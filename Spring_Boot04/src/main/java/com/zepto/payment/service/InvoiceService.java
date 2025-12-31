package com.zepto.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.zepto.payment.entity.InvoiceEntity;
import com.zepto.payment.repository.InvoiceRepository;
import com.zepto.payment.request.InvoiceRequest;

import jakarta.persistence.Entity;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public int createInvoice(InvoiceRequest invoiceRequest) {

		InvoiceEntity invoiceEntity = new InvoiceEntity();

		double price = invoiceRequest.getPrice();
		float tax = invoiceRequest.getTax();
		int quant = invoiceRequest.getQuantity();

		double totalPrice = quant * price * (1 + tax / 100);

		invoiceEntity.setItemName(invoiceRequest.getItemName());
		invoiceEntity.setQuantity(quant);
		invoiceEntity.setPrice(price);
		invoiceEntity.setTax(tax);
		invoiceEntity.setTotalPrice(totalPrice);

		invoiceEntity = invoiceRepository.save(invoiceEntity);
		return invoiceEntity.getInvoiceId();

	}
	public Optional<InvoiceEntity> findInvoiceById(int id) {
		Optional<InvoiceEntity> list = invoiceRepository.findById(id);
		return list;
	}
	
	public List<InvoiceEntity> findInvoiceByName(@PathVariable String itemName){
	List<InvoiceEntity> list = invoiceRepository.findInvoiceByitemName(itemName);
	return list;
	}

}
