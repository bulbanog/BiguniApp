<?php 
if(isset($_POST['matricula'])){
	$matricula = $_POST['matricula'];
	$email= $_POST['email'];
	$nome = $_POST['nome'];
	$telefone = $_POST['telefone'];
	$avatar = $_POST['avatar'];
	include "conexao.php";
	//escrita da consulta
	$sql = "UPDATE usuarios SET email='$email', nome='$nome', telefone='$telefone',avatar='$avatar' WHERE matricula=$matricula";
	if($conexao->query($sql)){
		$msg = array('status' => 1, 'msg' =>"atualizado com sucesso" );
	}else{
		$msg ="Erro na atualizacao <br>".mysqli_error($conexao);
	}
	header("content-type: application/json");
	echo json_encode($msg);
}else{
	echo "Usuario nao informado!";
}
?>