package com.reward.exception;

public class InvalidTransactionException extends RuntimeException{
 
	public InvalidTransactionException(String msg) {
		super(msg);
	}
}
