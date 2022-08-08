
public class Reparacion extends Trabajo{
    //atributos
    private String tipo;
    private double preciomaterial=0;

    //Constructores
    public Reparacion(){}

    public Reparacion(String tipo, String id, String Descripcion, String tipotrabajo) {
        super(id, Descripcion, tipotrabajo);
        this.tipo = tipo;
    }

    //Metodos
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreciomaterial() {
        return preciomaterial;
    }
    public void setPreciomaterial(double preciomaterial) {
        this.preciomaterial += preciomaterial;
    }
    
    public void setPrecio() {
        if(tipo.equals("Mecánica")){
            precio = (preciomaterial + 200000) * 1.1;
        }else if(tipo.equals("Latonería y Pintura")){
            precio = (100000 + preciomaterial) * 1.3;
        }     
    }
    
}
