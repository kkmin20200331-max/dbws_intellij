package com.dm.board.movie;

import com.dm.board.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieDAO {
    public static final MovieDAO MDAO = new MovieDAO();

    private MovieDAO() {
    }

    private  ArrayList<MovieDTO> movies;
    public  void selectAllMovie(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from movie_test ORDER BY M_NO";


        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            MovieDTO dto = null;
            movies = new ArrayList<>();

            while (rs.next()) {
                dto = new MovieDTO();
                dto.setNo(rs.getInt("M_NO"));
                dto.setTitle(rs.getString("M_TITLE"));
                dto.setActor(rs.getString("M_ACTOR"));
                dto.setImg(rs.getString("M_IMG"));
                dto.setStory(rs.getString("M_STORY"));
                movies.add(dto);
                //movies.add(new MovieDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            request.setAttribute("movies", movies);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, rs);
        }


    }

    public  void addMovie(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        //String path = request.getServletContext().getRealPath("movieFile");
        String path = "C:/dm/dbws_intellij/upload/movieFile";


        Connection con = null;
        PreparedStatement ps = null;


        String sql = "insert into movie_test values(movie_test_seq.nextval,?,?,?,?)";


        try {
            MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 20, "utf-8", new DefaultFileRenamePolicy());
            String title = mr.getParameter("title");
            String actor = mr.getParameter("actor");
            String img = mr.getFilesystemName("file");
            String story = mr.getParameter("story");
            con = DBManager.connect();
            ps = con.prepareStatement(sql);



           story = story.replaceAll("\r\n","<br>");

            ps.setString(1, title);
            ps.setString(2, actor);
            ps.setString(3, img);
            ps.setString(4, story);
            if (ps.executeUpdate() == 1) {
                System.out.println("add movie success");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }
    }

    public  void delMovie(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql = "delete movie_test where M_NO=?";
        int no = Integer.parseInt(request.getParameter("id"));

        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, no);

            if (ps.executeUpdate() == 1) {
                System.out.println("delete movie success");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }
    }

    public  void updateMovie(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql = "update movie_test set m_title = ? where m_no =?";
        int no = Integer.parseInt(request.getParameter("id"));
        String edit = request.getParameter("edit");

        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, edit);
            ps.setInt(2, no);

            if (ps.executeUpdate() == 1) {
                System.out.println("update movie success");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, null);
        }
    }

    public  void getMovie(HttpServletRequest request) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from movie_test where m_no =?";
        String no = request.getParameter("no");

        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, no);
            rs = ps.executeQuery();

            MovieDTO dto =new MovieDTO();


           if( rs.next()) {

               dto.setNo(rs.getInt("M_NO"));
               dto.setTitle(rs.getString("M_TITLE"));
               dto.setActor(rs.getString("M_ACTOR"));
               dto.setImg(rs.getString("M_IMG"));
               dto.setStory(rs.getString("M_STORY"));
           }
            System.out.println(dto);
            request.setAttribute("movie", dto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, rs);
        }
    }

    public  void upJspMovie(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String story = request.getParameter("story");
        story = story.replaceAll("\r\n","<br>");
        String no =  request.getParameter("no");
        String sql = "update movie_test set m_title = ?, m_actor = ?, m_story = ? where m_no =?";
        System.out.println(title);
        System.out.println(actor);
        System.out.println(story);
        System.out.println(no);
        try {
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, actor);
            ps.setString(3, story);
            ps.setString(4, no);
            if (ps.executeUpdate() == 1) {
                System.out.println("update movie success");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, ps, null);
        }

    }

    public  void editImgMovie(HttpServletRequest request) throws UnsupportedEncodingException {
    request.setCharacterEncoding("utf-8");

    String path = "C:/dm/dbws_intellij/upload/movieFile";
    Connection con = null;
    PreparedStatement ps = null;
    String sql = "update movie_test set m_title = ?, m_actor = ?, m_img = ?, m_story = ? where m_no =?";
    try {
    MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20, "utf-8",new DefaultFileRenamePolicy());
            String title = mr.getParameter("title");
            String actor = mr.getParameter("actor");
            String newImg = mr.getFilesystemName("newImg");
            String oldImg = mr.getParameter("oldImg");
            String img = newImg;
            if (img == null){
                img = oldImg;
            }
            String story = mr.getParameter("story");
            story = story.replaceAll("\r\n","<br>");
            String no =  mr.getParameter("no");

            System.out.println(title);
            System.out.println(actor);
            System.out.println(img);
            System.out.println(story);
            System.out.println(no);



            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, actor);
            ps.setString(3, img);
            ps.setString(4, story);
            ps.setString(5, no);
            if (ps.executeUpdate() == 1) {
                System.out.println("edit movie success");
                if( newImg != null){
                    File f = new File( path + "/"+oldImg);
                    f.delete();
                }
            }
            request.setAttribute("noo",no);
    }catch (Exception e) {
        e.printStackTrace();
    }finally {
        DBManager.close(con, ps, null);
    }

    }
    public  void paging(int pageNum, HttpServletRequest request){
        request.setAttribute("currentPage",pageNum);

        int total = movies.size();
        int cnt =4;
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

        ArrayList<MovieDTO> items = new ArrayList<>();
        for (int i = start-1; i > end; i--) {
            items.add(movies.get(i));
        }
        request.setAttribute("movies", items);








    }
}
