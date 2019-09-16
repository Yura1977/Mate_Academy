package com.verbitskey.controller;

import com.verbitskey.Request;
import com.verbitskey.ViewModel;
import com.verbitskey.service.CategoryService;

public class GetAllCategoriesController implements Controller {

    private final CategoryService categoryService;

    public GetAllCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        return ViewModel.of( "categories" ).withAttribute( "categories", categoryService.getAll() );
    }
}

