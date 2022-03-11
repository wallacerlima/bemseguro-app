<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Segurados</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Segurados</h2>
	  
	  <form action='<c:url value="/segurado/incluir"/>' method="post"> 
	  	  
	    <div class="mb-3 mt-3">
	    <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o nome" name="nome" value="Claudio Castro">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>CPF / CNPJ:</label>
	      <input type="text" class="form-control" placeholder="Entre com o cpf ou cnpj" name="cpfCnpj" value="08254613698"> 
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o e-mail" name="email" value="claudiocastro@gmail.com"> 
	    </div>
	    
	    <c:import url="/WEB-INF/jsp/endereco.jsp"/>
	    
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>


</body>
</html>