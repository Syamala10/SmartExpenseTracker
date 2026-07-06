package com.expense.controller;

import java.io.IOException;

import com.expense.dao.ExpenseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteExpenseServlet")
public class DeleteExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ExpenseDAO dao = new ExpenseDAO();

        dao.deleteExpense(id);

        response.sendRedirect("ViewExpenseServlet");
    }
}