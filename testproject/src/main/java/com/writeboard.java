package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.WriteDAO;

@WebServlet("/writeboard")
public class writeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("euc-kr");
		
		String subject = request.getParameter("subject");
		String content= request.getParameter("content");
		String img_pic1= request.getParameter("img_pic1");
		String img_pic2= request.getParameter("img_pic2");
		String img_pic3= request.getParameter("img_pic3");

		

		WriteDAO dao = new WriteDAO();
		
		int cnt = dao.write(subject, content, img_pic1, img_pic2, img_pic3);
		
		if (cnt>0) {
			System.out.println("글 작성 성공");;
		}
		
		
		
	}

}
