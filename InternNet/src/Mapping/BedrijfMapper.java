/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapping;

import domein.Bedrijf;
import domein.StageOpdracht;
import javax.persistence.EntityManager;

/**
 *
 * @author Wim
 */
public class BedrijfMapper 
{
    
    public PersistenceHulp ph = new PersistenceHulp();
    
    public Bedrijf createBedrijf(int id, String naam, String email, String url, 
            String telefoon, String paswoord, String adres, 
            String bedrijfsactiviteit, String bereikbaarheid, 
            StageOpdracht stageOpdracht)
    {
        ph.start();
        Bedrijf bed = new Bedrijf(id);
        
        bed.setNaam(naam);
        bed.setEmail(email);
        bed.setUrl(url);
        bed.setTelefoon(telefoon);
        bed.setPaswoord(paswoord);
        bed.setAdres(adres);
        bed.setBedrijfsactiviteit(bedrijfsactiviteit);
        bed.setBereikbaarheid(bereikbaarheid);
        bed.setStageOpdracht(stageOpdracht);
        
        ph.getEm().persist(bed);
        
        ph.end();
        return bed;
    }
    
    public Bedrijf findBedrijf(int id)
    {
        ph.start();
        Bedrijf b = ph.getEm().find(Bedrijf.class, id);
        ph.end();
        return b;
    }
    
    public void removeBedrijf(int id)
    {
        ph.start();
        Bedrijf b = ph.getEm().find(Bedrijf.class, id);
        if (b != null)
        {
            ph.getEm().remove(b);
        }
        ph.end();
    }
    
    public Bedrijf update(int id, String naam, String email, String url, 
            String telefoon, String paswoord, String adres, 
            String bedrijfsactiviteit, String bereikbaarheid, 
            StageOpdracht stageOpdracht)
    {
        ph.start();
        Bedrijf b = ph.getEm().find(Bedrijf.class, id);
        if (b != null)
        {
            if (b.getNaam() != naam && naam != null)
            {
                b.setNaam(naam);
            }
            if (b.getEmail() != email && email != null)
            {
                b.setEmail(email);
            }
            if (b.getUrl() != url && url != null)
            {
                b.setUrl(url);
            }
            if (b.getTelefoon() != telefoon && telefoon != null)
            {
                b.setTelefoon(telefoon);
            }
            if (b.getPaswoord() != paswoord && paswoord != null)
            {
                b.setPaswoord(paswoord);
            }
            if (b.getAdres() != adres && adres != null)
            {
                b.setAdres(adres);
            }
            if (b.getBedrijfsactiviteit() != bedrijfsactiviteit && bedrijfsactiviteit != null)
            {
                b.setBedrijfsactiviteit(bedrijfsactiviteit);
            }
            if (b.getBereikbaarheid() != bereikbaarheid && bereikbaarheid != null)
            {
                b.setBereikbaarheid(bereikbaarheid);
            }
            if (b.getStageOpdracht() != stageOpdracht && stageOpdracht != null)
            {
                b.setStageOpdracht(stageOpdracht);
            }
        }
        ph.end();
        return b;
    }
}
