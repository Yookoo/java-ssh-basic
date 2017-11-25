
var url = "${pageComtext.request.contestPath}/articleAction_findUserArticleByPage.action"


function init(list) {
	var dataHtml = "";
	$.each(list, function(i, val) {

		console.log(val);
		var c1 =val.content;
		var c2 = c1.substring(c1.indexOf(">")+1, c1.lastIndexOf("<"))
		
		dataHtml += '<div class="art-list-item"><a href="articleAction_findById.action?id='+val.id+'" class="title">' + val.title
			+ '</a><div>' + c2.substring(0, 500) + '...</div><div class="info"><span>' + val.userId
			+ '</span> ⋅ <span>' + val.click + '</span> ⋅ <span>' + val.jointime + '</span></div></div>';
		
	})
	$("#user-art-list").html(dataHtml);
}

/** 
 * Initialisation function for pagination
 */


function initPagination() {
	// count entries inside the hidden content

	$.get(url, function(data) {

		init(data.list);
		console.log("data:"+data.totalCount);
		// Create content inside pagination element
		$("#pager").pagination(data.totalCount, {
			prev_text :"<上一页",
			next_text :"下一页>",
			callback : function(page_index, jq) {
				
				$.get(url, {
					page : page_index+1
				}, function(data) {
					console.log(data)
					init(data.list);
				}, "json")
				//return false;
			}
		});

	}, "json")

}

// When document is ready, initialize pagination

$(document).ready(function() {
	initPagination();
});