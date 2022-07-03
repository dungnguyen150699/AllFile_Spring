package com.ngatdo.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Application {
	// Bean có thể được khai báo tại đây
	@Bean
	@LoadBalanced
	/**
	 * 	Thông báo với restTemplate rằng không đi thẳng tới service trực tiếp bằng URL  nhận được, đây chỉ là một hint để tìm ra service
	 * 	restTemplate gọi Eureka xem có service nào tên như vậy không? Lúc này Eureka chỉ biết 3 tên service chứ không biết localhost:8082… là gì
	 */
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
