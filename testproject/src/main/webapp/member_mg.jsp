<%@page import="com.DAO.ManagerDAO"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.WriteVO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/19aa9ed23d.js"
	crossorigin="anonymous"></script>
<head>
<meta charset="EUC-KR">
<title>리뷰게시판</title>

<link rel="stylesheet" href="CSS/Board/css.css">
<link rel="stylesheet" href="CSS/main/board.css">
<link rel="stylesheet" href="CSS/Board/tab.css">


</head>
<body>

	<div data-include-path="header.jsp"></div>
	<%
	//vo 가져옴
	MemberVO vo = (MemberVO) session.getAttribute("vo");
	ManagerDAO dao = new ManagerDAO();
	ArrayList<MemberVO> list = dao.select();
	%>
	<!--  -->
	<section class="section1">

		<nav>
			<ul>
				<li class="active"><a href="review_board2.jsp"
					style="font-size: 20px;">회원 관리</a></li>

				<!-- <p> 게시판 용도에 맞지 않는 글은 운영자에 의해 삭제될 수 있습니다.</p> -->
				<li><a href="event_mg.jsp" style="font-size: 20px;">이벤트
						관리</a></li>

			</ul>

			</div>



			<!--  -->
			<div class="board_wrap">
				<div class="board_title">


					<div class="inputTypeText">

						<div class="search1">
							<input type="text" placeholder="Search"> <i
								class="fas fa-search"></i>
						</div>
					</div>
					<div class="board_list_wrap">
						<div class="board_list">
							<div class="top">
								<div class="num">아이디</div>
								<div class="writer">닉네임</div>
								<div class="date">핸드폰 번호</div>
								<div class="good">가입일자</div>
								<div class="count">마일리지</div>
							</div>


							<%
							int count = dao.selectCnt();
							String tempStart = request.getParameter("page");
							int startPage = 1;
							int onePageCnt = 10;

							count = (int) Math.ceil((double) count / 10);

							if (tempStart != null) {
								startPage = startPage + ((Integer.parseInt(tempStart) - 1) * 10);
								onePageCnt = onePageCnt + ((Integer.parseInt(tempStart) - 1) * 10) + 1;
							}
							%>

							<%
							for (int i = startPage; i <= onePageCnt; i++) {
								if (i < list.size()) {
							%>
							<form action="memberDelete">
							<div>
							<div class="id">
								<input name="memberId" type="text" value="<%=list.get(i).getMemberId()%>"></input>
							</div>
								<div class="num"><%=list.get(i).getMemberId()%></div>

								<div class="writer"><%=list.get(i).getNickname()%></div>


								<div class="date"><%=list.get(i).getPhone()%></div>
								<div class="good"><%=list.get(i).getEntryDate()%></div>
								<div class="count"><%=list.get(i).getMileage()%></div>
								<div class="bt_wrap" id="bt_wrap1">
									<button class='on' type="submit">삭제</button>
								</div>

							</div>
							</form>

							<%
							} else {
							break;
							}
							}
							%>

						</div>


						<div class="board_page">
							<a href="#" class="bt first"><<</a> <a href="#" class="bt prev"><<</a>


							<%
							for (int j = 1; j <= count; j++) {
							%>
							<a href="member_mg.jsp?page=<%=j%>" class="num on"><%=j%></a>

							<%
							}
							%>

							<a href="#" class="bt">></a> <a href="#" class="bt">>></a>
						</div>


					</div>
		</nav>


	</section>

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
	<script >

		var nav = $("nav");
		var line = $("<div />").addClass("line");

		line.appendTo(nav);

		var active = nav.find(".active");
		var pos = 0;
		var wid = 0;

		if (active.length) {
			pos = active.position().left;
			wid = active.width();
			line.css({
				left : pos,
				width : wid
			});
		}

		nav.find("ul li a").click(
				function(e) {
					e.preventDefault();
					if (!$(this).parent().hasClass("active")
							&& !nav.hasClass("animate")) {
						nav.addClass("animate");

						var _this = $(this);

						nav.find("ul li").removeClass("active");

						var position = _this.parent().position();
						var width = _this.parent().width();

						if (position.left >= pos) {
							line.animate({
								width : position.left - pos + width
							}, 300, function() {
								line.animate({
									width : width,
									left : position.left
								}, 150, function() {
									nav.removeClass("animate");
								});
								_this.parent().addClass("active");
							});
						} else {
							line.animate({
								left : position.left,
								width : pos - position.left + wid
							}, 300, function() {
								line.animate({
									width : width
								}, 150, function() {
									nav.removeClass("animate");
								});
								_this.parent().addClass("active");
							});
						}

						pos = position.left;
						wid = width;
					}
				});
	</script>

	<div data-include-path="footer.html"></div>
</body>
</html>