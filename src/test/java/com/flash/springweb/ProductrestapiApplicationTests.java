package com.flash.springweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.flash.springweb.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.service.url}")
	private String baseURL;
	@Test
	void testGetProducts() {
		RestTemplate restTemplate=new RestTemplate();
		System.out.println("URL: "+baseURL+"3");
		Product product = restTemplate.getForObject(baseURL+"3", Product.class);
		assertNotNull(product);
		assertEquals("macbook", product.getName());
	}
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product product1=new Product();
		product1.setName("samsung mobile");
		product1.setPrice(10000);
		product1.setDescription("It's hangs too much");
		Product product = restTemplate.postForObject(baseURL,product1, Product.class);
		assertNotNull(product);
		assertNotNull( product.getId());
		assertEquals("samsung mobile", product.getName());
	}
	@Test
	void testUpdateProducts() {
		RestTemplate restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"4", Product.class);
		product.setPrice(9000000);
		
		restTemplate.put(baseURL, product);
		 
	}
	
}
