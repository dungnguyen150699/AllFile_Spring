package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
//bỏ Spring Security autoConfig cái này nếu cáu hình tư động thôi còn app này vẫn có Sercurity
//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }) 
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private ProductService ps;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Product p = new Product();
//		p.setId(100000);
//		p.setName("dung");
//		ps.saveProduct(p);
//		test t1 = new test();
//		Product p1 = new Product();
//		p1.setName("px");
//		ps.saveProduct(p1);
	}

}
