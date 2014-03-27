/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapping;

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
        emf = Persistence.createEntityManagerFactory("InternNetPU");
        emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public EntityManager getEm(){
        return em;
    }
    
    public void end()
    {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
