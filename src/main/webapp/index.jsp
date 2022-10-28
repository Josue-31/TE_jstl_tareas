
<%@page import="com.emergentes.modelo.Tarea"%>
<%@page import="com.emergentes.modelo.GestorTareas"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("agenda")== null){
        GestorTareas agenda = new GestorTareas();
        
        agenda.insertarTarea(new Tarea(1, "Reunion con estudiantes de la carrera", "Alta"));
        agenda.insertarTarea(new Tarea(2, "Estudiar para el examen de Estadistica", "Alta"));
        agenda.insertarTarea(new Tarea(3, "Partido de Futsal", "Baja"));
        
        session.setAttribute("agenda", agenda);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - Tarease</title>
    </head>
    <body>
        <h1>Lista de Tareas</h1>
        <a href="Controller?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Prioridad</th>
            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.tarea}</td>
                    <td>${item.prioridad}</td>
                    <td><a href="Controller?op=modificar&id=${item.id}">Modificar</a></td>
                    <td><a href="Controller?op=eliminar&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
