<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carros</title>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2> Cadastramento de Carros</h2>
	  
	   <hr>
	 	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
	  
	   <c:if test="${not empty lista}">
	    
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Id</th>
		        <th>Placa</th>
		        <th>UF</th>
		        <th>Chassi</th>
		        <th>Cor</th>
		        <th>Kit Gás</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="c" items="${lista}">
		      <tr>
		      	<td>${c.id}</td>
		        <td>${c.placa}</td>
		        <td>${c.uf}</td>
		        <td>${c.chassi}</td>
		        <td>${c.cor}</td>
		        <td>${c.possuiKitGas ? "Sim" : "Não"}</td>
		        <td><a href='<c:url value="/carro/${c.id}/excluir"/>'>excluir</a></td>	
		      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
		  <h4>Total de carros: ${lista.size()}</h4>	
	  </c:if>  
	    
	  <c:if test="${empty lista}">
	  	<h4>Não existem carros cadastrados!!!</h4>
	  </c:if>
	   
	</div>
	
	<div class="container mt-3" align = "right">
	  <form action='<c:url value="/carro"/>' method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	</div>

</body>
</html>