package com.dm.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/CRC")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ResModel.getAllRes(request);

    request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ResModel.addRes(request);
    response.sendRedirect("CRC");
    }

    public void destroy() {
    }
}