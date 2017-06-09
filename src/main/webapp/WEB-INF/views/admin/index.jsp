<%@ include file="../includes/header.jsp" %>

<div class="container">
	<div class="row mainbackoffice">
		<c:if test="${not empty msg}">
			<p class="alert alert-success" role="alert">${msg}</p>
		</c:if>
		<h2>Cursos totales</h2><br>
		<button type="button" class="btn btn-info navbar-btn btnmigracion">
	  		<a href="admin/curso/migrar">Migración Excel</a>
	  	</button>
		<a href="admin/curso/edit"><i class="fa fa-plus-square fa-2x" aria-hidden="true"></i></a>
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




<%@ include file="../includes/footer2.jsp" %>

