/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfirmasipembelian;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pengiriman.TampilanAwalController;

/**
 * FXML Controller class
 *
 * @author 62895
 */
public class bayarcontroller implements Initializable {

    @FXML
    private Button tutup;
    @FXML
    private Button toko;
    @FXML
    private ImageView Logo1;
    @FXML
    private Button buttonLanjut;
   
    //for multiScene
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HBTutupStage2(ActionEvent event) {
        Stage primaryStage = (Stage) tutup.getScene().getWindow();
        primaryStage.close();
    }

    @FXML
    private void HBkembalikeToko(ActionEvent event) {
        
    }
    @FXML
    private void buttonLanjut(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader(TampilanAwalController.class.getResource("TampilanAwal.fxml"));
        root = loader.load();	
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
