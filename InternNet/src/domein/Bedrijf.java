/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table (name="Bedrijf")

public class Bedrijf implements Serializable {
    @Id
    private int BedrijfId;
    private String Bedrijfsnaam;
    private String Email;
    private String Telefoon;
    private String Adres;
    private String Url;
    private String Wachtwoord;
    private String BedrijfsActiviteit;
    private String Bereikbaarheid;

    public Bedrijf() {
    }

    public Bedrijf(int BedrijfId, String Bedrijfsnaam, String Email, String Telefoon, String Adres, String Url, String Wachtwoord, String BedrijfsActiviteit, String Bereikbaarheid) {
        this.BedrijfId = BedrijfId;
        this.Bedrijfsnaam = Bedrijfsnaam;
        this.Email = Email;
        this.Telefoon = Telefoon;
        this.Adres = Adres;
        this.Url = Url;
        this.Wachtwoord = Wachtwoord;
        this.BedrijfsActiviteit = BedrijfsActiviteit;
        this.Bereikbaarheid = Bereikbaarheid;
    }

    public int getBedrijfId() {
        return BedrijfId;
    }

    public String getBedrijfsnaam() {
        return Bedrijfsnaam;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefoon() {
        return Telefoon;
    }

    public String getAdres() {
        return Adres;
    }

    public String getUrl() {
        return Url;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public String getBedrijfsActiviteit() {
        return BedrijfsActiviteit;
    }

    public String getBereikbaarheid() {
        return Bereikbaarheid;
    }

    public void setBedrijfId(int BedrijfId) {
        this.BedrijfId = BedrijfId;
    }

    public void setBedrijfsnaam(String Bedrijfsnaam) {
        this.Bedrijfsnaam = Bedrijfsnaam;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTelefoon(String Telefoon) {
        this.Telefoon = Telefoon;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public void setWachtwoord(String Wachtwoord) {
        this.Wachtwoord = Wachtwoord;
    }

    public void setBedrijfsActiviteit(String BedrijfsActiviteit) {
        this.BedrijfsActiviteit = BedrijfsActiviteit;
    }

    public void setBereikbaarheid(String Bereikbaarheid) {
        this.Bereikbaarheid = Bereikbaarheid;
    }
    
    
    
}
