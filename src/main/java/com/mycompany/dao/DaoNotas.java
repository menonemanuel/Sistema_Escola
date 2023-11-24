/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
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
public class DaoNotas extends BancoDeDadosMySql {
    
    private String sql;
    
    public Boolean inserir(int id, int id_aluno, String nome, String notas, String trimestre){
        try{
            sql = "INSERT INTO CARGO (ID, ID_ALUNO, NOTAS, TRIMESTRE) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(1, id_aluno);
            getStatement().setString(2, notas);
            getStatement().setString(2, trimestre);
            
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
     * @return
     */
    public Boolean alterar(int id, String novoNome){
        try{
            sql = "UPDATE CARGO SET NOME = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
            getStatement().setString(1, novoNome);
            
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
            sql = "DELETE FROM CARGO WHERE ID = ?";
            
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
                "   CAR.ID AS ID,           " +
                "   CAR.NOME AS NOME        " +
                " FROM                      " +
                "   CARGO CAR               " ;
            
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
                " SELECT                    " +
                "   CARG.ID AS ID,          " +
                "   CARG.ID_ALUNO AS ID_ALU " +
                "   CARG.NOME AS NOTAS      " +
                "   CARG.NOME AS TRIMESTRE  " +
                " FROM                      " +
                "   CARGO CAR               " +
                " WHERE                     " +
                "   CAR.ID = ?              ";
            
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
                "   CAR.ID AS ID,           " +
                "   CAR.NOME AS NOME        " +
                " FROM                      " +
                "   CARGO CAR               " +
                " WHERE                     " +
                "   CAR.NOME LIKE ?         ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @return
     */
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CARGO";
            
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
