/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengiriman;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import konfirmasipembelian.Data;
import model.Pengguna;
/**
 *
 * @author 20523015
 */
//resi gagal
public class FXMLDocumentController_1 implements Initializable {
    XStream xstream = new XStream(new StaxDriver());//
    
    int temp;
    LinkedList<Data> DA=getDataConfirm();//getting data from dataconfirm(Konfirmasi pembelian)
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView tableview;
    @FXML private TableColumn No;
    @FXML private TableColumn Nama;
    @FXML private TableColumn Alamat;
    @FXML private TableColumn Kurir;
    @FXML private TableColumn Resi;
    @FXML
    private Button buttonSimpan;
   
                  
    //observalble list to store data
   ObservableList dataList = observableArrayList();      
   LinkedList<Pengguna> LoginDataContainer=bukaXml();//getting data from LoginDataContainer(FormPendaftaranController)
   
   //xml method===================================================================================================
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
    //buttonHandler===================================================================================
    @FXML
     private void buttonSimpan(ActionEvent event){
         simpanObs();
     }
     @FXML
     private void buttonCari(ActionEvent event){
         TableView.TableViewSelectionModel selectionModel=tableview.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
         
         String searchData=filterField.getText();
         int temp=0;
         
         /*for (int i = 0; i <dataList.size(); i++) {
             if(searchData.equals(DA.get(i).getNama())){
                 temp=i;
             }
         }*/
     }
    //buttonHandler>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //simpan buka observable list
    
   //xml method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    void bukaObs(){
    FileInputStream xx = null;
      try {
          xx = new FileInputStream("dataObs2.xml");//data obs2=data from pengiriman(observablelist)
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
        dataList=(ObservableList) xstream.fromXML(stringnya);	  
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
    
    void simpanObs(){
        String xml = xstream.toXML(dataList);
        FileOutputStream xx = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            xx = new FileOutputStream("dataObs2.xml");
            
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
    //xml from 
    //ordinary method========================================================================================
    void DAtoTableView(){
        

        for (int i = 0; i <DA.size(); i++) {
            dataList.add(DA.get(i));
  
            
            
        }
    }
    
    
    
    //ordinary method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //dataList.clear();
        //DA.clear();
        
        
        bukaObs();
        
        DAtoTableView();
        
        //String kurir ;
        //String pembayaran ;
        //String alamat ;
        //String kode  ;
        //String resi;                    
        //No.setCellValueFactory(new PropertyValueFactory<Data,String>(""));       
        //Nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        Nama.setCellValueFactory(new PropertyValueFactory<Pengguna, String>("nama"));
        Alamat.setCellValueFactory(new PropertyValueFactory<Data, String>("alamat"));        
        Kurir.setCellValueFactory(new PropertyValueFactory<Data,String>("kurir"));        
        Resi.setCellValueFactory(new PropertyValueFactory<Data,String >("resi"));            
        
        
                    
        tableview.setItems(dataList);
    }    
    
}