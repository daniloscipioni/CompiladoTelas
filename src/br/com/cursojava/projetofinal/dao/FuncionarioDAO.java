package br.com.cursojava.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.MysqlDataTruncation;

import br.com.cursojava.projetofinal.model.Funcionario;

public class FuncionarioDAO extends AbstractDAO {
	
    public void save(Funcionario func) throws DAOException{
    	
		Connection cn = null;
		PreparedStatement ps = null;
    	
		try {
			cn = getConnection();
			ps = cn.prepareStatement("INSERT INTO tab_func (func_name, func_rmnt_val, role_code) VALUES (?,  ? , ?);");
			
			ps.setString(1, func.getNome());
			ps.setDouble(2, func.getSalario());
			ps.setDouble(3, func.getCargoId());
			
			ps.execute();
			
/*		} catch (MysqlDataTruncation e) {
			throw new DAOException("Dados muito grandes para os campos", e);
			//e.printStackTrace();
		*/}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Não foi possível salvar o cargo", e);
			
		} finally{
			/*Fecha os recursos utilizados*/
			closeResources(cn, ps, null, null);
		}
		
    	
    }
	
	/*List preserva a consulta que foi feita no banco, caso for feita uma ordenação*/
	public List<Funcionario> FindByName(String nome) throws DAOException{
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			/*Abre a conexão*/
			cn = getConnection();
			
			/*Prepara a consulta*/
			ps = cn.prepareStatement("SELECT F.func_code, F.func_name, F.func_rmnt_val, F.role_code, R.role_name, R.role_code "
									+ "FROM tab_func F join tab_role R ON F.role_code = R.role_code where func_name LIKE ?  "					
									+ "ORDER BY func_code  ");
			
			/*Preenche o critério de busca*/
		    ps.setString(1, nome);
		    
		    /*Executa a consulta*/
		    rs = ps.executeQuery();
		    
		    
		    List<Funcionario> funcList = new ArrayList<>();
		    
		    /*Varre o resultset adicionando na lista*/
		    while (rs.next()){
		    	Funcionario func = new Funcionario();
		    	
		    	func.setMatricula(rs.getInt("func_code"));
		    	func.setNome(rs.getString("func_name"));
		    	func.setSalario(rs.getDouble("func_rmnt_val"));
		    	func.setCargoId(rs.getInt("role_code"));
		    	func.setCargoNome(rs.getString("role_name"));
		    	funcList.add(func);
		    }
		    
		    return funcList;
		    
		} catch (SQLException e) {
			throw new DAOException("Falha ao pesquisa funcionarios", e);

		}finally{
			closeResources(cn, ps, rs, null);
			
		}
		
	}



}
