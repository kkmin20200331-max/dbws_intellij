package com.dm.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-info")
public class AccountInfoC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //mypage - session에 다 있기 때문에 굳이 조회할 필요가 없다!

        //어디로 갈지?
        if(AccountDAO.ADAO.loginCheck(request)){
        request.setAttribute("content","jsp/account/mypage.jsp");

        }else{
        request.setAttribute("content","home.jsp");

        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }

    public void destroy() {
    }
}