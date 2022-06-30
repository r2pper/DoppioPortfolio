<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/am-pagination.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/am-pagination.js"></script>
<script>
	$(document).ready(function() {

	
		var page1 = $('.boardhover').hover(function() {

			$(this).css("background-color","#f7f7f7");

		}, function() {

		$(this).css("background-color","#ffffff");

	});

});
</script>
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
	           $(location).attr('href', "http://localhost:9000/doppio/admin/member/member_list.th?rpage="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>
	<!-- header -->
	<jsp:include page="../../doppio_header.jsp"></jsp:include>


	<!-- content -->
	<div id="boarddiv">
		<section class="board_list">
			<div class="title">
				<p>회원관리</p>
			</div>
			<br>
			<table id="board_table">
				<tr id="board_head">
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>	
					<th>핸드폰</th>
					<th>주소</th>
					<th>가입일</th>
				</tr>
				<c:forEach var="vo" items="${list }">
				<tr class="boardhover">
					<td>${vo.rno }</td>
					<td><a href="http://localhost:9000/doppio/admin/member/member_content.th?mnum=${vo.mnum }&rno=${vo.rno}" class="boardtitle">${vo.id }</a></td>
					<td>${vo.name }</td>
					<td>${vo.hp }</td>
					<td>${vo.address }</td>
					<td>${vo.mdate }</td>
					<c:choose>
						<c:when test="${vo.join_status == 0 }">
							<td><button type="button" disabled>신청</button></td>
						</c:when>
						<c:otherwise>
							<td><button type="button">신청</button></td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="7"><div id="ampaginationsm"></td>
				</tr>
			</table>
			<br><br><br><br><br><br>
		</section>
		
	</div>
	
	
	<!-- footer -->
	<jsp:include page="../../doppio_footer.jsp"></jsp:include>
</body>
</html>