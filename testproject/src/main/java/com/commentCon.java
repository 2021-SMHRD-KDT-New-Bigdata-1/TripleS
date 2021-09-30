package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.replyDAO;
import com.VO.MemberVO;
import com.VO.VideoVO;

@WebServlet("/commentCon")
public class commentCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("reply");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("vo");
		String memberId = mvo.getMemberId();
		String nickname = mvo.getNickname();
		VideoVO vvo = (VideoVO)session.getAttribute("vvo");
		String video_seq = vvo.getVideo_filename();
		replyDAO rdao = new replyDAO();
		int cnt = rdao.insert(9999, comment, memberId, video_seq,nickname);
		
		if (cnt > 0) {
			response.sendRedirect("movie_detail.jsp");
			System.out.println("댓글 작성 성공");
		}

	}

}
