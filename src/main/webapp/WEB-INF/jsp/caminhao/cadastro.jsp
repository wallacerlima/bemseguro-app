<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Caminhões</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Caminhões</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action='<c:url value="/caminhao/incluir"/>' method="post">
	    <div class="mb-3 mt-3">
	    <label>Placa:</label>
	      <input type="text" class="form-control" placeholder="Entre com a placa" name="placa" value="KHY0944">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>UF:</label>
	      <input type="text" class="form-control" placeholder="Entre com a UF" name="uf" value="RJ"> 
	    </div>
	    
	    <div class="mb-3 mt-3">
	    <label>Chassi:</label>
	      <input type="text" class="form-control" placeholder="Entre com o chassi" name="chassi" value="PORORE9984312DSD">
	    </div>
	    
	    <div class="mb-3 mt-3">
	    <label>Cor:</label>
	      <input type="text" class="form-control" placeholder="Entre com a cor" name="cor" value="Azul">
	    </div>
		
	    <div class="mb-3 mt-3">
	    <label>Eixos:</label>
	      <input type="text" class="form-control" placeholder="Entre com a quantidade de eixos" name="eixos" value="4">
	    </div>
	       
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>


</body>
</html>