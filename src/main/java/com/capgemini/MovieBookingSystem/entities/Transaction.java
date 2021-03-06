package com.capgemini.MovieBookingSystem.entities;

import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.capgemini.MovieBookingSystem.beans.CardDetails;
@DynamoDBTable(tableName = "Transaction")
public class Transaction {
	private String transactionId;
	private LocalDateTime transactionDate;
	private double amount;
	private Booking bookingReference;
	private CardDetails paymentDetails;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@DynamoDBAttribute
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	@DynamoDBAttribute
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	@DynamoDBAttribute
	public Booking getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(Booking bookingReference) {
		this.bookingReference = bookingReference;
	}
	@DynamoDBAttribute
	public CardDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(CardDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
}
