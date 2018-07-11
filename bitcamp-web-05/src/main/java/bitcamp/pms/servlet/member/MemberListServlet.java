package bitcamp.pms.servlet.member;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Param;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;


@WebServlet("/member/list")

public class MemberListServlet extends HttpServlet {
    

    

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        //DB 에서 가져올 데이터의 페이지 정보 
        HashMap<String, Object> params= new HashMap<>();
        
        if(request.getParameter("page") !=null &&
              request.getParameter("size") != null){
            int page= Integer.parseInt(request.getParameter("page"));
            int size=Integer.parseInt(request.getParameter("size"));
            
            System.out.println(page+"page");
            System.out.println(size+"size?");
            
            params.put("startIndex",(page-1) * size);
            params.put("pageSize", size);
            
        }
        try {
            
           MemberDao memberDao = (MemberDao)getServletContext().getAttribute("memberDao");
                       
               System.out.println("1");
               List<Member> list = memberDao.selectList(params);
               System.out.println("2");
               System.out.println("리스트 불러라");
               request.setAttribute("list", list);
               System.out.println("3");
               RequestDispatcher rd = 
                       request.getRequestDispatcher("/member/list.jsp");
               
               rd.include(request, response);
          
        } catch (Exception e) {
            request.setAttribute("error", e);
            System.out.println("<목록 가져오기 실패!");
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            
            rd.forward(request, response);
            
            e.printStackTrace();
        }
     
    }

}
