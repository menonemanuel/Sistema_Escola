/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

public class ModCargo {
    
    private int id;
    private String nome;
    
    public ModCargo (int id, String nome) {
        this.id =  id;
        this.nome = nome;
    }

    public ModCargo() {
    }
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id =id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void SetNome (String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
         return "Cargo{" + "id=" + id + ", nome=" + nome + '}';
        }
    }
