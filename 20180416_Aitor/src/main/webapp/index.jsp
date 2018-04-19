<%-- 
    Document   : index
    Created on : 17-abr-2018, 12:19:19
    Author     : aitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css" media="screen" />
    </head>
    <body>
        <div class="columnasCentradas">
            <form action="Controlador" method="post">
                <table>
                    <tr>
                        <td><h1>Calculadora</h1></td>
                    </tr>
                    <tr>
                        <td><label for="operando1">Primer número:</label></td>
                        <td><input type="text" id="operando1" name="operando1"></td>
                    </tr>
                    <tr>
                        <td><label for="operando2">Segundo número:</label></td>
                        <td><input type="text" id="operando2" name="operando2"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="operacion" value="sumar" checked/>Sumar
                            <input type="radio" name="operacion" value="restar"/>Restar
                            <input type="radio" name="operacion" value="multiplicar"/>Mutiplicar
                            <input type="radio" name="operacion" value="dividir"/>Dividir
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="enviar" value="Calcular"/></td>
                        <td><input type="reset" name="limpiar" value="Limpiar"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
