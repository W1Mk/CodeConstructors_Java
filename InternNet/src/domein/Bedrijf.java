/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Wim
 */
@Entity
public class Bedrijf implements Serializable //gebruik van implementatie serializable 
// is voor het beter wegschrijven/opslaan ... in een bestand of db
{
    @Id //bepalen wat de sleutelwaarder is
    private int id;
    
    private String naam;
    private String email;
    private String url;
    private String telefoon;
    private String paswoord;
    private String adres;
    private String bedrijfsactiviteit;
    private String bereikbaarheid;
    @ManyToOne
    private StageOpdracht stageOpdracht;

    public Bedrijf() {
    }

    public Bedrijf(int id) {
    }

    //constructor, aanmaken van een bedrijf
    public Bedrijf(int id, String naam, String email, String url, 
            String telefoon, String paswoord, String adres, 
            String bedrijfsactiviteit, String bereikbaarheid, 
            StageOpdracht stageOpdracht) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.url = url;
        this.telefoon = telefoon;
        this.paswoord = paswoord;
        this.adres = adres;
        this.bedrijfsactiviteit = bedrijfsactiviteit;
        this.bereikbaarheid = bereikbaarheid;
        this.stageOpdracht = stageOpdracht;
        
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

    // opvragen url
    public String getUrl() {
        return url;
    }

    // wijzigen url
    public void setUrl(String url) {
        this.url = url;
    }

    // opvragen telefoon
    public String getTelefoon() {
        return telefoon;
    }

    // wijzigen telefoon
    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    // opvragen wachtwoord
    public String getPaswoord() {
        return paswoord;
    }

    // wijzigen paswoord
    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    // opvragen adres
    public String getAdres() {
        return adres;
    }

    // wijzigen adres
    public void setAdres(String adres) {
        this.adres = adres;
    }

    // opvragen bedrijfsactiviteit
    public String getBedrijfsactiviteit() {
        return bedrijfsactiviteit;
    }

    // wijzigen bedrijfsactiviteit
    public void setBedrijfsactiviteit(String bedrijfsactiviteit) {
        this.bedrijfsactiviteit = bedrijfsactiviteit;
    }

    // opvragen bereikbaarheid 
    public String getBereikbaarheid() {
        return bereikbaarheid;
    }

    // wijzigen bereikbaarheid
    public void setBereikbaarheid(String bereikbaarheid) {
        this.bereikbaarheid = bereikbaarheid;
    }

    // opvragen stageopdracht
    public StageOpdracht getStageOpdracht() {
        return stageOpdracht;
    }

    // wijzigen stageopdracht
    public void setStageOpdracht(StageOpdracht stageOpdracht) {
        this.stageOpdracht = stageOpdracht;
    }
    
    //bedrijf verwijderen?
}
