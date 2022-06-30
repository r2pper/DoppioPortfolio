<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
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
			<form name="" action="/doppio/qna/qna_update.th?qnum=${vo.qnum}" method="post">
				<table class="content_write">
					<tr>
						<th>제목</th>
						<td width="90%"><input type="text" name="qtitle" value="${vo.qtitle }"></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write">
					<tr>
						<td><textarea name="qcontent">${vo.qcontent}</textarea></td>
					</tr>
				</table>
				<hr class="writeline">
				<table class="content_write" id="lasttable">
					<tr>					
						<td colspan="2">
							<button type="submit" class="btn_style2">수정완료</button>
							<a href="http://localhost:9000/doppio/qna/qna_content.th?qnum=${vo.qnum }&rno=${vo.rno}"><button type="button" class="btn_style2">취소</button></a>
							<a href="http://localhost:9000/doppio/qna/qna_list.th"><button type="button" class="btn_style2">리스트</button></a>
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