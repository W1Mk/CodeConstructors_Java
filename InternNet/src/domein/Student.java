/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author laurens
 */
@Entity

@Table (name="student")
public class Student implements Serializable {
         @Id
         private int StudentId;
         private String Naam;
         private String Email;
         private String TweedeEmail;
         private String Wachtwoord;
         private String Adres;
         private String Gsm;
         private String KeuzeVak;
         @Temporal(TemporalType.DATE)
         private Date BeginDatum;
         @Temporal(TemporalType.DATE)
         private Date EindeDatum;
         private String StageContract;
         @ManyToMany(mappedBy="Studenten")
         private Collection<StageOpdracht> Stages;
        

    public Student() {
       
    }

    public Student(int StudentId, String Naam, String Email, String TweedeEmail, String Wachtwoord, String Gsm, String KeuzeVak, List<StageOpdracht> stageopdracht) {
        this.StudentId = StudentId;
        this.Naam = Naam;
        this.Email = Email;
        this.TweedeEmail = TweedeEmail;
        this.Wachtwoord = Wachtwoord;
        this.Gsm = Gsm;
        this.KeuzeVak = KeuzeVak;
       
    }

    public void setStageContract(String StageContract) {
        this.StageContract = StageContract;
    }

    public String getStageContract() {
        return StageContract;
    }
    

    public void setBeginDatum(Date BeginDatum) {
        this.BeginDatum = BeginDatum;
    }

    public void setEindeDatum(Date EindeDatum) {
        this.EindeDatum = EindeDatum;
    }

  /*  public void setStages(Collection<StageOpdracht> stages) {
        this.Stages = stages;
    }*/

    public Date getBeginDatum() {
        return BeginDatum;
    }

    public Date getEindeDatum() {
        return EindeDatum;
    }

    public Collection<StageOpdracht> getStages() {
        return Stages;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTweedeEmail(String TweedeEmail) {
        this.TweedeEmail = TweedeEmail;
    }

    public void setWachtwoord(String Wachtwoord) {
        this.Wachtwoord = Wachtwoord;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public void setGsm(String Gsm) {
        this.Gsm = Gsm;
    }

    public void setKeuzeVak(String KeuzeVak) {
        this.KeuzeVak = KeuzeVak;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String getNaam() {
        return Naam;
    }

    public String getEmail() {
        return Email;
    }

    public String getTweedeEmail() {
        return TweedeEmail;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public String getAdres() {
        return Adres;
    }

    public String getGsm() {
        return Gsm;
    }

    public String getKeuzeVak() {
        return KeuzeVak;
    }

   public List<Student> StudentList(EntityManager em){
       em.clear();
       Query query = em.createQuery("select x from Student x where x.BeginDatum IS NOT NULL AND x.StageContract ='geen' OR x.StageContract ='gemaakt'",Student.class);
        return query.getResultList();
       
   }
         
         
}
