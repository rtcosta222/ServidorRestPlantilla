<%-- 
    Document   : webapiplantillafuncion02
    Created on : 08-abr-2021, 2:28:53
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.ControllerPlantilla" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumo XML Java Api Plantilla/Función</title>
    </head>
    <body>
        <h1>Consumo XML Java Api Plantilla/Función</h1>
        <form method="post">
            <label>Función: </label>
            <select name="selectedfuncion">
                <%=controller.getPlantillaFunciones()%>
            </select>
            <button type="submit">Ver plantilla</button>
        </form>
        
    <%  String funcion = request.getParameter("selectedfuncion");
        if(funcion != null){
    %>      <table>
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Funcion</th>
                        <th>Turno</th>
                        <th>Salario</th>
                    </tr>
                </thead>
                <tbody>
                    <%=controller.getPlantillaFuncion(funcion)%>
                </tbody>
            </table>
    <%  }
    %>
    </body>
</html>
