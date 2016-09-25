/* function $(id){
	 return document.getElementById(id);
 }*/
 /****控制输入只能是整数***/
 document.getElementById("CPrice").onkeyup=function(){
	 var i=this.value; 
	 var hint = document.getElementById("price-hint");
	 if ( isNaN(i) ) {
		 this.value="";
		 hint.innerHTML="此空只能填写价格(整数、小数)"
	 }
 }

document.getElementById("CAPrice").onkeyup=function(){
	 var i=this.value; 
	 var hint = document.getElementById("account-price-hint");
	 if ( isNaN(i) ) {
		 this.value="";
		 hint.innerHTML="此空只能填写价格(整数、小数)"
	 }
}

document.getElementById("count").onkeyup=function(){
	 var i=this.value; 
	 var hint = document.getElementById("count-hint");
	 if ( isNaN(i) ) {
		 this.value="";
		 hint.innerHTML="此空只能填写价格(整数、小数)"
	 }
}


document.getElementById("stock-count").onkeyup=function(){
	 var i=this.value; 
	 var hint = document.getElementById("stock-hint");
	 if ( isNaN(i) ) {
		 this.value="";
		 hint.innerHTML="此空只能填写价格(整数、小数)"
	 }
}

/*******失去焦点检查**********/

 document.getElementById("CName").onblur=function(){
	 var hint=document.getElementById("name-hint");
	 var cname = document.getElementById("CName").value;
	 if(cname==""){
		
		hint.style.color="#f00";
		hint.innerHTML="商品名称不能为空！";
		return;
	 }else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 document.getElementById("CPrice").onblur=function(){
	 var hint=document.getElementById("price-hint");
	 var cname = document.getElementById("CPrice").value;
	 if(cname==""){
		hint.style.color="#f00";
		hint.innerHTML="商品价格不能为空！";
		return;
	 }
	 else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 document.getElementById("CAPrice").onblur=function(){
	 var hint=document.getElementById("account-price-hint");
	 var cname = document.getElementById("CAPrice").value;
	 if(cname==""){
		hint.style.color="#f00";
		hint.innerHTML="注意：折扣价默认等于正常价！";
		return;
	 }
	 else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 document.getElementById("count").onblur=function(){
	 var hint=document.getElementById("count-hint");
	 var cname = document.getElementById("count").value;
	 if(cname==""){
		hint.style.color="#f00";
		hint.innerHTML="不可为空！";
		return;
	 }
	 else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 document.getElementById("stock-count").onblur=function(){
	 var hint=document.getElementById("stock-hint");
	 var cname = document.getElementById("stock-count").value;
	 if(cname==""){
		hint.style.color="#f00";
		hint.innerHTML="不可为空！";
		return;
	 }
	 else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 
 document.getElementById("CInfo").onblur=function(){
	 var hint=document.getElementById("Info-hint");
	 var cname = document.getElementById("CInfo").value;
	 if(cname==""){
		hint.style.color="#f00";
		hint.innerHTML="不可为空！";
		return;
	 }
	 else{
		 hint.innerHTML="完成";
		 return;
	 }
 }
 
 /**************提交前检查***************/
 
 function checkForm(){
	 var cname = document.getElementById("CName").value;
	 //alert(cname);
	 var cprice  =document.getElementById("CPrice").value;
	// alert(cprice);
	 var caprice =document.getElementById("CAPrice").value;
	 //alert(caprice);
	 var ccount = document.getElementById("count").value;
	 var cscount = document.getElementById("stock-count").value;
	// alert(cscount+'sdsav');
	 var cinfo = document.getElementById("CInfo").value;
	// alert(cinfo+'sdsv');
	 if(cname==""){
		 document.getElementById("name-hint").style.color="#f00";
		 document.getElementById("name-hint").innerHTML="商品名称不能为空！";
		 return false;
	 }
	 if(cprice==""){
		 document.getElementById("price-hint").style.color="#f00";
		 document.getElementById("price-hint").innerHTML="商品价格不能为空！";
		 return false;
	 }
	 if(caprice==""){
		 document.getElementById("CAPrice").value=cprice;
		 alert(document.getElementById("CAPrice").value);
	 }
	 if(ccount==""){
		 document.getElementById("count-hint").style.color="#f00";
		 document.getElementById("count-hint").innerHTML="不可为空！";
		 return false;
	 }
	 if(cscount==""){
		 document.getElementById("stock-hint").style.color="#f00";
		 document.getElementById("stock-hint").innerHTML="不可为空！";
		 return false;
	 }
	 if(cinfo==""){
			document.getElementById("Info-hint").style.color="#f00";
			document.getElementById("Info-hint").innerHTML="不可为空！";
			return false;
	 }
	 return true;
 }
 
 
 