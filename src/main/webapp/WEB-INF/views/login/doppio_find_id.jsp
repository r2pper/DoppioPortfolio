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
	<div class="findDiv">
	<form action="/doppio/login/doppio_find_id_result.th" method = "POST">
		<table class="find_table">
			<tr>
				<td colspan="2">
					<div class = "search-title">
						<p>아이디 찾기</p>
					</div>
				</td>
			</tr>			
			<tr>
				<td class="find_td">이 름</td>
				<td><input type="text" name="name" id="name" class = "btn-name" placeholder = "등록한 이름"></td>
			</tr>
			<tr>
				<td class="find_td">번 호</td>
				<td><input type="text" name="hp" id="hp" class = "btn-phone" placeholder = "휴대폰번호를 '-' 포함 입력"></td>
			</tr>			
			<tr>
				<td colspan="2">
					<button type="submit" name="enter" id=findBtn class="findBtn" >찾기</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" name="cancle" class="findBtn" onClick="location.href='http://localhost:9000/doppio/login/doppio_login.th'">취소</button>
				</td>
			</tr>					
		</table>
	</form>
	</div>	
	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>