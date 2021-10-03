package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ManagerDAO;
import com.DAO.replyDAO;
import com.VO.replyVO;

@WebServlet("/best_event")
public class best_event extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ManagerDAO dao = new ManagerDAO();
		String memberId=request.getParameter("memberId");
		int cnt= Integer.parseInt( request.getParameter("cnt"));
		
				
	}

}
