<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统 ——职位管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		function move(row) {
			row.style.backgroundColor = "#ebf0f5";
			row.style.cursor = "pointer";
		}
		function out(row) {
			row.style.backgroundColor = "#ffffff";
		}
		/** 删除职位 */
		var deleteFn = function(id){
			if (confirm('您确定要删除吗？')){
				window.location = "${pageContext.request.contextPath}/job/deleteJob?id=" + id;
			}
		};
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：职位管理 &gt; 职位查询</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">

	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit">
			  <td>编号</td>
			  <td>名称</td>
			  <td>备注</td>
			  <td colspan="2" align="center">操作</td>
			</tr>

		<c:forEach items="${jobs}" var="job">
			<tr class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
				<td>${job.id}</td>
				<td>${job.name}</td>
				<td>${job.remark}</td>
				<td align="center" width="40px;"><a href="${pageContext.request.contextPath}/job/toUpdateJob?id=${job.id}">
					<img title="修改" src="${pageContext.request.contextPath}/images/update.gif"/></a>
				</td>
				<td align="center"  width="40px;">
					<a href="javascript:void(0);" onclick="deleteFn('${job.id}');">
						<img title="删除" src="${pageContext.request.contextPath}/images/delete.gif"/></a>
				</td>
			</tr>
		</c:forEach>

			 <%-- <s:iterator value="jobs">
				  <tr class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
					  <td><s:property value="id"/></td>
					  <td><s:property value="name"/></td>
					  <td><s:property value="remark"/></td>
					  <td align="center" width="40px;"><a href="${pageContext.request.contextPath}/job/updateJob?id=${id}">
						  <img title="修改" src="${pageContext.request.contextPath}/images/update.gif"/></a>
					  </td>
					  <td align="center"  width="40px;">
						  <a href="javascript:void(0);" onclick="deleteFn('${id}');">
							  <img title="删除" src="${pageContext.request.contextPath}/images/delete.gif"/></a>
					  </td>
				  </tr>
			  </s:iterator>--%>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  		<fkjava:pager pageIndex="${pageModel.pageIndex}" 
	  		              pageSize="${pageModel.pageSize}" 
	  		              recordCount="${pageModel.recordCount}" 
	  		              submitUrl="${pageContext.request.contextPath}/job/selectJob/{0}.html"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>