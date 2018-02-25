<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/include/admin/userManager.js"></script>
<script>
	$(".selectIndex>li:last-of-type").attr("class","active");
</script>
<div class="container">
  <div class="row">
	<div class="page-header">
	  <h1><i class="fa fa-users"></i>&nbsp;用户管理<small> 用户权限状态控制</small></h1>
	  <button class="btn btn-success" data-toggle="modal" data-target="#myModal"><i class="fa fa-user-plus fa-lg"></i>&nbsp;添加用户</button>
    </div>
  </div>
  <div class="row">
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title"><i class="fa fa-list-alt"></i>&nbsp;用户信息</h3>
	  </div>
	  <div class="panel-body">
	    <table class="table table-bordered text-center">
	      <tr>
	    	<td><i class="fa fa-bug fa-lg"></i>&nbsp;权限：</td>
	    	  <td>
	    		<select name="searchIsAdmin" class="form-control">
	    			<option value="2">请选择...</option>
	    			<option value="0">普通用户</option>
	    			<option value="1">管理员</option>
	    		</select>
	    	 </td>
	    	 <td><i class="fa fa-ban fa-lg"></i>&nbsp;状态：</td>
	    	 <td>
	    		<select name="searchIsInUse" class="form-control">
	    			<option value="2">请选择...</option>
	    			<option value="0">禁用</option>
	    			<option value="1">正常</option>
	    		</select>
	    	 </td>
	    	 <td><i class="fa fa-pencil-square-o fa-lg"></i>&nbsp;用户名：</td>
	    	 <td>
	    	 	<input name="userNameList" class="form-control" list="keywordList" autocomplete="off" placeholder="请输入用户名...">
	    	 	<datalist id="keywordList"></datalist>
	    	 </td>
	    	 <td>
	    	 	<button class="btn btn-primary" type="button" id="searchButton"><i class="fa fa-search"></i>&nbsp;查询</button>
	    	 </td>
	      </tr>
	    </table>
	   	<table id="userTable" class="table table-striped table-bordered table-hover">
	   		<thead>
	   			<tr>
	   				<th><i class="fa fa-id-card fa-lg"></i>&nbsp;ID</th>
	   				<th>用户名</th>
	   				<th>姓名</th>
	   				<th><i class="fa fa-phone-square fa-lg"></i>&nbsp;电话</th>
	   				<th><i class="fa fa-envelope fa-lg"></i>&nbsp;邮箱</th>
	   				<th><i class="fa fa-bug fa-lg"></i>&nbsp;权限</th>
	   				<th><i class="fa fa-ban fa-lg"></i>&nbsp;状态</th>
	   			</tr>
	   		</thead>
	   		<tbody></tbody>
	   	</table>
	  </div>
	</div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><i class="fa fa-user-plus"></i>&nbsp;用户详情</h4>
      </div>
      <div class="modal-body">
        <form id="userForm">
		  <div class="form-group">
		    <label for="userName">用户名：</label>
		    <input class="form-control" id="userName" name="userName" maxlength="20" placeholder="请输入用户名...">
		  </div>
		  <div class="form-group">
		    <label for="password">登陆密码：</label>
		    <input type="password" class="form-control" id="password" name="password" maxlength="12" placeholder="请输入密码...">
		  </div>
		  <div class="form-group">
		    <label for=confirmPwd>确认密码：</label>
		    <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" maxlength="12" placeholder="请再次输入密码...">
		  </div>
		  <div class="form-group">
		    <label for="name">姓名：</label>
		    <input class="form-control" id="name" name="name" maxlength="20" placeholder="请输入真实姓名...">
		  </div>
		  <div class="form-group">
		    <label for="phone">联系电话：</label>
		    <input type="number" class="form-control" id="phone" name="phone" placeholder="请输入电话号码...">
		  </div>
		  <div class="form-group">
		    <label for="email">邮箱地址：</label>
		    <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱地址...">
		  </div>
		  <div class="form-group">
		    <label for="isAdmin">用户角色：</label>
		    	<select id="isAdmin" name="isAdmin" class="form-control">
	    			<option value="0">普通用户</option>
	    			<option value="1">管理员</option>
	    		</select>
		  </div>
		  <input type="hidden" name="isInUse" value="1">
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="submitBtn"><i class="fa fa-user-plus"></i>&nbsp;添加</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-window-close-o fa-lg"></i>&nbsp;关闭</button>
      </div>
    </div>
  </div>
</div>