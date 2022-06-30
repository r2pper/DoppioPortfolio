<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="writecontent">
		<section class="board_write">
			<div class="title">
				<p>ADMIN NOTICE</p><br>
			</div>
			<form name="notice_write" action="/doppio/admin/admin_notice/notice_write.th" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" id="id" value="${sessionScope.sid }">
				<table class="content_write">
					<tr>
						<th>제목</th>
						<td width="90%"><input type="text" name="ntitle" id="ntitle"></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write">
					<tr>
						<td><textarea name="ncontent" id="ncontent"></textarea></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>
						<th>파일</th>
						<td><input type="file" name="file1"></td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="button" class="w-btn-outline w-btn-skin-outline" id="btnNotice">저장</button>
							<a href="http://localhost:9000/doppio/admin/admin_notice/notice_list.th"><button type="button" class="w-btn-outline w-btn-skin-outline">취소</button></a>
						</td>
					</tr>
				</table>
				<br><br><br>
			</form>
		</section>
		
	</div>
	
	
	<!-- footer -->
	<jsp:include page="../../doppio_footer.jsp"></jsp:include>
</body>
</html>