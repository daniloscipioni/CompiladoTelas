package br.com.cursojava.projetofinal.ui;

import br.com.cursojava.projetofinal.dao.DAOException;
import br.com.cursojava.projetofinal.dao.NumeroExtensoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NumeroExtensoController {

    @FXML
    private TextField txtNumero;

    @FXML
    private TextArea TextReturnExtenso;

    @FXML
    private Label lblMensagem;

    @FXML
    void callProcedure(ActionEvent event) {
    	
    	try {
			NumeroExtensoDAO dao = new NumeroExtensoDAO();
			
			TextReturnExtenso.setText(dao.CallProcedure(Integer.parseInt(txtNumero.getText())));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
