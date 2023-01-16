<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
    <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Usuarios</h3>
	  </div>
	  <div class="panel-body">
	   	<table class="table table-striped">
	   		<thead>
	   			<tr>
	   				<td>Id</td>
	   				<td>Nombres</td>
	   				<td>Apellidos</td>
	   				<td>Edad</td>
	   				<td></td>
	   			</tr>
	   		</thead>
	   		<tbody>
	   			<c:forEach items="${usuarios}" var="user">
	   				<tr>
	   					<td>${user.id}</td>
	   					<td>${user.nombres}</td>
	   					<td>${user.apellidos}</td>
	   					<td>${user.edad}</td>
	   					<td>
	   						<a href="${context}/usuarios/edit/${user.id}" class="glyphicon glyphicon-pencil"></a>
	   						<a href="${context}/usuarios/delete/${user.id}" class="glyphicon glyphicon-remove"></a>
	   					</td>
	   				</tr>
	   			</c:forEach>
	   		</tbody>
	   	</table>
	  </div>
	  <div class="panel-footer">
	  	<div class="btn-group" role="group" aria-label="...">
	  		<a href="${context}/usuarios" class="btn btn-default">Nuevo Usuario</a>
	  	</div>
	  </div>
	</div>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"   integrity="sha256-gvQgAFzTH6trSrAWoH1iPo9Xc96QxSZ3feW6kem+O00="   crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>
</html>
