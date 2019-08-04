<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>人事管理系统 ——后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
		<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function(){
			
				// 用户提交
				$("#btn").click(function(){
					var name = $("#name");
					var msg = "";
					if ($.trim(name.val()) == ""){
						msg = "用户账号不能为空！";
						name.focus();
					}
					if (msg != ""){
						alert(msg);
					}else{
						$("#userForm").submit();
					}
				});
			});
		</script>
	</head>
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			 <tr><td height="10"></td></tr>
			 <tr>
			    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
				<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 修改用户</td>
				<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
			 </tr>
		</table>
		
		<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" class="main_tabbor">
		  	<tr valign="top">
			    <td>
				  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">

					  <form action="/user/updateUser" method="post" theme="simple" id="userForm">
						  <input name="id" type="hidden" value="${user.id}">
						  <tr><td class="font3 fftd">用户账号：<input name="name" id="name" size="30" value="${user.name}"/>
						  </td>
						  </tr>
						  <tr><td class="main_tdbor"></td></tr>

						  <!-- 用户密码 -->
						  <tr><td class="font3 fftd">
							  用户密码：<input type="password" name="passWord" id="passWord"  size="30"/>
						  </td></tr>
						  <tr><td class="main_tdbor"></td></tr>

						  <!-- 新输密码 -->
						  <tr><td class="font3 fftd">
							  新输密码：<input type="password" name="newPwd" id="newPwd"  size="30"/>
						  </td></tr>
						  <tr><td class="main_tdbor"></td></tr>

						  <tr><td class="font3 fftd">
							  <input type="button" id="btn" value="确定">
							  <input type="reset" value="重置">
						  </td></tr>
						  <tr><td class="main_tdbor"></td></tr>
					  </form>
				  </table>
				</td>
		  	</tr>
		</table>
		<div style="height:10px;"></div>
	</body>
</html>