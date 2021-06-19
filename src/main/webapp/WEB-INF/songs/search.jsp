<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Search</title>
</head>
<body>
	<div style="margin: 100px">
		<div>
			<h1>Songs by Artist: ${artist}</h1>
			<form action="/search" method="get">
			    <p>
			        <input name="artist"/>
			        <input type="submit" value="Search Artists"/>
			    </p>
			</form>
			<a href="/songs">Dashboard</a>
		</div>
		<table>
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Rating</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
		        <tr>
		            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		            <td><c:out value="${song.rating}"/></td>
		            <td>
		            	<%-- <form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form> --%>
						<a href="/songs/${song.id}/delete">Delete</a>
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
		<a href="/songs">Dashboard</a>
	</div>

</body>
</html>