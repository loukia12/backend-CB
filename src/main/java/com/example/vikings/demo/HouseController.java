package com.example.vikings.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class HouseController {

	@Autowired
	HouseRepository houseRepository;
	
	
    @GetMapping("/house")
    public List<House> index(){
    	return houseRepository.findAll();        
    }
    
    @CrossOrigin("http://localhost:3000/results")
    @GetMapping("/house/results")
    public List<House> showNewResults(@RequestParam(value = "toPrice", defaultValue = "100000") String toPrice,
    		@RequestParam(value = "fromSize", defaultValue = "0") String fromSize, @RequestParam(value = "location", defaultValue = "") String location, 
    		@RequestParam(value = "status", defaultValue = "Rent") String status){
    	
    	int p = Integer.parseInt(toPrice);
    	int s = Integer.parseInt(fromSize);
    	
    	System.out.println(status);
    	System.out.println(location);
    	System.out.println(toPrice);
    	System.out.println(fromSize);
    	
    	if(location.equals("")) {
    		System.out.println("empty location" + status);
    		return houseRepository.findByFilters(p, s, status);
    	}else {
    		System.out.println("location" + status);
    		return houseRepository.findByFilters2(p, s, location, status);
    	}
    }
      
    @CrossOrigin("http://localhost:3000/yourEntry")
    @GetMapping("/add")
    public String addHouse(@RequestParam(value = "price") String price, @RequestParam(value = "size") String size, 
    		@RequestParam(value = "location") String location, @RequestParam(value = "status") String status, @RequestParam(value = "contact") String contact, 
    		@RequestParam(value = "image") String image){
    	
    	int p = Integer.parseInt(price);
    	int s = Integer.parseInt(size);
    	
    	House h= new House(p, s, status, contact, location, image);
    	houseRepository.save(h);
    	
    	System.out.print("Added");
    	return ("New house added");
    }
}
