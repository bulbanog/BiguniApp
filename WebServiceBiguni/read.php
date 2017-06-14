<?php 

	$msg;
	
	if(isset($_GET['matricula'])){
		include "conexao.php";
		$matricula = $_GET['matricula'];
		
		$sql = "SELECT * FROM usuarios WHERE matricula=$matricula";
		//efetua a consulta no banco
		$resultado = mysqli_fetch_assoc($conexao->query($sql));
		if($resultado){
			//caso exista retorno adiciona os dados retornados à mensagem retornada para a aplicação
			$msg = array('status'=>1, 'user' => $resultado);
		}else{
			$msg = array('status' => 2, 'msg' => "usuario informado nao existe");
		}
		//adicionar o usuário retornado ao json
	}else{
		$msg = array('status' => 3, 'msg' => "nenhum usuario foi informado");
	}
	echo json_encode($msg);
?>