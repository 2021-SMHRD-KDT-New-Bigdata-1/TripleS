<%@page import="com.VO.WriteVO"%>
<%@page import="com.DAO.WriteDAO"%>
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

<div data-include-path="header.jsp"></div>
<section class="section1">
    <div class="board_wrap">
        <div class="board_editTitle">
            <strong><i class="fas fa-eraser"></i> 게시글 수정하기</strong>
            <p>게시판 용도에 맞지 않는 글은 운영자에 의해 삭제될 수 있습니다.</p>
        </div>
        <div class="board_write_wrap">
             <div class="board_write">
              <%
            	  int id = Integer.parseInt(request.getParameter("id"));
              	WriteDAO dao = new WriteDAO();
				WriteVO writevo = dao.subjectList(id);
				%>
                <div class="title">
                    <dl>
                        <dt>제목 </dt>
                        <dd><%=writevo.getSubject()%></dd>
                    </dl>
                </div>
            
                <div class="cont">
                    <textarea  name="content"></textarea>
                   
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
                </div>
            </div>
            <div class="bt_wrap" id="bt_wrap2">
                <a href="view.html" class="on" id="on">재등록</a>
                <a href="reviewB.html">목록</a>
                <a href="#">삭제</a>
     
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