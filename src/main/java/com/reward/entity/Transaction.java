package com.reward.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

/**
 * Entity class representing customer transaction details.
 * 
 * This entity stores purchase transaction information
 * used for reward point calculation.
 * 
 * Mapped Database Table:
 * customer_transaction
 * 
 * Each transaction contains:
 * 
 * Transaction id
 * Customer id
 * Transaction amount
 * Transaction date
 * 
 * 
 * 
 */
@Entity
@Table(name = "customer_transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long txnId;

	@NotBlank(message ="Customer ID cannot be blank")
	private String custId;

	@Positive(message ="Amount must be greater than 0")
	private Double amount;

	@NotNull(message ="Transaction date cannot be null")
	@PastOrPresent(message ="transaction date cannot be in the future")
	private LocalDate date;

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", custId=" + custId + ", amount=" + amount + ", date=" + date + "]";
	}

}
