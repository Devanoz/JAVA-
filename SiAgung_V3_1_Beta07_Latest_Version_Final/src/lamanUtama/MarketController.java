package lamanUtama;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import main.MyListener;
import model.Barang;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Pengguna;
import views.AdminController;
import views.AkunController;
import views.KeranjangController;
import views.PageDescriptionController;




public class MarketController implements Initializable {
    XStream xstream= new XStream(new StaxDriver());
    
    int column;
    int row;
    ArrayList<Barang> barangBaru=getXml();
    ArrayList<Barang> dataBaru=getDataBaru();
    //get data from (fromPendaftaranController)
    LinkedList<Pengguna> LoginDataContainer=getLoginDataContainer();
    
    //Xstream================================================================================
     //getting xml from dataBaru(AdminController)======================================
    ArrayList<Barang> getDataBaru(){
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
        return (ArrayList<Barang>) xstream.fromXML(stringnya);	  
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
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    void simpanFruits(){
        String xml = xstream.toXML(fruits);
 
        FileOutputStream coba = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            coba = new FileOutputStream("dataBarang.xml");
 
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
    
    void bukaXml(){
        
        
         FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataBarang.xml");
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
        fruits= (ArrayList<Barang>) xstream.fromXML(stringnya);	  
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
    
    ArrayList<Barang> getXml(){
        FileInputStream cobi = null;
      try {
           // nama file yang akan dibuka (termasuk folder jika perlu
          cobi = new FileInputStream("dataBarang.xml");
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
        return (ArrayList<Barang>) xstream.fromXML(stringnya);	  
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
    
     LinkedList<Pengguna> getLoginDataContainer(){
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
    
     
   
    //Xstream>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    
    //button setDisable=======================================
    public void setDisableButtonKeranjang(boolean condition){
        buttonKeranjang.setDisable(condition);
    }
    public void setDisableButtonAdmin(boolean condition){
        buttonAdmin.setDisable(condition);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    
    
    
    
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLable;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    @FXML
    private ImageView logoAdmin;
    @FXML
    private ImageView homeLogo;
    @FXML
    private Image gambar;
    @FXML
    private BorderPane BorderPane;
    @FXML
    private Button buttonKeranjang;
    @FXML
    private Button buttonAdmin;
    @FXML
    private Button buttonBeliBarang;
    
    //untuk multiScene
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    Barang tmpBarang;
    
    
    //handler=============================================================================================
    @FXML
    private void homeButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/market.fxml"));
        root = loader.load();	
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void bukaAkun(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AkunController.class.getResource("Akun.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Akun");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
        
        
    }
    
     @FXML
     private void bukaKeranjang(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(FXMLDocumentController.class.getResource("FXMLDocument.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        //Stage dialogStage = new Stage(); 
        //dialogStage.setTitle("Akun");
        //dialogStage.initModality(Modality.APPLICATION_MODAL); 
        //Scene scene = new Scene(loader.load()); 
        //dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
       //dialogStage.showAndWait();
       
       Pane pane= FXMLLoader.load(KeranjangController.class.getResource("Keranjang.fxml"));
       BorderPane.setCenter(pane);
       
     }
     
     @FXML
     private void handleButtonBeliBarang(ActionEvent event) throws IOException{
//         FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(PageDescriptionController.class.getResource("PageDescription.fxml")); 
//        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
//        // FXML2 diganti dengan FXML yang kedua
//
//        Stage dialogStage = new Stage(); 
//        dialogStage.setTitle("Akun");
//        dialogStage.initModality(Modality.APPLICATION_MODAL); 
//        Scene scene = new Scene(loader.load()); 
//        dialogStage.setScene(scene);
//        // Show the dialog and wait until the user closes it 
//        dialogStage.showAndWait();
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PageDescription.fxml"));
        Pane bp = (Pane) loader.load();
        PageDescriptionController pageController = loader.<PageDescriptionController>getController();
        pageController.display(tmpBarang);
        BorderPane.setCenter(bp);
//        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        }catch(Exception e){
            System.out.println(e);
        }
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageDescription.fxml"));
////        root = loader.load();
//        PageDescriptionController pageController = loader.getController();
//        pageController.display(tmpBarang);
//        System.out.println(tmpBarang.getName());
//        
//        Pane pane= FXMLLoader.load(PageDescriptionController.class.getResource("PageDescription.fxml"));
//        
//        BorderPane.setCenter(pane);
//        

        
     }
     
     @FXML
     private void handdleButtonAdmin(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AdminController.class.getResource("Admin.fxml")); 
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Akun");
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        Scene scene = new Scene(loader.load()); 
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it 
        dialogStage.showAndWait();
     }
     
     @FXML
     private void buttonRefresh(ActionEvent event) throws IOException{
         //addFruit();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/market.fxml"));
         root = loader.load();	
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
//         System.out.println(dataBaru.size());
        
     }
     
     
     
   //handler>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     
     
   //declaring fruits===============================================================================

    private ArrayList<Barang> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    
    
   void setBarangDefault(){
        
        Barang fruit;   fruit = new Barang();
        fruit.setName("Sepatu Gunung Murah Meriah");
        fruit.setPrice("200000");
        fruit.setImgSrc("/image/snta_snta-sepatu-gunung-pria--snta-498-_full18.jpg");
        fruit.setColor("b5a272");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tenda Camping Anti Air");
        fruit.setPrice("670000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/10128311_1.jpg");
        fruit.setColor("db4112");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Pisau Hutan Serbaguna");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setPrice("67000");
        fruit.setImgSrc("/image/1943175_c1960313_1ae9_473e_89e1_f476f3fa8391.jpg");
        fruit.setColor("b81a1a");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tas Ransel Gunung Murah Meriah");
        fruit.setPrice("450000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/trim_gunung_elfs_35l_backsupport_mc0-bbfdc-3073_10827-t3073_116.jpg");
        fruit.setColor("941616");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tali Tambang Sangat Kuat");
        fruit.setPrice("45000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/tambang.jpg");
        fruit.setColor("26a62f");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Sepatu Gunung Murah Meriah");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setPrice("200000");
        fruit.setImgSrc("/image/snta_snta-sepatu-gunung-pria--snta-498-_full18.jpg");
        fruit.setColor("b5a272");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tenda Camping Anti Air");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setPrice("670000");
        fruit.setImgSrc("/image/10128311_1.jpg");
        fruit.setColor("db4112");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Pisau Hutan Serbaguna");
        fruit.setPrice("67000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/1943175_c1960313_1ae9_473e_89e1_f476f3fa8391.jpg");
        fruit.setColor("b81a1a");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tas Ransel Gunung Murah Meriah");
        fruit.setPrice("450000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/trim_gunung_elfs_35l_backsupport_mc0-bbfdc-3073_10827-t3073_116.jpg");
        fruit.setColor("941616");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Tali Tambang Sangat Kuat");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setPrice("45000");
        fruit.setImgSrc("/image/tambang.jpg");
        fruit.setColor("26a62f");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Senter Gunung Sangat Terang");
        fruit.setPrice("90000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/senter_gunung.jpg");
        fruit.setColor("3b3b3b");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Poncho Gunung Anti Air");
        fruit.setPrice("30000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/poncho.jpg");
        fruit.setColor("4a4a4a");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Hammock Untuk Tidur maks. 150kg");
        fruit.setPrice("80000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/hammock.jpg");
        fruit.setColor("db5202");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Kompor Gas Outdoor Windproof");
        fruit.setPrice("75000");
        fruit.setImgSrc("/image/komporin.jpg");
        fruit.setColor("bd0404");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruits.add(fruit);

        fruit = new Barang();
        fruit.setName("Celana Gunung Anti Air");
        fruit.setPrice("100000");
        fruit.setQty(20);
        fruit.setDeskripsi("Sangat awt");
        fruit.setImgSrc("/image/celana_gunung.jpg");
        fruit.setColor("6b6b6b");
        fruits.add(fruit);
        
        
        
    }
   
    
   
    //declaring fruits>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //method===============================================================

    private void setChosenFruit(Barang fruit) {
        fruitNameLable.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        
        if(fruit.getOri()){
            image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        }else{
            image = new Image(fruit.getImgSrc());
        }
            fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    
    private void displayImage(){
         gambar=new Image(getClass().getResourceAsStream("/image/logoAdmin.png"));
         Image gambar2=new Image(getClass().getResourceAsStream("/image/homeLogo.jpg"));
         logoAdmin.setImage(gambar);
         homeLogo.setImage(gambar2);
         
         
    }
    
    
    public void setKeranjangOff(){
        buttonKeranjang.setDisable(true);
    }
    
    public void setKeranjangOn(){
        buttonKeranjang.setDisable(false);
    }
    
    void controlButtonPengguna(){
        boolean adaPenggunaOnline=false;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if ((LoginDataContainer.get(i).getStatusOnline())  && !LoginDataContainer.get(i).getAdmin() ) {
                adaPenggunaOnline=true;
                break;
            }
        }
        
        if (adaPenggunaOnline) {
            buttonKeranjang.setDisable(false);
            buttonBeliBarang.setDisable(false);
        }
    }
    void controlButtonAdmin(){
        boolean isAdmin=false;
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if ((LoginDataContainer.get(i).getStatusOnline()) && (LoginDataContainer.get(i).getAdmin())) {
                isAdmin=true;
                break;
            }
        }
        
        if (isAdmin) {
            buttonAdmin.setDisable(false);
            buttonBeliBarang.setDisable(true);
        }
    }
    
    
    
    //adding admin(default)
   
    
    //method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //adding defaultAdmin for login
        
         
         
        
        //menambah list barang(di scrollPane) dari dataBaru ke Fruits(barang)
        if(!dataBaru.isEmpty()){
            Barang fruit; 
            for (int i = 0; i <dataBaru.size(); i++) {
           
           
           
              
            fruit = new Barang();
            fruit.setName(dataBaru.get(i).getName());
            if(dataBaru.get(i).getImgSrc().equals("")){
                fruit.setOri(true);
                fruit.setImgSrc("/image/celana_gunung.jpg");
            }else{
                fruit.setImgSrc(dataBaru.get(i).getImgSrc());
                fruit.setOri(false);
            }
            
            fruit.setPrice(dataBaru.get(i).getPrice());
            fruit.setColor("6b6b6b");
            fruits.add(fruit);
            simpanFruits();
         }
       }
       
       
       
        //tambah barang
        setBarangDefault();
        
        
        
        if (fruits.size() > 0) {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Barang fruit) {
                    setChosenFruit(fruit);
                    tmpBarang=fruit;
                }
            };
        }
        column = 0;
        row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                System.out.println(fruits.get(i).getImgSrc());
                System.out.println(fruits.get(i).getOri());
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        //untuk menyimpan pengguna online
        
        
        //simpan buka xml
        displayImage();
        bukaXml();
        simpanFruits();
        controlButtonPengguna();
        controlButtonAdmin();
        
    }

}
