package com.fastfood.burgerbox.repository;

import com.fastfood.burgerbox.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Product product1 = new Product();
        product1.setName("Beef Burger");
        product1.setPrice(4.99);
        product1.setImagePath("beefburger.png");

        Product product2 = new Product();
        product2.setName("Cheese Burger");
        product2.setPrice(5.99);
        product2.setImagePath("cheeseburger.png");

        Product product3 = new Product();
        product3.setName("Crispy Chicken");
        product3.setPrice(5.99);
        product3.setImagePath("crispychicken.png");

        Product product4 = new Product();
        product4.setName("Vegan Burger");
        product4.setPrice(3.49);
        product4.setImagePath("veganburger.png");

        Product product5 = new Product();
        product5.setName("Fries");
        product5.setPrice(2.49);
        product5.setImagePath("fries.png");

        Product product6 = new Product();
        product6.setName("Coffee");
        product6.setPrice(3.99);
        product6.setImagePath("coffee.png");

        Product product7 = new Product();
        product7.setName("Soft drink");
        product7.setPrice(1.99);
        product7.setImagePath("softdrink.png");

        Product product8 = new Product();
        product8.setName("Ice Cream");
        product8.setPrice(2.99);
        product8.setImagePath("icecream.png");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);

        System.out.println("Initial products have been added to the H2 database.");

    }
}
