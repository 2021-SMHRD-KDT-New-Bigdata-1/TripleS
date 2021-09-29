<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
		<form action="JoinService" method="post">
			<h1>회원가입</h1>
			<input name="memberId" id="email" type="text" placeholder="이메일" />
			<input type="button" value="이메일 중복체크" onclick="emailCheck()">
					<span id="sp"></span>
			<input name="password" type="password" placeholder="비밀번호" />
			<input name="nickname" id="name" type="text" placeholder="닉네임" />
			<input type="button" value="닉네임 중복체크" onclick="nicknameCheck()">
					<span id="nick"></span>
			<input name="phone" type="tel" placeholder="전화번호" />
			<button type="submit">회원가입</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="LoginService" method="post">
			<h1>로그인</h1>
			<input name="memberId" type="email" placeholder="이메일" />
			<input name="password" type="password" placeholder="비밀번호" />
			<a href="#">비밀번호를 잊으셨나요?</a>
			<button type="submit">로그인</button>
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
     <script >
function emailCheck(){
			
			var input = document.getElementById("email");

			/* 이메일 */
			$.ajax({
				// type : 데이터 전송 방식
				// data : 서버에 보낼 데이터{키:값}
				// url : 데이터를 보낼 서버페이지
				// dataType : 응답받을 데이터 타입
				type : "post", 
				data : {email:input.value},
				url : "EmailCheckCon",
				dataType : "text",
				success : function(data){
					var sp = document.getElementById("sp");
					
					if (data=="true") {
						sp.innerHTML = "사용할 수 없는 이메일입니다"
					}else{
						sp.innerHTML = "사용 가능한 이메일입니다"
					}
				},
				error : function(){
					alert("통신실패");
				}
			})
		}

function nicknameCheck(){

	var input = document.getElementById("name");

	/* 닉네임 */
	$.ajax({
		// type : 데이터 전송 방식
		// data : 서버에 보낼 데이터{키:값}
		// url : 데이터를 보낼 서버페이지
		// dataType : 응답받을 데이터 타입
		type : "post", 
		data : {nickname:input.value},
		url : "NickNameCheckCon",
		dataType : "text",
		success : function(data){
			var sp = document.getElementById("nick");
			
			if (data=="true") {
				sp.innerHTML = "사용할 수 없는 닉네임입니다"
			}else{
				sp.innerHTML = "사용 가능한 닉네임입니다"
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