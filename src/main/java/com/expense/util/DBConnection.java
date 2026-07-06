package com.expense.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/smart_expense_tracker";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "syam@12";   // Change if your password is different

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}