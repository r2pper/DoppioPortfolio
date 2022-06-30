<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<style>
	div.mypage_nav a:nth-child(3) {text-decoration: underline;}
</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<br><br>
	<div id="orderdiv">
		<div class="title">
		<p>My Page</p>
	</div>
	<br><br>
	<div class="mypage_nav">
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th?mnum=${sessionScope.mnum}">정보수정</a>&emsp;&emsp;
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_basket.th">장바구니</a>&emsp;&emsp;
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_order_history.th">주문내역</a>
	</div>
		<table id="order_table">
			<tr id="order_list">
				<th>주문일</th><th>주문상품</th><th>결제금액</th><th>주문상태</th>
			</tr>
			<tr class="order_data">		
				<td>2022-04-27</td><td>얼그레이</td><td>20,000원</td><td>배송중</td>
			</tr>
			<tr class="order_data">		
				<td>2022-04-25</td><td>원두</td><td>15,000원</td><td>배송완료</td>
			</tr>
		</table>
		<br><br><br><br><br><br><br><br>
	</div>
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>