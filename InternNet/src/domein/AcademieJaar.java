/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author laurens
 */
@Entity

@Table (name="AcademieJaar")
public class AcademieJaar implements Serializable  {
 @Id
 private int Id;
 private String AcademieJaar;
 private Boolean Actief;

    public AcademieJaar(int Id, String AcademieJaar, Boolean Actief) {
        this.Id = Id;
        this.AcademieJaar = AcademieJaar;
        this.Actief = Actief;
    }
 
public AcademieJaar(){
    
}
    public int getId() {
        return Id;
    }

    public String getAcademieJaar() {
        return AcademieJaar;
    }

    public Boolean getActief() {
        return Actief;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setAcademieJaar(String AcademieJaar) {
        this.AcademieJaar = AcademieJaar;
    }

    public void setActief(Boolean Actief) {
        this.Actief = Actief;
    }
 public List<AcademieJaar> lijstAcademieJaar(EntityManager em){
       em.clear();
       
       Query query=em.createQuery("select x from AcademieJaar x where x.Actief=1",AcademieJaar.class);
       return query.getResultList();
 }
 public List<AcademieJaar> getAcademieJaarLijst(EntityManager em,String jaar){
     em.clear();
       
       Query query=em.createQuery("select x from AcademieJaar x where x.AcademieJaar='"+jaar+"'",AcademieJaar.class);
     return query.getResultList();
     
 }
 }

