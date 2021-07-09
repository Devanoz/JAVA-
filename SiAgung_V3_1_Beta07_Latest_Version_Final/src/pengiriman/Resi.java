/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengiriman;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 20523015
 */
public class Resi {    
    private  int No;
    private  String  Nama;
    private  String Alamat;
    private  String  Kurir;
    private  String  Resi;
    
    Resi(int no, String nama, String alamat, String kurir, String resi)
    {      
       
    
    }
    
     
    public Integer getNo() {
        return this.No;
    }

    public void setNo(int no) {
        this.No=no;
    }
    
   
  
    public String getNama() {
        return this.Nama;
    }

    public void setNama(String nama) {
        this.Nama=nama;
    }
    
    

    public String getAlamat() {
        return this.Alamat;
    }

    public void setAlamat(String alamat) {
        this.Alamat=alamat;
    }
    
    
    public String getKurir() {
        return this.Kurir;
    }

    public void setKurir(String kurir) {
        this.Kurir=kurir;
    }
    
   

    public String getResi() {
        return this.Resi;
    }

    public void setResi(String resi) {
        this.Resi=resi;
    }
    
    
}
    
