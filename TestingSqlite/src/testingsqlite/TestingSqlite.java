/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsqlite;

import java.util.Scanner;

/**
 *
 * @author Urrea
 */
public class TestingSqlite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        main();
    }
    
    private static void main() {
        int opc = 0;
        int id = 0;
        String nombre = "", apellido = "";
        Scanner scan = new Scanner(System.in);
        Alumno alumno = new Alumno();
        while (opc != 6) {
            System.out.println("=========================");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1)Consultar alumnos");
            System.out.println("2)Buscar un alumno");
            System.out.println("3)Insertar un alumno");
            System.out.println("4)Eliminar un alumno");
            System.out.println("5)Actualizar un alumno");
            System.out.println("6)Salir");
            System.out.println("=========================");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    alumno.show(-1);
                    break;
                case 2:
                    System.out.println("Digite la identificacion del alumno:");
                    id = scan.nextInt();
                    alumno.show(id);
                    break;
                case 3:
                    System.out.println("Nombres: ");
                    scan.nextLine();
                    nombre = scan.nextLine();
                    System.out.println("Apellidos: ");
                    apellido = scan.nextLine();
                    Alumno nuevoAlumno = new Alumno(nombre, apellido);
                    nuevoAlumno.save();
                    break;
                case 4:
                    System.out.println("Digite la identificacion del alumno:");
                    id = scan.nextInt();
                    alumno.remove(id);
                    break;
                case 5:
                    System.out.println("Id del alumno a actualizar: ");
                    id = scan.nextInt();
                    System.out.println("Nombres: ");
                    scan.nextLine();
                    nombre = scan.nextLine();
                    System.out.println("Apellidos: ");
                    apellido = scan.nextLine();                    
                    alumno.update(id, nombre, apellido);
                    break;
                case 6:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
    
}
