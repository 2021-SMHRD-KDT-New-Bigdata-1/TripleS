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
					<h3>��ȭ��</h3>
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
					<dt>��� : <%out.print(vo.getActor());%></dt>
					<dt>�帣 : <%out.print(vo.getGenre());%></dt>
					<dt>�ð� : <%out.print(vo.getRunning_time());%></dt>
					<dt>���� : <%out.print(vo.getUpload_date());%></dt>
				</dl>
			</div>
			<div class="box-story-top">
				<h3>�ٰŸ�</h3>
			</div>
			<div class="sect-story-movie">
				<br>
				<P>
					<STRONG><EM><SPAN style="FONT-FAMILY: sans-serif">����
								������� ���뱳ü!</SPAN></EM></STRONG>
				</P>
				<P>
					<STRONG><EM><SPAN style="FONT-FAMILY: sans-serif">���������
								�Ƿ��� ���� ���� �� ����?��</SPAN></EM></STRONG>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">&nbsp;</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">���ú� ���� ��� ����� ��Ÿũ��(�ι�Ʈ
						�ٿ�� �ִϾ�)���� ��Ź�Ǿ�</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">����� Ȱ���� ���ƴ� �����̴��� ������
						��Ŀ��(�� Ȧ����).</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">�׿��� ���ο� ��Ʈ�� ������ �����
						��Ÿũ���� ������ ���� ���� ����� �����Ѵ�.</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">������ �㼼�� ���ǰ����� �ʶ� ��ģ
						������ ��Ŀ����</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">������ �����ϴ� ������ ��
						����ó��(����Ŭ Űư)�� �¼��� �ϴµ���</SPAN>
				</P>
				<P>
					<SPAN style="FONT-FAMILY: sans-serif">&nbsp;</SPAN>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">������
							������� �� �� ���� �����̴���</SPAN></STRONG>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">��������
							������ ���ϰ� ���� �����̴���</SPAN></STRONG>
				</P>
				<P>
					<STRONG><SPAN style="FONT-FAMILY: sans-serif">�״� ����
							������ ����η� �ŵ쳯 �� ���� ���ΰ�!</SPAN></STRONG>
				</P>
				<br>
			</div>
		</div>

		<div class="CommentBox">
			<div class="comment_option">
				<h3 class="comment_title">���</h3>

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
									<a href="#" class="modify">����</a> <a href="#" class="delete">����</a>
								</div>

							</div>
							<div class="comment_text_box">
								<p class="comment_text_view">
									<span class="text_comment">�� ��������</span>
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
					<strong class="blind">����� �Է��ϼ���</strong> <em
						class="comment_inbox_name">gomdori</em>
					<textarea placeholder="����� ���ܺ�����" class="comment_inbox_text"
						rows="1"
						style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
				</div>
				<div class="comment_attach">
					<div class="register_box">
						<a href="#" role="button" class="button btn_register">���</a>
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