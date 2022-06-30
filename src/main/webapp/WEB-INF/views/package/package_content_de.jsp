<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
    
<!DOCTYPE html>
<html lang="ko">
	<head> 
		<meta charset="UTF-8">
		<title>DOPPIO</title>
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/recipe_buy_css.css">
		<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
		<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>  
	</head>
	<body>
	
		<!-- header -->
		<jsp:include page="../doppio_header.jsp"></jsp:include>
		
		
		<!-- content -->
		<br>
		<div class="list_go">
		<a href="http://localhost:9000/doppio/package/package_list_cf.th" id="tolist" class="tolist2"> > 목록으로 </a>
		</div>
		<div class="recipe_buy">
		
		<form name="package_cart_de" action="/package/package_content_de.th?mnum=${sessionScope.mnum }" method="post">
			<div class="buy_div">
				
				
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
					<h2>${vo.ptitle}</h2>
				<p style="font-size: 18px; line-height: 65px;">￦ ${vo.pprice} 원</p>
					
				<div class="buy_stitle">

					<p style="font-size: 15px; line-height: 25px; white-space: pre-wrap;">${vo.pcontent }
					</p><br>
				</div>
				</div>
				
				<!-- 옵션 박스 -->
				<div class="option_div">
					<div class="option_sc">
					
						<label class="count_label"> 수량 </label> <br><br>
						<div class="count_option">
							<select class="cacount" id="cacount"  name="cacount" style= "width: 200px; height: 30px;">
								<c:forEach begin="1" end="${vo.pstock }" var="count">
									<option>${count }</option>
								</c:forEach>
							</select>
						</div>
						
						<label class="add_label"> 추가 구매 </label> <br><br>
						<div class="add_option">
							<select class="popid" name="popid" id="popid" style= "width: 200px; height: 30px;">
								<c:forEach var="vo" items="${list}" >
									<option>${vo.popid}</option>
								</c:forEach>
								<input type="hidden" name="popprice" id="popprice" value="${vo.popprice }">
							</select>
						</div>
					</div>
				</div>
			
				<c:if test="${sessionScope.sid != null }">
				<div class="option_btn">
				<input type="hidden" name="pnum" id="pnum" value="${vo.pnum}">
				<input type="hidden" name="mnum" id="mnum" value="${sessionScope.mnum}">
				<button type="button" class="w-btn-outline w-btn-outline-package" id="cart_btn_de" data-pnum="${vo.pnum }">장바구니 담기</button>
				</div>
				</c:if>
				</div>
		</form>
		
		</div>
			<br><br><br>
		<!-- footer -->
		<jsp:include page="../doppio_footer.jsp"></jsp:include>
	
	</body>
</html>