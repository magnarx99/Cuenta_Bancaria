public class CuentaBancaria {

    // Atributos privados (encapsulamiento)
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private double limiteRetiro;

    // Constructor por defecto
    public CuentaBancaria() {
        titular = "Sin asignar";
        numeroCuenta = "0000";
        saldo = 0;
        limiteRetiro = 500000;
    }

    // Constructor con parámetros
    public CuentaBancaria(String titular, String numeroCuenta, double saldo, double limiteRetiro) {
        this();
        setTitular(titular);
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldo);
        setLimiteRetiro(limiteRetiro);
    }

    // Método de comportamiento 1: retirar dinero
    public void retirar(double monto) {
        if (monto < 0) {
            System.out.println("El monto a retirar debe ser positivo");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente. Saldo disponible: $" + String.format("%.2f", saldo));
        } else if (monto > limiteRetiro) {
            System.out.println("El monto supera el límite de retiro de $" + String.format("%.2f", limiteRetiro));
        } else {
            saldo = saldo - monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + String.format("%.2f", saldo));
        }
    }

    // Método de comportamiento 2: depositar dinero
    // Si el depósito supera $2.000.000 se suma una bonificación del 1% del monto depositado
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser positivo");
        } else {
            saldo = saldo + monto;
            if (monto > 2000000) {
                double bonificacion = monto * 0.01;
                saldo = saldo + bonificacion;
                System.out.println("Bonificación del 1% aplicada: $" + String.format("%.2f", bonificacion));
            }
            System.out.println("Depósito exitoso. Nuevo saldo: $" + String.format("%.2f", saldo));
        }
    }

    // Datos de la cuenta para que se vean en consola :)
    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + String.format("%.2f", saldo));
        System.out.println("Límite de retiro: $" + String.format("%.2f", limiteRetiro));
    }

    // Getters y Setters

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular.trim();
        } else {
            System.out.println("Titular inválido, no puede estar vacío");
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        
        // El número de cuenta solo puede tener dígitos
        
        if (numeroCuenta != null && numeroCuenta.trim().matches("[0-9]+")) {
            this.numeroCuenta = numeroCuenta.trim();
        } else {
            System.out.println("Número de cuenta inválido, solo se permiten números");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo inválido, no puede ser negativo");
        }
    }

    public double getLimiteRetiro() {
        return limiteRetiro;
    }

    public void setLimiteRetiro(double limiteRetiro) {
        if (limiteRetiro > 0) {
            this.limiteRetiro = limiteRetiro;
        } else {
            System.out.println("Límite de retiro inválido, debe ser mayor que 0");
        }
    }
}
