

<%@page import="com.VO.replyVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.replyDAO"%>
<%@page import="com.VO.Write3VO"%>
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
Write3VO writevo3 = (Write3VO)session.getAttribute("write3vo");

%>


<div data-include-path="header.jsp"></div>
 <section class="section1">
 	<form action="articlecommentcon1">
        <div class="board_wrap">
            <div class="board_title">
              <strong><a href="community.jsp">이벤트게시판</a></strong>
            </div>
            <div class="board_view_wrap">
              <div class="board_view">
		
               <div class="titleview">
               제목  <%=writevo3.getNotice_title() %>
         		
               </div>
               <div class="info">
                <dl>
                  <dt>번호</dt>
                  <dd id="seq"><%=writevo3.getNotice_seq() %></dd>
                </dl>
                <dl>
                  <dt>작성자</dt>
                  <dd><%=writevo3.getMemberId()%></dd>
                </dl>
                <dl>
                  <dt>작성일</dt>
                  <dd><%=writevo3.getInput_date() %></dd>
                </dl>
                <dl>
                  <dt>조회</dt>
                  <dd><%=writevo3.getCnt() %></dd>
                </dl>
               
               </div>
               <div class="cont">
               <%=writevo3.getNotice_content() %>

               </div>
              <div class="feeling_div">
	
			  
		</div>
        
              <div class="CommentBox">
                <div class="comment_option">
                    <h3 class="comment_title"> 댓글 </h3>
           
                </div>
               <%--  <%if(al.size()==0){
                           
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
                                        <a href="#" class="modify">수정</a>
                                        <a href="#" class="delete">삭제</a>
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
                     <% } %> --%>
                
                       <%if(vo==null){
                           
                        }else{%>
                <div class="CommentWriter">
                    <div class="comment_inbox"> 
                        <strong class="blind">댓글을 입력하세요</strong>
                        <em class="comment_inbox_name"><%=vo.getNickname() %></em>
                        <textarea name="reply" placeholder="댓글을 남겨보세요" class="comment_inbox_text" rows="1" style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
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
    margin-top: -20px;
    margin-left: auto;">
                        </div>
                    </div>
                </div>
                 <% } %>
                   <div class="bt_wrap" id="bt_wrap1">
                 <%if(vo==null){
					
					out.print("<a href='review_board.jsp' class='on'>목록</a>");
				
				}else{
					if(vo.getMemberId().equals(writevo3.getMemberId())){%>
					<a href="edit.jsp?id=<%=writevo3.getNotice_seq() %>" >수정</a>
					<%out.print("<a href='review_board.jsp' class='on' >목록</a>");
					}else{
						out.print("<a href='review_board.jsp' class='on'>목록</a>");
					}
				}

				%>
            </div> 
                 
        </div>
</form>
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