<%@page import="com.VO.Write2VO"%>
<%@page import="com.VO.WriteVO"%>
<%@page import="com.DAO.ManagerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.Write3VO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/19aa9ed23d.js"
	crossorigin="anonymous"></script>
<head>
<meta charset="EUC-KR">
<title>CONTENT</title>
<link rel="stylesheet" href="CSS/Board/css.css">
<link rel="stylesheet" href="CSS/main/best.css">
</head>

<body>
	<%
	//vo ������
	MemberVO vo = (MemberVO) session.getAttribute("vo");
	Write3VO writevo = (Write3VO) session.getAttribute("write3vo");
	%>

	<div data-include-path="header.jsp"></div>

	<section class="section1">
		<div class="board_wrap">
			<div class="board_title">
				<strong>�̺�Ʈ�Խ���</strong>
			</div>
			<div class="board_view_wrap">
				<div class="board_view">

					<div class="titleview">

						<%
						out.print("����  " + writevo.getNotice_title());
						%>

					</div>
					<div class="info">
						<dl>
							<dt>��ȣ</dt>
							<dd>
								<%
								out.print(writevo.getNotice_seq());
								%>
							</dd>
						</dl>
						<dl>
							<dt>�ۼ���</dt>
							<dd>������</dd>
						</dl>
						<dl>
							<dt>�ۼ���</dt>
							<dd>
								<%
								out.print(writevo.getInput_date());
								%>
							</dd>
						</dl>
						<dl>
							<dt>��ȸ</dt>
							<dd>
								<%
								out.print(writevo.getCnt());
								%>
							</dd>
						</dl>
					</div>
					<div class="cont">

						<%
						out.print(writevo.getNotice_content());
						%>

					</div>
				</div>
				<div class="CommentBox">
					<div class="comment_option">
						<h3 class="comment_title">�̺�Ʈ �����</h3>

					</div>
					<ul class="comment_list">
						<li class="CommentItem">
							<div class="comment_area">
								<div class="comment_box"></div>
							</div>
						</li>
					</ul>
					
						<div class="board_list_wrap">
							<div class="board_list">
								<div class="top">
									<div class="title">�Խñ� ����</div>
									<div class="num">���̵�</div>
									<div class="writer">�г���</div>
									<div class="good">��������</div>
									<div class="count">���ϸ���</div>
									<div class="date">�߰� �� ���ϸ�����</div>
								</div>
								<%
								ManagerDAO dao = new ManagerDAO();
								ArrayList<WriteVO> best_1 = dao.select_best1();
								ArrayList<Write2VO> best_2 = dao.select_best2();
								MemberVO b_1 =dao.bSelect(best_1.get(1).getMemberId());
								MemberVO b_2 =dao.bSelect(best_2.get(1).getMemberId());
								%>


								<form action="mileagePlus">
									<div>
										<div class="title">����Խ���</div>
										<div class="num"><%=b_1.getMemberId() %></div>
										<div class="id">
											<input name="memberId" type="text" value="<%=b_1.getMemberId() %>"></input>
										</div>

										<div class="writer"><%=b_1.getNickname() %></div>
										<div class="good"><%=b_1.getEntryDate() %></div>
										<div class="count"><%=b_1.getMileage() %></div>
										<div class="id">
											<input name="mileage" type="text" value="<%=b_1.getMileage() %>"></input>
										</div>
										<div class="mileage">
											<input name="cnt" type="text" placeholder="���ϸ���"></input>
										</div>
										<div class="bt_wrap" id="bt_wrap1">
											<button class='on' type="submit">�߰�</button>
										</div>

									</div>
								</form>
								<form action="mileagePlus">
									<div>
										<div class="title">�����Խ���</div>
										<div class="num"><%=b_2.getMemberId() %></div>
										<div class="id">
											<input name="memberId" type="text" value="<%=b_2.getMemberId() %>"></input>
										</div>

										<div class="writer"><%=b_2.getNickname() %></div>
										<div class="good"><%=b_2.getEntryDate() %></div>
										<div class="count"><%=b_2.getMileage() %></div>
										<div class="id">
											<input name="mileage" type="text" value="<%=b_2.getMileage() %>"></input>
										</div>
										<div class="mileage">
											<input name="cnt" type="text" placeholder="���ϸ���"></input>
										</div>
										<div class="bt_wrap" id="bt_wrap1">
											<button class='on' type="submit">�߰�</button>
										</div>

									</div>
								</form>


							</div>




						</div>
					</form>
					<%--                 <div class="CommentWriter">
                    <div class="comment_inbox"> 
                        <strong class="blind">����� �Է��ϼ���</strong>
                        <em class="comment_inbox_name"><% out.print(writevo.getMemberId()); %></em>
                        <textarea name="reply" placeholder="����� ���ܺ�����" class="comment_inbox_text" rows="1" style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
                    </div>
                    <div class="comment_attach">
                        <div class="register_box">
                            <input type ="submit" style="display: inline-block;
    min-width: 46px;
    height: 32px;
    font-size: 13px;
    color: black;
    vertical-align: top;
    margin-top: -24px;
    margin-left: auto";>
                        </div>
                    </div>
                </div> --%>
					<div class="bt_wrap" id="bt_wrap1">
						<%
						if (vo == null) {

							out.print("<a href='event_mg.jsp' class='on'>���</a>");

						} else {
							if (vo.getMemberId().equals(writevo.getMemberId())) {
						%>
						<a href="edit.jsp?id=<%=writevo.getNotice_seq()%>">����</a>
						<%
						out.print("<a href='event_mg.jsp' class='on'>���</a>");
						} else {
						out.print("<a href='event_mg.jsp' class='on'>���</a>");
						}
						}
						%>
					</div>
				</div>
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
	<div data-include-path="footer.html"></div>
</body>
</html>