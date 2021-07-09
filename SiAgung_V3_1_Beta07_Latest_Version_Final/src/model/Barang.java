package model;

public class Barang {
    private String name;
    private String imgSrc="";
    private String price;
    private String color;
    private int qty;
    private String deskripsi;
    
    private boolean ori=true;
    
//status barang
    private boolean dikemas;
    private boolean dikirim;
    private boolean diterima;

    
    
    public Barang(String name,String price,String Deskripsi){
        this.name=name;
        this.price=price;
        this.deskripsi=Deskripsi;
    }
    public Barang(){
        
    }
    
    
    //setter
     public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi=deskripsi;
    }
    public void setQty(int qty){
        this.qty=qty;
    }
    
    

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    public void setOri(boolean t){
        this.ori=t;
    }
    
   //getter
    public String getPrice() {
        return price;
    }


    public String getColor() {
        return color;
    }

   
    public String getName() {
        return name;
    }
    public String getImgSrc() {
        return imgSrc;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    public int getQty(){
        return this.qty;
    }
    public boolean getOri(){
        return this.ori;
    }
    
}
