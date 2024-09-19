package co.edu.uniquindio.biblioteca.parcial_1.model;

import co.edu.uniquindio.biblioteca.parcial_1.model.enumeracion.TipoContrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FincaUQ {
    private String nombre;
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Tarea> listaTareas = new ArrayList<>();

    /*Constructor*/
    public FincaUQ() {
    }

    public FincaUQ(String nombre) {
        this.nombre = nombre;
    }

    /*Getters and Setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void crearEmpleado( int tipoEmpleado, String nombre, String apellido,
                               String cedula, int edad, double salario,
                               int numeroHorasTrabajo, TipoContrato tipoContrato) {

        int resultadoBusqueda = devolverPosicionEmpleado(cedula);
        if (resultadoBusqueda == -1){
            if (tipoEmpleado == 1){
                Jornalero jornalero = new Jornalero();
                jornalero.setNombre(nombre);
                jornalero.setApellido(apellido);
                jornalero.setCedula(cedula);
                jornalero.setEdad(edad);
                jornalero.setSalario(salario);
                jornalero.setNumeroHorasTrabajo(numeroHorasTrabajo);
                jornalero.setTipoContrato(tipoContrato);
                getListaEmpleados().add(jornalero);
                System.out.println("Empleado creado exitosamente");


            } else if (tipoEmpleado == 2) {
                Recolector recolector = new Recolector();
                recolector.setNombre(nombre);
                recolector.setApellido(apellido);
                recolector.setCedula(cedula);
                recolector.setEdad(edad);
                recolector.setSalario(salario);
                recolector.setNumeroHorasTrabajo(numeroHorasTrabajo);
                recolector.setTipoContrato(tipoContrato);
                getListaEmpleados().add(recolector);
                System.out.println("Empleado creado exitosamente");


            }
            else if (tipoEmpleado == 3){
                Administrador administrador = new Administrador();
                administrador.setNombre(nombre);
                administrador.setApellido(apellido);
                administrador.setCedula(cedula);
                administrador.setEdad(edad);
                administrador.setSalario(salario);
                administrador.setNumeroHorasTrabajo(numeroHorasTrabajo);
                administrador.setTipoContrato(tipoContrato);
                getListaEmpleados().add(administrador);
                System.out.println("Empleado creado exitosamente");

            }
            else
                System.out.println("Ingrese un valor válido");


        }else {
            System.out.println("El empleado ya está creado en el sistema");
        }
    }

    public List<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    public int devolverPosicionEmpleado(String cedula) {
        int posicion = -1;
        boolean bandera = false;
        for(int i = 0; i < listaEmpleados.size() && bandera == false; i++) {
            if(listaEmpleados.get(i).getCedula().equalsIgnoreCase(cedula)) {
                bandera = true;
                posicion = i;
            }
        }
        return posicion;
    }

    public void eliminarEmpleado(String cedula) {
        for (Empleado empleado : listaEmpleados){
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                getListaEmpleados().remove(empleado);
                break;
            }
        }
    }

    public void actualizarEmpleado(String cedula, String nuevoNombre,
                                   String nuevoApellido, int nuevaEdad,
                                   double nuevoSalario, int nuevoNumeroHoras,
                                   TipoContrato tipoContrato) {

        for (Empleado empleado : listaEmpleados){
            if (empleado.getCedula().equals(cedula)){
                empleado.setNombre(nuevoNombre);
                empleado.setApellido(nuevoApellido);
                empleado.setEdad(nuevaEdad);
                empleado.setSalario(nuevoSalario);
                empleado.setNumeroHorasTrabajo(nuevoNumeroHoras);
                empleado.setTipoContrato(tipoContrato);
                break;
            }
        }
    }

    public void mostrarInformacionTipoEmpleado(int tipoEmpleado) {

        for (Empleado empleado : getListaEmpleados() ) {
            if (tipoEmpleado == 0){
                System.out.println(empleado.toString());
            }
            if (tipoEmpleado == 1 && empleado instanceof Jornalero){
                System.out.println(empleado);
            } else if (tipoEmpleado == 2 && empleado instanceof Recolector) {
                System.out.println(empleado);
            } else if (tipoEmpleado == 3 && empleado instanceof Administrador) {
                System.out.println(empleado);

            }
        }
    }

    public void crearTarea(int numeroTarea, String cedulaEmpleado, Date fechaInicio,
                           Date fechaFin, String descripcion) {
        Tarea tarea = new Tarea();
        tarea.setNumeroTarea(numeroTarea);
        tarea.setFechaInicio(fechaInicio);
        tarea.setFechaFin(fechaFin);
        tarea.calcularDuracion();
        tarea.setDescripcion(descripcion);

        Empleado empleado = obtenerEmpleado(cedulaEmpleado);

        if (empleado != null){
            tarea.setEmpleadoAsociado(empleado);
        }
        getListaTareas().add(tarea);
    }

    private Empleado obtenerEmpleado(String cedulaEmpleado) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getCedula().equals(cedulaEmpleado)) {
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;

    }

    public List<Tarea> obtenerTareas() {
        return getListaTareas();
    }
}