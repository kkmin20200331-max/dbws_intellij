package com.dm.board.review;

import com.dm.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewDAO {

    public static final ReviewDAO RDAO = new ReviewDAO();

    private ReviewDAO() {
    }

    public void showAllReview(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBManager.connect();
            ps = con.prepareStatement("select * from review_test");
            rs = ps.executeQuery();

            ArrayList<ReviewVO> reviews = new ArrayList<>();
            while (rs.next()) {
                reviews.add(new ReviewVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
            }
            request.setAttribute("reviews", reviews);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBManager.close(con, ps, rs);
        }


    }

    public void addReview(HttpServletRequest request)  {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into review_test values(review_test_seq.nextval,?,?,sysdate)";
        String title = request.getParameter("title");
        String txt = request.getParameter("txt");

        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            request.setCharacterEncoding("utf-8");
            ps.setString(1, title);
            ps.setString(2, txt);

            if (ps.executeUpdate() == 1) {
                System.out.println("add success");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }

    }
}
