package br.com.cursojava.projetofinal.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class NumeroExtensoDAO extends AbstractDAO {

	
public String CallProcedure(int numero) throws DAOException{
    	
		Connection cn = null;
		CallableStatement cs = null;
	  try {
			
			
			
			cn = getConnection();
			/*Prepara a chamada da procedure*/
			cs = cn.prepareCall("{ call prc_numero_extenso(?, ?)}");
			
					
			/*Preenche o parâmetro de entrada*/
			cs.setInt(1, numero);
			
			/*Registra o parâmetro de saída*/
			cs.registerOutParameter(2, Types.VARCHAR);
			
			/*Executa a procedure*/
			cs.executeUpdate();
			
			/*Resgata o parametro de saída e imprime da tela*/
			String result = cs.getString(2);
			
			
			return result;
	  
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			closeResources(cn, null, null, cs);
		}
	

		
    	
    }
}
