
<%@page import="com.VO.VideoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.VideoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel='stylesheet' href='CSS/movie/movie.css'>
<title>Insert title here</title>
</head>
<body>
<% 
VideoDAO dao = new VideoDAO();
ArrayList<VideoVO> al = dao.select();
System.out.print(al.size());
%>
	<div data-include-path="header.jsp"></div>

	<script>
		function includeHTML() {
			var z, i, elmnt, file, xhttp;
			z = document.getElementsByTagName("*");
			for (i = 0; i < z.length; i++) {
				elmnt = z[1];
				file = elmnt.getAttribute("include-html");
				if (file) {
					xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							elmnt.innerHTML = this.responseText;
							elmnt.removeAttribute("include-html");
							includeHTML();
						}
					}
					xhttp.open("GET", file, true);
					xhttp.send();
					return;
				}
			}
		}
		

		includeHTML();
	</script>

	<!-- 여기부터 작업 공간 -->
	<section class="movie_serch1">
		<div class="movie_top">
			<ul class="movie_top_ul">
				<form action="movie_search.jsp">
					<li><a href="movieN.jsp"><img src="img/icon/netflic.png" id="nicon"></a></li>
					<li><a href="movieH.jsp"><img src="img/icon/watha.png" id="Hicon"></a></li>
					<li><a href="movieW.jsp"><img src="img/icon/wavve.png" id="Wicon"></a></li>
					<li><a href="#"><img src="img/icon/tiving.png" id="Ticon"></a></li>
					<li><input type="text" placeholder="검색어를 입력해주세요." id="seachwindow" name = "title"></li>
					<input type="image" id="seachicon" src="img/icon/pngegg.png">
				</form>
			</ul>
		</div>
		<table class="movie_table">
			<% 	int a = 0;
				int b = 8;
				for (int i = 0; i< al.size()/8; i++) {
				out.print("<tr>");
				for (int e = a; e < b; e++) {
					out.print("<td><a href='movieCon.do?filename="+al.get(e).getVideo_filename()+"'><img src='img/mini1/"+al.get(e).getVideo_filename()+".jpg'></a></td>");
				}
				out.print("<tr>");
				a += 8;
				b += 8;
			}
			%>
		</table>
	</section>


	<div data-include-path="footer.html"></div>

	<script>
		window.addEventListener('load', function() {
			var allElements = document.getElementsByTagName('*');
			Array.prototype.forEach.call(allElements, function(el) {
				var includePath = el.dataset.includePath;
				if (includePath) {
					var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							el.outerHTML = this.responseText;
						}
					};
					xhttp.open('GET', includePath, true);
					xhttp.send();
				}
			});
		});
		
	</script>

</body>
</html>