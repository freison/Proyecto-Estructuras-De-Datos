
package vistas;

import proyecto_final.Administrador;
import Estructuras.ListaES;
import javax.swing.JOptionPane;
import proyecto_final.Tarea;
import proyecto_final.EstadoTarea;
import Estructuras.Cola;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class FrmNuevaTarea extends javax.swing.JInternalFrame {
    
    private Object[][] miembros;
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static DefaultListModel listModel = new DefaultListModel();
    private static final String nombresDeColumna[] = {
        "Id", "Nombres", "Apellidos", "Usuario", "Cedula", "Rol"
    };
    
    private String idProyecto;
    private Integer tareaId = null;

    public FrmNuevaTarea() {
        initComponents();
    }
    
    public FrmNuevaTarea(String idProyecto){
        this.idProyecto = idProyecto;
        llenarTabla();
        listModel = new DefaultListModel();
        initComponents();
    }
    
    public void llenarTabla(){
        this.obtenerDatos();
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1l;
            public Class<?> getColumnClass(int column){
                return column == 1 ? DefaultTableModel.class : String.class;
            }
        };
    }
    
    public void obtenerDatos(){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            ListaES[] Datos = administrador.listarMiembrosPorProyecto(Integer.parseInt(idProyecto));
            miembros = new Object[total][6];
            
            for(int i=0; i<Datos[0].getLongitud(); i++){
                for(int j=0; j<Datos.length; j++){
                    if(j==0){
                        miembros[i][j] = Datos[j].obtenerEspecifico(i)
                                .toDatoString().getCadena();
                    }
                    else{
                        miembros[i][j] = Datos[j].obtenerEspecifico(i)
                                .toDatoString().getCadena();
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public int obtenerIdSeleccionado(){
        int id = 0;
        try{
            id = Integer.parseInt(
            TablaMiembros.getValueAt(TablaMiembros.getSelectedRow(), 0).toString());
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un miembro");
        }
        
        return id;
    }
    
    public void agregarTareaTableroKamban(
            int miembroId, Tarea tarea, int ultimaTareaId, Cola[] datosEstados){
        // NEEDS TO BE IMPLEMENTED.
    }
    
    public void agregarTareaTablero(
            int miembroId, Tarea tarea, int ultimaTareaId, Cola[] datosEstados){
        if(this.tareaId == null){
            if(TxtDescripcion.isEnabled()){
                tarea.Agregar(TxtDescripcion.getText().trim(), 
                        datosEstados[0].obtenerEspecifico(0).toDatoInt().getNumero(),
                        Integer.parseInt(this.idProyecto));
                ultimaTareaId = tarea.buscarUltimaTarea();
                tarea.agregarDetalle(miembroId, ultimaTareaId);
                
                listModel.addElement(TablaMiembros.getValueAt(TablaMiembros.getSelectedRow(), 1));
                
                this.TxtDescripcion.setEnabled(false);
            }
            else{
                ultimaTareaId = tarea.buscarUltimaTarea();
                tarea.agregarDetalle(miembroId, ultimaTareaId);
                listModel.addElement(TablaMiembros.getValueAt(TablaMiembros.getSelectedRow(), 1));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaMiembros = new javax.swing.JTable(modelo);
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaMiembrosAsignados = new javax.swing.JList<>(listModel);
        jLabel2 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nueva Tarea");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripción");

        TxtDescripcion.setBackground(new java.awt.Color(20, 29, 38));
        TxtDescripcion.setColumns(20);
        TxtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        TxtDescripcion.setRows(5);
        jScrollPane1.setViewportView(TxtDescripcion);

        TablaMiembros.setBackground(new java.awt.Color(20, 29, 38));
        TablaMiembros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TablaMiembros.setForeground(new java.awt.Color(255, 255, 255));
        TablaMiembros.setModel(modelo);
        jScrollPane2.setViewportView(TablaMiembros);

        ListaMiembrosAsignados.setBackground(new java.awt.Color(20, 29, 38));
        ListaMiembrosAsignados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ListaMiembrosAsignados.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(ListaMiembrosAsignados);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccionar miembros");

        BtnCancelar.setBackground(new java.awt.Color(20, 29, 38));
        BtnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnGuardar.setBackground(new java.awt.Color(153, 216, 240));
        BtnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(0, 172, 238));
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Miembros asignados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(BtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        int miembroId = obtenerIdSeleccionado();
        Tarea tarea = new Tarea();
        EstadoTarea estados = new EstadoTarea();
        Cola[] datosEstados = estados.listarEstadosPorProyecto(Integer.parseInt(this.idProyecto));
        int ultimaTareaId = 0;
        
        if(true){
            agregarTareaTablero(miembroId, tarea, ultimaTareaId, datosEstados);
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JList<String> ListaMiembrosAsignados;
    private javax.swing.JTable TablaMiembros;
    private javax.swing.JTextArea TxtDescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
