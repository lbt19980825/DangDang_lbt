<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="${pageContext.request.contextPath }/com/lbt/front/css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> 
				<span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的</a> |
					<a href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>| 
				</span> 
			</span>
			<div class="cart gray4012">
				<a href="../com/lbt/front/cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好<span style="color:red">${loginUser.nickname }</span>，欢迎光临</b>
		<c:if test="${loginUser.nickname!=null}">
		[&nbsp;<a href="${pageContext.request.contextPath }/user/UserExit" class="b">登出</a>&nbsp;]
		</c:if>
		<c:if test="${loginUser.nickname==null}">
		[&nbsp;<a href="../com/lbt/front/user/login_form.jsp" class="b">登录</a>]
		</c:if>
		[<a href="../com/lbt/front/user/register_form.jsp" class="b">注册</a>]&nbsp;
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">

		</div>

	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
