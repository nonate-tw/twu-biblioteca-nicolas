package com.twu.biblioteca.menu;

public interface IMenuHandler {

    public void setNext(IMenuHandler handler);

    public IMenuHandler getNext();

    public void handlerOption(int option);
}
