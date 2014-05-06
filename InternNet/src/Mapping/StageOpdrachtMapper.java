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
    
    public StageOpdracht findBegeleider(int id)
    {
        ph.start();
        StageOpdracht o = ph.getEm().find(StageOpdracht.class, id);
        ph.end();
        return o;
    }
    
    public void removeBegeleider(int id)
    {
        ph.start();
        StageOpdracht o = ph.getEm().find(StageOpdracht.class, id);
        if (o != null)
        {
            ph.getEm().remove(o);
        }
        ph.end();
    }
    
    public StageOpdracht update(int id, String naam, String semester,
     String omschrijving, String specialisatie)
    {
        ph.start();
        
        StageOpdracht o = ph.getEm().find(StageOpdracht.class, id);
        
        if (o != null)
        {
            if (o.getNaam() != naam && naam != null)
            {
                o.setNaam(naam);
            }
            
            if (o.getOmschrijving() != omschrijving && omschrijving != null)
            {
                o.setOmschrijving(omschrijving);
            }
            
            if (o.getSemester() != semester && semester != null)
            {
                o.setSemester(semester);
            }
            
            if (o.getSpecialisatie() != specialisatie && specialisatie != null)
            {
                o.setSpecialisatie(specialisatie);
            }
        }
        
        ph.end();
        
        return o;
    }
}
