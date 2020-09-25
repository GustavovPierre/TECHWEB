package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/task","root","05311202");
	}
	
	public List <Pessoa> getLista() throws SQLException{
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TASKS");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setTask(rs.getString("tasks"));
			
			
			pessoas.add(pessoa);
		}
		
		rs.close();
		stmt.close();
		
		return pessoas;
	}
	
	public void adiciona (Pessoa pessoa) throws SQLException {
		
		String sql = "INSERT INTO TASKS (tasks) VALUES (?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getTask());
		stmt.execute();
		stmt.close();
	}
	public void remove(Integer id) throws SQLException{
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM TASKS WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		
		
	}
	
	public void atualiza (Pessoa pessoa) throws SQLException {
		
		PreparedStatement stmt = connection.prepareStatement("UPDATE TASKS SET tasks=? WHERE id=?");
		stmt.setNString(1,pessoa.getTask());
		stmt.setInt(2,pessoa.getId());
		stmt.execute();
		stmt.close();
		
	}
	public void close() throws SQLException {
		
		connection.close();
	
	}
}
