
package vistas;

import Estructuras.Pila;

public class FrmDatosProyecto extends javax.swing.JInternalFrame {

    public FrmDatosProyecto() {
        initComponents();
    }
    
    public FrmDatosProyecto(Pila datosUsuario){
        initComponents();
        this.Lb_Titulo.setText(datosUsuario.obtenerEspecifico(1).toDatoString().getCadena());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaToDo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaEnProceso = new javax.swing.JList<>();
        Lb_Titulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaFinalizado = new javax.swing.JList<>();
        BtnAgregarTarea = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaMiembros = new javax.swing.JList<>();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proyecto");

        ListaToDo.setBackground(new java.awt.Color(20, 29, 38));
        ListaToDo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaToDo.setForeground(new java.awt.Color(153, 0, 51));
        ListaToDo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaToDo);

        ListaEnProceso.setBackground(new java.awt.Color(20, 29, 38));
        ListaEnProceso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaEnProceso.setForeground(new java.awt.Color(153, 153, 0));
        ListaEnProceso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaEnProceso);

        Lb_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Titulo.setText("Proyecto");

        ListaFinalizado.setBackground(new java.awt.Color(20, 29, 38));
        ListaFinalizado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaFinalizado.setForeground(new java.awt.Color(0, 102, 0));
        ListaFinalizado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(ListaFinalizado);

        BtnAgregarTarea.setBackground(new java.awt.Color(153, 216, 240));
        BtnAgregarTarea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregarTarea.setForeground(new java.awt.Color(0, 172, 238));
        BtnAgregarTarea.setText("Agregar Tarea");

        ListaMiembros.setBackground(new java.awt.Color(20, 29, 38));
        ListaMiembros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaMiembros.setForeground(new java.awt.Color(153, 216, 240));
        ListaMiembros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(ListaMiembros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lb_Titulo)
                    .addComponent(BtnAgregarTarea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Titulo)
                .addGap(33, 33, 33)
                .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JLabel Lb_Titulo;
    private javax.swing.JList<String> ListaEnProceso;
    private javax.swing.JList<String> ListaFinalizado;
    private javax.swing.JList<String> ListaMiembros;
    private javax.swing.JList<String> ListaToDo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
