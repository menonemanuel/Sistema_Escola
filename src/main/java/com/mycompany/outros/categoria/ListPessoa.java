/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.outros.categoria;

import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emanuel.4966
 */
public class ListPessoa extends javax.swing.JFrame {

    /**
     * Creates new form ListPessoa
     */
    public ListPessoa() {
        initComponents();
    }
    
    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int parseInt){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorIdEndereco(int paseInt){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorIdEndereco(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id, idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorSobrenome(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorSobrenome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorGenero(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorGenero(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorTelefone(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorTelefone(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                
                defaultTableModel.addRow(new Object[]{id, idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCpf(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorCpf(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorRg(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorRg(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorData_De_Nascimento(String text){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorData_De_Nascimento(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idEndereco = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sobrenome = resultSet.getString(4);
                String genero = resultSet.getString(5);
                String telefone = resultSet.getString(6);
                String cpf = resultSet.getString(7);
                String rg = resultSet.getString(8);
                String data_de_nascimento = resultSet.getString(9);
                
                defaultTableModel.addRow(new Object[]{id,  idEndereco, nome, sobrenome, genero, telefone, cpf, rg, data_de_nascimento});
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
        tablePessoa = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablePessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_ENDERECO", "NOME", "SOBRENOME", "GENERO", "TELEFONE", "RG", "CPF", "DATA_DE_NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePessoa);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "CIDADE", "RUA", "CEP", "NÚMERO", "MORADIA" }));
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
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(697, 699, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfFiltro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePessoaMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModPessoa modPessoa = new ModPessoa();

                modPessoa.setId(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0))));
                modPessoa.setIdEndereco(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 1))));
                modPessoa.setNome(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 2)));
                modPessoa.setSobrenome(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 3)));
                modPessoa.setGenero(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 4)));
                modPessoa.setTelefone(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 5)));
                modPessoa.setRg(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 6)));
                modPessoa.setCpf(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 7)));
                modPessoa.setData_de_nascimento(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 8)));

                DadosTemporarios.tempObject = (ModPessoa) modPessoa;

                CadPessoa cadPessoa = new CadPessoa();
                cadPessoa.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tablePessoaMouseClicked

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
        case 0:
            listarTodos();
                break;
                
        case 1:
            listarPorId(Integer.parseInt(tfFiltro.getText()));
               break;
        case 2:
            listarPorIdEndereco(Integer.parseInt(tfFiltro.getText()));
                break;
        case 3:
            listarPorNome(tfFiltro.getText());
               break;
        case 4:
            listarPorSobrenome(tfFiltro.getText());
               break;
        case 5:
            listarPorGenero(tfFiltro.getText());
              break;
        case 6:
            listarPorTelefone(tfFiltro.getText());
               break;
        case 7:
            listarPorRg(tfFiltro.getText());
               break;
        case 8:
            listarPorCpf(tfFiltro.getText());
                break;
        case  9:
            listarPorData_De_Nascimento(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tablePessoa;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
