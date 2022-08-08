
public class Revision extends Trabajo{

    public Revision() {}
    public Revision(String id, String Descripcion, String tipotrabajo) {
        super(id, Descripcion, tipotrabajo);
    }
    
    
    public void setPrecio(){
        precio = 300000 + (nhoras * 30000) + 20000;
    }
    
}
