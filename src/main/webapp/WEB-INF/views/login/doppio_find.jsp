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
	<div class="smallTitle">아이디 비밀번호 찾기</div>
	<div class="find_div">
	<button type="button" class="findInfo" onclick="location.href='http://localhost:9000/doppio/login/doppio_find_id.th'"> 아이디 찾기 </button>
	
	<button type="button" class="findInfo" onclick="location.href='http://localhost:9000/doppio/login/doppio_find_pass.th'">비밀번호 찾기</button>
	</div>
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>