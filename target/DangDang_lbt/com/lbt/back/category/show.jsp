<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/com/lbt/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath }/com/lbt/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath }/admin/QueryFirstCategory'">添加二级类别&raquo;</div>
			<div style="font-size:24px;color:red">${sessionScope.message }</div>
			<c:remove var="message" scope="session"/>
		</div>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			
			<c:forEach var="c" items="${categoryList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.category.name}</td>
					<td>${c.levels}</td>
					<td>
						<div class="button" onclick="location.href='${pageContext.request.contextPath }/admin/deleteCategory?id=${c.id}' ">删除 &raquo;${message2}</div>	
					</td>
			    </tr>		
			</c:forEach>

						
			
		</table><br/>
		
	</body>  
</html>



