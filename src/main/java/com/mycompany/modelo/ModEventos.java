/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModEventos {
    
    private int id;
    private String nome;
    private String dia;
    private String local;
    private String horario;
    
    
    public ModEventos (int id, String nome, String dia, String local, String horario) {
        this.id =  id;
        this.nome = nome;
    }

    public ModEventos() {
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
    
    public String getDia() {
        return dia;
    }
    
    public void SetDia (String dia) {
        this.dia = dia;
    }
    
    public String getLocal() {
        return local;
    }
    
    public void SetLocal (String local) {
        this.local = local;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public void SetHorario (String horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString() {
         return "Cargo{" + "id=" + id + ", nome=" + nome + ", dia=" + dia + ", local=" + local + ", horario=" + horario +'}';
        }
    }
