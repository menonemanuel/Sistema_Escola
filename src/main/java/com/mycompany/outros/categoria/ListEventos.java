/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.outros.categoria;

import com.mycompany.dao.DaoEventos;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEventos;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emanuel.4966
 */
public class ListEventos extends javax.swing.JFrame {

    /**
     * Creates new form ListEventos
     */
    public ListEventos() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
    /**
     *
     */
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);
            
            DaoEventos daoEventos = new DaoEventos();
            
            ResultSet resultSet = daoEventos.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param pId
     */
    public void ListarPorId(int pId){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);
            
            DaoEventos daoEventos = new DaoEventos();
            
            ResultSet resultSet =  daoEventos.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
             }
            }catch (Exception e) {
                   System.out.println(e.getMessage());
            }
        }
    
    /**
     *
     * @param pNome
     */
    public void ListarPorNome(String pNome){
        try{ //Define o Modelo da tabela
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);

            DaoEventos daoEventos = new DaoEventos();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEventos.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ListarPorDia(String pDia){
        try{ //Define o Modelo da tabela
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);

            DaoEventos daoEventos = new DaoEventos();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEventos.listarPorNome(pDia);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ListarPorLocal(String pLocal){
        try{ //Define o Modelo da tabela
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);

            DaoEventos daoEventos = new DaoEventos();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEventos.listarPorNome(pLocal);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ListarPorHorario(String pHorario){
        try{ //Define o Modelo da tabela
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEventos.getModel();
            
            tableEventos.setModel(defaultTableModel);

            DaoEventos daoEventos = new DaoEventos();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEventos.listarPorNome(pHorario);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String dia = resultSet.getString(3);
                String local = resultSet.getString(4);
                String horario = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, nome, dia, local, horario});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEventos = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Dia", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEventos);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "ID", "NOME", "DIA", "LOCAL" }));
        jcbTipoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoFiltroActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEventosMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModEventos modEventos = new ModEventos();

                modEventos.setId(Integer.parseInt(String.valueOf(tableEventos.getValueAt(tableEventos.getSelectedRow(), 0))));
                modEventos.SetNome(String.valueOf(tableEventos.getValueAt(tableEventos.getSelectedRow(), 1)));

                DadosTemporarios.tempObject = (ModEventos) modEventos;

                CadEventos cadEventos = new CadEventos();
                cadEventos.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableEventosMouseClicked

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
        case 0:
            listarTodos();
                break;
        case 1:
            ListarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
        case 2:
            ListarPorNome(tfFiltro.getText());
                break;
        case 3:
            ListarPorDia(tfFiltro.getText());
                break;
        case 4: 
            ListarPorLocal(tfFiltro.getText());
                break;
        case 5:
            ListarPorHorario(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ListEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEventos;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
