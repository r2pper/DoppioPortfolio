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
				<p>레시피 작성</p><br>
			</div>
			<form name="recipe_write_de" action="/doppio/admin/admin_recipe/recipe_write_de.th" method="post" enctype="multipart/form-data">
				<table class="content_write">
					<tr>
						<th>카테고리</th>
						<td width="90%">
							<select name="rcate">
								<option value="cf">Coffee</option>
								<option value="ncf">Non-Coffee</option>
								<option value="de">Dessert</option>							
							</select></td>
					</tr>
					<tr>
						<th>레시피명</th>
						<td width="90%"><input type="text" name="rname" id="rname"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td width="90%"><input type="text" name="rtitle" id="rtitle"></td>
					</tr>
					<tr>
						<th>영상 주소</th>
						<td width="90%"><input type="text" name="rurl" id="rurl"></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write">
					<tr>
						<th>Ingredients</th>
						<td width="90%">
							<textarea name="rcontent1" id="rcontent1">${vo.rcontent1 }</textarea>
						</td>
					</tr>
					<tr>
						<th>Recipe</th>
						<td width="90%">
						<textarea name="rcontent2" id="rcontent2">${vo.rcontent2 }</textarea>
						</td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>
						<th>대표사진</th>
						<td><input type="file" name="file1"></td>
					</tr>
					<tr>					
						<td colspan="2">
							<button type="button" class="w-btn-outline w-btn-skin-outline" id="btnRecipede">저장</button>
							<button type="button" class="w-btn-outline w-btn-skin-outline" id="btnCancel" onclick="location.href='http://localhost:9000/doppio/admin/admin_recipe/recipe_list_de.th?rcate=de'">취소</button>
							<!-- <a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_list.th"></a> -->
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