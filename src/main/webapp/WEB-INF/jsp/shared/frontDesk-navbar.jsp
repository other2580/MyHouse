<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/index"><i class="fa fa-connectdevelop fa-lg"></i> MyHouse</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav selectIndex">
	        <li><a href="${pageContext.request.contextPath}/index">首页<span class="sr-only">(current)</span></a></li>
	      </ul>
      	  <ul class="nav navbar-nav navbar-right">
      	    <c:if test="${loginUser != null}">
	      	  <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${loginUser.userName}"/><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="userInfo">个人中心</a></li>
		            <li><a href="addHouse">添加出租房屋</a></li>
		            <li><a href="houseInfo">出租详情</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="logout"><i class="fa fa-sign-out"></i> 登出</a></li>
		          </ul>
		      </li>
      	    </c:if>
	        <c:if test="${loginUser == null}">
	          <li>
	          	<a style="display:inline-block; padding: 10px 5px;" href="login"><i class="fa fa-sign-in"></i> 登录</a>/
	          	<a style="display:inline-block; padding: 15px 5px;" href="register">注册</a>
	          </li>
	        </c:if>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
  </div>
</div>