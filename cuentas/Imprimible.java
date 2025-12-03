package cuentas;

/**
 * Interfaz que obliga a las clases que la implementan a devolver una representación en texto de sus datos.
 * 
 * @author Viktoriia Bohoslavska
 */
public interface Imprimible {
    /**
     * Devuelve la información del objeto como una cadena de texto.
     * 
     * @return Representación en texto de la información del objeto.
     */
    String devolverInfoString();
}

