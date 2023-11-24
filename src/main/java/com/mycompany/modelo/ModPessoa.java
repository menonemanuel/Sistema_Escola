/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModPessoa {
    
    private int id;
    private int idEndereco;
    private String nome;
    private String sobrenome;
    private String genero;
    private String data_de_nascimento;
    private String telefone;
    private String cpf;
    private String rg;
    private String rua;
    private String moradia;
    private String cep;

    public ModPessoa(int id, int idEndereco, String nome, String sobrenome, String genero, String data_de_nascimento, String telefone, String cpf, String rg, String rua, String moradia, String cep) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.data_de_nascimento = data_de_nascimento;
        this.telefone = telefone;
        this.cpf = cpf;
        this. rg = rg;
        this.rua = rua;
        this.moradia = moradia;
        this.cep =  cep;
    }

    public ModPessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getData_de_nascimento() {
        return data_de_nascimento;
    }
    
    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getMoradia() {
        return moradia;
    }
    
    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "ModPessoa{" + "id=" + id + ", idEndereco=" + idEndereco + ", nome=" + nome + ", sobrenome=" + sobrenome + ", genero=" + genero + ", telefone=" + telefone + ", cpf=" + cpf + ", rua=" + rua +", moradia=" + moradia + ", cep=" + cep + '}';
    }

    public String getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
