<%-- 
    Document   : editar
    Created on : 25 oct. 2022, 21:31:37
    Author     : CJ
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - Tareas</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op == 'nuevo'}" var="res" scope="request">
                Registro de
            </c:if>
            <c:if test="${requestScope.op == 'modificar'}" var="res" scope="request">
                Modificar
            </c:if>
            Tarea
        </h1>
        <jsp:useBean id="tarea" scope="request" class="com.emergentes.modelo.Tarea"/>
        
        <form action="Controller" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td>
                        <input type="text" name="id" value="<jsp:getProperty name="tarea" property="id"/>">
                    </td>
                </tr>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tarea" value="<jsp:getProperty name="tarea" property="tarea"/>"></td>
                </tr>
                <tr>
                    <td>Prioridad</td>
                    <td>
                        <select name="prioridad">
                            <option value="Alta" 
                                    <c:if test="${tarea.prioridad == 'Alta'}" var="res" scope="request">
                                        selected </c:if>">Alta</option>
                            <option value="Media" <c:if test="${tarea.prioridad == 'Media'}" var="res" scope="request">
                                    selected</c:if>>Media</option>
                            <option value="Baja" <c:if test="${tarea.prioridad == 'Baja'}" var="res" scope="request">
                                    selected</c:if>>Baja</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}">
                        <input type="hidden" name="op" value="grabar">
                    </td>
                    <td><<input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
