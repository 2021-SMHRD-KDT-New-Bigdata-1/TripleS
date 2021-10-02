package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.WriteDAO;

@WebServlet("/deleteservice.do")
public class deleteservice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int seq = Integer.parseInt(request.getParameter("seq"));
		WriteDAO dao = new WriteDAO();
		int cnt = dao.delete_board(seq);
		
		if (cnt > 0) {
			response.sendRedirect("review_board.jsp");
		}
		
	}

}
