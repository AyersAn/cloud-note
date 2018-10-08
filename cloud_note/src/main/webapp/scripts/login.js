
function userLogin(){
		//测试绑定事件
		//alert("荷湖荷湖荷湖");
		//获取参数
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		var code = $("#imgCode").val().trim();
		//alert(code);
		/* alert(name+","+password); */
		/* 获取该节点，并将其中的值清空 */
		$("#count_span").html("");
		$("#password_span").html("");
		$("#code_span").html("");
		//alert("hhh")
		//格式检测
		var ok = true;
		if(name==""){
			$("#count_span").html("用户名不能为空");
			ok = false;
		}
		if(password==""){
			$("#password_span").html("密码不能为空");
			ok = false;
		}
		if(code==""){
			$("#code_span").html("验证码不能为空");
			ok = false;
		}
		//发送请求
		if(ok){		//检测格式通过
			//发送ajax请求
			//alert("ok");
			$.ajax({
				url:path+"/user/login.do", //请求地址
				type:"post",//发送数据的方式
				data:{"name":name,"password":password,"code":code},//请求类型
				dataType:"json",//服务器返回
				success:function(result){
					//result是服务器返回的json结果
					if(result.status == 0){
						//alert(result.status)
						//将用户信息保存到cookie
						var userId = result.data.cn_user_id;
						addCookie("userId",userId,2);
						window.location.href="edit.html";
						//alert("登录成功");
						//alert("result=0");
					}else if(result.status == 1){ //用户名错误
						$("#count_span").html(result.msg);
					}else if(result.status == 2){
						$("#password_span").html(result.msg);
					}else if(result.status == 3){
						$("#code_span").html(result.msg);
					}
				},
				error:function(){
					alert("登录失败");
				}
			});
		}
			
	}