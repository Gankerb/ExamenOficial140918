
package com.mycompany.controllerimpl;

import com.mycompany.modell.Venta;
import com.mycompamy.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.VentaDAO;

public class VentaCtrlImpl implements VentaDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Venta> listDatos;

    public VentaCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createVenta(Venta ven) {
        sql = "INSERT INTO public.venta(fecha, concepto, igv, total, sub_total, id_cliente_direccion, id_vendedor)"
                + "VALUES('"+ven.getFecha()+"','"+ven.getConcepto()+"','"+ven.getIgv()+"','"+ven.getTotal()+"','"+ven.getSub_total()+"','"+ven.getId_cliente_direccion()+"','"+ven.getId_vendedor()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Venta> readVenta() {
        listDatos = new ArrayList<>();
        sql = "SELECT *"
                + "    FROM public.venta";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Venta(rs.getString("id_venta"),rs.getString("fecha"),rs.getString("concepto"),rs.getString("igv"),rs.getString("total"),rs.getString("sub_total"),rs.getString("id_cliente_direccion"),rs.getString("id_vendedor")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentaCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateVenta(Venta ven) {
        sql = "UPDATE public.venta SET"
                + " fecha = '"+ven.getFecha()+"' , concepto = '"+ven.getConcepto()+"' , igv = '"+ven.getIgv()+"' , total = '"+ven.getTotal()+"' , sub_total = '"+ven.getSub_total()+"' , id_cliente_direccion = '"+ven.getId_cliente_direccion()+"' , id_vendedor = '"+ven.getId_vendedor()+"'"
                + " WHERE id_venta = "+ven.getId_venta()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteVenta(String id) {       
        sql = "DELETE public.venta "
                + "WHERE id_venta = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
