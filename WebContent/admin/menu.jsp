<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="gestionUsuarios.jsp">gestionar usuarios</a>&nbsp;
<a href="ServletListadoAnunciosAdmin">gestionar anuncios</a>&nbsp;
<a href="ServletLogOutAdmin">salir</a>&nbsp;

