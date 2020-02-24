<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script>
</script>


</head>
<frameset rows="150,*" noresize="true" border="2px" bordercolor="#9A9D9F">
	<frame src="${pageContext.request.contextPath }/com/lbt/back/main/head.jsp">
	<frameset cols="15%,*">
		<frame src="${pageContext.request.contextPath }/com/lbt/back/main/menu.jsp" />
		<frame name="Homepage" src="${pageContext.request.contextPath }/com/lbt/back/main/home.jsp">
	</frameset>
</frameset>
</html>