
package universidadgrupo36.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;
import universidadgrupo36.Entidades.Inscripcion;


public class InscripcionData {
    private Connection con=null;
    private MatData data;
    private AluData alumno;

    public InscripcionData() {
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
       String sql = "INSERT INTO alumno (nota,idAlumno,idMateria) VALUES (?, ?, ?)";
       try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, insc.getNota());
        ps.setString(2, alumno.getidAlumno());
        ps.setString(3, data.getidMateria());
        int as=ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if (as==1) {
            JOptionPane.showMessageDialog(null, "Inscripcion guardada con exito.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al inscribir al alumno");
        }
    ps.close(); //

    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        } 
    }
    
}
