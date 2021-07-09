package model;

import konfirmasipembelian.Data;



/**
 *
 * @author X
 */
public class Pengguna {
    String nama;
    String ID;
    String password;
    String Alamat;
    Barang barang;
    Data dataKonfirmasi; 
    Keranjang keranjang;

    private boolean admin;
    boolean statusOnline;

    
    //constructor
    public Pengguna(String nama,String ID,String password){
        this.nama=nama;
        this.ID=ID;
        this.password=password;
    }
    public Pengguna(String nama,String ID,String password,boolean admin){
        this.nama=nama;
        this.ID=ID;
        this.password=password;
        this.admin=admin;
    }
    
   
    
    
    //setter
   
    public void setAdmin(boolean Admin){
        this.admin=Admin;
    }
    public void setID(String ID){
        this.ID=ID;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setStatusOnline(boolean status){
        this.statusOnline=status; 
    }
    public void setAlamat(String alamat){
        this.Alamat=alamat;
    }
    public void setKeranjang(Keranjang keranjang){
        this.keranjang= keranjang;
    }
    //getter
    public String getNama(){
        return this.nama;
    }
    
    public String getID(){
        return this.ID;
    }
    public boolean getAdmin(){
        return this.admin;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public boolean getStatusOnline(){
        return this.statusOnline;
    }
    public String getAlamat(){
        return this.Alamat;
    }
    public Keranjang getKeranjang(){
        return this.keranjang;
    }
}
