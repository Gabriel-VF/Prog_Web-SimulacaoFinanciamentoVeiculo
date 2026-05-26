<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Dados para Calculo</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
	<script src='main.js'></script>
</head>
<body>
	<h1>Entrada de dados</h1>
	<form id="formId" action="dados" method="post">
		<label for="valorVeiculoId">Valor da compra: </label>
		<input id="valorVeiculoId" type="text" name="valorVeiculo" required placeholder="Insira valor da compra"/>
		<br>
		<label for="entradaId">Entrada: </label>
		<input id="entradaId" type="text" name="entrada" required placeholder="Insira entrada"/>
		<br>
		<label for="jurosId">Juros: </label>
		<input id="jurosId" type="text" name="juros" required placeholder="Insira juros">
		<br>
		<label for="prazoId">Prazo: </label>
		<input id="prazoId" type="text" name="prazo" required placeholder="Insira prazo">
		<br>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>