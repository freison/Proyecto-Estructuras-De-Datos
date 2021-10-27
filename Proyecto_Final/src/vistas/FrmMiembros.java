
package vistas;

import javax.swing.JOptionPane;
import proyecto_final.Administrador;
import Estructuras.Cola;

public class FrmMiembros extends javax.swing.JInternalFrame {
    
    private Object[][] miembros;

    public FrmMiembros() {
        initComponents();
        this.obtenerDatos();
    }
    
    public void obtenerDatos(){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            Cola[] Datos = administrador.listarMiembros();
            // System.out.println(Datos.length + " - " + Datos[0].getLongitud());
            // System.out.println(Datos[1].obtenerEspecifico(1).toDatoString().getCadena()); 
            miembros = new Object[total][6];
            
            for(int i=0; i<Datos[0].getLongitud(); i++){
                for(int j=0; j<Datos.length; j++){
                    if(j==0)
                        miembros[i][j] = Datos[j].obtenerEspecifico(i).toDatoInt().getNumero();
                    else
                        miembros[i][j] = Datos[j].obtenerEspecifico(i).toDatoString().getCadena();
                }
            }
            
            for(int i=0; i<Datos[0].getLongitud(); i++){
                for(int j=0; j<Datos.length; j++){
                    System.out.println(miembros[i][j]);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lb_Titulo = new javax.swing.JLabel();
        BtnAgregarMiembro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        Lb_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Titulo.setText("Miembros");

        BtnAgregarMiembro.setBackground(new java.awt.Color(102, 102, 102));
        BtnAgregarMiembro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregarMiembro.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarMiembro.setText("Agregar");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(Lb_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Titulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       
        FrmHome.frameCount--;
    }//GEN-LAST:event_formInternalFrameClosed

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        FrmNuevoMiembro nuevoMiembro = new FrmNuevoMiembro();
        nuevoMiembro.setVisible(true);
        FrmHome.Desktop_Main.add(nuevoMiembro);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JLabel Lb_Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
