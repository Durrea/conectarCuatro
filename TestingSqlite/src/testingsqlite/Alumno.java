/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsqlite;

/**
 *
 * @author Urrea
 */
public class Alumno {

    private int id;
    private String nombre, apellidos;

    Conector con = new Conector();

    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void save() {
        con.connect();
        con.saveAlumno(this);
        con.close();
    }

    public void show(int id) {
        con.connect();
        if (id != -1) {
            con.mostrarAlumno(id);
        } else {
            con.mostrarAlumnos();
        }
        con.close();
    }

    public void remove(int id) {
        con.connect();
        con.eliminarAlumno(id);
        con.close();
    }
    
    public void update(int id, String nombre, String apellido){
        con.connect();
        con.actualizarAlumno(id, nombre, apellido);
        con.close();
    }
}
