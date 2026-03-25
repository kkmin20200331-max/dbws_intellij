package com.dm.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del-user")
public class DeleteAccountC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //what?
        AccountDAO.ADAO.delUser(request);
        //어디로 갈지?

        response.sendRedirect("HC");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (AccountDAO.ADAO.delUser(request)==1) {

            response.sendRedirect("HC");
        } else {
            response.sendRedirect("user-info");
        }
    }

    public void destroy() {
    }
}