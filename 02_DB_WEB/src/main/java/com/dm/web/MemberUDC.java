package com.dm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/udc")
public class MemberUDC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    MemberDAO.updateMember(request);
    response.sendRedirect("all");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }


}