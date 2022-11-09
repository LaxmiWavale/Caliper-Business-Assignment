package com.hydroponic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HydroponicFarmingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydroponicFarmingApplication.class, args);
		System.out.println("connected to database!");
	}

}
