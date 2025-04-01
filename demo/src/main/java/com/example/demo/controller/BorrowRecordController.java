package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BorrowRecord;
import com.example.demo.service.BorrowRecordService;

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
@RequestMapping("/borrow")
public class BorrowRecordController {
        public BorrowRecordService borrowRecordService;
        public BorrowRecordController(BorrowRecordService borrowRecordService){
            this.borrowRecordService=borrowRecordService;
        }

        @PostMapping
        public  ResponseEntity<Object> createBorrow(@RequestBody BorrowRecord borrowRecord) {

        BorrowRecord borrowRecord2 = borrowRecordService.createBorrow(borrowRecord);
        return ResponseEntity.ok(borrowRecord2);
        }
        @GetMapping
        public ResponseEntity<List<BorrowRecord>> getAllBorrowRecord()
        {
         return ResponseEntity.ok(borrowRecordService.getAllBorrowRecord());
        }
        @GetMapping("{id}")
        public ResponseEntity<Object> getBorrowrecord(@PathVariable("id") int id) {
        BorrowRecord borrowRecord = borrowRecordService.getBorrowRecord(id);
        if (borrowRecord == null) {
        return ResponseEntity.status(404).body("Book not found with ID: " + id);
        }
         return ResponseEntity.ok(borrowRecord);
         }
        // @GetMapping("{id}")
        // public ResponseEntity<Object>getborrowRecord(@PathVariable("id") int id)
        // {
        // BorrowRecord borrowRecord = borrowRecordService. getBorrowRecord(id);
        // return
        // ResponseEntity.status(200).body(borrowRecord);
        // }
        @GetMapping("paginate")
        public Page<BorrowRecord>getAllPage(Pageable pg)
        {
        return borrowRecordService.getAllPage(pg);
        }
        
        @PutMapping("{id}")
        public ResponseEntity<Object>updateBorrowRecord (@PathVariable("id") int id,@RequestBody BorrowRecord borrowRecord)
        {
        borrowRecordService.updateBorrowRecord(id,borrowRecord.getBorrowDate(),borrowRecord.getReturnDate(),borrowRecord.getMember(),borrowRecord.getBooks());
        return ResponseEntity.ok("Updates Success");
        }
        @DeleteMapping("{id}")
        public ResponseEntity<Object>deleteBorrowRecord(@PathVariable("id") int id)
        {
        borrowRecordService.deleteBorrowRecord(id);
        return ResponseEntity.ok("Deleted SuccessFully");
        }

        
        

       
        

        
        



}


