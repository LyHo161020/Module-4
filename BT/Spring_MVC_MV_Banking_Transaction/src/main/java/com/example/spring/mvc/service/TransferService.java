//package com.example.spring.mvc.service;
//
//import com.example.spring.mvc.model.Transfer;
//import com.example.spring.mvc.repository.ITransferRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class TransferService implements ITransferService{
//
//   //@Autowired
//    private ITransferRepository transferRepository;
//
//    @Override
//    public List<Transfer> findAll() {
//        return transferRepository.findAll();
//    }
//
//    @Override
//    public Transfer findTransferBy(Long id) {
//        return transferRepository.findTransferBy(id);
//    }
//
//    @Override
//    public Transfer save(Transfer transfer) {
//        return transferRepository.save(transfer);
//    }
//
//    @Override
//    public void deleteTransferBy(Long id) {
//        transferRepository.deleteTransferBy(id);
//    }
//}
