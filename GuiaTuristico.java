package model;

/**
 * Clase hija que representa a un Guía Turístico de Llanquihue Tour.
 * HERENCIA: GuiaTuristico ES-UN Colaborador.
 */
public class GuiaTuristico extends Colaborador {

    private String especialidad;
    private int    aniosExperiencia;

    public GuiaTuristico() {
        super();
        this.especialidad     = "Sin especialidad";
        this.aniosExperiencia = 0;
    }

    public GuiaTuristico(String rut, String nombre, String telefono,
                         boolean activo, Direccion direccion,
                         String especialidad, int aniosExperiencia) {
        super(rut, nombre, telefono, "Guia", activo, direccion);
        this.especialidad     = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getEspecialidad()     { return especialidad; }
    public int    getAniosExperiencia() { return aniosExperiencia; }

    public void setEspecialidad(String especialidad)      { this.especialidad     = especialidad; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    @Override
    public String toString() {
        return "GuiaTuristico{" +
                "rut='"              + getRut()          + '\'' +
                ", nombre='"         + getNombre()       + '\'' +
                ", telefono='"       + getTelefono()     + '\'' +
                ", activo="          + isActivo()        +
                ", especialidad='"   + especialidad      + '\'' +
                ", experiencia="     + aniosExperiencia  + " años" +
                ", comuna='"         + getDireccion().getComuna() + '\'' +
                '}';
    }
}
