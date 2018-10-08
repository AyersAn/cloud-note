









//删除笔记
function deleteNote(){
		//alert("删除");
		//获取请求数据
		var $li = $(this).parents("li");
		var noteId = $li.data("noteId");
		//alert(noteId);
		//发送请求
		$.ajax({
			url:path+"/delete/delete.do",
			type:"post",
			data:{"noteId":noteId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					//location.reload();  //刷新当前页面
					//parent.location.reload();//刷新父亲对象（用于框架）
				}
				
			},
			error:function(){
				alert("删除笔记失败");
			}
		});
	};


//增加笔记信息
function addNote(){
	//alert("绑定生效");
	//获得请求参数
	var title = $("#input_note").val().trim();
	var userId = getCookie("userId");
	//获取笔记本ID,
	var $li = $("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	//设置判断值
	var ok = true;
	if(title == ""){
		ok = false;
		$("#title_span").html("标题不能为空");
	}
	if(userId == ""){
		ok = false;
		window.location.href = "log_in.html";
	}
	if(ok){
		$.ajax({
			url:path+"/note/add.do",
			type:"post",
			data:{"title":title,"userId":userId,"bookId":bookId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					//alert(result.msg);
					var note = result.data;
					
					var noteTitle = note.cn_note_title;
					var noteId = note.cn_note_id;
					//alert(noteTitle+","+noteId);
					/* var sli = "";
					sli += '<li class="online">';
					sli += '<a>';
					sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
					sli += noteTitle;
					sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					sli += '</a>';
					sli += '<div class="note_menu" tabindex="-1">';
					sli += '<dl>';
					sli += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					sli += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					sli += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					sli += '</dl>';
					sli += '</div>';
					sli += '</li>';
					//将字符串sli转换成jQuery对象
					var $li = $(sli);
					
					$li.data("noteId",noteId);
					//将li添加到note ul 中
					$("#note_ul").append($li); */
					createNoteLi(noteId,noteTitle);
					alert(result.msg);
				}
			},
			error:function(){
				alert("笔记创建失败");
			}
		});
	} 
	 
};


//更新笔记信息
function updateNote(){
	//alert("=====");
	//获取笔记id，该id绑定在笔记的li上
	var $li = $("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	//alert(noteId);
	//获取笔记标题和内容
	var noteTitle = $("#input_note_title").val().trim();
	var noteBody = um.getContent();
	//alert(noteId+","+noteTitle+","+noteBody);
	$.ajax({
		url:path+"/note/update.do",
		type:"post",
		data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				//alert("笔记信息保存成功");
				var sli = "";
				sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
				sli += noteTitle;
				sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				//将sli替换到li 的a元素中
				$li.find("a").html(sli);
				alert(result.msg);
				
			}
		},
		error:function(){
			alert("笔记信息保存失败");
		}
	});
};


//显示笔记信息
function loadNote(){
	//设置选中效果
	$("#note_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	
	//获取noteId,发送的参数
	var noteId = $(this).data("noteId");
	//alert("noteId:"+noteId);
	
	$.ajax({
		url:path+"/note/load.do",
		type:"post",
		data:{"noteId":noteId},
		dataTypr:"json",
		success:function(result){
			if(result.status == 0){
				//获取笔记信息
				var note = result.data;
				var noteTitle = note.cn_note_title;
				var noteBody = note.cn_note_body;
				//alert(noteTitle+","+noteBody);
				/* var title = $("#input_note_title").attr("placeholder"); */
				//设置笔记标题
				$("#input_note_title").val(noteTitle);
				//设置笔记内容
				um.setContent(noteBody);
				
			}
		},
		error:function(){
			alert("笔记信息加载失败");
		}
		
	});
};

//显示笔记本中的笔记
function loadBookNotes(){
		//alert("动态绑定成功");
		//获取bookId，.val().trim()  注意
		var bookId = $(this).data("bookId");
		//alert("bookId:"+bookId);
		//alert("bookId");
		//设置选中效果
		$("#book_ul a").removeClass("checked");
		$(this).find("a").addClass("checked");
		
		$.ajax({
			url:path+"/note/loadnotes.do",
			type:"post",
			data:{"bookId":bookId},
			dataType:"json",
			success:function(result){
				//切换显示区域
				$("#pc_part_6").hide();
				$("#pc_part_2").show(); 
				//alert(result.msg);
				//alert(result.data);
				//if(result.status == 0){
				//清除原列表信息
				$("#note_ul").empty();
				//$("#note_ul").clean();
				//获取笔记信息
				var notes = result.data;
				
				//alert(notes.length);
				for(var i = 0;i < notes.length;i++){
					//alert(notes[i].cn_note_id);
					var noteId = notes[i].cn_note_id;
					//alert("noteId,"+noteId);
					var noteTitle = notes[i].cn_note_title;
					//alert(noteId+","+noteTitle)
					createNoteLi(noteId,noteTitle);
				}
				//alert(notes); 
			},
			error:function(){
				alert("笔记加载失败");
			}
		});
	//}
};





function createNoteLi(noteId,noteTitle){
	var sli = "";
	//alert(sli);
	sli += '<li class="online">';
	sli += '<a>';
	sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> ';
	sli += noteTitle;
	sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli += '</a>';
	sli += '<div class="note_menu" tabindex="-1">';
	sli += '<dl>';
	sli += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli += '</dl>';
	sli += '</div>';
	sli += '</li>';
	
	//将sli字符串转换成jQuery对象li元素
	var $li = $(sli);
	/*
	 * 将noteId值与jQuery对象绑定，
	 * 点击笔记，其中的笔记信息会在全部笔记中显示
	 */
	$li.data("noteId",noteId);
	//将li元素添加到笔记ul列表区
	$("#note_ul").append($li);

};