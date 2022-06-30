<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>          
<!DOCTYPE html>
<html> 
	<head>
		<meta charset="UTF-8">
		<title>DOPPIO</title>
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/doppio_css.css">
		<link rel="stylesheet" href="http://localhost:9000/doppio/resources/css/recipe_content_css.css">
		<script src="http://localhost:9000/doppio/resources/js/jquery-3.6.0.min.js"></script>
		<script src="http://localhost:9000/doppio/resources/js/doppio.js"></script>
	</head>
	<body>
	
		<!-- header -->
		<jsp:include page="../doppio_header.jsp"></jsp:include>
		
		<!-- content -->
		<br>
		<a href="http://localhost:9000/doppio/recipe/recipe_list_ncf.th?rcate=ncf" id="tolist" class="tolist2"> >목록으로</a>
	<div class="recipe_content">
		<div class="content_div">
				
				<h2>${vo.rtitle}</h2> 
				<div class="table_div">
						<table class="content_table">
							<tr>
								<th> ${vo.rhits} </th><td>명이 이 레시피에 관심을 가졌어요! ❤.❤</td>
							</tr>
						</table>
				</div><br>
			<div class="iframediv">
				<iframe height="500" width="100%" src="https://www.youtube.com/embed/${vo.rurl }" 
						title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
						encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
			<br><br>
			<div class="share" >
				<!-- <a href="#"><img alt="url" src="http://localhost:9000/doppio/resources/img/url_con.png" class="share_con" width="45px" height="45px"></a>	
				<a href="#"><img alt="twitter" src="http://localhost:9000/doppio/resources/img/twt_con.png" class="share_con" width="45px" height="45px"></a>	
				<a href="#"><img alt="kakao" src="http://localhost:9000/doppio/resources/img/kt_con.png" class="share_con" width="45px" height="45px"></a>	 -->
			<div class="purchasebtn">
        		<a href= "http://localhost:9000/doppio/package/package_list_ncf.th"><img src="http://localhost:9000/doppio/resources/img/recipe_click5.png" width="600px;"></a>
     	 	</div>
     	 	</div>
			</div>
		</div>
		
		<div class="content" style="width: 100%;">
   			<div style="width: 800px; margin: 0 auto; ">
     		 <div class="재료" style="width: 265px; float: left; border-top: 5px double #d2d2d2; border-radius:10px; padding-top: 10px; padding-bottom: 5px;">
		         <div class="subtitle">Ingredients</div>
				 <div style="margin-top: 0px;">
			         <p class="recipe" style="width: 250px; white-space: pre-wrap; margin: 0; ">${vo.rcontent1}</p>			     
     			 </div>
      		</div>
      		
    		  <div class="레시피" style="width: 500px; float: right; border-top: 5px double #d2d2d2; border-radius:10px; padding-top: 10px;  margin-bottom: 100px;" >
		         <div class="subtitle">Recipe</div>
		         <div style="margin-top: 0px;">
			            <p class="recipe" style="width: 500px; white-space: pre-wrap; margin: 0;">${vo.rcontent2}</p>			     
       			 </div>
     		 </div>
	 

    	<div class="댓글" >
       	<div class="subtitle" style="clear: both;">Tip Comments</div>
        	<div class="commentfield">
        		<c:if test="${sessionScope.sid != null }">
				<form name="comment_write_ncf" action="doppio/recipe/recipe_write_ncf.th" method="post">
			        		<input type="hidden" name="cmcate_num" value="${vo.rnum}">
			        		<input type="hidden" name="id" id="id" value="${sessionScope.sid }">
			           	<textarea rows="1" cols="40" style="width: 600px;" placeholder="내용을 입력해 주세요" id="cmcomment" name="cmcomment"></textarea>
			          		<button type="button" class="enter w-btn-skin-outline" id="btnComm4" data-rnum="${vo.rnum}">등록</button>  
			    </form> 
			    </c:if> 

        		<table class="commtable2" >
        			        			
        			<c:forEach var="vo" items="${list }">
        			<tr class="commbtn">
        				<td colspan="2" class="commbtntd"><p>${vo.cmdate }</p>&nbsp;
        				<c:if test="${sessionScope.sid == vo.id || sessionScope.sid == 'test'}">
        				<button class="commbtnup" data-cnum="${vo.cmnum}">수정</button>
        				<button type="submit" data-cnum="${vo.cmnum}" class="commbtndel">삭제</button></td>
        				</c:if>
        			</tr>
        			
        			<tr class="cmtArea"> <!-- style="vertical-align: text-top;" -->
        				<tr class="${vo.cmnum}">
	        				<th class="commth" data-cnum="${vo.cmnum}">${vo.id}</th>
	        				<td class="commtd" data-cnum="${vo.cmnum}">${vo.cmcomment}</td>
        				</tr>
        				
        				<%-- <td>
        				<textarea style="width: 520px; vertical-align:top;">${vo.cmcomment}</textarea>
        				<button type="button" style="width: 50px; height: 61px;" id="cmtSave">저장</button>
        				</td> --%>
        				
        			</tr>
        			</c:forEach>
        		 </table>        		
     		
        	</div>
     		</div>
   		</div>
  		</div>
  		
		<!-- footer -->
		<jsp:include page="../doppio_footer.jsp"></jsp:include>
	</body>
</html>