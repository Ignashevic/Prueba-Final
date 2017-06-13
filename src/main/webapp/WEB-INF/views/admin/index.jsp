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
		<a href="admin/curso/edit"><span class="fa fa-plus-square fa-2x" aria-hidden="true"></span></a>
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
						<a href="curso/eliminar/${cur.id}"><span class="fa fa-trash fa-2x" aria-hidden="true"></span></a>
						<a href="admin/curso/edit/${cur.id}" ><span class="fa fa-pencil fa-2x" aria-hidden="true"></span></a>
					</td>
				</tr>		
				</c:forEach>
			</tbody>	
		</table>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-body">
        ¿Estas seguro de que quieres eliminar el curso?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-danger">Si, eliminar</button>
      </div>
    </div>
  </div>
</div>




<%@ include file="../includes/footer2.jsp" %>

