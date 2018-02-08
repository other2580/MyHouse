<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>   
<script>
$(function(){
	var table = $("#userTable").DataTable({
		ajax: {
			url: "getUserInfo",
			data: function(param){
				param.isAdmin = $("select[name='isAdmin']").val();
				param.isInUse = $("select[name='isInUse']").val();
				param.userName = $("input[name='userName']").val();
			}
		},
		columns:[
			{"data":"id"},
			{"data":"userName"},
			{"data":"name"},
			{"data":"phone"},
			{"data":"email"}
		],
		columnDefs : [ {
			"render" : function(data, type, row) {
				var down = '<i class="fa fa-user-secret"></i>&nbsp;管理员&emsp;<button class="level btn btn-danger btn-sm" data-id="'+row.id+'" data-use="'+row.isAdmin+'"><i class="fa fa-level-down"></i>&nbsp;降权</button>'
				var up = '<i class="fa fa-user-circle"></i>&nbsp;普通用户&emsp;<button class="level btn btn-warning btn-sm" data-id="'+row.id+'" data-use="'+row.isAdmin+'"><i class="fa fa-level-up"></i>&nbsp;提权</button>';
				return row.isAdmin > 0 ? down : up;
				},
			"targets" : 5
		},{
			"render" : function(data, type, row) {
				var one = '<button class="state btn btn-danger btn-sm" data-id="'+row.id+'" data-use="'+row.isInUse+'"><i class="fa fa-ban"></i>&nbsp;禁用</button>'
				var two = '<button class="state btn btn-success btn-sm" data-id="'+row.id+'" data-use="'+row.isInUse+'"><i class="fa fa-send"></i>&nbsp;解禁</button>';
				return row.isInUse > 0 ? one : two;
				},
			"targets" : 6
		}],
		language : {
			"lengthMenu" : "_MENU_ 条记录每页",
			"zeroRecords" : "没有找到记录",
			"info" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
			"infoEmpty" : "无记录",
			"infoFiltered" : "(从 _MAX_ 条记录过滤)",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页"
			}
		},
		searching: false,
		serverSide:true
	});
	
	// 按条件搜索
	$("#searchButton").click(function(){
		table.ajax.reload(); 
	});
	
	// 搜索框自动填充
	$("input[name='userName']").keyup(function(){
		if($(this).val().trim()==""){
			$("#keywordList").empty();
			return;
		}
		$.ajax({
			url:"getUserByPrefix",
			data:{prefix:$(this).val()},
			type:"get",
			dataType:"json",
			success:function(json){
				$("#keywordList").empty();
				json.forEach(function(item,index){
					var line = "<option>"+item+"</option>";
					$("#keywordList").append(line);
				});
			}
		});
	});
	
	// 改变状态
	$("#userTable").delegate("button.state ","click",function(){
		// 拦截操作
		if(!confirm("危险操作，确认继续？")){
			return false;
		}
		var id = $(this).attr("data-id");
		var isInUse = $(this).attr("data-use");
		$.ajax({
			url: "modifyByUse",
			type: "get",
			data: {"id":id, "isInUse":isInUse},
			dataType: "json",
			success: function(json){
				if(json)
					table.ajax.reload();
				else
					alert("未知原因修改失败！");
			},
			error: function(){
				alert("异步调用出错！修改失败！");
				return false;
			}
		});
	});
	
	// 改变权重
	$("#userTable").delegate("button.level ","click",function(){
		// 拦截操作
		if(!confirm("危险操作，确认继续？")){
			return false;
		}
		var id = $(this).attr("data-id");
		var isAdmin = $(this).attr("data-use");
		$.ajax({
			url: "modifyByAdmin",
			type: "get",
			data: {"id":id, "isAdmin":isAdmin},
			dataType: "json",
			success: function(json){
				if(json)
					table.ajax.reload();
				else
					alert("未知原因修改失败！");
			},
			error: function(){
				alert("异步调用出错！修改失败！");
				return false;
			}
		});
	});
});
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
	    		<select name="isAdmin" class="form-control">
	    			<option value="2">请选择...</option>
	    			<option value="0">普通用户</option>
	    			<option value="1">管理员</option>
	    		</select>
	    	 </td>
	    	 <td><i class="fa fa-ban fa-lg"></i>&nbsp;状态：</td>
	    	 <td>
	    		<select name="isInUse" class="form-control">
	    			<option value="2">请选择...</option>
	    			<option value="0">禁用</option>
	    			<option value="1">正常</option>
	    		</select>
	    	 </td>
	    	 <td><i class="fa fa-pencil-square-o fa-lg"></i>&nbsp;用户名：</td>
	    	 <td>
	    	 	<input name="userName" class="form-control" list="keywordList" autocomplete="off" placeholder="请输入用户名...">
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>