<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<header id="all_header">
		<div class="header-wrap">
			<div class="container">
				<ul class="gnb list">
					<li class="gnb-menu"><a href="movie.jsp"><h2>영화검색</h2></a>
					</li>
					<li class="gnb-menu"><a href="matching_start.html"><h2>파티매칭</h2></a>
					</li>
					<li class="gnb-menu">
						<h1 class="logo">
							<a href="main_index.html"></a>
						</h1>
					</li>

					<li class="gnb-menu"><a href="#"><h2>게시판</h2></a>
						<ul class="sub-gnb">
							<li><a href="review_board.jsp">리뷰게시판</a></li>
							<li><a href="community_board.html">자유게시판</a></li>
							<li><a href="event_board.html">이벤트게시판</a></li>
						</ul></li>
					<li class="gnb-menu"><a href="/child/sub/inquiry/"><h2>문의사항</h2></a>
					</li>
				</ul>
				
				<%MemberVO vo = (MemberVO) session.getAttribute("vo");%>
				
				<ul class="sns-ul">
				<%if(vo==null){
					out.print("<button class='button'>");
					out.print("<a href='login_index.html'>로그인 | </a>");
					out.print("</button>");
					out.print("<button class='button'>");
					out.print("<a href='join_index.html'>회원가입</a>");
					out.print("</button>");
				}else{
					out.print("<button class='button'>");
					out.print("<h3 class='nickname'>"+vo.getNickname()+"님</h1>");
					out.print("<button class='button'>");
					out.print("<a href='myPage_index.jsp'>마이페이지 | </a>");
					out.print("</button>");
					out.print("<button class='button'>");
					out.print("<a href='LogOutService'>로그아웃</a>");
					out.print("</button>");
				}

				%>
				
				<!-- <button class="button">
					<a href="login_index.html">로그인 |</a>
				</button>
				<button class="button">
					<a href="join_index.html">회원가입</a>
				</button> -->
				</ul>
			</div>
		</div>

		<div class="menu">
			<button class="burger-menu" type="button" role="button"
				aria-pressed="false">
				<div class="burger-wrap">
					<span class="burger-top"></span> <span class="burger-middle"></span>
					<span class="burger-bottom"></span>
				</div>
			</button>
		</div>


	</header>
</body>
</html>