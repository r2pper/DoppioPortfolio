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
				<p>관리자 package</p><br>
			</div>
			<form name="package_write_de" action="/doppio/admin/admin_package/package_write_de.th" method="post" enctype="multipart/form-data">
				<table class="content_write">
					<tr>
						<th>패키지명</th>
						<td width="90%"><input type="text" name="pname" id="pname"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>패키지 제목</th>
						<td width="90%"><input type="text" name="ptitle" id="ptitle"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>세부 사항</th>
						<td width="90%"><input type="text" name="pcontent" id="pcontent"></td>
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
						<td width="90%"><input type="text" name="pstock" id="pstock"></td>
					</tr>
				</table>
				<table class="content_write">
					<tr>
						<th>가격</th>
						<td width="90%"><input type="text" name="pprice" id="pprice"></td>
					</tr>
				</table>
				<hr class="writeline">
				
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>
						<th>파일</th>
						<td><input type="file" name="file1"></td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="button" class="btn_style2" id="btnPackageDe">저장</button>
							<a href="http://localhost:9000/doppio/admin/admin_package/package_list_de.th"><button type="button" class="btn_style2">취소</button></a>
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