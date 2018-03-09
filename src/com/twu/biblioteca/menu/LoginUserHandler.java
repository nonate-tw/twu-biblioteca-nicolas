package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.LoginService;

public class LoginUserHandler implements IMenuHandler{

    private IMenuHandler next;
    private LoginService loginService;


    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.LOGIN) {
            loginService.loginUser();
        }else{
            next.handlerOption(option);
        }

    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
