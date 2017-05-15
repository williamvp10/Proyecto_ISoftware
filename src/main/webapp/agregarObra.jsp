<%-- 
    Document   : agregarObra
    Created on : 12/05/2017, 10:14:18 AM
    Author     : Labing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method= "POST" action="HelloCrunchify">
            <h1>Nueva Obra</h1>
            <table>
                <tr>
                    <td>Nombre:</td>  
                    <td><input type="text" name="nombre" size="20" placeholder="Ingrese el nombre"/></td>
                </tr>
                <tr>
                    <td>descripcion:</td>  
                    <td><input type="text" name="descripcion" size="40" placeholder="descripcion"/></td>
                </tr>
                <tr>
                    <td>estilo:</td>  
                    <td><input type="text" name="estilo" size="40" placeholder="estilo"/></td>
                </tr>
                <tr>
                    <td>valor:</td>  
                    <td><input type="number" name="valor" size="20" placeholder="valor"/></td>
                </tr>
                <tr>
                    <td>user :</td>  
                    <td><input type="text" name="user" size="20" placeholder="user"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Crear" value="Crear"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.html'" name="regresar" value="Regresar"> </td>
                </tr>
            </table>
        </form>
        <%
                if (request.getAttribute("Mensaje") != null) {%>
        <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
        <% request.removeAttribute("Mensaje");%>
        <%
            }
        %>

    </body>
</html>
