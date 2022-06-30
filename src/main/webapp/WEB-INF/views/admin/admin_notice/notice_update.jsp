<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<style>
	#upload {
		position:relative;
		/*border:1px solid red;*/
		left:89px;	top:-29px;
		background-color:white;
		width:150px;
		display:inline-block;
	}
</style>
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
<script>
	$(document).ready(function(){
		$("input[type=file]").change(function(){
		
			if(window.FileReader){
				var fname =  $(this)[0].files[0].name;
				$("#upload").text(fname);
			}
		});		
		
	});
</script>
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
			<form name="notice_write" action="/doppio/admin/admin_notice/notice_update.th?nnum=${vo.nnum}" method="post" enctype="multipart/form-data">
				<input type="hidden" name="nnum" value="${vo.nnum }">
				<input type="hidden" name="nsfile" value="${vo.nsfile }">
				<input type="hidden" name="nfile" value="${vo.nfile }">
				<table class="content_write">
					<tr>
						<th>제목</th>
						<td width="90%"><input type="text" name="ntitle" id="ntitle" value="${vo.ntitle }"></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write">
					<tr>
						<td><textarea name="ncontent">${vo.ncontent}</textarea></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>
						<th>파일</th>
						<td><input type="file" name="file1">
						<span id="upload">${vo.nfile }</span></td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="submit" class="w-btn-outline w-btn-skin-outline">저장</button>
							<a href="http://localhost:9000/doppio/admin/admin_notice/notice_content.th?nnum=${vo.nnum }&rno=${vo.rno}"><button type="button" class="w-btn-outline w-btn-skin-outline">취소</button></a>
							<a href="http://localhost:9000/doppio/admin/admin_notice/notice_list.th"><button type="button" class="w-btn-outline w-btn-skin-outline">리스트</button></a>
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