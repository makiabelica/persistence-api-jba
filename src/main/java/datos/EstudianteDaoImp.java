package datos;

import com.example.registroacademico.Estudiante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EstudianteDaoImp implements  IEstudianteDao {
    @PersistenceContext(unitName = "EstudianteUP")
    EntityManager em;


    @Override
    public List<Estudiante> buscarTodosEstudiante() {
        return em.createNamedQuery("Estudiante.findAll").getResultList();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return em.find(Estudiante.class, estudiante.getId());
    }

    @Override
    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante) {
        Query q = em.createNamedQuery("from Estudiante e where e.carnet: carnet");
        q.setParameter("carnet", estudiante.getCarnet());
        return (Estudiante) q.getSingleResult();
    }

    @Override
    public void insertEstudiante(Estudiante estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void modificarEstudiante(Estudiante estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        em.remove(em.merge(estudiante));
    }
}
