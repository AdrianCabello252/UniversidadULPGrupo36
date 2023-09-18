
package universidadgrupo36.AccesoADatos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo36.Entidades.Materia;


public class MateriaData {
    private Connection con=null;

    public MateriaData() {
    con=Conexion.getConexion();
    }
    void guardarMateria(Materia materia){
        try {
            String sql="INSERT INTO materia (nombre,anio,estado) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
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

    String getidMateria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Materia buscarMateria(int idMateria) {
    Materia materia = null;
    String sql = "SELECT nombre, anio, estado FROM materia WHERE idMateria = ? AND estado = 1";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idMateria);
        rs = ps.executeQuery();

        if (rs.next()) {
            materia = new Materia();
            materia.setIdMateria(idMateria);
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materia.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe la materia");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar la materia: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    return materia;
}
    
    
    
   public List<Materia> ListarMaterias() {

    List<Materia> listaMaterias = new ArrayList<>();
    
    try {
        String sql = "SELECT * FROM materia";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        Materia materia = new Materia();
        materia.setNombre(rs.getString("nombre"));
        materia.setAnio(rs.getInt ("anio"));
        materia.setEstado(true); 
        
        listaMaterias.add(materia);
        }
        
    ps.close();

    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia" +ex.getMessage());
    }
    return listaMaterias;
    }
    
    
    public void modificarMateria(Materia materia){
        
        String sql="UPDATE materia SET nombre=?, anio=?, estado=?";  
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Materia modificada con exito");
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
            }
    
    }
    
}