<%@ include file="includes/header.jsp" %>

<div class="col-md-12">
	<div class="container">
		<div class="row homewrapper">
			<div class="col-md-12">
				<div class="col-md-2"></div>
  				<form class="col-md-8 navbar-form navbar-left">
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-search"></span>
						</span>					
						<input id="buscar_receta" 
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
				<ul class="listaultimos10">
					<c:forEach items="${cursos}" var="cur">
						<li>${cur.nombrecur} - ${cur.codigocur} <a class="ojo" href="#"><i class="fa fa-eye fa-2x" aria-hidden="true"></i></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>

<%@ include file="includes/footer.jsp" %>
