<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>.:Cleni Duarte - Imobiliaria:.</title>
		<link rel="stylesheet" type='text/css' href='<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-theme.css'/>
		<link rel="stylesheet" type='text/css' href='<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css'/>
		<link rel="stylesheet" type='text/css' href='<%=request.getContextPath()%>/resources/css/cleniduarte.commons.css'/>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body class="content">
		<h1>Autenticação obrigatoria</h1>
		<form action="/cleniduarte/admin/authenticate" method='POST'>
			Login: <input id='login' name='login' type='text'/>
			Senha: <input id='password' name='password' type='password'/>
			<input type='submit' value='Entrar' />
		</form>
	</body>
</html>