package br.com.estudo.teste;

import javax.swing.JOptionPane;

import br.com.estudo.jdbc.Conexao;

public class TesteConexao {
	public static void main(String[] args) {
		
		//try pois na classe getConexao tem um throws.
		try {
			//Conexao con = new Conexao(); // inst�ncia pois meu objeto n�o e statico
			Conexao.getConexao();            // obtendo a conex�o para teste
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conex�o deu errado");
		}
	}

}
