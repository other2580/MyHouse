<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
  <div class="row">
  	<ol class="breadcrumb">
	  <li><a href="index">首页</a></li>
	  <li class="active">个人中心</li>
	</ol>
  </div>
  <div class="row">
  	<div class="page-header">
	  <h1><i class="fa fa-user fa-lg"></i> 个人中心 <small>用户详细信息</small></h1>
	</div>
  </div>
  <div class="row">
  	<div>
	  <!-- Nav tabs -->
	  <ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">用户信息</a></li>
	    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">编辑用户信息</a></li>
	    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">修改登录密码</a></li>
	  </ul>
	  <!-- Tab panes -->
	  <div class="tab-content">
	    <div role="tabpanel" class="tab-pane active" id="home">
	      <table class="table table-bordered">
	 		<tr>
	 			<td>ID：</td>
	 			<td>
	 				<c:out value="${loginUser.id}" />
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>用户名：</td>
	 			<td>
	 				<c:out value="${loginUser.userName}" />
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>姓名：</td>
	 			<td>
	 				<c:out value="${loginUser.name}" />
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>电话：</td>
	 			<td>
	 				<c:out value="${loginUser.phone}" />
	 			</td>
	 		</tr>
	 		<tr>
	 			<td>邮箱：</td>
	 			<td>
	 				<c:out value="${loginUser.email}" />
	 			</td>
	 		</tr>
		  </table>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="profile">
	    	<form>
	    	  <table class="table table-bordered">
		 		<tr>
		 			<td>ID：</td>
		 			<td>
		 				<c:out value="${loginUser.id}" />
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>用户名：</td>
		 			<td>
		 				<input class="form-control required" type="text" placeholder="请输入用户名" name="userName" autofocus="autofocus" maxlength="20" value="${loginUser.userName}" />
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>姓名：</td>
		 			<td>
		 				<input class="form-control required" type="text" placeholder="请输入真实姓名" name="name" maxlength="20" value="${loginUser.name}" />
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>电话：</td>
		 			<td>
		 				<input class="form-control required" type="number" placeholder="请输入联系号码" name="phone" value="${loginUser.phone}" />
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>邮箱：</td>
		 			<td>
		 				<input class="form-control required" type="email" placeholder="请输入邮箱地址" name="email" value="${loginUser.email}" />
		 			</td>
		 		</tr>
		 		<tr>
		 			<td></td>
		 			<td>
		 				<button type="submit" class="btn btn-success"><i class="fa fa-save fa-lg"></i> 提交</button>
		 			</td>
		 		</tr>
			  </table>
	    	</form>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="messages">
	    	
	    </div>
	  </div>
	
	</div>
  </div>
</div>
