package servicios;

import com.example.registroacademico.Estudiante;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IEstudianteService {
    public List<Estudiante> buscarTodoEstudiante();
    public Estudiante buscarEstudiantePorId(Estudiante estudiante);
    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante);
    public void insertEstudiante(Estudiante estudiante);
    public void modificarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);
}
