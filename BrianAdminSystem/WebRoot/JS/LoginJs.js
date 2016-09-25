  
/*
 * 预加载cookie值
 */
$(document).ready(function () {
    if ($.cookie("reUser") == "checked") {
    $("#remember-me").attr("checked", true);
    $("#adminname").val($.cookie("username"));
    $("#adminpassword").val($.cookie("password"));
    }
  });

	function getID(id){
			return document.getElementById(id);
		}
		/*************************验证用户名的格式****************************/
       		  /*  function checkuser(us)
			{
				var reg=/^[a-zA-z]\w{6,15}$/;//只允许使用大小写字母、数字、下划线。只许以
				return (reg.test(us));	
			}
			document.getElementById('User').onkeyup=function ()
			{
				if(document.getElementById('User').value=="")
				{
					document.getElementById('Uwarning').innerHTML="";		
				}
				else
				{
						if(checkuser(this.value))
					{
						document.getElementById('Uwarning').style.color='#FC3';
						document.getElementById('Uwarning').innerHTML="此用户名可用";
					}
					else
					{
						document.getElementById('Uwarning').style.color='red';
						document.getElementById('Uwarning').innerHTML="请输入6~16位有字母、数字、下划线组成的用户名";
					}	
				}
			}// JavaScript Document
			*/
	function checkLogin(){
		var uname=$("#adminname").val().trim();
	 	var upassword=$("#adminpassword").val().trim();
	 	
		if($("#remember-me").attr("checked")== "checked"){
			alert("haha");
			$.cookie("reUser","checked",{expires:7});
			$.cookie("username",uname,{expires:7});
			$.cookie("password",upassword,{expires:7});
			
		}
		
		else{
			alert("haha...");
			$.cookie("reUser","false",{expires:-1});
			$.cookie("username","",{expires:-1});
			$.cookie("password","",{expires:-1});
		}
		
	   $.ajax({
           url: "User/loginServlet",
           type: "POST",
           data: { uname: uname, upassword: upassword},
           dataType: "json",
           success: function (result) { 
               if (result.code == 1) {
            	   	alert("欢迎进入后台管理系统");
               		location.href="Home/index.jsp";
               }
               else{
            	   noty({ text: "用户名或密码错误", type: 'warning', layout: 'topCenter', timeout: 500 }); 	             	   
               }
           } 
	   })			
	}	

	function KeyDown(){
		if(event.keyCode == 13){
			$("#login").click();
		}
	}
	
	


	
	
	
	
	
			
			
			
