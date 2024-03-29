/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.outros.categoria;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.dao.DaoTurma;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author emanuel.4966
 */
public class CadPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa
     */
    public CadPessoa() {
        initComponents();
    
        carregarCidades();
        carregarTurmas();
        
        if(!existeDadosTemporarios()){
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoEndereco daoEndereco = new DaoEndereco();
            
            int id = daoPessoa.buscarProximoId(); 
            int idEnd = daoEndereco.buscarProximoId();
            if (id > 0){
                GetId.setText(String.valueOf(id));
                tfIdEndereco.setText(String.valueOf(idEnd));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCidade();
        recuperaIdTurma();
        
        setLocationRelativeTo(null);
        
        GetId.setEnabled(false);
        tfIdTurma.setVisible(false);
        
        setExtendedState(MAXIMIZED_BOTH);
        
    }

    private Boolean existeDadosTemporarios(){    
        
        if(DadosTemporarios.tempObject instanceof ModPessoa){
            int id = ((ModPessoa) DadosTemporarios.tempObject).getId();
            int idEndereco = ((ModPessoa) DadosTemporarios.tempObject).getIdEndereco();
            String nome = ((ModPessoa) DadosTemporarios.tempObject).getNome();
            String sobrenome = ((ModPessoa) DadosTemporarios.tempObject).getSobrenome();
            String genero = ((ModPessoa) DadosTemporarios.tempObject).getGenero();
            String Data_de_nascimento = ((ModPessoa) DadosTemporarios.tempObject).getData_de_nascimento();
            String telefone = ((ModPessoa) DadosTemporarios.tempObject).getTelefone();
            String cpf = ((ModPessoa) DadosTemporarios.tempObject).getCpf();
            String rg = ((ModPessoa) DadosTemporarios.tempObject).getRg();
            
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getNomeRua();
            String moradia = ((ModEndereco) DadosTemporarios.tempObject2).getNomeMoradia();
            String cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            String numero_residencia = ((ModEndereco) DadosTemporarios.tempObject2).getNumeroResidencia();
            
            int index = 0;
            for(int i = 0; i < jcbGenero.getItemCount(); i++){
                if(jcbGenero.getItemAt(i).equals(genero)){
                    index = i;
                    break;
                }
            }
            
            GetId.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idEndereco));
            tfNomeAluno.setText(nome);
            tfSobrenome.setText(telefone);
            tfTelefone.setText(telefone);
            jcbGenero.setSelectedIndex(index);
            tfDatadenascimento.setText(Data_de_nascimento);
            tfCpf.setText(cpf);
            tfRg.setText(rg);
            tfRua.setText(rua);
            tfMoradia.setText(moradia);
            tfCep.setText(cep);
            tfNumeroResidencia.setText(numero_residencia);
            jcbGenero.setSelectedIndex(index);
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next())
                jcbCidade.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void carregarTurmas(){
        try{
            DaoTurma daoTurma = new DaoTurma();

            ResultSet resultSet = daoTurma.listarTodos();

            while(resultSet.next())
                jcbTurma.addItem(resultSet.getString("SE"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdTurma(){
        try{
            DaoTurma daoTurma = new DaoTurma();
            ResultSet resultSet = daoTurma.listarPorSerie(jcbTurma.getSelectedItem().toString());
            
            resultSet.next();
            tfIdTurma.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        tfIdFuncionario = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jcbGenero = new javax.swing.JComboBox<>();
        tfIdCidade = new javax.swing.JTextField();
        jcbCidade = new javax.swing.JComboBox<>();
        tfMoradia = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNomeAluno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        GetId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfIdEndereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        tfDatadenascimento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfNumeroResidencia = new javax.swing.JTextField();
        tfIdTurma = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfPai = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfMae = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfResponsaveis = new javax.swing.JTextField();
        jcbTurma = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tfIdFuncionario.setText("ID FUNCIONARIO");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maculino", "Feminino" }));
        jcbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGeneroActionPerformed(evt);
            }
        });

        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });
        jcbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCidadeActionPerformed(evt);
            }
        });

        jLabel9.setText("MORADIA:");

        jLabel8.setText("RUA:");

        jLabel6.setText("NÚMERO DE TELEFONE:");

        jLabel5.setText("SOBRENOME:");

        jLabel4.setText("NOME:");

        GetId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        tfIdEndereco.setEditable(false);
        tfIdEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdEnderecoActionPerformed(evt);
            }
        });

        jLabel10.setText("ID Endereço");

        jLabel7.setText("CPF:");

        jLabel11.setText("DATA DE NASCIMENTO:");

        jLabel2.setText("RG:");

        jLabel3.setText("GÊNERO:");

        jLabel12.setText("CIDADE:");

        jLabel13.setText("CEP:");

        jLabel14.setText("NÚMERO RESIDÊNCIA:");

        tfIdTurma.setText("ID TURMA");

        jLabel15.setText("PAI:");

        jLabel16.setText("MÃE:");

        jLabel17.setText("RESPONSÁVEIS:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(289, 289, 289)
                    .addComponent(tfIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(503, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(567, 768, Short.MAX_VALUE))
                        .addComponent(tfRg)
                        .addComponent(tfCpf)
                        .addComponent(tfNumeroResidencia)
                        .addComponent(tfMoradia)
                        .addComponent(tfRua)
                        .addComponent(tfCep)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jcbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jcbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfDatadenascimento, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(71, 71, 71)
                                    .addComponent(jLabel10))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNomeAluno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfSobrenome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfMae)
                                .addComponent(tfPai)
                                .addComponent(tfResponsaveis)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel17))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jcbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(GetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(283, 283, 283)
                    .addComponent(tfIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(476, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel10))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel16))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel17))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfResponsaveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfNumeroResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel13)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        DaoEndereco daoEndereco = new DaoEndereco();
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserirEndereco();
            inserir();

            GetId.setText(String.valueOf(daoPessoa.buscarProximoId()));
            tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){            
            alterarEndereco();
            alterar();
        }      
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha =
        JOptionPane.showConfirmDialog(
            null,
            "Deseja realmente excluir o aluno " + tfNomeAluno.getText() + "?");

         if(escolha == JOptionPane.YES_OPTION)
           excluir();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void GetIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GetIdActionPerformed

    private void jcbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGeneroActionPerformed

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void tfIdEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdEnderecoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadPessoa = null;
    }//GEN-LAST:event_formWindowClosed

    private void inserir(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.inserir(Integer.parseInt(GetId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNomeAluno.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfDatadenascimento.getText(), tfTelefone.getText(), tfCpf.getText(), tfRg.getText(), tfRua.getText(), tfMoradia.getText(), tfCep.getText(), tfNumeroResidencia.getText(),tfPai.getText(), tfMae.getText(), tfResponsaveis.getText())){
            JOptionPane.showMessageDialog(null, "Aluno salva com sucesso!");
            
            GetId.setText("");
            tfIdEndereco.setText("");
            tfNomeAluno.setText("");
            tfSobrenome.setText("");
            jcbGenero.getSelectedItem();
            tfDatadenascimento.setText("");
            tfTelefone.setText("");
            tfCpf.setText("");
            tfRg.setText("");
            tfRua.setText("");
            tfMoradia.setText("");
            tfCep.setText("");
            tfNumeroResidencia.setText("");
            tfPai.setText("");
            tfMae.setText("");
            tfResponsaveis.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o aluno!");
        }
    }
    
    private void inserirEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumeroResidencia.getText(), tfMoradia.getText())){
//            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
            tfIdEndereco.setText("");
            tfIdCidade.setText("");
            tfRua.setText("");
            tfCep.setText("");
            tfNumeroResidencia.setText("");
            tfMoradia.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
        }
    }
     
    private void alterarEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumeroResidencia.getText(), tfMoradia.getText())){
            JOptionPane.showMessageDialog(null, "Aluno alterada com sucesso!");
            
            tfIdEndereco.setText("");
            tfIdCidade.setText("");
            tfRua.setText("");
            tfCep.setText("");
            tfNumeroResidencia.setText("");
            tfMoradia.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o aluno!");
        }
    }
    
    private void inserirTurma(){
        DaoTurma daoTurma = new DaoTurma();
        
//        if (daoTurma.inserir(Integer.parseInt(tfIdTurma.getText()), Integer.parseInt(tfIdFuncionario.getText()), tf.getText())){
////            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
//            
//            tfIdTurma.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possível salvar a turma!");
//        }
    }
        
    private void alterar(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.inserir(Integer.parseInt(GetId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNomeAluno.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfDatadenascimento.getText(), tfTelefone.getText(), tfCpf.getText(), tfRg.getText(), tfRua.getText(), tfMoradia.getText(), tfCep.getText(), tfNumeroResidencia.getText(),tfPai.getText(), tfMae.getText(), tfResponsaveis.getText())){
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            GetId.setText("");
            tfIdEndereco.setText("");
            tfNomeAluno.setText("");
            tfSobrenome.setText("");
            jcbGenero.getSelectedItem();
            tfDatadenascimento.setText("");
            tfTelefone.setText("");
            tfCpf.setText("");
            tfRg.setText("");
            tfRua.setText("");
            tfMoradia.setText("");
            tfCep.setText("");
            tfNumeroResidencia.setText("");
            tfPai.setText("");
            tfMae.setText("");
            tfResponsaveis.setText("");
            }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o aluno!");
        }
        
        ((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }
     
    private void excluir(){
            DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.excluir(Integer.parseInt(GetId.getText()))){
            JOptionPane.showMessageDialog(null, "Aluno " + GetId.getText() + " excluída com sucesso!");
            
            GetId.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o aluno!");
        }
        
        ((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }
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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GetId;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbTurma;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfDatadenascimento;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfIdFuncionario;
    private javax.swing.JTextField tfIdTurma;
    private javax.swing.JTextField tfMae;
    private javax.swing.JTextField tfMoradia;
    private javax.swing.JTextField tfNomeAluno;
    private javax.swing.JTextField tfNumeroResidencia;
    private javax.swing.JTextField tfPai;
    private javax.swing.JTextField tfResponsaveis;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
