package com.example.spring.mvc.controller;

import com.example.spring.mvc.dto.DepositDTO;
import com.example.spring.mvc.dto.TransferDTO;
import com.example.spring.mvc.dto.WithdrawDTO;
import com.example.spring.mvc.model.Customer;
import com.example.spring.mvc.service.ICustomerService;
import com.example.spring.mvc.service.IDepositsService;
import com.example.spring.mvc.utils.ValidDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IDepositsService depositsService;


    @GetMapping("")
    public ModelAndView showListCustomer() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView;
        List<Customer> customers = customerService.findAll();
        List<String> errors = new ArrayList<>();
        for (Customer c : customers){
            if(customer.getPhone().equals(c.getPhone())){
                errors.add("Số điện thoại này đã đăng ký tài khoản rồi!");
                break;
            }
        }

        if(bindingResult.hasErrors() || errors.size() > 0){
            modelAndView = new ModelAndView("/create");
            modelAndView.addObject("hasError",true);
            modelAndView.addObject("errors",errors);
            return modelAndView;
        }


        modelAndView = new ModelAndView("/list");
        customerService.save(customer);

        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        ModelAndView modelAndView;
        List<String> errors = new ArrayList<>();
        Optional<Customer> customer = Optional.empty();
        if(!ValidDateUtils.isNumberValid(id)){
            errors.add("Id không hợp lê!");
        }else {
            customer = customerService.findCustomerBy(Integer.parseInt(id));
            if(!customer.isPresent()){
                errors.add("Không tồn tại khách hàng có id là: " + id);
            }
        }

        if(errors.size() > 0) {
            modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("hasError",true);
//            modelAndView.addObject("customer", null);
            return modelAndView ;
        }

        modelAndView = new ModelAndView("/edit");
//        customer.ifPresent(value -> );
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable String id, @Validated @ModelAttribute("customer") Customer cus, BindingResult bindingResult){
        ModelAndView modelAndView;


        if(bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("hasError",true);
            return modelAndView;
        }

        modelAndView = new ModelAndView("/list");
        customerService.save(cus);

        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/deposit/{id}")
    public ModelAndView showFormDeposit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/deposit");
        List<String> errors = new ArrayList<>();
        Optional<Customer> customer = Optional.empty();
        DepositDTO depositDTO = new DepositDTO();

        if(!ValidDateUtils.isNumberValid(id)){
            errors.add("Id không hợp lệ!");
        }else {
            customer = customerService.findCustomerBy(Integer.parseInt(id));

            if(!customer.isPresent()){
                errors.add("Không tồn tại tài khoản có id là: " + id);
            }
        }


        if(errors.size() > 0){
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("hasError",true);
            modelAndView.addObject("depositDTO",depositDTO);
            return modelAndView ;
        }

        depositDTO.setId(customer.get().getId());
        depositDTO.setFullName(customer.get().getFullName());
        depositDTO.setBalance(customer.get().getBalance());
        modelAndView.addObject("depositDTO",depositDTO);
        return  modelAndView;
    }

    @PostMapping("/deposit/{id}")
    public ModelAndView deposit(@Validated @PathVariable String id, @RequestParam("transactionAmount") String transactionAmount,
                                @ModelAttribute DepositDTO depositDTO, BindingResult bindingResult){
        ModelAndView modelAndView;

        Customer customer = customerService.findCustomerBy(Integer.parseInt(id)).get();
        List<String> errors = new ArrayList<>();

        if(!ValidDateUtils.isNumberValid(transactionAmount)){
            errors.add("Số tiền chuyển không hợp lệ!");
        }else if(transactionAmount.equals("")) {
            errors.add("Số tiền chuyển không được để trống!");
        }else if(Integer.parseInt(transactionAmount) < 50){
            errors.add("Số tiền chuyển tối thiếu là 50đ!");
        }else if(Long.parseLong(transactionAmount) > 1000000000){
            errors.add("Số tiền chuyển tối đa là 1.000.000.000đ!");
        }



        if(errors.size() > 0 || bindingResult.hasErrors()){
            depositDTO.setId(customer.getId());
            depositDTO.setFullName(customer.getFullName());
            depositDTO.setBalance(customer.getBalance());
            modelAndView = new ModelAndView("/deposit");
            modelAndView.addObject("hasError",true);
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("depositDTO",depositDTO);
            return modelAndView;
        }


        modelAndView = new ModelAndView("/list");
        customer.setBalance(customer.getBalance() + depositDTO.getTransactionAmount());
        customerService.save(customer);
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/withdraw/{id}")
    public ModelAndView showFormWithdraw(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/withdraw");
        List<String> errors = new ArrayList<>();
        Optional<Customer> customer = Optional.empty();
        WithdrawDTO withdrawDTO = new WithdrawDTO();

        if(!ValidDateUtils.isNumberValid(id)){
            errors.add("Id không hợp lệ!");
        }else {
            customer = customerService.findCustomerBy(Integer.parseInt(id));

            if(!customer.isPresent()){
                errors.add("Không tồn tại tài khoản có id là: " + id);
            }
        }


        if(errors.size() > 0){
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("hasError",true);
            modelAndView.addObject("withdrawDTO",withdrawDTO);
            return modelAndView ;
        }

        withdrawDTO.setId(customer.get().getId());
        withdrawDTO.setFullName(customer.get().getFullName());
        withdrawDTO.setBalance(customer.get().getBalance());
        modelAndView.addObject("withdrawDTO",withdrawDTO);
        return  modelAndView;
    }

    @PostMapping("/withdraw/{id}")
    public ModelAndView withdraw(@Validated @PathVariable String id, @RequestParam("transactionAmount") String transactionAmount,
                                 @ModelAttribute WithdrawDTO withdrawDTO, BindingResult bindingResult){
        ModelAndView modelAndView;

        Customer customer = customerService.findCustomerBy(Integer.parseInt(id)).get();
        List<String> errors = new ArrayList<>();

        if(!ValidDateUtils.isNumberValid(transactionAmount)){
            errors.add("Số tiền chuyển không hợp lệ!");
        }else if(transactionAmount.equals("")) {
            errors.add("Số tiền chuyển không được để trống!");
        }else if(Integer.parseInt(transactionAmount) < 50){
            errors.add("Số tiền chuyển tối thiếu là 50đ!");
        }else if(Long.parseLong(transactionAmount) > 1000000000){
            errors.add("Số tiền chuyển tối đa là 1.000.000.000đ!");
        }



        if(errors.size() > 0 || bindingResult.hasErrors()){
            withdrawDTO.setId(customer.getId());
            withdrawDTO.setFullName(customer.getFullName());
            withdrawDTO.setBalance(customer.getBalance());
            modelAndView = new ModelAndView("/deposit");
            modelAndView.addObject("hasError",true);
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("depositDTO",withdrawDTO);
            return modelAndView;
        }


        modelAndView = new ModelAndView("/list");
        customer.setBalance(customer.getBalance() - Long.parseLong(withdrawDTO.getTransactionAmount()));
        customerService.save(customer);
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }


    @GetMapping("/transfer/{id}")
    public ModelAndView showFormTransfer(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/transfer");
        List<String> errors = new ArrayList<>();
        Optional<Customer> customer = Optional.empty();
        List<Customer> customers = customerService.findAll();
        TransferDTO transferDTO = new TransferDTO();

        if(!ValidDateUtils.isNumberValid(id)){
            errors.add("Id không hợp lệ!");
        }else {
            customer = customerService.findCustomerBy(Integer.parseInt(id));

            if(!customer.isPresent()){
                errors.add("Không tồn tại tài khoản có id là:" + id);
            }
        }

        if(errors.size() > 0){
            modelAndView.addObject("hasError", true);
            modelAndView.addObject("errors",errors);
            modelAndView.addObject("customers",customers);
            modelAndView.addObject("transferDTO", transferDTO);

            return modelAndView;
        }

        transferDTO.setSenderId(String.valueOf(customer.get().getId()));
        transferDTO.setSenderName(customer.get().getFullName());
        transferDTO.setEmail(customer.get().getEmail());
        transferDTO.setSenderBalance(String.valueOf(customer.get().getBalance()));
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("transferDTO", transferDTO);

        return modelAndView;

    }

    @PostMapping("/transfer/{id}")
    public ModelAndView transfer(@Validated @PathVariable String id, @ModelAttribute TransferDTO transferDTO,
                                 BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> errors = new ArrayList<>();
        String transactionAmount = transferDTO.getTransactionAmount();
        String repId = transferDTO.getRepId();
        Optional<Customer> sender = Optional.empty();
        Optional<Customer> rep = Optional.empty();
        List<Customer> customers = null;

        if(!ValidDateUtils.isNumberValid(transactionAmount)){
            errors.add("Số tiền chuyển không hợp lệ!");
        }else if(transactionAmount.equals("")) {
            errors.add("Số tiền chuyển không được để trống!");
        }else if(Integer.parseInt(transactionAmount) < 50){
            errors.add("Số tiền chuyển tối thiếu là 50đ!");
        }else if(Long.parseLong(transactionAmount) > 1000000000){
            errors.add("Số tiền chuyển tối đa là 1.000.000.000đ!");
        }

        if(!ValidDateUtils.isNumberValid(id)){
            errors.add("Id người gửi không hợp lệ!");
        }else {
            sender = customerService.findCustomerBy(Integer.parseInt(id));
            if(!sender.isPresent()){
                errors.add("Không tồn tại tài khoản có id là:" + id);
            }
        }

        if(!ValidDateUtils.isNumberValid(repId)){
            errors.add("Id người nhận không hợp lệ!");
        }else {
            rep = customerService.findCustomerBy(Integer.parseInt(repId));
            if(!rep.isPresent()){
                errors.add("Tài khoản người nhân có id:" + id + " không hợp lệ!");
            }
        }

        if(bindingResult.hasErrors() || errors.size() > 0){
            modelAndView = new ModelAndView("/transfer");
            transferDTO.setSenderId(String.valueOf(sender.get().getId()));
            transferDTO.setSenderName(sender.get().getFullName());
            transferDTO.setEmail(sender.get().getEmail());
            transferDTO.setSenderBalance(String.valueOf(sender.get().getBalance()));

            modelAndView.addObject("hasError",true);
            modelAndView.addObject("errors",errors);
            customers = customerService.findAll();
            modelAndView.addObject("customers",customers);
            modelAndView.addObject("transferDTO",transferDTO);
            return modelAndView;
        }

        modelAndView = new ModelAndView("/list");
        sender.get().setBalance((sender.get().getBalance() - Math.round(Long.parseLong(transactionAmount) * 1.1)));
        customerService.save(sender.get());

        rep.get().setBalance(rep.get().getBalance() + Long.parseLong(transactionAmount));
        customerService.save(rep.get());
        customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

}
