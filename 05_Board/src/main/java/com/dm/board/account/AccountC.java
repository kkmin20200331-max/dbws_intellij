package com.dm.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-login")
public class AccountC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //로그아웃 - 세션죽이기
        AccountDAO.logout(request);
        //어디로 갈지?
       response.sendRedirect("HC");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //하는일
        AccountDAO.login(request);
    //어디로?
    AccountDAO.loginCheck(request);
    request.setAttribute("content","home.jsp");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}