function init(){
 
 
 
}



$(document).ready(function(){


	init();

		
	/**************
	 * 회원가입 - 폼체크
	 ************/
	$("#btnJoin").click(function(){
		
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else if($("#cpass").val() == ""){
			alert("패스워드 확인을 입력해주세요");
			$("#cpass").focus();
			return false;
		}else if($("#name").val() ==""){
			alert("이름을 입력해주세요");
			$("#name").focus();
			return false;
		}else if($("#address").val() == ""){
			alert("주소를 입력해주세요");
			$("#address").focus();
			return false;
		}else if($("#hp1").val() == ""){
			alert("핸드폰 번호를 입력해주세요");
			$("#hp1").focus();
			return false;
		}else if($("#hp2").val() == ""){
			alert("핸드폰 번호를 입력해주세요");
			$("#hp2").focus();
			return false;
		}else if($("#hp3").val() == ""){
			alert("핸드폰 번호를 입력해주세요");
			$("#hp3").focus();
			return false;
		}else if($("#email1").val() == ""){
			alert("이메일을 입력해주세요");
			$("#email1").focus();
			return false;
		}else if($("#email2").val() == ""){
			alert("이메일주소를 입력해주세요");
			$("#email2").focus();
			return false;
		}else{
			join_form.submit();
		}			
	});
	
	/********************************
	  회원가입폼 - 패스워드, 패스워드확인 비교
	*********************************/
	function passCheck(){
		var pass = document.getElementById("pass");
		var cpass = document.getElementById("cpass");
		var msg = document.getElementById("msg");
		msg.style.fontSize ="13px";
				
		if(pass.value != "" && cpass.value != ""){
			if(pass.value == cpass.value){
				msg.innerHTML = "패스워드가 동일합니다";
				msg.style.color ="blue";
				return true;
			}else{
				msg.innerHTML = "패스워드가 동일하지 않습니다";
				msg.style.color ="red";
				pass.value = "";
				cpass.value = "";
				pass.focus();
				return false;
			}
		}
		
	}
		
	/**************
	 * 로그인 - 폼체크
	 ************/
	$("#btnLogin").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else{
			login_form.submit();
		}
	});
	
	
	/*******************
	 * 큐엔에이 - 글쓰기 폼체크
	 ********************/	
 	$("#btnQna").click(function(){
		if($("#qtitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#qtitle").focus();
			return false;
		}else if($("#qcontent").val() == ""){
			alert("내용을 입력해주세요");
			$("#qcontent").focus();
			return false;
		}else{
			qna_write.submit();
		}
	});
	 
	/*******************
	 * 게시판 - 글쓰기 폼체크
	 ********************/	
 	$("#btnBoard").click(function(){
		if($("#btitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#btitle").focus();
			return false;
		}else if($("#bcontent").val() == ""){
			alert("내용을 입력해주세요");
			$("#bcontent").focus();
			return false;
		}else{
			board_write.submit();
		}
	});
	
	
	/*******************
	 * 레시피 - 글쓰기 폼체크
	 ********************/	
 	$("#btnRecipecf").click(function(){
 		if($("#rname").val() == ""){ 
			alert("레시피명을 입력해주세요");
			$("#rname").focus();
				return false;
		}else if($("#rtitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#rtitle").focus();
			return false;
		}else if($("#rcontent1").val() == ""){
			alert("재료를 입력해주세요");
			$("#rcontent1").focus();
			return false;
		}else if($("#rcontent2").val() == ""){
			alert("레시피를 입력해주세요");
			$("#rcontent2").focus();
			return false;
		}else{
			recipe_write_cf.submit();
		}
	});
	
	/*******************
	 * 레시피 - 글쓰기 폼체크
	 ********************/	
 	$("#btnRecipencf").click(function(){
 		if($("#rname").val() == ""){ 
			alert("레시피명을 입력해주세요");
			$("#rname").focus();
				return false;
		}else if($("#rtitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#rtitle").focus();
			return false;
		}else if($("#rcontent1").val() == ""){
			alert("재료를 입력해주세요");
			$("#rcontent1").focus();
			return false;
		}else if($("#rcontent2").val() == ""){
			alert("레시피를 입력해주세요");
			$("#rcontent2").focus();
			return false;
		}else{
			recipe_write_ncf.submit();
		}
	});
	
	/*******************
	 * 레시피 - 글쓰기 폼체크
	 ********************/	
 	$("#btnRecipede").click(function(){
 		if($("#rname").val() == ""){ 
			alert("레시피명을 입력해주세요");
			$("#rname").focus();
				return false;
		}else if($("#rtitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#rtitle").focus();
			return false;
		}else if($("#rcontent1").val() == ""){
			alert("재료를 입력해주세요");
			$("#rcontent1").focus();
			return false;
		}else if($("#rcontent2").val() == ""){
			alert("레시피를 입력해주세요");
			$("#rcontent2").focus();
			return false;
		}else{
			recipe_write_de.submit();
		}
	});
	
	
	/*******************
	 * 패키지 - 등록 폼체크
	 ********************/	
 	$("#btnPackageNcf").click(function(){
 		if($("#pname").val() == ""){ 
			alert("상품명을 입력해주세요");
			$("#pname").focus();
				return false;
		}else if($("#ptitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#ptitle").focus();
				return false;
		}else if($("#pcontent").val() == ""){
			alert("소제목을 입력해주세요");
			$("#pcontent").focus();
				return false;
		}else if($("#pcate").val() == ""){
			alert("상품 구분을 입력해 주세요");
			$("#pcate").focus();
				return false;
		}else if($("#pstock").val() == ""){
			alert("재고 현황을 입력해 주세요");
			$("#pstock").focus();
				return false;
		}else if($("#pprice").val() == ""){
			alert("상품 가격을 입력해 주세요");
			$("#pprice").focus();
				return false;
		}else{
			package_write_ncf.submit();
		}
	});
	
	/*******************
	 * 패키지 - 등록 폼체크
	 ********************/	
 	$("#btnPackageCf").click(function(){
 		if($("#pname").val() == ""){ 
			alert("상품명을 입력해주세요");
			$("#pname").focus();
				return false;
		}else if($("#ptitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#ptitle").focus();
				return false;
		}else if($("#pcontent").val() == ""){
			alert("소제목을 입력해주세요");
			$("#pcontent").focus();
				return false;
		}else if($("#pcate").val() == ""){
			alert("상품 구분을 입력해 주세요");
			$("#pcate").focus();
				return false;
		}else if($("#pstock").val() == ""){
			alert("재고 현황을 입력해 주세요");
			$("#pstock").focus();
				return false;
		}else if($("#pprice").val() == ""){
			alert("상품 가격을 입력해 주세요");
			$("#pprice").focus();
				return false;
		}else{
			package_write_cf.submit();
		}
	});
	
	/*******************
	 * 패키지 - 등록 폼체크
	 ********************/	
 	$("#btnPackageDe").click(function(){
 		if($("#pname").val() == ""){ 
			alert("상품명을 입력해주세요");
			$("#pname").focus();
				return false;
		}else if($("#ptitle").val() == ""){
			alert("제목을 입력해주세요");
			$("#ptitle").focus();
				return false;
		}else if($("#pcontent").val() == ""){
			alert("소제목을 입력해주세요");
			$("#pcontent").focus();
				return false;
		}else if($("#pcate").val() == ""){
			alert("상품 구분을 입력해 주세요");
			$("#pcate").focus();
				return false;
		}else if($("#pstock").val() == ""){
			alert("재고 현황을 입력해 주세요");
			$("#pstock").focus();
				return false;
		}else if($("#pprice").val() == ""){
			alert("상품 가격을 입력해 주세요");
			$("#pprice").focus();
				return false;
		}else{
			package_write_de.submit();
		}
	});
	
	
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 admin cf
	 ********************/	
 	$("#btnComm").click(function(){
 	
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/admin/admin_recipe/recipe_content_cf_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax
		
		
			//comment_write_cf.submit();
		}
	});
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 admin ncf
	 ********************/	
 	$("#btnComm1").click(function(){
 	
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/admin/admin_recipe/recipe_content_ncf_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax
		
		
		}
	});
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 admin de
	 ********************/	
 	$("#btnComm2").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/admin/admin_recipe/recipe_content_de_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 cf
	 ********************/	
 	$("#btnComm3").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/recipe/recipe_content_cf_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 ncf
	 ********************/	
 	$("#btnComm4").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/recipe/recipe_content_ncf_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	/*******************
	 * 레시피 - 댓글쓰기 폼체크 de
	 ********************/	
 	$("#btnComm5").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/recipe/recipe_content_de_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("rnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	
	/*******************
	 * board 게시판 - 댓글쓰기 폼체크 
	 ********************/	
	 
	 
 	$("#btnComm6").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/board/board_content_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("bnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	
	/*******************
	 * qna 큐엔에이 - 댓글쓰기 폼체크 
	 ********************/	
 	$("#btnComm7").click(function(){ 		
 		if($("#cmcomment").val() == ""){
			alert("댓글내용을 입력해주세요");
			$("#cmcomment").focus();
			return false;
		}else{
			$.ajax({
					url : "/doppio/qna/qna_content_cmtWrite.th",
					type: "POST",
					data : JSON.stringify({
						"num" : $(this).data("qnum"),
						"id" : $('#id').val(),
						"cmcomment" : $('#cmcomment').val()
					}),
					contentType : 'application/json',
					success : function(result){
						location.reload();
					}
				});//ajax	
		
		}
	});
	
	
	
	
	
	
	
	
	/*******************
	 * 레시피 - 댓글 수정 폼체크 - 공통
	 ********************/	
 	$(".commbtnup").click(function(){
 	
 		$(this).attr("style","display:none");
 		var cnum = $(this).data("cnum");
 		var oldCmt = $('.'+cnum+'> td').text();
		console.log(cnum);
 		
 		var cmtform = '<td>'
        cmtform+='<textarea style="width: 520px; vertical-align:top;" id="updatecmt">'
        cmtform+=oldCmt
        cmtform+='</textarea>'
        cmtform+='<button style="width: 50px; height: 61px;" data-cnum="'
        cmtform+=cnum
        cmtform+='"id="cmtSave">저장</button>'
        cmtform+='</td>'	
		  			
		
		$('.'+cnum+'> td').empty();
		$('.'+cnum+'> td').append(cmtform);
		
	});
	
	
	
	
	/*******************
	 * 댓글 수정 api 호출 admin cf
	 ********************/	
	$(document).on('click','#cmtSave',function(){ 			
		//console.log("aaa");
		$.ajax({
			url : "/doppio/admin/admin_recipe/recipe_content_cf_cmtUpdate.th",
			type: "POST",
			data : JSON.stringify({
				"cmnum" : $(this).data("cnum"),
				"cmcomment" : $('#updatecmt').val()
			}),
			contentType : 'application/json',
			success : function(result){
				location.reload();
			}
		});//ajax
	});
	
	
	/*******************
	 * 레시피 - 댓글 삭제 폼체크 admin cf
	 ********************/	
 	$(".commbtndel").click(function(){

 		$.ajax({
			url : "/doppio/admin/admin_recipe/recipe_content_cf_cmtDelete.th",
			type: "POST",
			data : JSON.stringify({
				"cmnum" : $(this).data("cnum")
			}),
			contentType : 'application/json',
			success : function(result){
				location.reload();
			}
		});//ajax
 			
		  			
		
	});
		
	
	
	/*******************
	 * 장바구니로 이동 package cf
	 ********************/	
	
	$("#cart_btn_cf").click(function(){
		
		$.ajax({
			url : "/doppio/package/package_content_cf_cart.th",
			type: "POST",
			data : JSON.stringify({
				"pnum" : $(this).data("pnum"),
				"id" : $('#id').val(),
				"popid" : $('#popid').val(),
				"cacount" : $('#cacount').val()
			}),
			contentType : 'application/json',
			success : function(result){
				//location.href("/doppio/mypage/doppio_mypage_basket.th");
				//console.log("aaa");
				var check = confirm("상품이 장바구니에 담겼습니다. 확인하시겠습니까?");  
			        
		        if (check == true) {
		        	 
		        	package_cart_cf.submit();
		        	location.assign("/doppio/mypage/doppio_mypage_basket.th");
		        } 
			}
		});//ajax
		
		
	});
	
	
	/*******************
	 * 회원탈퇴 신청처리
	 ********************/
	

	
	
	
	
	
	
	
		
}); //ready function


















