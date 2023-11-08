/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaescola;

import com.mycompany.ferramentas.BancoDeDadosMySql;

/**
 *
 * @author emanuel.4966
 */
public class SistemaEscola {

    public static void main(String[] args) {
       if (BancoDeDadosMySql.conectar()) {
            System.out.println("Conectado ao banco de dados com sucesso!");
        }
    }
}
