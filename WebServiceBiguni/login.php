<?php 
	$msg;
	if(isset($_POST['matricula']) && isset($_POST['senha'])){
		$matricula = str_replace(" ", "", $_POST['matricula']);
		$senha = str_replace(" ", "", $_POST['senha']);
		if(strlen($matricula)< 4 || strlen($matricula)>50){
			$msg = array('status' => 0, 'msg' =>"login precisa ser maior que 3 e menor que 50 caracteres" );
		}elseif(strlen($senha)< 8 || strlen($senha)>30) {
			$msg = array('status' => 0, 'msg' =>"senha precisar ser maior que 7 e menor que 30" );
		}else{
			require_once("logar.php");
		}
	}else{
		$msg = array('status' => 0, 'msg' =>"Informe o usuario e a senha" );
	}
	echo json_encode($msg);
?>