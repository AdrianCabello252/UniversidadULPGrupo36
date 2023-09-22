
package universidadgrupo36.AccesoADatos;

    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
       String sql = "INSERT INTO alumno (nota,idAlumno,idMateria) VALUES (?, ?, ?)";
       try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, (int) insc.getNota());
//      ps.setString (2, aluData.getidAlumno());
        ps.setString(3, matData.getidMateria());
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
      
        public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materiasCursadas = new ArrayList<>();
        Materia mat = null;
        String sql = "SELECT inscripcion.idMateria, nombre, anno FROM inscripcion JOIN materia "
                + "ON(inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ?;";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            stp.setInt(1, idAlumno);
            while (rs.next()) {
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anno"));
                materiasCursadas.add(mat);

            }
            
        stp.close();  

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return materiasCursadas;
        }
     
        public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        
        List<Materia> listaMateriasNOCursadas = new ArrayList<>();
        Materia mat = null;
        String sql = "SELECT M.idMateria, M.nombre, M.anno\n"
                + "FROM Materia M\n"
                + "WHERE M.idMateria NOT IN (\n"
                + "    SELECT I.idMateria\n"
                + "    FROM Inscripcion I\n"
                + "    WHERE I.idAlumno = ?\n"
                + ");";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            stp.setInt(1, idAlumno);
            while (rs.next()) {
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anno"));
                listaMateriasNOCursadas.add(mat);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
        //    cerrarConexion(con);
        }

        return listaMateriasNOCursadas;
} 
     
     
}
     
     
    
