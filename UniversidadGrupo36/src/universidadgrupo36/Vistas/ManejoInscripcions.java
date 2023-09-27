
package universidadgrupo36.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo36.AccesoADatos.AlumnoData;
import universidadgrupo36.AccesoADatos.InscripcionData;
import universidadgrupo36.AccesoADatos.MateriaData;
import universidadgrupo36.Entidades.Alumno;
import universidadgrupo36.Entidades.Inscripcion;
import universidadgrupo36.Entidades.Materia;
/**
 *
 * @author marce
 */
public class ManejoInscripcions extends javax.swing.JInternalFrame {

    private List<Materia> listaM;
    private ArrayList<Alumno> listaA;
    private InscripcionData inscData;
    private AlumnoData aData;
    private MateriaData mData;
    private DefaultTableModel modelo;

    public ManejoInscripcions() {
        initComponents();
        aData = new AlumnoData ();
        listaA = (ArrayList<Alumno>) aData.listarAlumnos();
        modelo = new DefaultTableModel();
        inscData = new InscripcionData();
        mData = new MateriaData();
        cargaAlumno();
        armarCabeceraTabla ();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboxAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        radioNoInscriptas = new javax.swing.JRadioButton();
        radioInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Formulario Inscripcion");

        jLabel2.setText("Seleccione un Alumno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Listado de Materias");

        radioNoInscriptas.setText("Materias inscriptas");
        radioNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoInscriptasActionPerformed(evt);
            }
        });

        radioInscriptas.setText("Materias no inscriptas");
        radioInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtMaterias);

        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBAnular.setText("Anular inscripcion");
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioNoInscriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioInscriptas)
                        .addGap(82, 82, 82))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jBInscribir)
                        .addGap(43, 43, 43)
                        .addComponent(jBAnular)
                        .addGap(36, 36, 36)
                        .addComponent(jbSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNoInscriptas)
                    .addComponent(radioInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBAnular)
                    .addComponent(jbSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void radioNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoInscriptasActionPerformed
        borrarFilaTabla();
        radioInscriptas.setSelected(false);
        cargarDatosInscriptas();
        jBAnular.setEnabled(false);
        jBInscribir.setEnabled(false);
    }//GEN-LAST:event_radioNoInscriptasActionPerformed

    private void radioInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInscriptasActionPerformed
        borrarFilaTabla();
        radioInscriptas.setSelected(false);
        cargarDatosNoInscriptas();
        jBAnular.setEnabled(false);
        jBInscribir.setEnabled(true);
    }//GEN-LAST:event_radioInscriptasActionPerformed

    
    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
       
        int filaSeleccionada = jtMaterias.getSelectedRow();
        if (filaSeleccionada != -1) {
            Alumno alumnoSeleccionado = (Alumno) cboxAlumno.getSelectedItem();
        if (alumnoSeleccionado != null) {
            int idMateria = (int) jtMaterias.getValueAt(filaSeleccionada, 0); 
            Materia materiaSeleccionada = mData.buscarMateria(idMateria);
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setAlumno(alumnoSeleccionado);
            inscripcion.setMateria(materiaSeleccionada);
            inscData.guardarInscripcion(inscripcion);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un alumno válido en el JComboBox.");
        }
        } else {
        JOptionPane.showMessageDialog(null, "Selecciona una fila en la tabla de materias.");
        }      

    }//GEN-LAST:event_jBInscribirActionPerformed

        
        
    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed
        int filaSeleccionada=jtMaterias.getSelectedRow();
            if (filaSeleccionada!=-1) {
            Alumno a = (Alumno) cboxAlumno.getSelectedItem();
            int idMateria=(Integer)modelo.getValueAt(filaSeleccionada, 0);
            inscData.borrarInscripcionMateriaAlumno (a.getIdAlumno(), idMateria);
            borrarFilaTabla ();
    }//GEN-LAST:event_jBAnularActionPerformed
    }
        
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    private void cargaAlumno() {
            for (Alumno item: listaA){
                cboxAlumno.addItem(item);
            }
    }
    
    
    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Año");
            modelo.setRowCount(0);
            for (Object it: filaCabecera){
            modelo.addColumn(it);
            }
            jtMaterias.setModel(modelo);
            modelo.setRowCount(0);
    }
    
    
    private void borrarFilaTabla(){
         int indice = modelo.getRowCount() -1;
         for (int i = indice;i>=0;i--){
             modelo.removeRow(i);
         }
    }

       
@SuppressWarnings("unchecked")
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cboxAlumno;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtMaterias;
    private javax.swing.JRadioButton radioInscriptas;
    private javax.swing.JRadioButton radioNoInscriptas;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosNoInscriptas() {
        Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
        listaM = inscData.obtenerMateriasNoCursadas(selec.getIdAlumno());
        
            for (Materia m : listaM) {
            modelo.addRow(new Object[] { m.getIdMateria(), m.getNombre(), m.getAnio() });
            }
    }

    private void cargarDatosInscriptas() {
        Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
        List <Materia> lista = inscData.obtenerMateriasCursadas(selec.getIdAlumno());
            
            for (Materia m : lista) {
            modelo.addRow(new Object[] { m.getIdMateria(), m.getNombre(), m.getAnio() });
            }
    }
    
    
}
