package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberUpdateController implements PageController {
    MemberDao memberDao;

    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(id);
        System.out.println(email);
        System.out.println(password);
        response.setContentType("text/html;charset=UTF-8");

        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));

        if (memberDao.update(member) == 0) {
            return "/member/updatefail.jsp";

        } else {
            return "redirect:list";

        }
    }

}