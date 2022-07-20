package com.cg.controller.rest;


import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.TransferDTO;
import com.cg.service.CustomerService;
import com.cg.service.DepositService;
import com.cg.service.TransferService;
import com.cg.service.WithdrawService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private TransferService transferService;

    @GetMapping("")
    public ResponseEntity<?> showListCustomer() {
        List<CustomerDTO> customerDTOs = customerService.findAllCustomerDTO();

        if (customerDTOs.isEmpty()) {
            return new ResponseEntity<>("Danh sách trống!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Optional<CustomerDTO> customerDTO = customerService.findCustomerDTOBy(id);

        if (!customerDTO.isPresent()) {
            return new ResponseEntity<>("Không tìm thấy customer có id là:" + id + "!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerDTO.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody Customer customer) {

        customer.setId(0L);
        customer.setBalance(BigDecimal.ZERO);

        Map<String, String> errors = new HashMap<>();

        Boolean existEmail = customerService.existsByEmail(customer.getEmail());

        Boolean existPhone = customerService.existsByPhone(customer.getPhone());

        if (existEmail) {
            errors.put("email", "Trùng email!");
        }

        if (existPhone) {
            errors.put("phone", "Trùng số điện thoại!");
        }

        if (errors.isEmpty()) {
            try {
                customer = customerService.save(customer);
                return new ResponseEntity<>(customer.toCustomerDTO(), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> doEdit(@PathVariable Long id, @RequestBody CustomerDTO customerDTO,
                                    BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        Optional<Customer> c = customerService.findById(id);

        if (!c.isPresent()) {
            return new ResponseEntity<>("Không tồn tại customer", HttpStatus.NOT_FOUND);
        }

        Boolean existEmail = customerService.existsByEmailAndIdIsNot(customerDTO.getEmail(), id);

        Boolean existPhone = customerService.existsByPhoneAndIdIsNot(customerDTO.getPhone(), id);

        if (existEmail) {
            errors.put("email", "Trùng email!");
        }

        if (existPhone) {
            errors.put("phone", "Trùng số điện thoại!");
        }

        if (errors.isEmpty()) {
            try {
                Customer customer = customerDTO.toCustomer();

                customer.setId(c.get().getId());
                customer.setBalance(c.get().getBalance());

                customerDTO = customer.toCustomerDTO();

                customerService.save(customer);

                return new ResponseEntity<>(customerDTO, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @PostMapping("/deposit/{id}")
    public ResponseEntity<?> doDeposit(@PathVariable Long id,
                                       @Validated @RequestBody Deposit deposit, BindingResult bindingResult) {

        Optional<CustomerDTO> customerDTO = Optional.empty();

        if (bindingResult.hasErrors()) {
            return AppUtils.errors(bindingResult);
        }

        try {
            customerDTO = customerService.findCustomerDTOBy(id);

            if (!customerDTO.isPresent()) {
                return new ResponseEntity<>("Không tồn tại tài khoản có id là:" + id, HttpStatus.NOT_FOUND);
            }

            deposit.setCustomer(customerService.findById(id).get());
            depositService.save(deposit);

            customerDTO.get().setBalance(customerDTO.get().getBalance().add(deposit.getTransactionAmount()));

            Customer customer = customerDTO.get().toCustomer();
            customer.setId(customerDTO.get().getId());
            customer.setBalance(customerDTO.get().getBalance());

            customerService.save(customer);

            return new ResponseEntity<>(customerDTO.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Server không  xử lý được vui lòng liên hệ anh Hân (Anonymous)", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity<?> doWithdraw(@PathVariable Long id, @Validated @RequestBody Withdraw withdraw,
                                        BindingResult bindingResult) {
//        Map<String, String> errors = new HashMap<>();
        Optional<CustomerDTO> customerDTO = Optional.empty();

        if(bindingResult.hasErrors()){
            return AppUtils.errors(bindingResult);
        }

        try {
            customerDTO = customerService.findCustomerDTOBy(id);

            if (!customerDTO.isPresent()) {
                return new ResponseEntity<>("Không tồn tại tài khoản có id là:" + id, HttpStatus.NOT_FOUND);
            }

            withdraw.setCustomer(customerService.findById(id).get());
            withdrawService.save(withdraw);

            customerDTO.get().setBalance(customerDTO.get().getBalance().subtract(withdraw.getTransactionAmount()));

            Customer customer = customerDTO.get().toCustomer();
            customer.setId(customerDTO.get().getId());
            customer.setBalance(customerDTO.get().getBalance());

            customerService.save(customer);
            return new ResponseEntity<>(customerDTO.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Server không  xử lý được vui lòng liên hệ anh Hân (Anonymous)", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/transfers/{id}")
    public ResponseEntity<?> doTransfer(@PathVariable Long id,@RequestBody TransferDTO transferDTO,
                                         BindingResult bindingResult){
        Map<String, Customer> customerMap = new HashMap<>();

        String transferAmount = transferDTO.getTransferAmount();
        String repId = transferDTO.getRecipientId();

        Optional <CustomerDTO> senderDTO = Optional.empty();

        if(!ValidDateUtils.isNumberValid(transferAmount)){
            bindingResult.addError(new FieldError("transferAmount","transferAmount", "Vui lòng nhập đúng số tiền chuyển khoản!"));
        }else {
            if(transferAmount.length() < 6 || transferAmount.equals("100000")){
                if(Long.parseLong(transferAmount) < 50){
                    bindingResult.addError(new FieldError("transferAmount","transferAmount","Số tiền giao dịch tối thiểu là 50$!"));
                }
            }else {
                bindingResult.addError(new FieldError("transferAmount","transferAmount","Số tiền giao dịch tối thiểu là 100.000$!"));
            }
        }

        if(!ValidDateUtils.isNumberValid(repId)){
            bindingResult.addError(new FieldError("recipientId","recipientId","Tên người nhận không hợp lệ!"));
        }else {
            Optional<Customer> customer = customerService.findById(Long.parseLong(repId));

            if(!customer.isPresent()){
                bindingResult.addError(new FieldError("recipientId", "recipientId","Tên người nhận không tồn tại!"));
            }else if( id == Long.parseLong(repId)) {
                bindingResult.addError(new FieldError("recipientId","recipientId","Người nhận không thể là chính mình!"));
            }
        }



        BigDecimal transactionAmount = new BigDecimal(Long.parseLong(transferAmount) * 1.1);

        senderDTO = customerService.findCustomerDTOBy(id);

        if(senderDTO.get().getBalance().compareTo(transactionAmount) < 0) {
            bindingResult.addError(new FieldError("transferAmount","transferAmount","Số tiền chuyển khoản vượt quá số dư của bạn!"));
        }

        System.out.println(bindingResult);

        if(bindingResult.hasErrors()){
            return AppUtils.errors(bindingResult);
        }

        try {
            Optional <CustomerDTO> repDTO = customerService.findCustomerDTOBy(Long.parseLong(repId));
//            Update sender

            if(!senderDTO.isPresent()){
                return new ResponseEntity<>("Không tồn tại tài khoản có id là:" + id, HttpStatus.NOT_FOUND);
            }

            senderDTO.get().setBalance(senderDTO.get().getBalance().subtract(transactionAmount));

            Customer sender = senderDTO.get().toCustomer();
            sender.setId(senderDTO.get().getId());
            sender.setBalance(senderDTO.get().getBalance());

            customerService.save(sender);
            customerMap.put("sender",sender);

//            Update Rep

            if(!repDTO.isPresent()){
                return new ResponseEntity<>("Không tồn tại tài khoản có id là:" + id, HttpStatus.NOT_FOUND);
            }

            repDTO.get().setBalance(repDTO.get().getBalance().add(new BigDecimal(transferAmount)));

            Customer rep = repDTO.get().toCustomer();
            rep.setId(repDTO.get().getId());
            rep.setBalance(repDTO.get().getBalance());

            customerService.save(rep);
            customerMap.put("rep",rep);

            BigDecimal feesAmount = new BigDecimal(Long.parseLong(transferAmount) * 0.1);

//            Post Transfer
            Transfer transfer = transferDTO.toTransfer(transferDTO, sender, rep);
            transfer.setFees(TransferDTO.fees);
            transfer.setFeesAmount(feesAmount);
            transfer.setTransactionAmount(transactionAmount);
            transferService.save(transfer);

            return new ResponseEntity<>(customerMap,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("Server không xử lí được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
