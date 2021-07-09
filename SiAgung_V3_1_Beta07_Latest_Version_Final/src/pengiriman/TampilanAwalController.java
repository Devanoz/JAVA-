/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengiriman;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 20523015
 */
// next berhasil
// RESI gagal
public class TampilanAwalController implements Initializable {

    @FXML
    private Button bNext;
    @FXML
    private Button bNoResi;
    @FXML
    private Button bLogout;
 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonNext(ActionEvent event) throws Exception{ 
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLDocumentController.class.getResource("FXMLDocument.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("No Resi");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
    }

    @FXML
    private void handleButtonNoResi(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLDocumentController_1.class.getResource("FXMLDocument_1.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Resi");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
    }   

    @FXML
    private void handleButtonLogout(ActionEvent event) {
        Stage primaryStage = (Stage) bLogout.getScene().getWindow();
        primaryStage.close();
    }
    }

    
 
