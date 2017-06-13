/*
 * Buscador en la barra de navegación, para buscar recetas mediante la API  
 * Busca recetas que coincidan su nombre, minimo 3 letras 
 * Ejemplo: http://localhost:8080/formacion/api/receta/?filter=pat
 * 
 * */	
	
"use-strict"


$(function() {

	console.debug('search-curso.js ready');
			
	$( "#buscar_curso" ).autocomplete({		
		source: function( request, response ) {
	        $.ajax( {
	          url: "/pruebafinal/api/cursos/?filter=" + $("#buscar_curso").val(),
	          dataType: "json",	          
	          success: function( data ) {
	        	var aString = [];
	        	$.each(data, function(i,cur){	        		
	        		aString.push( {'label': cur.nombrecur, 'value' : cur.id} );	
	        	}); 	        	  
	            response( aString );
	          }
	        });
	      },		
	     minLength: 1,
	     select: function( event, ui ) {
	       console.debug( "Selected: " + ui.item.value + " id " + ui.item.label );
	       var url = "curso/show/" + ui.item.value;
	       window.location.href = url;
	     }
	});
	
	
	
})