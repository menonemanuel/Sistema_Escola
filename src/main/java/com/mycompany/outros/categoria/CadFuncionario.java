/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.outros.categoria;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoFuncionario;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModFuncionario;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author emanuel.4966
 */
public class CadFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form CadFuncionario
     */
    public CadFuncionario() {
        initComponents();
        
        carregarCidades();
        
        if(!existeDadosTemporarios()){
            DaoFuncionario daoFuncionario = new DaoFuncionario();
            
            int id = daoFuncionario.buscarProximoId();
//            int idEnd = DaoEndereco.buscarProximoId();
            
            if (id > 0){
                GetId.setText(String.valueOf(id));
//                tfIdEndereco.setText(String.valueOf(idEnd));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCidade();
        
        setLocationRelativeTo(null);
        
        GetId.setEnabled(false);
        
        setExtendedState(MAXIMIZED_BOTH);
        
    }

    private Boolean existeDadosTemporarios(){    
        
        if(DadosTemporarios.tempObject instanceof ModFuncionario){
            
            int id = ((ModPessoa) DadosTemporarios.tempObject3).getId();
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
            
            int idTurma = ((ModFuncionario) DadosTemporarios.tempObject3).getIdTurma();
            int idEstadoCivil = ((ModFuncionario) DadosTemporarios.tempObject3).getIdEstadoCivil();
            int idCargo = ((ModFuncionario) DadosTemporarios.tempObject3).getIdCargo();
            String salario = ((ModFuncionario) DadosTemporarios.tempObject3).getSalario();
            String dias_de_trabalho = ((ModFuncionario) DadosTemporarios.tempObject3).getDias_de_trabalho();
            String carga_horaria = ((ModFuncionario) DadosTemporarios.tempObject3).getCarga_horaria();
            String num_conta_bancaria = ((ModFuncionario) DadosTemporarios.tempObject3).getNum_conta_bancaria();
            
            int index = 0;
            for(int i = 0; i < jcbGenero.getItemCount(); i++){
                if(jcbGenero.getItemAt(i).equals(genero)){
                    index = i;
                    break;
                }
            }
            
            GetId.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idEndereco));
            tfNome.setText(nome);
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
            jcbTurma.setSelectedIndex(index);
            jcbEstadoCivil.setSelectedIndex(index);
            jcbCargo.setSelectedIndex(index);
            tfSalario.setText(String.valueOf(salario));
            tfDias_de_trabalho.setText(String.valueOf(dias_de_trabalho));
            tfCarga_horaria.setText(String.valueOf(carga_horaria));
            tfNum_conta_bancaria.setText(String.valueOf(num_conta_bancaria));
            
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfDatadenascimento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfMoradia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfNumeroResidencia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        GetId = new javax.swing.JTextField();
        tfIdEndereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbTurma = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        tfSalario = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfDias_de_trabalho = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfCarga_horaria = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        tfNum_conta_bancaria = new javax.swing.JTextField();
        tfIdCidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("NOME:");

        jLabel5.setText("SOBRENOME:");

        jLabel6.setText("NÚMERO DE TELEFONE:");

        jLabel11.setText("DATA DE NASCIMENTO:");

        jLabel2.setText("RG:");

        jLabel7.setText("CPF:");

        jLabel3.setText("GÊNERO:");

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maculino", "Feminino" }));
        jcbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGeneroActionPerformed(evt);
            }
        });

        jLabel8.setText("RUA:");

        jLabel12.setText("CIDADE:");

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

        jLabel14.setText("NÚMERO RESIDÊNCIA:");

        jLabel13.setText("CEP:");

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

        GetId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetIdActionPerformed(evt);
            }
        });

        tfIdEndereco.setEditable(false);
        tfIdEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdEnderecoActionPerformed(evt);
            }
        });

        jLabel10.setText("ID Endereço");

        jLabel1.setText("ID");

        jLabel15.setText("TURMA:");

        jLabel16.setText("ESTADO CIVIL:");

        jLabel18.setText("SALÁRIO:");

        jLabel19.setText("DIAS DE TRABALHO:");

        jLabel20.setText("CARGA HORÁRIA:");

        jLabel21.setText("CARGO:");

        jLabel22.setText("CONTA BANCÁRIA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                    .addComponent(tfSobrenome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDatadenascimento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfRg, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfSalario)
                                    .addComponent(tfDias_de_trabalho)
                                    .addComponent(tfCarga_horaria)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel15))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfCep, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfNumeroResidencia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfMoradia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcbCidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfRua, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcbGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, 426, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(GetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(71, 71, 71)
                                            .addComponent(jLabel10))
                                        .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(0, 195, Short.MAX_VALUE))
                                    .addComponent(tfNum_conta_bancaria)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDias_de_trabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCarga_horaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNum_conta_bancaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGeneroActionPerformed

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
//        DaoEndereco daoEndereco = new DaoEndereco();
//        DaoPessoa daoPessoa = new DaoPessoa();
//
//        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
//            inserirEndereco();
//            inserir();
//
//            GetId.setText(String.valueOf(daoPessoa.buscarProximoId()));
//            tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
//        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
//            alterarEndereco();
//            alterar();
//        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha =
        JOptionPane.showConfirmDialog(
            null,
            "Deseja realmente excluir a pessoa " + tfNome.getText() + "?");

        if(escolha == JOptionPane.YES_OPTION)
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void GetIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GetIdActionPerformed

    private void tfIdEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdEnderecoActionPerformed

//    private void inserir(){
//        DaoFuncionario daoFuncionario = new DaoFuncionario();
//        
//        if (daoFuncionario.inserir(Integer.parseInt(GetId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfDatadenascimento.getText(), tfTelefone.getText(), tfCpf.getText(), tfRg.getText(), tfRua.getText(), tfMoradia.getText(), tfCep.getText(), tfNumeroResidencia.getText(), (String) jcbAluno.getSelectedItem(), (String) jcbCargo.getSelectedItem(), (String) jcbEstadoCivil.getSelectedItem(), (String) jcbTurma.getSelectedItem())){
//            JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
//            
//            GetId.setText("");
//            tfIdEndereco.setText("");
//            tfNome.setText("");
//            tfSobrenome.setText("");
//            jcbGenero.getSelectedItem();
//            tfDatadenascimento.setText("");
//            tfTelefone.setText("");
//            tfCpf.setText("");
//            tfRg.setText("");
//            tfRua.setText("");
//            tfMoradia.setText("");
//            tfCep.setText("");
//            tfNumeroResidencia.setText("");
//            jcbTurma.getSelectedItem();
//            jcbEstadoCivil.getSelectedItem();
//            jcbCargo.getSelectedItem();
//            tfSalario.setText("");
//            tfDias_de_trabalho.setText("");
//            tfCarga_horaria.setText("");
//            tfNum_conta_bancaria.setText("");
//            
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possível salvar a pessoa!");
//        }
//    }
    
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
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            tfIdEndereco.setText("");
            tfIdCidade.setText("");
            tfRua.setText("");
            tfCep.setText("");
            tfNumeroResidencia.setText("");
            tfMoradia.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
        }
    }
        
//    private void alterar(){
//        DaoFuncionario daoFuncionario = new DaoFuncionario();
//        
//        if (daoFuncionario.inserir(Integer.parseInt(GetId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfDatadenascimento.getText(), tfTelefone.getText(), tfCpf.getText(), tfRg.getText(), tfRua.getText(), tfMoradia.getText(), tfCep.getText(), tfNumeroResidencia.getText(), (String) jcbAluno.getSelectedItem())){
//            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
//            
//            GetId.setText("");
//            tfIdEndereco.setText("");
//            tfNome.setText("");
//            tfSobrenome.setText("");
//            jcbGenero.getSelectedItem();
//            tfDatadenascimento.setText("");
//            tfTelefone.setText("");
//            tfCpf.setText("");
//            tfRg.setText("");
//            tfRua.setText("");
//            tfMoradia.setText("");
//            tfCep.setText("");
//            tfNumeroResidencia.setText("");
//            jcbAluno.getSelectedItem();
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
//        }
//        
//        ((ListPessoa) Formularios.listPessoa).listarTodos();
//        
//        dispose();
//    }
     
    private void excluir(){
            DaoFuncionario daoFuncionario = new DaoFuncionario();
        
        if (daoFuncionario.excluir(Integer.parseInt(GetId.getText()))){
            JOptionPane.showMessageDialog(null, "Pessoa " + GetId.getText() + " excluída com sucesso!");
            
            GetId.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a pessoa!");
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
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadFuncionario().setVisible(true);
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEstadoCivil;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbTurma;
    private javax.swing.JTextField tfCarga_horaria;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfDatadenascimento;
    private javax.swing.JTextField tfDias_de_trabalho;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfMoradia;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNum_conta_bancaria;
    private javax.swing.JTextField tfNumeroResidencia;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
