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
		<jsp:include page="../../doppio_header.jsp"></jsp:include>
		
		<br>
		<div class="list_go">
		<a href="http://localhost:9000/doppio/package/package_list_cf.th" id="tolist" class="tolist2"> > 목록으로 </a>
		</div>
		
		<!-- content -->
		<div class="recipe_buy">
			<div class="buy_div">
				
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
					<h2>${vo.ptitle}</h2>
				<p style="font-size: 18px; line-height: 65px;">￦ ${vo.pprice} 원</p><br>
					
				<div class="buy_stitle">
					<br>
					<p style="font-size: 15px; line-height: 25px; white-space: pre-wrap;">${vo.pcontent }
					</p><br>
				</div>
				</div>
			
			<div class="option_btn_admin">	
			<form name="delForm" action="/doppio/admin/admin_package/package_content_cf.th?pnum=${vo.pnum }" method="post">
				<table>
				<tr>
					<td><button type="button" class="w-btn-outline w-btn-outline-package-admin" onclick="location.href='http://localhost:9000/doppio/admin/admin_package/package_update_cf.th?pnum=${vo.pnum }&rno=${rno}'">수정</button></td>
				</tr>
				<tr>
					<td><button type="submit" class="w-btn-outline w-btn-outline-package-admin">삭제</button></td>
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