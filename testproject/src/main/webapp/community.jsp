<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.WriteDAO"%>
<%@page import="com.VO.WriteVO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/19aa9ed23d.js" crossorigin="anonymous"></script>
<head>
<meta charset="EUC-KR">
<title>����Խ���</title>
 <link rel="stylesheet" href="CSS/Board/css.css">
</head>
<body>

<div data-include-path="header.jsp"></div>
<%
MemberVO vo = (MemberVO)session.getAttribute("vo");
%>
<section class="section1">
        <div class="board_wrap">
            <div class="board_title">
              <strong>�����Խ���</strong>
              <p>�Խ��� �뵵�� ���� �ʴ� ���� ��ڿ� ���� ������ �� �ֽ��ϴ�.</p>
            </div>
            <div class="board_list_wrap">
              <div class="board_list">
                <div class="top">
                      <div class="num">��ȣ</div>
                  <div class="title">����</div>
                  <div class="writer">�۾���</div>
                  <div class="date">�ۼ���</div>
                  <div class="good">��õ��</div>
                  <div class="count">��ȸ��</div>
                    </div>
           
            	
      
      			
                <div>
                  <div class="num" ></div>
                  <div class="title"></div>
                  <div class="writer"></div>
                  <div class="date" ></div>
                  <div class="good" ></div>
                  <div class="count" ></div>
					
                </div>
               
          
              </div>
              
              	
              <div class="board_page">
                <a href="#" class="bt first"><<</a>
                <a href="#" class="bt prev"><<</a>
                
            
		   
     
                <a href="#" class="bt">></a>
                <a href="#" class="bt">>></a>
              </div>
              <div class="inputTypeText">
                <div class="search"> <select class= "search" >
               
                   <option value="����">����</option>
                   <option value="�۳���">�۳���</option>
                   <option value="�ۼ���">�ۼ���</option>
                </select>
                </div>
                <div class="search1">
                 <input  type="text" placeholder="Search">
                
                 <i class="fas fa-search" ><input type="submit" style= "opacity: 0%  color = white"></i>
               </div>
             </div>
              <div class="bt_wrap">
           
              <%if(vo==null){
					
					//out.print("<a href='review_board.jsp' class='on'>���</a>");
				
				}else{
					out.print("<a href='write_board2.html' class='on'>���ۼ�</a>");
				}

				%>
              <!--  <a href="write_board.html" class="on">�� �ۼ�</a>-->
                 
            </div> 
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