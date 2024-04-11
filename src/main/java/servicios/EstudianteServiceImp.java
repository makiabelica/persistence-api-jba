package servicios;

import com.example.registroacademico.Estudiante;
import datos.IEstudianteDao;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class EstudianteServiceImp implements  IEstudianteService {
    @Inject
    private IEstudianteDao iEstudiante;


    public List<Estudiante> buscarTodoEstudiante() {
        return iEstudiante.buscarTodosEstudiante();
    }


    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return iEstudiante.buscarEstudiantePorId(estudiante);
    }


    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante) {
        return iEstudiante.buscarEstudiantePorCarnet(estudiante);
    }

    public void insertEstudiante(Estudiante estudiante) {
        iEstudiante.modificarEstudiante(estudiante);
    }


    public void modificarEstudiante(Estudiante estudiante) {
        iEstudiante.modificarEstudiante(estudiante);
    }


    public void eliminarEstudiante(Estudiante estudiante) {
        iEstudiante.eliminarEstudiante(estudiante);
    }
}
