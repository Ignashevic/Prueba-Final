<%@ include file="../includes/header.jsp" %>

<h1>Backoffice!</h1>

<a href="admin/curso/edit" class="btn btn-default">Crear curso nuevo</a>

<div class="container">
	<div class="row">
		<c:if test="${not empty msg}">
			<p class="alert alert-success" role="alert">${msg}</p>
		</c:if>
		<table class="tablePlugin" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre Curso</th>
					<th>Codigo Curso</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cursos}" var="cur">
				<tr>
					<td>${cur.id}</td>
					<td>${cur.nombrecur}</td>
					<td>${cur.codigocur}</td>
					<td>
						<a href="curso/eliminar/${cur.id}"><i class="fa fa-trash fa-2x" aria-hidden="true"></i></a>
						<a href="admin/curso/edit/${cur.id}"><i class="fa fa-pencil fa-2x" aria-hidden="true"></i></a>
					</td>
				</tr>		
				</c:forEach>
			</tbody>	
		</table>
	</div>
</div>




<%@ include file="../includes/footer.jsp" %>

