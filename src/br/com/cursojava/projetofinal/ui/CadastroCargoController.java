package br.com.cursojava.projetofinal.ui;


import br.com.cursojava.projetofinal.dao.CargoDAO;
import br.com.cursojava.projetofinal.dao.DAOException;
import br.com.cursojava.projetofinal.model.Cargo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroCargoController {

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblMensagem;
    

    

    @FXML
    void SalvaOnAction(ActionEvent event) {
    	
    	try {
			/*Instancia um objeto*/
			Cargo cargo = new Cargo();
			
			/*Preenche o objeto com os dados da tela*/
			cargo.setNome(txtNome.getText());
			
			/*Salva cargo na base de dados*/
			CargoDAO dao = new CargoDAO();
			dao.save(cargo);
			
			/*Limpa os campos da tela*/
			LimparOnAction(event);
			
			/*Exibe mensagem de sucesso*/
			lblMensagem.setText("Cargo cadastrado com sucesso.");
    	}
    
    		
    	
    	catch (DAOException e) {
			lblMensagem.setText(e.getMessage());
			e.printStackTrace();
    	}
    }

    @FXML
    void LimparOnAction(ActionEvent event) {
    	txtNome.setText("");
    	lblMensagem.setText("");
    }

}


