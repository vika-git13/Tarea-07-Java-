package bancoapp;
/**
 * Clase que representa una persona con nombre, apellidos y DNI.
 * 
 * @author Viktoriia Bohoslavska
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;

    /**
     * Constructor para crear una persona.
     * 
     * @param nombre    Nombre de la persona
     * @param apellidos Apellidos de la persona
     * @param dni       Documento Nacional de Identidad (DNI)
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Los apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @return El DNI de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece un nuevo nombre para la persona.
     * 
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece nuevos apellidos para la persona.
     * 
     * @param apellidos Los nuevos apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece un nuevo DNI para la persona.
     * 
     * @param dni El nuevo DNI
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve la información de la persona en forma de cadena.
     * 
     * @return Cadena con los datos de la persona.
     */
    @Override
    public String toString() {
        return "Cliente: " + nombre + " "+ apellidos;
    }  
    }