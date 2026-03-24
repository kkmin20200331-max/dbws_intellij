package com.dm.board.movie;

import com.dm.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUpMovie")
public class DelUpMovieC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("type")!=null && request.getParameter("type").equals("d")) {
            MovieDAO.MDAO.delMovie(request);
            AccountDAO.loginCheck(request);
            response.sendRedirect("movie");
        }else{
            MovieDAO.MDAO.updateMovie(request);
            AccountDAO.loginCheck(request);
            response.sendRedirect("movie");
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}