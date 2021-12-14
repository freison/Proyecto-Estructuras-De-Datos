
package vistas;

import javax.swing.JOptionPane;
import proyecto_final.Administrador;
import Estructuras.Cola;
import javax.swing.table.DefaultTableModel;
import proyecto_final.Proyecto;

public class FrmMiembros extends javax.swing.JInternalFrame {
    
    private Object[][] miembros;
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static final String nombresDeColumna[] = {
        "Id", "Nombres", "Apellidos", "Usuario", "Cedula", "Rol"
    };
    private int proyectoId = 0;

    public FrmMiembros() {
        llenarTabla();
        initComponents();
        this.BtnAgregarAProyecto.setVisible(false);
    }
    
    public FrmMiembros(int proyectoId) {
        llenarTabla();
        initComponents();
        this.BtnAgregarAProyecto.setVisible(true);
        this.proyectoId = proyectoId;
    }
    
    private void llenarTabla(){
        this.obtenerDatos();
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1l;
            public Class<?> getColumnClass(int column){
                return column == 1 ? DefaultTableModel.class : String.class;
            }
        };
    }
    
    private void obtenerDatos(){
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
        GridMiembros = new javax.swing.JTable(modelo);
        BtnAgregarAProyecto = new javax.swing.JButton();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Miembros");
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

        BtnAgregarMiembro.setBackground(new java.awt.Color(20, 29, 38));
        BtnAgregarMiembro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregarMiembro.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarMiembro.setText("Agregar");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        GridMiembros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        GridMiembros.setModel(modelo);
        jScrollPane1.setViewportView(GridMiembros);

        BtnAgregarAProyecto.setBackground(new java.awt.Color(20, 29, 38));
        BtnAgregarAProyecto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregarAProyecto.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarAProyecto.setText("Agregar a Proyecto");
        BtnAgregarAProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarAProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(Lb_Titulo)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAgregarAProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Titulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnAgregarAProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void BtnAgregarAProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarAProyectoActionPerformed
        int miembroId = 0;
        
        try{
            miembroId = Integer.parseInt(GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 0).toString());
        }catch(IndexOutOfBoundsException | NullPointerException e){
            try{
                miembroId = Integer.parseInt(GridMiembros.getModel().getValueAt(0, 0).toString());
            }catch(NullPointerException ex){
                System.out.println(ex.getMessage());
            }
        }finally{
            Proyecto proyecto = new Proyecto();
            if(!proyecto.validarParticipacion(miembroId, this.proyectoId)){
                proyecto.agregarDetalleParticipacion(miembroId, proyectoId);
            }
            else{
                JOptionPane.showMessageDialog(null, "Miembro seleccionado\n ya pertenece a este proyecto");
            }
        }
    }//GEN-LAST:event_BtnAgregarAProyectoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarAProyecto;
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JTable GridMiembros;
    private javax.swing.JLabel Lb_Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
