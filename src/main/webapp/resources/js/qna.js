

$(document).ready(function(){
	
	searchFunc(1);
	
	
	//검색버튼 클릭 이벤트
	$("#searchBtn").click(function(){
 	
 		searchFunc(1);
		
	});
	
	
	$(document).on('click','.paging > li > button',function(e){
		
		$(this).addClass("on");
		searchFunc(Number($(this).text()));
	});
	

});

function searchFunc(page){

		$.ajax({
			url : "/doppio/qna/qna_list.th",
			type: "POST",
			data : JSON.stringify({
				"searchType" : $('select[name=searchType]').val(),
				"keyword" : $('input[name=keyword]').val(),
				"rpage" : page,
				"start" : (page*5)-4, 
				"end"   : page*5
			}),
			contentType : 'application/json', 
			success : function(result){
							
				var res = result.searchList;
				
				//일단 그리려는 영역 비우기
				$('#board_table').empty();
				$('.paging').empty();
				
				var pageHtml='';
				var html = '<tr id="board_head"><th>번호</th><th width="60%">제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>' 
				
				$.each(res,function(i){
					html+='<tr class="boardhover">';
					html+='<td>'+(i+1)+'</td>';
					html+='<td class="write_title">';
					html+='<a href="http://localhost:9000/doppio/qna/qna_content.th?qnum=';
					html+=this.qnum+'&rno='+this.rno+'"class="boardtitle">'+this.qtitle+'</a>';
					html+='</td>';
					html+='<td>'+this.id+'</td>';
					html+='<td>'+this.qdate+'</td>';
					html+='<td>'+this.qhits+'</td>';
					html+='</tr>';	
				});
				
				var pageNum = 0;
				if($('input[name=keyword]').val().length <= 0){
					pageNum = parseInt(result.totalListCnt/5)+1;
				}else{
					pageNum = parseInt(result.resultCnt/5)+1;
				}
				
				
				for(var i = 1 ; i <= pageNum ; i++){
				
					pageHtml+='<li><button>'+i+'</button></li>';
				}
				
				
				html+='</div></td></tr>';
				
				
				$('#board_table').append(html);
				$('.paging').append(pageHtml);
			}
		});//ajax

}



