package bancoapp;
import cuentas.CuentaAhorro;
import cuentas.CuentaCorrienteEmpresa;
import cuentas.CuentaCorrientePersonal;
import utils.Validar;
import java.util.Scanner;

/**
 * Clase principal que gestiona la interacción con el usuario.
 * 
 * @author 38097
 */
public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner in = new Scanner(System.in);
        int option = 0;
        
        while (option != 7) {
            menu();
            System.out.print("Give option: ");
            option = in.nextInt();
            in.nextLine(); // Evita problemas con nextLine() después de nextInt()

            switch (option) {
                case 1:
                    System.out.print("Give me nombre: ");
                    String nombre = in.nextLine();
                    System.out.print("Give me apellidos: ");
                    String apellidos = in.nextLine();
                    
                    boolean validDNI = false;
                    String dni = "";
                    while (!validDNI) {
                        System.out.print("Give me DNI (NNNNNNNNF): ");
                        dni = in.nextLine();
                        validDNI = Validar.validarDni(dni);
                    }

                    Persona owner = new Persona(nombre, apellidos, dni);

                    boolean validIBAN = false;
                    String iban = "";
                    while (!validIBAN) {
                        System.out.print("Give me IBAN: ");
                        iban = in.nextLine();
                        validIBAN = Validar.validarIBAN(iban);
                    }

                    System.out.print("Give me saldo: ");
                    double saldo = in.nextDouble();
                    in.nextLine();

                    System.out.println("Choose an option\n1) Cuenta Ahorro\n2) Cuenta Corriente Personal\n3) Cuenta Corriente Empresa");
                    int opt = in.nextInt();
                    in.nextLine();

                    switch (opt) {
                        case 1:
                            System.out.print("Give me annualInterest: ");
                            double annualInterest = in.nextDouble();
                            in.nextLine();
                            CuentaAhorro cuentaAhorro = new CuentaAhorro(iban, saldo, owner, annualInterest);
                            banco.agregarCuenta(cuentaAhorro);
                            System.out.println("DONE");
                            break;

                        case 2:
                            System.out.print("Give me commission: ");
                            double commission = in.nextDouble();
                            in.nextLine();
                            System.out.print("How many authorized companies (0-5)? ");
                            int numCompanies = in.nextInt();
                            in.nextLine();

                            String[] authorizedCompanies = new String[numCompanies];
                            for (int i = 0; i < numCompanies; i++) {
                                System.out.print("Enter company " + (i + 1) + ": ");
                                authorizedCompanies[i] = in.nextLine();
                            }

                            CuentaCorrientePersonal cuentaPersonal = new CuentaCorrientePersonal(iban, saldo, owner, authorizedCompanies, commission);
                            banco.agregarCuenta(cuentaPersonal);
                            System.out.println("DONE");
                            break;

                        case 3:
                            System.out.print("Give me maxOverdraft: ");
                            double maxOverdraft = in.nextDouble();
                            System.out.print("Give me interestOverdraft: ");
                            double interestOverdraft = in.nextDouble();
                            System.out.print("Give me commissionOverdraft: ");
                            double commissionOverdraft = in.nextDouble();
                            in.nextLine();
                            
                            System.out.print("How many authorized companies (0-5)? ");
                            int numCompan = in.nextInt();
                            in.nextLine();

                            String[] authorizedCompan = new String[numCompan];
                            for (int i = 0; i < numCompan; i++) {
                                System.out.print("Enter company " + (i + 1) + ": ");
                                authorizedCompan[i] = in.nextLine();
                            }

                            CuentaCorrienteEmpresa cuentaEmpresa = new CuentaCorrienteEmpresa(iban, saldo, owner, authorizedCompan, maxOverdraft, interestOverdraft, commissionOverdraft);
                            banco.agregarCuenta(cuentaEmpresa);
                            System.out.println("DONE!");
                            break;

                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                    break;

                case 2:
                    String[] listado = banco.listadoCuentas();
                    if (listado.length != 0) {
                        for (String cuenta : listado) {
                            System.out.println(cuenta);
                        }
                    } else {
                        System.out.println("No accounts found.");
                    }
                    break;

                case 3:
                    validIBAN = false;
                    String ibanConsulta = "";
                    while (!validIBAN) {
                        System.out.print("Give me IBAN: ");
                        ibanConsulta = in.nextLine();
                        validIBAN = Validar.validarIBAN(ibanConsulta);
                    }
                    System.out.println(banco.informacionCuenta(ibanConsulta));
                    break;

                case 4:
                    validIBAN = false;
                    String ibanCon = "";
                    while (!validIBAN) {
                        System.out.print("Give me IBAN: ");
                        ibanCon = in.nextLine();
                        validIBAN = Validar.validarIBAN(ibanCon);
                    }
                    System.out.print("Enter amount to deposit: ");
                    double cantidad = in.nextDouble();
                    in.nextLine();

                    boolean success = banco.ingresoCuenta(ibanCon, cantidad);
                    System.out.println(success ? "Done" : "No se pudo realizar el ingreso.");
                    break;

                case 5:
                    validIBAN = false;
                    String ibanRetiro = "";
                    while (!validIBAN) {
                        System.out.print("Give me IBAN: ");
                        ibanRetiro = in.nextLine();
                        validIBAN = Validar.validarIBAN(ibanRetiro);
                    }

                    cantidad = 0;
                    while (cantidad <= 0) {
                        System.out.print("Enter sum: ");
                        cantidad = in.nextDouble();
                        in.nextLine();
                    }

                    success = banco.retiradaCuenta(ibanRetiro, cantidad);
                    System.out.println(success ? "Done." : "No se pudo realizar el retiro.");
                    break;

                case 6:
                    validIBAN = false;
                    String ibanSaldo = "";
                    while (!validIBAN) {
                        System.out.print("Give me IBAN: ");
                        ibanSaldo = in.nextLine();
                        validIBAN = Validar.validarIBAN(ibanSaldo);
                    }
                    double Saldo = banco.obtenerSaldo(ibanSaldo);
                    System.out.println(Saldo == -1 ? "No such IBAN." : "Saldo actual: " + Saldo + " EUR.");
                    break;

                case 7:
                    System.out.println("Gracias por usar el banco. ¡Hasta luego!");
                    System.exit(0); // **Программа корректно завершает работу**
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("----------------------------------------------------");
        System.out.println("1. Abrir una nueva cuenta.");
        System.out.println("2. Ver un listado de cuentas disponibles.");
        System.out.println("3. Obtener los datos de una cuenta concreta.");
        System.out.println("4. Realizar un ingreso en una cuenta.");
        System.out.println("5. Retirar efectivo de una cuenta.");
        System.out.println("6. Consultar el saldo actual de una cuenta.");
        System.out.println("7. Salir de la aplicación.");
    }
}