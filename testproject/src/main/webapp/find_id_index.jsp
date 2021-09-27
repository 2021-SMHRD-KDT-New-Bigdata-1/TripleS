<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Triple_S</title>
<link rel="stylesheet" href="CSS/Login/Login.css">
</head>
<body>
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
	<!-- 로그인 -->
	<div id="container" style="padding-top: 160px;">
		<div id="contents">
			<!-- 본문 시작 -->



			<div class="sub_content">

				<!-- //side_cont -->

				<div class="content_box">
					<div class="bber_wrap">
						<div class="member_tit">
							<h1>아이디 찾기</h1>
						</div>
						<!-- //member_tit -->
						<div class="member_cont">



							<div class="cellbox">

								<div class="cell cell1">
								
									<form action="LoginService" method="post">
									
										<input type="hidden" id="mode" name="mode" value="login">
										<input type="hidden" id="returnUrl" name="returnUrl"
											value="https%3A%2F%2Fwww.goodbingo.co.kr%2Fmain%2Findex.php">
										<div class="member_login_box">
											<div class="login_input_sec">
												<div>
														
													<input type="text" id="loginId" name="phone" value=""
														placeholder="전화번호" required="true" aria-required="true">
														
													<input type="password" id="loginPwd" name="password"
														value="" placeholder="비밀번호" required="true"
														aria-required="true">
														
														
													<button type="submit"
														style="position: absolute; z-index: -9999999; opacity: 0; top: -5555px; left: -55555px;">찾기</button>
												</div>


												<div class="member_link_wrap">
													<div class="id_chk">

														<p class="dn js_caution_msg1">아이디, 비밀번호가 일치하지 않습니다. 다시
															입력해 주세요.</p>
													</div>

													<div class="btn_login_box">
														<ul>
															<li><button id="btnJoinMember"
																	class="btn_member_join"> <a href="join_index.html">회원가입</a> </button></li>
															<li><button id="btnFindId" class="btn_member_white"><a href="#">아이디</a>
																	찾기</button></li>
															<li><button id="btnFindPwd" class="btn_member_white"><a href="#">비밀번호 찾기</a>
																	</button></li>
														</ul>
													</div>
													<!-- //btn_login_box -->
												</div>

												<button type="submit">아이디 찾기</button>
											</div>
										</div>
									</form>
								</div>
								<!-- // cell 1 -->

								</div>
								<!-- // cell2 -->
							</div>
							<!-- // cellbox -->



						</div>
						<!-- //member_cont -->
					</div>
					<!-- //member_wrap -->
				</div>
				<!-- //content_box -->

			</div>
			<!-- //sub_content -->
		</div>
		<!-- //본문 끝 contents -->
	</div>


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