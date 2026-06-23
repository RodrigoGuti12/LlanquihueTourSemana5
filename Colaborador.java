package model;

/**
 * Clase base general que representa a cualquier colaborador
 * vinculado a Llanquihue Tour.
 * Aplica composición con la clase Direccion.
 */
public class Colaborador {

    private String    rut;
    private String    nombre;
    private String    telefono;
    private String    tipo;
    private boolean   activo;
    private Direccion direccion;  // COMPOSICIÓN: Colaborador TIENE-UN Direccion

    public Colaborador() {
        this.rut       = "Sin RUT";
        this.nombre    = "Sin nombre";
        this.telefono  = "Sin teléfono";
        this.tipo      = "Sin tipo";
        this.activo    = false;
        this.direccion = new Direccion();
    }

    public Colaborador(String rut, String nombre, String telefono,
                       String tipo, boolean activo, Direccion direccion) {
        this.rut       = rut;
        this.nombre    = nombre;
        this.telefono  = telefono;
        this.tipo      = tipo;
        this.activo    = activo;
        this.direccion = direccion;
    }

    public String    getRut()       { return rut; }
    public String    getNombre()    { return nombre; }
    public String    getTelefono()  { return telefono; }
    public String    getTipo()      { return tipo; }
    public boolean   isActivo()     { return activo; }
    public Direccion getDireccion() { return direccion; }

    public void setRut(String rut)          { this.rut       = rut; }
    public void setNombre(String nombre)    { this.nombre    = nombre; }
    public void setTelefono(String tel)     { this.telefono  = tel; }
    public void setTipo(String tipo)        { this.tipo      = tipo; }
    public void setActivo(boolean activo)   { this.activo    = activo; }
    public void setDireccion(Direccion dir) { this.direccion = dir; }

    @Override
    public String toString() {
        return "Colaborador{" +
                "rut='"       + rut       + '\'' +
                ", nombre='"  + nombre    + '\'' +
                ", telefono='"+ telefono  + '\'' +
                ", tipo='"    + tipo      + '\'' +
                ", activo="   + activo    +
                ", direccion="+ direccion +
                '}';
    }
}
