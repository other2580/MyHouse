<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title><tiles:insertAttribute name="pageTitle" /></title>

    <!-- Bootstrap -->
    <link href="${initParam.staticUrl}/js/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${initParam.staticUrl}/js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${initParam.staticUrl}/js/plugins/bootstrap/js/bootstrap.min.js"></script>
	<tiles:insertAttribute name="navbar" />
	<tiles:insertAttribute name="main" />
  </body>
</html>