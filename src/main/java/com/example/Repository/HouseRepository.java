package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.House;

@Repository
public interface HouseRepository extends JpaRepository<House,Long>{
	
	House findBySize(int size);
	House findByPrice(int price);

}
