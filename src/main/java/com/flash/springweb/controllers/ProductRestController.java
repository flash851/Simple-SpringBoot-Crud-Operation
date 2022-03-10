package com.flash.springweb.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flash.springweb.entities.Product;
import com.flash.springweb.repos.ProductRepository;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Rest endpoint")
public class ProductRestController {
	@Autowired
	private ProductRepository repository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);
	@RequestMapping(value="/products/" ,method=RequestMethod.GET)
	public List<Product> getProduct()
	{
		return repository.findAll();
	}
	@Hidden
	@RequestMapping(value="/products/{id}" ,method=RequestMethod.GET)
	@Operation(summary = "Returns a Product",description = "Take a id and return a Product")
	public @ApiResponse(description = "Product Object")  
	Product getProductById(@Parameter(description = "Id of the product") @PathVariable("id")int id) {
		LOGGER.info("finding product with id:"+id);
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/products/" ,method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/" ,method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/{id}" ,method=RequestMethod.DELETE)
	public void deleteProductById(@PathVariable("id")int id) {
		 repository.deleteById(id);
	}
}
