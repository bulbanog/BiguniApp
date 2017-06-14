<?php 
include "conexao.php";
//usuario banco de dados
$matricula = $_POST['matricula'];
$email = $_POST['email'];
$senha = $_POST['senha'];
$nome = $_POST['nome'];
$telefone =$_POST['telefone'];
$avatar = $_POST['avatar'];

$sql = "INSERT INTO usuarios VALUES ($matricula,'$email', MD5('$senha'),'$nome', '$telefone', '$avatar')";
if($conexao->query($sql)){
	$msg = array('status' => 1,'msg'=>'Usuário inserido com sucesso' );
}else{
	echo "Erro = ".$sql."<br />".mysqli_error($conexao);
}
$json = $msg;
header('content-type: application/json');
echo json_encode($json);
?>