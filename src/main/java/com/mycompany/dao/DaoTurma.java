/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import static com.mycompany.ferramentas.BancoDeDadosMySql.getConexao;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getStatement;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setStatement;
import java.sql.ResultSet;

public class DaoTurma {
    
    private String sql;
    
    public Boolean inserir(int id, int idFuncionario, String serie){
        try{
            sql = "INSERT INTO TURMA (ID, ID_FUNCIONARIO, SERIE) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idFuncionario);
            getStatement().setString(3, serie);
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idFuncionario, String NovaSerie){
        try{
            sql = "UPDATE TURMA SET SERIE = ? ID_FUNCIONARIO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idFuncionario);
            getStatement().setString(3, NovaSerie);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM TURMA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql = 
                " SELECT                          " +
                "   TURMA.ID AS ID,               " +
                "   TURMA.SERIE AS SE             " +
                " FROM                            " +
                "   TURMA AS TURMA                " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                          " +
                "   TURMA.ID AS ID,               " +
                "   TURMA.ID_FUNCIONARIO AS FUN,  " +
                "   TURMA.SERIE AS SE             " +
                " FROM                      " +
                "   TURMA AS TURMA          " +
                " WHERE                     " +
                "   TURMA.ID = ?            ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdFuncionario(int id_funcionario){
        try{
            sql = 
                " SELECT                          " +
                "   TURMA.ID AS ID,               " +
                "   TURMA.ID_FUNCIONARIO AS FUN,  " +
                "   TURMA.SERIE AS SE             " +
                " FROM                            " +
                "   TURMA AS TURMA                " +
                " WHERE                           " +
                "   TURMA.ID_FUNCIONARIO = ?      ";
            
    setStatement(getConexao().prepareStatement(sql));
            
        getStatement().setInt(1, id_funcionario);
            
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        
        return getResultado();
    }
    
    public ResultSet listarPorSerie(String serie){
        try{
            sql = 
                " SELECT                          " +
                "   TURMA.ID AS ID,               " +
                "   TURMA.SERIE AS SE            " +
                " FROM                            " +
                "   TURMA AS TURMA                " +
                " WHERE                           " +
                "   TURMA.SERIE LIKE ?               ";
    setStatement(getConexao().prepareStatement(sql));
            
        getStatement().setString(1, serie);
            
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM TURMA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
