<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head> 
<meta charset="UTF-8">
<title>DOPPIO</title>
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
	           $(location).attr('href', "http://localhost:9000/doppio/admin/admin_recipe/recipe_list_de.th?rpage="+e.page);         
	    });
		
 	});
</script>
<style>
	div.mypage_nav a:nth-child(3) {text-decoration: underline;}
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
				<img alt="dessert" src="http://localhost:9000/doppio/resources/img/recipe_dessert_bn.png">
			</div>
			<br><br>
		<div class="mypage_nav">
			<a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_list_cf.th?rcate=cf">coffee</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_list_ncf.th?rcate=ncf">non-coffee</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_list_de.th?rcate=de">dessert</a>
		</div>
		
		<!-- ?????? ?????? -->
		<div class="purchasebtn">
				<a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_write_de.th"><button type="button">????????? ??????</button></a>
		</div>
		<div class="lioption_div">
			<div class="lioption_div2">
				<!-- <section class="lioption_sc">
						<ul class="liopli">
							
							<li>
								<select name="oplist" id="oplist" style= "width: 200px; height: 30px;">
								<option value="????????????">????????????</option>
								<option value="??????&?????????">??????&?????????</option>
								<option value="?????????&????????????">?????????&????????????</option></select>
							</li>
							
						</ul>
					</section> -->
			</div>
		</div>
		<!-- ?????? ????????? -->
			<div class="imgcon_div">
				<div class="imgcon_sc">
				
					<c:forEach var="vo" items="${list}">
						<div class="imgcon1">
							<input type="hidden" name="rno" value="${vo.rno }">
							<input type="hidden" name="rnum" value="${vo.rnum }">
							<input type="hidden" name="rsfile" value="${vo.rsfile }">
							<input type="hidden" name="rtitle" value="${vo.rtitle }">
							<c:if test="${vo.rsfile != null}">
								<a href="recipe_content_de.th?rnum=${vo.rnum }&rno=${vo.rno}">
									<img src="http://localhost:9000/doppio/resources/upload/${vo.rsfile }" class="recipe_img" width="300" height="300"/>
								</a>
							</c:if>
							<br>
							<a href="recipe_content_de.th?rnum=${vo.rnum }&rno=${vo.rno}">${vo.rtitle }</a>
						</div>
					</c:forEach>
				
				</div>
			</div>
			</div>
		</div>
			
				<table class="pagenumber">
					<tr>
						<td colspan="4"><div id="ampaginationsm"></td>
					</tr>
				</table>
				
				<br><br><br><br><br><br>
	<!-- <div style="text-align: center; margin: 0 auto;">
		<div style="display: inline-block; margin: 50px;"><img alt="" src="" width="250px" height="250px"></div>
		<div style="display: inline-block; margin: 50px;"><img alt="" src="" width="250px" height="250px"></div>
		<div style="display: inline-block; margin: 50px;"><img alt="" src="" width="250px" height="250px"></div>
		<div style="display: inline-block; margin: 50px;"><img alt="" src="" width="250px" height="250px"></div>
	</div> -->
		
		
			
		<!-- footer -->
		<jsp:include page="../../doppio_footer.jsp"></jsp:include>
		
	</body>
</html>