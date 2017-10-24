package br.com.cursojava.projetofinal.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JanelaPrincipalController {

	@FXML
	private BorderPane pnlRaiz;

	private Stage stage;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void cadastroCargoOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/CadastroCargo.fxml"));
		Parent parent = loader.load();
		pnlRaiz.setCenter(parent);
		stage.setTitle("Projeto Final - Cadastro de Cargos");
    }

    @FXML
    void cadastroFuncionarioOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/CadastroFuncionario.fxml"));
		Parent parent = loader.load();
		pnlRaiz.setCenter(parent);
		stage.setTitle("Projeto Final - Cadastro de Funcionarios");
    }

    @FXML
    void pesquisaCargoOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/PesquisaCargo.fxml"));
		Parent parent = loader.load();
		pnlRaiz.setCenter(parent);
		stage.setTitle("Projeto Final - Pesquisa de Cargos");
    }

    @FXML
    void pesquisaFuncionarioOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/PesquisaFuncionario.fxml"));
		Parent parent = loader.load();
		pnlRaiz.setCenter(parent);
		stage.setTitle("Projeto Final - Pesquisa de Funcionários");
    }

    @FXML
    void extensoOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/NumeroExtenso.fxml"));
		Parent parent = loader.load();
		pnlRaiz.setCenter(parent);
		stage.setTitle("Projeto Final - Número por Extenso");
    }

	@FXML
	void sairOnAction(ActionEvent event) {
		stage.close();
	}
}
