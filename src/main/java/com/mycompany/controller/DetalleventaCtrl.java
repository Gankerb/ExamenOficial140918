
package com.mycompany.controller;

import com.mycompany.modell.Detalleventa;
import com.mycompany.controllerimpl.DetalleventaCtrlImpl;
import java.util.ArrayList;
import com.mycompany.dao.DetalleventaDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "detalleventaCtrl")
@SessionScoped

public class DetalleventaCtrl implements Serializable {
    
    private Detalleventa selected;
    private boolean est;
    DetalleventaDAO dvdao;
    
    private ArrayList<Detalleventa> list = new ArrayList<>();

    public DetalleventaCtrl() {
        this.selected = new Detalleventa();
        this.dvdao = new DetalleventaCtrlImpl();
    }
    
    public void createDetalleventa(){
        
        if(dvdao.createDetalleventa(selected)){
            System.out.println("Insertado");
        } else{
            System.out.println("Error al momento de insertar");
        }
        
    }
    
    ArrayList<Detalleventa> listDatos;

    public ArrayList<Detalleventa> getList(){
        
        dvdao = new DetalleventaCtrlImpl();
        list = dvdao.readDetalleventa();
        return list;
        
    }
    
    
     public Detalleventa getSelected() {
        return selected;
    }

    public void setSelected(Detalleventa selected) {
        this.selected = selected;
    }
    
    
    

}
