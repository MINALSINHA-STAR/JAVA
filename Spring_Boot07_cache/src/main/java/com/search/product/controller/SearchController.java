package com.search.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.search.product.SpringBoot07CacheApplication;
import com.search.product.entity.SearchEntity;
import com.search.product.repository.SearchRepo;
import com.search.product.request.SearchRequest;
import com.search.product.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SpringBoot07CacheApplication springBoot07CacheApplication;
	@Autowired
	private SearchService service;
	
	SearchController(SpringBoot07CacheApplication springBoot07CacheApplication){
		this.springBoot07CacheApplication = springBoot07CacheApplication; 
	}

	@GetMapping("/product")
	public List<SearchEntity> productSearch(@RequestParam String name) {
		System.out.println("product search: "+name);
		
		System.out.println("SearchController.search.........sending start time to APM to action name ");
		
		return service.doProductSearch(name);
		
	}
}
