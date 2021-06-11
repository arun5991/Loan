package com.example.spring.webflux.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.webflux.model.LoanDetails;
import com.example.spring.webflux.model.ResponseMessage;
import com.example.spring.webflux.service.LoanService;
import com.example.spring.webflux.service.LoanServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/applyLoan")
public class Controller {
	
	@Autowired
	LoanService loanService;

	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}
	
	@PostMapping
	public Mono<ResponseEntity<ResponseMessage>> ApplyLoan(@RequestBody LoanDetails loanDetails)
			throws URISyntaxException {
		Mono<LoanDetails> emp = loanService.applyLoan(loanDetails);

		StringBuilder locationStr = new StringBuilder();
		emp.subscribe(e -> locationStr.append("http://localhost:9010/applyLoan"));

		// Getting current resource path
		URI location = new URI(locationStr.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse(loanDetails.getCustomerId(), "Loan Applied")));
	}
	
	@GetMapping("/{id}")
	public Mono<LoanDetails> getCustomerLoanDetails(@PathVariable Integer id) {
		System.out.println("Postman hit the get api");
		return loanService.getCustomerLoanDetails(id);
	}

}
