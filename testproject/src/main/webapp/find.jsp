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
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>


	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="LoginService" method="post">
				<h1>로그인</h1>
				<input name="memberId" type="email" placeholder="이메일" /> <input
					name="password" type="password" placeholder="비밀번호" /> <a href="#">비밀번호를
					잊으셨나요?</a>
				<button type="submit">로그인</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="FindPwService" method="post">
				<h1>비밀번호</h1>
				<input name="memberId" id="email" type="text" placeholder="이메일" />
				<input name="phone" type="tel" placeholder="전화번호" />
				<button type="submit">찾기</button>
			</form>

		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>로그인</h1>
					<p>로그인을 하시면 더욱 다양한 서비스를 즐기실 수 있습니다!</p>
					<button class="ghost" id="signIn">로그인</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>회원가입</h1>
					<p>아직 회원가입을 안 하셨나요?</p>
					<button class="ghost" id="signUp">회원가입</button>
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

</body>
</html>