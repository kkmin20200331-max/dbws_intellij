package com.dm.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-user")
public class EditAccountC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //수정하러 보내기
        if (AccountDAO.ADAO.loginCheck(request)) {
            request.setAttribute("content", "jsp/account/edit_account.jsp");
        } else {
            request.setAttribute("content", "home.jsp");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //어디로 갈지?
        if (AccountDAO.ADAO.loginCheck(request)) {
            AccountDAO.ADAO.editUser(request);
        }
        response.sendRedirect("user-info");

    }

    public void destroy() {
    }
}