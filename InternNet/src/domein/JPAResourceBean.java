/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Wim
 */
public class JPAResourceBean 
{
    protected EntityManagerFactory emf; //declaring entitymanager via de factory 
   
    // opvragen/bekomen van entity manager
     public EntityManagerFactory getEMF ()
     {
         // controlestructuur die kijkt of entity manager bestaat, zodat indien 
         // er 1 bestaat geen nieuwe moet gemaakt worden
        if (emf == null)
        {
            //aanmaken entitity manager
            emf = Persistence.createEntityManagerFactory("default", new java.util.HashMap());
        }
        // nu is er sowieso een entity manager en kunnen we die retourneren
        return emf;
     }
}
