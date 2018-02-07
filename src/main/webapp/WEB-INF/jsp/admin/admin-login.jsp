<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${initParam.staticUrl}/css/include/admin/admin-login.css">
<script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${initParam.staticUrl}/js/include/admin/admin-login.js"></script>
<div class="container">
	<div class="form row">
		<form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form" action="checkAdminLogin" method="post">
			<h3 class="form-title">登录后台管理系统</h3>
			<div class="col-sm-9 col-md-9">
				<div class="form-group">
					<i class="fa fa-user fa-lg"></i> 
					<input class="form-control required" type="text" placeholder="请输入用户名" name="userName" autofocus="autofocus" maxlength="20" />
				</div>
				<div class="form-group">
					<i class="fa fa-key fa-lg"></i> 
					<input class="form-control required" type="password" placeholder="请输入密码" name="password" maxlength="12" />
				</div>
				<div class="form-group">
					<label style="color:red;">${error}</label>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-success pull-right" value="登录 " />
				</div>
			</div>
		</form>
	</div>
</div>
