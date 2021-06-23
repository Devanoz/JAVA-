/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pendaftaran;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author X
 */
public class FormPendaftaranController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfPassword;
    
    //handleAction
    @FXML
    public void buttonDaftar(ActionEvent event){
        //simpan ID dan Password ke xml
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
