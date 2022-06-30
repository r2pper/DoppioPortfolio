<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
<script>
	var join_result = "${join_result}";
	if(join_result == "succ"){
		alert("회원가입에 성공했습니다.");
	}	

	var login_result = "${login_result}";
	if(login_result == "fail"){
		alert("아이디 또는 패스워드가 다릅니다. 다시 로그인 해주세요.")
	}else if(login_result == "drop"){
		alert("탈퇴한 회원입니다.")
	}
	
	
	
	var auth_result = "${auth_result}";
	if(auth_result == "fail"){
		alert("접속권한이 없습니다. 로그인해주세요");
	}
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include> 
	
	<!-- content -->
	<div class="title">
			<p>Login</p>
	</div>
<form name="login_form" action="/doppio/login/doppio_login.th" method="post">
	<div class="login_page">		
		
		<div class="login">
			<div class="login_form">
				<input type="text" placeholder="아이디" id="id" name="id"><br>
				<input type="password" placeholder="비밀번호" id="pass" name="pass">	
			</div>
			<div class="login_btn">
				<button type="button" id="btnLogin">로그인</button>
			</div>
			<div class="login_join">
				<p><a href="http://localhost:9000/doppio/join/doppio_join.th">회원가입</a><!-- | <a href="#">아이디 비밀번호 찾기</a> --></p>
			</div>
		</div>
	</div>
</form>	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>