/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModTurma {
    
    private int id;
    private int id_eventos;
    private int id_funcionario;
    private String serie;
    
    public ModTurma (int id, int id_eventos, int id_funcionario, String serie) {
        this.id =  id;
        this.id_eventos = id_eventos;
        this.id_funcionario = id_funcionario;
        this.serie = serie;
    }

    public ModTurma() {
    }
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id =id;
    }
    
    public int getIdEventos() {
        return id_eventos;
    }
    
    public void SetIdEventos (int id_eventos) {
        this.id_eventos = id_eventos;
    }
    
    public int getIdFuncionario() {
        return id_funcionario;
    }
    
    public void SetIdFuncioario (int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    
    public String getSerie() {
        return serie;
    }
    
    public void SetSerie (String serie) {
        this.serie = serie;
    }
    
    @Override
    public String toString() {
         return "Turma{" + "id=" + id + ", + id_eventos=" + id_eventos + ", + id_funcionario=" + id_funcionario + ", + serie=" + serie + '}';
    }
}
