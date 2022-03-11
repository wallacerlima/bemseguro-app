<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Apólices</title>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2> Cadastramento de Apólices</h2>
	 	  
	  <hr>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	   <c:if test="${not empty lista}">		
	     
		  <table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Número</th>
		        <th>Tipo</th>
		        <th>Data</th>
		        <th>Segurado</th>
		        <th>Itens Segurados</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="a" items="${lista}">
		      <tr>
		      	<td>${a.id}</td>
		      	<td>${a.numApolice}</td>
		      	<td>${a.tipo}</td>
		        <td>${a.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</td>
		        <td>${a.segurado.nome}</td>
		       	<td>${a.itensSegurados.size()}</td>
		        <td><a href='<c:url value="/apolice/${a.id}/excluir"/>'>excluir</a></td>
		      </tr>
		      </c:forEach>
		    </tbody>
		  </table>	
		  <h4>Total de apólices: ${lista.size()}</h4>
		  
	  </c:if>  
	  
	  <c:if test="${empty lista}">
	  	<h4>Não existem apólices cadastradas!!!</h4>
	  </c:if>
	   
	</div>
	
	<div class="container mt-3" align = "right">
		<form action="/apolice" method="get" >
			<button type="submit" class="btn btn-primary">Nova</button>
		</form>
	</div>

</body>
</html>