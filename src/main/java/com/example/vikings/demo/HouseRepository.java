package com.example.vikings.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

	@Query("SELECT h FROM House h WHERE h.price = ?1 or h.price < ?1")
    List<House> findByPrice(Integer price);
	
	@Query("SELECT h FROM House h WHERE h.size = ?1 or h.size < ?1")
	List<House> findBySizeLower(Integer size);
	
	@Query("SELECT h FROM House h WHERE h.size = ?1 or h.size > ?1")
	List<House> findBySizeHigher(Integer size);
	
	@Query("SELECT h FROM House h WHERE (h.price = ?1 or h.price < ?1) and (h.size = ?2 or h.size < ?2)")//up to size
	List<House> findByFilters(Integer price, Integer size);
}
