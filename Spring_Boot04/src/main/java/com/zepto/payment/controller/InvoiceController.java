package com.zepto.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.payment.entity.InvoiceEntity;
import com.zepto.payment.request.InvoiceRequest;
import com.zepto.payment.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping("invoice")
	public int invoicePrint(@RequestBody InvoiceRequest invoiceRequest) {
		int invId = invoiceService.createInvoice(invoiceRequest);
		return invId;
	}

	@GetMapping("/invoiceid/{invoice_id}")
	public Optional<InvoiceEntity> findInvoiceById(@PathVariable int invoice_id) {
		return invoiceService.findInvoiceById(invoice_id);
	}

	@GetMapping("/invoicename/{itemName}")
	public List<InvoiceEntity> findByName(@PathVariable String itemName) {
		List<InvoiceEntity> list =
				invoiceService.findInvoiceByName(itemName);
		return list;
		
	}

}
