package br.com.cursojava.projetofinal.ui;

import java.util.List;

import br.com.cursojava.projetofinal.dao.CargoDAO;
import br.com.cursojava.projetofinal.dao.DAOException;
import br.com.cursojava.projetofinal.model.Cargo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PesquisaCargoController {

    @FXML
    private TextField txtCargo;

    @FXML
    private TableView<Cargo> tabCargo;

    @FXML
    private TableColumn<Cargo, Integer> colIdCargo;

    @FXML
    private TableColumn<Cargo, String> colNmCargo;

    @FXML
    private Label lblMensagem;
    
public void initialize(){
    	
    	/*Os nomes dos parametros vem dos atributos da classe cargo*/
    	
    	/*Configura a coluna de id*/
    	colIdCargo.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	/*Configura a coluna de nome*/
    	colNmCargo.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	    	
    }
    
    @FXML
    void procurarOnAction(ActionEvent event) {
		try {
			/*Limpa dados antigos*/
			tabCargo.getItems().clear();
			
			CargoDAO dao = new CargoDAO();
			List<Cargo> cargolist = dao.FindByRole(txtCargo.getText());
			
			tabCargo.getItems().addAll(cargolist);
			
		} catch (DAOException e) {
			lblMensagem.setText(e.getMessage());
			e.printStackTrace();
		}
		
		
    }

}
