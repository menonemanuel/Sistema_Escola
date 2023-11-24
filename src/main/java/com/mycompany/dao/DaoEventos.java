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

/**
 *
 * @author emanuel.4966
 */
public class DaoEventos {
    private String sql;
    
    public Boolean inserir(int id,  String nome, String dia, String local, String horario){
        try{
            sql = "INSERT INTO EVENTOS (ID,  NOME, DIA, LOCAL, HORARIO) VALUES (?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, dia);
            getStatement().setString(4, local);
            getStatement().setString(5, horario);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     *
     * @param id
     * @param novoNome
     * @param novoHorario
     * @param novoLocal
     * @param novoDia
     * @return
     */
    public Boolean alterar(int id, String novoNome, String novoHorario, String novoLocal, String novoDia){
        try{
            sql = "UPDATE EVENTOS SET NOME = ? SET HORARIO = ? SET LOCAL = ? SET DIA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, novoNome);
            getStatement().setString(2, novoHorario);
            getStatement().setString(3, novoLocal);
            getStatement().setString(4, novoDia);
            getStatement().setInt(5, id);
            
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM EVENTOS WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     *
     * @return
     */
    public ResultSet listarTodos(){
        try{
            sql = 
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +
                " FROM                      " +
                "   EVENTOS EV              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().executeUpdate();
            
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
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +
                " FROM                      " +
                "   EVENTOS EV              " +
                " WHERE                     " +
                "   EV.ID = ?               ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +    
                " FROM                      " +
                "   EVENTOS EV              " +
                " WHERE                     " +
                "   EV.NOME LIKE ?          ";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorHorario(String horario){
        try{
            sql = 
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +    
                " FROM                      " +
                "   EVENTOS EV              " +
                " WHERE                     " +
                "   EV.HORARIO LIKE ?          ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, horario);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorLocal(String local){
        try{
            sql = 
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +    
                " FROM                      " +
                "   EVENTOS EV              " +
                " WHERE                     " +
                "   EV.LOCAL LIKE ?         ";
         setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, local);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorDia(String dia){
        try{
            sql = 
                " SELECT                    " +
                "   EV.ID AS ID,            " +
                "   EV.NOME AS NO,          " +
                "   EV.HORARIO AS HORA,     " +
                "   EV.LOCAL AS LO,         " +
                "   EV.DIA AS DI            " +    
                " FROM                      " +
                "   EVENTOS EV              " +
                " WHERE                     " +
                "   EV.DIA LIKE ?           ";
         setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, dia);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM EVENTOS";
            
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
