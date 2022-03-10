package com.flash.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flash.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
