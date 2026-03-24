package com.dm.board.movie;

import com.dm.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/movie")
public class MovieC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDAO.MDAO.selectAllMovie(request);
        String p = request.getParameter("p");

        int page =1;
        if (p != null) {
            page = Integer.parseInt(p);
            System.out.println(page);
        }

        MovieDAO.MDAO.paging(page,request);
        AccountDAO.loginCheck(request);
        request.setAttribute("content","jsp/movie/movie.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    MovieDAO.MDAO.addMovie(request);
        AccountDAO.loginCheck(request);
    response.sendRedirect("movie");
    }

    public void destroy() {
    }
}