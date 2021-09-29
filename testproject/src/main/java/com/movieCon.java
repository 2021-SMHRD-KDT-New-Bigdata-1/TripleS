package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.VideoDAO;
import com.VO.VideoVO;

@WebServlet("/movieCon.do")
public class movieCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String filename = request.getParameter("filename");
		
		VideoDAO dao = new VideoDAO();
		VideoVO vo =  dao.oneselect(filename);
		
		if (vo != null) {
			session.setAttribute("vvo", vo);
			response.sendRedirect("movie_detail.jsp");
			System.out.println("연결성공");
		}
		
	}

}
