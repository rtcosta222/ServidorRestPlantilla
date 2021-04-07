<%-- 
    Document   : webapiplantilla
    Created on : 07-abr-2021, 19:15:03
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.ControllerPlantilla" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumo XML Java Api Plantilla</title>
    </head>
    <body>
        <h1>Consumo XML Java Api Plantilla</h1>
        <table>
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Funcion</th>
                    <th>Turno</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaPlantilla()%>
            </tbody>
        </table>
    </body>
</html>
