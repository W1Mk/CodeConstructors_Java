/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package internnet2;

import domein.AcademieJaar;
import domein.StageBegeleider;
import domein.StageOpdracht;
import domein.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Wim
 */
public class PersistenceHulp {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersistenceHulp()
    {
        
    }
    
    public void start()
    {
        emf = Persistence.createEntityManagerFactory("CodeConstructors");
        emf.createEntityManager();
        em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
    }
    
    public EntityManager getEm(){
        return em;
    }
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    public void saveStageOpdracht(StageOpdracht stageopdracht){
      em.merge(stageopdracht);
    }
     public void saveStudent(Student student){
      em.merge(student);
    }
      public void saveAcademieJaar(AcademieJaar ac){
      em.merge(ac);
    }
      public void saveBegeleider(StageBegeleider sb){
      em.merge(sb);
    }
    public void end()
    {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
