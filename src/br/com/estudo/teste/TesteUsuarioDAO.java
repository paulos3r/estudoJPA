package br.com.estudo.teste;

import java.util.List;

import br.com.estudo.entidade.Usuario;
import br.com.estudo.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testeCadastrar();
		
		//testeAlterar();
		
		//testeExcluir();
		
		//testeBuscaTodos();
		
		testeBuscarId();
		
	}

	private static void testeCadastrar() {
		//instância para usar os atributos da entidade
		Usuario usu = new Usuario();
		//instancia para usar a classe que ira fazer a conexão com Driver, seta a informação na classe e anexa no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		//usando atributos
		usu.setNome("Paulo");
		usu.setLogin("123paulo");
		usu.setSenha("pa123");
		
		//utilizando a classe para criar conexao com banco e anexar no banco.
		usuDAO.cadastrar(usu);
	}
	
	private static void testeAlterar() {
		Usuario usu = new Usuario();
		UsuarioDAO usuDao = new UsuarioDAO();
		
		usu.setId(1);
		usu.setNome("Paulo da silva");
		usu.setLogin("pulinho");
		usu.setSenha("12345");
				
		usuDao.atualizar(usu);
	}
	private static void testeExcluir() {
		Usuario usu = new Usuario();
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usu.setId(3);
		
		usuDAO.excluir(usu);
	}
	
	private static void testeBuscaTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> listaUsuario = usuDAO.buscarTodos();
		
		for(Usuario u: listaUsuario) {
			System.out.println(u.getId() + " " + u.getNome() + " " + u.getLogin() + " " + u.getSenha());
		}
	}
	
	private static void testeBuscarId() {
		Usuario usu = new Usuario();
		UsuarioDAO usuDAO = new UsuarioDAO();
		usu = usuDAO.buscaId(6);
		System.out.println(usu.getId() + " " + usu.getNome() + " " + usu.getLogin() + " " + usu.getSenha());
	}

}
