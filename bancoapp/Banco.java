package bancoapp;

import cuentas.CuentaBancaria;
import java.util.ArrayList;

/**
 *
 * @author 38097
 */
public class Banco {
    private static final int MAX_CUENTAS = 100;
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
    
    public boolean agregarCuenta(CuentaBancaria cuenta) {
    if (cuentas.size() >= MAX_CUENTAS) {
        System.out.println("Bank account limit reached! Cannot add more.");
        return false;
    }
    cuentas.add(cuenta);
    return true;
    }
    
    public String[] listadoCuentas(){
        if (cuentas.isEmpty()){
        System.out.println("No cuentas");
        return new String[0];
    }
        String[] listado = new String[cuentas.size()];
            for (int i = 0; i < cuentas.size(); i++){
            listado[i]=cuentas.get(i).toString();
            }
            return listado;
    }
   
    public boolean eliminarCuenta(String iban){
        if (cuentas==null || cuentas.isEmpty()){
            System.out.println("No cuentas");
            return false;
        }
        for (int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIBAN().equals(iban)){
                cuentas.remove(i);
                return true;
            }
        }
        System.out.println("No cuenta with such IBAN");
        return false;
    }
    
    public String informacionCuenta(String iban){
        if (cuentas==null || cuentas.isEmpty()){
            return "No cuentas";
        }
        for (int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIBAN().equals(iban)){
                return cuentas.get(i).toString();
            }
        }
            return "No cuenta with such IBAN";
    }
    
    public boolean ingresoCuenta(String iban, double cantidad){
    if (cantidad <= 0) {
        System.out.println("Error: number should be positive");
        return false;
    }
    for (int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIBAN().equals(iban)){
                cuentas.get(i).ingresar(cantidad);
                return true;
            }
    }
    System.out.println("No account found with the given IBAN.");
    return false;
}

    public boolean retiradaCuenta(String iban, double cantidad){
        if (cantidad <= 0) {
        System.out.println("Error: number should be positive");
        return false;
    }
    for (int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIBAN().equals(iban)){
                return cuentas.get(i).retirar(cantidad);
            }
    }
    System.out.println("No account found with the given IBAN.");
    return false;
    }
    
    public double obtenerSaldo(String iban){
        if (cuentas==null || cuentas.isEmpty()){
            return -1;
        }
        for (int i = 0; i < cuentas.size(); i++){
            if(cuentas.get(i).getIBAN().equals(iban)){
                return cuentas.get(i).getSaldo();
            }
        }
            return -1;
    }
    
    
}
