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

@WebServlet("/agregarEstudiante")
public class InsertarEstudianteServlet extends HttpServlet {
    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // se declara un objeto de tipo estudiante donde se llena la informacion del nuevo estudiante que sera ingresado en la BD
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setCarnet("CL100421");
        nuevoEstudiante.setApellido("campos Lopez");
        nuevoEstudiante.setNombre("Gabriel eduardo");

        // se inserta al estudiante en la BD con el metodo que proviene del servicio
        iEstudianteService.insertEstudiante(nuevoEstudiante);

        // se verifica que el estudiante haya sido creado, obteniendolo de la base de datos
        Estudiante buscarNuevoEstudiante = iEstudianteService.buscarEstudiantePorCarnet(nuevoEstudiante);

        // Colocamos un atributo llamado "nuevoEstudiante" que sera referenciado asi en la pagina agregarEstudiante.jsp
        request.setAttribute("nuevoEstudiante", buscarNuevoEstudiante);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/agregarEstudiante.jsp").forward(request, response);
    }
}
