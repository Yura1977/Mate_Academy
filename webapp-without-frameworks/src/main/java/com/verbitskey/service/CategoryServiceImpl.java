package com.verbitskey.service;

import com.verbitskey.model.Category;
import com.verbitskey.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private static List<Category> categories = new ArrayList<>();

    static {
        Product product1 = new Product( 1L,"iPhone", "Apple product", 999.99 );
        Product product2 = new Product( 2L,"samsung", "korean product", 700.99 );

        List<Product> phoneProducts = new ArrayList<>();
        phoneProducts.add( product1 );
        phoneProducts.add( product2 );
        Category category1 = new Category( 1L, "Phones", "Best ever phones" );
        category1.setProducts( phoneProducts );
        categories.add( category1 );



//        categories.add( new Category( 2L, "Shoes", "Italian shoes" ));
        Product product3 = new Product( 3L,"Nike", "Nike needed no intro", 999.0 );
        Product product4 = new Product( 4L,"Adidas", "Original product", 999.99 );
        List<Product> shoesProducts = new ArrayList<>();
        shoesProducts.add( product3 );
        shoesProducts.add( product4 );
        Category category2 = ( new Category( 5L, "Shoes", "Italian shoes" ));
        category2.setProducts( shoesProducts );
        categories.add( category2 );


        Product product5 = new Product( 6L,"Samsung", "Korea TV", 1999.0 );
        Product product6 = new Product( 7L,"LG", "Original  Koreian product", 1909.99 );
        List<Product> tvsProducts = new ArrayList<>();
        tvsProducts.add( product5 );
        tvsProducts.add( product6 );
        Category category3 = ( new Category( 8L, "TVs", "Korea TVs" ) );
        category3.setProducts( tvsProducts );
        categories.add( category3 );
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categories.stream().filter( c -> c.getId().equals( id ) ).findFirst();
    }
    public static List<Product> getAllProducts() {
        return categories.stream().flatMap(c -> c.getProducts().stream()).collect( Collectors.toList());
    }
}

