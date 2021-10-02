package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.WriteDAO;

@WebServlet("/likeService2")
public class likeService2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String l = request.getParameter("like");
		String a = request.getParameter("article");
		
		int like = Integer.parseInt(l);
		int article = Integer.parseInt(a);
		System.out.println(like);
		System.out.println(article);
		WriteDAO dao = new WriteDAO();
		
		int data = dao.like(like,article);
		
		
		PrintWriter out= response.getWriter();
		
		out.print(data);
	}

}
