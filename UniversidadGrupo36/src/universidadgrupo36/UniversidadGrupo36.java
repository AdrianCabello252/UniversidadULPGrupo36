
package universidadgrupo36;

import java.time.LocalDate;
import universidadgrupo36.AccesoADatos.AlumnoData;
import universidadgrupo36.Entidades.Alumno;

public class UniversidadGrupo36 {

   
    public static void main(String[] args) {
        
 
        AlumnoData aluData=new AlumnoData();//para usar metodos de alumno data
//    Prueba agregar
        Alumno jony=new Alumno(2,2435244, "gabriel", "Zerpa", LocalDate.of(1992, 2, 7), true);
        aluData.guardarAlumno(jony);
//    Prueba buscar id/dni
        Alumno alumnoEncontrado= aluData.buscarAlumno(2);
//        Alumno alumnoEncontrado= alu.buscarAlumnoPorDni(2435244);
        System.out.println("DNI "+alumnoEncontrado.getDni());
        System.out.println("Apellido "+alumnoEncontrado.getApellido());
//    Prueba listar
        for(Alumno alumno:aluData.listarAlumnos()){
            System.out.println(alumno.getDni());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getApellido());
        }
        aluData.listarAlumnos();
//    Prueba modificar
        aluData.modificarAlumno(jony);
//    prueba eliminar
        aluData.eliminarAlumno(2);
    }
    
}
