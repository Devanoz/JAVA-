/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.ItemKeranjang;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Keranjang   {
   private List<ItemKeranjang> keranjang = new ArrayList<>();
   private int total=0;
   
   public void addBarang(ItemKeranjang b){
       this.keranjang.add(b);
   }
   
   public void removeBarang(ItemKeranjang b){
       this.keranjang.remove(b);
   }
   
   public int getTotal(){
       return this.total;
   }
   public void setTotal(int t){
       this.total= t;
   }
   
   public ItemKeranjang getBarang(int id){
       return this.keranjang.get(id);
   }
   
   public void clearKeranjang(){
       this.keranjang.clear();
   }
   
   public void addAllBarang(Collection<ItemKeranjang> c){
       this.keranjang.addAll(c);
   }
   
   public int sizeKeranjang(){
       return this.keranjang.size();
   }
   
  
   
}
