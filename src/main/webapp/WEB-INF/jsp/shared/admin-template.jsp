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
    <script src="${initParam.staticUrl}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${initParam.staticUrl}/js/plugins/jquery.validate.min.js"></script>   
    <script src="${initParam.staticUrl}/js/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!--font-awesome-->  
	<link href="${initParam.staticUrl}/css/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  	<style>
  		body { padding-top: 55px; }
  		.footer {
		  /* position: absolute; */
		  bottom: 0;
		  width: 100%;
		  /* Set the fixed height of the footer here */
		  height: 60px;
		  background-color: #f5f5f5;
		}
  	</style>
  </head>
  <body>
	<tiles:insertAttribute name="navbar" ignore="true" />
	<tiles:insertAttribute name="main" />
	<tiles:insertAttribute name="footer" ignore="true"/>
  </body>

<!-- 修改密码模态框 -->
<div class="modal fade" id="changePwd_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改登录密码</h4>
      </div>
      <div class="modal-body">
        <form id="changePwdForm" class="form-horizontal">
          <div class="form-group">
            <label for="OldPassword" class="col-sm-2 control-label">旧密码:</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" id="OldPassword" name="OldPassword" placeholder="请输入旧密码" pattern="[a-zA-Z0-9]{3,12}" required>
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-sm-2 control-label">新密码:</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="请输入新密码" pattern="[a-zA-Z0-9]{3,12}" required>
            </div>
          </div>
          <div class="form-group">
            <label for="Confirmation" class="col-sm-2 control-label">确认密码:</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" id="Confirmation" name="Confirmation" placeholder="请再次输入新密码" pattern="[a-zA-Z0-9]{3,12}" required>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="changeAdminPwdSub">确认更改</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
	$(function(){
		// 验证提交数据
		$("#changePwdForm").validate({
			  rules: {
				  OldPassword:{
					   required: true,
					   maxlength: 12,
					   remote: {
							url: "checkAdminPwd",
							type: "post",
							dataType: "json",
							data:{
								password: function(){
									return $("#OldPassword").val();
								}
							}
						}
				   },
				   newPassword:{
					   required: true,
					   maxlength: 12,
					},
					Confirmation:{
					   required: true,
					   maxlength: 12,
					   equalTo: "#newPassword"
					}
				},
				messages: {
					OldPassword:{
					   required: "请填写旧密码！",
					   maxlength: "密码长度不能超过12个字符！",
					   remote: "输入密码与登录密码不一致！"
				    },
				    newPassword:{
					   required: "请填写新密码！",
					   maxlength: "密码长度不能超过12个字符"
				    },
				    Confirmation:{
						required: "请再次填写密码！",
						maxlength: "密码长度不能超过12个字符！",
					   	equalTo: "两次输入密码不一致！"
				    }
				}
		});
		
		function checkAdminPwd(){
			if(!$("#changePwdForm").valid()){
				return false;
			}

			$.ajax({
				url: "modifyPwd",
				type: "post",
				data: {"password": $("#newPassword").val()},
				dataType: "json",
				success: function(json){
					if(json.state){
						alert('修改密码成功！');
						$("#changePwd_modal").modal("hide");
						$("#OldPassword").val('');
						$("#newPassword").val('');
						$("#Confirmation").val('');
					} else{
						alert(json.message);
					}
				},
				error: function(){
					alert("异步提交数据出错！");
					return false;
				}
			});
		}
		
		$("#changeAdminPwdSub").click(function(){
			checkAdminPwd();
		});
	});
</script>
</html>