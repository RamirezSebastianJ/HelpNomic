<?php
    $hostname_localhost = "localhost:3308";
    $username_localhost = "root";   
    $password_localhost = "";
    $database_localhost = "helpNomic";
    

    $json = array();

    

    if(isset($_GET["nombre"]) && isset($_GET["cedula"]) && isset($_GET["pass"]) && isset($_GET["direccion"]) && isset($_GET["cantidad_prestamos"]) 
        && isset($_GET["puntos_negativos"]) && isset($_GET["telefono"]) && isset($_GET["deuda_total"]) && isset($_GET["id_administrador"])){

        $nombre = $_GET['nombre'];
        $cedula = $_GET['cedula'];
        $pass= $_GET['pass'];
        $direccion = $_GET['direccion'];
        $cantidad_prestamos = $_GET['cantidad_prestamos'];
        $puntos_negativos = $_GET['puntos_negativos'];
        $telefono = $_GET['telefono'];
        $deuda_total = $_GET['deuda_total'];
        $id_administrador = $_GET['id_administrador'];

        $conexion = mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);
        
        if (!$conexion) {
            echo "Error: No se pudo conectar a MySQL.".PHP_EOL;
            echo "error de depuración: ".mysqli_connect_errno().PHP_EOL;
            echo "error de depuración: ".mysqli_connect_error().PHP_EOL;
            exit;
        }
    
        $insert = "INSERT INTO usuario(nombre, cedula, pass, direccion, cantidad_prestamos, puntos_negativos, telefono, deuda_total, id_administrador) VALUES ('{$nombre}', '{$cedula}', '{$pass}', '{$direccion}', '{$cantidad_prestamos}', '{$puntos_negativos}', '{$telefono}', '{$deuda_total}', '{$id_administrador}')";
        $resultado_insert = mysqli_query ($conexion, $insert);
        


        if($resultado_insert){
            $consulta = "SELECT * FROM usuario WHERE cedula = '{$cedula}'";
            $resultado = mysqli_query($conexion, $consulta);

            if($registro = mysqli_fetch_array($resultado)){
                $json['usuario'][]=$registro;
            }

            mysqli_close($conexion);
            echo json_encode($json);
        }else{
            $resulta["nombre"] = 'No registra';
            $resulta["cedula"] = '0';
            $resulta["pass"] = '0000';
            $resulta['direccion'] = 'no registra';
            $resulta["cantidad_prestamos"] = '0';
            $resulta["puntos_negativos"] = '0';
            $resulta["telefono"] = '0' ;
            $resulta["deuda_total"] = '0';
            $resulta["id_administrador"] = '0';
            $json['usuario'][] = $resulta;
            echo json_encode($json);
        }
        
    }else{
        $resulta["nombre"] = 'WS No registra';
        $resulta["cedula"] = '0';
        $resulta["pass"] = '0000';
        $resulta['direccion'] = ' WS no registra';
        $resulta["cantidad_prestamos"] = '0';
        $resulta["puntos_negativos"] = '0';
        $resulta["telefono"] = '0' ;
        $resulta["deuda_total"] = '0';
        $resulta["id_administrador"] = '0';
        $json['usuario'][] = $resulta;
        echo json_encode($json);
    }

?>