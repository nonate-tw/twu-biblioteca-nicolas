package com.twu.biblioteca.menu;

public class ExitMenuHandler implements IMenuHandler{


    @Override
    public void setNext(IMenuHandler handler) {

    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.QUIT) {
            System.out.println("Good Bye!");
            System.exit(0);
        }else{
            System.out.println("Select a valid option!");
        }
    }
}
