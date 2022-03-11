<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usu�rios</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Usu�rios</h2>
	  
	   <hr>
	   
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma��o!</strong> ${mensagem}
		</div>	  
	  </c:if>

	<c:if test="${not empty lista}">		
				  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>Endere�o</th>
		        <th>Segurados</th>
		        <th>Ve�culos</th>
		        <th>Ap�lices</th>
		        <c:if test="${user.admin}">
		        	<th></th>
		        </c:if>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="u" items="${lista}">
			      <tr>
			        <td>${u.id}</td>
			        <td>${u.nome}</td>
			        <td>${u.email}</td>
			        <td>${u.endereco.cep}</td>
			        <td>${u.segurados.size()}</td>
			        <td>${u.veiculos.size()}</td>
			        <td>${u.apolices.size()}</td>
			        	<td><c:if test="${user.admin && user.id != u.id}" ><a href='<c:url value="/usuario/${u.id}/excluir"/>'>excluir</a> </c:if></td>			       
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
	  	<h4>Total de usu�rios: ${lista.size()}</h4>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>N�o existem usu�rios cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>