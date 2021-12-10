package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*�Ʒ� Ŭ������ ��Ƽ��/��Ƽ�� ���ð��� �÷������� �����Ͽ� �޾ƿ� ���� �´� html �������� �̵������ִ� Ŭ�����̴� 
 *html�� �̵��ϱ��� ������ �����ؼ� ���ǿ� ������ ���̵�� ������ �� �ְ� ���ش�. */

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
