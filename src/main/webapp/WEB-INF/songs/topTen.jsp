<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten Songs</title>
</head>
<body>
	<h1>Top Ten Songs</h1>
	<a href="/songs">Dashboard</a>
	<div style="margin: 100px; outline: solid black 1px; padding: 30px">
		<table>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><c:out value="${song.rating}"/>-<c:out value="${song.title}"/>-<c:out value="${song.artist}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>