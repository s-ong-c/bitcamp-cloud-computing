package bitcamp.pms.servlet.member;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;


@WebServlet("/member/list")

public class MemberListServlet extends HttpServlet {
    

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            
           MemberDao memberDao = (MemberDao)getServletContext().getAttribute("memberDao");
                       
               List<Member> list = memberDao.selectList();
               
               request.setAttribute("list",list);
               RequestDispatcher rd =
                       request.getRequestDispatcher("/member/list.jsp");
               
               rd.include(request, response);
               
      
            
          
        } catch (Exception e) {
            request.setAttribute("error",e);
            
            RequestDispatcher rd =
                    request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);
  
        }
 
    }

}
