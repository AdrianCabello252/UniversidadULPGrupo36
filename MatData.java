
package universidadgrupo36.AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo36.Entidades.Materia;


public class MatData {
    private Connection con=null;

    public MatData() {
    con=Conexion.getConexion();
    }
    void guardarMateria(Materia materia){
        try {
            String sql="INSERT INTO materia (nombre,anio,estado) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            int as=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
        if (as==1) {
            JOptionPane.showMessageDialog(null, "Materia agregada con exito.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al agregar la materia");
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos de las materias"+ex.getMessage());
        }
    }
    
    void eliminarMateria(int id){
        String sql="UPDATE materia SET estado = 0 WHERE idMateria = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            int as=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
        if (as==1) {
            JOptionPane.showMessageDialog(null, "Materia eliminada con exito.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia");
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos de la materia"+ex.getMessage());
        }
    }
    
}
