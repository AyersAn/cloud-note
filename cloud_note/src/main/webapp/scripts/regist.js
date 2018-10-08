function userRegist(){
			//测试单击事件的绑定
			//alert("==");
			//获取参数
			var name = $("#regist_username").val().trim();
			var nick = $("#nickname").val().trim();
			var password = $("#regist_password").val().trim();
			var final_password = $("#final_password").val().trim();
			//alert(name+","+nick+","+password+","+final_password);
			//alert(password.length);
			$("#warning_1 span").html("");
			$("#warning_2 span").html("");
			$("#warning_3 span").html("");
			//检查数据格式
			//检查用户数据
			var ok = true; //表示参数状态
			
			if(name == ""){
				$("#warning_1 span").html("用户不能为空");
				$("#warning_1").show();
				ok = false;
				//alert(name);
			}
			//检查密码数据：1-非空 2-不能小于6位
			if(password == ""){
				$("#warning_2 span").html("密码不能为空！");
				$("#warning_2").show();
				ok = false;
			}else if(password.length > 0 && password.length < 6){
				$("#warning_2 span").html("密码不能小于6位");
				$("#warning_2").show();
				ok = false;
			}
			//检查确认密码：1-非空 2- 是否与密码数据保持一致
			if(password != final_password){
				$("#warning_3 span").html("两次输入密码不相同！");
				$("#warning_3").show();
				ok = false;
			} 
			//数据校验通过，发送ajax（）请求
			if(ok){
				$.ajax({
					//请求路径
					url:path+"/user/add.do",
					//定义发送方式
					type:"post",
					//参数
					data:{"name":name,"nick":nick,"password":password},
					//返回的数据
					dataType:"json",
					//处理回调数据
					success:function(result){
						if(result.status == 0){
							//alert(result.msg);
							//返回到登录页面
							$("#back").click();
						}else if(result.status == 1){//用户名已存在
							//alert(result.msg);
							$("#warning_1 span").html(result.msg);
							$("#warning_1").show();
						}
						
					},
					error:function(){
						alert("注册失败");
						}
				});
			}
		}