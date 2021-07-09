/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import views.KeranjangController;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Barang;
import model.ItemKeranjang;
import java.io.FileInputStream;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Keranjang;

/**
 *
 * @author LENOVO
 */
public class PageDescriptionController implements Initializable {
    Keranjang keranjang = new Keranjang();
        
    @FXML
    private AnchorPane anchorPD;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Label labelHarga;
    
    @FXML
    private Label labelNama;
    
    @FXML
    private Label labelQty;
    
    @FXML
    private Label labelDesc;
    
    @FXML
    private Button buttonAdd;
    
    @FXML
    private Button buttonMin;
    
    @FXML
    private Button keranjangBtn;
    
    @FXML
    private ImageView imgBarang;
   
    
    @FXML
    private TextField tfQty;
   
    Barang a = new Barang();
    
    int tmp;
    
    int mx;
    

    @FXML
    private void handleBeliBtn(ActionEvent e){
    
    }
    
    @FXML
    private void handleAddBtn(ActionEvent event) {
        if(tmp<mx){
        tmp++;
        tfQty.setText(Integer.toString(tmp));
        }
    }
    @FXML
    private void handleMinBtn(ActionEvent event) {
        if (tmp>1){
            tmp--;
            tfQty.setText(Integer.toString(tmp));
        }
    }
    
    @FXML
    private void handleButtonKeranjang(ActionEvent event) throws Exception {
        saveXML(a);
//Multi Stage

//        FXMLLoader loader = new FXMLLoader(KeranjangController.class.getResource("Keranjang.fxml"));
//        AnchorPane pageKeranjang = (AnchorPane) loader.load();
//        Scene scene = new Scene(pageKeranjang);
//        dialogStage.setTitle("Keranjang");
//        dialogStage.initModality(Modality.APPLICATION_MODAL);
//        Scene scene = new Scene(loader.load());
//        dialogStage.setScene(scene);
//        dialogStage.showAndWait();

// Multi Scene

//        Parent root =FXMLLoader.load(getClass().getResource("Keranjang.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Keranjang");
//        stage.show();

//Border Pane
    FXMLLoader loader = new FXMLLoader();
    Pane pane= FXMLLoader.load(KeranjangController.class.getResource("Keranjang.fxml"));
    borderPane.setCenter(pane);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        a.setName("Sepatu Gunung");
//        a.setPrice("50000");
//        a.setQty(10);
//        a.setImgSrc("/image/snta_snta-sepatu-gunung-pria--snta-498-_full18.jpg");
//        a.setDeskripsi("simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
//        
//        labelNama.setText(a.getName());
//        labelHarga.setText("Rp. "+(a.getPrice()));
//        labelQty.setText(Integer.toString(a.getQty()));
//        labelDesc.setText(a.getDeskripsi());
//        Image image;
//        image = new Image(getClass().getResourceAsStream(a.getImgSrc()));
//        imgBarang.setImage(image);
//          display(a);
          loadKeranjang();
    }    
    
    public void saveXML(Barang b){
        XStream xstream = new XStream(new StaxDriver());
//        HashMap<Barang, Integer> cart = new HashMap<Barang,Integer>();
//        cart.put(b,tmp);
        System.out.println(keranjang.sizeKeranjang());
        ItemKeranjang cart = new ItemKeranjang(b, tmp);
        keranjang.addBarang(cart);
        String xml = xstream.toXML(keranjang);
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataKeranjang.xml");
 
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
    private void loadKeranjang(){
      XStream xstream = new XStream(new StaxDriver());
      FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataKeranjang.xml"); // ganti file
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
//        myList = (double[]) xstream.fromXML(stringnya);	  
//        k.addBarang((HashMap<Barang,Integer>) xstream.fromXML(stringnya));
//         HashMap<Barang,Integer> tmp = (HashMap<Barang,Integer>) xstream.fromXML(stringnya);
//          Barang barang;
          keranjang = (Keranjang) xstream.fromXML(stringnya);
//          k.addBarang(ik);
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
     
    public void display(Barang barang){
        a=barang;
        labelNama.setText(barang.getName());
        labelHarga.setText("Rp. "+(barang.getPrice()));
//                barang.setQty(10);
        mx=barang.getQty();
        labelQty.setText(Integer.toString(barang.getQty()));
//        barang.setDeskripsi("ABC");
        labelDesc.setText(barang.getDeskripsi());
        Image image;
        if(barang.getOri()){
                image = new Image(getClass().getResourceAsStream(barang.getImgSrc()));
            }else{
                image = new Image(barang.getImgSrc());
            }
        imgBarang.setImage(image);
    }
    
    }
