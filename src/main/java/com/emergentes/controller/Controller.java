package com.emergentes.controller;

import com.emergentes.modelo.GestorTareas;
import com.emergentes.modelo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tarea tarea = new Tarea();
        int id;
        int pos;
        String opcion = request.getParameter("op");
        String op = (opcion != null) ? request.getParameter("op"):"view";
        if(op.equals("nuevo")){
            HttpSession session = request.getSession();
            GestorTareas agenda = (GestorTareas)session.getAttribute("agenda");
            
            tarea.setId(agenda.obtieneId());
            
            request.setAttribute("op", op);
            request.setAttribute("tarea", tarea);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("modificar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            GestorTareas agenda = (GestorTareas)session.getAttribute("agenda");
            pos = agenda.ubicarTarea(id);
            tarea = agenda.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("tarea", tarea);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            GestorTareas agenda = (GestorTareas)session.getAttribute("agenda");
            pos = agenda.ubicarTarea(id);
            
            agenda.eliminarTarea(pos);
            session.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
        if(op.equals("view")){
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tarea tarea = new Tarea();
        int pos;
        String op = request.getParameter("op");
        if(op.equals("grabar")){
            tarea.setId(Integer.parseInt(request.getParameter("id")));
            tarea.setTarea(request.getParameter("tarea"));
            tarea.setPrioridad(request.getParameter("prioridad"));
            
            HttpSession session = request.getSession();
            GestorTareas agenda = (GestorTareas)session.getAttribute("agenda");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                agenda.insertarTarea(tarea);
            }else{
                pos = agenda.ubicarTarea(tarea.getId());
                agenda.modificarTarea(pos, tarea);
            }
            session.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
    }

}
