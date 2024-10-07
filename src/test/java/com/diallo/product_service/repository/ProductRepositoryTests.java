package com.diallo.product_service.repository;

import com.diallo.product_service.entity.Product;


import com.diallo.product_service.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTests {
    @Mock
    private ProductRepository productRepository;  // Mock the repository

    @InjectMocks
    private ProductService productService;  // Inject the mock repository into the service

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize the mock objects
    }
    @Test
    public void testSaveProduct() {
        // Create a new product
        Product product = Product
                .builder()
                .name("Orange")
                .description("Nice")
                .price(1000.00)
                .build();

        // Mock the save method to return the same product
        when(productRepository.save(product)).thenReturn(product);

        // Call the service to save the product
        Product savedProduct = productService.save(product);

        // Assert that the saved product is not null and has the correct properties
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Orange");
        assertThat(savedProduct.getPrice()).isEqualTo(1000.00);
    }

    @Test
    public void testgetAllProducts() {

        List<Product> products = Arrays.asList(
                Product
                        .builder()
                        .name("Orange")
                        .description("Nice")
                        .price(1000.00)
                        .build(),
                Product
                        .builder()
                        .name("Apple")
                        .description("Cool")
                        .price(500.0).build()
        );

        when(productRepository.findAll()).thenReturn(products);

        List<Product> retrievedProducts = productService.getAll();

        assertThat(retrievedProducts).isNotNull();
        assertThat(retrievedProducts.size()).isEqualTo(products.size());

    }
}
