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
</head>
<body>
	<!-- header -->
	<jsp:include page="../../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="writecontent">
		<section class="board_write">
			<div class="title">
				<p>ADMIN PACKAGE</p><br>
			</div>
			<form name="package_write" action="/doppio/admin/admin_package/package_update_ncf.th?pnum=${vo.pnum }" method="post" enctype="multipart/form-data">
				<table class="content_write">
					<tr>
						<th>패키지명</th>
						<td width="90%"><input type="text" name="ptitle" id="ptitle" value="${vo.ptitle}"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>제품명</th>
						<td width="90%"><input type="text" name="pname" id="pname" value="${vo.pname}"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>내용</th>
						<td width="90%"><textarea name="pcontent" id="pcontent" >${vo.pcontent}</textarea></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>구분</th>
						<td width="90%">
							<select name="pcate" id="pcate">
								<option value="cf">Coffee</option>
								<option value="ncf">Non-Coffee</option>
								<option value="de">Dessert</option>							
							</select></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>재고</th>
						<td width="90%"><input type="text" name="pstock" id="pstock" value="${vo.pstock }"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>가격</th>
						<td width="90%"><input type="text" name="pprice" id="pprice" value="${vo.pprice }"></td>
					</tr>
				</table>
				<hr class="writeline">
				
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>
						<th>파일</th>
						<td><input type="file" name="file1">
						<span id="upload">${vo.pfile }</span></td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="submit" class="w-btn-outline w-btn-skin-outline">저장</button>
							<a href="http://localhost:9000/doppio/admin/admin_package/package_content_ncf.th?pnum=${vo.pnum }&rno=${vo.rno}"><button type="button" class="w-btn-outline w-btn-skin-outline">취소</button></a>
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