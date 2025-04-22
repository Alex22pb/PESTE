/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConexaoBanco {
    static Connection conexao;
    
    public static Connection fazerConexao() throws ClassNotFoundException, SQLException{
        String servidor = "127.0.0.1:5432";
        String login = "postgres";
        String senha = "1320";
        String nomeBancoDados = "RevisaoProvaPOO2";
        String url = "jdbc:postgresql://" + servidor + "/" + nomeBancoDados;
        
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url,login,senha);
        return conexao;   
    }
}
