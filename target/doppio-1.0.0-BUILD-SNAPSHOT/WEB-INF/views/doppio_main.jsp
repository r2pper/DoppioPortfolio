<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_main_css.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css" />
<script>
	var login_result = "${login_result}";
	var logout_result = "${logout_result}";
	//var drop_result = "${login_result}";
	var sid = "${sid}";
	
	if(login_result=="succ"){
		alert("로그인에 성공하셨습니다.");
		/* location.href="http://localhost:9000/doppio/doppio_main.th" */
	}
/* 	if(login_result=="drop"){
		alert("탈퇴한 회원입니다");
	} 
	 */
	if(logout_result=="succ"){
		alert("["+sid+"]님! "+"로그아웃에 성공하셨습니다.");
	}
</script>
<style>
*{margin: 0;}  
</style>
</head>
<body>	
	<img class="main_bgpic" src="/doppio/resources/img/maindark.jpg" width="100%">
<div class="main_bgheader">
	<c:choose>
		<c:when test="${sessionScope.sid != null }">
		<div id="log">
			<br>
			<p><a href="http://localhost:9000/doppio/login/doppio_logout.th">${sessionScope.sid}님&emsp; logout</a>&emsp;
			<!-- <a href="http://localhost:9000/doppio/join/doppio_join.th">join</a>&emsp; -->
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th?mnum=${sessionScope.mnum}">mypage</a>&emsp;
			<c:if test="${sessionScope.sid == 'test' }">
				<a href="http://localhost:9000/doppio/admin/admin.th">admin</a>
			</c:if>
			
		</div>
		</c:when>
		<c:otherwise>
		<div id="log">
			<br>
			<p><a href="http://localhost:9000/doppio/login/doppio_login.th">login</a>&emsp;
			<a href="http://localhost:9000/doppio/join/doppio_join.th">join</a>&emsp;
			<!-- <a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th">mypage</a>&emsp; -->
			<!-- <a href="http://localhost:9000/doppio/admin/admin.th">admin</a></p> -->
		</div>
		</c:otherwise>
	</c:choose>
</div>	
<div class="main_bgnav">
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
					<li class="nav_list"><a href="http://localhost:9000/doppio/board/board_list.th">Review</a></li>
					<li class="nav_list"><a href="http://localhost:9000/doppio/qna/qna_list.th">Q & A</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</div>	
	<div class="main_letter animate__animated animate__fadeIn animate__slower 2s">
		<span>D&nbsp;O&nbsp;P&nbsp;P&nbsp;I&nbsp;O</span><br><p>have a pleasant teatime at home</p>
	</div>
	<br><br><br><br><br><br><br>
	<div class="main_new_text">
		<p>New Recipe</p>
	</div>
	<br><br>
	<div class="main_new_box" >
		<div class="main_new_inner_box" >
			<div class="main_new_pic">
					<div class="main_new_more"><a href="http://localhost:9000/doppio/recipe/recipe_list_cf.th">> MORE</a></div>
					<a href="#"><img src="/doppio/resources/img/newcoffee.jpg" width="100%" ></a>
					<br><br>
					<a href="#">Coffee</a>
			</div>
			<div class="main_new_pic">
					<div class="main_new_more"><a href="http://localhost:9000/doppio/recipe/recipe_list_ncf.th">> MORE</a></div>
					<a href="#"><img src="/doppio/resources/img/newnoncoffee.jpg" width="100%"></a>
					<br><br>
					<a href="#">Non-Coffee</a>
			</div>
			<div class="main_new_pic3"  >
					<div class="main_new_more"><a href="http://localhost:9000/doppio/recipe/recipe_list_de.th">> MORE</a></div>					
					<a href="#"><img src="/doppio/resources/img/newdessert.jpg" width="100%"></a>
					<br><br>
					<a href="#">Dessert</a>				
			</div>
		</div>
	</div>

	<div class="slider">
		<a href="#slide-1" class="slider_a" target="_self">&lang;</a>
		
			<div class="slides">
		    	<div id="slide-1"><img src="/doppio/resources/img/main_event4.jpg" class="main_slide_img"></div>
		    	<div id="slide-2"><img src="/doppio/resources/img/review_event2.jpg" class="main_slide_img"></div>
		  	</div>  
		<a href="#slide-2" class="slider_a">&rang;</a>
	</div>	
	
	
	<br><br><br><br><br>
	<div class="main_review">
			<span>Review</span>
			<p>List of recent reviews</p>				
	</div>
	<div class="main_review_box" >
		<div class="main_review_inner_box" >
			<c:forEach var="vo" items="${list }">
			<div class="main_review_pic">
				<a href="http://localhost:9000/doppio/board/board_content.th"><img src="/doppio/resources/img/orange.jpg" width="100%" height="250px" ></a>
				<br>
				<p>${vo.bdate }</p>
				<div class="main_review_title"><a href="http://localhost:9000/doppio/board/board_content.th?bnum=${vo.bnum }&rno=${vo.rno}">${vo.btitle }</a></div>
				<div class="main_review_more"><a href="http://localhost:9000/doppio/board/board_content.th?bnum=${vo.bnum }&rno=${vo.rno}">> READ MORE</a></div>
			</div>
			</c:forEach>
			<!-- <div class="main_review_pic">
					<a href="#"><img src="/doppio/resources/img/berry.jpg" width="100%" height="250px"></a>
					<br>
					<p>2022-04-25</p>
					<div class="main_review_title"><a href="#">리뷰 제목</a></div>
					<div class="main_review_more"><a href="#">> READ MORE</a></div>
			</div>
			<div class="main_review_pic3">	
					<a href="#"><img src="/doppio/resources/img/lemon.jpg" width="100%" height="250px"></a>
					<br>
					<p>2022-04-25</p>
					<div class="main_review_title"><a href="#">리뷰 제목</a></div>
					<div class="main_review_more"><a href="#">> READ MORE</a></div>				
			</div> -->
		</div>
	</div>

<!-- footer -->
	<jsp:include page="doppio_footer.jsp"></jsp:include>
</body>
</html>