<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${initParam.staticUrl}/css/include/register.css">
<script type="text/javascript" src="${initParam.staticUrl}/js/include/register.js"></script>
<div class="container">
	<div class="form row">
		<form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" action="userRegister" method="post">
			<h3 class="form-title">欢迎注册</h3>
			<div class="col-sm-9 col-md-9">
				<div class="form-group">
					<i class="fa fa-user fa-lg"></i>
					<input class="form-control required" type="text" placeholder="请输入用户名" name="userName" autofocus="autofocus" maxlength="20" value="${user.userName}" />
				</div>
				<div class="form-group">
					<i class="fa fa-key fa-lg"></i> 
					<input class="form-control required" type="password" placeholder="请输入密码" id="password" name="password" maxlength="12" />
				</div>
				<div class="form-group">
					<i class="fa fa-key fa-lg"></i> 
					<input class="form-control required" type="password" placeholder="请再次输入密码" name="confirmPwd" maxlength="12" />
				</div>
				<div class="form-group">
					<i class="fa fa-vcard-o fa-lg"></i> 
					<input class="form-control required" type="text" placeholder="请输入真实姓名" name="name" maxlength="20" value="${user.name}" />
				</div>
				<div class="form-group">
					<i class="fa fa-phone-square fa-lg"></i> 
					<input class="form-control required" type="number" placeholder="请输入联系号码" name="phone" value="${user.phone}" />
				</div>
				<div class="form-group">
					<i class="fa fa-envelope-o fa-lg"></i> 
					<input class="form-control required" type="email" placeholder="请输入邮箱地址" name="email" value="${user.email}" />
				</div>
				<div class="form-group">
					<label style="color:red;">${error}</label>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-success pull-right" value="注册 " />
					<hr/>
					<p>已有账号，请<a href="login">登录</a></p>
				</div>
			</div>
		</form>
	</div>
</div>