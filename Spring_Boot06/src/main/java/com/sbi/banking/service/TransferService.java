package com.sbi.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbi.banking.entity.TransferEntity;
import com.sbi.banking.repository.TransferRepository;
import com.sbi.banking.request.TransferRequest;

@Service
public class TransferService {

	@Autowired
	private TransferRepository repository;

	@Transactional
	public void test() {
		TransferEntity entity = repository.findByAccountNo("SBIN0009001");
		entity.setBalance(10000.00);

	}

//@Transactional
	//@Transactional(rollbackFor = Exception.class)
	public String transferAmount(TransferRequest request) {
		double amountToTransfer = request.getAmount();

		String fromAccNo = request.getFromAccount();
		TransferEntity entity = repository.findByAccountNo(fromAccNo);
		entity.setBalance(entity.getBalance() - amountToTransfer);

		repository.save(entity);
		/*try {
			int x = 10 / 0;
		} catch (Exception e) {
			throw e;
		}*/
		//throw new RuntimeException("runtime Exception");
		
		// entity.setPassword("AAAAAAAAA");

	String toAccNo = request.getToAccount();
		TransferEntity entity2 = repository.findByAccountNo(toAccNo);
		entity2.setBalance(entity2.getBalance() + amountToTransfer);
		repository.save(entity2);

		return "Amount has transfered successfully";

	}
}
