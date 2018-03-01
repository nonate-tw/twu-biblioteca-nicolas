package com.twu.biblioteca;

public class MenuDraw {

    public static String getLines(int n) {

        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < n; i++) {
            lines.append("=");
        }

        return lines.toString();
    }

    public static String principalMenu() {

        String lines = MenuDraw.getLines(50);
        String menu = "";

        menu += String.format("%s%n",lines);
        menu += String.format("%-20s%s%n","","MENU");
        menu += String.format("%s%n",lines);
        menu += String.format("%-15s%s%n","","1.- List Books");
        menu += String.format("%-15s%s%n","","2.- Quit");
        menu += String.format("%s%n",lines);

        menu += String.format("%s", "choose an option > ");

        return menu;
    }
}
