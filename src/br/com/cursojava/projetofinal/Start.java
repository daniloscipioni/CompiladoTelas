package br.com.cursojava.projetofinal;

import br.com.cursojava.projetofinal.ui.JanelaPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/JanelaPrincipal.fxml"));
		Parent parent = loader.load();
		JanelaPrincipalController controller = loader.getController();
		controller.setStage(stage);

		stage.setScene(new Scene(parent));
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/resource/image/funcionario-icon.png")));
		stage.setTitle("Projeto Final");
		stage.setWidth(600);
		stage.setHeight(400);
		stage.show();
	}
}
