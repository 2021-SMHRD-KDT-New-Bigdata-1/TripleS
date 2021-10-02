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
</head>

<body>
	<%
		//vo 가져옴
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	Write3VO vo2 = (Write3VO)session.getAttribute("vo2");
	

	%>
		
<div data-include-path="header.jsp"></div>

 <section class="section1">
        <div class="board_wrap">
            <div class="board_title">
              <strong>이벤트게시판</strong>
            </div>
            <div class="board_view_wrap">
              <div class="board_view">
              
               <div class="titleview">
               
               <%
               out.print("제목  "+vo2.getNotice_title());
               

               %>
         
               </div>
               <div class="info">
                <dl>
                  <dt>번호</dt>
                  <dd><%out.print(vo2.getNotice_seq()); %></dd>
                </dl>
                <dl>
                  <dt>작성자</dt>
                  <dd><%out.print(vo2.getMemberId()); %></dd>
                </dl>
                <dl>
                  <dt>작성일</dt>
                  <dd><%out.print(vo2.getInput_date()); %></dd>
                </dl>
                <dl>
                  <dt>조회</dt>
                  <dd><%out.print(vo2.getCnt()); %></dd>
                </dl>
               </div>
               <div class="cont">
               
         		<% out.print(vo2.getNotice_content()); %>
         		
               </div>
              </div>
              <div class="CommentBox">
                <div class="comment_option">
                    <h3 class="comment_title"> 댓글 </h3>
           
                </div>
                <ul class="comment_list">
                    <li class="CommentItem">
                        <div class="comment_area">
                            <div class="comment_box">
                               <!--  <div class="comment_nick_box">
                                    <div class="comment_nick_info">
                                        <a href="#" role="button" class="comment_nickname"> #댓글 작성자 id가 들어감</a>
                                    </div>
                                    <div class="md">
                                        <a href="#" class="modify">수정</a>
                                        <a href="#" class="delete">삭제</a>
                                    </div>
                                 
                                </div>
                                <div class="comment_text_box">
                                    <p class="comment_text_view">
                                        <span class="text_comment" > #댓글내용이 들어감</span>
                                    </p>
                                </div>
                                <div class="comment_info_box">
                                    <span class="comment_info_date">#날짜가 들어감</span>
                               
                                </div> -->
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="CommentWriter">
                    <div class="comment_inbox"> 
                        <strong class="blind">댓글을 입력하세요</strong>
                        <em class="comment_inbox_name"><% out.print(vo2.getMemberId()); %></em>
                        <textarea name="reply" placeholder="댓글을 남겨보세요" class="comment_inbox_text" rows="1" style="overflow: hidden; overflow-wrap: break-word; height: 17px;"></textarea>
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
                </div>
              <div class="bt_wrap" id="bt_wrap1">
                 <%if(vo==null){
					
					out.print("<a href='event.jsp' class='on'>목록</a>");
				
				}else{
					if(vo.getMemberId().equals(vo2.getMemberId())){%>
					<a href="edit.jsp?id=<%=vo2.getNotice_seq() %>" >수정</a>
					<%out.print("<a href='community.jsp' class='on'>목록</a>");
					}else{
						out.print("<a href='event.jsp' class='on'>목록</a>");
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