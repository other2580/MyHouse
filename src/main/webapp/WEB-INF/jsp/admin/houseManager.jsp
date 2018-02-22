<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/include/admin/houseManager.js"></script>
<link href="${initParam.staticUrl}/js/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
<script src="${initParam.staticUrl}/js/plugins/bootstrap-select/js/bootstrap-select.min.js"></script>
<script src="${initParam.staticUrl}/js/plugins/bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>

<div class="container">
  <div class="row">
  	<div class="page-header">
  		<h1><i class="fa fa-home"></i>&nbsp;房源管理<small> 房屋信息管理</small></h1>
  		<!-- <button class="btn btn-success" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus-square-o fa-lg"></i>&nbsp;添加分类</button> -->
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-12">
  	  <div class="panel panel-primary">
		<div class="panel-heading">
		  <h3 class="panel-title"><i class="fa fa-table fa-lg"></i>&nbsp;房屋信息</h3>
		</div>
		<div class="panel-body">
			<div class="searchBox">
				<table class="table table-bordered text-center">
					<tr>
						<td>发布用户：</td>
						<td>
							<select class="selectpicker" data-live-search="true" id="searchUserId">
								<option value="0">请选择...</option> 
							</select>
						</td>
						<td>房屋类型：</td>
						<td>
							<select class="form-control" id="searchType">
								<option value="0">请选择...</option>
							</select>
						</td>
						<td>所属区域：</td>
						<td>
							<select class="form-control" id="searchDistrict">
								<option value="0">请选择...</option>
							</select>
						</td>
						<td>所属街道：</td>
						<td>
							<select class="form-control" id="searchStreet">
								<option value="0">请选择...</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>价格区间：</td>
						<td>
							<input type="number" class="form-control" id="searchMinPrice" placeholder="最低价" />
						</td>
						<td>
							<input type="number" class="form-control" id="seachMaxPrice" placeholder="最高价" />
						</td>
						<td>状态：</td>
						<td>
							<select class="form-control" id="seachState">
								<option value="2">请选择...</option>
								<option value="0">下架</option>
								<option value="1">正常</option>
							</select>
						</td>
						<td>
							<button class="btn btn-primary" type="button" id="searchButton"><i class="fa fa-search"></i>&nbsp;查询</button>
						</td>
					</tr>
				</table>
			</div>
		   	<table id="houseTable" class="table table-striped table-bordered table-hover">
			  	<thead>
			  	  <tr>
			  	  	<th>ID</th>
			  	  	<th>用户</th>
			  	  	<th>房屋类型</th>
			  	  	<th>街区</th>
			  	  	<th>标题</th>
			  	  	<th>价格&nbsp;( <i class="fa fa-cny fa-lg"></i> )</th>
			  	  	<th>状态</th>
			  	  	<th>操作</th>
			  	  </tr>
			  	</thead>
			</table>
		</div>
	  </div>
  	</div>
  </div>
</div>
