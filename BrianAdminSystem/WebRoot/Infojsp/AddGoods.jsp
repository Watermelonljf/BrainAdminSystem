

<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="title">
	商品添加
</Layout:overwrite>
<Layout:overwrite name="Mycss">	
<link rel="stylesheet" href="Content/bootstrap/bootstrap-datetimepicker.min.css" type="text/css"></link>




</Layout:overwrite>  

<Layout:overwrite name="MyContent">
		
		 <ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="Home/index.jsp">首页</a>
								<span class="icon-angle-right"></span>
							</li>

							<li>
								<a href="#">商品管理</a>
								<span class="icon-angle-right"></span>
							</li>

							<li><a href="#">添加商品</a></li>
		</ul> 
		
		<!-- 内容 -->
		 <div class="tab-pane active" id="tab_1">

									<div class="portlet box blue">

										<div class="portlet-title">

											<div class="caption"><i class="icon-reorder"></i>添加商品</div>

											<div class="tools">

												<a href="javascript:;" class="collapse"></a>

												<a href="#portlet-config" data-toggle="modal" class="config"></a>

												<a href="javascript:;" class="reload"></a>

												<a href="javascript:;" class="remove"></a>

											</div>

										</div>

										<div class="portlet-body form">

											<!-- BEGIN FORM -->

											<form action="Admin/AddGoodServlet" class="form-horizontal" method="post"  onsubmit="return checkForm()">
													<div class="control-group">

													<label class="control-label">商品名称</label>

													<div class="controls">

														<input type="text"  id="CName"  name="gname" placeholder="商品名称" class="m-wrap medium" />

														<span class="help-inline"  id="name-hint"></span>

													</div>

												</div>				
											<!-- 	class -->
												<div class="control-group">

													<label class="control-label">商品类别</label>

													<div class="controls">

														<select id="CClass" name="gclass" class="small m-wrap"  tabindex="1">

															<option value="1">零食</option>

															<option value="2">服饰</option>

															<option value="3">数码产品</option>

															<option value="4">图书</option>

														</select>

													</div>

												</div>
												
												<!-- normal price -->
												<div class="control-group">

														<label class="control-label">商品价格</label>

														<div class="controls">

																<div class="input-prepend input-append">
																	<span class="add-on icon-yen"></span><input id="CPrice"  name="price" class="m-wrap medium"  type="text" placeholder="商品价格"  /><span class="add-on">.00</span>
																</div>
																<span class="help-inline" id="price-hint"></span>

														</div>
														
												</div>
												
												<!-- account price -->
												
												<div class="control-group">

														<label class="control-label">折扣价格</label>

														<div class="controls">

																<div class="input-prepend input-append">

																	<span class="add-on icon-yen"></span><input id="CAPrice" name="aprice" class="m-wrap " type="text"  placeholder="不填默认为正常价"  /><span class="add-on">.00</span>
																</div>
																<span class="help-inline" id="account-price-hint"></span>
														</div>
												</div>
												
												<!-- Goods account -->
												<div class="control-group">

													<label class="control-label">商品总数量</label>

													<div class="controls">

														<input type="text"  id="count" name="count"placeholder="商品总数量" class="m-wrap small" />

														<span class="help-inline" id="count-hint">Some hint here</span>

													</div>

												</div>				
																			
												<!-- stock of goods -->
												<div class="control-group">

													<label class="control-label">商品库存</label>

													<div class="controls">

														<input type="text" placeholder="商品库存"  id="stock-count"  name="stock"  class="m-wrap small" />

														<span class="help-inline" id="stock-hint"></span>

													</div>

												</div>			
													
												<!-- date -->
										<div class="control-group">

										<label class="control-label">上架日期</label>

										<div class="controls">

											<div class="input-append date form_datetime" id="datetimepicker" data-date="2012-12-21T15:25:00Z">

												<input name="time" size="16" type="text" value="" readonly class="m-wrap">

												<span class="add-on"><i class="icon-remove"></i></span>

												<span class="add-on"><i class="icon-calendar"></i></span>

											</div>

										</div>

									</div>
												
												<div class="control-group">

													<label class="control-label">商品描述</label>

													<div class="controls">

														<textarea id="CInfo" name="info" class="medium m-wrap" rows="4"  cols="15"></textarea>
														<span class="help-inline" id="CInfo-hint"></span>
													</div>

												</div>
												
											<!-- 	Goods images	
										
												Time to market -->
												<div class="form-actions">

													<button type="submit" class="btn blue"><i class="icon-ok"></i> 录入</button>

													<button type="button" class="btn">返回</button>

												</div> 

											</form>
											

										<!-- 	END FORM  -->

										</div>

									</div>

								</div>	 
</Layout:overwrite>
<Layout:overwrite name="MyScript">
	<script type="text/javascript" src="JS/AddGoods.js"></script> 
	<script type="text/javascript" src="Scripts/bootstrap/jquery-1.8.3.min.js"></script>

<script type="text/javascript" src="Scripts/bootstrap/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="Scripts/bootstrap/locales/bootstrap-datetimepicker.fr.js"></script>
<script type="text/javascript">
$("#datetimepicker").datetimepicker({
//一堆参数
		weekStart:1,
		todayBtn:1,
		autoclose:1,
		todayHighlight:1,
		startView:2,
		forceParse:0,
		showMeridian:1,
    });
</script>
</Layout:overwrite> 
<%@ include file="/share/_Layout.jsp"%>




