package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.estudo.entidade.Usuario;

public class UsuarioDAO {
	
	public void cadastrar(Usuario usuario) {
		
		Connection con = Conexao.getConexao();
		//sql
		String sql = "INSERT INTO usuario (nome, login, senha) values (?,?,?)";
		//Construção da preparação para enviar para o banco;
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			//aponta onde cada informação deve ficar
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();//Execulta o sql passado;
			preparador.close(); //fecha a conexão
			
			JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Usuario usuario) {

		Connection con = Conexao.getConexao();
		String sql = "UPDATE usuario SET nome= ?, login=?,senha=? WHERE id=?";
			
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			preparador.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	public void excluir(Usuario usuario) {
		
		Connection con = Conexao.getConexao();
			
		String sql = "DELETE FROM usuario WHERE id=?";
			
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluido com sucesso id="+ usuario.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Usuario> buscarTodos() {
		//preparando a conexão
		Connection con = Conexao.getConexao();
		//sql
		String sql = "SELECT * FROM usuario";
		//Criando uma cariavel lista array
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		//ao fim ele fecha a conexão
		try (PreparedStatement prepara = con.prepareStatement(sql)){
			 //Classe que vai recuperar os dados do banco de dados
			ResultSet resultSet = prepara.executeQuery();
		    //Enquanto existir dados no banco de dados, faça
			while(resultSet.next()){
				//cria um novo contato sempre que passa no while
				Usuario usuario = new Usuario();
				//armazenando valor usuario para popular a lista usuarios
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
				//populando a lista usuarios
				usuarios.add(usuario);
			}
			//fechando
			if(resultSet != null) {
				resultSet.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//retorna a lista de usuarios
		return usuarios;
	}
	
	public Usuario buscaId(Integer id){
		
		Connection con = Conexao.getConexao();
		
		String sql = "SELECT * FROM usuario WHERE id=?";		
		
		Usuario usuario = null;
		
		try (PreparedStatement prepara = con.prepareStatement(sql)){
			//id ja e passado quando chama o metodo	
			prepara.setInt(1, id);
			
			ResultSet result = prepara.executeQuery();
			
			if(result.next()) {
				
				usuario = new Usuario();
				
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setLogin(result.getString("login"));
				usuario.setSenha(result.getString("senha"));
				
			}
			//fecha as conexões abertas
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}
}