<%@ include file="../includes/header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6 maincajon">
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
				<label for="id">Id:</label>
				<form:input id="id" class="form-control" path="id" readonly="true"/><br>
				<label for="nombre">Nombre del curso:</label>
				<form:input id="nombre" class="form-control" path="nombrecur"/><br>
				<form:errors path="nombrecur" cssStyle="color:red;"/><br>
				<label for="codigo">Codigo del curso:</label>
				<form:input id="codigo" class="form-control" path="codigocur"/><br>
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
		<div class="col-md-3"></div>
	</div>
</div>

<%@ include file="../includes/footer2.jsp" %>