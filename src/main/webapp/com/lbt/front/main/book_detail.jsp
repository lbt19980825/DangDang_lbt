<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="../css/book_detail.css"/>
		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${book.name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath }/com/lbt/back/images/${book.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.press }</td>
			</tr>
			<tr>
				<td>出版时间：<fmt:formatDate value="${book.press_date}" pattern="yyyy-MM-dd"/> </td>
				<td>字数：${book.word_num }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${book.page_num }</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${book.print_date }" pattern="yyyy-MM-dd"/></td>
				<td>开本：${book.sizes }</td>
			</tr>
			<tr>
				<td>印次：${book.impression }</td>
				<td>纸张：${book.paper }</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td>包装：${book.pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${book.dprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.price-book.dprice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath }/front/CartAction?id=${book.id}">
						<img src='../com/lbt/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>${book.editior_recommend} </p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>${book.content_abstract }</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>${book.author_abstract }</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>${book.director }</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>${book.media_commentary }</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">

					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
