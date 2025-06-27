
/**
 *
 * @author franc
 */
public class Problema6_CuentaBanco {
    public static void main(String[] args) {
        CuentaCheques cc = new CuentaCheques("CH-001", "Juan Pérez");
        CuentaAhorros ca = new CuentaAhorros("AH-002", "María Gómez");
        CuentaPlatino cp = new CuentaPlatino("PL-003", "Carlos Ruiz");


        cc.depositar(1000);
        cc.retirar(1500);

        ca.depositar(2000);
        ca.retirar(500);
        ca.calcularInteres();

        cp.depositar(3000);
        cp.retirar(4000);
        cp.calcularInteres();

        System.out.println("=== Estado de Cuentas ===");
        System.out.printf("%s (%s): $%.2f%n", cc.numero, cc.cliente, cc.balance);
        System.out.printf("%s (%s): $%.2f%n", ca.numero, ca.cliente, ca.balance);
        System.out.printf("%s (%s): $%.2f%n", cp.numero, cp.cliente, cp.balance);
    }
}

class Cuenta {
    public String numero;
    public String cliente;
    public double balance;

    public Cuenta(String numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.balance = 0.0;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            balance += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && balance >= monto) {
            balance -= monto;
            return true;
        }
        return false;
    }
}

class CuentaCheques extends Cuenta {
    public CuentaCheques(String numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean retirar(double monto) {

        if (monto > 0) {
            balance -= monto;
            return true;
        }
        return false;
    }
}

class CuentaAhorros extends Cuenta {
    public double interes = 0.05;

    public CuentaAhorros(String numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean retirar(double monto) {

        if (monto > 0 && balance >= monto) {
            balance -= monto;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        balance += balance * interes;
    }
}

class CuentaPlatino extends Cuenta {
    public double interes = 0.10;

    public CuentaPlatino(String numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto > 0) {
            balance -= monto;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        balance += balance * interes;
    }
}


