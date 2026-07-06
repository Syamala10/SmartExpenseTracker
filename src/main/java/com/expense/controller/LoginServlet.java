package com.expense.controller;

import java.io.IOException;

import com.expense.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        if (dao.validateUser(username, password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            response.sendRedirect("dashboard.jsp");

        } else {

            response.sendRedirect("login.jsp");

        }

    }

}