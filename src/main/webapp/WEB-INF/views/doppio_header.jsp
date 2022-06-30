<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>

</head>
<body>
<header>
	<div class="doppio_logo">
		<a href="http://localhost:9000/doppio/doppio_main.th"><img src="/doppio/resources/img/DOPPIO_LOGO2.png" width="200px"></a>
	</div>
	<c:choose>
	<c:when test="${sessionScope.sid != null }">
	<div id="log">
		<br>
		<p>
		<a href="http://localhost:9000/doppio/login/doppio_logout.th">${sessionScope.sid}님&emsp; logout</a>&emsp;
		<!-- <a href="http://localhost:9000/doppio/join/doppio_join.th">join</a>&emsp; -->
		<a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th?mnum=${sessionScope.mnum}">mypage</a>&emsp;
		<c:if test="${sessionScope.sid == 'test' }">
			<a href="http://localhost:9000/doppio/admin/admin.th">admin</a>
		</c:if>
		</p>
	</div>
	</c:when>
	<c:otherwise>
	<div id="log">
		<br>
		<p>
		<a href="http://localhost:9000/doppio/login/doppio_login.th">login</a>&emsp;
		<a href="http://localhost:9000/doppio/join/doppio_join.th">join</a>&emsp;
		<!-- <a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th">mypage</a>&emsp;
		<a href="http://localhost:9000/doppio/admin/admin.th">admin</a> -->
		</p>
	</div>
	</c:otherwise>
	</c:choose>
<nav>
	<ul class="menu">
		<li>
			<a>Recipe</a>
			<ul class="inner_menu">
				<li class="nav_list"><a href="http://localhost:9000/doppio/recipe/recipe_list_cf.th">Coffee</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/recipe/recipe_list_ncf.th">Non-Coffee</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/recipe/recipe_list_de.th">Dessert</a></li>
			</ul>
		</li>
		<li>
			<a>Package</a>
			<ul class="inner_menu">
				<li class="nav_list"><a href="http://localhost:9000/doppio/package/package_list_cf.th">Coffee</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/package/package_list_ncf.th">Non-Coffee</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/package/package_list_de.th">Dessert</a></li>
			</ul>
		</li>
		<li>
			<a>Community</a>
			<ul class="inner_menu">
				<li class="nav_list"><a href="http://localhost:9000/doppio/notice/notice_list.th">Notice</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/board/board_list.th">Review</a></li>
				<li class="nav_list"><a href="http://localhost:9000/doppio/qna/qna_list.th">Q & A</a></li>
			</ul>
		</li>
	</ul>
</nav>
</header>

</body>
</html>