/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import domein.Bedrijf;
import domein.StageOpdracht;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Wim
 */
public class BedrijfController 
{
    @FXML
    private TextField naamTF;
    private TextField emailTF;
    private TextField urlTF;
    private TextField telefoonTF;
    private TextField paswoordTF;
    private TextField adresTF;
    private TextField bedrijfsactiviteitTF;
    private TextField bereikbaarheidTF;
    
    private Bedrijf bedrijf;
    
    // login/register bedrijf
    // 2 buttons op een scherm (fxml)
    // neemt u naar bedrijf manager of bedrijf registratie scherm
    
    // bedrijfregistratie scherm
    // achter registratie, krijgt u bevestiging en het manager scherm
    
    // toon bedrijf, bedrijf "manager" scherm (bedrijfFXML)
    // later als er al stage ... bestaat
    // dit scherm heeft ook een knop verwijderen, die bevestiging vraagt en daarna
    // zelf verwijdering bevestigd en u naa login scherm brengt
    // hiermee kan u ook met een knop wijziging naar wijzig scherm
    
    // wijziging scherm 
    // als u wijziging annuleert terug naar manager scherm
    // als u wijzigingen doorvoert, bevistiging geven en dan ook naar manager scherm
}
