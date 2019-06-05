package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	//classe para criar a conex�o com o driver do banco de dados
	public static Connection getConexao(){
		
		//obter um objeto para conex�o
		Connection con = null; 
		
		try {
			//informando a url, login, senha do banco de dados
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cjweb1","postgres","postgres");
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage() + "N�o foi possivel a conex�o com banco, favor entrar em contato com suporte");
		}
		//retorna a conexao para ser usada caso der tudo certo...
		return con;
	}

}
