<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Busqueda por propiedad</title>
</head>
<body>
	<h2>BUSQUEDA POR PROPIEDAD</h2>
	<form method="POST"
		action="EmpleadosController?opcion=muestraEmpleadosBusqueda">
		<div class="form-group">
			<label for="DNI">DNI EMPLEADO</label> <input type="text"
				class="form-control" id="DNI" placeholder="Introduce DNI"
				name="varDNI">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back()">Volver</button>

	</form>
	<br>
	<form method="POST"
		action="EmpleadosController?opcion=muestraEmpleadosBusqueda">
		<div class="form-group">
			<label for="Nombre">NOMBRE EMPLEADO</label> <input type="text"
				class="form-control" id="Nombre" placeholder="Introduce Nombre"
				name="varNombre">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back()">Volver</button>

	</form>
	<br>
	<form method="POST"
		action="EmpleadosController?opcion=muestraEmpleadosBusqueda">
		<div class="form-group">
			<label for="Categoria">CATEGORIA EMPLEADO</label> <input
				type="number" class="form-control" id="Categoria"
				placeholder="Introduce Categoria" name="varCategoria">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back()">Volver</button>

	</form>
	<br>
	<form method="POST"
		action="EmpleadosController?opcion=muestraEmpleadosBusqueda">
		<div class="form-group">
			<label for="Años">AÑOS EMPLEADO</label> <input type="number"
				class="form-control" id="Anyos" placeholder="Introduce Años"
				name="varAnyos">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back()">Volver</button>

	</form>
	<br>
	<form method="POST"
		action="EmpleadosController?opcion=muestraEmpleadosBusqueda">
		<div class="form-group">
			<label for="Sexo">SEXO EMPLEADO</label> <input type="text"
				class="form-control" id="Sexo" placeholder="Introduce Sexo"
				name="varSexo">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Buscar</button>
		<button type="button" class="btn btn-primary"
			style="background-color: red;" onclick="window.history.back();">Volver</button>

	</form>





</body>
</html>