package co.edu.uniquindio.biblioteca.parcial_1.ejercicio_2FincaUQ;

import co.edu.uniquindio.biblioteca.parcial_1.model.*;
import co.edu.uniquindio.biblioteca.parcial_1.model.enumeracion.TipoContrato;

import java.util.Date;
import java.util.List;


public class MainFincaUQ {
    public static void main(String[] args){
        FincaUQ fincaUQ = inicializarDatosPrueba();


        //CRUD Empleado

        //Crear
        crearEmpleado(2,"Sara", "Mendez",
                "1016874393", 23, 1150000,
                8, TipoContrato.MEDIO_TIEMPO, fincaUQ);
        crearEmpleado(1,"Daniel", "Quintero",
                "1094435405", 18, 800000,
                10, TipoContrato.HORAS, fincaUQ);
        crearEmpleado(3,"Fabián", "Gallego",
                "1098432309", 32, 1000000,
                8, TipoContrato.TIEMPO_COMPLETO,fincaUQ);
        crearEmpleado(2, "Alba", "Suarez",
                "1094238594", 28, 1500000,
                8, TipoContrato.HORAS, fincaUQ);
        crearEmpleado(1,"Luis", "Sanchez",
                "1024490348", 20, 900000,
                10, TipoContrato.MEDIO_TIEMPO,fincaUQ);

        //Read
        fincaUQ.mostrarInformacionTipoEmpleado(3);
        System.out.println("Informacion de los empleados:");
        mostrarInformacionEmpleados(fincaUQ);

        //Delate
        eliminarEmpleado("1739748303", fincaUQ);
        System.out.println("-----> Información luego de eliminar:");
        mostrarInformacionEmpleados(fincaUQ);

        //Update
        actualizarEmpleado("1024490348", "Santiago",
                "Ospina", 19, 1100000,
                8,TipoContrato.TIEMPO_COMPLETO ,fincaUQ);

        System.out.println("-----> Información luego de actualizar");
        mostrarInformacionEmpleados(fincaUQ);

        Date fechaInicio = new Date(23,9,23,19,9);
        Date fechaFin = new Date(23,9,24,15,9);
        Date fechaInicio2 = new Date(23, 7, 20,6,20);
        Date fechaInicio3 = new Date(23, 7, 15,10,10);
        Date fechaFin3 = new Date(23, 8, 15, 22, 0);

        fincaUQ.crearTarea(1, "1016874393", fechaInicio,
                fechaFin, "Sembrar plantas");
        fincaUQ.crearTarea(2, "1094238594", fechaInicio2,
                fechaFin3, "Recoger café" );
        fincaUQ.crearTarea(3, "1098432309", fechaInicio3,
                fechaFin3, "Administrar dinero" );

        mostrarInformacionTareas(fincaUQ);

    }

    private static FincaUQ inicializarDatosPrueba() {
        FincaUQ fincaUQ = new FincaUQ();
        fincaUQ.setNombre("El Paraíso");

        return fincaUQ;
    }

    private static void crearEmpleado(int tipoEmpleado, String nombre, String apellido,
                                      String cedula, int edad, double salario,
                                      int numeroHorasTrabajo, TipoContrato tipoContrato,
                                      FincaUQ fincaUQ) {
        fincaUQ.crearEmpleado(tipoEmpleado,nombre,apellido,cedula,edad,
                salario,numeroHorasTrabajo,tipoContrato);
    }

    private static void mostrarInformacionEmpleados(FincaUQ fincaUQ) {
        List<Empleado> listaEmpleados = fincaUQ.obtenerEmpleados();
        int tamanoLista = listaEmpleados.size();
        for (int i = 0; i < tamanoLista; i ++){
            Empleado empleado = listaEmpleados.get(i);
            System.out.println(empleado.toString());
        }
    }

    private static void eliminarEmpleado(String cedula, FincaUQ fincaUQ) {

        fincaUQ.eliminarEmpleado(cedula);
    }

    private static void actualizarEmpleado(String cedula,String nuevoNombre,
                                           String nuevoApellido, int nuevaEdad,
                                           double nuevoSalario , int nuevoNumeroHoras,
                                           TipoContrato nuevoContrato,
                                           FincaUQ fincaUQ) {

        fincaUQ.actualizarEmpleado(cedula, nuevoNombre, nuevoApellido,
                nuevaEdad, nuevoSalario, nuevoNumeroHoras, nuevoContrato);
    }

    private static void mostrarInformacionTareas(FincaUQ fincaUQ) {
        List<Tarea> listaTareas = fincaUQ.obtenerTareas();
        int tamanoLista = listaTareas.size();
        for (int i = 0; i < tamanoLista; i ++){
            Tarea tarea = listaTareas.get(i);
            System.out.println(tarea.toString());
        }
    }
}