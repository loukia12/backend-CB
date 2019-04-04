package com.example.vikings.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

	@Autowired
	HouseRepository houseRepository;
	
    @GetMapping("/house")
    public List<House> index(){
    	System.out.println("YES");
//    	return houseRepository.findAll();
        return houseRepository.findByPrice(300);
    }
	
    
    @GetMapping("/house/{id}")
    public House show(@PathVariable String id){
        int houseId = Integer.parseInt(id);
        return houseRepository.getOne(houseId);
    }
}
