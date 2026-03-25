package com.dm.board.account;

import com.dm.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDAO {
    public static final AccountDAO ADAO = new AccountDAO();



    private AccountDAO() {
    }




    public  boolean loginCheck(HttpServletRequest request) {
//        HttpSession hs = request.getSession();
        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        if (user != null) {
            request.setAttribute("loginPage", "jsp/account/loginOK.jsp");
            return true;
        } else {
            request.setAttribute("loginPage", "jsp/account/login.jsp");
            return false;
        }
    }

    public  void login(HttpServletRequest request) {
        //1. 값받기 or db
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        if(id == null){
            id = (String) request.getAttribute("idd");
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from login_test where l_id = ?";
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            String msg = null;
            if (rs.next()) {
                if (rs.getString("l_pw").equals(pw)) {
                    //로그인성공 존
                    System.out.println("Login Success");
                    msg = "Login Success";
                    AccountVO accountVO = new AccountVO();
                    accountVO.setId(rs.getString("l_id"));
                    accountVO.setPw(rs.getString("l_pw"));
                    accountVO.setName(rs.getString("l_name"));
//                    request.setAttribute("user", accountVO);
                    HttpSession hs = request.getSession();
                    hs.setAttribute("user", accountVO);
                    hs.setMaxInactiveInterval(5 * 60);
                } else {
                    System.out.println("Wrong Password");
                    msg = "Wrong Password";
                }
            } else {
                System.out.println("No Account");
                msg = "No Account";
            }

            request.setAttribute("msg", msg);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, rs);
        }


    }

    public  void logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
//     session.invalidate(); 세션 초기화
//     session.removeAttribute("user"); 세션 삭제
        session.setAttribute("user", null); // 세션 null 집어넣기


    }

    public  int delUser(HttpServletRequest request) {
        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        String pw = request.getParameter("pw");
        Connection con = null;
        PreparedStatement ps = null;

        try {
            if (pw.equals(user.getPw())) {
                con = DBManager.connect();
                ps = con.prepareStatement("delete from login_test where l_pw = ?");
                ps.setString(1, pw);

                if (ps.executeUpdate() == 1) {
                    System.out.println("delete success");
                    logout(request);

                }
                return 1;
            }else{

                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBManager.close(con, ps, null);
        }
        return 0;
    }

    public  void editUser(HttpServletRequest request) {

        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        Connection con = null;
        PreparedStatement ps = null;
        request.setAttribute("idd", user.getId());
        try {

                con = DBManager.connect();
                ps = con.prepareStatement("update login_test set l_pw=?, l_name=? where l_id=?");
                ps.setString(1,pw);
                ps.setString(2,name);
                ps.setString(3, user.getId());
                if (ps.executeUpdate() == 1) {
                    System.out.println("update success");
                    //재로그인
                   // login(request);
                    //세션업데이트
                    user.setPw(pw);
                    user.setName(name);
                }



        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBManager.close(con, ps, null);
        }
    }
}
