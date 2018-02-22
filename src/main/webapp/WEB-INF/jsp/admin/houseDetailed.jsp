<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Q7bnEXde3qezPSnHfvuVKsBVrTMMdcak"></script>

<div class="container">
  <div class="row">
  	<div class="page-header">
  		<h1><i class="fa fa-home"></i>&nbsp;房屋信息详情</h1>
  		<button type="button" class="btn btn-link btn-lg"><a href="${pageContext.request.contextPath}/admin/houseManager"><i class="fa fa-mail-reply"></i> 返回</a></button>
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-6">
  		<div class="table-responsive">
		  <table class="table table-bordered">
		  	<caption>房屋详细信息</caption>
		   	<tr>
	   		  <td>房屋ID：</td>
	   		    <td>
	   		      <c:out value="${house.id}" />
	   		  </td>
		   	</tr>
		   	<tr>
		   	  <td>房屋类型： </td>
		   	  <td>
		   	    <c:out value="${house.typeName}" />
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>所属街道：</td>
		   	  <td>
		   	  	<c:out value="${house.streetName}" />
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>楼层：</td>
		   	  <td>
		   	  	<c:out value="${house.floor}" />
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>价格：</td>
		   	  <td>
		   	  	<c:out value="${house.price}" />
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>更新时间：</td>
		   	  <td>
		   	  	<fmt:formatDate type="BOTH" value="${house.updateTime}"/>
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>标题：</td>
		   	  <td>
		   	  	<c:out value="${house.topic}" />
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>内容：</td>
		   	  <td>
		   	  	<textarea rows="5" cols=55><c:out value="${house.content}"/></textarea>
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>图片：</td>
		   	  <td>
		   	  	<c:forEach var="p" items="${photo}">
			   	  	<img src="${initParam.staticUrl}/image/photo/${p.fileName}" alt="图片" class="img-rounded img-responsive">		   	  	
		   	  	</c:forEach>
		   	  </td>
		   	</tr>
		   	<tr>
		   	  <td>状态：</td>
		   	  <td>
		   	  	<c:out value="${house.state > 0 ? '正常' : '已下架'}" />
		   	  </td>
		   	</tr>
		  </table>
		</div>
  	</div>
  	<div class="col-md-6">
  		<div id="container" class="col-md-12" style="height: 700px"></div> 
		<script type="text/javascript"> 
			var map = new BMap.Map("container");
			// 创建地图实例  
			var point = new BMap.Point(${house.longitude}, ${house.latitude});
			// 创建点坐标  
			map.addControl(new BMap.NavigationControl());    
			map.addControl(new BMap.ScaleControl());    
			map.addControl(new BMap.OverviewMapControl());    
			map.addControl(new BMap.MapTypeControl()); 
			map.centerAndZoom(point, 20);
			// 初始化地图，设置中心点坐标和地图级别  
		</script> 
    </div>
  </div>

</div>