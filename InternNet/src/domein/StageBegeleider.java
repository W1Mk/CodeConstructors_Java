/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author laurens
 */

@Entity
@Table (name="StageBegeleider")
public class StageBegeleider implements Serializable {
   @Id
   private int Id;
   private String Naam;
   private String Voornaam;
   private String Adres;
   private String Email;
   private String Gsm;
   private String Telefoon;
   private String Wachtwoord;
   @JoinTable(name="stagebegeleiderstageopdracht1",joinColumns = {@JoinColumn(name = "begeleidersidV",referencedColumnName="Id")},inverseJoinColumns=@JoinColumn(name="stageopdrachtidV",referencedColumnName="StageOpdrachtid"))
    @ManyToMany
   private Collection<StageOpdracht> Stages;
   

    public StageBegeleider() {
    }

    public StageBegeleider(int Id, String Naam, String Voornaam, String Adres, String Email, String Gsm, String Telefoon, String Wachtwoord) {
        this.Id = Id;
        this.Naam = Naam;
        this.Voornaam = Voornaam;
        this.Adres = Adres;
        this.Email = Email;
        this.Gsm = Gsm;
        this.Telefoon = Telefoon;
        this.Wachtwoord = Wachtwoord;
    }

    public void setStages(Collection<StageOpdracht> Stages) {
        this.Stages = Stages;
    }

    public Collection<StageOpdracht> getStages() {
        return Stages;
    }

    public int getId() {
        return Id;
    }

    public String getNaam() {
        return Naam;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public String getAdres() {
        return Adres;
    }

    public String getEmail() {
        return Email;
    }

    public String getGsm() {
        return Gsm;
    }

    public String getTelefoon() {
        return Telefoon;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public void setVoornaam(String Voornaam) {
        this.Voornaam = Voornaam;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGsm(String Gsm) {
        this.Gsm = Gsm;
    }

    public void setTelefoon(String Telefoon) {
        this.Telefoon = Telefoon;
    }

    public void setWachtwoord(String Wachtwoord) {
        this.Wachtwoord = Wachtwoord;
    }

     public List<StageOpdracht> StageOpdrachtListPerBegeleider(EntityManager em){
       em.clear();
       AcademieJaar ac = new AcademieJaar();
       Query query = em.createQuery("select x from StageOpdracht x where x.Status2 is null OR x.Status2='goedgekeurd' AND x.AcademieJaar='"+ac.lijstAcademieJaar(em).iterator().next().getAcademieJaar()+"'",StageOpdracht.class);
        return query.getResultList();
       
   }
    public List<StageBegeleider> StageBegeleiderList(EntityManager em){
       em.clear();
       Query query = em.createQuery("select x from StageBegeleider x",StageBegeleider.class);
        return query.getResultList();
       
   }
   
}
