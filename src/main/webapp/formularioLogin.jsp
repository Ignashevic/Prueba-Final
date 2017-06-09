<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/login.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	</head>
	<body>
		<div class="login-page">
		  <div class="form">
		  	<img alt="Brand" src="http://sc1.emgcdn.net/assets/es/logos/centro/id/56051/size/m.png">
		    <form class="register-form" action="login" method="post">
		      <input type="text" name="usuario" placeholder="Usuario"/>
		      <input type="password" name="clave" placeholder="Contraseña"/>
		      <button type="submit">Validar</button>
		    </form>
		  </div>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="resources/js/login.js"></script>
	</body>
</html>