
package com.mycompany.dao;

import com.mycompany.modell.Detalleventa;
import java.util.ArrayList;

public interface DetalleventaDAO {
    public boolean createDetalleventa(Detalleventa dv);
    public ArrayList<Detalleventa> readDetalleventa();
    public boolean updateDetalleventa(Detalleventa dv);
    public boolean deleteDetalleventa(String id);
}
