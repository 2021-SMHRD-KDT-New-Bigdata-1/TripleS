package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ManagerDAO;

@WebServlet("/memberDelete")
public class memberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		System.out.println("������?"+memberId);
		ManagerDAO dao = new ManagerDAO();
		dao.delete(memberId);
		response.sendRedirect("member_mg.jsp");
	}

}
