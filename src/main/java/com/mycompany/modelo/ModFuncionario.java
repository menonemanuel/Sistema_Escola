/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModFuncionario {
    
    private int id;
    private int idPessoa;
    private int idTurma;
    private int idEstadoCivil;
    private int idCargo;
    private String salario;
    private String dias_de_trabalho;
    private String carga_horaria;
    private String num_conta_bancaria;

    public ModFuncionario(int id, int idPessoa, int idTurma, int idEstadoCivil, int idCargo, String salario, String dias_de_trabalho, String carga_horaria, String num_conta_bancaria) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idTurma = idTurma;
        this.idEstadoCivil = idEstadoCivil;
        this.idCargo = idCargo;
        this.salario = salario;
        this.dias_de_trabalho = dias_de_trabalho;
        this.carga_horaria = carga_horaria;
        this.num_conta_bancaria = num_conta_bancaria;
    }

    public ModFuncionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int nome) {
        this.idTurma = idTurma;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
    
    public String getSalario() {
        return salario;
    }
    
    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDias_de_trabalho() {
        return dias_de_trabalho;
    }

    public void setDias_de_trabalho(String dias_de_trabalho) {
        this.dias_de_trabalho = dias_de_trabalho;
    }
    
    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    
    public String getNum_conta_bancaria() {
        return num_conta_bancaria;
    }
    
    public void setnum_conta_bancaria(String num_conta_bancaria) {
        this.num_conta_bancaria = num_conta_bancaria;
    }
    
    @Override
    public String toString() {
        return "ModFuncionario{" + "id=" + id + ", idPessoa=" + idPessoa + ", idTurma=" + idTurma + ", idEstadoCivil=" + idEstadoCivil + ", idCargo=" + idCargo + ", salario=" + salario + ", dias_de_trabalho=" + dias_de_trabalho + ", carga_horaria=" + carga_horaria +", num_conta_bancaria=" + num_conta_bancaria + '}';
    }

    public String getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
