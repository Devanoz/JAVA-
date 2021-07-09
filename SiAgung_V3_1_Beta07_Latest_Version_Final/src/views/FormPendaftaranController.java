package views;

//import package

import model.Pengguna;

//other
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Xstream
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;

//untuk menyimpan xml
import java.io.IOException;
import java.io.FileOutputStream;
import javafx.fxml.FXMLLoader;

//untuk buka xml
import java.io.FileInputStream;


/**
 * FXML Controller class
 *
 * @author Devano zaidan
 */

//untuk mengganti Scene
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import lamanUtama.MarketController;






public class FormPendaftaranController implements Initializable {
    
    
    LinkedList<Pengguna> LoginDataContainer=new LinkedList<>();//inisialisasi LinkedList untuk  menyimpan Pengguna yang dibutuhkan saat login
    //setiap node memiliki masing-masing Pengguna
    
    
    
    LinkedList<Pengguna>  getLoginData (){
       return LoginDataContainer;
   }
    Pengguna getPenggunaOnline(){
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if (LoginDataContainer.get(i).getStatusOnline()) {
                return LoginDataContainer.get(i);
            }
        }
        return null;
    }
    
    public void show(){
        daftarAkun.setText(LoginDataContainer.get(0).getID());
    }
        
    
    
    
    XStream xstream= new XStream(new StaxDriver());
    @FXML
    private AnchorPane pane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane Pane;
    @FXML
    private Button buttonDaftar;
    @FXML
    private Image gambar;
    @FXML
    private ImageView logoDelta;
    @FXML
    private Label daftarAkun;


    
    //method untuk buka xml
    void bukaXml(){
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
        LoginDataContainer =  (LinkedList<Pengguna>) xstream.fromXML(stringnya);	  
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
    //untuk form pendaftaran
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfPassword;
    @FXML
    private Label usernameAlert;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //untuk login view
    
    @FXML
    private TextField tfID2;

    @FXML
    private TextField tfPassword2;

    @FXML
    private Button btLogin;

    @FXML
    private Button btDaftar2;
    @FXML
    private ImageView logoDelta2;


    



    //untuk form pendaftaran 
    @FXML
    private void buttonDaftar(ActionEvent event) throws IOException{
        
        //mengambil text dari masing-masing textfield untuk dimasukkan dalam variabel
        String nama=tfNama.getText();
        String ID=tfID.getText();
        String password=tfPassword.getText();
        
        
        
        boolean IDganda = false;//variabel untuk cek apakah ada ID yang Ganda
        
        //melakukan pencarian setiap indeks Linkedlist dan mendapatkan ID pada setiap indeks
        for (int i = 0; i < LoginDataContainer.size(); i++) {
            System.out.println(LoginDataContainer.get(i));
            if(ID.equals(LoginDataContainer.get(i).getID())){//jika ID yang dimasukkan ditemukan kesamaan nilai maka ID dianggap ganda 
                IDganda=true;// IDganda set True (terdapat ID yang sama)
            }
          
        }
        
        
        if(IDganda){
            usernameAlert.setText("ID/Username telah digunakan");//jika terdapat ID yang sama maka akan muncul peringatan berikut
            
            
        }else if(!IDganda){
            LoginDataContainer.add(new Pengguna(nama,ID,password));// jika tidak terdapat iD yang sama maka data dapat dimasukkan ke dalam Pengguna container
            
           
            
 
        // larik double diubah menjadi string dengan format XML
        String xml = xstream.toXML(LoginDataContainer);
 
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
            //
            root = FXMLLoader.load(FormPendaftaranController.class.getResource("FormPendaftaran.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.close();
        }
        
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
     private void displayImage(){
         gambar=new Image(getClass().getResourceAsStream("/image/DeltaShop.jpeg"));
         logoDelta.setImage(gambar);
    }
     
     void clearLoginData(){
         LoginDataContainer.clear();
         String xml = xstream.toXML(LoginDataContainer);
 
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
     
     void adAdmin(){
        Pengguna admin=new Pengguna("Admin","admin","admin",true);
        LoginDataContainer.add(admin);
        
        //simpang loginData ke xml
        String xml = xstream.toXML(LoginDataContainer);
 
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //method
        bukaXml();
        displayImage();
    }    

   
}
