<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			
				// 部门修改
				$("#btn").click(function(){
					var name = $("#name");
					var remark = $("#remark");
					var msg = "";
					if ($.trim(name.val()) == ""){
						msg = "部门名称不能为空！";
						name.focus();
					}else if ($.trim(remark.val()) == ""){
						msg = "部门的备注不能为空！";
					}
				
					if (msg != ""){
						alert(msg);
					}else{
						$("#deptForm").submit();
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
				<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：部门管理  &gt; 修改部门</td>
				<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
			 </tr>
		</table>
		
		<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" class="main_tabbor">
		  	<tr valign="top">
			    <td>
				  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">

				  	<!-- 表单 -->
				  	<form action="/dept/updateDept" method="post" theme="simple" id="deptForm">

						<input name="id" type="hidden" value="${dept.id}" />
					    <tr>
					    <td class="font3 fftd">部门名称：
						 <input value="${dept.name}" name="name" id="name" size="40"></input>
						</td>
					    </tr>
						<tr><td class="main_tdbor"></td></tr>
						<tr>
							<td class="font3 fftd">部门备注：
							<input rows="4" cols="40" size="40" name="remark" id="remark" value="${dept.remark}"></input>
						</td>
						</tr>

						<tr><td class="main_tdbor"></td></tr>
						
						<tr><td class="font3 fftd">
								<input type="button" id="btn" value="确定">
								<input type="reset" value="重置">
						</td></tr>
						<tr><td class="main_tdbor"></td></tr>
					</form>




					  <%--<!-- 表单 -->
					  <s:form action="/dept/updateDept.action" method="post" theme="simple" id="deptForm">
						  <s:token></s:token>
						  <s:hidden name="dept.id"/>
						  <tr><td class="font3 fftd">部门名称：<s:textfield name="dept.name" id="name" size="40" />
							  <s:if test="tip != null"><font color="red">${tip }</font></s:if>
						  </td>
						  </tr>
						  <tr><td class="main_tdbor"></td></tr>

						  <tr><td class="font3 fftd">部门备注：<br/>
							  <s:textarea rows="4" cols="40" name="dept.remark" id="remark"></s:textarea>
						  </td></tr>
						  <tr><td class="main_tdbor"></td></tr>


						  <tr><td class="font3 fftd">
							  <input type="button" id="btn" value="确定">
							  <input type="reset" value="重置">
						  </td></tr>
						  <tr><td class="main_tdbor"></td></tr>
					  </s:form>--%>
				  </table>
				</td>
		  	</tr>
		</table>
		<div style="height:10px;"></div>
	</body>
</html>