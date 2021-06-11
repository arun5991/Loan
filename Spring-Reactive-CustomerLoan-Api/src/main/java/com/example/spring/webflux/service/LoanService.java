package com.example.spring.webflux.service;

import org.springframework.stereotype.Component;

import com.example.spring.webflux.model.LoanDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface LoanService {
	public Mono<LoanDetails> applyLoan(LoanDetails loanDetails);
	public Mono<LoanDetails> getCustomerLoanDetails(Integer customerId);
}
