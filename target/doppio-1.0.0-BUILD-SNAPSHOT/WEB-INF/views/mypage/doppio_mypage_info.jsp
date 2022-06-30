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
<script>
	$(document).ready(function(){
		
		//회원탈퇴 신청 처리
		$(document).on('click','#join_status',function(){
				
			$.ajax({
				url : "/doppio/mypage/doppio_mypage_info_out.th",
				type: "POST",
				data : JSON.stringify({
					"mnum" : $(this).data("mnum"), 
				}),
				contentType : 'application/json',
				success : function(result){
		
					
					if (result) {               
						alert("완료");           
					} else {               
						alert("전송된 값 없음");
					}       
				},       
				error: function() {           
						 alert("에러 발생");       
				}
					
			}); //ajax 
		
		});
	});
</script>
<style type="text/css">
	
	/* 마이페이지 개별css */
	div.mypage_nav a:first-child {text-decoration: underline;}
</style>
</head>
<body>
<!-- header -->
<jsp:include page="../doppio_header.jsp"></jsp:include> 
<!-- content -->
	<div class="title">
		<p>My Page</p>
	</div>
	<br><br>
	<div class="mypage_nav">
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_info?mnum=${sessionScope.mnum}.th">정보수정</a>&emsp;&emsp;
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_basket.th">장바구니</a>&emsp;&emsp;
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_order_history.th">주문내역</a>
	</div>

<form name="" action="/doppio/mypage/doppio_mypage_info.th?mnum=${vo.mnum }" method="post">
	<div class="join_frame">
		<table class="join_table">
			<tr class="join_tr">
				<td class="join_td1">아이디</td>
				<td class="join_td2">${vo.id }
					<!-- <input type="text" max="15">
					<button type="button" onclick="location='#'">중복확인</button> -->
				</td>
			</tr>
			<tr class="join_tr">
				<td class="join_td1">
				비밀번호</td>
				<td class="join_td2">
					<input type="text" name="pass" value="${vo.pass }">
					<!-- <input type="text"> -->
				</td>
			</tr>
			<tr class="join_tr">
				<td class="join_td1">이름</td>
				<td class="join_td2">
					<input type="text" name="name" value="${vo.name }">
					<!-- <input type="text"> -->
				</td>
			</tr>
			<tr class="join_tr">
				<td class="join_td1">주소</td>
				<td class="join_td2">
					<input type="text" name="address" value="${vo.address }" class="mypage_address">
					<!-- <input type="text" class="join_input1"> -->
				</td>
			</tr>
			<tr class="join_tr">
				<td class="join_td1">전화번호</td>
				<td class="join_td2">
					<input type="text" name="hp" value="${vo.hp }">
					<!-- <input type="text" name="hp1" value="${vo.hp1 }">-
					<input type="text" name="hp2" value="${vo.hp2 }">-
					<input type="text" name="hp3" value="${vo.hp3 }"> -->
				</td>
			</tr>
			<tr class="join_tr">
				<td class="join_td1">이메일</td>
				<td class="join_td2">
					<input type="text" name="email" value="${vo.email }" class="mypage_email">
					<!--<input type="text" name="email1" value="${vo.email1 }">@
					<input type="text" name="email2" value="${vo.email2 }"> -->
				</td>
			</tr>
		</table>		
	</div>
</form>

	<div class="join_btn">
		<c:choose>
			<c:when test="${vo.join_status == 0 }">
				<button id="join_status" data-mnum="${vo.mnum }">회원탈퇴</button>
			</c:when>
			<c:otherwise>
				<button id="join_status">탈퇴취소</button>
			</c:otherwise>
		</c:choose> 
<!-- 			<button type="submit">회원탈퇴</button> -->
		<button type="submit">저장하기</button>
	</div>
	<br><br><br><br><br>
<!-- footer -->
<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>