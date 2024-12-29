package com.fastfood.burgerbox.service;

import com.fastfood.burgerbox.model.Product;
import com.fastfood.burgerbox.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }
}
