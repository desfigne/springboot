package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateProductRepository implements ProductRepository {

    @Override
    public List<Product> findAll() {
        System.out.println("repository ----------> ");
        return null;
    }
}
