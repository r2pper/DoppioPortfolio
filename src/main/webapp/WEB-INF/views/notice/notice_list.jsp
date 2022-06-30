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
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
<script src="http://localhost:9000/doppio/resources/js/notice.js"></script>
<script src="http://localhost:9000/doppio/resources/js/am-pagination.js"></script>

<script>
	$(document).ready(function(){
		
		/* var pager = jQuery('#ampaginationsm').pagination({
		
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
	           $(location).attr('href', "http://localhost:9000/doppio/notice/notice_list.th?rpage="+e.page);         
	    }); */
		
 	});
</script>

</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include>
	
	<div id="boarddiv">
		<section class="board_list">
			<div class="title">
				<p>NOTICE</p><br>
			</div>
			<h3 style="text-align: center;">각종 이벤트와 새로운 소식을 전해드려요. 놓치지 말고 확인해 보세요!</h3>
			<div id="writebtn">
			<%-- <c:if test="${ sessionScope.sid == 'test'}">
		    <button type="button" class="write_button" onclick="location.href='http://localhost:9000/doppio/admin/admin_notice/notice_write.th'">공지글 작성</button><br><br>
			</c:if> --%>
			</div>
			<table id="board_table">
				<%-- <tr id="board_head">
					<th>번호</th>
					<th width="60%">제목</th>
					<th>작성자</th>	
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr class="boardhover">
						<td>${vo.rno }</td>
						<td><a href="http://localhost:9000/doppio/notice/notice_content.th?nnum=${vo.nnum }&rno=${vo.rno}" class="boardtitle">${vo.ntitle }</a></td>
						<td>${vo.id }</td>
						<td>${vo.ndate }</td>
						<td>${vo.nhits }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><div id="ampaginationsm"></td>	
				</tr> --%>
			</table>
			<div style="text-align: center;">
			<ul class="paging" >
				
			</ul>
			</div> 
			
			<div style="text-align: center;">
			  <select name="searchType">
			      <option value="title">제목</option>
			      <option value="content">내용</option>
			      <option value="id">작성자</option>
			  </select>
			  
			  <input type="text" name="keyword"/>
			  
			  <button id="searchBtn" >검색</button>
			</div>
			<br><br>
		</section>
		
		<!-- <div id="ampaginationsm"></div> -->
	</div>
	
	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>