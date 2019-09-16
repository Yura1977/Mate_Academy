package com.verbitskey;

import com.verbitskey.controller.Controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.verbitskey.Factory.getCategoryService;
import static com.verbitskey.Factory.getGetAllCategoriesController;
import static com.verbitskey.Factory.getGetCategoryByIdController;
import static com.verbitskey.Factory.getGetProductByIdController;
import static com.verbitskey.Factory.getLoginUserController;
import static com.verbitskey.Factory.getProductService;
import static com.verbitskey.Factory.getUserServiceImpl;

//import static com.verbitskey.Factory.*;

public class MainServlet extends HttpServlet {
    private static final Map<Request, Controller> controllerMap = new HashMap<>();

    static {
        controllerMap.put( Request.of( "GET", "/servlet/login" ), new Controller() {
            @Override
            public ViewModel process(Request r) {
                return ViewModel.of( "login" );
            }
        } );
        controllerMap.put( Request.of( "POST", "/servlet/login" ), getLoginUserController( getUserServiceImpl()));
        controllerMap.put( Request.of( "GET", "/servlet/categories" ), getGetAllCategoriesController( getCategoryService() ) );
        controllerMap.put( Request.of( "GET", "/servlet/category" ), getGetCategoryByIdController( getCategoryService()));
        controllerMap.put( Request.of( "GET", "/servlet/product" ), getGetProductByIdController(getProductService() ));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest( req, resp );
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = Request.of( req.getMethod(), req.getRequestURI(), req.getParameterMap() );
        Controller controller = controllerMap.getOrDefault( request, r -> ViewModel.of( "404" ) );
        ViewModel vm = controller.process( request );
        processViewModel( vm, req, resp );
        /*String name;
        if (req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("GET")) {
            name = "login";
        } else if (req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("POST")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            req.setAttribute("username",username);
            name = "welcome";
        }else{
            name = "404";
        }
        req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", name)).forward(req, resp);*/
    }

    private void processViewModel(ViewModel vm, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //vm.getAttributes().forEach((k,v)->req.setAttribute(k,v));
        vm.getAttributes().forEach( req::setAttribute );

        req.getRequestDispatcher( vm.getRedirectUri() ).forward( req, resp );
    }
}