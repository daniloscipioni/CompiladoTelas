package br.com.cursojava.projetofinal.ui;


import java.util.List;

import br.com.cursojava.projetofinal.dao.DAOException;
import br.com.cursojava.projetofinal.dao.FuncionarioDAO;
import br.com.cursojava.projetofinal.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PesquisaFuncionarioController {

    @FXML
    private TextField txtNome;

    @FXML
    private TableView<Funcionario> tabFuncionario;
    
    @FXML
    private TableColumn<Funcionario, String> colNome;
    
    @FXML
    private TableColumn<Funcionario, Double> colSalario;

    @FXML
    private TableColumn<Funcionario, Integer> colMatricula;
    
    @FXML
    private TableColumn<Funcionario, String> colCargo;
    
    @FXML
    private Label lblMensagem;
    
    public void initialize(){
    	
    	/*Os nomes dos parametros vem dos atributos da classe funcionario*/
    	
    	/*Configura a coluna de matricula*/
    	colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    	
    	/*Configura a coluna de nome*/
    	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	/*Configura a coluna de cargo*/
    	colCargo.setCellValueFactory(new PropertyValueFactory<>("cargoNome"));
    	
    	/*Configura a coluna de salario*/
    	colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	
    }
    
    @FXML
    void procurarOnAction(ActionEvent event) {
        	
    	try {
    		/*Limpa dados antigos*/
			tabFuncionario.getItems().clear();
    		
			
    		FuncionarioDAO dao = new FuncionarioDAO();
			List<Funcionario> funcList  = dao.FindByName(txtNome.getText());
			
			tabFuncionario.getItems().addAll(funcList);
			
		} catch (DAOException e) {
			lblMensagem.setText(e.getMessage());
			
		}
    }

}