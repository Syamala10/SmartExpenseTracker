package com.expense.controller;

import java.io.IOException;

import com.expense.dao.ExpenseDAO;
import com.expense.model.Expense;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EditExpenseServlet")
public class EditExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ExpenseDAO dao = new ExpenseDAO();

        Expense expense = dao.getExpenseById(id);

        request.setAttribute("expense", expense);

        request.getRequestDispatcher("editExpense.jsp").forward(request, response);

    }

}