<%@ include file="includes/header.jsp" %>

<div class="col-md-12">
	<div class="container">
		<div class="row homewrapper">
			<div class="col-md-12">
				<div class="col-md-2"></div>
  				<form class="col-md-8 navbar-form navbar-left">
					<div class="input-group">
						<span class="input-group-addon">
							<label for="buscar_curso">Buscar:</label>	
							<span class="glyphicon glyphicon-search"></span>
						</span>				
						<input id="buscar_curso" 
							       type="text" 
							       class="form-control"
							       size="100"
							       placeholder="busca tu curso...">
					</div>				
				</form>
				<div class="col-md-2"></div>
			</div>
			<div class="col-md-12 cajaultimos10">
			<h2>Ultimos 10 cursos</h2>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>Id</th>
					    <th>Nombre Curso</th>
					    <th>Codigo Curso</th>
					    <th>Ver detalle</th>
	 				</tr>
 				</thead>
 				<tbody>
 					<c:forEach items="${cursos}" var="cur">
  						<tr>
  							<td>${cur.id}</td>
					    	<td>${cur.nombrecur}</td>
					    	<td>${cur.codigocur}</td>
  							<td><a class="ojo" href="curso/show/${cur.id}"><span class="fa fa-eye fa-2x" aria-hidden="true"></span></a></td>
  						</tr>
  					</c:forEach>
  				</tbody>
			</table>
				<!-- <ul class="listaultimos10">
					<c:forEach items="${cursos}" var="cur">
						<li>${cur.nombrecur} - ${cur.codigocur} </li>
					</c:forEach>
				</ul> -->
			</div>
		</div>
	</div>
</div>

<%@ include file="includes/footer.jsp" %>
