<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
	<head> 
		<meta charset="UTF-8">
		<title>Doppio</title>
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/recipe_list_css.css">
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/am-pagination.css">
		<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
		<script src="http://localhost:9000/doppio/resources/js/am-pagination.js"></script>
		<script>
			$(document).ready(function(){
				
				var pager = jQuery('#ampaginationsm').pagination({
				
				    maxSize: 7,	    		// max page size
				    totals: '${dbCount}',	// total pages	
				    page: '${reqPage}',		// initial page		
				    pageSize: '${pageSize}',			// max number items per page
				
				    // custom labels		
				    lastText: '&raquo;&raquo;', 		
				    firstText: '&laquo;&laquo;',		
				    prevText: '&laquo;',		
				    nextText: '&raquo;',
						     
				    btnSize:'sm'	// 'sm'  or 'lg'		
				});
				
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
					   jQuery('.showlabelsm').text('The selected page no: '+e.page);
			           $(location).attr('href', "http://localhost:9000/doppio/admin/admin_package/package_list_cf.th?rpage="+e.page);         
			    });
				
		 	});
		</script>
		<style>
			div.mypage_nav a:nth-child(1) {text-decoration: underline;}
			.pagenumber{margin-left: auto; margin-right: auto;}
		</style>
		</head>
	<body>
		
		<!-- header -->
		<jsp:include page="../../doppio_header.jsp"></jsp:include>
		
		<!-- content -->
		<div class="recipe_list">
			<div class="list_div">
		
			<div class="recipe_header">
				<img alt="coffee" src="http://localhost:9000/doppio/resources/img/package_coffee_bn.png">
			</div>
			<br><br>
		<div class="mypage_nav">
			<a href="http://localhost:9000/doppio/admin/admin_package/package_list_cf.th">coffee</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/admin/admin_package/package_list_ncf.th">non-coffee</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/admin/admin_package/package_list_de.th">dessert</a>
		</div>
		
		<!-- 옵션 박스 -->
		<div class="purchasebtn">
				<a href="http://localhost:9000/doppio/admin/admin_package/package_write_cf.th"><button type="submit">제품 등록</button></a>
		</div>
		<div class="lioption_div">
			<div class="lioption_div2">
				<!-- <section class="lioption_sc">
						<ul class="liopli">
							
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="전체보기">전체보기</option>
								<option value="원두커피">원두커피</option>
								<option value="믹스커피">믹스커피</option></select>
							</li>
							
						</ul>
					</section> -->
			</div>
		</div>
		<!-- 판매 리스트 -->
			<div class="imgcon_div">
				<section class="imgcon_sc">
				<c:forEach var="vo" items="${list}">
					<div class="imgcon1">
						<input type="hidden" name="rno" value="${vo.rno }">
						<input type="hidden" name="pnum" value="${vo.pnum }">
						<input type="hidden" name="psfile" value="${vo.psfile }">
						<input type="hidden" name="ptitle" value="${vo.ptitle }">
						<c:if test="${vo.psfile != null}">
							<a href="package_content_cf.th?pnum=${vo.pnum }&rno=${vo.rno}">
								<img src="http://localhost:9000/doppio/resources/upload/${vo.psfile }" class="package_img" width="300" height="300"/>
							</a>
						</c:if>
						<br>
						<a href="http://localhost:9000/doppio/resources/upload/${vo.psfile }">${vo.ptitle }</a>
					</div>
				</c:forEach>
					
				</section>
			</div>
			</div>
		</div>
		
		<table class="pagenumber">
			<tr>
				<td colspan="4"><div id="ampaginationsm"></div></td>
			</tr>
		</table>
		
		<br><br><br><br><br><br>
			
		<!-- footer -->
		<jsp:include page="../../doppio_footer.jsp"></jsp:include>
		
	</body>
</html>