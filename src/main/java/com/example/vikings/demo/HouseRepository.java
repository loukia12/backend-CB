package com.example.vikings.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

	List<House> findById(int id);
	List<House> findByPrice(int price);
	List<House> findBySize(int size);
	
}
