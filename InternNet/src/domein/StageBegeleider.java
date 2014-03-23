/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Wim
 */
@Entity
public class StageBegeleider implements Serializable
{
    @Id
     private int id;
     private String naam;
    @OneToOne(mappedBy = "stagebegeleider")
    private StageOpdracht stageBegeleider;

    public StageBegeleider() {
    }

    // Constructor, toevoegen nieuwe begeleider
    public StageBegeleider(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    // opvragen begeleider id 
    public int getId() {
        return id;
    }

    // wijzigen begeleider id
    public void setId(int id) {
        this.id = id;
    }

    // opvragen naam 
    public String getNaam() {
        return naam;
    }

    // wijzigen naam
    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    // begeleider verwijderen?
}
