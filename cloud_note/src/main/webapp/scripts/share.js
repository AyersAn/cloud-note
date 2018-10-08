
//按更对按钮,加载查询结果下一页
function moreSearchShare(){
	//$("#search_ul").remove();
	//获取参数
	var keyword = $("#search_note").val().trim();
	page += 1;
	//发送ajax请求,加载列表
	loadPageShare(keyword,page);
}

function loadPageShare(keyword,page){
	//发送ajax请求
	$.ajax({
		url:path+"/share/search.do",
		type:"post",
		data:{"keyword":keyword,"page":page},
		dataType:"json",
		success:function(result){
			//alert(result.msg);
			//获取数据
			var shares = result.data;
			//alert(shares[0].cn_share_id);
			//遍历数据
			for(var i = 0;i < shares.length;i++){
				//alert(i);
				//获取shareId
				var shareId = shares[i].cn_share_id;
				//获取shareTitle
				var shareTitle = shares[i].cn_share_title;
				//alert(shareId+","+shareTitle);
				//获取li对象
				var sli = "";
				sli += '<li class="online">';
				sli += '<a>';
				sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
				sli += shareTitle;
				sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				sli += '</a>';
				sli += '</li>';
				//绑定shareId
				var $li = $(sli);
				$li.data("shareId",shareId);
				
				//将li对象添加到ul中
				$("#search_ul").append($li);
				//切换显示区域
				$("#pc_part_2").hide();
				$("#pc_part_6").show(); 
			}
		},
		error:function(){
			alert("笔记搜索失败");
		}
	});
};

//按回车,加载搜索结果第一页
function searchShareNote(event){
	
	var code = event.keyCode;
	//alert(code);
	if(code == 13){
		//清空原有列表
		$("#search_ul li").remove();
		//获取请求参数
		var keyword = $("#search_note").val().trim();
		//alert(keyword);
		page = 1;
		loadPageShare(keyword,page);
	}
};


//分享笔记
function shareNote(){
	//alert("分享");
	//获得请求参数
	var $li = $(this).parents("li");
	var noteId = $li.data("noteId");
	alert(noteId);
	//发送请求
	$.ajax({
		url:path+"/share/add.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var noteTitle = $li.text();
				var sli = "";
				sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
				sli += noteTitle;
				sli += '&nbsp;&nbsp;&nbsp;&nbsp;';
				sli += '<i class="fa fa-sitemap"></i>';
				sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				//将笔记li元素的<a>标记内容替换
				$li.find("a").html(sli);
				alert(result.msg);
			}
				
		},
		error:function(){
			alert("笔记分享失败");
		}
	}); 
	
};





