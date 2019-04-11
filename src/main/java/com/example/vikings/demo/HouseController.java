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
	
    @GetMapping("/house")
    public List<House> index(){
    	System.out.println("YES");
    	return houseRepository.findAll();        
    }
	
    @GetMapping("/house/{id}")
    public House show(@PathVariable String id){
        int houseId = Integer.parseInt(id);
        return houseRepository.getOne(houseId);
    }
    
    @PostMapping("/house/price")
    public List<House> showByPrice(@RequestParam(value = "toPrice") String toPrice){
        int p = Integer.parseInt(toPrice);
        return houseRepository.findByPrice(p);
    }
    
    @GetMapping("/house/lowerSize")
    public List<House> showByLowerSize(@RequestParam(value = "toSize") String toSize){
        int s = Integer.parseInt(toSize);
        return houseRepository.findBySizeLower(s);
    }
    
    @GetMapping("/house/higherSize")
    public List<House> showByHigherSize(@RequestParam(value = "fromSize") String fromSize){
        int s = Integer.parseInt(fromSize);
        return houseRepository.findBySizeHigher(s);
    }
    
    @GetMapping("/house/results")
    public List<House> showResults(@RequestParam(value = "toPrice", defaultValue = "1000000") String toPrice,
    		@RequestParam(value = "toSize", defaultValue = "1000") String toSize){
    	
    	int p = Integer.parseInt(toPrice);
    	int s = Integer.parseInt(toSize);
        return houseRepository.findByFilters(p, s);
    }
}
