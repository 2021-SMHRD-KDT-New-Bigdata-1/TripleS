<%@page import="com.VO.WriteVO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/19aa9ed23d.js" crossorigin="anonymous"></script>
<head>
<meta charset="EUC-KR">
<title>CONTENT</title>
 <link rel="stylesheet" href="CSS/Board/css.css">
</head>

<body>
	<%
		//vo ������
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	WriteVO vo2 = (WriteVO)session.getAttribute("vo2");
	
	%>
		
<div data-include-path="header.jsp"></div>
 <section class="section1">
        <div class="board_wrap">
            <div class="board_title">
              <strong>�� ���� �б�</strong>
              <p># ��Ͽ��� ���� Ŭ�� ���� �� or �� ����� �ۼ��� �������� ������</p>
            </div>
            <div class="board_view_wrap">
              <div class="board_view">
              
               <div class="titleview">
               
               <%
               out.print("����  "+vo2.getSubject());
               

               %>
         
               </div>
               <div class="info">
                <dl>
                  <dt>��ȣ</dt>
                  <dd>1</dd>
                </dl>
                <dl>
                  <dt>�ۼ���</dt>
                  <dd>gomdol</dd>
                </dl>
                <dl>
                  <dt>�ۼ���</dt>
                  <dd>2021.09.18</dd>
                </dl>
                <dl>
                  <dt>��ȸ</dt>
                  <dd>33</dd>
                </dl>
               </div>
               <div class="cont">
               
         		<!--  �� ���� -->
         		
               </div>
              </div>
              <div class="CommentBox">
                <div class="comment_option">
                    <h3 class="comment_title"> ��� </h3>
           
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
                                        <a href="#" class="modify">����</a>
                                        <a href="#" class="delete">����</a>
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
                        <strong class="blind">����� �Է��ϼ���</strong>
                        <em class="comment_inbox_name">gomdori</em>
                        <textarea placeholder="����� ���ܺ�����" class="comment_inbox_text" rows="1" style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
                    </div>
                    <div class="comment_attach">
                        <div class="register_box">
                            <a href="#" role="button" class="button btn_register">���</a>
                        </div>
                    </div>
                </div>
              <div class="bt_wrap" id="bt_wrap1">
                <a href="reviewB.html" class="on">���</a>
                 <!-- <a href="edit.html" >����</a>  -->
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
                    xhttp.onreadystatechange = function () {
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