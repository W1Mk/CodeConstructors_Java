/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapping;

import domein.StageBegeleider;

/**
 *
 * @author Wim
 */
public class StageBegeleiderMapper 
{
    public PersistenceHulp ph = new PersistenceHulp();
    
    public StageBegeleider createBegeleider(int id, String naam)
    {
        ph.start();
        
        StageBegeleider beg = new StageBegeleider();
        
        beg.setId(id);
        beg.setNaam(naam);
        
        ph.getEm().persist(beg);
        ph.end();
        
        return beg;
    }
    
    public StageBegeleider findBegeleider(int id)
    {
        ph.start();
        StageBegeleider b = ph.getEm().find(StageBegeleider.class, id);
        ph.end();
        return b;
    }
    
    public void removeBegeleider(int id)
    {
        ph.start();
        StageBegeleider b = ph.getEm().find(StageBegeleider.class, id);
        if (b != null)
        {
            ph.getEm().remove(b);
        }
        ph.end();
    }
    
    public StageBegeleider update(int id, String naam)
    {
        ph.start();
        
        StageBegeleider b = ph.getEm().find(StageBegeleider.class, id);
        
        if (b != null)
        {
            if (b.getNaam() != naam && naam != null)
            {
                b.setNaam(naam);
            }
        }
        
        ph.end();
        
        return b;
    }
}
