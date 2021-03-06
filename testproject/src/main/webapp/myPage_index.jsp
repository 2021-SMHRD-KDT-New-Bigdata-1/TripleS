<%@page import="com.VO.PartiesVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.DAO.MemberDAO"%>
<%@page import="com.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Triple_S</title>
<link rel="stylesheet" href="CSS/Login/MyPage.css">
</head>
<body class="manage_comm">

   <div data-include-path="header.jsp"></div>

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



   <div id="all">
      <div class="tabs">
         <div class="tab-2">
            <label for="tab2-1">내정보 관리</label> <input id="tab2-1" name="tabs-two"
               type="radio" checked="checked">
            <div>
               <div id="kakaoContent" class="cont_myinfo" role="main">
                  <div id="cMain">
                     <div id="mArticle">

                        <div id="pageManage" data-role="page" data-url="pageManage"
                           class="km-page-active">
                           <h2 id="kakaoBody" class="screen_out">카카오계정 본문</h2>
                           <h3 class="tit_kaccount">내정보 관리</h3>

                           <%
                           MemberVO vo = (MemberVO) session.getAttribute("vo");
                           MemberDAO dao = new MemberDAO();
                           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                           Date time = new Date();
                           String time1 = format.format(time);
                           String time2 = vo.getMileage_date();
                           String result = time2.substring(0, 10);
                           %>
                           <div class="wrap_kaccount">
                              <div class="box_manage">
                                 <strong class="tit_manage">마일리지</strong>
                                 <p class="desc_comm desc_manage">사이트에서 마일리지는 현금처럼 사용할 수
                                    있습니다.</p>
                                 <div href="/weblogin/account/profile"
                                    class="link_set link_profile">
                                    <div class="info_kaccount">
                                       <div class="thumb_profile">
                                          <img src="img/login/mailiji.jpg" class="img_profile"
                                             alt="프로필사진"> <span class="img_frame"></span>
                                       </div>
                                       <span class="info_accounts"> <strong
                                          class="screen_out">이용 중인 계정</strong> <span
                                          class="txt_accounts" style="margin-top: 10px;">마일리지</span>
                                          <%
                                          if (time1.equals(result)) {
                                          %> <span class="txt_set"><%=vo.getMileage()%></span> <%
                                           } else {
                                           int mileage = dao.mileage(vo.getMileage(), vo.getMemberId(), vo.getMileage_date());
                                           %> <span class="txt_set"><%=mileage%></span> <%
                                                 }%>
                                       </span>
                                    </div>
                                    <span class="ico_account ico_arr"></span>
                                 </div>
                              </div>
                              <div class="box_set">
                                 <strong class="tit_manage">로그인 정보</strong>
                                 <p class="desc_comm desc_manage">계정 정보입니다.</p>
                                 <strong class="tit_set">이메일</strong> <span class="txt_set">
                                    <button id="readNicknameButton" type="button"
                                       class="btn_comm btn_type8">수정</button>
                                 </span> <span class="txt_set"><%=vo.getMemberId()%></span>
                              </div>

                              <%-- <div class="box_set">
                        <strong class="tit_set">비밀번호</strong> <span class="txt_set"><%=vo.getPassword()%></span>
                     </div> --%>
                              <div class="box_set">
                                 <strong class="tit_set">닉네임</strong><span class="txt_set">
                                    <button id="readNicknameButton" type="button"
                                       class="btn_comm btn_type8">수정</button>
                                 </span> <span class="txt_set"><%=vo.getNickname()%></span>
                              </div>
                              <div class="box_set">
                                 <strong class="tit_set">전화번호</strong><span class="txt_set">
                                    <button id="readNicknameButton" type="button"
                                       class="btn_comm btn_type8">수정</button>
                                 </span> <span class="txt_set"><%=vo.getPhone()%></span>
                              </div>

                           </div>
                        </div>

                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="tab-2">
            <label for="tab2-2">공유 계정</label> <input id="tab2-2" name="tabs-two"
               type="radio">
            <div>
               <%
               String memberId = vo.getMemberId();
               ArrayList<PartiesVO> al = dao.share(memberId);
               %>

               <hr class="hide">

               <div id="kakaoContent" class="cont_myinfo" role="main">
                  <div id="cMain">
                     <div id="mArticle">

                        <div id="pageManage" data-role="page" data-url="pageManage"
                           class="km-page-active">
                           <h2 id="kakaoBody" class="screen_out">카카오계정 본문</h2>
                           <h3 id="tit_s">공유 계정</h3>

                           <%
                           if (al.size() == 0) {
                           %>
                           <div class="wrap_kaccount">
                              <div class="box_manage">
                                 <div class="share_alert">
                                    <strong>공유하고 있는 계정이 없습니다.</strong>
                                 </div>
                              </div>
                           </div>


                           <%
                           } else {
                           %>

                           <%
                           for (PartiesVO share : al) {
                           %>
                           <div class="wrap_kaccount">
                              <div class="box_manage">
                                 <strong class="tit_manage">공유 계정</strong>
                                 <p class="desc_comm desc_manage">공유 계정에 대한 정보를 확인 할 수
                                    있습니다.</p>
                                 <div href="/weblogin/account/profile"
                                    class="link_set link_profile">
                                    <div class="info_kaccount">
                                       <div class="thumb_profile">

                                          <img src="img/login/icon-<%=share.getOtt()%>.png"
                                             class="img_profile" alt="프로필사진"> <span
                                             class="img_frame"></span>
                                       </div>
                                       <span class="info_accounts"> <strong
                                          class="screen_out">이용 중인 계정</strong> <span
                                          class="txt_accounts"><%=share.getOtt()%></span> <span
                                          class="txt_set_2" style="margin-top: 10px;"> </span>
                                       </span>
                                    </div>
                                    <span class="ico_account ico_arr"></span>
                                 </div>
                              </div>
                              <div class="box_set">
                                 <strong class="tit_manage">계정 정보</strong>
                                 <p class="desc_comm desc_manage">계정 정보입니다.</p>
                                 <strong class="tit_set">아이디</strong> <span class="txt_set_2"><%=share.getOttId()%></span>
                              </div>
                              <div class="box_set">
                                 <strong class="tit_set">비밀번호</strong> <span class="txt_set_2"><%=share.getOttPw()%></span>
                              </div>

                           </div>
                           <%
                           }
                           }
                           %>
                        </div>

                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>


   <!-- footer -->
   <div data-include-path="footer.html"></div>

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
</body>
</html>