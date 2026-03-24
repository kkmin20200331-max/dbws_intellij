package com.dm.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    public static void showAllPeople(HttpServletRequest request)  {
        //1.값 or db 껍 3종
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from name_age_test";
            con = DBManager.connect();
            System.out.println("connect success");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //HumanDTO
            ArrayList<Human> humans = new ArrayList<>();
            while (rs.next()){
                humans.add(new Human(rs.getString("N_NAME"),rs.getInt("N_AGE")));
            }
            System.out.println(humans);
            request.setAttribute("humans", humans);

        }catch (Exception e){
            e.printStackTrace();

        }finally {
           DBManager.close(con,ps,rs);
        }


    }

    public static void addPeople(HttpServletRequest request) {
        //DB세팅
        Connection con = null;
        PreparedStatement ps = null;

        //값 받기
        String name = request.getParameter("n");
       String age = request.getParameter("a");
        try {
            String sql = "insert into name_age_test values (?,?)";
            con = DBManager.connect();
            System.out.println("connect success");
            ps = con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,age);

            if(ps.executeUpdate() > 0){
                System.out.println("insert success");
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            DBManager.close(con,ps,null);
        }


    }
}
