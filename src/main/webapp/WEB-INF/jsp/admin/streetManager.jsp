<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/include/admin/streetManager.js"></script>
<div class="container">
  <div class="row">
  	<div class="page-header">
  		<h1>街道管理<small> 房屋所属街道</small></h1>
  		<button class="btn btn-success" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus-square-o fa-lg"></i>&nbsp;添加街道</button>
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-12">
  	  <div class="panel panel-primary">
		<div class="panel-heading">
		  <h3 class="panel-title"><i class="fa fa-table fa-lg"></i>&nbsp;街道详情</h3>
		</div>
		<div class="panel-body">
		  <div class="table-responsive">
			  <table class="table table-bordered text-center ">
			    <tr>
			      <td>所属区域：</td>
			      <td>
			        <select class="form-control" id="districtSelect" name="districtId">
			          <option value="0">请选择...</option>
			        </select>
			      </td>
			      <td>街道名：</td>
			      <td>
			      	<input class="form-control" name="streetName" id="streetName" list="keywordList" autocomplete="off" />
			      	<datalist id="keywordList"></datalist>
			      </td>
			      <td>
			      	<button class="btn btn-primary" type="button" id="searchButton"><i class="fa fa-search"></i>&nbsp;查询</button>
			      </td>
			    </tr>
			  </table>
	      </div>
	  	 <table id="streetTable" class="table table-striped table-bordered table-hover">
		  	<thead>
		  	  <tr>
		  	  	<th>ID</th>
		  	  	<th>街道名称</th>
		  	  	<th>所属区域</th>
		  	  	<th>操作</th>
		  	  </tr>
		  	</thead>
		  </table>
		</div>
	  </div>
  	</div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">街道信息编辑</h4>
      </div>
      <div class="modal-body">
	    <form id="streetForm">
	      	<div class="form-group">
			  <label for="id">ID</label>
			  <input type="text" class="form-control" id="id" name="id" value="0" readonly="readonly">
			</div>
			<div class="form-group">
			  <label for="district">所属区域</label>
			  <select name="districtId" id="districtSelectTwo" class="form-control"></select>
			</div>
			<div class="form-group">
			  <label for="name">街道名</label>
			  <input type="text" class="form-control" id="name" name="name" maxlength="20" placeholder="请输入街道名...">
			</div>
	    </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="submitBtn"><i class="fa fa-save fa-lg"></i>&nbsp;保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-window-close-o fa-lg"></i>&nbsp;关闭</button>
      </div>
    </div>
  </div>
</div>