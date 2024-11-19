package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private String nombre;
    private String direccion;
    private List<Vehiculo> vehiculos;
    private List<Transaccion> transacciones;
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    private Administrador administrador;

    public Concesionario(String nombre, String direccion, Administrador administrador) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.vehiculos = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.administrador = administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.getNombre());
    }

    public void eliminarEmpleado(Empleado empleado) {
        if (empleados.remove(empleado)) {
            System.out.println("Empleado eliminado: " + empleado.getNombre());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void actualizarEmpleado(Empleado empleado, String nuevoNombre, String nuevoApellido) {
        empleado.setNombre(nuevoNombre);
        empleado.setApellido(nuevoApellido);
        System.out.println("Empleado actualizado: " + empleado.getNombre() + " " + empleado.getApellido());
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado: " + cliente.getNombre());
    }

    public void eliminarCliente(Cliente cliente) {
        if (clientes.remove(cliente)) {
            System.out.println("Cliente eliminado: " + cliente.getNombre());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void actualizarCliente(Cliente cliente, String nuevoNombre, String nuevoEmail) {
        cliente.setNombre(nuevoNombre);
        cliente.setEmail(nuevoEmail);
        System.out.println("Cliente actualizado: " + cliente.getNombre());
    }

    public void actualizarAdministrador(String nuevoNombre, String nuevoApellido, String nuevoUsuario,
            String nuevaContrasenia) {
        administrador.setNombre(nuevoNombre);
        administrador.setApellido(nuevoApellido);
        administrador.setUsuario(nuevoUsuario);
        administrador.setContrasenia(nuevaContrasenia);
        System.out
                .println("Administrador actualizado: " + administrador.getNombre() + " " + administrador.getApellido());
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado al inventario: " + vehiculo.obtenerInformacion());
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.remove(vehiculo)) {
            System.out.println("Vehículo eliminado del inventario: " + vehiculo.obtenerInformacion());
        } else {
            System.out.println("El vehículo no se encontró en el inventario.");
        }
    }

    public void mostrarInventario() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el inventario.");
        } else {
            System.out.println("Inventario del concesionario:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo.obtenerInformacion());
            }
        }
    }

    public void registrarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        System.out.println("Transacción registrada: " + transaccion.toString());
    }

    public void mostrarTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("Historial de transacciones:");
            for (Transaccion transaccion : transacciones) {
                System.out.println(transaccion);
            }
        }
    }

    public static void main(String[] args) {
        Administrador administrador = new Administrador("Carlos", "Martínez", "admin", "1234");

        Concesionario concesionario = new Concesionario("AutoCentro", "Calle Principal 123", administrador);

        Empleado empleado1 = new Empleado("E001", "María", "Gómez", "maria.gomez@email.com", "password123");
        Empleado empleado2 = new Empleado("E002", "Luis", "Pérez", "luis.perez@email.com", "password456");

        concesionario.agregarEmpleado(empleado1);
        concesionario.agregarEmpleado(empleado2);

        concesionario.actualizarEmpleado(empleado1, "María Fernanda", "Gómez");

        Cliente cliente1 = new Cliente("Juan Pérez", "1090278936", "3237898398", "juami.kondog@gmaiñ.com");
        Cliente cliente2 = new Cliente("Ana López", "1902837232", "6722445678", "analo.gomz@gmail.com");

        concesionario.agregarCliente(cliente1);
        concesionario.agregarCliente(cliente2);

        concesionario.actualizarCliente(cliente1, "Juan Pablo Pérez", "juan.pablo@email.com");

        Vehiculo moto = new Moto(
                TipoCombustible.GASOLINA,
                "Yamaha",
                true,
                "MT-09",
                6,
                225,
                847,
                false,
                10000,
                50,
                9000);

        concesionario.agregarVehiculo(moto);

        Vehiculo hibrido = new Hibrido(
                TipoCombustible.HIBRIDO,
                "Ford",
                true,
                "Fusion Hybrid",
                6,
                180,
                2000,
                true,
                25000,
                100,
                23000,
                true,
                false);

        concesionario.agregarVehiculo(hibrido);

        Vehiculo electrico = new Electrico(
                TipoCombustible.ELECTRICO,
                "Tesla",
                true,
                "Model 3",
                1,
                250,
                0,
                true,
                35000,
                120,
                30000,
                500,
                1.5);

        concesionario.agregarVehiculo(electrico);

        concesionario.mostrarInventario();

        empleado1.venderVehiculo(cliente1, moto);
        concesionario.registrarTransaccion(
                new Transaccion("Venta", moto, cliente1, empleado1, LocalDate.now(), moto.getPrecioVenta()));

        concesionario.mostrarTransacciones();
    }
}