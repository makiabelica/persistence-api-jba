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


// se define la ruta que va a apuntar en la URL
@WebServlet("/eliminarEstudiante")
public class EliminarEstudianteServlet extends HttpServlet {
    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // se declara un objeto de tipo estudiante donde solo se le da valor al ID que sera buscado en la BD
        Estudiante estudianteParaEncontrar = new Estudiante();
        estudianteParaEncontrar.setIdestudiante(3);

        // Antes de eliminarlo colocamos un atributo llamado "estudianteEliminadoID" que sera referenciado asi en la pagina eliminarEstudiante.jsp
        request.setAttribute("estudianteEliminadoID", estudianteParaEncontrar.getIdestudiante());

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Estudiante estudianteAEliminar = iEstudianteService.buscarEstudiantePorId(estudianteParaEncontrar);

        // se ejecuta el metodo de eliminar
        iEstudianteService.eliminarEstudiante(estudianteAEliminar);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/eliminarEstudiante.jsp").forward(request, response);
    }
}
