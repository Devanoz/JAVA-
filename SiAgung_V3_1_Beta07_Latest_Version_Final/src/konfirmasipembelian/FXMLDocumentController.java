/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfirmasipembelian;

import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.LinkedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Pengguna;



public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button6;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private ImageView Logo1;
    @FXML
    private ImageView Logo11;
    
    void random(){
        Random dice = new Random ();
        int number;
        
        for (int counter=1; counter<=10;counter++);
        number = 10000+dice.nextInt(100000);
        
        String hasil = TF3.getText();
        isi4.setText(number + " ");
    }
    
    LinkedList<Data>DA = new LinkedList();//menyimpan data konfirmasi pembelian
    //LinkedList<Pengguna> dataLogin=getLoginData();
    
    XStream xstream = new XStream (new StaxDriver());
    
    
    
    
    //Xml method============================================================================
    void bukaXML(){
    FileInputStream mencobi = null;
      try {

          mencobi = new FileInputStream("dataConfirm.xml");
          
          int isi;
          char charnya;
          String stringnya;
          
          stringnya ="";
          while ((isi = mencobi.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        
        DA = (LinkedList<Data>) xstream.fromXML(stringnya);	  
      }
      catch (Exception e){
          System.err.println("test: "+e.getMessage());
      }
      finally{
        if(mencobi != null){
            try{
                mencobi.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }      
      }
    }
    
    void simpanDA(){
        String xml = xstream.toXML(DA);

        FileOutputStream mencoba = null;
        try {
            
            mencoba = new FileOutputStream("dataConfirm.xml");

            byte[] bytes = xml.getBytes("UTF-8");

            
            mencoba.write(bytes);
        } 
    catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } 
    finally {
            if (mencoba != null) {
                try {
                    mencoba.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    LinkedList<Pengguna> getLoginData(){
       
        
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
    //xml method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    @FXML
    private Label isi5;
    private Label isi;
    @FXML
    private ChoiceBox CB;
    @FXML
    private ChoiceBox CB2;
    private Label isi2;
    @FXML
    private TextField TF3;
    private Label isi3;
    @FXML
    private Button button4;
    @FXML
    private Label isi4;
   
    
    
    
    private void HBA(ActionEvent event) {
        isi.setText(CB.getValue().toString());
    }
    private void HBA2(ActionEvent event) {
        isi2.setText(CB2.getValue().toString());
    }
     @FXML
    private void HBA3(ActionEvent event) {
        String hasil = TF3.getText();
        isi3.setText(hasil);
    }
    
    
    @FXML
    private void HBA4(ActionEvent event) {
        Random dice = new Random ();
        int number;
        
        for (int counter=1; counter<=10;counter++);
        number = 1000000+dice.nextInt(9999999);
        
        String hasil = TF3.getText();
        isi4.setText(number + " ");
    }
    @FXML
    private void HBBayar(ActionEvent event) throws IOException {
        LinkedList<Pengguna> dataLogin=getLoginData();
        isi5.setText("Data telah tersimpan");
        
        int temp=0;
        boolean adaPenggunaOnline=false;
        for (int i = 0; i <dataLogin.size(); i++) {
            if ((dataLogin.get(i).getStatusOnline()) ) {
                adaPenggunaOnline=true;
                temp=i;
                break;
            }
        }
        
        if (adaPenggunaOnline) {
            DA.add(new Data(CB.getValue().toString(),CB2.getValue().toString(), TF3.getText(),isi4.toString(),dataLogin.get(temp).getNama()));
            simpanDA();
        
            AnchorPane pane = FXMLLoader.load(getClass().getResource("melakukanbayar.fxml"));
            anchorpane.getChildren().setAll(pane);
        }
        
        
        
    
        
//    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
      CB.getItems().addAll("JNE", "SICEPAT" , "JNT");
      CB2.getItems().addAll("ALFAMART", "INDOMARET", "BRI" , "MANDIRI");
      bukaXML();
      
      
    }  

    
      }
    

    

    

   

    
    

