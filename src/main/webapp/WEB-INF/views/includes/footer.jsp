<div class="col-md-12 barrafooter">
	<div class="container">
		<div class="row center">
			<h2>Siguenos en redes sociales</h2>
			<div class="col-md-3 center cajaredsocial">
				<div class="prueba">
					<img class="rrss" src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
				</div>
				<p class="nombrered">Twitter</p>
			</div>
			<div class="col-md-3 center cajaredsocial">
				<div class="prueba">
					<img class="rrss" src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
				</div>
				<p class="nombrered">Twitter</p>
			</div>
			<div class="col-md-3 center cajaredsocial">
				<div class="prueba">
					<img class="rrss" src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
				</div>
				<p class="nombrered">Twitter</p>
			</div>
			<div class="col-md-3 center cajaredsocial">
				<div class="prueba">
					<img class="rrss" src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
				</div>
				<p class="nombrered">Twitter</p>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12 columnacopy">
	<div class="container">
		<div class="row center filafooter">
			<ul class="listafooter">
				<li>Contacto</li>
				<li>Terminos</li>
				<li>Sitemap</li>
				<li>Politicas de privacidad</li>
				<li>Cookies</li>
				<li>Quienes Somos</li>
			</ul>
			<p class="copyright">&copy; 2017 Ignacio Serna</p>
		</div>
	</div>
	
</div>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="resources/js/buscador-receta.js"></script>
<script>
var castellano = {
	    "sProcessing":     "Procesando...",
	    "sLengthMenu":     "Mostrar _MENU_ registros",
	    "sZeroRecords":    "No se encontraron resultados",
	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	    "sInfoPostFix":    "",
	    "sSearch":         "Buscar:",
	    "sUrl":            "",
	    "sInfoThousands":  ",",
	    "sLoadingRecords": "Cargando...",
	    "oPaginate": {
	        "sFirst":    "Primero",
	        "sLast":     "Último",
	        "sNext":     "Siguiente",
	        "sPrevious": "Anterior"
	    },
	    "oAria": {
	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    }
	};
//Esperara a que todo el DOM este cargado
$(document).ready(function() {
	
    $('.tablePlugin').DataTable({
    		language: castellano,
    		order:[]
    });
    
    
});//$(document).ready
</script>

</body>
</html>