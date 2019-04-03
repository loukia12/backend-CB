package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Model.House;
import com.example.Repository.HouseRepository;

public class HouseController {
	
	@Autowired
	HouseRepository repository;
//	@PostMapping("api/house")
//	public House createResults(@RequestBody )
}
