<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../../doppio_header.jsp"></jsp:include>
	
	<!-- content -->
	<div>
		<div class="title">
				<p>MEMBER INFO</p>
		</div>
		<br><br>
			<table class="join_table">
					<tr class="join_tr">
						<td class="join_td1">번호</td>
						<td class="join_td2">${rno}
							
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">아이디</td>
						<td class="join_td2">
							${vo.id }
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">비밀번호</td>
						<td class="join_td2">
							${vo.pass }
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">이름</td>
						<td class="join_td2">
							${vo.name }
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">핸드폰</td>
						<td class="join_td2">
							${vo.hp }
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">주소</td>
						<td class="join_td2">
							${vo.address }
						</td>
					</tr>
					<tr class="join_tr">
						<td class="join_td1">가입일</td>
						<td class="join_td2">
							${vo.mdate }
						</td>
					</tr>
				</table>
				<br>
				<table class="content_write" id="lasttable">
					<tr>					
						<td colspan="2">
							<button type="button" class="w-btn-outline w-btn-skin-outline" onclick="location.href='http://localhost:9000/doppio/admin/member/member_list.th'">리스트</button>
							<a href="http://localhost:9000/doppio/admin/admin.th"><button type="button" class="w-btn-outline w-btn-skin-outline">관리자 홈</button></a>
						</td>
					</tr>
				</table>
				<br><br>
		</div>
	
	
	
	<!-- footer -->
	<jsp:include page="../../doppio_footer.jsp"></jsp:include>
</body>
</html>