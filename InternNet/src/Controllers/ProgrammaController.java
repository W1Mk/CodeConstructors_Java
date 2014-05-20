/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



import com.itextpdf.text.DocumentException;
import domein.AcademieJaar;
import domein.StageBegeleider;
import domein.StageOpdracht;
import domein.Student;
import internnet2.Mail;
import internnet2.Pdf;
import internnet2.PersistenceHulp;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author laurens
 */
public class ProgrammaController {
    @FXML
    private Button buttonBegeleiders;
    @FXML
    private Button buttongoedkeuren;
    @FXML
    private Button buttonafkeuren;
    @FXML
    private Pane PaneStageOpdrachten;
    @FXML
    private Pane PaneBegeleiders;
    @FXML
    private Pane PaneStudent;
    @FXML
    private Pane PaneStageContract;
    @FXML
    private TableView<StageOpdracht> tableStageOpdrachten;
    @FXML
    private TableColumn kolomnaam,kolomsemester,kolomomschrijving,kolomspecialisatie,kolomstagementor,kolomstatus;
    @FXML
    private TableView<StageOpdracht> tablebegeleider;
    @FXML
    private TableColumn kolombegeleidernaam,kolombegeleidersemester,kolombegeleideromschrijving,kolombegeleiderspecialisatie,kolombegeleiderstagementor,kolombegeleideraantalstudenten,kolombegeleiderstatus;
    @FXML
    private Label lblnaam,lblvoornaam,lblemail,lbladres,lbltelefoon,lblgsm;
    @FXML
    private Label lblStudentNaam,lblStudentAdres,lblStudentKeuzeVak,lblStudentEmail,lblStudentGsm,lblStudentTweedeEmail;
    @FXML
    private TextField txtBeginStage,txtEindeStage;
    @FXML
    private ListView<Student> ListViewStudent;
 private PersistenceHulp ph = new PersistenceHulp();
    
    private ObservableList<StageOpdracht> lijst = FXCollections.observableArrayList();
    private ObservableList<StageOpdracht> lijstopdrachtenPerBegeleider = FXCollections.observableArrayList();
    private ObservableList<Student> lijstGoedgekeurdeStages= FXCollections.observableArrayList();
    private ObservableList<Student> lijstStudent = FXCollections.observableArrayList();
    private ObservableList<Student> lijstPdfStudent = FXCollections.observableArrayList();
    private  Iterator<Student> studentIterator;
    private int i= 0,y;
   
   public ProgrammaController() {
  ph.start();
   }
   public void setTableView(){
      
       
       kolomnaam.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("naam"));
       kolomomschrijving.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("omschrijving"));
       kolomsemester.setCellValueFactory( new PropertyValueFactory<StageOpdracht, Integer>("semester"));
       kolomspecialisatie.setCellValueFactory(new PropertyValueFactory<StageOpdracht, String>("specialisatie"));
       kolomstagementor.setCellValueFactory(new PropertyValueFactory<StageOpdracht, String>("stageMentor"));
       kolomstatus.setCellValueFactory(new PropertyValueFactory<StageOpdracht, String>("status"));
         if(lijstopdrachtenPerBegeleider.isEmpty()){
         }
         else{
        kolombegeleidernaam.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("naam"));
         kolombegeleideromschrijving.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("omschrijving"));
          kolombegeleidersemester.setCellValueFactory( new PropertyValueFactory<StageOpdracht, Integer>("semester"));
           kolombegeleiderspecialisatie.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("specialisatie"));
            kolombegeleiderstagementor.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("stageMentor"));
             kolombegeleideraantalstudenten.setCellValueFactory( new PropertyValueFactory<StageOpdracht, Integer>("aantalStudenten"));
             kolombegeleiderstatus.setCellValueFactory( new PropertyValueFactory<StageOpdracht, String>("status2"));
             tablebegeleider.setItems(lijstopdrachtenPerBegeleider);
         }
           //ph.start();
           StageOpdracht stageopdracht = new StageOpdracht();
          
           lijst.clear();
           lijst.addAll(stageopdracht.StageOpdrachtList(ph.getEm()));
        
           tableStageOpdrachten.setItems(lijst);
           
           
         // ph.end();
      
   }
   @FXML
   public void ButtonBegeleider(){
       PaneStageOpdrachten.setVisible(false);
       PaneBegeleiders.setVisible(true);
       PaneStudent.setVisible(false);
       PaneStageContract.setVisible(false);
       buttongoedkeuren.setDisable(false);
       buttonafkeuren.setDisable(false);
       setStageOpdrachten();
       StageBegeleider stagebegeleider = new StageBegeleider();
       stagebegeleider =stagebegeleider.StageBegeleiderList(ph.getEm()).get(i);
       tablebegeleider.setItems(lijstopdrachtenPerBegeleider);
         lbladres.setText("adres: "+stagebegeleider.getAdres());
         lblnaam.setText("naam: " +stagebegeleider.getNaam());
         lblvoornaam.setText("voornaam: " +stagebegeleider.getVoornaam());
         lblemail.setText("email: " +stagebegeleider.getEmail());
         lbltelefoon.setText("telefoon: "+stagebegeleider.getTelefoon());
         lblgsm.setText("gsm: "+stagebegeleider.getGsm());
         setTableView();
         
         
         
         
   }
   public void setStageOpdrachten(){
       try{
       ph.start();
       lijstopdrachtenPerBegeleider.clear();
       StageBegeleider stagebegeleider = new StageBegeleider();
       stagebegeleider = stagebegeleider.StageBegeleiderList(ph.getEm()).get(i);
       lijstopdrachtenPerBegeleider.addAll(stagebegeleider.getStages());
       }
       catch(Exception ex){
           
       }
   }
   

   @FXML
   public void Buttonvolgende(){
       
       try{
           i+=1;
          
           ButtonBegeleider();
           
       }
          catch(Exception ex){
              i-=1;
             
          }
       
   }

      @FXML
   public void Buttonvorige(){
       try{
           i-=1;
           ButtonBegeleider();
       }    
       catch(Exception ex){
           i+=1;
       }
         
         
       
       
   }
   @FXML
   public void ButtonStageOpdrachten(){
       
       setTableView();
       PaneStudent.setVisible(false);
       PaneStageOpdrachten.setVisible(true);
       PaneBegeleiders.setVisible(false);
       PaneStageContract.setVisible(false);
       buttongoedkeuren.setDisable(false);
       buttonafkeuren.setDisable(false);
   }
   @FXML
   public void ButtonStudent(){
       PaneStudent.setVisible(true);
       PaneStageOpdrachten.setVisible(false);
       PaneBegeleiders.setVisible(false);
       PaneStageContract.setVisible(false);
       buttongoedkeuren.setDisable(true);
       buttonafkeuren.setDisable(true);
       Student student = new Student();
       lijstStudent.clear();
       lijstStudent.addAll(student.StudentList(ph.getEm()));
       student = lijstStudent.get(y);
       lblStudentAdres.setText("adres: "+student.getAdres());
       lblStudentEmail.setText("email: "+student.getEmail());
       lblStudentGsm.setText("gsm: "+student.getGsm());
       lblStudentKeuzeVak.setText("keuzevak: "+student.getKeuzeVak());
       lblStudentNaam.setText("naam: "+student.getNaam());
       lblStudentTweedeEmail.setText("tweede email: "+student.getTweedeEmail());
       DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
       String BeginStage= df.format(student.getBeginDatum());
       String EindeStage = df.format(student.getEindeDatum());
       txtBeginStage.setText(BeginStage);
       txtEindeStage.setText(EindeStage);
       
   }
  
   @FXML
   public void ButtonStudentVolgende(){
       
       try{
           
       
       y+=1;
       ButtonStudent();
       }
       catch(Exception ex){
           y-=1;
       }
               
       
   }
   @FXML
   public void ButtonStudentVorige(){
       if(y==0){
           
       }
       else{
        y-=1;
        ButtonStudent();
       }
       
   }
   @FXML
   public void ButtonOpslaan() throws ParseException{
       Student student = lijstStudent.get(y);
       Date BeginDatum = new SimpleDateFormat("yyyy/MM/dd").parse(txtBeginStage.getText());
       Date EindeDatum = new SimpleDateFormat("yyyy/MM/dd").parse(txtEindeStage.getText());
       student.setBeginDatum(BeginDatum);
       student.setEindeDatum(EindeDatum);
       ph.saveStudent(student);
       ph.end();
       ph.start();
   }
   @FXML
   public void ButtonStageContract(){
       PaneStudent.setVisible(false);
       PaneStageOpdrachten.setVisible(false);
       PaneBegeleiders.setVisible(false);
       PaneStageContract.setVisible(true);
       buttongoedkeuren.setDisable(true);
       buttonafkeuren.setDisable(true);
       lijstGoedgekeurdeStages.clear();
       Student student = new Student();
       lijstGoedgekeurdeStages.clear();
       lijstGoedgekeurdeStages.addAll(student.StudentList(ph.getEm()));  
       studentIterator = lijstGoedgekeurdeStages.iterator();
       while(studentIterator.hasNext()){
           if(studentIterator.next().getStages().isEmpty()){
              studentIterator.remove();
           }
          
       }
       Iterator<Student> it = studentIterator;
       while(it.hasNext())
       {
           lijstGoedgekeurdeStages.add(it.next());
       }
      setListView();
      
       
   }
   @FXML
   public void MenuAcademieJaar(){
       AcademieJaar ac = new AcademieJaar();
       String[] academiejaar = { "2013-2014", "2014-2015", "2015-2016", "2016-2017","2017-2018","2018-2019","2019-2020" };
       JFrame frame = new JFrame("academiejaar");
    String optie = (String) JOptionPane.showInputDialog(frame, 
        "Stel hier het academiejaar in",
        "academiejaar",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        academiejaar, 
        academiejaar[0]);
    if(optie ==null){
    
    }
    else{
   ac= ac.lijstAcademieJaar(ph.getEm()).iterator().next();
   ac.setActief(Boolean.FALSE);
           ph.saveAcademieJaar(ac);
           ph.end();
           ph.start();
     ac= ac.getAcademieJaarLijst(ph.getEm(), optie).iterator().next();
      ac.setActief(Boolean.TRUE);
      ph.saveAcademieJaar(ac);
      ph.end();
      ph.start();
    }
   }
   public void setListView(){

       ListViewStudent.setItems(lijstGoedgekeurdeStages);
       
       ListViewStudent.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
           
           @Override
           public ListCell<Student> call(ListView<Student> p) {
                ListCell<Student> cell = new ListCell<Student>(){
               private HBox hb = HBoxBuilder.create().spacing(15).build();
                   private CheckBox cb = new CheckBox();
                    
                    @Override
                    protected void updateItem(final Student t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            hb.getChildren().clear();
			    hb.getChildren().addAll(cb);
                            setText(t.getStageContract() +"   "+ t.getAdres() + "   " + t.getEmail() + "   "+ t.getGsm() + "   "+ t.getKeuzeVak() + "   "+t.getNaam());
                            setGraphic(hb);
                            cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
                                @Override
                                public void changed(ObservableValue<? extends Boolean> ov, Boolean t1, Boolean t2) {
                                    ListViewStudent.getSelectionModel().select(t);
                                   Student student= ListViewStudent.getSelectionModel().getSelectedItem();
                                                                     
                                   if(cb.isSelected()){
                                     lijstPdfStudent.add(student);  
                                   }
                                   else
                                   lijstPdfStudent.remove(student);
                                
                                }
                            });
                        }
                    }  
                    
       };
               
       return cell;
   }
               });
      
   }

   @FXML
   public void StageContractenMaken() throws DocumentException, IOException{
    studentIterator = lijstPdfStudent.iterator();
    Pdf pdf = new Pdf();
    int genereren=0;
    while(studentIterator.hasNext()){
        Student student = studentIterator.next();
        if("gemaakt".equals(student.getStageContract()))
    genereren=JOptionPane.showConfirmDialog(null, "De student: "+student.getNaam()+" heeft al een stagecontract. Wilt u het opniew genereren?", "stagecontract al gegenereerd",JOptionPane.YES_NO_OPTION);
        if(genereren == 0){
    pdf.createPdf(student.getNaam()+".pdf", student);
    student.setStageContract("gemaakt");
    ph.saveStudent(student);
    ph.end();
    ph.start();
    setListView();
        }
    }
}

  @FXML
   public void goedkeuren(){
      
      if (PaneBegeleiders.isVisible()){
           StageOpdracht stageopdracht =  tablebegeleider.getSelectionModel().getSelectedItem();
           stageopdracht.setStatus2("goedgekeurd");
           StageBegeleider stagebegeleider = new StageBegeleider();
           stagebegeleider = stagebegeleider.StageBegeleiderList(ph.getEm()).get(i);
                    stageopdracht.setStagebegeleider(stagebegeleider);
                   stagebegeleider.setStages(null);
                   
                   Iterator<Student> iterator = stageopdracht.getStudenten().iterator();
       while(iterator.hasNext()){
           Student student = iterator.next();
           student.setStageContract("geen");
           ph.saveStudent(student);
           ph.end();
           ph.start();
       }
        
          
           lijstopdrachtenPerBegeleider.remove(stageopdracht);
           stagebegeleider.setStages(lijstopdrachtenPerBegeleider);
           ph.saveBegeleider(stagebegeleider);
           ph.end();
           ph.start();
           ph.saveStageOpdracht(stageopdracht);
           ph.end();
           ph.start();
           setTableView();
            
      }
      else if(PaneStageOpdrachten.isVisible()){
 StageOpdracht stageopdracht =  tableStageOpdrachten.getSelectionModel().getSelectedItem();

stageopdracht.setStatus("goedgekeurd");
ph.saveStageOpdracht(stageopdracht);
ph.end();
ph.start();
setTableView();
Mail mail = new Mail();
mail.MailToBedrijf(stageopdracht.getBedrijf().getEmail(),stageopdracht);
      }
}
  @FXML
   public void afkeuren(){
      if (PaneBegeleiders.isVisible()){
          StageOpdracht stageopdracht =  tablebegeleider.getSelectionModel().getSelectedItem();
          stageopdracht.setStagebegeleider(null);
          StageBegeleider stagebegeleider = new StageBegeleider();
       stagebegeleider = stagebegeleider.StageBegeleiderList(ph.getEm()).get(i);
       
           lijstopdrachtenPerBegeleider.remove(stageopdracht);
       
       stagebegeleider.setStages(lijstopdrachtenPerBegeleider);
       ph.saveBegeleider(stagebegeleider);
       ph.end();
       ph.start();
           ph.saveStageOpdracht(stageopdracht);
           ph.end();
           ph.start();
            setTableView();
      }
       else if(PaneStageOpdrachten.isVisible()) { 
      
 StageOpdracht stageopdracht =  tableStageOpdrachten.getSelectionModel().getSelectedItem();
 stageopdracht.getBedrijf().getBedrijfsnaam();
 stageopdracht.setStatus("afgekeurd");
 ph.saveStageOpdracht(stageopdracht);
 ph.end();
 ph.start();
 setTableView();
 String reden = (String)JOptionPane.showInputDialog("Reden van afkeuring:");
                    
 Mail mail = new Mail();
 mail.MailToBedrijfAfgekeurd(stageopdracht.getBedrijf().getEmail(),reden,stageopdracht);
       }
}
 }
