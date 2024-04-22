package web;

import com.example.registroacademico.Estudiante;
import servicios.IEstudianteService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


// se define la ruta que va a apuntar en la URL
@WebServlet("/estudiantes")
public class EstudianteServlet extends HttpServlet {

    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // se obtiene una lista proveniente de la BD con todos los estudiantes
        List<Estudiante> estudiantes = iEstudianteService.buscarTodoEstudiante();

        // Colocamos un atributo llamado "estudiantes" que sera referenciado asi en la pagina listadoEstudiante.jsp
        request.setAttribute("estudiantes", estudiantes);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/listadoEstudiante.jsp").forward(request,response);
    }
}
