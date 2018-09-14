import com.mycompany.controllerimpl.ProductoCtrlImpl;
import com.mycompany.dao.ProductoDAO;
import com.mycompany.modell.Producto;
import java.util.ArrayList;


public class TestProducto {
    
    static ArrayList<Producto> list = new ArrayList<>();
    
    public static void main(String[] args) {
        
        ProductoDAO prodao;
        prodao = new ProductoCtrlImpl();
/*        list = catdao.readCategoria();
          for(Categoria item: list){
              System.out.println(""+item.getName_cat());
          }*/
        Producto pro = new Producto();
//        clie.setId_cliente("5");
        pro.setId_categoria("2");
        pro.setId_unimed("2");
        pro.setNombre("Alex Miguel");
        pro.setDescripcion("lalalal");
        pro.setCodigo("1");
        if (prodao.createProducto(pro)){
            System.out.println("Insertado correctamente");
        }else{
            System.out.println("Error al ingresar el dato");
        }
    }
    
}

