
package universidadgrupo36.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
             ps.setBoolean(5, alumno.());
             ps.executeUpdate();
             
             ResultSet rs=ps.getGeneratedKeys();
             if(rs.next()){
                 
             }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
            }
        
    }
}
