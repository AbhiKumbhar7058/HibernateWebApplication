package com.exception;

public class BookDao extends RuntimeException{
	public BookDao() {
		
	}
	
	public BookDao(String message) {
		super(message);
	
	}
}
