<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Carros</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Carros</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma��o!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action='<c:url value="/carro/incluir"/>' method="post">
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
		
		<div class="mb-3 mt-3" style="margin-top:20px; margin-bottom:20px">
	    	<label>Possui Kit G�s:</label>
	    	<div class="radio">
				<label style="margin-right:10px"><input type="radio" name="possuiKitGas" value="true">Sim</label>  
				<label><input type="radio" name="possuiKitGas" value="false">N�o</label>
			</div>
		</div>
	       
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>


</body>
</html>