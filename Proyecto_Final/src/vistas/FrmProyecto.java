
package vistas;

import Estructuras.Pila;
import Estructuras.ListaES;
import proyecto_final.Proyecto;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrmProyecto extends javax.swing.JInternalFrame {

    private static DefaultListModel listModel;
    Pila pila = new Pila();
    
    public FrmProyecto() {
        llenarLista();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_Proyectos = new javax.swing.JList<String>();
        TxtBusqueda = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnAgregarProyecto = new javax.swing.JButton();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proyectos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PROYECTOS");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        Lista_Proyectos.setBackground(new java.awt.Color(20, 29, 38));
        Lista_Proyectos.setFont(new java.awt.Font("Segoe UI", 1, 24));
        Lista_Proyectos.setModel(listModel);
        Lista_Proyectos.setForeground(new java.awt.Color(255, 255, 255));
        Lista_Proyectos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lista_Proyectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Lista_ProyectosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Lista_Proyectos);

        TxtBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtBusqueda.setText("Realizar Búsqueda");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnAgregarProyecto.setText("Agregar");
        BtnAgregarProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBuscar)
                                .addGap(26, 26, 26)
                                .addComponent(BtnAgregarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnAgregarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        FrmNuevoProyecto nuevoProyecto = new FrmNuevoProyecto();
        nuevoProyecto.setVisible(true);
        FrmHome.Desktop_Main.add(nuevoProyecto);
        this.dispose();
        // listModel.addElement(TxtTituloProyecto.getText().trim());
        // pila.apilar(TxtTituloProyecto.getText().trim());
        
    }//GEN-LAST:event_BtnBuscarActionPerformed

    public void llenarLista(){
        Proyecto proyecto = new Proyecto();
        ListaES[] datos = proyecto.listar(FrmHome.datosUsuario.obtenerEspecifico(0).toDatoString().getCadena());
        listModel = new DefaultListModel();
        if(datos[0].getLongitud() > 0){ // datos[0].isLESEmpty();
            for(int i = 0; i<datos[0].getLongitud(); i++){
                listModel.addElement(datos[1].obtenerEspecifico(i).toDatoString().getCadena());
            }
        }
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        FrmHome.frameCountProject--;
    }//GEN-LAST:event_formInternalFrameClosed

    private void BtnAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarProyectoActionPerformed
        FrmNuevoProyecto nuevoProyecto = new FrmNuevoProyecto();
        nuevoProyecto.setVisible(true);
        FrmHome.Desktop_Main.add(nuevoProyecto);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarProyectoActionPerformed

    private void Lista_ProyectosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Lista_ProyectosValueChanged
        Proyecto proyecto = new Proyecto();
        FrmDatosProyecto datosProyecto = new FrmDatosProyecto(proyecto.buscarProyecto(
        this.Lista_Proyectos.getSelectedValue().toString()));
        datosProyecto.setVisible(true);
        FrmHome.Desktop_Main.add(datosProyecto);
        this.dispose();
    }//GEN-LAST:event_Lista_ProyectosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarProyecto;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JList<String> Lista_Proyectos;
    private javax.swing.JTextField TxtBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
