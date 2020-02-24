<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/com/lbt/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/com/lbt/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/com/lbt/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/com/lbt/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/DangDang_lbt/com/lbt/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		$(function(){
  		$(".book-cover").mouseover(function(e){
  			//alert("鼠标移入");
  			//1.拿到原图片的大小
  			var width=this.width*2;
  			var height=this.height*2;
  			//2.获取鼠标的位置
  			var x=e.pageX;
  			var y=e.pageY;
  			//3.创建一个div浮层
  			var div=$("<div id='bigDiv'/>").css({
  			                                 "position":"absolute",
  			                                 "display":"none",
  			                                 "width":width,
  			                                 "height":height,
  			                                 "left":x+10,
  			                                 "top":y+10,
  			        						 "border":"3px solid yellow"
  			                              });
  			//4.创建图片
  			var img=$("<img/>").css({
  							       "width":width,
  			                       "height":height
  			                  }).attr({
  			                  	   "src":this.src
  			                  });
  			//5.将图片放入div
  			div.append(img);
  			//6.将div放入body
  			$("body").append(div);
  			div.show(1000);
  		}).mousemove(function(e){
  		    //alert("鼠标移动");
  		    //1.先获取鼠标的坐标
  		    var x=e.pageX;
  		    var y=e.pageY;
  		    //2.把坐标给div
  		    $("#bigDiv").css({
  		    	"left":x+10,
  			    "top":y+10
  		    });
  		}).mouseout(function(e){
  		    //alert("鼠标移出");
  		    $("#bigDiv").remove();
  		});
  	});
			//按要求排序
			function rank() {	
			
				var value = $("#sel option:selected").val();		
				
					location.href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${fid}&sid=${sid}&pagebean.pageNo=${pagebean.pageNo}&orderType="+value; 
			}
			
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="/com/lbt/front/common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../com/lbt/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath }/front/main'>当当图书</a> &gt;&gt;
			<c:if test="${sid!=null&&sid!='' }">		
				<a href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${fid}&sid=&pagebean.pageNo=1"><font ><strong>${category.name }</strong> </font></a>				
			</c:if>
			<c:if test="${sid==''||sid==null }">					
				<font style='color: #cc3300'><strong>${category.name }</strong> </font>			
			</c:if>

			<c:forEach var="cate" items="${category.sons }">
			<c:if test="${param.sid!=null&&param.sid==cate.id }">
				&gt;&gt;
				<font style='color: #cc3300'><strong>${cate.name }</strong> </font>
			</c:if>
			</c:forEach>
		</div>

		<div class="book">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>										
										<a href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=&pagebean.pageNo=1" ><font <c:if test="${sid==''||sid==null}">style='color: #cc3300'</c:if>>&middot;&nbsp;全部</font></a>&nbsp;										
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="c" items="${category.sons }">	
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${c.id}&pagebean.pageNo=1">
										   <font <c:if test="${param.sid==c.id}">style='color: #cc3300'</c:if>>${c.name}</font>   &nbsp;</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							
							</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
				
						<select id="sel" onchange="rank()" name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="defaultOrder" <c:if test="${param.orderType=='defaultOrder' }">selected</c:if>>请选择排序方式</option>
							<option  value="byCreateDate" <c:if test="${param.orderType=='byCreateDate' }">selected</c:if>>
								按上架时间 降序
							</option>
							
							<option  value="bySaleDate"  <c:if test="${param.orderType=='bySaleDate' }">selected</c:if>>
								按销售量 降序
							</option>
							<option  value="byDprice"  <c:if test="${param.orderType=='bydDrice' }">selected</c:if>>
								按价格从低到高
							</option>
							<option  value="byDpriceDesc"  <c:if test="${param.orderType=='byDpriceDesc' }">selected</c:if>>
								按价格从高到低
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<!--  上一页      -->
							<div class='list_r_title_text3a'>
								<c:if test="${pagebean.pageNo==1 }">
								<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.sid}&pagebean.pageNo=1&orderType=${param.orderType}">
									<img src='../com/lbt/front/images/page_up_gray.gif' /> 
								</a>
								</c:if>
								<c:if test="${pagebean.pageNo!=1 }">
								<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.sid}&pagebean.pageNo=1&orderType=${param.orderType}">
									<img src='../com/lbt/front/images/page_up.gif' /> 
								</a>
								</c:if>
							</div>
							<div class='list_r_title_text3a'>
								<c:if test="${pagebean.pageNo>1 }">
								<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.sid}&pagebean.pageNo=${pagebean.pageNo-1}&orderType=${param.orderType}">
									<img src='../com/lbt/front/images/page_up.gif' /> 
								</a>
								</c:if>
						 		<c:if test="${pagebean.pageNo==1 }">
									<img src='../com/lbt/front/images/page_up_gray.gif' /> 
								</c:if>
							</div>
							<div class='list_r_title_text3b'>
								第${pagebean.pageNo }页/共${pagebean.totalPage }页
							</div>
							
							<div class='list_r_title_text3a'>
								<!--   下一页      -->
								<c:if test="${pagebean.pageNo<pagebean.totalPage }">
								<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.id}&pagebean.pageNo=${pagebean.pageNo+1}&orderType=${param.orderType}">
									<img src='../com/lbt/front/images/page_down.gif' /> 
								</a>
								</c:if>
						 		<c:if test="${pagebean.pageNo==pagebean.totalPage }">
									<img src='../com/lbt/front/images/page_down_gray.gif' /> 
								</c:if> 
							</div>
			
							<div class='list_r_title_text3a'>
								<c:if test="${pagebean.pageNo==pagebean.totalPage }">
									<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.id}&pagebean.pageNo=${pagebean.totalPage}&orderType=${param.orderType}">
										<img src='../com/lbt/front/images/page_down_gray.gif' /> 
									</a>
								</c:if>
								<c:if test="${pagebean.pageNo!=pagebean.totalPage }">
									<a name=link_page_next href="${pageContext.request.contextPath }/front/ShowSecondLevelBook?fid=${category.id}&sid=${param.id}&pagebean.pageNo=${pagebean.totalPage}&orderType=${param.orderType}">
										<img src='../com/lbt/front/images/page_down.gif' /> 
									</a>
								</c:if>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<c:forEach var="b" items="${SecondPageBooks }">
						
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath }/front/ShowBookDetail?id=${b.id}'>
										<img class="book-cover" src="${pageContext.request.contextPath }/com/lbt/back/images/${b.cover}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath }/front/ShowBookDetail?id=${b.id}'>${b.name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${b.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${b.press }</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${b.press_date}" pattern="yyyy-MM-dd"/>
								</h4>
								<h5>
									${b.content_abstract }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${b.price }</span>
									<span class="red">￥${b.dprice }</span>
									节省：￥${b.price-b.dprice }
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath }/front/CartAction?id=${b.id}"> 
									<img src='${pageContext.request.contextPath }/com/lbt/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
						</c:forEach>

						
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
