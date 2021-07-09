/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengiriman;

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
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import konfirmasipembelian.Data;



public class FXMLDocumentController implements Initializable {
    
    XStream xstream = new XStream(new StaxDriver());
    ArrayList<Data>data = new ArrayList<>();
    
    LinkedList<Data>DA =getDataConfirm();//getting data from(konfirmasi pembelian)
    
    String resi;//untuk menyimpan String dari resi;
    
    //random method=====================================
    void random(){
        Random dice = new Random ();
        int number;
        
        for (int counter=1; counter<=10;counter++);
        number = 10000+dice.nextInt(100000);
        
        String hasil = TF3.getText();
        isi4.setText(number + " ");
    }
    
    //random method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    
    //xml method========================================================
    void bukaXoxo(){
    FileInputStream xx = null;
      try {
          xx = new FileInputStream("xoxo.xml");
          // harus diingat objek apa yang dahulu disimpan di file 
          // program untuk membaca harus sinkron dengan program
          // yang dahulu digunakan untuk menyimpannya
          int isi;
          char charnya;
          String stringnya;
          // isi file dikembalikan menjadi string
          stringnya ="";
          while ((isi = xx.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        // string isi file dikembalikan menjadi larik double
        resi = (String) xstream.fromXML(stringnya);	  
      }
      catch (Exception e){
          System.err.println("test: "+e.getMessage());
      }
      finally{
        if(xx != null){
            try{
                xx.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }      
      } 
        
    }
    
    //get xml from dataConfrim(konfirmasi pembelian)
    LinkedList<Data> getDataConfirm(){
    FileInputStream xx = null;
      try {
          xx = new FileInputStream("dataConfirm.xml");
          // harus diingat objek apa yang dahulu disimpan di file 
          // program untuk membaca harus sinkron dengan program
          // yang dahulu digunakan untuk menyimpannya
          int isi;
          char charnya;
          String stringnya;
          // isi file dikembalikan menjadi string
          stringnya ="";
          while ((isi = xx.read()) != -1) {
              charnya= (char) isi;
              stringnya = stringnya + charnya;
          }    
        // string isi file dikembalikan menjadi larik double
        return (LinkedList<Data>) xstream.fromXML(stringnya);	  
      }
      catch (Exception e){
          System.err.println("test: "+e.getMessage());
      }
      finally{
        if(xx != null){
            try{
                xx.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }      
      } 
        return null;
        
    }
    
    void simpanDA(){
        String xml = xstream.toXML(DA);
        FileOutputStream xx = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            xx = new FileOutputStream("dataConfirm.xml");
            
            // mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] bytes = xml.getBytes("UTF-8");
            // menyimpan file dari bytes
            xx.write(bytes);
        } 
            catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } 
            finally {
            if (xx != null) {
                try {
                    xx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
    }

    //xml method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @FXML
    private TextField TF3;
    @FXML
    private Button button4;
    @FXML
    private Label isi4;
    @FXML
    private Button button5;
    @FXML
    private Label isi5;
   
    
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
    private void HBSimpan(ActionEvent event) {
        // larik double diubah menjadi string dengan format XML
        String xml = xstream.toXML(resi);
        FileOutputStream xx = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            xx = new FileOutputStream("xoxo.xml");
            
            // mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] bytes = xml.getBytes("UTF-8");
            // menyimpan file dari bytes
            xx.write(bytes);
        } 
            catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } 
            finally {
            if (xx != null) {
                try {
                    xx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

      bukaXoxo();
      
      
    }  

    

    
      }
    























































//        isi5.setText("Data telah tersimpan");
//        
//        
//        DA.add(new Data(TF3kurir.getText(), TF3pembayaran.getText(), TF3alamat.getText(), TF3kode.getText()));
//        
//        
//        String xml = xstream.toXML(DA);
//
//        FileOutputStream mencoba = null;
//        try {
//            
//            mencoba = new FileOutputStream("simpan.xml");
//
//            byte[] bytes = xml.getBytes("UTF-8");
//
//            
//            mencoba.write(bytes);
//        } 
//    catch (Exception e) {
//            System.err.println("Perhatian: " + e.getMessage());
//        } 
//    finally {
//            if (mencoba != null) {
//                try {
//                    mencoba.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    

    

   

    
    

