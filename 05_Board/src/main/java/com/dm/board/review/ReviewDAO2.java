package com.dm.board.review;

import com.dm.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewDAO2 {

    public static final ReviewDAO2 RDAO = new ReviewDAO2();

    private ReviewDAO2() {
    }


    public ArrayList<ReviewVO> showAllReview(HttpServletRequest request) {
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
//            request.setAttribute("reviews", reviews);
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBManager.close(con, ps, rs);
        }
        return null;


    }

    public void addReview(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
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

    public void getReview(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "select * from review_test where r_no = ?";
    String no = request.getParameter("no");
    if(no == null){
        no =(String) request.getAttribute("no");
    }
    try {
        con = DBManager.connect();
        ps = con.prepareStatement(sql);
        ps.setString(1, no);

        rs = ps.executeQuery();
        ReviewVO getReview = new ReviewVO();
        if (rs.next()) {
            getReview.setTitle(rs.getString("r_title"));
            getReview.setNo(rs.getInt("r_no"));
            getReview.setTxt(rs.getString("r_txt"));
            getReview.setDate(rs.getDate("r_date"));
            System.out.println("get review success");
        }
        request.setAttribute("review", getReview);
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        DBManager.close(con, ps, rs);
    }



    }

    public void updateReview(HttpServletRequest request) throws UnsupportedEncodingException {
            request.setCharacterEncoding("utf-8");

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update review_test set r_title = ?, r_txt = ? where r_no = ?";
        String title = request.getParameter("title");
        String txt = request.getParameter("txt");
        int no = Integer.parseInt(request.getParameter("no"));
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, txt);
            ps.setInt(3, no);

            if (ps.executeUpdate() == 1) {
                System.out.println("update success");
                request.setAttribute("no", no);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }
    }

    public void delReview(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete review_test where r_no = ?";
        int no = Integer.parseInt(request.getParameter("no"));
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, no);

            if (ps.executeUpdate() == 1) {
                System.out.println("delete success");
                request.setAttribute("no", no);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }


    }



    public  void paging(int pageNum, HttpServletRequest request){
        request.setAttribute("currentPage",pageNum);
        ArrayList<ReviewVO> reviews =  showAllReview(request);
        int total = reviews.size();
        int cnt =5;
        //페이지수 구하기
        int totalPage = (int)Math.ceil((double)total/(double)cnt);
        request.setAttribute("totalPage",totalPage);

        if (pageNum>totalPage){
            pageNum = totalPage;
        }
        if (pageNum<1){
            pageNum = 1;
        }

        int start = total - (cnt * (pageNum - 1));
        //2p : 11-(3*(2-1)) = 8

        int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

        ArrayList<ReviewVO> items = new ArrayList<>();
        for (int i = start-1; i > end; i--) {
            items.add(reviews.get(i));
        }
        request.setAttribute("reviews", items);








    }
}
