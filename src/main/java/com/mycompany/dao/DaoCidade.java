/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class DaoCidade extends BancoDeDadosMySql {
    
    private String sql; 

    public DaoCidade() {
    }
    
    /**
     *
     * @param id
     * @param nome
     * @return
     */
    public Boolean inserir(int id, String nome){
        try{
            sql = "INSERT INTO CIDADE (ID, NOME) VALUES (?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            
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
            sql = "UPDATE CIDADE SET NOME = ? WHERE ID = ?";
            
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
            sql = "DELETE FROM CIDADE WHERE ID = ?";
            
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
                "   CID.ID AS ID,           " +
                "   CID.NOME AS NOME        " +
                " FROM                      " +
                "   CIDADE CID              " ;
            
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
                "   CID.ID AS ID,           " +
                "   CID.NOME AS NOME        " +
                " FROM                      " +
                "   CIDADE CID              " +
                " WHERE                     " +
                "   CID.ID = ?              ";
            
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
                "   CID.ID AS ID,           " +
                "   CID.NOME AS NOME        " +
                " FROM                      " +
                "   CIDADE CID              " +
                " WHERE                     " +
                "   CID.NOME LIKE ?         ";
            
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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CIDADE";
            
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
