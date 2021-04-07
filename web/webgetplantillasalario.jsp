<%-- 
    Document   : webgetplantillasalario
    Created on : 07-abr-2021, 20:20:00
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.ControllerPlantilla" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumo XML Java Api Plantilla/Salario</title>
    </head>
    <body>
        <h1>Consumo XML Java Api Plantilla/Salario</h1>
        <form method="post">
            <label>Salario </label>
            <input type="text" name="cjsalario"/>
            <button type="submit">Ver plantilla</button>
        </form>
        
    <%  String ui = request.getParameter("cjsalario");
        if(ui != null){
            int salario = Integer.parseInt(ui);
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
                    <%=controller.getPlantillaSalario(salario)%>
                </tbody>
            </table>
    <%  }
    %>
    </body>
</html>
