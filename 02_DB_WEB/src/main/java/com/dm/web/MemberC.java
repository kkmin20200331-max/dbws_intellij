package com.dm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member-c")
public class MemberC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    MemberDAO.delMember(request);
    response.sendRedirect("all");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }


}