package views;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lamanUtama.MarketController;
import model.Pengguna;

/**
 * FXML Controller class
 *
 * @author X
 */
public class LoginViewController implements Initializable {
//    private MarketController marketController;
    XStream xstream= new XStream(new StaxDriver());
    //mengambil method dari FormPendaftaran controller untuk mendapatkan linked List yang disimpan ke data
    LinkedList<Pengguna> LoginDataContainer=bukaXml();
    
    
//    public LoginViewController(){
//        
//    }
    
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
    
    

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btLogin;

    @FXML
    private Button btDaftar2;

    @FXML
    private ImageView imageLogo;
    @FXML
    private Image gambar;
    @FXML
    private ImageView logoDelta2;
    @FXML
    private Label alert;
    

    
    //untuk multipleScene
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    
    @FXML
    private void buttonDaftar(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormPendaftaran.fxml"));
        root = loader.load();	
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    @FXML
    private void buttonLogin(ActionEvent event) throws IOException{
        String username=tfID.getText();
        String password=tfPassword.getText();
        
        boolean dataBenar=false;
        boolean isAdmin=false;
        
        for (int i = 0; i <LoginDataContainer.size(); i++) {
            if ((username.equals(LoginDataContainer.get(i).getID()))&& (password.equals(LoginDataContainer.get(i).getPassword()))) {
                LoginDataContainer.get(i).setStatusOnline(true);
                dataBenar=true;
                break;
            }else if((username.equals("admin")) && (password.equals("admin"))){
                dataBenar=true;
                isAdmin=true;
                LoginDataContainer.get(i).setAdmin(true);
                LoginDataContainer.get(i).setStatusOnline(true);
            }
        }
        
        
        if(dataBenar && !isAdmin){
            root = FXMLLoader.load(LoginViewController.class.getResource("LoginView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.close();
            
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
//        System.out.println("Hehe");
        
//        
                
//        Pane bp = (Pane) loader.load();
//        PageDescriptionController pageController = loader.<PageDescriptionController>getController();
//        pageController.display(tmpBarang);
//        BorderPane.setCenter(bp);
//        
        
        
        

        }else if(dataBenar && isAdmin){
            root = FXMLLoader.load(LoginViewController.class.getResource("LoginView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.close();
            
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
        else if(!dataBenar){
            alert.setText("ID/password Salah silahkan ulangi lagi");
        }
    }
    
    //method================================================================================================
    private void displayImage(){
         gambar=new Image(getClass().getResourceAsStream("/image/DeltaShop.jpeg"));
         logoDelta2.setImage(gambar);
    }
    
     
    //method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        displayImage();
        bukaXml();
        
     
    }    
    
}
