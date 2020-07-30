<?php
    $hostname_localhost = "localhost:3308";
    $username_localhost = "root";   
    $password_localhost = "";
    $database_localhost = "helpNomic";
    

    $json = array();

    

    if(isset($_GET["cedula"]) && isset($_GET["pass"])){

        $cedula = $_GET['cedula'];
        $pass = $_GET['pass'];


        $conexion = mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);
        
        if (!$conexion) {
            echo "Error: No se pudo conectar a MySQL.".PHP_EOL;
            echo "error de depuración: ".mysqli_connect_errno().PHP_EOL;
            echo "error de depuración: ".mysqli_connect_error().PHP_EOL;
            exit;
        }


        $consulta = "SELECT * FROM usuario WHERE cedula = '{$cedula}' AND pass = '{$pass}'";
        $resultado = mysqli_query($conexion, $consulta);

        if($registro = mysqli_fetch_array($resultado)){
            $json['usuario'][]=$registro;

            mysqli_close($conexion);
            echo json_encode($json);
        }else{
            $resulta["cedula"] = '0';
        }
        
    }else{
        $resulta["cedula"] = '0';
        $resulta["pass"] = '0000';

    }

?>