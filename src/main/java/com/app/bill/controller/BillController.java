package com.app.bill.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bill.model.Bill;
import com.app.bill.repository.BillRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BillController {

	@Autowired
	BillRepository billsRepo;

	@GetMapping("/bills")
	public ResponseEntity<List<Bill>> getAllBills() {
		try {
			List<Bill> bills = new ArrayList<Bill>();

			billsRepo.findAll().forEach(bills::add);

			if (bills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/bills/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") long id) {
		Optional<Bill> billData = billsRepo.findById(id);

		if (billData.isPresent()) {
			return new ResponseEntity<>(billData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/bills/due/{date}")
	public ResponseEntity<Bill> getBillById(@PathVariable("date") String date) {
		Optional<Bill> billData = billsRepo.findByBillDate(date);

		if (billData.isPresent()) {
			return new ResponseEntity<>(billData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
