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
	<div class="admin_main">
			<div class="title">
				<p>ADMIN PAGE</p><br><br>
			</div>
			<div>
				<section class="admin">
				<div>
					<a href="http://localhost:9000/doppio/admin/member/member_list.th"><img src="/doppio/resources/img/member.png" width="130px" height="130px"><br>Member</a>
					<a href="http://localhost:9000/doppio/admin/admin_notice/notice_list.th"><img src="/doppio/resources/img/recipe.png" width="130px" height="130px"><br>Notice</a>
					<a href="http://localhost:9000/doppio/admin/admin_package/package_list_cf.th"><img src="/doppio/resources/img/package.png" width="130px" height="130px"><br>Package</a>
					<a href="http://localhost:9000/doppio/admin/admin_recipe/recipe_list_cf.th?rcate=cf"><img src="/doppio/resources/img/rrrecipe.png" width="130px" height="130px"><br>Recipe</a>
					<a href="http://localhost:9000/doppio/admin/admin_order_list.th"><img src="/doppio/resources/img/orderlist.png" width="130px" height="130px"><br>Order List</a>
				</div><br><br><br><br>
				</section>
			</div>
	</div>
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>