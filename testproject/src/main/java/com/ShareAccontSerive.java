package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MemberDAO;
import com.VO.MemberVO;

@WebServlet("/ShareAccontSerive")
public class ShareAccontSerive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		String memberId = vo.getMemberId();
		MemberVO share = dao.share(memberId);

		if (share != null) {
			session.setAttribute("share", share);
			response.sendRedirect("main_index.html");
		} else {
			System.out.println("½ÇÆÐ!");
			response.sendRedirect("login_index.html");

		}
	}

}
