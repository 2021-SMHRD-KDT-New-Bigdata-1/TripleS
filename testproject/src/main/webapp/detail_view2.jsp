<%@page import="com.VO.replyVO"%>
<%@page import="com.DAO.replyDAO"%>
<%@page import="com.DAO.write2DAO"%>
<%@page import="com.VO.Write2VO"%>
<%@page import="java.util.ArrayList"%>
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
<script src="js/jquery-3.6.0.min.js"></script>
</head>

<body>
<%
MemberVO vo = (MemberVO) session.getAttribute("vo");
Write2VO writevo = (Write2VO)session.getAttribute("write2vo");
replyDAO rdao = new replyDAO();
ArrayList<replyVO> al = rdao.dselect(writevo.getArticles_seq(),"commu");
int cnt = (int)session.getAttribute("cnt");
%>


<div data-include-path="header.jsp"></div>
 <section class="section1">
 	<form action="articlecommentcon1">
        <div class="board_wrap">
            <div class="board_title">
              <strong><a href="community.jsp">�����Խ���</a></strong>
            </div>
            <div class="board_view_wrap">
              <div class="board_view">
		
               <div class="titleview">
               ����  <%=writevo.getSubject() %>
         		
               </div>
               <div class="info">
                <dl>
                  <dt>��ȣ</dt>
                  <dd id="seq"><%=writevo.getArticles_seq() %></dd>
                </dl>
                <dl>
                  <dt>�ۼ���</dt>
                  <dd><%=writevo.getNickname()%></dd>
                </dl>
                <dl>
                  <dt>�ۼ���</dt>
                  <dd><%=writevo.getReg_date() %></dd>
                </dl>
                <dl>
                  <dt>��ȸ</dt>
                  <dd><%=cnt %></dd>
                </dl>
               <dl>
                  <dt>��õ��</dt>
                  <dd id="like"><%=writevo.getRec_cnt() %></dd>
                </dl>
               </div>
               <div class="cont">
               <%=writevo.getContent() %>

               </div>
              <div class="feeling_div">
			<div class="like">
			    <button class="feeling_a" type="button" onclick="like()">
			      <i class="fa fa-heart-o"> Like</i>    
			 	</button>
			 	<!-- <button type="button" onclick="pwFind()" >��õ</button> -->
			  </div>
			  
		</div>
        
              <div class="CommentBox">
                <div class="comment_option">
                    <h3 class="comment_title"> ��� </h3>
           
                </div>
                <%if(al.size()==0){
                           
                 }else{%>
                <ul class="comment_list">
                    <li class="CommentItem">
                        <div class="comment_area">
                        <%for(replyVO reply:al){ %>
                            <div class="comment_box">
                                <div class="comment_nick_box">
                                    <div class="comment_nick_info">
                                        <a href="#" role="button" class="comment_nickname"> <%=reply.getNickname() %></a>
                                    </div>
                                    <div class="md">
                                        <a href="#" class="modify">����</a>
                                        <a href="#" class="delete">����</a>
                                    </div>
                                 
                                </div>
                                <div class="comment_text_box">
                                    <p class="comment_text_view">
                                        <span class="text_comment" > <%=reply.getReply_comment() %></span>
                                    </p>
                                </div>
                                <div class="comment_info_box">
                                    <span class="comment_info_date"><%=reply.getReg_date() %></span>
                                </div>
                            </div>
                            <%} %>
                        </div>
                    </li>
                </ul>
                     <% } %>
                
                       <%if(vo==null){
                           
                        }else{%>
                <div class="CommentWriter">
                    <div class="comment_inbox"> 
                        <strong class="blind">����� �Է��ϼ���</strong>
                        <em class="comment_inbox_name"></em>
                        <textarea name="reply" placeholder="����� ���ܺ�����" class="comment_inbox_text" rows="1" style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
                    </div>
                    <div class="comment_attach">
                       </div>
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
                </div>
                 <% } %>
        </div>
</form>
    </section>
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
 <script>
 function like(){
		
		var article = <%=writevo.getArticles_seq() %>
		var like = <%=writevo.getRec_cnt() %>
	<%-- 	alert(like)
		alert(article)
		
		alert(<%=writevo.getArticles_seq() %>); --%>
		
		/* �̸��� */
		$.ajax({
			// type : ������ ���� ���
			// data : ������ ���� ������{Ű:��}
			// url : �����͸� ���� ����������
			// dataType : ������� ������ Ÿ��
			type : "post", 
			data : {like:like,article:article},
			url : "likeService",
			dataType : "text",
			success : function(data){
				var sp = document.getElementById("like");
				
				if (data!=null) {
					sp.innerHTML = data
				}else{
					sp.innerHTML = "����"
				}
			},
			error : function(){
				alert("��Ž���");
			}
		})
	}
 </script>
</html>