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

@WebServlet("/estudiante")
public class EstudianteServlet extends HttpServlet {

    @Inject
    IEstudianteService iEstudianteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Estudiante> estudiantes = iEstudianteService.buscarTodoEstudiante();
        System.out.println("estudiantes: " + estudiantes);
        request.setAttribute("estudiante", estudiantes);
        request.getRequestDispatcher("/listadoEstudiante.jsp").forward(request,response);
    }
}
