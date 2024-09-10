package co.edu.uniquindio.biblioteca.parcial_1.model;

import co.edu.uniquindio.biblioteca.parcial_1.model.enumeracion.TipoContrato;


public class Empleado {

    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private double salario;
    private int numeroHorasTrabajo;
    private TipoContrato tipoContrato;
    FincaUQ ownedByFincaUQ;

    /*Constructor*/

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula, int edad, double salario, int numeroHorasTrabajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.salario = salario;
        this.numeroHorasTrabajo = numeroHorasTrabajo;
    }

    /*Getters and setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumeroHorasTrabajo() {
        return numeroHorasTrabajo;
    }

    public void setNumeroHorasTrabajo(int numeroHorasTrabajo) {
        this.numeroHorasTrabajo = numeroHorasTrabajo;
    }

    public FincaUQ getOwnedByFincaUQ() {
        return ownedByFincaUQ;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public void setOwnedByFincaUQ(FincaUQ ownedByFincaUQ) {
        this.ownedByFincaUQ = ownedByFincaUQ;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", numeroHorasTrabajo=" + numeroHorasTrabajo +
                ", tipoContrato=" + tipoContrato +
                '}';
    }
}
