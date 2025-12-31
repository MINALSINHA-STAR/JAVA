package com.sbi.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.banking.request.TransferRequest;
import com.sbi.banking.service.TransferService;

@RestController
public class TransferController {
	@Autowired
	private TransferService service;

	@PostMapping("transfermoney")
	public String fundTransfer(@RequestBody TransferRequest tr) {
		String output = service.transferAmount(tr);

		return output;
	}
	
	@GetMapping("test")
	public void testtransfer() {
		service.test();
	}
}
