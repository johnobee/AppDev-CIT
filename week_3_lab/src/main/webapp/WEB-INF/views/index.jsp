<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Todo Application</title>
		<style type="text/css">
		body {
			font-family: Trebuchet MS, Verdana;
			font-size: 12px;
		}
		</style>
	</head>
	<body>
		<h1>Todo Application</h1>
		<img src="springsource.png">
		<form method="post">
			TODO text:<br>
			<textarea name="text" cols="50" rows="5"></textarea>
			<br>
			<input type="submit">
		</form>
		<hr>
		List of current Todos (total: ${todos.size()}) :
		<table>
			<c:forEach var="todo" items="${todos}" varStatus="index">
				<tr	<c:if test="${todo.done }">style="text-decoration: line-through;"</c:if>>
					<td>${index.count}.</td>
					<td>${todo.text}</td>
					<td>
						<c:choose>
							<c:when test="${todo.done}">
								<form action="open.html" method="get">
									<input hidden="true" name="todoIndex" value="${index.count}">
									<input type="submit" value="Open">
								</form>
							</c:when>
							<c:otherwise>
								<form action="done.html" method="get">
									<input hidden="true" name="todoIndex" value="${index.count}">
									<input type="submit" value="Done">
								</form>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
	</body>
</html>