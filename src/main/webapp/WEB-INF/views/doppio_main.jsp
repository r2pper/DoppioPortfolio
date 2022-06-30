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
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
<script>
	var login_result = "${login_result}";
	var logout_result = "${logout_result}";
	//var drop_result = "${login_result}";
	var sid = "${sid}";
	
	if(login_result=="succ"){
		alert(sid+"님 환영합니다! DOPPIO에서 즐거운 시간 보내세요");
		location.href="http://localhost:9000/doppio/doppio_main.th" 
	}
/* 	if(login_result=="drop"){
		alert("탈퇴한 회원입니다");
	} 
	 */
	if(logout_result=="succ"){
		alert(sid+"님 성공적으로 로그아웃되었습니다.");
		location.href="http://localhost:9000/doppio/doppio_main.th" 
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
					<li class="nav_list"><a href="http://localhost:9000/doppio/notice/notice_list.th">Notice</a></li>
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
					<c:forEach var="olist" items="${ klist}">
					<a href="http://localhost:9000/doppio/recipe/recipe_content_cf.th?rnum=${olist.rnum }&rno=${olist.rno}"><img src="http://localhost:9000/doppio/resources/upload/${olist.rsfile }" width="300px" height="300px" ></a>
					<br><br>
					<a href="http://localhost:9000/doppio/recipe/recipe_content_cf.th?rnum=${olist.rnum }&rno=${olist.rno}"><span style="letter-spacing: 2px; font-size: 10PX;">| COFFEE |</span><br>${olist.rtitle }</a>
					</c:forEach>
			</div>
			<div class="main_new_pic">
					<div class="main_new_more"><a href="http://localhost:9000/doppio/recipe/recipe_list_ncf.th">> MORE</a></div>
					<c:forEach var="alist" items="${nlist}">
					<a href="http://localhost:9000/doppio/recipe/recipe_content_ncf.th?rnum=${alist.rnum }&rno=${alist.rno}"><img src="http://localhost:9000/doppio/resources/upload/${alist.rsfile }" width="300px" height="300px"></a>
					<br><br>
					<a href="http://localhost:9000/doppio/recipe/recipe_content_ncf.th?rnum=${alist.rnum }&rno=${alist.rno}"><span style="letter-spacing: 2px; font-size: 10PX;">| NON-COFFEE |</span><br>${alist.rtitle }</a>
					</c:forEach>
			</div>
			<div class="main_new_pic"  >
					<div class="main_new_more"><a href="http://localhost:9000/doppio/recipe/recipe_list_de.th">> MORE</a></div>					
					<c:forEach var="blist" items="${dlist}">
					<a href="http://localhost:9000/doppio/recipe/recipe_content_de.th?rnum=${blist.rnum }&rno=${blist.rno}"><img src="http://localhost:9000/doppio/resources/upload/${blist.rsfile }" width="300px" height="300px"></a>
					<br><br>
					<a href="http://localhost:9000/doppio/recipe/recipe_content_de.th?rnum=${blist.rnum }&rno=${blist.rno}" ><span style="letter-spacing: 2px; font-size: 10PX;">| DESSERT |</span><br>${blist.rtitle}</a>		
					</c:forEach>		
			</div>
		</div>
	</div>
	
	<!-- 슬라이드 배너 시작-->
	<div >
	<!-- <button style="display: inline-block;">&lang;</button> -->
	<div id="sliderWrap">
	  
	  <ul id="slider" style="display: inline-block;">	  
	  	<c:forEach var="vovo" items="${clist }">
	    <li>
	      <a href="http://localhost:9000/doppio/notice/notice_content.th?nnum=${vovo.nnum }&rno=${vovo.rno}"><img src="http://localhost:9000/doppio/resources/upload/${vovo.nsfile }" width="1250px" height="350px" alt="슬라이드1"></a>
	    </li>
	    </c:forEach>	    
	  </ul>
	  
	</div>
	<!-- <button style="display: inline-block;">&rang;</button> -->
	</div>

	<!-- 슬라이드 배너 끝 -->
	
	

	
	<div class="main_review">
			<span>Review</span>
			<p>List of recent reviews</p>				
	</div>
	<div class="main_review_box">
		<div class="main_review_inner_box" >
			<c:forEach var="vo" items="${list }">
			<div class="main_review_pic" >
			<c:if test="${vo.bsfile != null}">
				<a href="http://localhost:9000/doppio/board/board_content.th?bnum=${vo.bnum }&rno=${vo.rno}">
				<img src="http://localhost:9000/doppio/resources/upload/${vo.bsfile }" width="350px" height="250px" ></a>
			</c:if>
			<c:if test="${vo.bsfile == null}">
				<img src="http://localhost:9000/doppio/resources/img/noimage.png" width="350px" height="250px" >
			</c:if>
				<br>
				<p>${vo.bdate }</p>
				<div class="main_review_title"><a href="http://localhost:9000/doppio/board/board_content.th?bnum=${vo.bnum }&rno=${vo.rno}">${vo.btitle }</a></div>
				<div class="main_review_more"><a href="http://localhost:9000/doppio/board/board_content.th?bnum=${vo.bnum }&rno=${vo.rno}">> READ MORE</a></div>
			</div>
			</c:forEach>
		</div>
	</div>

<!-- footer -->
	<jsp:include page="doppio_footer.jsp"></jsp:include>
</body>
</html>