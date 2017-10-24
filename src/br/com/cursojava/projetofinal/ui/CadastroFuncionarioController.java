package br.com.cursojava.projetofinal.ui;

import java.util.List;

import br.com.cursojava.projetofinal.dao.CargoDAO;
import br.com.cursojava.projetofinal.dao.DAOException;
import br.com.cursojava.projetofinal.dao.FuncionarioDAO;
import br.com.cursojava.projetofinal.model.Cargo;
import br.com.cursojava.projetofinal.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController {

	
	
	
    @FXML
    private TextField txtNome;

    @FXML
    private ComboBox<Cargo> cbCargo;

    @FXML
    private TextField txtSalario;

    @FXML
    private Label lblMensagem;
    
    public void initialize(){
    	
    	try {
    		CargoDAO dao = new CargoDAO();
    		List<Cargo> cargoList  = dao.list();
			
			cbCargo.getItems().addAll(cargoList);
			
			
		} catch (DAOException e) {
			lblMensagem.setText(e.getMessage());
			e.printStackTrace();
		}
    }
      
    
    @FXML
    void LimparOnAction(ActionEvent event) {
    	txtNome.setText("");
    	txtSalario.setText("");
    	cbCargo.setValue(null);
    }

    @FXML
    void SalvaOnAction(ActionEvent event) {
    	
    	try {
			Funcionario func = new Funcionario();
			Cargo idValue = cbCargo.getValue();
			
			func.setNome(txtNome.getText());
			func.setSalario(Double.parseDouble(txtSalario.getText()));
			func.setCargoId(idValue.getId());
			
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.save(func);
			
			LimparOnAction(event);
			
			lblMensagem.setText("Funcionário cadastrado com sucesso.");
			
		} catch (NumberFormatException e) {
			lblMensagem.setText("Erro na conversão do número");
			e.printStackTrace();
		} catch (DAOException e) {
			lblMensagem.setText(e.getMessage());
			e.printStackTrace();
		}
    }

}
