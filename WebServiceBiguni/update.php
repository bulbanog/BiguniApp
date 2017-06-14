<?php 
if(isset($_GET['matricula'])){
	$matricula = $_GET['matricula'];
	$email= $_GET['email'];
	$nome = $_GET['nome'];
	$telefone = $_GET['telefone'];
	$avatar = $_GET['avatar'];
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