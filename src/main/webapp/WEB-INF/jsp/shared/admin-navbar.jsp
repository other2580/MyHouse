<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="navbar navbar-fixed-top">
  <div>
	<nav class="navbar navbar-default">
	  <div class="container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/admin-index"><i class="fa fa-cog fa-spin fa-lg"></i> MyHouse</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav selectIndex">
	        <li><a href="${pageContext.request.contextPath}/admin/admin-index">主页<span class="sr-only">(current)</span></a></li>
	     	<li>
     		  <ul class="nav navbar-nav navbar-left">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">分类管理<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="districtManager"><i class="fa fa-map fa-lg"></i>&nbsp;区域管理</a></li>
		            <li><a href="streetManager"><i class="fa fa-map-signs fa-lg"></i>&nbsp;街道管理</a></li>
		            <li><a href="typeManager"><i class="fa fa-tags fa-lg"></i>&nbsp;类型管理</a></li>
		          </ul>
		        </li>
		      </ul>
	     	</li>
	     	<li><a href="${pageContext.request.contextPath}/admin/houseManager"><i class="fa fa-home fa-lg"></i>&nbsp;房源管理</a></li>
	     	<li><a href="${pageContext.request.contextPath}/admin/userManager"><i class="fa fa-user-secret fa-lg"></i>&nbsp;用户管理</a></li>
	      </ul>
      	  <div class="btn-group nav navbar-nav navbar-right" style="padding-top: 8px;">
            <button type="button" class="btn btn-primary">管理员设置</button>
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu">
                <li>
                  <a href="#" data-toggle="modal" data-target="#changePwd_modal">
                    <span class="glyphicon glyphicon-edit" aria-hidden="true"> 修改登录密码</span>
                  </a>
                </li>
                <li role="separator" class="divider"></li>
                <li>
                  <a href="${pageContext.request.contextPath}/admin/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"> 登出</span></a>
                </li>
              </ul>
          </div>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
  </div>
</div>