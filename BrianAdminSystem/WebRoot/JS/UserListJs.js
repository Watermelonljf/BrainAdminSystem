var itme;
	    var pageSize = 10; //一页显示的记录数
	    var pageIndex = 1; //当前页
	    var PSize = 10;
	    var pageCount=0;
	    var orderby = "", strSearch = "";
	    var count = 0;  //总记录数
	    $(document).ready(function () {
	     getUserList();
	    // getSendMessageList();
	        document.getElementById("pagesize").onchange = function () {
	            if (this.value < 0) {
	                pageSize = count;
	            } else
	                pageSize = this.value;
	            getUserList();
	        };
	        document.getElementById("search").onkeyup = function () {
	            strSearch = this.value;
	            getUserList();
	        };
	        

	        document.getElementById("selectRead").onclick = function () {
	            var lst = document.getElementsByClassName("checkboxes");
	            var str = "", shopnum = "";
	            for (var i = 1; i < lst.length; i++) {
	                if (lst[i].checked) {
	                    str += (str == "") ? lst[i].value : ("," + lst[i].value);
	                    shopnum += (shopnum == "") ? lst[i].title : ("," + lst[i].title);
	                }
	            }
	            
	            if (str.length > 0)
	                noty({
	                    text: '确定要将勾选信息标记为已读吗',
	                    type: 'information',
	                    layout: 'center',
	                    buttons: [
	                        {
	                            addClass: 'btn blue', text: '确定', onClick: function ($noty) {
	                                $.ajax({
	                                    url: "com.Manager.Communication/markerMessage",
	                                    type: "POST",
	                                    data: {
	                                        ids: str
	                                    },
	                                    dataType: "json",
	                                    success: function (result) {
	                                        if (result.code == 1) {               
	                                            $noty.close();
	                                            noty({ text: result.msg, type: 'information', layout: 'center', timeout: 2000 });
	                                            getUserList();
	                                            uncheckAll();
	                                        }
	                                        else {
	                                            noty({ text: result.msg, type: 'warning', layout: 'center', timeout: 2000 });
	                                        }
	                                    },
	                                    error: function () {
	                                        noty({ text: "检查网络设置", type: 'warning', layout: 'center', timeout: 2000 });
	                                    }

	                                });

	                            }
	                        },
	                        {
	                            addClass: 'btn red', text: '取消', onClick: function ($noty) {
	                                $noty.close();
	                            }
	                        }
	                    ]
	                });
	        };


	    });
	    
	  //取消选中  
	    function uncheckAll()   {   
	    	 var lst = document.getElementsByClassName("checkboxes");
	    	 for (var i = 1; i < lst.length; i++) {
	    		 if(lst[i].checked){
	    			 lst[i].checked=false;
	    		 }
	    	 }
	    }  
	    /**标准化时间*/
		function StandardTime(Time){
			if(Time==null){
				return "未知时间";
			}
			else{
				return new Date(Time.time).toLocaleDateString()+" "+Time.hours+":"+Time.minutes+":"+Time.seconds;
			}
		}
	    /**标准化状态*/
	     function ShowStatu(statu){
	    	if(statu==0){
	    		return '<span class="label label-warning">未读</span>';
	    	}else{
	    		return '<span class="label">已读</span>';
	    	}
	    } 
	    function getUserList() {
	   
	    //alert("pageSize:"+pageSize+"pageIndex:"+pageIndex);
	        $.ajax({
	            url: "Admin/GetUserInfoSrevlet",
	            type: "POST",
	            data: { pageSize: pageSize, pageIndex: pageIndex, strSearch: strSearch,type:1},
	            dataType: "json",
	            success: function (result) {            	
	                if (result.code == 1) {
	                    count = result.count;
	                    var html = "";
	                    var data=result.UL; 
	                 //   alert(new Date(data[1].sendTime.time).toLocaleDateString());
	                    for (var i = 0; i < data.length; i++) {
	                
	                    	
	                        html += '<tr class="odd gradeX">';
	                        html += '<td class="sorting_1"><div class="checker"><span><input type="checkbox" onclick="checkItem(this);" class="checkboxes" value=' + data[i].userId + '></span></div></td>';
	                        html += '<td class="hidden-480">' + data[i].strUserName+ '</td>';
	                        html += '<td class="hidden-480">' + data[i].strUserSex+ '</td>';
	                        html += '<td class="hidden-480">' +data[i].strUserTel+ '</td>';
	                        html += '<td class="hidden-480">' +data[i].strUserQ+ '</td>';
	                        html += '<td class="hidden-480">' +data[i].strUserEmail+ '</td>';  
	                         html += '<td class="hidden-480">' +data[i].strAddress+ '</td>';
	                        /* html += '<td class="hidden-480">' +data[i].onTime+ '</td>';*/
	                        /* html += '<td class="hidden-480"><a href="./com.Manager.Communication/EditContact?ID=' + data[i].ID + '&active=menupage6_6" class="label label-important" style="color: white;">不再显示</a></td>'; */
	                    }
	                    $("#ListBody").html(html);
	                }
	                else {
	                	count=0;
	                    var html = "";
	                    html += "<tr class='odd gradeX'>";
	                    html += "<td colspan='10' style='text-align:center'>抱歉，还没有任何信息</td>";
	                    html += "</tr>";
	                    $("#ListBody").html(html);
	                }
	                $("#chk_All").attr("checked", false).closest("span").removeClass("checked");

	                GetPageInfo(count,1);
	            },
	            error: function () {
	                console.log("error");
	            }
	        });
	    }
		
	    function GetPageInfo(count,type) {
	        var pageHtml = "";
	        var pageInfo="pageInfo";
	        var pagePart="pagePart";
	      //  var pageCount=0;
	        var recordCount=0;
	        if(type==1){pageInfo="pageInfo";pagePart="pagePart";}
	        else{pageInfo="pageSendInfo";pagePart="pageSendPart";}
	        if (count != 0) {
	        	//alert("page:"+count+"pageSize:"+pageSize+"pageIndex:"+pageIndex);
	            recordCount = count;
	            pageCount = Math.ceil(recordCount / pageSize);
				//alert("pageCount:"+pageCount);
	            if (pageIndex == 1) {
	                pageHtml += "<li class='prev disabled pagehover' ><a>← <span class='hidden-480'>上一页</span></a></li>";
	            }
	            else {
	                pageHtml += "<li class='prev  pagehover' onclick='GotoPage(" + Number(pageIndex - 1) + ")'><a>← <span class='hidden-480'>上一页</span></a></li>";
	            }

	            var PNumCount = Math.ceil(pageCount / PSize);//判断总分页
	            var PNum = parseInt((pageIndex - 1) / PSize);//判断第几页分页
	            if (PNum >= 1)
	                pageHtml += "<li  class='pagehover' onclick='GotoPage(" + Number((PNum - 1) * PSize + 1) + ")'><a>...</a></li>";
	            for (var j = PNum * PSize; j < (pageCount <= PSize * (PNum + 1) ? pageCount : PSize * (PNum + 1)) ; j++) {
	                if (j == pageIndex - 1) {
	                    pageHtml += "<li class=\"active\"><a>" + (j + 1) + "</a></li>";
	                }
	                else {
	                    pageHtml += "<li  class='pagehover' onclick='GotoPage(" + (j + 1) + ")'><a>" + (j + 1) + "</a></li>";
	                }
	            }
	            if ((PNum + 1) < PNumCount)
	                pageHtml += "<li class='pagehover' onclick='GotoPage(" + Number((PNum + 1) * PSize + 1) + ")'><a>...</a></li>";

	            if (pageIndex == pageCount) {
	                pageHtml += " <li class='next disabled  pagehover'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            }
	            else {
	                pageHtml += " <li class='next pagehover'' onclick='GotoPage(" + Number(pageIndex + 1) + ")'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            }
	            $("#"+pagePart).html(pageHtml);
	            if (pageSize * pageIndex > recordCount) {
	                if (recordCount == 0) {
	                    $("#"+pageInfo).html("显示第 0 条数据到 0 条数据，总共 0 页");
	                }
	                else {
	                    $("#"+pageInfo).html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + recordCount + " 条数据，总共 " + pageCount + " 页");
	                }
	            }
	            else {
	                $("#"+pageInfo).html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + pageSize * pageIndex + " 条数据，总共 " + pageCount + " 页");
	            }
	        }
	        else {
	            pageHtml += "<li class='prev disabled' ><a>← <span class='hidden-480'>上一页</span></a></li>";
	            pageHtml += " <li class='next disabled'><a><span class='hidden-480'>下一页</span> → </a></li>";
	            $("#"+pageInfo).html("显示 0 条数据到 0 条数据，总共 0 页");
	        }
	        $("#"+pagePart).html(pageHtml);
	        if (pageIndex > pageCount) {
	        	if(pageCount==0)pageIndex=1;
	        	else pageIndex = pageCount;
	        }
	        //alert(pageCount+"页");
	    }

	    function GotoPage(topage) {
	    	//alert("topage:"+topage);
	    	//alert("pageCount:"+pageCount);
	        pageIndex = topage;
	        if (0 < topage && topage <= pageCount)
	            getUserList();
	    }
	    /*********************删除一条记录（扩展删除多项）************************/
	    
	    $("#removerecode").click(function(){
	    	 var UID;
	    	 var strId="";
	    	 var j=0;
	    	var lst = document.getElementsByClassName("checkboxes");
	    	 for (var i = 1; i < lst.length; i++) {
	    		 if(lst[i].checked){
	    			 j++;
	    			UID=lst[i].value;
	    			if(j!=1)
	    			strId = strId+',';
	    			strId = strId+UID.toString();
	    		 }
	    	 }
	    	alert(strId);
	    	    $.ajax({
	    	 	url:"Admin/GetUserInfoSrevlet",
	    	 	type:"POST",
	    	 	data:{"strId":strId,"type":0},
	    	 	datatype:"json",
	    	 	success:function(result){
	    	 		result = eval("(" + result + ")");     
	    	 		alert(result.code);
	    	 		if(result.code==1){
	    	 			noty({ text: "删除成功", type: 'success', layout: 'topCenter', timeout: 1000 });
	    	 			getUserList();
	    	 		}else{
	    	 			noty({ text: "删除失败", type: 'success', layout: 'topCenter', timeout: 1000 });
	    	 		}
	    	 	}
	    	 })   
	    })
	    
	    
	    /*********************修改编辑************************/
	    $("#update").click(function(){
	    	 var CID;
		    	var lst = document.getElementsByClassName("checkboxes");
		    	 for (var i = 1; i < lst.length; i++) {
		    		 if(lst[i].checked){
		    			CID=lst[i].value;
		    			 break;
		    		 }
		    	 }
		    	  $.ajax({
			    	 	url:"Admin/GetGoodsInfoServlet",
			    	 	type:"GET",
			    	 	data:{"CID":CID},
			    	 	datatype:"json",
			    	 	success:function(result){
			    	 		result = eval("(" + result + ")");     
			    	 		alert(result.code);
			    	 		if(result.code==1){
			    	 			location.href="Goods/UpdateGoods.jsp?active=menupage6_6";
			    	 		}else{
			    	 			alert("更新异常")
			    	 		}
			    	 	}
			    	 
			    	 })   
			    })
	    
	    
	   /*  checkItem(this); */