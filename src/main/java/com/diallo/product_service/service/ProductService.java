package com.diallo.product_service.service;


import com.diallo.product_service.entity.Product;
import com.diallo.product_service.exception.ProductNotFoundExcepetion;
import com.diallo.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Product getProduct(Integer id) throws ProductNotFoundExcepetion {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundExcepetion("Product not found"));
    }








}
