<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	<form:form action="${context}/usuarios/save" method="post" name="usuario" modelAttribute="usuario" class="form-horizontal" commandName="usuario">
		<fieldset>
			<legend>Usuario</legend>
			<c:if test="${not empty usuario.id}">
				<form:hidden path="id"/>
			</c:if>						
			<div class="form-group">
		    	<label for="inputNombres" class="col-lg-2 control-label">Nombres</label>
		      	<div class="col-lg-10">			        	
		        	<form:input path="nombres" type="text" class="form-control"
                               id="nombres" placeholder="Nombres" />
		      	</div>
		    </div>		    
		    <div class="form-group">
		    	<label for="inputApellidos" class="col-lg-2 control-label">Apellidos</label>
		      	<div class="col-lg-10">
		        	<form:input path="apellidos" type="text" class="form-control" id="apellidos" placeholder="Apellidos"/>
		      	</div>
		    </div>
		    <div class="form-group">
		    	<label for="inputEdad" class="col-lg-2 control-label">Edad</label>
		      	<div class="col-lg-10">
		        	<form:input path="edad" type="text" class="form-control" id="edad" placeholder="Edad"/>
		      	</div>
		    </div>
		    <div class="controls">
		    	<input type="submit" value="Guardar">
		    </div>
		</fieldset>
	</form:form>
</body>
</html>