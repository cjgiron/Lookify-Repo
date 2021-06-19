<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs Home</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
		crossorigin="anonymous">
</head>
<body>
	<div style="margin: 100px">
		<h1>All Songs</h1>
		<a href="songs/new">Add New</a>
		<a href="/search/topTen">Top Ten Songs</a>
		
		<form action="/search" method="get">
		    <p>
		        <input name="artist"/>
		        <input type="submit" value="Search Artists"/>
		    </p>
		</form>
		
		<table>
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Artist</th>
		            <th>Rating</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
		        <tr>
		            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		            <td><c:out value="${song.artist}"/></td>
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
	</div>
</body>
</html>