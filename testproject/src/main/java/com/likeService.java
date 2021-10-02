package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.write2DAO;

@WebServlet("/likeService")
public class likeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String l = request.getParameter("like");
		String a = request.getParameter("article");
		
		int like = Integer.parseInt(l);
		int article = Integer.parseInt(a);
		System.out.println(like);
		System.out.println(article);
		write2DAO dao = new write2DAO();
		
		int data = dao.like(like,article);
		
		
		PrintWriter out= response.getWriter();
		
		out.print(data);
	}

}
