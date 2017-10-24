package br.com.cursojava.projetofinal.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {
	
	
	protected Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/impacta?noAccessToProcedureBodies=true",
				"aluno","java");
		
		}
	
	
	
	/* Fecha a conex�o quando h� alguma*/
	protected void closeResources(Connection cn, Statement st, ResultSet rs, CallableStatement cs){
		if(st!=null){
			try {
				st.close();
			} catch (Exception e) {
				// unica excess�o para um catch sem a��o
			}
		}
		
		if(cn!=null){
			try {
				cn.close();
			} catch (Exception e) {
				// unica excess�o para um catch sem a��o
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// unica excess�o para um catch sem a��o
			}
		}
		
		if(cs!=null){
			try {
				cs.close();
			} catch (Exception e) {
				// unica excess�o para um catch sem a��o
			}
		}
		
	}
}
