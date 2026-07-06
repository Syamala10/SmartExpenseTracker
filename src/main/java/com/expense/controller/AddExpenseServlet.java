package com.expense.controller;

import java.io.IOException;

import com.expense.dao.ExpenseDAO;
import com.expense.model.Expense;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddExpenseServlet")
public class AddExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("===== AddExpenseServlet Executed =====");

        String title = request.getParameter("title");
        String amountStr = request.getParameter("amount");
        String category = request.getParameter("category");
        String expenseDate = request.getParameter("expenseDate");

        System.out.println("Title : " + title);
        System.out.println("Amount : " + amountStr);
        System.out.println("Category : " + category);
        System.out.println("Date : " + expenseDate);

        try {

            double amount = Double.parseDouble(amountStr);

            Expense expense = new Expense();

            expense.setTitle(title);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setExpenseDate(expenseDate);

            ExpenseDAO dao = new ExpenseDAO();

            boolean status = dao.addExpense(expense);

            if (status) {

                System.out.println("Expense Added Successfully");

                response.sendRedirect("dashboard.jsp");

            } else {

                System.out.println("Expense Not Added");

                response.getWriter().println("Expense Not Added!");

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}