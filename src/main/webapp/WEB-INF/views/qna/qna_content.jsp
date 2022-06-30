<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div id="containdiv">
		<section>
			<div class="title">
				<p>Q & A</p><br><br>
			</div>
			
			
			<table id="headtable">
				<tr>
					<td class="tolistTd"><a href="http://localhost:9000/doppio/qna/qna_list.th" id="tolist">> 목록으로</a></td>
				</tr>
				
				<tr id="hits">					
					<td colspan="4">조회수 : ${vo.qhits }</td>
				</tr>
				<tr class="containerhead">
					<td>${rno }</td>
					<td width="60%"><span>${vo.qtitle }</span></td>
					<td> 작성자 ${vo.id }</td>
					<td class="t_right"> 작성일 : ${vo.qdate }</td>
				</tr>
			</table>
			
			<hr id="middleline">
			<form name="delForm" action="/doppio/qna/qna_content.th?qnum=${vo.qnum }" method="post">
			<br>
			<table id="contenttable">
				<tr id="contenthead">
					<td></td>
					<c:if test="${sessionScope.sid == vo.id || sessionScope.sid == 'test'}">
					<td>
					<button type="button" class="delbtn" onclick="location.href='http://localhost:9000/doppio/qna/qna_update.th?qnum=${vo.qnum}&rno=${rno}'">수정</button>
					<button type="submit" class="delbtn">삭제</button></td>
					</c:if>
				</tr>
			</table>
			</form>
			<br>
			<table id="contentmain">
				<tr>
					<td style="white-space: pre-wrap;">${vo.qcontent }</td>
				</tr>
			</table>
			<br><br><br><br><br><br>
			<!-- <div id="comment">
			<h4>댓글</h4><br>
			<div id="comment_1">
				<div class=innerc>
					<textarea rows="4" cols="170" class="ment"></textarea>

					<button id="cbut" class="mentbtn">등록</button>
				</div>	
			</div>
			</div>
			<br><br><br><br><br> -->
			
			<div class="댓글">
       <%-- 	<div class="subtitle">&nbsp;댓글 ${vo.qnum }</div> --%>
        	<div class="commentfield2">
        		<c:if test="${sessionScope.sid != null }">
				<form name="comment_write" action="doppio/qna/qna_write.th" method="post">
			        		<input type="hidden" name="cmcate_num" value="${vo.qnum}">
			        		<input type="hidden" name="id" id="id" value="${sessionScope.sid }">
			           	<textarea rows="1" cols="40" placeholder="내용을 입력해 주세요" id="cmcomment" name="cmcomment"></textarea>
			          		<button type="button" class="enter w-btn-skin-outline" id="btnComm7" data-qnum="${vo.qnum}">등록</button>  
			    </form> 
			    </c:if> 

        		<table class="commtable">        			        			
        			<c:forEach var="vo" items="${list }">
        			<tr class="commbtn">
        				<td colspan="2" class="commbtntd"><p>${vo.cmdate }</p>&nbsp;
        				<c:if test="${sessionScope.sid == vo.id }">
        				<button class="commbtnup" data-cnum="${vo.cmnum}">수정</button>
        				<button type="submit" data-cnum="${vo.cmnum}" class="commbtndel">삭제</button>
        				</c:if>
        				</td>
        				
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
		</section>
		
	</div>
	
	
	
	
	<!-- footer -->
	<jsp:include page="../doppio_footer.jsp"></jsp:include>
</body>
</html>