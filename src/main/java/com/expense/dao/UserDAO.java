package com.expense.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.expense.util.DBConnection;

public class UserDAO {

    public boolean validateUser(String username, String password) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM user WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}