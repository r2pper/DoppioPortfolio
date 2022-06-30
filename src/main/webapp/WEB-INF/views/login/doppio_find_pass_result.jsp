<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/login_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>

</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include> 
	
	<!-- content -->
	<div class="title">
			<p>Login</p>
	</div>

	<div class="smallTitle">비밀번호 찾기 결과</div>

		<div class="find_div">
			
			<div class="result_text">회원님의 등록된 비밀번호는<strong> ${pass} </strong>입니다</div><br><br>
			<button type="button" class="toLogin" onClick="location.href='http://localhost:9000/doppio/login/doppio_login.th'">Login</button>
			
		</div>

	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>