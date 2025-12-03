package cuentas;

import bancoapp.Persona;

/**
 * Clase que representa una cuenta corriente de empresa.
 * Extiende de `CuentaCorriente` y permite descubierto con penalización.
 * 
 * @author 38097
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Imprimible {
    private double maxOverdraft;
    private double interestOverdraft;
    private double commissionOverdraft;

    /**
     * Constructor para CuentaCorrienteEmpresa.
     * 
     * @param IBAN Número IBAN de la cuenta
     * @param saldo Saldo inicial de la cuenta
     * @param owner Propietario de la cuenta
     * @param AuthorisedCompany Lista de empresas autorizadas
     * @param maxOverdraft Límite máximo de descubierto
     * @param interestOverdraft Interés sobre el saldo negativo
     * @param commissionOverdraft Comisión fija por descubierto
     */
    public CuentaCorrienteEmpresa(String IBAN, double saldo, Persona owner, String[] AuthorisedCompany, 
                                  double maxOverdraft, double interestOverdraft, double commissionOverdraft) {
        super(IBAN, saldo, owner, AuthorisedCompany);
        this.maxOverdraft = maxOverdraft;
        this.interestOverdraft = interestOverdraft;
        this.commissionOverdraft = commissionOverdraft;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public double getInterestOverdraft() {
        return interestOverdraft;
    }

    public double getCommissionOverdraft() {
        return commissionOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }

    public void setInterestOverdraft(double interestOverdraft) {
        this.interestOverdraft = interestOverdraft;
    }

    public void setCommissionOverdraft(double commissionOverdraft) {
        this.commissionOverdraft = commissionOverdraft;
    }

    /**
     * Realiza una retirada de dinero, permitiendo descubierto hasta un límite.
     * 
     * @param sum Cantidad a retirar
     * @return true si la operación es exitosa, false si supera el límite de descubierto
     */
    @Override
    public boolean retirar(double sum) {
        if (sum <= saldo) { // Saldo suficiente
            saldo -= sum;
            return true;
        } else {
            double deficit = sum - saldo; 
            if (deficit <= maxOverdraft) { // Permitimos descubierto
                saldo -= sum;
                return true;
            } else {
                System.out.println("Overdraft limit exceeded! Operation denied.");
                return false;
            }
        }
    }

    /**
     * Aplica penalización por descubierto si el saldo es negativo.
     */
    public void applyCommissionOverdraft() {
        if (saldo < 0) {
            double overdraft = -saldo;
            double interest = overdraft * (interestOverdraft / 100);
            double totalPenalty = interest + commissionOverdraft;
            System.out.println("Applying overdraft penalty: " + totalPenalty);
            saldo -= totalPenalty;
        }
    }

    /**
     * Devuelve la información detallada de la cuenta corriente de empresa.
     * 
     * @return Información de la cuenta como cadena de texto
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +
               "\nTipo de cuenta: Corriente Empresa" +
               "\nMaximo descubierto: " + maxOverdraft + "€" +
               "\nInteres por descubierto: " + interestOverdraft + "%" +
               "\nComision fija por descubierto: " + commissionOverdraft + "€";
    }
}
