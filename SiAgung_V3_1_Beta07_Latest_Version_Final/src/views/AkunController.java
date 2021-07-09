/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Pengguna;




/**
 * FXML Controller class
 *
 * @author X
 */
public class AkunController implements Initializable {
    XStream xstream= new XStream(new StaxDriver());
    /**
     * Initializes the controller class.
     */
    
    LinkedList<Pengguna> LoginDataContainer=bukaXml();
    
    String nama,ID,password;
    
    void setPenggunaOnline(){
        boolean adaPenggunaOnline=false;
        int indeks=0;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if (LoginDataContainer.get(i).getStatusOnline()) {
               adaPenggunaOnline=true;
               indeks=i;
               break;
 
            }
        }
        if (adaPenggunaOnline) {
            nama=LoginDataContainer.get(indeks).getNama();
            ID=LoginDataContainer.get(indeks).getID();
            password=LoginDataContainer.get(indeks).getPassword();
            
        }
    }
    
    
   
    
    LinkedList<Pengguna> bukaXml(){
        FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataLogin.xml");
          // harus diingat objek apa yang dahulu disimpan di file 
          // program untuk membaca harus sinkron dengan program
          // yang dahulu digunakan untuk menyimpannya
          int isi;
          char charnya;
          String stringnya;
          // isi file dikembalikan menjadi string
          stringnya ="";
          while ((isi = cobi.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        // string isi file dikembalikan menjadi larik double
        return (LinkedList<Pengguna>) xstream.fromXML(stringnya);	  
      }
      catch (Exception e){
          System.err.println("test: "+e.getMessage());
      }
      finally{
        if(cobi != null){
            try{
                cobi.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }      
      } 
        return null;
    }
    
    
    //method simpan xml
    void simpanXml(LinkedList<Pengguna> data){
        String xml = xstream.toXML(data);
 
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataLogin.xml");
 
            // mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] bytes = xml.getBytes("UTF-8");
 
            // menyimpan file dari bytes
            coba.write(bytes);
        } 
        catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } 
        finally {
            if (coba != null) {
                try {
                    coba.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
    }
   
    // set disable logout Button
    void controlLogoutButton(){
        boolean adaPenggunaOnline=false;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if (LoginDataContainer.get(i).getStatusOnline()) {
                adaPenggunaOnline=true;
                break;
            }
        }
        
        if (!adaPenggunaOnline) {
            logoutButton.setDisable(true);
        }
    }
    //mehtod untuk enable/disable login button sesuai kondisi
    void controlLoginButton(){
        boolean adaPenggunaOnline=false;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if (LoginDataContainer.get(i).getStatusOnline()) {
                adaPenggunaOnline=true;
                break;
            }
        }
        if (!adaPenggunaOnline) {
            loginButton.setDisable(false);
        }
    }
    
   
     @FXML
    private Label labelNama;

    @FXML
    private Label labelID;

    @FXML
    private Label labelPassword;
    @FXML
    private Button loginButton;

    @FXML
    private Button logoutButton;

     
     
    @FXML
    private Image gambar;
    @FXML
    private ImageView logoProfile;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    
    private void displayImage(){
         gambar=new Image(getClass().getResourceAsStream("/image/Profile.png"));
         logoProfile.setImage(gambar);
    }
    
    @FXML
    private void buttonLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(LoginViewController.class.getResource("LoginView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
    @FXML
    private void buttonLogout(ActionEvent event) throws IOException{
        boolean adaPenggunaOnline=true;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if (LoginDataContainer.get(i).getStatusOnline()) {
                LoginDataContainer.get(i).setStatusOnline(false);
               
                adaPenggunaOnline=false;
                break;
            }
        }
        //close stage
        
        simpanXml(LoginDataContainer);//menyimpan data kembali ke Xml
        
        Stage primaryStage = (Stage) logoutButton.getScene().getWindow();
        primaryStage.close();

        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayImage();
        bukaXml();
        setPenggunaOnline();
        labelNama.setText(nama);
        labelID.setText(ID);
        labelPassword.setText(password);
        
        controlLogoutButton();
        controlLoginButton();
     
        
        
        
       
    }    
    
}
