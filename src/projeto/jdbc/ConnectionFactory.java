/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JJV
 */
public class ConnectionFactory {
    public static void main(String[] args) {
        
    }
    
    public Connection getConnection(){
        
        try {
            
            // aqui ira a conexao com o banco de dados local ou web
           // return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas","teste","12345");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
}
