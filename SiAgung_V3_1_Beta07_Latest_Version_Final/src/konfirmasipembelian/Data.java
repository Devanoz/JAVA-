/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfirmasipembelian;

/**
 *
 * @author 62895
 */
public class Data {
    String nama;
    String kurir ;
    String pembayaran ;
    String alamat ;
    String kode  ;
    String resi;
    
    public Data(String Kurir,String Pembayaran,String Alamat,String Kode){
      this.kurir = Kurir;  
      this.pembayaran = Pembayaran;
      this.alamat = Alamat;
      this.kode = Kode;
      
      
    }
    
    public Data(String Kurir,String Pembayaran,String Alamat,String Kode,String nama){
      this.kurir = Kurir;  
      this.pembayaran = Pembayaran;
      this.alamat = Alamat;
      this.kode = Kode;
      this.nama=nama;
      
      
    }
    public String getKurir(){
        return this.kurir; 
    }
    public void setKurir(String Kurir){
        this.kurir = Kurir;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    public String getPembayaran(){
        return this.pembayaran; 
    }
    public void setPembayaran(String Pembayaran){
        this.pembayaran = Pembayaran;
    }
    
    public String getAlamat(){
        return this.alamat; 
    }
    public void setAlamat(String Alamat){
        this.alamat = Alamat;
    }
    
    public String getKode(){
        return this.kode; 
    }
    public void setKode(String Kode){
        this.kode = Kode;
    }
    
}
