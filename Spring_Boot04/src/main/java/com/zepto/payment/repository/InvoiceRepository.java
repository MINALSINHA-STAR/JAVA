package com.zepto.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zepto.payment.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer>{
	//select * from invoice where item_name =?
	List<InvoiceEntity> findInvoiceByitemName(String itemName);
}
