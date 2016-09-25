<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>Admin Login</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link rel="shortcut icon" href="Content/image/favicon.ico" />

<link rel="stylesheet" href="Content/bootstrap/bootstrap.min.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/bootstrap-responsive.min.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/font-awesome.min.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/style-metro.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/style.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/style-responsive.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/default.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/uniform.default.css" type="text/css"></link>
<link rel="stylesheet" href="Content/bootstrap/login-soft.css" type="text/css"></link></head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="login" onkeydown="KeyDown();">

	<!-- BEGIN LOGO -->

	<div class="logo">

		<img src="Content/image/logo-big.png" alt="" /> 

	</div>

	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->

	<div class="content">

		<!-- BEGIN REGISTRATION FORM -->

		<form class="form-vertical register-form" action="index.html">
			<h3 class="">注册</h3>
			<p>请输入账号信息:</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input id="username" class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
						 <p class="warning" id="Uwarning"></p>
					</div>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input id="password" class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password" name="password"/>
						<p class="warning" id="Pwarning"></p>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<a href="loginnow.jsp" id="register-back-btn" type="button" class="btn">
				<i class="m-icon-swapleft"></i>  返回
				</a>
				<a type="submit" id="register" class="btn blue pull-right">
				 注册 <i class="m-icon-swapright m-icon-white"></i>
				</a>            
			</div>
		</form>
		<!-- END REGISTER FORM -->

	</div>

	<!-- END LOGIN -->

	<!-- BEGIN COPYRIGHT -->

	<div class="copyright">

		2016 &copy; 秦风工作室.

	</div>

	<!-- END COPYRIGHT -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->
	<script type="text/javascript" src="Scripts/bootstrap/jquery-1.10.1.min.js"></script>
	

	<script src="Scripts/bootstrap/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="Scripts/bootstrap/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="Scripts/bootstrap/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="Scripts/bootstrap/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="Scripts/bootstrap/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="Scripts/bootstrap/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="Scripts/bootstrap/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="Scripts/bootstrap/jquery.validate.min.js" type="text/javascript"></script>

	<script src="Scripts/bootstrap/jquery.backstretch.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="Scripts/bootstrap/app.js" type="text/javascript"></script>

	<!-- <script src="Scripts/bootstrap/login-soft.js" type="text/javascript"></script>  --> 
	<script src="Scripts/bootstrap/noty/jquery.noty.js" type="text/javascript"></script>
    <script src="Scripts/bootstrap/noty/packaged/jquery.noty.packaged.min.js" type="text/javascript"></script>
     <script src="Scripts/bootstrap/noty/layouts/topCenter.js" type="text/javascript"></script>
     <script src="Scripts/bootstrap/noty/themes/default.js" type="text/javascript"></script>
     <script src="Scripts/bootstrap/noty/packaged/jquery.noty.packaged.min.js" type="text/javascript"></script>     
	<script type="text/javascript" src="JS/registerJs.js"></script>

	<!-- END PAGE LEVEL SCRIPTS --> 
	
	<script>

		jQuery(document).ready(function() {     
			jQuery('.register-form').show();
		  App.init();
		  $.backstretch([
			  		        "Images/bgimages/1.jpg",
			  		        "Images/bgimages/2.jpg",
			  		        "Images/bgimages/3.jpg",
			  		        "Images/bgimages/4.jpg"
			  		        ], {
			  		          fade: 1000,
			  		          duration: 8000
			  		      });
		});

	</script>

	<!-- END JAVASCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>