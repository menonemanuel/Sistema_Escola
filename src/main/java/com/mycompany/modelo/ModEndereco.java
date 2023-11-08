/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModEndereco {
    private int id;
    private int idCidade;
    private String nomeRua;
    private String cep;
    private String numeroResidencia;
    private String nomeMoradia;

    /**
     *
     * @param id
     * @param idCidade
     * @param nomeRua
     * @param cep
     * @param numeroResidencia
     * @param nomeMoradia
     */
    public ModEndereco(int id, int idCidade, String nomeRua, String cep, String numeroResidencia, String nomeMoradia) {
        this.id = id;
        this.idCidade = idCidade;
        this.nomeRua = nomeRua;
        this.cep = cep;
        this.numeroResidencia = numeroResidencia;
        this.nomeMoradia =  nomeMoradia;
    }

    /**
     *
     */
    public ModEndereco() {
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getIdCidade() {
        return idCidade;
    }

    /**
     *
     * @param idCidade
     */
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    /**
     *
     * @return
     */
    public String getNomeRua() {
        return nomeRua;
    }

    /**
     *
     * @param nomeRua
     */
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    /**
     *
     * @return
     */
    public String getCep() {
        return cep;
    }

    /**
     *
     * @param cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     *
     * @return
     */
    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    /**
     *
     * @param numeroResidencia
     */
    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }
    
    /**
     *
     * @return
     */
    public String getNomeMoradia() {
        return nomeMoradia;
    }

    /**
     *
     * @param nomeMoradia
     */
    public void setNomeMoradia(String nomeMoradia) {
        this.nomeMoradia = nomeMoradia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ModEndereco{" + "id=" + id + ", idCidade=" + idCidade + ", nomeRua=" + nomeRua + ", cep=" + cep + ", numeroResidencia=" + numeroResidencia + ", nomeMoradia=" + nomeMoradia + '}';
    }
}
