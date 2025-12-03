package utils;

/**
 *
 * @author 38097
 */
public class Validar {
      public static boolean validarDni(String dni){
        return dni.matches("^[0-9]{8}[A-Z]$");
    }
    
    public static boolean validarIBAN(String IBAN){
    return IBAN.matches("^ES[0-9]{22}$");
    }
    
}
