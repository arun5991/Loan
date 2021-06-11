package com.example.spring.webflux.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.webflux.model.LoanDetails;
import com.example.spring.webflux.model.ResponseMessage;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService{
	
	private Map<Integer, LoanDetails> loan = new HashMap<>();
	
	{
		loan.put(1, new LoanDetails(101, "Home Loan", 3000000 , "31/03/2021" ,8.5f,12));
		loan.put(2, new LoanDetails(256, "Car Loan", 900000 , "12/06/2019" ,9.2f,10));
		loan.put(3, new LoanDetails(98, "Personal Loan", 300000 , "16/02/2020" ,12.5f,5));
	}
	
	@Override
	public Mono<LoanDetails> applyLoan(LoanDetails loanDetails) {
		loan.put(loanDetails.getCustomerId(), loanDetails);
		return Mono.just(loanDetails);
	}

	@Override
	public Mono<LoanDetails> getCustomerLoanDetails(Integer Id) {
		System.out.println("Control reached here");
    return Mono.just(loan.get(Id));
	}

}
