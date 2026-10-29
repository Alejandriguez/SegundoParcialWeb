package org.gerdoc.servlet;

import org.gerdoc.model.Usuario;
import org.gerdoc.service.UsuarioService;
import org.gerdoc.service.impl.UsuarioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet
{
    @Serial
    private static final long serialVersionUID = 1L;
    private final UsuarioService usuarioService = new UsuarioServiceImpl( );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String accion = req.getParameter("accion");
        if ("delete".equals(accion))
        {
            Long id = Long.parseLong(req.getParameter("id"));
            usuarioService.deleteById(id);
            resp.sendRedirect("Alumnos.jsp");
            return;
        }
        String nombre = req.getParameter("nombre" );
        Integer edad = Integer.parseInt( req.getParameter("edad" ) );
        Double promedio = Double.parseDouble( req.getParameter("promedio" ) );
        Long id = Long.parseLong( req.getParameter("id" ) );

        Usuario usuario = Usuario.builder( )
                .nombre( nombre )
                .edad( edad )
                .promedio( promedio )
                .build();
        if( "update".equals(accion) )
        {
            usuario.setId( id );
            usuarioService.update( usuario );
        }
        else
        {
            usuarioService.save( usuario );
        }
        resp.sendRedirect("Alumnos.jsp");
    }
}
