
package vistas;

import proyecto_final.Administrador;

public class FrmNuevoMiembro extends javax.swing.JInternalFrame {

    public FrmNuevoMiembro() {
        initComponents();
        this.llenarComboBox();
    }
    
    public void llenarComboBox(){
        this.CmbTipoMiembro.removeAllItems();
        this.CmbTipoMiembro.addItem("Administrador");
        this.CmbTipoMiembro.addItem("Editor");
        this.CmbTipoMiembro.addItem("Invitado");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lb_Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtApellidos = new javax.swing.JTextField();
        TxtUsuario = new javax.swing.JTextField();
        TxtClave = new javax.swing.JTextField();
        CmbTipoMiembro = new javax.swing.JComboBox<>();
        BtnGuardar = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();
        LbCedula = new javax.swing.JLabel();
        TxtCedula = new javax.swing.JTextField();

        setBackground(new java.awt.Color(20, 29, 38));

        Lb_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Titulo.setText("Agregar Miembro");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres");

        TxtNombres.setBackground(new java.awt.Color(20, 29, 38));
        TxtNombres.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtNombres.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clave");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo Miembro");

        TxtApellidos.setBackground(new java.awt.Color(20, 29, 38));
        TxtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtApellidos.setForeground(new java.awt.Color(255, 255, 255));

        TxtUsuario.setBackground(new java.awt.Color(20, 29, 38));
        TxtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(255, 255, 255));

        TxtClave.setBackground(new java.awt.Color(20, 29, 38));
        TxtClave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtClave.setForeground(new java.awt.Color(255, 255, 255));

        BtnGuardar.setBackground(new java.awt.Color(153, 153, 153));
        BtnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnCerrar.setBackground(new java.awt.Color(153, 153, 153));
        BtnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCerrar.setText("Cerrar");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        LbCedula.setBackground(new java.awt.Color(255, 255, 255));
        LbCedula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LbCedula.setForeground(new java.awt.Color(255, 255, 255));
        LbCedula.setText("Cédula");

        TxtCedula.setBackground(new java.awt.Color(20, 29, 38));
        TxtCedula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtCedula.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(Lb_Titulo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CmbTipoMiembro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtNombres)
                    .addComponent(TxtApellidos)
                    .addComponent(TxtUsuario)
                    .addComponent(TxtClave)
                    .addComponent(TxtCedula)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(LbCedula))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnGuardar)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbTipoMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        FrmMiembros miembros = new FrmMiembros();
        miembros.setVisible(true);
        FrmHome.Desktop_Main.add(miembros);
        FrmHome.frameCount++;
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        String tipoMiembro = CmbTipoMiembro.getSelectedItem().toString();
        
        if(tipoMiembro.equalsIgnoreCase("Administrador")){
            Administrador administrador = new Administrador("", TxtNombres.getText().trim(), 
                    TxtApellidos.getText().trim(), TxtUsuario.getText().trim(), 
                    TxtClave.getText().trim(), TxtCedula.getText().trim());
            
            administrador.Agregar();
            
            // Implement other user tipe (Editor, Invitado).
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JComboBox<String> CmbTipoMiembro;
    private javax.swing.JLabel LbCedula;
    private javax.swing.JLabel Lb_Titulo;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtCedula;
    private javax.swing.JTextField TxtClave;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
