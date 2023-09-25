<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Update Book</title>
</head>
<body>

	<%-- <form:form action="saveBook" cssClass="form-horizontal"
		method="post" modelAttribute="book">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" value="${book.id}" />
		<label>Id of the updating book: {id}</label>
		<label>Name of the updating book: {oldname}</label>
		<label>Name of the updating book: {oldPrice}</label>
		<label for="name">Enter Book Name</label>
		<form:input path="name" />
		<label for="price">Enter Price</label>
		<form:input path="price" />
		<form:button>Save</form:button>

	</form:form> --%>
	<form action="/saveBook" method = "post" modelAttribute="book">
		<label>Id of the updating book: ${id}</label>
		<br>
		<label>Old name of the updating book: ${oldname}</label>
		<br>
		<label>Old price of the updating book: ${oldPrice}</label>
		<br>
		<input type="hidden" name="id" value="${book.id}">
		<label>Name: <input type = "text" name = "name"></label>
		<label>Price: <input type = "number" name = "price" step = "any"></label>
		<input type = "submit" value = "Update">
	</form>

</body>
</html>