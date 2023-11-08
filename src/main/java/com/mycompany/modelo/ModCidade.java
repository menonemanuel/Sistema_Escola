/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModCidade {
    
    private int id;
    private String nome;
    
    /**
     *
     * @param id
     * @param nome
     */
    public ModCidade (int id, String nome) {
        this.id =  id;
        this.nome = nome;
    }

    /**
     *
     */
    public ModCidade() {
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
        this.id =id;
    }
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    /**
     *
     * @param nome
     */
    public void SetNome (String nome) {
        this.nome = nome;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
         return "Cidade{" + "id=" + id + ", nome=" + nome + '}';
        }
    }
