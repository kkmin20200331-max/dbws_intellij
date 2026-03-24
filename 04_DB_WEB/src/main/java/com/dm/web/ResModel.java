package com.dm.web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ResModel {
    public static void getAllRes(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from restaurant_test ORDER BY r_no";
        try {
            conn = DBManager.connect();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<Restaurant> restaurants = new ArrayList<>();
            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            request.setAttribute("restaurants", restaurants);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, ps, rs);
        }
    }

    public static void addRes(HttpServletRequest request) {
        String saveRealPath = request.getSession().getServletContext().getRealPath("imgFile");
        System.out.println("saveRealPath:" + saveRealPath);
        Connection con = null;
        PreparedStatement ps = null;
        try {

            MultipartRequest mr = new MultipartRequest(request, saveRealPath, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
            String name = mr.getParameter("name");
            String place = mr.getParameter("place");
            String img = mr.getFilesystemName("img");
            if(img==null){
                img="defaultimg.jpg";
            }
            String sql = "insert into restaurant_test values(restaurant_test_seq.nextval,?,?,?)";
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, place);
            ps.setString(3, img);

            if (ps.executeUpdate() == 1) {
                System.out.println("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }
    }


    public static void delRes(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement ps = null;
        String no =  request.getParameter("no");
        String sql = "delete restaurant_test where r_no = ?";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, no);
            if (ps.executeUpdate() == 1) {
                System.out.println(" delete success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con,ps,null);
        }


    }

    public static void updateRes(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement ps = null;
        String no =  request.getParameter("no");
        String name = request.getParameter("name");
        String sql = "update restaurant_test set R_NAME = ? where R_NO = ?";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, no);
            if (ps.executeUpdate() == 1) {
                System.out.println("update success");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con,ps,null);
        }




    }
}
