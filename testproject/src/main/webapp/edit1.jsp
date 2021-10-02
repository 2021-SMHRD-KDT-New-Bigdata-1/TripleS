<%@page import="com.VO.replyVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.replyDAO"%>
<%@page import="com.VO.WriteVO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href=" CSS/Board/css.css">
</head>
<body>
<div data-include-path="header.jsp"></div>
<body>

<%
MemberVO vo = (MemberVO) session.getAttribute("vo");
WriteVO writevo = (WriteVO)session.getAttribute("writevo");
replyDAO rdao = new replyDAO();
ArrayList<replyVO> al = rdao.dselect(writevo.getArticles_seq(),"review");
int cnt = (int)session.getAttribute("cnt");
%>
	
	
<form action="writeboard">
<section class="section1">
    <div class="board_wrap">
        <div class="board_title">
            <strong>게시글 작성</strong>
            <p># 리뷰게시판 글 작성</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" value="<%=writevo.getSubject() %>" name="subject"></dd>
                    </dl>
                </div>
            
                <div class="cont">
                    <textarea type="text" value="<%=writevo.getContent() %>" name="content"></textarea>
                   
                </tbody>
                </div>
            </div>
            <div class="file">
            <tbody >
                <div class="file1">
                <tr>
                    <th scope="row">첨부파일1<i class="far fa-file"></i></th>
                    <td><input name="img_pic1"  type="file">
                    </td>
                </tr>
            </div>
            <div class="file2">
                <tr>
                    <th scope="row">첨부파일2<i class="far fa-file"></i></th>     
                    <td><input name="img_pic2" type="file">
                    </td>
                </tr>
            </div>
            <div class="file3">
                <tr>
                    <th scope="row">첨부파일3<i class="far fa-file"></i></th>
                    <td><input name="img_pic3" type="file">
                    </td>
                </tr>
            </div>
            </tbody>
        </div>
            <div class="bt_wrap" id="bt_wrap">
                <input type ="submit" value="등록" style="font-size: 14px; height:41.33px; background-color: black; color: white;
                text-align:center; width: 80px ">
                <a href= "review_board.jsp">취소</a>
            </div>
        </div>
      </section>
</form>

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