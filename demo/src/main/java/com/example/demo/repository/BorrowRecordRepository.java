package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BorrowRecord;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer>{

    @Query("SELECT a FROM BorrowRecord a")
    List<BorrowRecord> findAllBorrowRecord();

    @Query("SELECT a FROM BorrowRecord a WHERE a.id = :id")
    BorrowRecord findBorrowRecordById(int id);
}
