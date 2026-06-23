package model;

/**
 * Clase hija que representa a un Operador Local de Llanquihue Tour.
 * HERENCIA: OperadorLocal ES-UN Colaborador.
 */
public class OperadorLocal extends Colaborador {

    private String servicio;
    private String rubro;

    public OperadorLocal() {
        super();
        this.servicio = "Sin servicio";
        this.rubro    = "Sin rubro";
    }

    public OperadorLocal(String rut, String nombre, String telefono,
                         boolean activo, Direccion direccion,
                         String servicio, String rubro) {
        super(rut, nombre, telefono, "Operador", activo, direccion);
        this.servicio = servicio;
        this.rubro    = rubro;
    }

    public String getServicio() { return servicio; }
    public String getRubro()    { return rubro; }

    public void setServicio(String servicio) { this.servicio = servicio; }
    public void setRubro(String rubro)       { this.rubro    = rubro; }

    @Override
    public String toString() {
        return "OperadorLocal{" +
                "rut='"       + getRut()      + '\'' +
                ", nombre='"  + getNombre()   + '\'' +
                ", telefono='"+ getTelefono() + '\'' +
                ", activo="   + isActivo()    +
                ", servicio='"+ servicio      + '\'' +
                ", rubro='"   + rubro         + '\'' +
                ", comuna='"  + getDireccion().getComuna() + '\'' +
                '}';
    }
}
