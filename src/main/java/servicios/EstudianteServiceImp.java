package servicios;

import com.example.registroacademico.Estudiante;
import datos.IEstudianteDao;

import javax.inject.Inject;
import java.util.List;

public class EstudianteServiceImp implements  IEstudianteService {
    @Inject
    private IEstudianteDao iEstudiante;

    @Override
    public List<Estudiante> buscarTodoEstudiante() {
        return iEstudiante.buscarTodosEstudiante();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return iEstudiante.buscarEstudiantePorId(estudiante);
    }

    @Override
    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante) {
        return iEstudiante.buscarEstudiantePorCarnet(estudiante);
    }

    @Override
    public void insertEstudiante(Estudiante estudiante) {
        iEstudiante.modificarEstudiante(estudiante);
    }

    @Override
    public void modificarEstudiante(Estudiante estudiante) {
        iEstudiante.modificarEstudiante(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        iEstudiante.eliminarEstudiante(estudiante);
    }
}
