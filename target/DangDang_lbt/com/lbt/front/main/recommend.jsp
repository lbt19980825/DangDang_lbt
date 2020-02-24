<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	<c:forEach var="b" items="${recommendList }">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath }/front/ShowBookDetail?id=${b.id}' target='_blank'>
					<img src="${pageContext.request.contextPath }/com/lbt/back/images/${b.cover}" width=70 border=0 class="book-cover"/> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath }/front/ShowBookDetail?id=${b.id}' target='_blank' title='输赢'>${b.name }</a>
				</h3>
				<h4>
					作者：${b.author } 著
					<br />
					出版社：${b.press }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${b.press_date}" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					${b.content_abstract }
				</h5>
				<h6>
					定价：￥${b.price }&nbsp;&nbsp;
					当当价：￥${b.dprice }
					销量：<font color="red">${b.sale }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
	</c:forEach>

		
	</div>
</div>
