
public class Trabajo {
    //atributos
    private String id;
    private String Descripcion;
    protected int nhoras=0;
    private boolean estado=false;   //false: en proceso    true: finalizado
    public double precio=0;
    private String tipotrabajo;
    
    //Constructores
    public Trabajo(){}

    public Trabajo(String id, String Descripcion, String tipotrabajo) {
        this.id = id;
        this.Descripcion = Descripcion;
        this.tipotrabajo = tipotrabajo;
    }
    
    
    //Métodos

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getNhoras() {
        return nhoras;
    }
    public void setNhoras() {
        this.nhoras++;
    }

    public boolean getEstado() {
        return estado;
    }
    public void changeEstado() {
        this.estado = true;
    }

    public String getTipotrabajo() {
        return tipotrabajo;
    }

    public void setTipotrabajo(String tipotrabajo) {
        this.tipotrabajo = tipotrabajo;
    }

    public double getPrecio() {
        return precio;
    }
    
    
}
