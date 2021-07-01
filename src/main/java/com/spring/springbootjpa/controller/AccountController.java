package com.spring.springbootjpa.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootjpa.entity.Account;
import com.spring.springbootjpa.service.AccountService;


@RestController
@RequestMapping("jpa-exception-handling")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/")
	public List<Account> getAllAccounts(){
		return service.getAllAccounts();
	}
	@GetMapping("/page/{pageNo}/{pageSize}")
	public ResponseEntity<Map<String, Object>> getAllAccounts(@PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize) {
		return new ResponseEntity<>(service.getAllAccounts(pageNo,pageSize), HttpStatus.OK);
	}
	@GetMapping("/active")
	public List<Account> getActiveAccounts(){
		return service.getActiveAccounts();
	}
	@GetMapping("/name/{name}")
	public List<Account> getAccountsByName(@PathVariable("name") String name){
		return service.getAccountsByName(name);
	}
	@GetMapping("/state/{state}")
	public List<Account> getAccountsByStateOrderByBranch(@PathVariable("state") String state){
		return service.getAccountsByStateOrderByBranch(state);
	}
	@GetMapping("/id/{id}")
	public List<Account> getAccountsGreaterThanGivenId(@PathVariable("id") long accountId){
		return service.getAccountsGreaterThanGivenId(accountId);
	}
	@GetMapping("/{start}/{end}")
	public List<Account> getAccountsBetween(@PathVariable("start") long start,
			@PathVariable("end") long end){
		return service.getAccountsBetween(start, end);
	}
	

}



