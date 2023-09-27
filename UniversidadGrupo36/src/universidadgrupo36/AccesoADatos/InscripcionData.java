
package universidadgrupo36.AccesoADatos;

    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo36.Entidades.Alumno;
import universidadgrupo36.Entidades.Inscripcion;
import universidadgrupo36.Entidades.Materia;


public class InscripcionData {
    private Connection con=null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
       String sql = "INSERT INTO inscripcion (idAlumno, nota, idMateria) VALUES (?, ?, ?)";
       try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt (1, insc.getAlumno().getIdAlumno());
        ps.setInt(2, (int) insc.getNota());
        ps.setInt(3, insc.getMateria().getIdMateria());
        int as=ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if (rs.next()) {
            insc.setIdInscripcion(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Inscripcion guardada con exito.");
        }else{
            JOptionPane.showMessageDialog(null, "Error al inscribir al alumno");
        }
    ps.close(); //

    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion"+ex.getMessage());
        } 
    }
   
    
     public List<Inscripcion> obtenerInscripciones() {

    List<Inscripcion> inscripciones = new ArrayList<>();
    
    try {
        String sql = "SELECT * FROM inscripcion";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        Inscripcion insc = new Inscripcion();

        insc.setNota(rs.getInt("nota"));
//        aluData.setIdAlumno(rs.getString("IdAlumno"));
        insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
//        matData.setIdMateria(rs.getString("IdMateria"));
        insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
        inscripciones.add(insc);
        }
        
    ps.close();

    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, " Error al acceder a la tabla inscripcion"+ex.getMessage());
    }
    return inscripciones;
    }
     
     
    public List<Inscripcion> obtenerInscripcionesXAlumno() {

    List<Inscripcion> inscripciones = new ArrayList<>();
    
    try {
        String sql = "SELECT * FROM inscripcion WHERE Alumno = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        Inscripcion insc = new Inscripcion();

        insc.setNota(rs.getInt("nota"));
//        aluData.setIdAlumno(rs.getString("IdAlumno"));
        insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
//        matData.setIdMateria(rs.getString("IdMateria"));
        insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
        inscripciones.add(insc);
        }
        
    ps.close();

    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, " Error al acceder a la tabla inscripcion" +ex.getMessage());
    }
    return inscripciones;
    }
     
     
     
    public void actualizarNota(Inscripcion insc, int idAlumno, int idMateria, int nota){
        
        String sql="UPDATE Inscripcion SET nota=? where idAlumno=? AND idMateria=? ";  
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
//          ps.setInt(1, insc.getIdAlumno());
            insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
//            ps.setInt(2, insc.getIdMateria());
            insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
            ps.setInt(3, (int) insc.getNota());
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Nota modificada exitosamente");
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
            }

     }
     
     
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){  
//        String sql="select idAlumno, dni, apellido, nombre, fechaNacimiento from alumno where idMateria=?";
        String sql= "SELECT alumno.idAlumno, alumno.dni, alumno.apellido, alumno.nombre, alumno.fechaNacimiento FROM alumno JOIN inscripcion ON alumno.idAlumno = inscripcion.idAlumno WHERE inscripcion.idMateria = ?";
        
        ArrayList<Alumno> alumnos= new ArrayList<>(); 
        
        try {
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, idMateria); //idMateria agregado como parametro
          ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
                Alumno alumno=new Alumno(); 
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                alumnos.add(alumno); 
            }
        
        ps.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
        
        return alumnos;
    }
      
//        public List<Materia> obtenerMateriasCursadas(int idAlumno) {
//        List<Materia> materiasCursadas = new ArrayList<>();
//        Materia mat = null;
//        String sql = "SELECT inscripcion.idMateria, nombre, anno FROM inscripcion JOIN materia "
//                + "ON(inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ?;";
//        try (PreparedStatement stp = con.prepareStatement(sql); 
//            ResultSet rs = stp.executeQuery();) {
//            stp.setInt(1, idAlumno);
//            while (rs.next()) {
//                mat.setIdMateria(rs.getInt("idMateria"));
//                mat.setNombre(rs.getString("nombre"));
//                mat.setAnio(rs.getInt("anno"));
//                materiasCursadas.add(mat);
//
//            }
//            
//        stp.close();  
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        } 
//
//        return materiasCursadas;
//        }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
    List<Materia> materiasCursadas = new ArrayList<>();
    String sql = "SELECT M.idMateria, M.nombre, M.anio\n"
            + "FROM Materia M\n"
            + "INNER JOIN Inscripcion I ON M.idMateria = I.idMateria\n"
            + "WHERE I.idAlumno = ?;";
    try (PreparedStatement stp = con.prepareStatement(sql);) {
        stp.setInt(1, idAlumno);
        try (ResultSet rs = stp.executeQuery()) {
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                materiasCursadas.add(mat);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error SQL contacte al administrador: " + ex.getMessage(), "Error en la conexión a la base de datos", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
    }

    return materiasCursadas;
}

     
//        public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
//        
//        List<Materia> listaMateriasNOCursadas = new ArrayList<>();
//        Materia mat = null;
//        String sql = "SELECT M.idMateria, M.nombre, M.anio\n"
//                + "FROM Materia M\n"
//                + "WHERE M.idMateria NOT IN (\n"
//                + "    SELECT I.idMateria\n"
//                + "    FROM Inscripcion I\n"
//                + "    WHERE I.idAlumno = ?\n"
//                + ");";
//        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
//            stp.setInt(1, idAlumno);
//            while (rs.next()) {
//                mat.setIdMateria(rs.getInt("idMateria"));
//                mat.setNombre(rs.getString("nombre"));
//                mat.setAnio(rs.getInt("anio"));
//                listaMateriasNOCursadas.add(mat);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        } finally {
//        //    cerrarConexion(con);
//        }
//
//        return listaMateriasNOCursadas;
//    } 
        
        
        public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
            List<Materia> listaMateriasNoCursadas = new ArrayList<>();
            String sql = "SELECT M.idMateria, M.nombre, M.anio\n"  // Cambiado "anno" a "anio"
                    + "FROM Materia M\n"
                    + "WHERE M.idMateria NOT IN (\n"
                    + "    SELECT I.idMateria\n"
                    + "    FROM Inscripcion I\n"
                    + "    WHERE I.idAlumno = ?\n"
                    + ");";
            try (PreparedStatement stp = con.prepareStatement(sql);) {
                stp.setInt(1, idAlumno);
                try (ResultSet rs = stp.executeQuery()) {
                    while (rs.next()) {
                        Materia mat = new Materia();
                        mat.setIdMateria(rs.getInt("idMateria"));
                        mat.setNombre(rs.getString("nombre"));
                        mat.setAnio(rs.getInt("anio"));  // Cambiado "anno" a "anio"
                        listaMateriasNoCursadas.add(mat);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } finally {
                // cerrarConexion(con);
            }

            return listaMateriasNoCursadas;
        }

        
        
       public void borrarInscripcionMateriaAlumno (int idAlumno, int idMateria) {
       
           String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
           
               PreparedStatement ps;
        try {
            
            ps = con.prepareStatement(sql);
      
               ps.setInt(1, idAlumno);
               ps.setInt(2, idMateria);
               int filas = ps.executeUpdate();
               
               if (filas >0) {
                   JOptionPane.showMessageDialog(null, "Inscripcion borrada");
               }
               
               ps.close();
               
          } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       } 
     
     
}
     
     
    
