<?php 
include "conexao.php";
$sql = "SELECT * FROM usuario_carona";
//executando a consulta e guardando o valor
$resultado = $conexao->query($sql);
if($resultado){
	//criando o array que vai receber a lista de usuários
	$usuarios = [];
	//preenchendo o array com os usuários retornados do banco
	while ($usuario = mysqli_fetch_assoc($resultado)) {
		array_push(array, var)($usuarios, $usuario);
	}
	//exibindo o resultado
	echo json_encode($usuarios);
}
?>