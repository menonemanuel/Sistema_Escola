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
public class DaoFuncionario extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir(int id, int idPessoa, int idTurma, int idEstadoCivil, int idCargo, String salario, String dias_de_trabalho, String num_conta_bancaria){
        try{
            sql = "INSERT INTO FUNCIONARIO (ID, ID_PESSOA, ID_TURMA, ID_ESTADO_CIVIL, ID_CARGO, SALARIO, DIAS_DE_TRABALHO, NUM_CONTA_BANCARIA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idTurma);
            getStatement().setInt(4, idEstadoCivil);
            getStatement().setInt(5, idCargo);
            getStatement().setString(6, salario);
            getStatement().setString(7, dias_de_trabalho);
            getStatement().setString(8, num_conta_bancaria);
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idPessoa, int idTurma, int idEstadoCivil, int idCargo, String salario, String dias_de_trabalho, String num_conta_bancaria){
        try{
            sql = "UPDATE FUNCIONARIO SET ID = ?, ID_PESSOA = ?, ID_TURMA = ?, ID_ESTADO_CIVIL = ?, ID_CARGO = ?, SALARIO = ?, DIAS_DE_TRABALHO = ?, NUM_CONTA_BANCARIA = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idTurma);
            getStatement().setInt(4, idEstadoCivil);
            getStatement().setInt(5, idCargo);
            getStatement().setString(6, salario);
            getStatement().setString(7, dias_de_trabalho);
            getStatement().setString(8, num_conta_bancaria);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";
            
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
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " ;
                
            
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
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.ID = ?                    " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdPessoa(int idPessoa){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.ID_PESSOA = ?             " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idPessoa);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdTurma(int idTurma){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.ID_TURMA = ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idTurma);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdEstadoCivil(int idEstadoCivil){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.ID_ESTADO_CIVIL = ?       " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idEstadoCivil);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorIdCargo(int idCargo){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.ID_CARGO = ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idCargo);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorSalario(String salario){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.SALARIO = ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, salario + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorDiasDeTrabalho(String dias_de_trabalho){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.DIAS_DE_TRABALHO LIKE ?   " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, dias_de_trabalho + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCargaHorario (String carga_horaria){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.CARGA_HORARIA LIKE ?      " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, carga_horaria + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNumContaBancaria(String num_conta_bancaria){
        try{
            sql = 
                " SELECT                            " +
                "   F.ID AS ID,                     " +
                "   P.ID_PESSOA AS ID_PE            " +
                "   T.ID_TURMA AS ID_TUR,           " +
                "   E.ID_ESTADO_CIVIL AS ID_ESTA,   " +
                "   F.ID_CARGO AS ID_CAR,           " +
                "   F.SALARIO AS SALA,              " +
                "   F.DIAS_DE_TRABALHO AS TRABALHO, " +
                "   F.CARGA_HORARIA AS CARGA_HORA,  " +
                "   F.MORADIA AS MORA,              " +
                "   F.NUM_CONTA_BANCARIA AS CONTA,  " +
                " FROM                              " +
                "   FUNCIONARIO F                   " +
                " JOIN PESSOA P ON                  " +
                "   P.ID = P.ID_PESSOA              " +
                " JOIN TURMA T ON                   " +
                "   T.ID = T.ID_TURMA               " +
                " JOIN ESTADO_CIVIL E ON            " +
                "   E.ID = E.ID_ESTADO_CIVIL        " +
                " JOIN CARGO C ON                   " +
                "   C.ID = C.ID_CARGO               " +
                " WHERE F.CARGA_HORARIA = ?         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, num_conta_bancaria + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM FUNCIONARIO";
            
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
