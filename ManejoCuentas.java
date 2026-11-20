import java.util.ArrayList;
import java.util.Scanner;

public class ManejoCuentas {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        // Lista para almacenar varias cuentas
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== MENÚ CUENTAS BANCARIAS =====");
            System.out.println("1. Crear cuenta por defecto");
            System.out.println("2. Crear cuenta con parámetros");
            System.out.println("3. Modificar atributos de la cuenta");
            System.out.println("4. Visualizar cuentas registradas");
            System.out.println("5. Retirar dinero");
            System.out.println("6. Depositar dinero");
            System.out.println("7. Salir");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    // Crear cuenta con el constructor por defecto
                    cuentas.add(new CuentaBancaria());
                    System.out.println("Cuenta creada correctamente en la posición " + (cuentas.size() - 1));
                    break;

                case 2:
                    // Solicitar los datos de la cuenta
                    String titular = leerTexto("Ingrese titular: ");
                    String numeroCuenta = leerTexto("Ingrese número de cuenta: ");
                    double saldo = leerDouble("Ingrese saldo inicial: ");
                    double limiteRetiro = leerDouble("Ingrese límite de retiro: ");

                    // Crear cuenta con el constructor con parámetros
                    cuentas.add(new CuentaBancaria(titular, numeroCuenta, saldo, limiteRetiro));
                    System.out.println("Cuenta creada con parámetros en la posición " + (cuentas.size() - 1));
                    break;

                case 3:
                    int posicion = pedirPosicion(cuentas);

                    if (posicion != -1) {
                        CuentaBancaria cuenta = cuentas.get(posicion);

                        // Se modifican los atributos usando los setters
                        cuenta.setTitular(leerTexto("Nuevo titular: "));
                        cuenta.setNumeroCuenta(leerTexto("Nuevo número de cuenta: "));
                        cuenta.setSaldo(leerDouble("Nuevo saldo: "));
                        cuenta.setLimiteRetiro(leerDouble("Nuevo límite de retiro: "));

                        System.out.println("Modificación terminada. Los datos válidos quedaron guardados");
                    }
                    break;

                case 4:
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas");
                    } else {
                        // Mostrar todas las cuentas
                        for (int i = 0; i < cuentas.size(); i++) {
                            System.out.println("\nCuenta " + i);
                            cuentas.get(i).mostrarInformacion();
                        }
                    }
                    break;

                case 5:
                    posicion = pedirPosicion(cuentas);

                    if (posicion != -1) {
                        double montoRetiro = leerDouble("Monto a retirar: ");
                        cuentas.get(posicion).retirar(montoRetiro);
                    }
                    break;

                case 6:
                    posicion = pedirPosicion(cuentas);

                    if (posicion != -1) {
                        double montoDeposito = leerDouble("Monto a depositar: ");
                        cuentas.get(posicion).depositar(montoDeposito);
                    }
                    break;

                case 7:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        entrada.close();
    }

    // Pide la posición de una cuenta y verifica que exista
    // Devuelve -1 si la posición no es válida
    public static int pedirPosicion(ArrayList<CuentaBancaria> cuentas) {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas");
            return -1;
        }

        int posicion = leerEntero("Ingrese posición de la cuenta (0 a " + (cuentas.size() - 1) + "): ");

        if (posicion >= 0 && posicion < cuentas.size()) {
            return posicion;
        } else {
            System.out.println("Posición inválida");
            return -1;
        }
    }

    // Lee un número entero; si el usuario escribe letras, lo vuelve a pedir
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!entrada.hasNextInt()) {
            entrada.nextLine();
            System.out.print("Debe ingresar un número entero. " + mensaje);
        }
        int numero = entrada.nextInt();
        entrada.nextLine();
        return numero;
    }

    // Lee un número decimal; si el usuario escribe letras, lo vuelve a pedir
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!entrada.hasNextDouble()) {
            entrada.nextLine();
            System.out.print("Debe ingresar un número. " + mensaje);
        }
        double numero = entrada.nextDouble();
        entrada.nextLine();
        return numero;
    }

    // Lee una línea de texto
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine();
    }
}
