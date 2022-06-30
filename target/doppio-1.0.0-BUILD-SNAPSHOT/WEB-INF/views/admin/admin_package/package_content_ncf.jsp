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
		<jsp:include page="../../doppio_header.jsp"></jsp:include>
		
		
		<!-- content -->
		<div class="recipe_buy">
			<div class="buy_div">
				<a href="http://localhost:9000/doppio/admin/admin_package/package_list_ncf.th" id="btnBack"> >> BACK </a>
				<!-- 판매 상품 이미지 -->		
				<input type="hidden" name="pname" value="${vo.ptitle }">	
				<div class="buy_img">
					<c:if test="${vo.psfile != null}">
							<img src="http://localhost:9000/doppio/resources/upload/${vo.psfile}"
							     width="500px" height="500px">
					</c:if>
					</td>
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
						
							<li class="ol">옵션선택 : </li>
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="---------">구매 수량을 선택해 주세요.</option>
								<option value="1세트">1세트</option>
								<option value="2세트">2세트 (+6500원)</option>
								<option value="3세트">3세트 (+12000원)</option>
								<option value="4세트">4세트 (+18000원)</option>
								<option value="5세트">5세트 (+23000원)</option>
								</select>
							</li>
							<li class="ol"></li>
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="---------">음료를 추가해 보세요.</option>
								<option value="아메리카노">아메리카노 3팩 (+3000원)</option>
								<option value="밀크티">밀크티 300ml (+3500원)</option>
								<option value="딸기라떼">라떼 아트 키트 (+5000원)</option>
								<option value="밀크티">스파클링 와인 (+9000원)</option>
								<option value="밀크티">하이볼 패키지 (+14000원)</option>
								</select>
							</li>
							<!-- <li class="ol"></li>
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="---------">함께 읽으면 좋은 책이에요.</option>
								<option value="베스트셀러">4월의 베스트 셀러 - 파친코 (+11000원)</option>
								<option value="오늘의책1">오늘의 책 - 마음의 법칙 (+12000원)</option>
								<option value="오늘의책2">오늘의 책 - 저주토끼 (+13000원)</option>
								<option value="오늘의책3">오늘의 책 - 여름이 온다 (+13000원)</option>
								<option value="오늘의책4">오늘의 책 - 백광 (+13000원)</option>
								</select>
							</li>
							<li class="ol"></li>
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="---------">데코 용품은 어떠세요?</option>
								<option value="포스터">인스타 감성, 킨포크 포스터 (+3000원)</option>
								<option value="트레이">사진과 같아요, 우드 트레이 (+4000원)</option>
								<option value="조화">무향의 아름다움, 조화 다발 (+6000원)</option>
								<option value="피규어">촬영 필수템, 피규어 5종 (+12000원)</option>
								</select>
							</li> -->
						</ul>
					</section>
				</div>
				<div class="option_sum">
					<h2>임시 가격 : ${vo.pprice}</h2>
				</div>
			
			<div id="btn_package">	
			<form name="delForm" action="/doppio/admin/admin_package/package_content_ncf.th?pnum=${vo.pnum }" method="post">
				<table id="contenttable">
				<tr id="contenthead">
					<td width="100%"></td>
					<td><button type="button" class="pkbt" onclick="location.href='http://localhost:9000/doppio/admin/admin_package/package_update_ncf.th?pnum=${vo.pnum }&rno=${rno}'">수정</button></td>
					<td><button type="submit" class="pkbt">삭제</button></td>
				</tr>
				</table>
			</form>
			</div>	
			</div>
		
			</div>
			<br><br><br>
			
		<!-- footer -->
		<jsp:include page="../../doppio_footer.jsp"></jsp:include>
	
	</body>
</html>