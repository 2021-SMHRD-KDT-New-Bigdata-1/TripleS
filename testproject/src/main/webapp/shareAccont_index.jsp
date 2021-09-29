<%@page import="com.VO.PartiesVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.MemberDAO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Triple_S</title>
<link rel="stylesheet" href="CSS/Login/MyPage.css">
</head>
<body class="manage_comm">

	<div data-include-path="header.jsp"></div>
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

	<div id="kakaoWrap">
		<header id="kakaoHead">
			<div class="wrap_head">
				<nav id="kakaoGnb">
					<h2 class="screen_out">카카오계정 메뉴</h2>
					<ul class="list_gnb">

						<li><a href="myPage_index.jsp" class="link_gnb">내정보 관리</a></li>
						<li><a href="#" class="link_gnb">공유 계정</a></li>
					</ul>
				</nav>
			</div>
		</header>

		<%
		MemberDAO dao = new MemberDAO();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		String memberId = vo.getMemberId();
		ArrayList<PartiesVO> al = dao.share(memberId);
		System.out.println(al.size());
		%>

		<hr class="hide">

		<div id="kakaoContent" class="cont_myinfo" role="main">
			<div id="cMain">
				<div id="mArticle">

					<div id="pageManage" data-role="page" data-url="pageManage"
						class="km-page-active">
						<h2 id="kakaoBody" class="screen_out">카카오계정 본문</h2>
						<h3 id="tit_s">공유 계정</h3>

						<%
						if (al.size() == 0) {
						%>
						<div class="wrap_kaccount">
							<div class="box_manage">
							<div class="share_alert">
							<strong>공유하고 있는 계정이 없습니다.</strong>
							</div>
							</div>
						</div>


						<%
						} else {
						%>

						<%
						for (PartiesVO share : al) {
						%>
						<div class="wrap_kaccount">
							<div class="box_manage">
								<strong class="tit_manage">공유 계정</strong>
								<p class="desc_comm desc_manage">공유 계정에 대한 정보를 확인 할 수 있습니다.</p>
								<div href="/weblogin/account/profile"
									class="link_set link_profile">
									<div class="info_kaccount">
										<div class="thumb_profile">

											<img src="img/login/icon-<%=share.getOtt()%>.png"
												class="img_profile" alt="프로필사진"> <span
												class="img_frame"></span>
										</div>
										<span class="info_accounts"> <strong class="screen_out">이용
												중인 계정</strong> <span class="txt_accounts"><%=share.getOtt()%></span>
											<span class="txt_set_2" style="margin-top: 10px;"> </span>
										</span>
									</div>
									<span class="ico_account ico_arr"></span>
								</div>
							</div>
							<div class="box_set">
								<strong class="tit_manage">계정 정보</strong>
								<p class="desc_comm desc_manage">계정 정보입니다.</p>
								<strong class="tit_set">아이디</strong> <span class="txt_set_2"><%=share.getOttId()%></span>
							</div>
							<div class="box_set">
								<strong class="tit_set">비밀번호</strong> <span class="txt_set_2"><%=share.getOttPw()%></span>
							</div>

						</div>
						<%
						}
						}
						%>
					</div>

				</div>
			</div>
		</div>
		<!-- footer -->
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