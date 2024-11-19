package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Administrador {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasenia;

    public Administrador(String nombre, String apellido, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public void registrarEmpleado(ArrayList<Empleado> empleados, Empleado nuevoEmpleado) {
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado registrado: " + nuevoEmpleado.getNombre());
    }

    public void actualizarEmpleado(Empleado empleado, String nuevoNombre, String nuevoApellido) {
        empleado.setNombre(nuevoNombre);
        empleado.setApellido(nuevoApellido);
        System.out.println("Datos del empleado actualizados: " + empleado.getNombre() + " " + empleado.getApellido());
    }

    public void bloquearEmpleado(ArrayList<Empleado> empleados, Empleado empleadoABloquear) {
        if (empleados.remove(empleadoABloquear)) {
            System.out.println("Empleado bloqueado: " + empleadoABloquear.getNombre());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void generarReporte(ArrayList<Transaccion> transacciones, String fechaInicio, String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        LocalDate fechaInicioLocalDate = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaFinLocalDate = LocalDate.parse(fechaFin, formatter);
    
        System.out.println("Generando reporte de transacciones desde " + fechaInicio + " hasta " + fechaFin);
    
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getFecha().compareTo(fechaInicioLocalDate) >= 0 &&
                transaccion.getFecha().compareTo(fechaFinLocalDate) <= 0) {
                System.out.println(transaccion);
            }
        }
    }

    public boolean verificarCredenciales(String usuarioIngresado, String contraseniaIngresada) {
        return this.usuario.equals(usuarioIngresado) && this.contrasenia.equals(contraseniaIngresada);
    }

    public String recuperarcontrasenia(String preguntaSeguridad, String respuesta) {
        String respuestaCorrecta = "Pizza";
        if (respuesta.equalsIgnoreCase(respuestaCorrecta)) {
            return contrasenia;
        } else {
            return "Respuesta incorrecta.";
        }
    }

    @Override
    public String toString() {
        return "Administrador [nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrasenia="
                + contrasenia + "]";
    }
    
}
