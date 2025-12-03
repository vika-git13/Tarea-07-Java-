package cuentas;
import bancoapp.Persona;
/**
 * @author Viktoriia Bohoslavska
 */
/**
 * Clase abstracta que representa una cuenta bancaria genérica.
 * Proporciona funcionalidades básicas como ingreso y retiro de saldo.
 * Implementa la interfaz Imprimible.
 * 
 * @author Viktoriia Bohoslavska
 */
public abstract class CuentaBancaria implements Imprimible {
    protected String IBAN;
    protected double saldo;
    protected Persona owner;

    /**
     * Constructor para crear una cuenta bancaria.
     * 
     * @param IBAN   Número de cuenta en formato ESNNNNNNNNNNNNNNNNNNNN
     * @param saldo  Saldo inicial de la cuenta
     * @param owner  Propietario de la cuenta
     */
    public CuentaBancaria(String IBAN, double saldo, Persona owner) {
        this.IBAN = IBAN;
        this.saldo = saldo;
        this.owner = owner;
    }

    /**
     * @return Número IBAN de la cuenta
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * @return Saldo actual de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return Propietario de la cuenta
     */
    public Persona getOwner() {
        return owner;
    }

    /**
     * Establece un nuevo número IBAN.
     * 
     * @param IBAN Nuevo IBAN
     */
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    /**
     * Establece un nuevo saldo.
     * 
     * @param saldo Nuevo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Establece un nuevo propietario de la cuenta.
     * 
     * @param owner Nuevo propietario
     */
    public void setOwner(Persona owner) {
        this.owner = owner;
    }

    /**
     * Método para ingresar dinero en la cuenta.
     * 
     * @param sum Cantidad a ingresar
     * @return true si el ingreso fue exitoso, false si la cantidad es negativa o 0
     */
    public boolean ingresar(double sum) {
        if (sum <= 0) {
            System.out.println("La cantidad a ingresar debe ser mayor que 0.");
            return false;
        }
        this.saldo += sum;
        return true;
    }

    /**
     * Método para retirar dinero de la cuenta.
     * 
     * @param sum Cantidad a retirar
     * @return true si el retiro fue exitoso, false si el saldo es insuficiente
     */
    public boolean retirar(double sum) {
        if (this.saldo < sum) {
            System.out.println("No tienes suficiente saldo para realizar esta operación.");
            return false;
        }
        this.saldo -= sum;
        return true;
    }

    /**
     * Devuelve la información básica de la cuenta bancaria.
     * 
     * @return Cadena con la información de la cuenta
     */
    @Override
    public String devolverInfoString() {
        return owner.toString() + ", IBAN: " + IBAN + ", Saldo: " + String.format("%.2f", saldo) + "€";
    }

    /**
     * Método toString que devuelve la información de la cuenta bancaria.
     * 
     * @return Cadena con la información de la cuenta bancaria
     */
    @Override
    public String toString() {
        return devolverInfoString();
    }
}
