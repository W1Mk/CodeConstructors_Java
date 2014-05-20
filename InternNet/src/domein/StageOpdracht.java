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
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author laurens
 */
@Entity

@Table (name="StageOpdracht")


public class StageOpdracht implements Serializable {
     @Id
     
    private int StageOpdrachtid;
    private String Naam;
    private String Omschrijving;
    private int Semester;
    private String Specialisatie;
    private String StageMentor;
    private int AantalStudenten;
    private String Status;
    private String Status2;
    @ManyToOne
    @JoinColumn(name = "BegeleiderFK")
    private StageBegeleider Stagebegeleider;
    @ManyToOne
    @JoinColumn(name = "BedrijfFK")
    private Bedrijf Bedrijf;
    @JoinTable(name="studentstageopdracht1",joinColumns = {@JoinColumn(name = "StageOpdrachtid",referencedColumnName="StageOpdrachtid")},inverseJoinColumns=@JoinColumn(name="StudentId",referencedColumnName="StudentId"))
    @ManyToMany
    private Collection<Student> Studenten;
    private String AcademieJaar;

    public int getStageOpdrachtid() {
        return StageOpdrachtid;
    }

    public String getNaam() {
        return Naam;
    }

    public String getOmschrijving() {
        return Omschrijving;
    }

    public int getSemester() {
        return Semester;
    }

    public String getSpecialisatie() {
        return Specialisatie;
    }

    public String getStageMentor() {
        return StageMentor;
    }

    public int getAantalStudenten() {
        return AantalStudenten;
    }

    public String getStatus() {
        return Status;
    }

    public String getStatus2() {
        return Status2;
    }

    public StageBegeleider getStagebegeleider() {
        return Stagebegeleider;
    }

    public Bedrijf getBedrijf() {
        return Bedrijf;
    }

    public Collection<Student> getStudenten() {
        return Studenten;
    }

    public String getAcademieJaar() {
        return AcademieJaar;
    }

    public void setStageOpdrachtid(int StageOpdrachtid) {
        this.StageOpdrachtid = StageOpdrachtid;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public void setOmschrijving(String Omschrijving) {
        this.Omschrijving = Omschrijving;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public void setSpecialisatie(String Specialisatie) {
        this.Specialisatie = Specialisatie;
    }

    public void setStageMentor(String StageMentor) {
        this.StageMentor = StageMentor;
    }

    public void setAantalStudenten(int AantalStudenten) {
        this.AantalStudenten = AantalStudenten;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setStatus2(String Status2) {
        this.Status2 = Status2;
    }

    public void setStagebegeleider(StageBegeleider Stagebegeleider) {
        this.Stagebegeleider = Stagebegeleider;
    }

    public void setBedrijf(Bedrijf Bedrijf) {
        this.Bedrijf = Bedrijf;
    }

    public void setStudenten(Collection<Student> Studenten) {
        this.Studenten = Studenten;
    }

    public void setAcademieJaar(String AcademieJaar) {
        this.AcademieJaar = AcademieJaar;
    }

    public StageOpdracht(int StageOpdrachtid, String Naam, String Omschrijving, int Semester, String Specialisatie, String StageMentor, int AantalStudenten, String Status, String Status2, StageBegeleider Stagebegeleider, Bedrijf Bedrijf, Collection<Student> Studenten, String AcademieJaar) {
        this.StageOpdrachtid = StageOpdrachtid;
        this.Naam = Naam;
        this.Omschrijving = Omschrijving;
        this.Semester = Semester;
        this.Specialisatie = Specialisatie;
        this.StageMentor = StageMentor;
        this.AantalStudenten = AantalStudenten;
        this.Status = Status;
        this.Status2 = Status2;
        this.Stagebegeleider = Stagebegeleider;
        this.Bedrijf = Bedrijf;
        this.Studenten = Studenten;
        this.AcademieJaar = AcademieJaar;
    }
    
    public StageOpdracht(){
        
    }
    public List<StageOpdracht> StageOpdrachtList(EntityManager em){
         em.clear();
         AcademieJaar ac = new AcademieJaar();
       Query query = em.createQuery("select x from StageOpdracht x where x.AcademieJaar='"+ac.lijstAcademieJaar(em).iterator().next().getAcademieJaar()+"'",StageOpdracht.class);
         return query.getResultList();
        
    }
}
