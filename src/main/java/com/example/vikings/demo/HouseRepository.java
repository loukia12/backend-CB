package com.example.vikings.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

	@Query("SELECT h FROM House h WHERE ((h.price = ?1 or h.price < ?1) and (h.size = ?2 or h.size > ?2)) and (h.status = ?3) ORDER BY h.price ASC")
	List<House> findByFilters(Integer price, Integer size, String status);
	
	@Query("SELECT h FROM House h WHERE (h.price = ?1 or h.price < ?1) and (h.size = ?2 or h.size > ?2) and (h.location = ?3) and (h.status = ?4) ORDER BY h.price ASC")
	List<House> findByFilters2(Integer price, Integer size, String location, String status);
	
}
