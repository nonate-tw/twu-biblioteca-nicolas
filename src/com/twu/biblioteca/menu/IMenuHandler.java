package com.twu.biblioteca.menu;

public interface IMenuHandler {

    void setNext(IMenuHandler handler);

    void handlerOption(int option);
}
