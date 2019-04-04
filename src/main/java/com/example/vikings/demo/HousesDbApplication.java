package com.example.vikings.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(scanBasePackages = { "com.myapp.app" }, exclude = { ErrorMvcAutoConfiguration.class })
@SpringBootApplication
public class HousesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousesDbApplication.class, args);
		
//		HouseController houseController = new HouseController();
//		houseController.index();
	}

}
