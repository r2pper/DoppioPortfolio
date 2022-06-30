<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/mypage_basket_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script> 
	<script>
		$(document).ready(function(){
			 $(".selectDelete_btn").click(function(){
		         var checkArr = new Array();
				 var confirm_val = confirm("정말 삭제하시겠습니까?");
								  
		          	 alert("1111");
		                             
		                if(confirm_val) {					   
		                  $("input[class='chBox']:checked").each(function(){
		                    checkArr.push($(this).attr("data-canum"));
		                    });

		                    }// if
		                        
		                    $.each(checkArr, function (index, item) {
		            			
		            		 	alert(item);
		            		});

		                          alert(checkArr.length);     
		                             
		                          var objParams = {
		                                  "delList" : "delList",
		                                  "list" : checkArr        
		                              };

		                          //ajax 호출
		                         $.ajax({
				                    url  :   "doppio_mypage_basketDelete.th",               
				                    type :   "post",
				                    data : { "list" : checkArr},
				                    success     :   function(result){
				                    		if(result == "ok"){
				                    			alert("삭제 완료!!");
				                    		}else{
				                    			alert("삭제 실패!!");
				                    		}
				                    },
				                    error :   function(request, status, error){
				                            console.log("AJAX_ERROR");
				                    }
               					 });

		                          
		                    /*      $.ajax({
								url : "/DpCartServiceImpl/getDeleteResult",
								type : "post",
							    data : { chbox : checkArr },
								success : function(){
								location.href = "/mypage/doppio_mypage_basket";
						 	}
							});*/
			});
		
		});
</script>
	
<style type="text/css">
div.mypage_nav{text-align: center; width: 100%; margin-top: -25px; margin-bottom: 50px;}
div.mypage_nav a{text-decoration: none; color: black;}
div.mypage_nav a:hover{text-decoration: underline;}

/* 마이페이지 개별css */
div.mypage_nav a:nth-child(2) {text-decoration: underline;}


</style>
</head>
<body>

	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include> 

	<!-- content -->
		<div class="title">
			<p>My Info</p>
		</div>
		<br><br>
		<div class="mypage_nav">
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_info.th?mnum=${sessionScope.mnum }">정보수정</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_basket.th">장바구니</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_order_history.th">주문내역</a>
		</div>
		
			
			<div class="mypage_basket">
			<div class="basket_fix">
				<div class="basket_div">
				
				<div class="delBtn">
				   <button type="button" class="selectDelete_btn">선택 삭제</button>
				</div>
				
				<section class="basket_sc">
				<table class="basket_table" style="width: 75%; margin: auto;">
					<thead>
						<tr>
							<th style="line-height: 100px;">선택</th>
							<th colspan="2" style="text-align: center;" style="line-height: 100px;">상품명</th>
							<th style="line-height: 100px;">가격</th>
							<th style="line-height: 100px;">수량</th>
							<th style="line-height: 100px;">옵션</th>
							<!-- <th style="line-height: 100px;">삭제</th> -->
						</tr>
					</thead>
				
					<tbody>
					<c:forEach var="vo" items="${list}">
						<form name="delForm" action="doppio_mypage_basket.th" method="get">
						<tr>
							<th style="width: 5%; height: 60px;">
							 <div class="checkBox">
   								<input type="checkbox" name="chBox" class="chBox" data-canum="${vo.canum}" />
  							</div>
							</th>
							<td>
								<%-- <input type="hidden" name="canum" value="${vo.canum }"> --%>
								<input type="hidden" name="id" value="${sessionScope.sid }">
								<input type="hidden" name="rno" value="${vo.rno }">
								<input type="hidden" name="pnum" value="${vo.pnum }">
									<c:if test="${vo.psfile != null}">
								<img src="http://localhost:9000/doppio/resources/upload/${vo.psfile }" class="package_img" width="150" height="150"/>
									</c:if></td>
							<td>${vo.ptitle }</td>
							<td>${vo.pprice }</td>
							<td>${vo.cacount }</td>
							<td>${vo.popid }</td>
							<!-- <td><button type="submit" class="basket_delete">삭제</button> </td> -->
						</tr>
						</form>
					</c:forEach>
						<tr style="line-height: 200px;"><td colspan="7"><h3>상품을 결제해 주세요!</h3></td></tr>
					</tbody>
				</table>
				</section>
				</div>
			</div>
			
			<div class="row" style="text-align: center; margin: 80px 0;">
				<a href="http://localhost:9000/doppio/mypage/doppio_mypage_order_history.th"><button class="btn">주문하기</button></a>
				<a href="http://localhost:9000/doppio/package/package_list.th"><button class="btn btn-default">쇼핑을 계속하기</button></a>
			</div>
			
		</div>


		<%-- <table class= "" style="width: 100%; text-align: center;">
			<c:forEach var="vo" items="${list }">
				<tr> 
					<th style="width: 5%; text-align: center; height: 60px;">
						<input onclick="" type="checkbox" name="agree" class="basketChk"></th>
				<td style="width:10%;">${vo.psfile }</td>
				<td style="width:30%; min-width: 100px;" class="basketT">${vo.ptitle }</td>
				<td style="width:30%; min-width: 130px;">
					<div class="cart-product-quantity">
						<div class="quantity m-l-5 updown">
							<input type="button" name="minus" class="minus decreaseQuantity" value="-">
							<input type="text" 
								class="qty productStock" name="o_qty" style="min-width: 50px !important;" value="10">
							<input type="button" name="plus" class="plus increaseQuantity" value="+"> 
						</div>
					</div>
				</td>
				<td style="width:20%; min-width: 60px;" class="basketT">${vo.pprice} 원</td>
				</tr>
			</c:forEach>
		</table> --%>
		<!-- <script>
		
		$("input[name='agree']").click(function(){
				total = 0;
				
			$("input[name='agree']:checked").each(function(){
				let count = $(this).parent().parent().find("input[name='o_qty']").val();
				let price = $(this).parent().parent().find("input[name='o_price']").val(); 
				let sum = count * price;
				total += sum;
			});
			
			$("input[name='total']").val(total);
			
			let length = $("input[name='agree']").length;
			let check = $("input[name='agree']:checked").length;
			
			if(length != checked) $("input[name='agree_all']").prop("checked", false);
			else $("input[name='agree_all']").prop("checked", true);
			});
		</script> -->









	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
	</body>
	</html>