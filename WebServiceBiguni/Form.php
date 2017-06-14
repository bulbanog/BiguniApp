<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Form CRUD</title>
</head>
<body>
	<h1>INSERIR USUARIO</h1>
	<form action="create.php" method="post">
		<input type="text" name="matricula" placeholder="insira Matricula">
		<input type="text" name="email" placeholder="insira Email">
		<input type="text" name="senha" placeholder="insira Senha">
		<input type="text" name="nome" placeholder="insira Nome">
		<input type="text" name="telefone" placeholder="insira Telefone">
		<input type="text" name="avatar" placeholder="insira avatar">
		<input type="submit" value="Inserir">
	</form>
	<h1>Fazer pesquisa</h1>
	<form action="read.php" method="get">
		<input type="text" name="matricula" placeholder="insira Matricula">
		<input type="submit" value="Pesquisar">
	</form>
	<h1>Editar Usuario</h1>
	<form action="update.php" method="get">
		<input type="text" name="matricula" placeholder="insira Matricula">
		<input type="text" name="email" placeholder="insira Email">
		<input type="text" name="nome" placeholder="insira Nome">
		<input type="text" name="telefone" placeholder="insira Telefone">
		<input type="text" name="avatar" placeholder="insira avatar">
		<input type="submit" value="Atualizar">
	</form>
	<h1>Delete Usuario</h1>
	<form action="delete.php" method="get">
		<input type="text" name="matricula" placeholder="insira Matricula">
		<input type="submit" value="Apagar">
	</form>
</body>
</html>
