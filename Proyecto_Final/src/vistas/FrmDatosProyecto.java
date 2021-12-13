
package vistas;

import proyecto_final.Proyecto;
import proyecto_final.Tarea;
import proyecto_final.EstadoTarea;
import Estructuras.Pila;
import Estructuras.Cola;
import Estructuras.ListaES;
import Estructuras.ListaDC;
import javax.swing.DefaultListModel;

public class FrmDatosProyecto extends javax.swing.JInternalFrame {
    private Pila datosProyecto;
    private static DefaultListModel listModel;
    private DefaultListModel listPorHacerModel = new DefaultListModel();
    private DefaultListModel listEnProcesoModel = new DefaultListModel();
    private DefaultListModel listFinalizadoModel = new DefaultListModel();
    private ListaDC<ListaDC> porHacer = new ListaDC<>();
    private ListaDC<ListaDC> enProceso = new ListaDC<>();
    private ListaDC<ListaDC> finalizado = new ListaDC<>();
    private int idProyecto = 0;
    private boolean owener = false;
    
    Cola[] datosEstados;
    

    public FrmDatosProyecto() {
        initComponents();
    }
    
    public FrmDatosProyecto(Pila datosProyecto){
        this.datosProyecto = datosProyecto;
        this.llenarListaMiembros(Integer.parseInt(
        datosProyecto.obtenerEspecifico(0).toDatoString().getCadena()));
        initComponents();
        
        idProyecto = Integer.parseInt(datosProyecto.obtenerEspecifico(0).toDatoString().getCadena());
        
        EstadoTarea estados = new EstadoTarea();
        datosEstados = estados.listarEstadosPorProyecto(this.idProyecto);
        
        llenarListas();
        
        this.Lb_Titulo.setText(datosProyecto.obtenerEspecifico(1).toDatoString().getCadena());
    }
    
    public void llenarListaMiembros(int id){
        Proyecto proyecto = new Proyecto();
        ListaES nombres = proyecto.listarMiembros(id);
        listModel = new DefaultListModel();
        
        for(int i=0; i<nombres.getLongitud(); i++){
            listModel.addElement(nombres.obtenerEspecifico(i).toDatoString().getCadena());
        }
    }
    
    public void llenarListas(){
        Tarea tarea = new Tarea();
        ListaDC[] tareasProyecto = tarea.listarTareasPorProyecto(idProyecto);
        
        ListaDC porHacerIdTEMP = new ListaDC();
        ListaDC porHacerDescripcionesTEMP = new ListaDC();
        
        ListaDC enProcesoIdTEMP = new ListaDC();
        ListaDC enProcesoDescripcionesTEMP = new ListaDC();
        
        ListaDC finalizadoIdTEMP = new ListaDC();
        ListaDC finalizadoDescripcionesTEMP = new ListaDC();
        int indice = 0;
        
        for(int i=0; i<tareasProyecto.length; i++){
            for(int j=0; j<tareasProyecto[0].getLongitud(); j++){
                // Agrega datos (Descripciones) a los JLists.
                if(Integer.parseInt(tareasProyecto[2].obtenerEspecifico(j).toDatoString().getCadena())
                        == datosEstados[0].obtenerEspecifico(0).toDatoInt().getNumero()){
                    if(i == 1){
                        String elemento = tareasProyecto[1].obtenerEspecifico(j).toDatoString().getCadena();
                        // listPorHacerModel.addElement(elemento);
                        listPorHacerModel.add(j, elemento);
                        porHacerDescripcionesTEMP.agregarListaDC(elemento, j);
                        porHacerDescripcionesTEMP.setLongitud(porHacerDescripcionesTEMP.getLongitud()+1);
                        indice++;
                    }
                    else if(i == 0){
                        int elemento = tareasProyecto[0].obtenerEspecifico(j).toDatoInt().getNumero();
                        porHacerIdTEMP.agregarListaDC(elemento, indice);
                        porHacerIdTEMP.setLongitud(porHacerIdTEMP.getLongitud() + 1);
                        indice++;
                    }
                }
                else if(Integer.parseInt(tareasProyecto[2].obtenerEspecifico(j).toDatoString().getCadena())
                        == datosEstados[0].obtenerEspecifico(1).toDatoInt().getNumero()){
                    if(i == 1){
                        String elemento = tareasProyecto[1].obtenerEspecifico(j).toDatoString().getCadena();
                        listEnProcesoModel.addElement(elemento);
                        enProcesoDescripcionesTEMP.agregarListaDC(elemento, -1);
                    }
                    else if(i == 0){
                        int elemento = tareasProyecto[0].obtenerEspecifico(j).toDatoInt().getNumero();
                        enProcesoIdTEMP.agregarListaDC(elemento, -1);
                    }
                    indice++;
                }
                else if(Integer.parseInt(tareasProyecto[2].obtenerEspecifico(j).toDatoString().getCadena())
                        == datosEstados[0].obtenerEspecifico(2).toDatoInt().getNumero()){
                    if(i == 1){
                        String elemento = tareasProyecto[1].obtenerEspecifico(j).toDatoString().getCadena();
                        listFinalizadoModel.addElement(elemento);
                        finalizadoDescripcionesTEMP.agregarListaDC(elemento, -1);
                    }
                    else if(i == 0){
                        int elemento = tareasProyecto[0].obtenerEspecifico(j).toDatoInt().getNumero();
                        finalizadoIdTEMP.agregarListaDC(elemento, -1);
                    }
                    indice++;
                }
            }
        }
        
        this.porHacer.agregarListaDC(porHacerIdTEMP, 0);
        this.porHacer.agregarListaDC(porHacerDescripcionesTEMP, 1);
        this.enProceso.agregarListaDC(enProcesoIdTEMP, 0);
        this.enProceso.agregarListaDC(enProcesoDescripcionesTEMP, 1);
        this.finalizado.agregarListaDC(finalizadoIdTEMP, 0);
        this.finalizado.agregarListaDC(finalizadoDescripcionesTEMP, 1);
        
        ((ListaDC)this.porHacer.obtenerEspecifico(1).toDatoT()
                    .getT()).mostrarListaDC();
        ((ListaDC)this.enProceso.obtenerEspecifico(1).toDatoT()
                    .getT()).mostrarListaDC();
        ((ListaDC)this.finalizado.obtenerEspecifico(1).toDatoT()
                    .getT()).mostrarListaDC();
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
        ListaMiembros = new javax.swing.JList<>(listModel);
        BtnPorHacer_EnProceso = new javax.swing.JButton();

        setBackground(new java.awt.Color(20, 29, 38));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proyecto");

        ListaToDo.setBackground(new java.awt.Color(20, 29, 38));
        ListaToDo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaToDo.setForeground(new java.awt.Color(153, 0, 51));
        ListaToDo.setModel(listPorHacerModel);
        jScrollPane1.setViewportView(ListaToDo);

        ListaEnProceso.setBackground(new java.awt.Color(20, 29, 38));
        ListaEnProceso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaEnProceso.setForeground(new java.awt.Color(153, 153, 0));
        ListaEnProceso.setModel(listEnProcesoModel);
        jScrollPane2.setViewportView(ListaEnProceso);

        Lb_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Lb_Titulo.setText("Proyecto");

        ListaFinalizado.setBackground(new java.awt.Color(20, 29, 38));
        ListaFinalizado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaFinalizado.setForeground(new java.awt.Color(0, 102, 0));
        ListaFinalizado.setModel(listFinalizadoModel);
        jScrollPane3.setViewportView(ListaFinalizado);

        BtnAgregarTarea.setBackground(new java.awt.Color(153, 216, 240));
        BtnAgregarTarea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregarTarea.setForeground(new java.awt.Color(0, 172, 238));
        BtnAgregarTarea.setText("Agregar Tarea");
        BtnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarTareaActionPerformed(evt);
            }
        });

        ListaMiembros.setBackground(new java.awt.Color(20, 29, 38));
        ListaMiembros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListaMiembros.setForeground(new java.awt.Color(153, 216, 240));
        ListaMiembros.setModel(listModel);
        jScrollPane4.setViewportView(ListaMiembros);

        BtnPorHacer_EnProceso.setBackground(new java.awt.Color(20, 29, 38));
        BtnPorHacer_EnProceso.setForeground(new java.awt.Color(20, 29, 38));
        BtnPorHacer_EnProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/right-arrow.png"))); // NOI18N
        BtnPorHacer_EnProceso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnPorHacer_EnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPorHacer_EnProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lb_Titulo)
                    .addComponent(BtnAgregarTarea)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnPorHacer_EnProceso))
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(18, 18, 18)
                .addComponent(BtnPorHacer_EnProceso)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarTareaActionPerformed
        FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(datosProyecto.obtenerEspecifico(0).toDatoString().getCadena());
        nuevaTarea.setVisible(true);
        FrmHome.Desktop_Main.add(nuevaTarea);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarTareaActionPerformed

    private void BtnPorHacer_EnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPorHacer_EnProcesoActionPerformed
   
        int index = this.ListaToDo.getSelectedIndex();
        if(index>-1){
            System.out.println(index);
            int tareaId = (((ListaDC)this.porHacer.obtenerEspecifico(0).toDatoT().getT())
                    .obtenerEspecifico(index).toDatoInt().getNumero());
            System.out.println(tareaId);
//            String elemento = ((ListaDC)this.porHacer.obtenerEspecifico(1).toDatoT()
//                    .getT()).obtenerEspecifico(index).toDatoString().getCadena();
            
            String elemento = ListaToDo.getSelectedValue();
            Tarea tarea = new Tarea();
            
            this.listEnProcesoModel.addElement(elemento);
            // this.listPorHacerModel.removeElement(listPorHacerModel.get(index));
            this.listPorHacerModel.remove(index);
            ((ListaDC)(this.enProceso.obtenerEspecifico(0).toDatoT().getT())).agregarListaDC(tareaId, listEnProcesoModel.getSize()+1);
            (((ListaDC)this.enProceso.obtenerEspecifico(1).toDatoT().getT())).agregarListaDC(elemento, listEnProcesoModel.getSize()+1);
            (((ListaDC)this.porHacer.obtenerEspecifico(0).toDatoT().getT())).eliminarEspecifico(index);
            (((ListaDC)this.porHacer.obtenerEspecifico(1).toDatoT().getT())).eliminarEspecifico(index);
        }
    }//GEN-LAST:event_BtnPorHacer_EnProcesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JButton BtnPorHacer_EnProceso;
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
