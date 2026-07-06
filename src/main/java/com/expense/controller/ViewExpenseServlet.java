package com.expense.controller;

import java.io.IOException;
import java.util.List;

import com.expense.dao.ExpenseDAO;
import com.expense.model.Expense;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ExpenseDAO dao = new ExpenseDAO();

        List<Expense> list = dao.getAllExpenses();

        request.setAttribute("expenseList", list);

        request.getRequestDispatcher("viewExpenses.jsp").forward(request, response);

    }

}