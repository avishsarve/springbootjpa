package com.spring.springbootjpa.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.springbootjpa.Exception.NoSuchAccountException;
import com.spring.springbootjpa.Exception.StateNotFoundException;
import com.spring.springbootjpa.Repository.AccountRepository;
import com.spring.springbootjpa.entity.Account;


@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}
	public Map<String, Object> getAllAccounts(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("email").descending());
		Page<Account> accounts = repository.findAll(pageable);
		List<Account> accountList = accounts.getContent();
		Map<String, Object> response = new HashMap<>();
	      response.put("Accounts", accountList);
	      response.put("currentPage", accounts.getNumber());
	      response.put("totalItems", accounts.getTotalElements());
	      response.put("totalPages", accounts.getTotalPages());
	      return response;
	}
	public List<Account> getActiveAccounts() {
		List<Account> accounts = repository.findByIsActiveTrue();
		if(accounts.isEmpty())
			throw new NoSuchAccountException("No Active account found");
		return accounts;
		 
	}
	public List<Account> getAccountsByName(String name) {
		List<Account> accounts = repository.findByNameStartingWith(name);
		if(accounts.isEmpty())
			throw new NoSuchAccountException("No Account with this name found");
		return accounts;
	}
	public List<Account> getAccountsByStateOrderByBranch(String state) {
		List<Account> accounts = repository.findByStateOrderByBranchName(state);
		if(accounts.isEmpty())
			throw new StateNotFoundException("No Account with this state found");
		return accounts;
	}
	public List<Account> getAccountsGreaterThanGivenId(long accountId){
		return repository.findByAccountIdGreaterThan(accountId);
	}
	public List<Account> getAccountsBetween(long start, long end){
		return repository.findByAccountNoBetween(start, end);
	}

	

}
