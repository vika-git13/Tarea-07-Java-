package cuentas;
import bancoapp.Persona;

/**
 * Clase abstracta que representa una cuenta corriente.
 * No tiene intereses, pero permite domiciliar recibos de empresas autorizadas.
 * 
 * @author 38097
 */
public abstract class CuentaCorriente extends CuentaBancaria implements Imprimible {
    private String[] AuthorisedCompany;

    /**
     * Constructor de CuentaCorriente.
     * 
     * @param IBAN Número de cuenta en formato ESNNNNNNNNNNNNNNNNNNNN
     * @param saldo Saldo inicial de la cuenta
     * @param owner Propietario de la cuenta
     * @param AuthorisedCompany Lista de empresas autorizadas para cobrar recibos
     */
    public CuentaCorriente(String IBAN, double saldo, Persona owner, String[] AuthorisedCompany){
        super(IBAN, saldo, owner);
        this.AuthorisedCompany = AuthorisedCompany; 
    }

    /**
     * Obtiene la lista de empresas autorizadas.
     * 
     * @return Array con las empresas autorizadas
     */
    public String[] getAuthorisedCompany(){
        return AuthorisedCompany;
    }

    /**
     * Establece una nueva lista de empresas autorizadas.
     * 
     * @param AuthorisedCompany Nueva lista de empresas
     */
    public void setAuthorisedCompany(String[] AuthorisedCompany){
        this.AuthorisedCompany = AuthorisedCompany;
    }

    /**
     * Agrega una nueva empresa autorizada si hay espacio disponible.
     * 
     * @param companyName Nombre de la empresa a autorizar
     */
    public void addCompany(String companyName){
        if (AuthorisedCompany == null) {
            System.out.println("Error: No company list initialized.");
            return;
        }
        int i = 0;
        while (i < AuthorisedCompany.length) {
            if (AuthorisedCompany[i] == null) {
                AuthorisedCompany[i] = companyName;
                return;
            }
            i++;
        }
        System.out.println("No space available to add more.");
    }   

    /**
     * Lista todas las empresas autorizadas.
     */
    public void listCompany() {
        System.out.println("Authorized Companies:");
        if (AuthorisedCompany == null || AuthorisedCompany.length == 0) {
            System.out.println("No companies authorized.");
            return;
        }
        int i = 0;
        boolean hasCompanies = false;
        while (i < AuthorisedCompany.length) {
            if (AuthorisedCompany[i] != null) {
                System.out.println("- " + AuthorisedCompany[i]);
                hasCompanies = true;
            }
            i++;
        }
        if (!hasCompanies) {
            System.out.println("No companies authorized.");
        }
    }

    /**
     * Devuelve la información de la cuenta corriente como una cadena de caracteres.
     * 
     * @return Información detallada de la cuenta
     */
    @Override
    public String devolverInfoString() {
        String info = owner.toString() + ", IBAN: " + IBAN + ", Saldo: " + saldo + "€";
        info += "\nAuthorized Companies:";
        if (AuthorisedCompany == null || AuthorisedCompany.length == 0) {
            info += " None";
        } else {
            int i = 0;
            while (i < AuthorisedCompany.length) {
                if (AuthorisedCompany[i] != null) {
                    info += "\n- " + AuthorisedCompany[i];
                }
                i++;
            }
        }
        return info;
    }
}
