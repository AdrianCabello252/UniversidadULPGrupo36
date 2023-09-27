
package universidadgrupo36.Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import universidadgrupo36.AccesoADatos.AlumnoData;
import universidadgrupo36.Entidades.Alumno;



public class AlumnoVista extends javax.swing.JInternalFrame {

    public AlumnoVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtdni = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jcbActivo = new javax.swing.JCheckBox();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Alumnos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("DNI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Fecha de Nac");

        jcbActivo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jcbActivo.setText(" Activo");

        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbNuevo.setText("NUEVO");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbBuscar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbActivo)
                                    .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbActivo)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
//        Este era el que escribi yo hace unos dias
//        int dni = Integer.parseInt(jtdni.getText());    
//        AlumnoData aluData = new AlumnoData();
//        Alumno alu= aluData.buscarAlumnoPorDni(dni);
//        int idAlumno = alu.getIdAlumno();
//        aluData.eliminarAlumno(idAlumno);
//        
//        jtApellido.setText("");
//        jtNombre.setText("");
//        jtdni.setText("");
//        jdcFechaNac.setCalendar(null);
//        jcbActivo.setSelected(false);

//      Aqui pongo el de Adrian
        AlumnoData aluData = new AlumnoData();
        int dni = Integer.parseInt(jtdni.getText());
        Alumno alu= aluData.buscarAlumnoPorDni(dni);
        aluData.eliminarAlumno(alu.getIdAlumno());                   
    }//GEN-LAST:event_jbEliminarActionPerformed

    
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

       int dni = Integer.parseInt(jtdni.getText());
       AlumnoData aluData = new AlumnoData();
       Alumno alu= aluData.buscarAlumnoPorDni(dni);
       
       jtApellido.setText(alu.getApellido());
       jtNombre.setText(alu.getNombre());
       if (alu.isActivo()) {
       jcbActivo.setSelected(true);
       }
//     jdcFechaNac.setDate(alu.nuevaFecha());
       jdcFechaNac.setDate(Date.from(alu.getFechaNac().atStartOfDay(ZoneId.systemDefault()).toInstant()));

    }//GEN-LAST:event_jbBuscarActionPerformed

    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
    
//        int dni = Integer.parseInt(jtdni.getText());    
//        AlumnoData aluData = new AlumnoData();
//        Alumno alu= aluData.buscarAlumnoPorDni(dni);
//    
//        alu.setApellido(jtApellido.getText());
//        alu.setNombre(jtNombre.getText());
//        alu.setActivo(jcbActivo.isSelected());
//        alu.setFechaNac(jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//        aluData.guardarAlumno(alu);

        int dni = Integer.parseInt(jtdni.getText());    
        AlumnoData aluData = new AlumnoData();
        Alumno alu = aluData.buscarAlumnoPorDni(dni);

        if (alu == null) {
            alu = new Alumno();
            alu.setDni(dni);
        }

        alu.setApellido(jtApellido.getText());
        alu.setNombre(jtNombre.getText());
        alu.setActivo(jcbActivo.isSelected());
        alu.setFechaNac(jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        aluData.guardarAlumno(alu);

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed

        //AlumnoVista al=new AlumnoVista();
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
//        jtApellido.setText("");
//        jtNombre.setText("");
//        jtdni.setText("");
//        //jdcFechaNac.setCalendar("");
//        jcbActivo.setDisabledSelectedIcon(frameIcon);
        jtApellido.setText("");
        jtNombre.setText("");
        jtdni.setText("");
        jdcFechaNac.setCalendar(null);
        jcbActivo.setSelected(false);
    }//GEN-LAST:event_jbNuevoActionPerformed
                                                       

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbActivo;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtdni;
    // End of variables declaration//GEN-END:variables
}