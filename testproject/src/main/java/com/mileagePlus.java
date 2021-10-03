package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ManagerDAO;

@WebServlet("/mileagePlus")
public class mileagePlus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		String memberId = request.getParameter("memberId");
		System.out.println("cnt"+cnt);
		System.out.println("mileage"+mileage);
		System.out.println("memberId"+memberId);
		ManagerDAO dao = new ManagerDAO();
		dao.mileagePlus(memberId,mileage,cnt);
		response.sendRedirect("event_view.jsp");
		
	}

}
