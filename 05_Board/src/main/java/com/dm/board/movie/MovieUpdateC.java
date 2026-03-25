package com.dm.board.movie;

import com.dm.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-movie")
public class MovieUpdateC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDAO.MDAO.getMovie(request);
        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie_update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    MovieDAO.MDAO.upJspMovie(request);
        AccountDAO.ADAO.loginCheck(request);
    response.sendRedirect("detail-movie?no="+request.getParameter("no"));
    //    MovieDAO.getMovie(request);
//    request.setAttribute("content", "jsp/movie/movie_detail.jsp");
//    request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}