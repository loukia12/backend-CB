package com.example.vikings.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class HouseController {


	@Autowired
	HouseRepository houseRepository;
	
//	@RequestMapping(value = "/test")
//	public String index2() {
//		return "index";
//	}
	
    @GetMapping("/house")
    public List<House> index(){
    	return houseRepository.findAll();        
    }
    
    //@CrossOrigin("http://localhost:3000/results")
    @GetMapping("/house/results")
    public List<House> showNewResults(@RequestParam(value = "toPrice", defaultValue = "1000") String toPrice,
    		@RequestParam(value = "fromSize", defaultValue = "0") String fromSize, @RequestParam(value = "location") String location, 
    		@RequestParam(value = "status", defaultValue = "Rent") String status){
    	
    	int p = Integer.parseInt(toPrice);
    	int s = Integer.parseInt(fromSize);
    	
    	if(location.equals("")) {
    		return houseRepository.findByFilters(p, s, status);
    	}else {
    		return houseRepository.findByFilters2(p, s, location, status);
    	}

    }
}
