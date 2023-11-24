/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.outros.categoria;

import com.mycompany.dao.DaoCargo;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModCargo;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ListCargo extends javax.swing.JFrame {

    public ListCargo() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCargo.getModel();
            
            tableCargo.setModel(defaultTableModel);
            
            DaoCargo daoCargo = new DaoCargo();
            
            ResultSet resultSet = daoCargo.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cargo = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, cargo});
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ListarPorId(int pId){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCargo.getModel();
            
            tableCargo.setModel(defaultTableModel);
            
            DaoCargo daoCargo = new DaoCargo();
            
            ResultSet resultSet =  daoCargo.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cargo = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, cargo});
             }
            }catch (Exception e) {
                   System.out.println(e.getMessage());
            }
        }
    
    public void ListarPorNome(String pNome){
        try{ //Define o Modelo da tabela
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCargo.getModel();
            
            tableCargo.setModel(defaultTableModel);

            DaoCargo daoCargo = new DaoCargo();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCargo.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cargo = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, cargo});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCargo = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tableCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCargo);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "ID", "NOME" }));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tableCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCargoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModCargo modCargo = new ModCargo();

                modCargo.setId(Integer.parseInt(String.valueOf(tableCargo.getValueAt(tableCargo.getSelectedRow(), 0))));
                modCargo.SetNome(String.valueOf(tableCargo.getValueAt(tableCargo.getSelectedRow(), 1)));

                DadosTemporarios.tempObject = (ModCargo) modCargo;

                CadCargo cadCargo = new CadCargo();
                cadCargo.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableCargoMouseClicked

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
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableCargo;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
