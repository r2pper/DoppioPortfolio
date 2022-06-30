<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="writecontent">
		<section class="board_write">
			<div class="title">
				<p>Q & A</p><br>
			</div>
			<form name="qna_write" action="/doppio/qna/qna_write.th" method="post">
				<input type="hidden" name="id" id="id" value="${sessionScope.sid }">
				<table class="content_write">
					<tr>
						<th>제목</th>
						<td width="90%"><input type="text" name="qtitle" id="qtitle"></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write">
					<tr>
						<td><textarea name="qcontent" id="qcontent"></textarea></td> <!-- 내용 -->
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>					
						<td colspan="2">
							<button type="button" class="btn_style2" id="btnQna">저장</button>
							<a href="http://localhost:9000/doppio/qna/qna_list.th"><button type="button" class="btn_style2">취소</button></a>
						</td>
					</tr>
				</table>
				<br><br><br>
			</form>
		</section>
		
	</div>
	
	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>