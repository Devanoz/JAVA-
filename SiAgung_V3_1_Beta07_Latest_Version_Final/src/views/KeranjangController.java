/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Barang;
import model.ItemKeranjang;
import model.Keranjang;
import java.io.FileOutputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import konfirmasipembelian.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class KeranjangController implements Initializable {
     XStream xstream = new XStream(new StaxDriver());
     
    int total;

    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private HBox container;
    
    @FXML
    private HBox qtyHbx;
   
    @FXML
    private Label totalLabel;
    
    @FXML
    private VBox vbxMain;
    
    //for multiScene
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    
    @FXML
    private void handleOrderBtn(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLDocumentController.class.getResource("FXMLDocument.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Akun");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
        
        
        String xml = xstream.toXML(fruits);
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataOrder.xml");
 
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

//    private List<Barang> fruits = new ArrayList<>();
    private Keranjang fruits =new Keranjang();
    
    private Keranjang getData(){
        loadKeranjang();
        return fruits;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fruits = getData();
        generateNewHbx();
    }    
    
    public void generateNewHbx(){
        for(int i =0;i<fruits.sizeKeranjang();i++){
            ItemKeranjang tmp = fruits.getBarang(i);
            Barang b = tmp.getBarang();
            int idx= i;
        //Buat HBox
            container = new HBox(i+1);

            container.getStyleClass().add("container");
            
        // Button remove
            Button btnRemove = new Button("x");
            btnRemove.getStyleClass().add("btnRemove");
            
        // Image View    
            Image image ;
//            File file = new File(b.getImgSrc());
            ImageView imgView = new ImageView();
            imgView.setFitWidth(70);
            imgView.setFitHeight(50);
            if(b.getOri()){
                image = new Image(getClass().getResourceAsStream(b.getImgSrc()));
            }else{
                image = new Image(b.getImgSrc());
            }
            imgView.setImage(image);
            
            // Hbox Quantity
            qtyHbx = new HBox(i+1);
            qtyHbx.getStyleClass().add("qtyHbox");
            
        // Button di HBox Quantity
        
            Button btnMin = new Button("-");
            Button btnPlus = new Button("+");
            TextField tfQty = new TextField(Integer.toString(tmp.getJumlah()));
            
            btnPlus.setFont(Font.font(11));
            btnMin.setId("btnMin"+i);
            btnPlus.setId("btnPlus"+i);
            btnPlus.getStyleClass().add("button");
            btnMin.getStyleClass().add("button");
            
            tfQty.setId("tfQty"+i);
            tfQty.setEditable(false);
            
        // Label Total HBox
            Label labelT = new Label();
            labelT.setPrefWidth(70);
            labelT.setText("Rp. "+ Integer.toString(tmp.getJumlah()*Integer.parseInt(b.getPrice())));
            

            // Hbox Quantity Button OnClick
            btnMin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(tmp.getJumlah()!=0){
                        tmp.setJumlah(tmp.getJumlah()-1);
                        tfQty.setText(Integer.toString(tmp.getJumlah()));
                        labelT.setText("Rp. "+ Integer.toString(tmp.getJumlah()*Integer.parseInt(b.getPrice())));   
                        total-=Integer.parseInt(b.getPrice());
                        totalLabel.setText("Rp. "+Integer.toString(total));
                        fruits.setTotal(total);
                    }
                    
                }
            });
            
            btnPlus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tmp.setJumlah(tmp.getJumlah()+1);
                    tfQty.setText(Integer.toString(tmp.getJumlah()));
                    labelT.setText("Rp. "+ Integer.toString(tmp.getJumlah()*Integer.parseInt(b.getPrice())));
                    total+=Integer.parseInt(b.getPrice());
                    totalLabel.setText("Rp. "+Integer.toString(total));
                    fruits.setTotal(total);
                    System.out.println(fruits.getTotal());
                }
            });
            
            btnRemove.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (fruits.sizeKeranjang()>1){
                        try{
                            fruits.removeBarang(tmp);
                            total-=tmp.getJumlah()*Integer.parseInt(b.getPrice());
                            totalLabel.setText(Integer.toString(total));
                            vbxMain.getChildren().remove(idx);
                            fruits.setTotal(total);
                            saveKeranjang();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                    // todo: remove dari xml
                }
            });
            
            // HBox Inserting
            
            qtyHbx.getChildren().add(btnMin);
            qtyHbx.getChildren().add(tfQty);
            qtyHbx.getChildren().add(btnPlus);
            
            // Label Nama item + Harga Item
            Label labelNama = new Label(b.getName());
            labelNama.setWrapText(true);
            labelNama.setPrefWidth(105);
            
            // Label Harga
            Label labelHarga = new Label("Rp. "+Integer.toString(Integer.parseInt(b.getPrice())));
            labelHarga.setPrefWidth(70);
            
            // Inserting
            total +=Integer.valueOf(labelT.getText().substring(4)); 
            container.getChildren().add(btnRemove);
            container.getChildren().add(imgView);
            container.getChildren().add(labelNama);
            container.getChildren().add(qtyHbx);
            container.getChildren().add(labelHarga);
            container.getChildren().add(labelT);
            vbxMain.getChildren().add(container);
    }
        scrollPane.setContent(vbxMain);
        totalLabel.setText("Rp. "+ Integer.toString(total));
        
    }
    public void loadKeranjang(){
      XStream xstream = new XStream(new StaxDriver());
      FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataKeranjang.xml");
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
//         ItemKeranjang ik;
          fruits = (Keranjang) xstream.fromXML(stringnya);
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
    public void saveKeranjang(){
             XStream xstream = new XStream(new StaxDriver());
//        HashMap<Barang, Integer> cart = new HashMap<Barang,Integer>();
//        cart.put(b,tmp);
        
//        ItemKeranjang cart = new ItemKeranjang(b, tmp);
//        keranjang.addBarang(cart);
//        user.setKeranjang(fruits);
        String xml = xstream.toXML(fruits);
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
    
    }

