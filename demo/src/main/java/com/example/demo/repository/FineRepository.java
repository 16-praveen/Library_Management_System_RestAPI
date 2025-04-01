package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Fine;

@Repository
public interface FineRepository extends JpaRepository<Fine,Integer>{
    @Query("SELECT a FROM Fine a")
    List<Fine> findAllFine();

    @Query("SELECT a FROM Fine a WHERE a.id = :id")
    Fine findFineById(int id);
}
