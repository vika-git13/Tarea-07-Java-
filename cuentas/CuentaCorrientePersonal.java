package cuentas;
import bancoapp.Persona;

/**
 * Clase que representa una cuenta corriente personal.
 * Extiende de `CuentaCorriente` y tiene comisión de mantenimiento.
 * 
 * @author 38097
 */
public class CuentaCorrientePersonal extends CuentaCorriente implements Imprimible {
    private double commission;

    /**
     * Constructor para CuentaCorrientePersonal.
     * 
     * @param IBAN Número IBAN de la cuenta
     * @param saldo Saldo inicial de la cuenta
     * @param owner Propietario de la cuenta
     * @param authorisedCompanies Lista de empresas autorizadas
     * @param commission Comisión de mantenimiento anual
     */
    public CuentaCorrientePersonal(String IBAN, double saldo, Persona owner, String[] authorisedCompanies, double commission){
        super(IBAN, saldo, owner, authorisedCompanies);
        this.commission = commission;
    }

    /**
     * Obtiene la comisión de mantenimiento.
     * 
     * @return Comisión de mantenimiento
     */
    public double getCommission(){
        return commission;
    }

    /**
     * Establece una nueva comisión de mantenimiento.
     * 
     * @param commission Nueva comisión
     */
    public void setCommission(double commission){
        this.commission = commission;
    }

    /**
     * Aplica la comisión de mantenimiento a la cuenta.
     * Si el saldo es suficiente, la comisión se descuenta. Si no, se muestra un mensaje de error.
     */
    public void applyCommission(){
        if (saldo >= commission){ // saldo es protected, можно использовать напрямую
            saldo -= commission;
        } else {
            System.out.println("Not enough money to apply the commission.");
        }
    }

    /**
     * Devuelve la información detallada de la cuenta corriente personal.
     * 
     * @return Información de la cuenta como cadena de texto
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "\nTipo de cuenta: Corriente Personal" +
               "\nComision de mantenimiento: " + commission + "€";
    }
}
