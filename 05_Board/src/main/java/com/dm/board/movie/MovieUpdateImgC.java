package com.dm.board.movie;

import com.dm.board.account.AccountDAO;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class MovieUpdateImgC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDAO.MDAO.getMovie(request);
        AccountDAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie_edit.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    MovieDAO.MDAO.editImgMovie(request);
        AccountDAO.loginCheck(request);
    response.sendRedirect("detail-movie?no="+request.getAttribute("noo"));
    }

    public void destroy() {
    }
}