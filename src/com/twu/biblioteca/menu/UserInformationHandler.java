package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.LoginService;

public class UserInformationHandler implements IMenuHandler{

    private LoginService loginService;
    private IMenuHandler next;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.USER_INFORMATION) {
            loginService.getUserInfo();
        }else{
            next.handlerOption(option);
        }
    }
}
