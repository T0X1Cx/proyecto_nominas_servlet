<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA DE EMPLEADOS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h2>LISTA DE EMPLEADOS</h2>
	<br>
	<table class="table table-dark">
		<thead>
			<tr>

				<th scope="col">DNI</th>
				<th scope="col">Nombre</th>
				<th scope="col">Sexo</th>
				<th scope="col">Categoria</th>
				<th scope="col">Años</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="empleado" items="${lista}">
				<tr>

					<th><c:out value="${empleado.dni}" default="SIN REGISTROS"></c:out></th>
					<td><c:out value="${empleado.nombre}" default="SIN REGISTROS"></c:out></td>
					<td><c:out value="${empleado.sexo}" default="SIN REGISTROS"></c:out></td>
					<td><c:out value="${empleado.categoria}"
							default="SIN REGISTROS"></c:out></td>
					<td><c:out value="${empleado.anyos}" default="SIN REGISTROS"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<button type="button" class="btn btn-primary"
		style="background-color: red;" onclick="window.history.back();">Volver</button>


</body>
</html>