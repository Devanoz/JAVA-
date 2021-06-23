/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplestagescene;

import Login.lamanPembeliController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author X
 */
public class mainController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private MenuBar menuBarUtama;
    @FXML
    private Menu menuLogin;
    @FXML 
    private Menu menuDaftar;
    @FXML
    private BorderPane lamanUtama;
    @FXML 
    private Button buttonLogin;
    @FXML
    private Button buttonDaftar;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene sceneSwitch;
        
    
    @FXML
    private void handleButtonLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(lamanPembeliController.class.getResource("lamanPembeli.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Login");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
    }
    @FXML
    private void handleButtonDaftar(ActionEvent event) throws IOException{
        Pane pane= FXMLLoader.load(getClass().getResource("FormPendaftaran.fxml"));
        lamanUtama.setCenter(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    
    
}
