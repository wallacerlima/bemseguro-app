<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cargas Solta</title>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2> Cadastramento de Cargas Solta</h2>
	 	  
	  <hr>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma��o!</strong> ${mensagem}
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
		        <th>Navio</th>
		        <th>Documento</th>
		        <th>Porto</th>
		        <th>Mercadoria</th>
		        <th>IMO</th>
		        <th>OOG</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="cs" items="${lista}">
		      <tr>
		        <td>${cs.navio}</td>
		        <td>${cs.documento}</td>
		        <td>${cs.porto}</td>
		        <td>${cs.mercadoria}</td>
		        <td>
		        	<c:if test="${cs.imo}">Sim</c:if> 
		            <c:if test="${!cs.imo}">N�o</c:if> 
		        </td>
		        <td>
		        	<c:if test="${cs.oog}">Sim</c:if> 
		        	<c:if test="${!cs.oog}">N�o</c:if> 
		        </td>
		        <td><a href='<c:url value="/cargaSolta/${cs.id}/excluir"/>'>excluir</a></td>	
		      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
		  <h4>Total de cargas: ${lista.size()}</h4>	
	  </c:if>  
	    
	  <c:if test="${empty lista}">
	  	<h4>N�o existem cargas cadastradas!!!</h4>
	  </c:if>
	   
	</div>
	
	<div class="container mt-3" align = "right">
	  <form action='<c:url value="/cargaSolta"/>' method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	</div>

</body>
</html>