/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

import java.sql.Date;

/**
 *
 * @author emanuel.4966
 */
public class ModPessoa {
    
    private int id;
    private int idEndereco;
    private int idEstadoCivil;
    private String nome;
    private String sobrenome;
    private String genero;
    private Date data_de_nascimento;
    private String telefone;
    private String email;
    private String usuario;
    private String senha;
    private String cpf;
    private String rg;

    public ModPessoa(int id, int idEndereco, int idEstadoCivil, String nome, String sobrenome, String genero, Date data_de_nascimento, String telefone, String email, String cpf, String rg) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.idEstadoCivil = idEstadoCivil;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.data_de_nascimento = data_de_nascimento;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this. rg = rg;
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

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
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
    
    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }
    
    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ModPessoa{" + "id=" + id + ", idEndereco=" + idEndereco + ", idEstadoCivil=" + idEstadoCivil + ", nome=" + nome + ", sobrenome=" + sobrenome + ", genero=" + genero + ", telefone=" + telefone + ", email=" + email + '}';
    }
}
