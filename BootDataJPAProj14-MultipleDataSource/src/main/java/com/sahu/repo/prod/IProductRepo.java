package com.sahu.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.model.prod.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
