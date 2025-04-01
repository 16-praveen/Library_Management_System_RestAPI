package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.BorrowRecord;
import com.example.demo.repository.BorrowRecordRepository;

@Service
public class BorrowRecordService {
    final BorrowRecordRepository borrowRecordRepository;
    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository){
        this.borrowRecordRepository=borrowRecordRepository;
    }
    public BorrowRecord createBorrow(BorrowRecord borrowRecord){
        return borrowRecordRepository.save(borrowRecord);
    }
    public List<BorrowRecord> getAllBorrowRecord() {
        return borrowRecordRepository.findAllBorrowRecord(); 
    }
    
    public BorrowRecord getBorrowRecord(int id) {
        return borrowRecordRepository.findBorrowRecordById(id);
    }
    // public List<BorrowRecord> getAllBorrowRecord()
    // {
    //     return borrowRecordRepository.findAll();
    // }
    // public BorrowRecord getBorrowRecord(int id)
    // {
    //     return
    //     borrowRecordRepository.findById(id).orElseThrow(()-> new RuntimeException("author not found"+id));
    // }
    public Page<BorrowRecord> getAllPage(Pageable pg)
    {
        return borrowRecordRepository.findAll(pg);
    }
    public BorrowRecord updateBorrowRecord(int id,Date borrowDate,Date returnDate,String member,String book)
    {
    BorrowRecord borrowRecord=borrowRecordRepository.findById(id).orElseThrow(()->new RuntimeException("author not found"+id));
    if (book!=null) {
        borrowRecord.setBooks(book);
    }
    if (member!=null) {
        borrowRecord.setMember(member);
    }
    if (borrowDate!=null)
    {
        borrowRecord.setBorrowDate(borrowDate);
    }
    if (returnDate!=null){
        borrowRecord.setReturnDate(returnDate);
    }
    return borrowRecordRepository.save(borrowRecord);
    }
    public void deleteBorrowRecord(int id)
{
    if(!borrowRecordRepository.existsById(id))
    {
        throw new RuntimeException("user not found"+id);
    }
    borrowRecordRepository.deleteById(id);
}



}
