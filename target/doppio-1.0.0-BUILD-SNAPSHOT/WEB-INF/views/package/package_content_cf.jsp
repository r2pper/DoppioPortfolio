<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>      
<!DOCTYPE html>
<html lang="ko">
	<head> 
		<meta charset="UTF-8">
		<title>Doppio</title>
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/recipe_buy_css.css">
		<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
		<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>  	
	</head>
	<body>
	
		<!-- header -->
		<jsp:include page="../doppio_header.jsp"></jsp:include>
		
		
		<!-- content -->
		<div class="recipe_buy">
		<form name="package_cart_cf" action="/package/package_content_cf.th" method="post">
			<div class="buy_div">
				<a href="http://localhost:9000/doppio/package/package_list_cf.th" id="btnBack"> >> BACK </a>
				
				<!-- 판매 상품 이미지 -->		
				<input type="hidden" name="pname" value="${vo.ptitle }">	
				<div class="buy_img"> 
					<c:if test="${vo.psfile != null}">
							<img src="http://localhost:9000/doppio/resources/upload/${vo.psfile}"
							     width="500px" height="500px">
					</c:if>
				</div>
				
				<!-- 설명창 -->
				<div class="buy_title">
					<h2>${vo.ptitle}</h2><br>
					
					
				<p style="font-size: 15px">${vo.pcontent}</p><br>
					
				<div class="buy_stitle">
					<h3>할인 받고 저렴하게 구매하세요!</h3>
				</div>
				</div>
				
				<!-- 옵션 박스 -->
				<div class="option_div">
					<section class="option_sc">
						<ul class="opli">
						
						<div class="count_option" style="text-align: left;">
							<label> 희망 옵션을 선택해 주세요: </label> <br><br>
							<select class="cacount" id="cacount"  name="cacount" style= "width: 200px; height: 30px;">
								<c:forEach begin="1" end="${vo.pstock }" var="count">
									<option>${count }</option>
								</c:forEach>
							</select>
						</div>
						
						<li class="ol"></li>
						<li>
							
							<select class="popid" name="popid" id="popid" style= "width: 200px; height: 30px;">
								<c:forEach var="vo" items="${list}" >
								<option >${vo.popid}</option>
								</c:forEach>
							</select>
						</li>
						</ul>
					</section>
				</div>
				<div class="option_sum">
					<h2>임시 가격 : ${vo.pprice}</h2>
				</div>
				
			</div>
			<c:if test="${sessionScope.sid != null }">
				<div class="option_btn">
				<input type="hidden" name="pnum" id="pnum" value="${vo.pnum}">
				<input type="hidden" name="id" id="id" value="${sessionScope.sid}">
				<button type="button" class="pkbt" id="cart_btn_cf" data-pnum="${vo.pnum }">장바구니</button>
				<a href="http://localhost:9000/doppio/mypage/doppio_mypage_basket.th"><button type="submit" class="pkbt">바로구매</button></a>
				</form>
				</div>
</div>
			
			</c:if>
			<br><br><br>
			
			
		<!-- footer -->
		<jsp:include page="../doppio_footer.jsp"></jsp:include>
	
	</body>
</html>