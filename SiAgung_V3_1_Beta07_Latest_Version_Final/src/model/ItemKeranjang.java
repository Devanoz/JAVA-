/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Barang;

/**
 *
 * @author LENOVO
 */
public class ItemKeranjang {
    private final Barang b;
    private int jumlah;
    
    public ItemKeranjang(Barang a, int i){
        this.b=a;
        this.jumlah=i;
        
    }
    
    public Barang getBarang(){
        return this.b;
    }
    
    public int getJumlah(){
        return this.jumlah;
    }
    public void setJumlah(int k){
        this.jumlah=k;
    }
}
