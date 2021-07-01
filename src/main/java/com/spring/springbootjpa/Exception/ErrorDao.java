package com.spring.springbootjpa.Exception;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDao {
	
	private int errorCode;
	private String errorMessage;
}