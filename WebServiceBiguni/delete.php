<?php 
	//cria a variável que vai receber a mensagem
	$msg;
	//verifica se o id do usuário foi informado pela aplicação
	if(isset($_GET['matricula'])){
		// caso o id esteja setado faz a conexao
		include "conexao.php";
		//adiciona o conteúdo do id à variável id
		$matricula = $_GET['matricula'];
		//escreve a consulta sql para retornar o usuário que contenha o id informado
		$sql = "DELETE FROM usuarios WHERE matricula=$matricula";
		//efetua a consulta no banco
		$resultado = $conexao->query($sql);
		if($resultado){
			//caso exista retorno adiciona os dados retornados à mensagem retornada para a aplicação
			$msg = array('status'=>1, 'msg' => "usuario deletado com sucesso");
		}else{
			$msg = array('status' => 2, 'msg' => "usuario informado nao existe");
		}
		//adicionar o usuário retornado ao json
	}else{
		$msg = array('status' => 3, 'msg' => "nenhum usuario foi informado");
	}
	echo json_encode($msg);
?>