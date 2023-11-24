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
public class DaoPessoa extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir(int id, int idEndereco, String nome, String sobrenome, String genero, String data_de_nascimento, String telefone, String cpf, String rg, String rua, String moradia, String cep, String numero_residencia){
        try{
            sql = "INSERT INTO PESSOA (ID, ID_ENDERECO, NOME, SOBRENOME, GENERO, DATA_DE_NASCIMENTO, TELEFONE, CPF, RG, NOME_RUA, MORADIA, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idEndereco);
            getStatement().setString(3, nome);
            getStatement().setString(4, sobrenome);
            getStatement().setString(5, genero);
            getStatement().setString(6, data_de_nascimento);
            getStatement().setString(7, telefone);
            getStatement().setString(8, cpf);
            getStatement().setString(9, rg);
            getStatement().setString(10, rua);
            getStatement().setString(11, moradia);
            getStatement().setString(12, cep);
            getStatement().setString(13, numero_residencia);
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idEndereco, String nome, String sobrenome, String genero, String data_de_nascimento, String telefone, String cpf, String rg, String rua, String moradia, String cep, String numero_residencia){
        try{
            sql = "UPDATE PESSOA SET ID_ENDERECO = ?, NOME = ?, SOBRENOME = ?, GENERO = ?, DATA_DE_NASCIMENTO = ?, TELEFONE = ?, CPF = ?, RG = ?, RUA = ?, MORADIA = ?, CEP = ?, NUM_RESIDENCIA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idEndereco);
            getStatement().setString(3, nome);
            getStatement().setString(4, sobrenome);
            getStatement().setString(5, genero);
            getStatement().setString(6, data_de_nascimento);
            getStatement().setString(7, telefone);
            getStatement().setString(8, cpf);
            getStatement().setString(9, rg);
            getStatement().setString(10, rua);
            getStatement().setString(11, moradia);
            getStatement().setString(12, cep);
            getStatement().setString(13, numero_residencia);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PESSOA WHERE ID = ?";
            
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
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdEndereco(int idEndereco){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idEndereco);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorSobrenome(String sobrenome){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, sobrenome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorGenero(String genero){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, genero + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorTelefone(String telefone){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, telefone + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCpf(String cpf){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " JOIN ESTADO_CIVIL EC ON           " +
                "   EC.ID = P.ID_ESTADO_CIVIL       " +
                " WHERE P.SOBRENOME LIKE ?          " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cpf + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorRg (String rg){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, rg + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorData_De_Nascimento(String data_de_nascimento){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, data_de_nascimento + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorMoradia(String moradia){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, moradia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCep(String cep){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNum_Residencia(String num_residencia){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, num_residencia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorRua(String rua){
        try{
            sql = 
                " SELECT                            " +
                "   P.ID AS ID,                     " +
                "   P.ID_ENDERECO AS ID_ENDERECO    " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUM_RESIDENCIA AS NUM_RES,    " +
                "   P.NOME AS NOME,                 " +
                "   P.SOBRENOME AS SOBRENOME,       " +
                "   P.GENERO AS GENERO,             " +
                "   P.MORADIA AS MORA,              " +
                "   P.CEP AS CE,                    " +
                "   P.DATA_DE_NASCIMENTO AS DATA,   " +
                "   P.TELEFONE AS TELEFONE,         " +
                "   P.CPF AS CPF,                   " +
                "   P.RG AS RG,                     " +
                " FROM                              " +
                "   PESSOA P                        " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = P.ID_ENDERECO            " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE P.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, rua + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PESSOA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }

    public boolean alterar(int parseInt, String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
