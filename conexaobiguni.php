<?php 
	$conexao = mysqli_connect("localhost","root","","biguniapp");
	if(!$conexao){
		echo mysql_errno();
	}

?>