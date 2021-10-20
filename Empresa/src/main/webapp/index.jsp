<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>MENÚ PRINCIPAL - NÓMINAS</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">SELECCIONA UNA OPCION DEL MENU</th>
			</tr>
		</thead>
		<tbody">
			<tr>
				<td><a href="EmpleadosController?opcion=empleados">MOSTRAR
						TODOS LOS EMPLEADOS</a></td>
			</tr>
			<tr>
				<td><a href="EmpleadosController?opcion=buscaSalario">MOSTRAR
						SALARIO DE UN EMPLEADO</a></td>
			</tr>
			<tr>
				<td><a href="EmpleadosController?opcion=empleadosBusqueda">BUSCAR
						EMPLEADO POR PROPIEDAD</a></td>
			</tr>
		</tbody>
	</table>



</body>
</html>