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
@WebServlet("/actualizarEstudiante")
public class ActualizarEstudianteServlet extends HttpServlet {
    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // se declara un objeto de tipo estudiante donde solo se le da valor al ID que sera buscado en la BD
        Estudiante estudianteParaEncontrar = new Estudiante();
        estudianteParaEncontrar.setIdestudiante(3);

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Estudiante estudianteAmodificar = iEstudianteService.buscarEstudiantePorId(estudianteParaEncontrar);

        // actualizamos los datos del estudiante que viene de la BD
        estudianteAmodificar.setNombre("Julia");
        estudianteAmodificar.setApellido("Lopez");
        estudianteAmodificar.setCarnet("LJ90021");

        // Se llama al metodo que ejecuta el query para actualizar los datos en la BD
        iEstudianteService.modificarEstudiante(estudianteAmodificar);

        // Colocamos un atributo llamado "estudianteActualizado" que sera referenciado asi en la pagina actualizarEstudiante.jsp
        request.setAttribute("estudianteActualizado", estudianteAmodificar);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/actualizarEstudiante.jsp").forward(request, response);
    }
}
