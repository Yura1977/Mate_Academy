package com.verbitskey;


import com.verbitskey.controller.GetAllCategoriesController;
import com.verbitskey.controller.GetCategoryByIdController;
import com.verbitskey.controller.GetProductByIdController;
import com.verbitskey.controller.LoginUserController;
import com.verbitskey.service.CategoryService;
import com.verbitskey.service.CategoryServiceImpl;
import com.verbitskey.service.ProductService;
import com.verbitskey.service.ProductServiceImpl;
import com.verbitskey.service.UserService;
import com.verbitskey.service.UserServiceImpl;

//public class Factory {
//
//    public static LoginUserController getLoginUserController(UserService userService) {
//        return new LoginUserController( userService );
//    }
//
//    public static UserService getUserServiceImpl() {
//        return new UserServiceImpl();
//    }
//
//    public static GetAllCategoriesController getGetAllCategoriesController(CategoryService categoryService) {
//        return new GetAllCategoriesController( categoryService );
//    }
//
//    public static CategoryService getCategoryService() {
//        return new CategoryServiceImpl();
//    }
//
//    public static Controller getGetCategoryByIdController(CategoryService categoryService) {
//        return new GetCategoryByIdController( categoryService );
//    }
//
//    public static ProductService getProductService() {
//        return new ProductServiceImpl();
//    }
//
//    public static GetProductByIdController getGetProductByIdController(ProductService productService) {
//        return new GetProductByIdController(productService);
//    }
//}
public class Factory {

    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl() {
        return new UserServiceImpl();
    }

    public static GetAllCategoriesController getGetAllCategoriesController(CategoryService categoryService) {
        return new GetAllCategoriesController(categoryService);
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService) {
        return new GetCategoryByIdController(categoryService);
    }

    public static ProductService getProductService() {
        return new ProductServiceImpl();
    }

    public static GetProductByIdController getGetProductByIdController(ProductService productService) {
        return new GetProductByIdController(productService);
    }
}