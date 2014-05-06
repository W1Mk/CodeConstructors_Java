/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapping;

import domein.StageOpdracht;

/**
 *
 * @author Wim
 */
public class StageOpdrachtMapper 
{
    public PersistenceHulp ph = new PersistenceHulp();
    
    public StageOpdracht createOpdracht(int id, String naam,  String semester,
     String omschrijving, String specialisatie)
    {
        ph.start();
        
        StageOpdracht op = new StageOpdracht();
        
        op.setId(id);
        op.setNaam(naam);
        op.setSemester(semester);
        op.setOmschrijving(omschrijving);
        op.setSpecialisatie(specialisatie);
        
        ph.getEm().persist(op);
        ph.end();
        
        return op;
    }
    
    
}
