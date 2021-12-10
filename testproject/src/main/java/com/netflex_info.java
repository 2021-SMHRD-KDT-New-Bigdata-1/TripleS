package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*아래 클래스는 파티장/파티원 선택값과 플랫폼별로 구분하여 받아온 값에 맞는 html 페이지로 이동시켜주는 클래스이다 
 *html로 이동하기전 세션을 생성해서 세션에 저장한 아이디로 구별할 수 있게 해준다. */

@WebServlet("/netflex_info")
public class netflex_info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ott = request.getParameter("OTT");
		String hs = request.getParameter("matching");

		if (ott.equals("netflex") && hs.equals("host")) {

			HttpSession session = request.getSession();
			session.setAttribute("ott", ott);
			response.sendRedirect("host_netflex.html");
		} else if (ott.equals("watcha") && hs.equals("host")) {

			HttpSession session = request.getSession();
			session.setAttribute("ott", ott);
			response.sendRedirect("host_watcha.html");
		} else if (ott.equals("wavve") && hs.equals("host")) {

			HttpSession session = request.getSession();
			session.setAttribute("ott", ott);
			response.sendRedirect("host_wavve.html");
		} else if (ott.equals("tiving") && hs.equals("host")) {

			HttpSession session = request.getSession();
			session.setAttribute("ott", ott);
			response.sendRedirect("host_tiving.html");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("ott", ott);
			response.sendRedirect("pay.html");
		}
	}

}
