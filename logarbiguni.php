<?php 
	$login = $_POST['matricula'];
	$senha = $_POST['senha'];
	
	include("conexao.php");
	$sql = "SELECT nome from `usuario` WHERE matricula='$matricula' and senha='$senha'";
	 
	$consulta = mysqli_query($conexao,$sql);
	if(!$consulta){
		echo mysqli_errno($conexao);
	}else{
		while($usuario = mysqli_fetch_assoc($consulta)){
			session_start();
			$_SESSION['nome'] = $usuario["nome"];
		}
		header("Location:index.php?p=hello");
	}
 ?>