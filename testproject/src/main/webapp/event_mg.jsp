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
<title>이벤트게시판</title>
 <link rel="stylesheet" href="CSS/Board/css.css">
 <link rel="stylesheet" href="CSS/main/eventBoard.css">
 
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
				<li ><a href="member_mg.jsp"
					style="font-size: 20px;">회원 관리</a></li>

				<!-- <p> 게시판 용도에 맞지 않는 글은 운영자에 의해 삭제될 수 있습니다.</p> -->
				<li class="active"><a href="#" style="font-size: 20px;">이벤트
						관리</a></li>

			</ul>

			</div>
            
        <div class="board_wrap">
            <div class="board_title">
            <div class="inputTypeText">

						<div class="search1">
							<input type="text" placeholder="Search"> <i
								class="fas fa-search"></i>
						</div>
					</div>
           
            <div class="board_list_wrap">
              <div class="board_list">
                <div class="top">
                      <div class="num">번호</div>
                  <div class="title">제목</div>
                  <div class="writer">글쓴이</div>
                  <div class="date">작성일</div>
                  <div class="good">추천수</div>
                  <div class="count">조회수</div>
                    </div>
             <%
             Write3DAO dao = new Write3DAO();

             ArrayList<Write3VO> list = dao.subjectList();
             
             %>
                
            	  		<%for(int i = 0; i<list.size(); i++){ %>
      			
                <div>
                  <div class="num" ><%=list.get(i).getNotice_seq()%></div>
                  <div class="title"><a href="eventDetailCon_mg.do?seq=<%=list.get(i).getNotice_seq() %>"><%=list.get(i).getNotice_title()%></a></div>
                  <div class="writer">관리자</div>
                 
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
              
           
      
                 <div class="bt_wrap">
            <a href="event_write.html" class="on">글 작성</a>
            </div> 
            </div> 
            
        </div>
    </nav>
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