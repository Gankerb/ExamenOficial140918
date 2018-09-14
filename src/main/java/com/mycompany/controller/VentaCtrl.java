
package com.mycompany.controller;

import com.mycompany.modell.Venta;
import com.mycompany.controllerimpl.VentaCtrlImpl;
import java.util.ArrayList;
import com.mycompany.dao.VentaDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "ventaCtrl")
@SessionScoped

public class VentaCtrl implements Serializable {
    
    private Venta selected;
    private boolean est;
    VentaDAO vendao;
    
    private ArrayList<Venta> list = new ArrayList<>();

    public VentaCtrl() {
        this.selected = new Venta();
        this.vendao = new VentaCtrlImpl();
    }
    
    public void createVenta(){
        
        if(vendao.createVenta(selected)){
            System.out.println("Insertado");
        } else{
            System.out.println("Error al momento de insertar");
        }
        
    }
    
    ArrayList<Venta> listDatos;

    public ArrayList<Venta> getList(){
        
        vendao = new VentaCtrlImpl();
        list = vendao.readVenta();
        return list;
        
    }
    
    
     public Venta getSelected() {
        return selected;
    }

    public void setSelected(Venta selected) {
        this.selected = selected;
    }
    
    
    

}
