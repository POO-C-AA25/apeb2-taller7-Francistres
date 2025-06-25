
/**
 *Se desea desarrollar un sistema de nómina para los trabajadores de una empresa. 
 * Los datos personales de los trabajadores son nombre y apellidos, dirección y DNI. 
 * Además, existen diferentes tipos de trabajadores:

 *Fijos Mensuales: que cobran una cantidad fija al mes.
 *Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
 *Por Horas: cobran un precio por cada una de las horas que han realizado durante el mes. El precio es fijo para las primeras 40 horas y es otro para las horas realizadas a partir de la 40 hora mensual.
 *Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). El programa debe permitir dar de alta a trabajadores, así como fijar horas o ventas realizadas e imprimir la nómina correspondiente al final de mes.
Note
 *Diseñe la jerarquia de clases UML basado en herencia, que defina de mejor forma el escenario planteado.
 *Para probar el diseño de clases, instancia en el clase de prueba Ejecutor (la-s clase-s respectiva-s), con datos aleatorios.
 *En los escenarios de prueba verifique su solución con al menos 2 tipos de trabajadores.
 * @author Francis Tapia
 */

public class Problema4_NominaTrabajadores {
        public static void main(String[] args) {
        Jefe jefe1 = new Jefe("Carlos", "Gómez", "Calle 123", "11111111A", 5000.0);

        FijoMensual empleado1 = new FijoMensual("Ana", "López", "Av. Principal", "22222222B", jefe1, 2500.0);
        Comisionista empleado2 = new Comisionista("Pedro", "Martínez", "Calle Secundaria", "33333333C", jefe1, 5.0);
        empleado2.ventasRealizadas = 10000.0;

        PorHoras empleado3 = new PorHoras("Luisa", "Rodríguez", "Plaza Central", "44444444D", jefe1, 15.0, 20.0);
        empleado3.horasTrabajadas = 45;

        
        System.out.println("Nómina Jefe: " + jefe1.calcularNomina());
        System.out.println("Nómina Fijo Mensual: " + empleado1.calcularNomina());
        System.out.println("Nómina Comisionista: " + empleado2.calcularNomina());
        System.out.println("Nómina Por Horas: " + empleado3.calcularNomina());
    }
}

class Trabajador {
    public String nombre;
    public String apellidos;
    public String direccion;
    public String dni;
    public Trabajador jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public double calcularNomina() {
        return 0.0;
    }
}

class FijoMensual extends Trabajador {
    public double sueldoFijo;

    public FijoMensual(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularNomina() {
        return sueldoFijo;
    }
}

class Comisionista extends Trabajador {
    public double ventasRealizadas;
    public double porcentajeComision;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double porcentajeComision) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularNomina() {
        return ventasRealizadas * (porcentajeComision / 100);
    }
}

class PorHoras extends Trabajador {
    public int horasTrabajadas;
    public double precioHoraNormal;
    public double precioHoraExtra;

    public PorHoras(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double precioHoraNormal, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.precioHoraNormal = precioHoraNormal;
        this.precioHoraExtra = precioHoraExtra;
    }

    @Override
    public double calcularNomina() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioHoraNormal;
        } else {
            return (40 * precioHoraNormal) + ((horasTrabajadas - 40) * precioHoraExtra);
        }
    }
}

class Jefe extends Trabajador {
    public double sueldoFijo;

    public Jefe(String nombre, String apellidos, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni, null);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularNomina() {
        return sueldoFijo;
    }
}


