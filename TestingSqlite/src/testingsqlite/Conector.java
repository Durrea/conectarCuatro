/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsqlite;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urrea
 */
public class Conector {

    String url = "C:\\Users\\PERSONAL\\test.db";
    Connection connect;

    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                //System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumno (nombre, apellido) values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void mostrarAlumnos() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumno");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));

                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellido"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void eliminarAlumno(int id) {
        try {
            PreparedStatement st = connect.prepareStatement("delete from alumno where id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    void mostrarAlumno(int id) {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumno where id = ?");
            st.setInt(1, id);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));

                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellido"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    void actualizarAlumno(int id, String nombre, String apellido) {
        try {
            PreparedStatement st = connect.prepareStatement("update alumno set nombre=? , apellido = ? where id = ?");
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setInt(3, id);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
