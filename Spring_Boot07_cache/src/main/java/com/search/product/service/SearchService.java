package com.search.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.search.product.entity.SearchEntity;
import com.search.product.repository.SearchRepo;

@Service
public class SearchService {
	
	@Autowired
	private SearchRepo searchRepo;
	
	@Cacheable(value = "products-new", key = "#name", unless = "#result == null")
	public List<SearchEntity> doProductSearch(String name) {
		
		System.out.println("fetching from DB.......");
		return searchRepo.findByNameContainingIgnoreCase(name);
	}
}
