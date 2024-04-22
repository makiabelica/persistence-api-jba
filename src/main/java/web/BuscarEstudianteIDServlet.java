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
@WebServlet("/buscarEstudianteId")
public class BuscarEstudianteIDServlet extends HttpServlet {
    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // se declara un objeto de tipo estudiante donde solo se le da valor al ID que sera buscado en la BD
        Estudiante estudianteBuscarPorId = new Estudiante();
        estudianteBuscarPorId.setIdestudiante(4);

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Estudiante estudiante = iEstudianteService.buscarEstudiantePorId(estudianteBuscarPorId);

        // Colocamos un atributo llamado "estudiante" que sera referenciado asi en la pagina buscarEstudianteCarnet.jsp
        request.setAttribute("estudiante", estudiante);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/buscarEstudianteID.jsp").forward(request, response);
    }
}
