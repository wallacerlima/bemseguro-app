<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Bem Seguro</a>
    </div>
    <ul class="nav navbar-nav">
    
      <li class="active"><a href="/">Home</a></li>
      
      <c:if test="${not empty user}">
	      <li><a href="/usuarios">Usuários</a></li>
	      <li><a href="/segurados">Segurados</a></li>
	      <li><a href="#">Apólices</a></li>
	      <li><a href="#">Carros</a></li>
	      <li><a href="#">Motos</a></li>
	      <li><a href="#">Caminhões</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     
      <c:if test="${not empty user}">
      	<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Sair, ${user.nome}</a></li>
      </c:if>
      
      <c:if test="${empty user}">
      	<li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
      	<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
      </c:if>
    </ul>
  </div>
</nav>