package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fine;
import com.example.demo.repository.FineRepository;


@Service
public class FineService {
    final FineRepository fineRepository;
    public FineService(FineRepository fineRepository){
        this.fineRepository=fineRepository;
    }
    public Fine createFine(Fine fine){
        return fineRepository.save(fine);
    }
    public List<Fine> getAllFine() {
        return fineRepository.findAllFine(); 
    }
    
    public Fine getFine(int id) {
        return fineRepository.findFineById(id);
    }
    // public List<Fine> getAllFine()
    // {
    //     return fineRepository.findAll();
    // }
    // public Fine getFine(int id)
    // {
    //     return fineRepository.findById(id).orElseThrow(()-> new RuntimeException("fine not found"+id));
    // }
    public Page<Fine> getAllPage(Pageable pg)
    {
        return fineRepository.findAll(pg);
    }
    public Fine updateFine(int id,Float amount,String reason)
    {
     Fine fine=fineRepository.findById(id).orElseThrow(()->new RuntimeException("fine not found"+id));
     if (amount!=null) {
         fine.setAmount(amount);
     }
     if (reason!=null) {
         fine.setReason(reason);;
     }
     return fineRepository.save(fine);
    }
    public void deleteFine(int id)
   {
    if(!fineRepository.existsById(id))
    {
        throw new RuntimeException("fine not found"+id);
    }
    fineRepository.deleteById(id);
    }

}
    