package com.dm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

    public static void getAllMember(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from member_test ORDER BY M_NO ";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<MemberDTO> members = new ArrayList<>();
            while(rs.next()){
            MemberDTO member = new MemberDTO(rs.getInt("M_NO"), rs.getString("M_NAME"), rs.getInt("M_AGE"));
            members.add(member);
            request.setAttribute("members", members);
            }
            System.out.println(members);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con,ps,rs);
        }
    }



    public static void addMember(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String addsql = "insert into member_test values(member_test_seq.nextval,?,?)";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(addsql);

            ps.setString(1,name);
            ps.setInt(2,age);

            if(ps.executeUpdate()>0){
                System.out.println("등록완료!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con,ps,null);
        }
    }




    public static void delMember(HttpServletRequest request) {

    Connection con = null;
    PreparedStatement ps = null;
    String delsql = "delete from member_test where M_NO = ?";
    int id = Integer.parseInt(request.getParameter("id"));
    try {
        con = DBManager.connect();
        ps = con.prepareStatement(delsql);

        ps.setInt(1,id);
        if(ps.executeUpdate()==1){
            System.out.println("delete success!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        DBManager.close(con,ps,null);
    }





    }

    public static void updateMember(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement ps = null;
        String edit = request.getParameter("edit");
        String id = request.getParameter("id");
        String udsql = "update member_test set M_NAME=? where M_NO=?";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(udsql);
            ps.setString(1,edit);
            ps.setString(2,id);
            if(ps.executeUpdate()==1){
                System.out.println("update success!");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con,ps,null);
        }



    }
}
