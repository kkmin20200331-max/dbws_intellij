package com.dm.web;

import jdk.jfr.Frequency;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet( "/show-all")
public class Show extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //전체조회
        UserDAO.showAllPeople(request);
        //어디로?
        request.getRequestDispatcher("output.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    UserDAO.addPeople(request);
    UserDAO.showAllPeople(request);
    request.getRequestDispatcher("output.jsp").forward(request,response);

    }

}