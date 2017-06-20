<?php 
	include "conexao.php";
	$sql = "SELECT * FROM usuarios WHERE matricula='$matricula' AND senha='$senha'";
	$resultado = mysqli_fetch_assoc($conexao->query($sql));
	if($resultado){
		//caso exista retorno adiciona os dados retornados à mensagem retornada para a aplicação
		$msg = array('status'=>1, 'user' => $resultado);
	}else{
		$msg = array('status' => 2, 'msg' => "usuario informado nao existe");
	}
 ?>