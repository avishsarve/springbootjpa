package com.spring.springbootjpa.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springbootjpa.entity.Account;



public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Page<Account> findAll(Pageable pageable);
	List<Account> findByIsActiveTrue();
	List<Account> findByNameStartingWith(String name);
	List<Account> findByStateOrderByBranchName(String state);
	List<Account> findByAccountIdGreaterThan(long accountId);
	List<Account> findByAccountNoBetween(long start, long end);

}
