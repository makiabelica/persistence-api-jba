package datos;

import com.example.registroacademico.Estudiante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EstudianteDaoImp implements  IEstudianteDao {
    @PersistenceContext(unitName = "EstudiantePU")
    EntityManager em;



    public List<Estudiante> buscarTodosEstudiante() {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.idestudiante", Estudiante.class);
        return q.getResultList();
    }


    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return em.find(Estudiante.class, estudiante.getIdestudiante());
    }


    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante) {
        Query q = em.createQuery("select e from Estudiante e where e.carnet = :carnet");
        q.setParameter("carnet", estudiante.getCarnet());
        return (Estudiante) q.getSingleResult();
    }


    public void insertEstudiante(Estudiante estudiante) {
        em.persist(estudiante);
    }


    public void modificarEstudiante(Estudiante estudiante) {
        em.merge(estudiante);
    }


    public void eliminarEstudiante(Estudiante estudiante) {
        em.remove(em.merge(estudiante));
    }
}
