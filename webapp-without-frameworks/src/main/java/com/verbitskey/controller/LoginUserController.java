package com.verbitskey.controller;

import com.verbitskey.Request;
import com.verbitskey.ViewModel;
import com.verbitskey.model.User;
import com.verbitskey.service.UserService;

//public class LoginUserController implements Controller {
//
//    private UserService userService;
//
//    public LoginUserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public ViewModel process(Request req) {
//        String username = req.getParam( "username" )[0];
//        String password = req.getParam( "password" )[0];
//        User user = User.of( username, password );
//
//        return userService.authorize( user )
//                .map( u -> ViewModel.of( "welcome" ).withAttribute( "user", u ) )
//                .orElseGet( () -> ViewModel.of( "login" ).withAttribute( "error", "msg" ) );
//    }
//}
public class LoginUserController implements Controller {

    private final UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request req) {
        String username = req.getParam("username")[0];
        String password = req.getParam("password")[0];
        User user = User.of(username, password);

        return userService.authorize(user)
                .map(u -> ViewModel.of("welcome").withAttribute("user", u))
                .orElseGet(() -> ViewModel.of("login").withAttribute("error", "msg"));
    }
}