
//添加笔记本
function addNoteBook(){
	//alert("ii");
	//获取请求的参数
	var userId = getCookie("userId");
	var bookName = $("#input_notebook").val().trim();
	//alert(userId+","+bookName);
	//发送ajax请求
	$.ajax({
		url:path+"/book/add.do",
		type:"post",
		data:{"userId":userId,"bookName":bookName},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				$("#can").html("");
				$(".opacity_bg").hide();
				var sli = "";
				sli += '<li class="online">';
				sli += '<a>';
				sli += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
				sli += '</i>';
				sli += bookName;
				sli += '</a>';
				sli += '</li>';
				//将sli转成jQuery对象
				var $li = $(sli);
				/*
				 * 将bookId值与jQuery对象绑定，
				 * 点击笔记本，其中的笔记信息会在全部笔记中显示
				 */
				var bookId = result.data;
				//alert(bookId);
				$li.data("bookId",bookId);
				//将li元素添加到笔记本ul列表区
				$("#book_ul").append($li);
				alert(result.msg);
			}
		},
		
		error:function(){
			alert("笔记本创建失败");
		}
	});
};


//根据用户id显示笔记本列表
function loadUserBooks(){
	//获取userId
	var userId = getCookie("userId");
	//alert(userId);
	//判断是否获取到有效userId
	if(userId == null){
		//重新转发到登录页面
		window.location.href("log_in.html");
	}else{
		//发送ajax请求
		$.ajax({
			url:path+"/book/loadBooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			//回调
			success:function(result){
				//alert(result.status);
				//判断查询是否成功
				if(result.status==0){
					
					//获取笔记本集合
					//alert(result.msg);
					var books = result.data;
					//alert("books");
					for(var i = 0;i < books.length;i++){
						//获取笔记本id
						var bookId = books[i].cn_notebook_id;
						//获取笔记本名称
						var bookName = books[i].cn_notebook_name;
						//创建一个笔记本列表的li元素
						createBookLi(bookId,bookName);
						
					}
				}
			},
			error:function(){
				alert("笔记本加载失败");
			}
		});
	}
};

//创建一个笔记本li元素
function createBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>';
	sli+=bookName;
	sli+='</a>';
	sli+='</li>';
	//将sli字符串转换成jQuery对象li元素
	var $li = $(sli);
	/*
	 * 将bookId值与jQuery对象绑定，
	 * 点击笔记本，其中的笔记信息会在全部笔记中显示
	 */
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
	 
	
};



