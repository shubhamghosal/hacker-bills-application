package com.app.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id")
	private Long billId;

	@Column(name = "bill_to")
	private String billTo;
	
	@Column(name = "bill_date")
	private String billDate;
	
	@Column(name = "bill_price")
	private Long billPrice;
	
	@Column(name = "bill_tax")
	private Long billTax;
	
	@Column(name = "bill_total")
	private Long billTotal;

	public Bill() {
		
	}


	public Bill(Long billId, String billTo, String billDate, Long billPrice, Long billTax, Long billTotal) {
		super();
		this.billId = billId;
		this.billTo = billTo;
		this.billDate = billDate;
		this.billPrice = billPrice;
		this.billTax = billTax;
		this.billTotal = billTotal;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Long getBillPrice() {
		return billPrice;
	}

	public void setBillPrice(Long billPrice) {
		this.billPrice = billPrice;
	}

	public Long getBillTax() {
		return billTax;
	}

	public void setBillTax(Long billTax) {
		this.billTax = billTax;
	}

	public Long getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(Long billTotal) {
		this.billTotal = billTotal;
	}
	
}
