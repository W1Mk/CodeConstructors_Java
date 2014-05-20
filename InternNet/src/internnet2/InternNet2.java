/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internnet2;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author laurens
 */
public class InternNet2 extends Application {
 
   @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/programma.fxml"));
       loader.load();
       AnchorPane root = loader.getRoot();
       
       PersistenceHulp ph = new PersistenceHulp();
       ph.start();
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
