<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="title">
商品列表
</Layout:overwrite>
<Layout:overwrite name="Mycss">
 <link href="Content/bootstrap/DT_bootstrap.css" rel="stylesheet" />
<style>
#cover{
        position:fixed;
     	width:100%;height:100%;left:0;top:0;
        background:rgba(0,0,0,0.3);
        text-align: center;
    }
    #cover img{
   		position:absolute;
   		top:50%;
   		margin-top:-40px;
    }
    
    
    .pagehover:hover{
    	cursor:pointer;
    }
    </style>
</Layout:overwrite>

<Layout:overwrite name="MyContent">
<div class="row-fluid">
        <div>
            <div class="span12">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home"></i>
                        <a href="/Home/Index">首页</a>
                        <i class="icon-angle-right"></i>
                    </li>
                    <li>
                        <a href="javascript:void(0)">商品管理</a><i class="icon-angle-right"></i>
                    </li>

                    <li>
                        <a href="javascript:void(0)">商品列表</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
<div class="row-fluid">
            <div class="span12">
                <div class="portlet box light-grey" style="border-top: 1px solid #eee;">
                    <div class="portlet-body">
                        <div class="clearfix">
                           
                            <div class="btn-group">
                                <a id="update" type="button" class="btn green">编辑<i class="icon-edit"></i>
                                </a>
                             
                            </div>
                           <!--  <div class="btn-group">
                                <a id="excel" href="com.Manager.Communication/DownloadExcel" type="button" class="btn yellow">导出Excel <i class="icon-bar-chart"></i>
                                </a>
                            </div> -->
                             <div class="btn-group">
                                <a id="removerecode"  type="button" class="btn purple">删除<i class="icon-remove"></i>
                                </a>
                            </div> 
                            <div class="btn-group">
                                <a id="selectRead"  href="Infojsp/AddGoods.jsp?active=menupage6_5" type="button" class="btn red">添加<i class="icon-ok"></i>
                                </a>
                            </div>
                            
                        </div>
                        <div class="row-fluid">
                            <div class="span6">
                                <div id="sample_1_length" class="dataTables_length">
                                    <label>
                                        <select size="1" name="sample_1_length" id="pagesize" aria-controls="sample_1" class="m-wrap small">
                                            <option value="5">5</option>
                                            <option value="10" selected="selected">10</option>
                                            <option value="20">20</option>
                                            <option value="-1">All</option>

                                        </select> 条记录每页</label>
                                </div>
                            </div>
                            <div class="span6">
                                <div class="dataTables_filter" id="sample_1_filter">
                                    <label>检索: <input type="text" aria-controls="sample_1" class="m-wrap small" id="search" style="height:30px;" placeholder="名称、电话、地址"></label>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th style="text-align: center">
                                    <input type="checkbox" id="chk_All" class="checkboxes" onclick="CheckAll(this)" />
                                </th>
                                <th>商品名称</th>
                                <th>正常价格</th>
                                <th>折扣价格</th>
                                <th>商品总数</th>
                                <th>商品库存</th>
                                <th>商品简介</th>
                                <th>上架时间</th>
                            </tr>
                        </thead>
                        <tbody id="ListBody">
								
                        </tbody>
                    </table>
                    <div class="row-fluid">
                        <div class="span6">
                            <div id="pageInfo" class="dataTables_info">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="dataTables_paginate paging_bootstrap pagination">
                                <ul id="pagePart">
                                </ul>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
</Layout:overwrite>
<Layout:overwrite name="MyScript">
	<script type="text/javascript" src="JS/goodlistJs.js"></script>
</Layout:overwrite>	
<%@ include file="/share/_Layout.jsp"%>

