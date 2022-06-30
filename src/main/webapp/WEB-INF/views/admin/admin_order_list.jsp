<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script> 

</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<br><br>
	<div id="orderdiv">
		<div class="title"> 
		<p>ORDER LIST</p>
	</div>
	<br><br>

		<table id="order_table">
			<tr id="order_list">
				<th>회원번호</th><th>회원 아이디</th><th>주문상품</th><th>수량</th><th>결제금액</th><th>주문상태</th><th>주문일</th>
			</tr>
			<c:forEach var="vo" items="${list}">
			<tr class="order_data">		
				<td>${vo.mnum }</td><td>${vo.id }</td><td>${vo.ptitle }</td><td>${vo.cacount }</td><td>${ vo.pprice * vo.cacount + vo.popprice }원</td><td>결제완료</td><td>${vo.cadate }</td>
			</tr>
			</c:forEach>
		</table>

		<br><br><br><br><br><br><br><br>
	</div>
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>