/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Barang;
import model.Pengguna;

/**
 * FXML Controller class
 *
 * @author X
 */
public class AdminController implements Initializable {
    //===================================================================================================
     XStream xstream= new XStream(new StaxDriver());
     ArrayList<Barang> dataBaru=new ArrayList<>();//mengambil data fruits dari xml
     
     
     
     ObservableList data=observableArrayList();
     
    //=======================================================================================================
     
     

    /**
     * Initializes the controller class.
     */
    
     //xml=========================================================================================
    public  void bukaDataBaru(){
        
         FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataBaru.xml");
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
        dataBaru =(ArrayList<Barang>) xstream.fromXML(stringnya);	  
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
    }
    
    public void simpanDataBaru(){
        String xml = xstream.toXML(dataBaru);
 
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataBaru.xml");
 
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
    
    //Simpan Obesrvable list ke xml ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    void simpanObservableList(){
        String xml = xstream.toXML(data);
 
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataObs.xml");
 
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
    //buka ObservableList ke XML~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    void bukaObservableList(){
        
         FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataObs.xml");
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
        data= (ObservableList) xstream.fromXML(stringnya);	  
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
        
    }
    
    
    //xml =======================================================================================================
    
    //method======================================================================================================
    void displayImage(){
        Image image=new Image(getClass().getResourceAsStream("/image/logoAdmin.png"));
        logoAdmin.setImage(image);
    }
    //method=======================================================================================================>
     
    //declare atribut==============================================================================================
    @FXML
    private AnchorPane anchorId;
    
    @FXML
    private ImageView logoAdmin;
    @FXML
    private TableColumn tcNama;
    @FXML
    private TableColumn tcHarga;
    @FXML
    private TableColumn tcDeskripsi;
    @FXML
    private TableView tableView;
    
    
    //textfield dan text Area
      @FXML
    private TextField tfNama;

      @FXML
      private Button btnImg;
      
    @FXML
    private TextField tfHarga;

    @FXML
    private TextArea tfDeskripsi;
    //declare atribut==============================================================================================
    
    
    //buttonHandler=================================================================================================
    
    @FXML
    private void handleButtonImg(ActionEvent event){
        final FileChooser fc = new FileChooser();
        Stage stage = (Stage) anchorId.getScene().getWindow();
        File file= fc.showOpenDialog(stage);
        if(file!=null){
            System.out.println("Dir: "+file.getAbsolutePath() );
            btnImg.setText(file.toURI().toString());
//            Image image ;
//            image = new Image(file.toURI().toString());
        }
    }
    
    
    @FXML
    private void buttonTambah(ActionEvent event){
        String nama=tfNama.getText();
        String harga=tfHarga.getText();
        String deskripsi=tfDeskripsi.getText();
        String imgSrc= btnImg.getText();
        
        Barang barang = new Barang();
        barang.setName(nama);
        barang.setPrice(harga);
        barang.setImgSrc(imgSrc);
        barang.setDeskripsi(deskripsi);
        barang.setOri(false);
        
        data.add(barang);
        dataBaru.add(barang);
        
        TableViewSelectionModel selectionModel=tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int dataSize= data.size();
        selectionModel.select(dataSize-1);
        
        
        tfNama.setText("");
        tfHarga.setText("");
        tfDeskripsi.setText("");
        simpanDataBaru();
        simpanObservableList();
    }
    
    @FXML
    private void buttonHapus(ActionEvent event){
        TableViewSelectionModel selectionModel=tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
        if(i>=0){
            data.remove(i);
            dataBaru.remove(i);
        
            simpanDataBaru();
            simpanObservableList();
        }
        
        
        
        
    }
    @FXML
    private void buttonEdit(ActionEvent event){
        TableViewSelectionModel selectionModel=tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
        
        
        
        tfNama.setText("");
        tfHarga.setText("");
        tfDeskripsi.setText("");
        
    }
    
    //buttonHandler<<<<<==================================================================================================
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //declare method
        displayImage();
        bukaDataBaru();
        bukaObservableList();
 
        
        //for tableView
                
         tableView.setItems(data);
        
        tcNama.setCellValueFactory(new PropertyValueFactory<Barang,String>("name"));
        tcHarga.setCellValueFactory(new PropertyValueFactory<Barang,String>("price"));
        tcDeskripsi.setCellValueFactory(new PropertyValueFactory<Barang,String>("deskripsi"));
        
        //selection model
        
       
        
        
        
    }    

    
    
}
