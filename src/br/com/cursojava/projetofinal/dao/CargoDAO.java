package br.com.cursojava.projetofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.MysqlDataTruncation;

import br.com.cursojava.projetofinal.model.Cargo;
import br.com.cursojava.projetofinal.model.Funcionario;

public class CargoDAO extends AbstractDAO{
	/*Joga a exception para a classe controladora*/
	public void  save(Cargo cargo) throws DAOException{
		
		Connection cn = null;
		PreparedStatement ps = null;
		try {
//			Abre a conexão
			cn = getConnection();
			
			/*Prepara o statement de inclusao*/
			ps = cn.prepareStatement("INSERT INTO tab_role (role_name) VALUES(?)");
			
			/*Preenche o statement com os dados do objeto*/
			ps.setString(1,cargo.getNome());
			
			/*Efetiva a inclusão*/
			ps.execute();
			
		
		} catch (MysqlDataTruncation e){
			
			throw new DAOException("O campo deve ter no máximo 20 caracteres", e);
		
		} catch (SQLException e) {
			throw new DAOException("Não foi possível salvar o cargo", e);
			
		} finally{
			/*Fecha os recursos utilizados*/
			closeResources(cn, ps, null, null);
		}
		
	}
	
	public List<Cargo> list() throws DAOException{
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			/*Abre a conexão*/
			cn = getConnection();
			
			/*Prepara a consulta*/
			ps = cn.prepareStatement("SELECT role_code, role_name FROM tab_role ORDER BY role_name");

			/*Executa a consulta*/
		    rs = ps.executeQuery();
		    
		    List<Cargo> cargoList = new ArrayList<>();
		    
		    /*Varre o resultset adicionando na lista*/
		    while (rs.next()){
		    	Cargo cargo = new Cargo();
		    	
		    	cargo.setId(rs.getInt("role_code"));
		    	cargo.setNome(rs.getString("role_name"));
		    	
		    	cargoList.add(cargo);
		    }
		    
		    return cargoList;
		    
		} catch (SQLException e) {
			throw new DAOException("Falha ao pesquisar cargos", e);

		}finally{
			closeResources(cn, ps, rs, null);
			
		}
	}

	public List<Cargo> FindByRole(String role) throws DAOException{
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			/*Abre a conexão*/
			cn = getConnection();
			
			/*Prepara a consulta*/
			ps = cn.prepareStatement("SELECT role_code, role_name FROM tab_role WHERE role_name LIKE ? ORDER BY role_name");
			
			/*Preenche o critério de busca*/
		    ps.setString(1, role);
		    
		    /*Executa a consulta*/
		    rs = ps.executeQuery();
		    
		    
		    List<Cargo> cargoList = new ArrayList<>();
		    
		    /*Varre o resultset adicionando na lista*/
		    while (rs.next()){
		    	Cargo cargo = new Cargo();

		    	cargo.setId(rs.getInt("role_code"));
		    	cargo.setNome(rs.getString("role_name"));
		    	
		    	cargoList.add(cargo);
		    }
		    
		    return cargoList;
		    
		} catch (SQLException e) {
			throw new DAOException("Falha ao pesquisa cargos", e);

		}finally{
			closeResources(cn, ps, rs, null);
			
		}
		
	}
	
}
