package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Fine;
import com.example.demo.service.FineService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/fine")
public class FineController {
    public FineService fineService;
    
    public FineController(FineService fineService){
        this.fineService=fineService;
    }
    @PostMapping
    public  ResponseEntity<Object> createFine(@RequestBody Fine fine) {

        Fine fine2 = fineService.createFine(fine);
        return ResponseEntity.ok(fine2);
    }    
    @GetMapping
    public ResponseEntity<List<Fine>> getAllFine()
    {
        return ResponseEntity.ok(fineService.getAllFine());
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getFine(@PathVariable("id") int id) {
    Fine fine = fineService.getFine(id);
    if (fine == null) {
        return ResponseEntity.status(404).body("Fine not found with ID: " + id);
    }
    return ResponseEntity.ok(fine);
   }
    // @GetMapping("{id}")
    //  public ResponseEntity<Object>getfine(@PathVariable("id") int id)
    // {
    //     Fine fine= fineService.getFine(id);
    //     return ResponseEntity.status(200).body(fine);
    // }
    @GetMapping("paginate")
     public Page<Fine>getAllPage(Pageable pg)
    {
        return fineService.getAllPage(pg);
    }
    @PutMapping("{id}")
    public ResponseEntity<Object>updateFine (@PathVariable("id") int id,@RequestBody Fine fine)
    {
        fineService.updateFine(id,fine.getAmount(),fine.getReason());
        return ResponseEntity.ok("Updates Success");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteFine(@PathVariable("id") int id)
    {
        fineService.deleteFine(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }
    
    
    
}

