package com.expense.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.expense.model.Expense;
import com.expense.util.DBConnection;

public class ExpenseDAO {

    public boolean addExpense(Expense expense) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO expense(title,amount,category,expense_date) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setString(4, expense.getExpenseDate());

            status = ps.executeUpdate() > 0;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Expense> getAllExpenses() {

        List<Expense> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM expense ORDER BY id DESC");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Expense e = new Expense();

                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setExpenseDate(rs.getString("expense_date"));

                list.add(e);

            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public boolean deleteExpense(int id) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM expense WHERE id=?");

            ps.setInt(1, id);

            status = ps.executeUpdate() > 0;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public Expense getExpenseById(int id) {

        Expense expense = new Expense();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM expense WHERE id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                expense.setId(rs.getInt("id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setExpenseDate(rs.getString("expense_date"));

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return expense;
    }

    public boolean updateExpense(Expense expense) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE expense SET title=?,amount=?,category=?,expense_date=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setString(4, expense.getExpenseDate());
            ps.setInt(5, expense.getId());

            status = ps.executeUpdate() > 0;

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

}