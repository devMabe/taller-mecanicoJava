
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class consultar2 extends javax.swing.JFrame {
    
    /**
     * Creates new form consultar2
     */
    public consultar2() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        //fondo
        ImageIcon imagen = new ImageIcon(getClass().getResource("/fondos/fondoconsultas.jpg"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(Lfondo.getWidth(), Lfondo.getHeight(), Image.SCALE_DEFAULT));
        Lfondo.setIcon(fondo);
        this.repaint();
        
        if(registro.trabajos.size()==0){
            Bbuscarid.setEnabled(false);
        }else{
            Bbuscarid.setEnabled(true);
        }
        
        //Tabla Todos
        DefaultTableModel modelo = (DefaultTableModel) tablaConsultaTodos.getModel();
        modelo.getDataVector().clear();
        for (int k = 0; k < registro.trabajos.size(); k++) {
            modelo.addRow(new Object[]{"", "", "", "", ""});
        }
        for (int i = 0; i < registro.trabajos.size(); i++) {
            tablaConsultaTodos.setValueAt(registro.trabajos.get(i).getId(), i, 0);
            tablaConsultaTodos.setValueAt(registro.trabajos.get(i).getTipotrabajo(), i, 1);
            tablaConsultaTodos.setValueAt(registro.trabajos.get(i).getDescripcion(), i, 2);
            tablaConsultaTodos.setValueAt(registro.trabajos.get(i).getNhoras(), i, 3);
            if(registro.trabajos.get(i).getEstado()==false){
                tablaConsultaTodos.setValueAt("En proceso", i, 4);
            }else{
                tablaConsultaTodos.setValueAt("Finalizado", i, 4);
            }
        }
        
        //Tabla Revision
        DefaultTableModel modelo2 = (DefaultTableModel) tablaConsultaRevision.getModel();
        modelo2.getDataVector().clear();
        for (int k = 0; k < registro.revisiones.size(); k++) {
            modelo2.addRow(new Object[]{"", "", "", "", ""});
        }
        for (int i = 0; i < registro.revisiones.size(); i++) {
            tablaConsultaRevision.setValueAt(registro.revisiones.get(i).getId(), i, 0);
            tablaConsultaRevision.setValueAt(registro.revisiones.get(i).getTipotrabajo(), i, 1);
            tablaConsultaRevision.setValueAt(registro.revisiones.get(i).getDescripcion(), i, 2);
            tablaConsultaRevision.setValueAt(registro.revisiones.get(i).getNhoras(), i, 3);
            if(registro.revisiones.get(i).getEstado()==false){
                tablaConsultaRevision.setValueAt("En proceso", i, 4);
            }else{
                tablaConsultaRevision.setValueAt("Finalizado", i, 4);
            }
        }
        
        //consulta reparación
        DefaultTableModel modelo3 = (DefaultTableModel) tablaConsultaReparacion.getModel();
        modelo3.getDataVector().clear();
        for (int k = 0; k < registro.reparaciones.size(); k++) {
            modelo3.addRow(new Object[]{"", "", "", "", "", ""});
        }
        for (int i = 0; i < registro.reparaciones.size(); i++) {
            tablaConsultaReparacion.setValueAt(registro.reparaciones.get(i).getId(), i, 0);
            tablaConsultaReparacion.setValueAt(registro.reparaciones.get(i).getTipotrabajo(), i, 1);
            tablaConsultaReparacion.setValueAt(registro.reparaciones.get(i).getTipo(), i, 2);
            tablaConsultaReparacion.setValueAt(registro.reparaciones.get(i).getDescripcion(), i, 3);
            tablaConsultaReparacion.setValueAt(registro.reparaciones.get(i).getNhoras(), i, 4);
            if(registro.reparaciones.get(i).getEstado()==false){
                tablaConsultaReparacion.setValueAt("En proceso", i, 5);
            }else{
                tablaConsultaReparacion.setValueAt("Finalizado", i, 5);
            }
        }
        
        //consulta en proceso
        DefaultTableModel modelo4 = (DefaultTableModel) tablaConsultaProceso.getModel();
        modelo4.getDataVector().clear();
        int counter=0;
        for (int k = 0; k < registro.trabajos.size(); k++) {
            if(registro.trabajos.get(k).getEstado()==false){
               modelo4.addRow(new Object[]{"", "", "", "", "", ""}); 
               counter++;
            }
        }
        if(counter==0){
            JOptionPane.showMessageDialog(this, "No hay trabajos en proceso actualmente");
        }else{
            counter=0;
            for (int k = 0; k < registro.trabajos.size(); k++) {
                if(registro.trabajos.get(k).getEstado()==false){
                    tablaConsultaProceso.setValueAt(registro.trabajos.get(k).getId(), counter, 0);
                    tablaConsultaProceso.setValueAt(registro.trabajos.get(k).getTipotrabajo(),counter, 1);
                    tablaConsultaProceso.setValueAt(registro.trabajos.get(k).getDescripcion(), counter, 2);
                    tablaConsultaProceso.setValueAt(registro.trabajos.get(k).getNhoras(), counter, 3);
                    if(registro.trabajos.get(k).getEstado()==false){
                        tablaConsultaProceso.setValueAt("En proceso", counter, 4);
                    }else{
                        tablaConsultaProceso.setValueAt("Finalizado", counter, 4);
                    }
                    counter++;
                }
            }
        }
        
        //consulta en finalizado
        DefaultTableModel modelo5 = (DefaultTableModel) tablaConsultaFinalizado.getModel();
        modelo5.getDataVector().clear();
        int counter2=0;
        for (int k = 0; k < registro.trabajos.size(); k++) {
            if(registro.trabajos.get(k).getEstado()==true){
               modelo5.addRow(new Object[]{"", "", "", "", "", ""}); 
               counter2++;
            }
        }
        if(counter2==0){
            JOptionPane.showMessageDialog(this, "No hay trabajos en finalizados actualmente");
        }else{
            counter2=0;
            for (int k = 0; k < registro.trabajos.size(); k++) {
                if(registro.trabajos.get(k).getEstado()==true){
                    tablaConsultaFinalizado.setValueAt(registro.trabajos.get(k).getId(), counter2, 0);
                    tablaConsultaFinalizado.setValueAt(registro.trabajos.get(k).getTipotrabajo(),counter2, 1);
                    tablaConsultaFinalizado.setValueAt(registro.trabajos.get(k).getDescripcion(), counter2, 2);
                    tablaConsultaFinalizado.setValueAt(registro.trabajos.get(k).getNhoras(), counter2, 3);
                    if(registro.trabajos.get(k).getEstado()==false){
                        tablaConsultaFinalizado.setValueAt("En proceso", counter2, 4);
                    }else{
                        tablaConsultaFinalizado.setValueAt("Finalizado", counter2, 4);
                    }
                    counter2++;
                }
            }
        }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaTodos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaConsultaRevision = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsultaReparacion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaConsultaId = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        TFconsultaid = new javax.swing.JTextField();
        Bbuscarid = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaConsultaProceso = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaConsultaFinalizado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Lfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CONSULTAR TRABAJOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        tablaConsultaTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaConsultaTodos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Todos", jPanel2);

        tablaConsultaRevision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaConsultaRevision);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Revisión", jPanel3);

        tablaConsultaReparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "TIPO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaConsultaReparacion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reparación", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaConsultaId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaConsultaId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaConsultaId);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ingrese ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        TFconsultaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFconsultaidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TFconsultaid, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TFconsultaid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Bbuscarid.setBackground(new java.awt.Color(0, 204, 255));
        Bbuscarid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Bbuscarid.setText("BUSCAR");
        Bbuscarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbuscaridActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bbuscarid)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(Bbuscarid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Por ID", jPanel5);

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaConsultaProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaConsultaProceso);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("En Proceso", jPanel10);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaConsultaFinalizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJO", "DESCRIPCIÓN", "HORAS", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaConsultaFinalizado);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Finalizado", jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Por estado", jPanel8);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 600, 230));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 100, -1));
        jPanel1.add(Lfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFconsultaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFconsultaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFconsultaidActionPerformed

    private void BbuscaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbuscaridActionPerformed
        // TODO add your handling code here:
        boolean valid=false;
        int pos=0;

        if(TFconsultaid.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresr un ID", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else{
            for(int i=0; i<registro.trabajos.size(); i++){
                if(registro.trabajos.get(i).getId().equalsIgnoreCase(TFconsultaid.getText())){
                    valid=true;
                    pos=i;
                }
            }
            if(valid){
                DefaultTableModel modelo4 = (DefaultTableModel) tablaConsultaId.getModel();
                modelo4.getDataVector().clear();
                modelo4.addRow(new Object[]{"", "", "", "", ""});

                tablaConsultaId.setValueAt(registro.trabajos.get(pos).getId(), 0, 0);
                tablaConsultaId.setValueAt(registro.trabajos.get(pos).getTipotrabajo(), 0, 1);
                tablaConsultaId.setValueAt(registro.trabajos.get(pos).getDescripcion(), 0, 2);
                tablaConsultaId.setValueAt(registro.trabajos.get(pos).getNhoras(), 0, 3);
                if (registro.trabajos.get(pos).getEstado() == false) {
                    tablaConsultaId.setValueAt("En proceso", 0, 4);
                } else {
                    tablaConsultaId.setValueAt("Finalizado", 0, 4);
                }

            }else{
                JOptionPane.showMessageDialog(this, "ID no encontrada");
            }
        }

    }//GEN-LAST:event_BbuscaridActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consultar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultar2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultar2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bbuscarid;
    private javax.swing.JLabel Lfondo;
    private javax.swing.JTextField TFconsultaid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaConsultaFinalizado;
    private javax.swing.JTable tablaConsultaId;
    private javax.swing.JTable tablaConsultaProceso;
    private javax.swing.JTable tablaConsultaReparacion;
    private javax.swing.JTable tablaConsultaRevision;
    private javax.swing.JTable tablaConsultaTodos;
    // End of variables declaration//GEN-END:variables
}
