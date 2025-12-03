package cuentas;
import bancoapp.Persona;

/**
 * Clase que representa una cuenta de ahorro, que genera intereses anuales.
 * Extiende de `CuentaBancaria`.
 * 
 * @author Viktoriia Bohoslavska
 */
public class CuentaAhorro extends CuentaBancaria implements Imprimible {
    private double annualInterest;

    /**
     * Constructor para una cuenta de ahorro.
     * 
     * @param IBAN Número IBAN de la cuenta
     * @param saldo Saldo inicial de la cuenta
     * @param owner Propietario de la cuenta
     * @param annualInterest Tasa de interés anual (en porcentaje)
     */
    public CuentaAhorro(String IBAN, double saldo, Persona owner, double annualInterest) {
        super(IBAN, saldo, owner);
        this.annualInterest = annualInterest;
    }

    /**
     * Obtiene el interés anual de la cuenta.
     * 
     * @return Tasa de interés anual
     */
    public double getAnnualInterest() {
        return annualInterest;
    }

    /**
     * Establece una nueva tasa de interés anual.
     * 
     * @param annualInterest Nueva tasa de interés en porcentaje
     */
    public void setAnnualInterest(double annualInterest) {
        this.annualInterest = annualInterest;
    }

    /**
     * Calcula y aplica el interés anual a la cuenta.
     * Suma los intereses generados al saldo de la cuenta.
     */
    public void calculateInterest() {
        double interes = getSaldo() * (annualInterest / 100);
        ingresar(interes);
    }

    /**
     * Devuelve la información detallada de la cuenta de ahorro.
     * 
     * @return Información de la cuenta como cadena de texto
     */
    @Override
    public String devolverInfoString() {
        return owner.toString() + ", IBAN: " + IBAN + ", Saldo: " + saldo + "€, Interés anual: " + annualInterest + "%";
    }
}

