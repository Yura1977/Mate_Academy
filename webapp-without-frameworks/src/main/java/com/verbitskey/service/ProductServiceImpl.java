package com.verbitskey.service;

import com.verbitskey.model.Product;

import java.util.List;
import java.util.Optional;

//public class ProductServiceImpl implements ProductService {
//    private static  List<Product> products;
//    static {
//        products = CategoryServiceImpl.getAllProducts();
//    }
//
//    @Override
//    public List<Product> getAll() {
//        return products;
//    }
//
//    @Override
//    public Optional<Product> getById(Long id) {
//        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
//    }
//}
public class ProductServiceImpl implements ProductService {

    private static List<Product> products;

    static {
        products = CategoryServiceImpl.getAllProducts();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}