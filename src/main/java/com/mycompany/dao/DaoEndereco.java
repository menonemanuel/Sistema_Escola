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
import javax.swing.JTextField;

/**
 *
 * @author emanuel.4966
 */
public class DaoEndereco extends BancoDeDadosMySql {
    
    String sql;
    
    /**
     *
     * @param id
     * @param idCidade
     * @param nomeRua
     * @param cep
     * @param numeroResidencia
     * @param moradia
     * @return
     */
    public Boolean inserir(int id, int idCidade, String nomeRua, String cep, String numeroResidencia, String moradia){
        try{
            sql = "INSERT INTO ENDERECO (ID, ID_CIDADE, NOME_RUA, CEP, NUM_RESIDENCIA,  MORADIA) VALUES (?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCidade);
            getStatement().setString(3, nomeRua);
            getStatement().setString(4, cep);
            getStatement().setString(5, numeroResidencia);
            getStatement().setString(6, moradia);
            
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
     * @param idNovaCidade
     * @param novoNomeRua
     * @param novoCep
     * @param novoNumeroResidencia
     * @param novaMoradia
     * @return
     */
    
    public Boolean alterar(int id, int idNovaCidade, String novoNomeRua, String novoCep, String novoNumeroResidencia, String novaMoradia){
        try{
            sql = "UPDATE ENDERECO SET WHERE ID = ?, ID_CIDADE = ?, NOME_RUA = ?, CEP = ?, NUM_RESIDENCIA = ?, MORADIA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idNovaCidade);
            getStatement().setString(2, novoNomeRua);
            getStatement().setString(3, novoCep);
            getStatement().setString(4, novoNumeroResidencia);
            getStatement().setString(5, novaMoradia);
            getStatement().setInt(6, id);
            
            
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
            sql = "DELETE FROM ENDERECO WHERE ID = ?";
            
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
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.ID_CIDADE           " ;
            
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
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,         " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.ID_CIDADE           " +
                " WHERE                             " +
                "   EN.ID = ?                       " ;
            
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
     * @param cidade
     * @return
     */
    public ResultSet listarPorCidade(String cidade){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +    
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.ID_CIDADE           " +
                " WHERE                             " +
                "   CID.ID LIKE ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cidade + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNomeRua(String nomeRua){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " WHERE                             " +
                "   EN.NOME_RUA LIKE ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomeRua + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param cep
     * @return
     */
    public ResultSet listarPorCep(String cep){
        try{
            sql = 
               " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " WHERE                             " +
                "   EN.CEP LIKE ?                   " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param numeroResidencia
     * @return
     */
    public ResultSet listarPorNumeroResidencia(String numeroResidencia){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES," +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " WHERE                             " +
                "   EN.NUM_RESIDENCIA LIKE ?     " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, numeroResidencia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param nomeMoradia
     * @return
     */
    public ResultSet listarPorNomeMoradia(String nomeMoradia){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   EN.ID_CIDADE AS ID_CID,        " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CE,                  " +
                "   EN.NUM_RESIDENCIA AS NUM_RES,   " +
                "   EN.MORADIA AS MORA              " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " WHERE                             " +
                "   EN.MORADIA LIKE ?               " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomeMoradia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    /**
     *
     * @param cidade
     * @return
     */
    
    /**
     *
     * @return
     */
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ENDERECO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
