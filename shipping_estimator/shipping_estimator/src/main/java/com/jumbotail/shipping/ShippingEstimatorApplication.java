package com.jumbotail.shipping;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableCaching
@SpringBootApplication
public class ShippingEstimatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingEstimatorApplication.class, args);
	}
}