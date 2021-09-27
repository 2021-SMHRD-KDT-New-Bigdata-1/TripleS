<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="com.VO.VideoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.VideoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel='stylesheet' href='CSS/movie/movie_detail.css'>
</head>
<body>
	<%
	VideoVO vo = (VideoVO)session.getAttribute("vo");
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

	<section class="movie_serch1">
		<div id="contents">
			<div class="wrap-movie-detail" id="select_main">
				<div class="tit-heading-wrap">
					<h3>영화상세</h3>
				</div>
			</div>
			<div class="sect-base-movie">
				<div class="box-image">
					<span class="thumb-image"><img src="img/spider/1.jpg" alt=""></span>
				</div>
			</div>
			<div class="box-contents">
				<div class="title">
					<strong><%out.print(vo.getVideo_title());%></strong>
				</div>
			</div>
			<div class="spec">
				<dl>
					<dt>배우 : <%out.print(vo.getActor());%></dt>
					<dt>장르 : <%out.print(vo.getGenre());%></dt>
					<dt>시간 : <%out.print(vo.getRunning_time());%></dt>
					<dt>개봉 : <%out.print(vo.getUpload_date());%></dt>
				</dl>
			</div>
			<div class="box-story-top">
				<h3>줄거리</h3>
			</div>
			<div class="sect-story-movie">
				<br>
				<P>
					<STRONG><EM><SPAN style="FONT-FAMILY: sans-serif">마블
								히어로의 세대교체!</SPAN></EM></STRONG>
				</P>
				<P>
					<STRONG><EM><SPAN style="FONT-FAMILY: sans-serif">“어벤져스가
								되려면 시험 같은 거 봐요?”</SPAN></EM></STRONG>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">&nbsp;</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">‘시빌 워’ 당시 ‘토니 스타크’(로버트
						다우니 주니어)에게 발탁되어</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">대단한 활약을 펼쳤던 스파이더맨 ‘피터
						파커’(톰 홀랜드).</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">그에게 새로운 수트를 선물한 ‘토니
						스타크’는 위험한 일은 하지 말라며 조언한다.</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">하지만 허세와 정의감으로 똘똘 뭉친
						‘피터 파커’는</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">세상을 위협하는 강력한 적
						‘벌처’(마이클 키튼)에 맞서려 하는데…</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">&nbsp;</SPAN>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">아직은
							어벤져스가 될 수 없는 스파이더맨</SPAN></STRONG>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">숙제보다
							세상을 구하고 싶은 스파이더맨</SPAN></STRONG>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">그는 과연
							진정한 히어로로 거듭날 수 있을 것인가!</SPAN></STRONG>
				</P>
				<br>
			</div>
		</div>

		<div class="CommentBox">
			<div class="comment_option">
				<h3 class="comment_title">댓글</h3>

			</div>
			<ul class="comment_list">
				<li class="CommentItem">
					<div class="comment_area">
						<div class="comment_box">
							<div class="comment_nick_box">
								<div class="comment_nick_info">
									<a href="#" role="button" class="comment_nickname">gomdol</a>
								</div>
								<div class="md">
									<a href="#" class="modify">수정</a> <a href="#" class="delete">삭제</a>
								</div>

							</div>
							<div class="comment_text_box">
								<p class="comment_text_view">
									<span class="text_comment">난 곰도리야</span>
								</p>
							</div>
							<div class="comment_info_box">
								<span class="comment_info_date"> 2021.09.23 15:24</span>

							</div>
						</div>
					</div>
				</li>
			</ul>
			<div class="CommentWriter">
				<div class="comment_inbox">
					<strong class="blind">댓글을 입력하세요</strong> <em
						class="comment_inbox_name">gomdori</em>
					<textarea placeholder="댓글을 남겨보세요" class="comment_inbox_text"
						rows="1"
						style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
				</div>
				<div class="comment_attach">
					<div class="register_box">
						<a href="#" role="button" class="button btn_register">등록</a>
					</div>
				</div>
			</div>
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