<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOPPIO</title>
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/mypage_basket_css.css">
<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script> 
<script>
$(document).ready(function(){
	 // 배열 checkArr이라는 배열을 새로 생성하고
	 $(".selectDelete_btn").click(function(){											  
         	 //alert("1111"); //여기까지 성공했으면 1111띄움
                            
       	if(confirm("정말 삭제하시겠습니까?")) {	//만약 저 삭제하겠냐는 confirm에서 확인을 누르면				   
       		var checkArr = new Array();    
   			$("input[class='chBox']:checked").each(function(){ //클래스 이름이 chBox인 input중에 체크된 것들을
              checkArr.push($(this).attr("data-pnum"));	//checkArr 배열에 이 인덱스의 data-canum이라는 요소를 가져와서 넣겠다
              });
            

                 //ajax 호출
               $.ajax({
                   url  :   "/doppio/mypage/doppio_mypage_basketDelete.th",         //이 url에(컨트롤러와 같아야함)
                   type :   "post",				   //post방식으로
                   data : { "list" : checkArr},		 // objParams 배열에 들은 list라는 index의 checkArr배열의 데이터를 가져와서
                   success     :   function(result){		 // 성공시
                   		if(result.result == "ok"){		// 만약 값이 ok이면 삭제완료
                   			alert("삭제 완료되었습니다");
                   			location.reload();
                   		}else{
                   			alert("삭제 실패!!");   // 성공은 했으나 값이 ok가 아니면 삭제실패
                   			console.log(result);
                   		}
                   },
                   error :   function(request, status, error){
                   		
                           console.log("AJAX_ERROR");
                   }
    			}); 
         }// if
         
                         
                   
	});

});
</script>
<!-- <script>
	$(document).ready(function(){
		function moveHome(){
		     location.href = "http://localhost:9000/doppio/doppio_main.th";
	}
	});
</script> -->
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
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_basket.th?mnum=${sessionScope.mnum }">장바구니</a>&emsp;&emsp;
			<a href="http://localhost:9000/doppio/mypage/doppio_mypage_order_history.th?mnum=${sessionScope.mnum }">주문내역</a>
		</div>
		
			
			<div class="mypage_basket">
			<form name="add_order" action="/doppio/mypage/doppio_mypage_basket_or.th?mnum=${sessionScope.mnum }" method="post">
			<div class="basket_fix">
				<div class="basket_div">
				
				<div class="delBtn">
				   <button type="button" class="selectDelete_btn">선택 삭제</button>
				</div>
				
				<br>
				<section class="basket_sc">
				<table class="basket_table" style="width: 85%; margin: auto;">
					<thead>
						<tr id="board_head">
							<th style="line-height: 40px;">선택</th>
							<th colspan="2" style="text-align: center; line-height: 40px;">상품명</th>
							<th style="line-height: 40px;">가격</th>
							<th style="line-height: 40px;">수량</th>
							<th style="line-height: 40px;">옵션</th>
							<th style="line-height: 40px;">옵션가격</th>
							<th style="line-height: 40px;">총 가격</th>
						</tr>
					</thead>
				
				
					<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<th style="width: 5%; height: 70px;">
							 <div class="checkBox">
   								<input type="checkbox" name="chBox" class="chBox" data-pnum = "${vo.pnum }"/>
  							</div>
							</th>
							<td>
								<%-- <input type="hidden" name="canum" value="${vo.canum }"> --%>
								<input type="hidden" name="mnum" id="mnum" value="${sessionScope.mnum }">
								<input type="hidden" name="popid" id="popid" value="${vo.popid }">
								<input type="hidden" name="rno" value="${vo.rno }">
								<input type="hidden" name="pnum" id="pnum" value="${vo.pnum }">
									<c:if test="${vo.psfile != null}">
								<img src="http://localhost:9000/doppio/resources/upload/${vo.psfile }" class="package_img"/>
									</c:if>
							</td>
							<td>${vo.ptitle }</td>
							<td><fmt:formatNumber value="${vo.pprice}" pattern="##,###"/>원</td>							
							<td>${vo.cacount }</td>
							<td>${vo.popid }</td>
							<td><fmt:formatNumber value="${vo.popprice }" pattern="##,###"/>원</td>
							<td><fmt:formatNumber value="${ vo.pprice * vo.cacount + vo.popprice}" pattern="##,###"/>원</td>
							<%-- <td><button type="submit" class="basket_delete" data-canum="${vo.canum }">삭제</button> </td> --%>
						</tr>
						
					</c:forEach>						
						<tr style="line-height: 100px;">
						<td colspan="10" style="padding-top: 0px; padding-bottom: 0px;"><h3>상품을 결제해 주세요!</h3></td>
						</tr>
					</tbody>
				</table>
				</section>
				</div>
			</div>
			
			<div class="row" style="text-align: center; margin-bottom: 80px;">
				<button type="button" class="w-btn-outline w-btn-skin-outline" onclick="location.href='http://localhost:9000/doppio/doppio_main.th'">홈으로 돌아가기</button>
				<button type="button" id="orderlist_btn" class="w-btn-outline w-btn-skin-outline" data-mnum="${sessionScope.mnum }" data-canum="${sessionScope.canum }">주문하기</button>				
			</div>
			</form>
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