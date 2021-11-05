package com.app.bill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bill.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> { 
	
	Optional<Bill> findByBillDate(String date);

}
