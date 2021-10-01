
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.Write3DAO"%>
<%@page import="com.VO.Write3VO"%>
<%@page import="com.VO.MemberVO"%>


<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/19aa9ed23d.js" crossorigin="anonymous"></script>
<head>
<meta charset="EUC-KR">
<title>�̺�Ʈ�Խ���</title>
 <link rel="stylesheet" href="CSS/Board/css.css">
</head>
<body>

<div data-include-path="header.jsp"></div>
<%
MemberVO vo = (MemberVO)session.getAttribute("vo");
Write3VO vo2 = (Write3VO)session.getAttribute("vo2");

%>
<section class="section1">
<nav>
  <ul>
    <li class="active">
   <a href="event.jsp"><i class="far fa-laugh-squint"></i> �̺�Ʈ�Խ��� </a></li>
  <!-- <p> �Խ��� �뵵�� ���� �ʴ� ���� ��ڿ� ���� ������ �� �ֽ��ϴ�.</p> -->	

  </ul>
            
            </div>
        <div class="board_wrap">
            <div class="board_title">
           
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
             <%
             Write3DAO dao = new Write3DAO();

             ArrayList<Write3VO> list = dao.subjectList();
             
             
             %>
                
            	  		<%for(int i = 0; i<list.size(); i++){ %>
      		<% %>
      			
                <div>
                  <div class="num" ><%=list.get(i).getNotice_seq()%></div>
                  <div class="title"><a href="detail_view3.jsp?id=<%=list.get(i).getNotice_seq() %>"><%=list.get(i).getNotice_title()%></a></div>
                  <div class="writer"><%=list.get(i).getMemberId() %></div>
                 
                  <div class="date" ><%=list.get(i).getInput_date() %></div>
                  <div class="good" >0</div>
                  <div class="count" ><%=list.get(i).getCnt() %></div>
					
                </div>
               <%} %>
          
              </div>
              
              	
              <div class="board_page">
                <a href="#" class="bt first"><<</a>
                <a href="#" class="bt prev"><<</a>
                
           
                   <a href="event.jsp?page=#" class="num on" >1</a>
            
		   
     
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
					out.print("<a href='write_board3.html' class='on'>���ۼ�</a>");
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
    <script>
var nav = $("nav");
var line = $("<div />").addClass("line");

line.appendTo(nav);

var active = nav.find(".active");
var pos = 0;
var wid = 0;

if (active.length) {
  pos = active.position().left;
  wid = active.width();
  line.css({
    left: pos,
    width: wid
  });
}

nav.find("ul li a").click(function (e) {
  e.preventDefault();
  if (!$(this).parent().hasClass("active") && !nav.hasClass("animate")) {
    nav.addClass("animate");

    var _this = $(this);

    nav.find("ul li").removeClass("active");

    var position = _this.parent().position();
    var width = _this.parent().width();

    if (position.left >= pos) {
      line.animate(
        {
          width: position.left - pos + width
        },
        300,
        function () {
          line.animate(
            {
              width: width,
              left: position.left
            },
            150,
            function () {
              nav.removeClass("animate");
            }
          );
          _this.parent().addClass("active");
        }
      );
    } else {
      line.animate(
        {
          left: position.left,
          width: pos - position.left + wid
        },
        300,
        function () {
          line.animate(
            {
              width: width
            },
            150,
            function () {
              nav.removeClass("animate");
            }
          );
          _this.parent().addClass("active");
        }
      );
    }

    pos = position.left;
    wid = width;
  }
});
</script>
    
    
	  <div data-include-path="footer.html"></div>
</body>
</html>