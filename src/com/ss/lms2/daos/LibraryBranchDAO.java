package com.ss.lms2.daos;

import com.ss.lms2.MySQL;
import com.ss.lms2.pojos.LibraryBranch;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibraryBranchDAO {
    /*static public ResultSet getById(Integer id, LibraryBranch libraryBranch) {
        ResultSet resultSet = MySQL.doQuery("SELECT * FROM tbl_library_branch WHERE branchId = " + id + ";");
        try {
            while (resultSet.next()) {
                // TODO update to city
                libraryBranch.branchCity = resultSet.getString("branchAddress");
                libraryBranch.branchName = resultSet.getString("branchName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    static public List<LibraryBranch> getAll() {
        ResultSet resultSet = MySQL.doQuery("SELECT * FROM tbl_library_branch;");
        List<LibraryBranch> allLibraryBranches = new ArrayList<LibraryBranch>();
        try {
            while (resultSet.next()) {
                LibraryBranch libraryBranch = new LibraryBranch();
                libraryBranch.branchName = resultSet.getString("branchName");
                allLibraryBranches.add(libraryBranch);
            }
        } catch (Exception e) {

        }
        return allLibraryBranches;
    }
}
