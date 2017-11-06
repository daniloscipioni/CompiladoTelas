package br.com.cursojava.projetofinal.model;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Minhoca {
	
	
	
	public void AddElement(AnchorPane anchorpane, double x, double y) {
    	Circle circle1 = new Circle();
    	
    	circle1.setCenterX(10);
		circle1.setCenterY(50);
		circle1.setVisible(true);
		circle1.setRadius(5);
		
		anchorpane.getChildren().add(circle1);
		
	}
	
}
