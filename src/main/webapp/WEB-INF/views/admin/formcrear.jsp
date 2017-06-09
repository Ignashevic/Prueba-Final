<%@ include file="../includes/header.jsp" %>


<div class="row">
	<div class="col-md-12 maincajon">
		<span><a href="admin" class="btn btn-default">Volver</a></span>
		<c:if test="${not empty msg}">
			<p class="alert alert-success" role="alert">${msg}</p>
		</c:if>
		<c:choose>
			<c:when test="${curso.id == -1}">
				<h2>Crear Curso</h2>
			</c:when>
			<c:otherwise>
				<h2>Modificar Curso</h2>
			</c:otherwise>
		</c:choose>
		<form:form action="curso/crear" modelAttribute="curso">
			<label>Id:</label>
			<form:input class="form-control" path="id" readonly="true"/><br>
			<label>Nombre del curso:</label>
			<form:input class="form-control" path="nombrecur"/><br>
			<form:errors path="nombrecur" cssStyle="color:red;"/><br>
			<label>Codigo del curso:</label>
			<form:input class="form-control" path="codigocur"/><br>
			<form:errors path="codigocur" cssStyle="color:red;"/><br>
			<c:choose>
				<c:when test="${curso.id == -1}">
					<form:button type="submit" class="btn btn-primary margin1">Crear</form:button>
				</c:when>
				<c:otherwise>
					<form:button type="submit" class="btn btn-primary margin1">Modificar</form:button>
				</c:otherwise>
			</c:choose>
		</form:form>
	</div>
</div>

<%@ include file="../includes/footer2.jsp" %>