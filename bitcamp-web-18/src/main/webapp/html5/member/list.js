"use strict"

var {page, size} = $.parseQuery(location.href);

let tbody = $('#eListTable > tbody'); 
let data = null;

if (page != undefined && size != undefined) {
    loadList(page, size);
} else {
    loadList(1, 3);
}
$(ePrevBtn).click(function() {
    loadList(data.page - 1, data.size);
});

$(eNextBtn).click(function() {
    loadList(data.page + 1, data.size);
});

function loadList(page, size) { 
	$.getJSON('../../json/member/list',
			{
		          page:page,
		          size:size
			})
			.done(
			function(result){
			    data = result; // 글로벌 변수에 저장해야 다른함수에서 사용가능
		        tbody.html('');
		        for (var item of data.list) {
		            $("<tr>")
		              .html(`<td><a href='#' data-id='${item.id}' class='viewLink'>${item.id}</a></td>
		                <td>${item.email}</td>`)
		              .appendTo(tbody);
		        }
		        
		        $(ePageNo).html(data.page);
		        if (data.page <= 1)
		            $(ePrevBtn).attr('disabled', '');
		        else 
		            $(ePrevBtn).removeAttr('disabled');
		        
		        if (data.page >= data.totalPage)
		            $(eNextBtn).attr('disabled', '');
		        else
		            $(eNextBtn).removeAttr('disabled');
		       

	
		});

}
// 이방식은 실행 시점에 존재하는 태그에 대해서만 이벤트 핸들러를 등록할 수 있다.
/*
$('.viewLink').click(function (event) {
    
    event.preventDefault();
    var id = $(event.currentTarget).attr('data-id');
    location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
});

*/
// 실행 시점에 존재하지 않더라도 이벤트 핸들러를 등록하는 방법은?
// -> 앞으로 생성될 태그의 부모에 리스너를 등록하는 것이다.
// 버블링 때문에 가능  아무거나 눌러도 된다. 
tbody.on('click','a.viewLink',function(event){
	  console.log("============>");
	  event.preventDefault();
	  var id = $(event.target).attr('data-id');
	  location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
});