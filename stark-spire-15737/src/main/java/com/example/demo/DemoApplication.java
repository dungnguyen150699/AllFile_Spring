package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
//bỏ Spring Security autoConfig cái này nếu cáu hình tư động thôi còn app này vẫn có Sercurity
@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }) 
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private ProductService ps;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		ps.loopSave();
		ps.callLoopSave();
	}

}
