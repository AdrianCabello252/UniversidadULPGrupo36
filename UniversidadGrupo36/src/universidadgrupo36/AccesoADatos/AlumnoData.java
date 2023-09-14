
package universidadgrupo36.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; //para la funcion listas
import javax.swing.JOptionPane;
import universidadgrupo36.Entidades.Alumno;

public class AlumnoData {
    private Connection con=null;
    public AlumnoData(){
        con=Conexion.getConexion();
    }
    public void guardarAlumno(Alumno alumno){
        String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
                + "VALUES(?,?,?,?,?)";
        try {
             PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
             ps.setInt(1, alumno.getDni());
             ps.setString(2, alumno.getApellido());
             ps.setString(3, alumno.getNombre());
             ps.setDate(4,Date.valueOf(alumno.getFechaNac()));
             ps.setBoolean(5, alumno.isActivo());
             ps.executeUpdate();
             
             ResultSet rs=ps.getGeneratedKeys();
             
             if(rs.next()){
                 alumno.setIdAlumno(rs.getInt(1)); //se toma la columna nro 1 donde se encuentran los ID
                 JOptionPane.showMessageDialog(null, "Alumno guardado");
             }
             ps.close(); //para cerrar el objeto
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
    }
    public Alumno buscarAlumno(int idAlumno){
        String sql="select dni,apellido,nombre,fechaNac from alumno where idAlumno=? and estado=1";
        Alumno alumno=null;
        try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs=ps.executeQuery();
             if(rs.next()){
                 alumno=new Alumno();
                 alumno.setIdAlumno(idAlumno);
                 alumno.setDni(rs.getInt("dni"));
                 alumno.setApellido(rs.getString("apellido"));
                 alumno.setNombre(rs.getString("nombre"));
                 alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                 alumno.setActivo(true);
             }else{
                 JOptionPane.showMessageDialog(null, "No existe alumno");
             }
             ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        String sql="select idAlumno, dni,apellido,nombre,fechaNac from alumno where dni=? and estado=1";
        Alumno alumno=null;
        try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, dni);
             ResultSet rs=ps.executeQuery();
             if(rs.next()){
                 alumno=new Alumno();
                 alumno.setIdAlumno(rs.getInt("idAlumno"));
                 alumno.setDni(rs.getInt("dni"));
                 alumno.setApellido(rs.getString("apellido"));
                 alumno.setNombre(rs.getString("nombre"));
                 alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                 alumno.setActivo(true);
             }else{
                 JOptionPane.showMessageDialog(null, "No existe alumno");
             }
             ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
        return alumno;
    }
    
    public List<Alumno> listarAlumnos(){  //objeto tipo lista
        String sql="select idAlumno, dni, apellido, nombre, fechaNac from alumno where estado=1";
        ArrayList<Alumno> alumnos= new ArrayList<>(); //lista vacia
        try {
        PreparedStatement ps=con.prepareStatement (sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
                Alumno alumno=new Alumno(); //creamos objeto con datos alumno
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setActivo(true);
                alumnos.add(alumno); //agregamos la persona a la lista
            }
        ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
        return alumnos;
    }
//    public void listarAlumnos(){
//        String sql="select*from alumno";
//        try {
//             PreparedStatement ps=con.prepareStatement(sql);
//             ResultSet resultado=ps.executeQuery();
//             while(resultado.next()){
//                System.out.println("ID "+resultado.getInt("idAlumno"));
//                System.out.println("DNI "+resultado.getInt("dni"));
//                System.out.println("Nombre "+resultado.getString("nombre"));
//                System.out.println("Apellido "+resultado.getString("apellido"));
//                 System.out.println(" ");
//             }
//             ps.close();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
//            }
//    }
    public void modificarAlumno(Alumno alumno){
        
        String sql="UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNac=? where idAlumno=? ";  //los campos a modificar
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "alumno modificado exitosamente");
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
    }
    
    public void eliminarAlumno(int idAlumno){
        String sql="update alumno SET estado=0 WHERE idAlumno = ? ";
        try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             int exito=ps.executeUpdate();
             if(exito==1){
                JOptionPane.showMessageDialog(null, "alumno eliminado exitosamente");
             }else{
                 JOptionPane.showMessageDialog(null, "alumno no encontrado");
             }
             ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
    }
}
