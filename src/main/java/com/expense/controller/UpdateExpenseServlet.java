package com.expense.controller;

import java.io.IOException;

import com.expense.dao.ExpenseDAO;
import com.expense.model.Expense;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateExpenseServlet")
public class UpdateExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Expense expense = new Expense();

        expense.setId(Integer.parseInt(request.getParameter("id")));
        expense.setTitle(request.getParameter("title"));
        expense.setAmount(Double.parseDouble(request.getParameter("amount")));
        expense.setCategory(request.getParameter("category"));
        expense.setExpenseDate(request.getParameter("expenseDate"));

        ExpenseDAO dao = new ExpenseDAO();

        dao.updateExpense(expense);

        response.sendRedirect("ViewExpenseServlet");

    }

}