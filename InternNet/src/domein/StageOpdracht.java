/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Wim
 */
@Entity
public class StageOpdracht implements Serializable
{
    @Id
    private int id;
    private String naam;
    @OneToOne
    private Student student;
    private String semester;
    private String omschrijving;
    private String specialisatie;
    @OneToOne
    private StageBegeleider stagebegeleider;
    @OneToMany(mappedBy = "stageOpdracht")
    private List<Bedrijf> stages;

    public StageOpdracht() {
    }

    // Constructor,  aanmaken/aanvragen nieuwe opdracht
    public StageOpdracht(int id, String naam, Student student, String semester, String omschrijving, String specialisatie, StageBegeleider stagebegeleider) {
        this.id = id;
        this.naam = naam;
        this.student = student;
        this.semester = semester;
        this.omschrijving = omschrijving;
        this.specialisatie = specialisatie;
        this.stagebegeleider = stagebegeleider;
    }
    
    

    // opvragen id
    public int getId() {
        return id;
    }

    // wijzigen id
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

    // opvragen semester
    public String getSemester() {
        return semester;
    }

    // wijzigen semester
    public void setSemester(String semester) {
        this.semester = semester;
    }

    // opvragen omschrijving
    public String getOmschrijving() {
        return omschrijving;
    }

    // wijzigen omschrijving
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    // opvragen specialisatie
    public String getSpecialisatie() {
        return specialisatie;
    }

    // wijzigen specialisatie
    public void setSpecialisatie(String specialisatie) {
        this.specialisatie = specialisatie;
    }

    // opvragen aangewezen begeleider
    public StageBegeleider getStagebegeleider() {
        return stagebegeleider;
    }

    // begeleider vervangen
    public void setStagebegeleider(StageBegeleider stagebegeleider) {
        this.stagebegeleider = stagebegeleider;
    }

    // begeleider verwijderen van de opdracht?
    
    // opvragen welk student de stage mag doen
    public Student getStudent() {
        return student;
    }

    // een andere student kiezen
    public void setStudent(Student student) {
        this.student = student;
    }

    // student uit de opdracht verwijdern?
    
    // opdracht verwijderen?
}
