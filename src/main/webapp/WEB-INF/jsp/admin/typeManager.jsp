<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/include/admin/typeManager.js"></script>
<div class="container">
  <div class="row">
  	<div class="page-header">
  		<h1>类型管理<small> 房屋类型</small></h1>
  		<button class="btn btn-success" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus-square-o fa-lg"></i>&nbsp;添加分类</button>
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-12">
  	  <div class="panel panel-primary">
		<div class="panel-heading">
		  <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-lg"></i>&nbsp;分类详情</h3>
		</div>
		<div class="panel-body">
		  <table id="typeTable" class="table table-striped table-bordered">
		  	<thead>
		  	  <tr>
		  	  	<th>ID</th>
		  	  	<th>类型名称</th>
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
        <h4 class="modal-title" id="myModalLabel">分类编辑</h4>
      </div>
      <div class="modal-body">
	    <form id="typeForm">
	      	<div class="form-group">
			  <label for="id">ID</label>
			  <input type="text" class="form-control" id="id" name="id" value="0" readonly="readonly">
			</div>
			<div class="form-group">
			  <label for="name">分类名</label>
			  <input type="text" class="form-control" id="name" name="name" maxlength="10" placeholder="请输入分类名...">
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