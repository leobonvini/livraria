package br.com.alura.autor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import br.com.alura.autor.modelo.Autor;

public class AutorDao {

	private Connection conexao;
	
	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Autor autor) {
		try {
			String sql = "insert into autores(nome, email, nascimento) values(?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getNascimento()));
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Autor> listar(){
		
		try {
			String sql = "select * from autores";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Autor> autores = new ArrayList<>();
			while(rs.next()) {
				Autor a = new Autor();
				
				a.setNome(rs.getString("nome"));
				a.setEmail(rs.getString("email"));
				a.setNascimento(rs.getDate("nascimento").toLocalDate());
				
				autores.add(a);
				
			}
			
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

