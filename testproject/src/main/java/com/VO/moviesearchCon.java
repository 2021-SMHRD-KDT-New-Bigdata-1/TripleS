package com.VO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.VideoDAO;

@WebServlet("/moviesearchCon")
public class moviesearchCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		VideoDAO dao = new VideoDAO();
		ArrayList<VideoVO> al = dao.search(title);

		if (al != null) {
			session.setAttribute("al", al);
			session.setAttribute("title", title);
			response.sendRedirect("movie_search.jsp");
			System.out.println("연결성공");
		}
		
		
		
		
		
	}

}
