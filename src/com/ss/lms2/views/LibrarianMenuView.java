package com.ss.lms2.views;

import com.ss.lms2.UserInput;

public class LibrarianMenuView {
    static public void mainPrompt() {
        System.out.println("1) Choose Branch");
        System.out.println("2) Main Menu");

        System.out.print("Choose: ");
        Integer choice = Integer.parseInt(UserInput.get());

        switch(choice) {
            case 1:
                chooseBranch();
                break;
            case 2:
                return;
        }
    }

    static public void chooseBranch() {

    }
}
