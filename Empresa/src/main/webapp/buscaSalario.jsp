<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Busca salario por DNI</title>
</head>
<body>
	<h2>BUSCA SALARIO POR DNI</h2>
	<form method="POST" action="EmpleadosController?opcion=muestraSalario">
		<div class="form-group">
			<label for="DNI">DNI EMPLEADO</label> <input type="text"
				class="form-control" id="DNI" placeholder="Introduce DNI"
				name="varDNI">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back();">Volver</button>
	</form>








</body>
</html>