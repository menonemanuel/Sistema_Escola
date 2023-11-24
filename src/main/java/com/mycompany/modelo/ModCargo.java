/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModCargo {
    
    private int id;
    private String nome;
    
    /**
     *
     * @param id
     * @param nome
     */
    public ModCargo (int id, String nome) {
        this.id =  id;
        this.nome = nome;
    }

    /**
     *
     */
    public ModCargo() {
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
         return "Cargo{" + "id=" + id + ", nome=" + nome + '}';
        }
    }
