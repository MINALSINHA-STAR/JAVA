package com.search.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.product.entity.SearchEntity;

@Repository
public interface SearchRepo extends JpaRepository<SearchEntity, Integer> {

	public List<SearchEntity> findByNameContainingIgnoreCase(String name);

}
