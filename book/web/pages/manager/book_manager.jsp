<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@ include file="/pages/common/header.jsp" %>
</head>
<script type="text/javascript">
	/*给删除标签绑定删除提示事件*/
	$(function () {
	$("a.deleteClass").click(function () {
	/** * confirm
	 是确认提示框函数
	 参 数 是 它 的 提 示 内 容
	 它 有 两 个 按 钮 ， 一 个 确 认 ， 一 个 是 取 消 。
	 返 回：true表 示 点 击 了，确 认：返 回 false表示 点 击 取 消 。
	 */

	return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
})
	})
</script>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
<td><a href="/bookServlet?action=getBook&id=${book.id}&pageNO=${requestScope.page.pageNo}">修改</a></td>
<td><a class="deleteClass" href="/bookServlet?action=delete&id=${book.id}&pageNO=${requestScope.page.pageNo}">删除</a></td>
			</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNO=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>


		</table>
	<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>

	<%--页脚--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>