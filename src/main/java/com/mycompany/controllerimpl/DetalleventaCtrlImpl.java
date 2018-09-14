
package com.mycompany.controllerimpl;

import com.mycompany.modell.Detalleventa;
import com.mycompamy.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.DetalleventaDAO;

public class DetalleventaCtrlImpl implements DetalleventaDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Detalleventa> listDatos;

    public DetalleventaCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createDetalleventa(Detalleventa dv) {
        sql = "INSERT INTO public.id_dettalle_venta(id_venta, item, igv, sub_total, descuento, id_producto_stock, cantidad, precio_unit)"
                + "VALUES('"+dv.getId_venta()+"','"+dv.getItem()+"','"+dv.getIgv()+"','"+dv.getSub_total()+"','"+dv.getDescuento()+"','"+dv.getId_producto_stock()+"','"+dv.getCantidad()+"','"+dv.getPrecio_unit()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Detalleventa> readDetalleventa() {
        listDatos = new ArrayList<>();
        sql = "SELECT *"
                + "    FROM public.detalle_venta";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Detalleventa(rs.getString("id_detalle_venta"),rs.getString("id_venta"),rs.getString("item"),rs.getString("igv"),rs.getString("sub_total"),rs.getString("descuento"),rs.getString("id_producto_stock"),rs.getString("cantidad"),rs.getString("precio_unit")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalleventaCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateDetalleventa(Detalleventa dv) {
        sql = "UPDATE public.detalle_venta SET"
                + " id_venta = '"+dv.getId_venta()+"' , item = '"+dv.getItem()+"' , item = '"+dv.getItem()+"' , sub_total = '"+dv.getSub_total()+"' , descuento = '"+dv.getDescuento()+"' , id_producto_stock = '"+dv.getId_producto_stock()+"' , cantidad = '"+dv.getCantidad()+"' , precio_unit = '"+dv.getPrecio_unit()+"'"
                + " WHERE id_detalle_venta = "+dv.getId_detalle_venta()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteDetalleventa(String id) {       
        sql = "DELETE public.detalle_venta "
                + "WHERE id__detalle_venta = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
