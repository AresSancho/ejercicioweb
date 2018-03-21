<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
Bienvenido a mi portal de anuncios<br/>
<c:if test="${ sessionScope.identificado == null }">
	<span style="color: grey;"> 
		debes identificarte para registrar tu anuncio</span>
	<a href="login.jsp">Identificarme</a><br/>
	<a href="registrarUsuario.jsp">Registrarme</a><br/>
</c:if>
<c:if test="${ sessionScope.identificado != null }">
	<a href="registrarAnuncio.jsp">registrar mi anuncio</a><br/>
	<a href="ServletLogOut">cerrar sesion</a><br/>
</c:if>