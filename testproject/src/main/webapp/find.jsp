<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="CSS/Login/login_.css">
<link rel="stylesheet" href="CSS/main/nav.css">
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	
	
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="LoginService" method="post">
				<h1>로그인</h1>
				<input id="" name="memberId" type="email" placeholder="이메일" /> <input
					name="password" type="password" placeholder="비밀번호" /> <a href="#">비밀번호를
					잊으셨나요?</a>
				<button type="submit">로그인</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="#" method="post">
				<h1>비밀번호</h1>
				<input name="memberId" id="email" type="text" placeholder="이메일" />
				<input name="phone" id="phone" type="tel" placeholder="전화번호" />
				<h4 id="sp"></h4>
				<button type="button" onclick="pwFind()" >찾기</button>
			</form>

		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>회원가입</h1>
					<p>아직 회원가입을 안 하셨나요?</p>
					<button class="ghost" id="signIn">회원가입</button>
				</div>
				<div class="overlay-panel overlay-right">
				
					<h1>로그인</h1>
					<p>로그인을 하시면 더욱 다양한 서비스를 즐기실 수 있습니다!</p>
					<button class="ghost" id="signUp">로그인</button>
				</div>
			</div>
		</div>
	</div>


	<script>
      const signUpButton = document.getElementById('signUp');
      const signInButton = document.getElementById('signIn');
      const container = document.getElementById('container');

      signUpButton.addEventListener('click', () => {
      	container.classList.add("right-panel-active");
      });

      signInButton.addEventListener('click', () => {
      	container.classList.remove("right-panel-active");
      });
     </script>
     
     <script>
     function pwFind(){
			
			var email = document.getElementById("email");
			var phone = document.getElementById("phone");

			/* 이메일 */
			$.ajax({
				// type : 데이터 전송 방식
				// data : 서버에 보낼 데이터{키:값}
				// url : 데이터를 보낼 서버페이지
				// dataType : 응답받을 데이터 타입
				type : "post", 
				data : {email:email.value,phone:phone.value},
				url : "FindPwService",
				dataType : "text",
				success : function(pw){
					var sp = document.getElementById("sp");
					
					if (pw!=null) {
						sp.innerHTML ="비밀번호 : "+pw
					}else{
						sp.innerHTML = "다시 한번 확인해 보세요"
					}
				},
				error : function(){
					alert("통신실패");
				}
			})
		}
     </script>

</body>
</html>