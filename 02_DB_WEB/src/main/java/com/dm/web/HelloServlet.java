package com.dm.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/all")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    MemberDAO.getAllMember(request);
    request.getRequestDispatcher("member_list.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    request.setCharacterEncoding("UTF-8");
    MemberDAO.addMember(request);
//    MemberDAO.getAllMember(request);
//    request.getRequestDispatcher("member_list.jsp").forward(request,response);
    response.sendRedirect("all");//입력값 재요청이 필요없을 때 이렇게 하면 깔끔

    }


}