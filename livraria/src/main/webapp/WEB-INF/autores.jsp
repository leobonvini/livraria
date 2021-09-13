<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Autores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">Cadastro do autor</h1>
	<form action="<c:url value="/autores"/>" method="POST">
		<div class="form-group">
			<label for="nome"> Nome </label>
			<input id="nome" class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="email"> E-mail</label>
			<input id="email" class="form-control" name="email">
		</div>
		<div class="form-group">
			<label for="nascimento"> Nascimento (ex: 15/10/1980)</label>
			<input id="nascimento" class="form-control" name="nascimento">
		</div>

		
		<input type="submit" value="Registrar" class="mt-2 btn-primary" >
	</form>
	<h1 class="text-center">Lista de Autores</h1>
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
			<th>NOME </th>
			<th>E-MAIL </th>
			<th>NASCIMENTO </th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${autores}" var="a">
					<tr>
						<td>${a.nome}</td>
						<td>${a.email}</td>
						<td>${a.nascimento}</td>
					</tr>
				</c:forEach> 
			</tbody>
	</table>
</body>
</html>