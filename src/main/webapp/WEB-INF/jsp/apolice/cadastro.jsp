<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro de Apólices</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Apólices</h2>
	  
	  <c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger">
		  <strong>Erro!</strong> ${mensagemErro}
		</div>	  
	  </c:if>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-danger">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	<form action='<c:url value="/apolice/incluir"/>' method="post">
	  
		<div class="form-group">
		
			<c:if test="${not empty segurados}">	
		  		<label>Segurados:</label>
		  		<select class="form-control" name="segurado.id">
		  			<c:forEach var="s" items="${segurados}">
		  				<option value="${s.id}">${s.nome}</option>
		  			</c:forEach>
		  		</select>
		  	</c:if>
		  	
		  	<c:if test="${empty segurados}">	
		  		<c:set var="botao" value="disabled"/>
		  		<label>Não existe segurados cadastrados!</label>
		  	</c:if>
	  	</div>

	    <div class="mb-3 mt-3">
	      	<label>Número da apólice:</label>
	    	<input type="text" class="form-control" placeholder="Entre com o número da apólice" name="numApolice" value="0219140422"> 
	    </div>
	    
	    <div class="mb-3 mt-3" style="margin-top:20px">
		    <label>Tipo:</label>
		    <div class="radio">
				<label style="margin-right:10px"><input type="radio" name="tipo" value="Tradicional">Seguro Auto Tradicional</label>  
				<label><input type="radio" name="tipo" value="Roubo e Furto">Seguro Auto Roubo e Furto</label>
			</div>
		</div>
	    
  	    <div class="mb-3 mt-3" style="margin-top:20px">
  	    	<c:if test="${not empty veiculos}">		
		    	<label>Veículos:</label>
		    	<c:forEach var="v" items="${veiculos}">
			    	<div class="checkbox">
			    		<label><input type="checkbox" name="veiculosId" value="${v.id}">${v.placa} - ${v.chassi} - ${v.uf}</label>
			    	</div>
			    </c:forEach>
			</c:if>	
			
			<c:if test="${empty veiculos}">
				<c:set var="botao" value="disabled"/>
				<label>Não existem veículos cadastrados!</label>
			</c:if>	
	   	</div>  
    
	    <button ${botao} type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>


</body>
</html>