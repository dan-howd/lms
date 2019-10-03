package com.ss.lms2.views;

import com.ss.lms2.UserInput;
import com.ss.lms2.daos.LibraryBranchDAO;
import com.ss.lms2.pojos.LibraryBranch;

import java.util.List;

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
        List<LibraryBranch> allBranches = LibraryBranchDAO.getAll();
        Integer branchChoice = null;
        Integer index = 1;
        for (LibraryBranch branch : allBranches) {
            System.out.println(index + ") " + branch.branchName);
            index++;
        }
        // if the user selects this number, they chose to exit to main menu
        Integer exitChoice = index;
        System.out.println(exitChoice + ") Main Menu");

        System.out.print("Choose: ");
        branchChoice = Integer.parseInt(UserInput.get());
    }
}
