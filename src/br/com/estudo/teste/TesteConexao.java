package br.com.estudo.teste;

import javax.swing.JOptionPane;

import br.com.estudo.jdbc.Conexao;

public class TesteConexao {
	public static void main(String[] args) {
		
		//try pois na classe getConexao tem um throws.
		try {
			//Conexao con = new Conexao(); // instância pois meu objeto não e statico
			Conexao.getConexao();            // obtendo a conexão para teste
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conexão deu errado");
		}
	}

}
