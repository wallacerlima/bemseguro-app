<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carros</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2> Cadastramento de Motocicletas</h2>
	  
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
		        <th>Dispositivo Antifurto</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="m" items="${lista}">
		      <tr>
		      	<td>${m.id}</td>
		        <td>${m.placa}</td>
		        <td>${m.uf}</td>
		        <td>${m.chassi}</td>
		        <td>${m.cor}</td>
		        <td>${m.dispositivoAntiFurto ? "Sim" : "Não"}</td>
		        <td><a href='<c:url value="/motocicleta/${c.id}/excluir"/>'>excluir</a></td>	
		      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
		  <h4>Total de motocicletas: ${lista.size()}</h4>	
	  </c:if>  
	    
	  <c:if test="${empty lista}">
	  	<h4>Não existem motocicletas cadastradas!!!</h4>
	  </c:if>
	   
	</div>
	
	<div class="container mt-3" align = "right">
	  <form action='<c:url value="/carro"/>' method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	</div>

</body>
</html>