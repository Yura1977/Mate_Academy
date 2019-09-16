package com.verbitskey.service;

import com.verbitskey.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getById(Long id);

    List<Product> getAll();
}
