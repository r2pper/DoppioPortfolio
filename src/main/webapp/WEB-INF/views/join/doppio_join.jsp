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
<script>
	$(document).ready(function(){
		
		//중복체크
		$("#idCheck").click(function(){
			var id = $("#id").val();
			
			if(id == ""){
				alert("아이디를 입력해주세요");
				$("#id").focus();
			}else{
				$.ajax({
					url : "idCheck.th?id="+id,
					success : function(result){
						//alert(result);
						if(result == 1){
							$("#idcheck_msg").text("이미 중복된 아이디가 존재합니다. 다시 입력해주세요");	
							$("#idcheck_msg").css("font-size","9px");
							$("#idcheck_msg").css("color","red");
							$("#id").val("").focus();
						}else{
							$("#idcheck_msg").text("사용이 가능한 아이디입니다.");	
							$("#idcheck_msg").css("font-size","9px").css("color","blue");
							$("#pass").focus();
						}
					}
				});//ajax
			}//if
		});//click
	});//ready
</script>
</head>
<body>
	
	<!-- header -->
	<jsp:include page="../doppio_header.jsp"></jsp:include> 
	
	<!-- content -->
	<div class="title">
		<p>Join</p>
	</div>
	<br><br>
<form name="join_form" action="doppio_join.th" method="post">
<div class="join_frame">
	<table class="join_table">
		<tr class="join_tr">
			<td class="join_td1" >아이디</td>
			<td class="join_td2">
				<input type="text" max="15" name="id" id="id">
				<button type="button" id="idCheck">중복확인</button>
				<div id="idcheck_msg"></div>
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">비밀번호</td>
			<td class="join_td2">
				<input type="password" name="pass" id="pass">
				
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">비밀번호 확인</td>
			<td class="join_td2">
				<input type="password" name="cpass" id="cpass">
				<div id="msg"></div>
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">이름</td>
			<td class="join_td2">
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">주소</td>
			<td class="join_td2">
				<input type="text" class="join_input1" name="address" id="address">
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">전화번호</td>
			<td class="join_td2">
				<input type="text" class="join_input2" name="hp1" id="hp1"> - 
				<input type="text" class="join_input2" name="hp2" id="hp2"> - 
				<input type="text" class="join_input2" name="hp3" id="hp3">
			</td>
		</tr>
		<tr class="join_tr">
			<td class="join_td1">이메일</td>
			<td class="join_td2">
				<input type="text" name="email1" id="email1"> @ 
				<input type="text" class="join_input3" name="email2" id="email2">
			</td>
		</tr>
	</table>
	
	<div class="join_btn"> 
		<button type="button" id="btnJoin" class="w-btn-outline w-btn-skin-outline">가입하기</button>
	</div>
</div>
</form>	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>