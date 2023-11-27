/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author emanuel.4966
 */
public class ModNotas {
    
    private int id;
    private int id_aluno;
    private String notas;
    private String trimestre;
    
    public ModNotas (int id, int id_aluno, String notas, String trimestre) {
        this.id =  id;
        this.id_aluno =  id_aluno;
        this.notas = notas;
        this.trimestre = trimestre;
    }

    public ModNotas() {
    }
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id =id;
    }
    
    public int getIdAluno() {
        return id_aluno;
    }
    
    public void setIdAluno (int id_aluno) {
        this.id_aluno = id_aluno;
    }
    
    public String getNotas() {
        return notas;
    }
    
    public void setNotas (String notas) {
        this.notas = notas;
    }
    
    public String getTrimestre() {
        return trimestre;
    }
    
    public void setTrimestre (String trimestre) {
        this.trimestre = trimestre;
    }
    
    @Override
    public String toString() {
         return "Notas{" + "id=" + id + ", + id_aluno=" + id_aluno + ", + notas=" + notas + ", + trimestre=" + trimestre + '}';
        }
}
