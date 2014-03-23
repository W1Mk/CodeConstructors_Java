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
public class Student implements Serializable
{
    @Id
    private int id;
    private String naam;
    private String email;
    @OneToOne(mappedBy = "student")
    private StageOpdracht student;

    public Student() {
    }

    // Constructor, aanmaken nieuwe student
    public Student(int id, String naam, String email) {
        this.id = id;
        this.naam = naam;
        this.email = email;
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

    // opvragen mail
    public String getEmail() {
        return email;
    }

    // wijzigen mail
    public void setEmail(String email) {
        this.email = email;
    }
    
    // verwijderen student?
}
