package com.sbi.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbi.banking.entity.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Integer> {

	public TransferEntity findByAccountNo(String account);

}
