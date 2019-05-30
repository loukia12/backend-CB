package com.example.vikings.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
//@CrossOrigin(maxAge = 3600)
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
    		@RequestParam(value = "status", defaultValue = "Buy") String status){
    	
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
    @PostMapping(path= "/add")
    @ResponseBody
    public  String addHouse(@RequestParam Map<String, String> body)
        {
    	String price=body.get("price");
    	
    	
    	String size=body.get("size");
    	
    	String contact = body.get("contact");
    	
    	
    	String location=body.get("location");
    	System.out.println(location);
    	
    	String status=body.get("status");
    	System.out.println(status);
	 
    	int p = Integer.parseInt(price);
    	System.out.println(p);
    	
    	int s = Integer.parseInt(size);
    	System.out.println(s);
    	
    	House h= new House(p,s,status,contact,location);
    	houseRepository.save(h);
    	
    	
    	System.out.print("Added");
    	return ("New house added");	
    }
}
