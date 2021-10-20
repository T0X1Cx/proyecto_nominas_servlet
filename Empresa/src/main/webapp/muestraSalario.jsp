<%@page import="modelo.EmpleadosDAO"%>
<%@page import="modelo.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">

<title>Muestra salario por DNI</title>
</head>
<body>
	<h2>LISTA DE EMPLEADOS</h2>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">NOMBRE</th>
				<th scope="col">DNI</th>
				<th scope="col">SALARIO</th>



			</tr>
		</thead>
		<tbody>

			<tr>
				<td><c:out value="${empleado.nombre}"
						default="SIN REGISTROS PARA ESTE DNI"></c:out></td>
				<th><c:out value="${empleado.dni}"
						default="SIN REGISTROS PARA ESTE DNI"></c:out></th>
				<td><c:out value="${sueldo} €"
						default="SIN REGISTROS PARA ESTE DNI"></c:out></td>
		</tbody>
	</table>
	<br>
	<button type="button" class="btn btn-primary"
		style="background-color: red;" onclick="window.history.back()">Volver</button>


</body>
</html>