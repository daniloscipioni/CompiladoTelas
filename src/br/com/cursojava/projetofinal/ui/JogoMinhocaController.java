package br.com.cursojava.projetofinal.ui;

import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JogoMinhocaController {
	
	static final double LEFTLIMITX = 5.0 ;
	static final double RIGTHLIMITX = 579.0;
	static final double UPLIMITY = 5.0;
	static final double DOWNLIMITY = 332.0;

	
    @FXML
    private Button btnCima;

    @FXML
    private Circle circleId;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnBaixo;

    @FXML
    private Button btnEsquerda;

    @FXML
    private Button btnDireita;

    @FXML
    private Label lblInfo1;

    @FXML
    private Label lblX;

    @FXML
    private Label lblY;

    @FXML
    void ClickOnMouse(MouseEvent event) {
    	
    }
     

    
    @FXML
    void PressedOnKey(KeyEvent Event) throws InterruptedException {
    	
    	
    	if(Event.getCode() == KeyCode.LEFT) {
    		//while(Event.getCode() == KeyCode.UNDEFINED) {
    		double left = circleId.getLayoutX();
            if(left>LEFTLIMITX) {
            	
            		circleId.setLayoutX(left - 1);
            		TimeUnit.MILLISECONDS.sleep(200);
            	}
            				
            //}
    	}
    	if(Event.getCode() == KeyCode.RIGHT) {
    		//while(Event.getCode() == KeyCode.UNDEFINED) {
    		double right = circleId.getLayoutX();
        	if(right<RIGTHLIMITX) {
        		
        		circleId.setLayoutX(right + 1);
        		TimeUnit.MILLISECONDS.sleep(200);
        		}
        	//}
    	}
    	if(Event.getCode() == KeyCode.UP) {
    		//while(Event.getCode() == KeyCode.UNDEFINED) {
        	double up = circleId.getLayoutY();
        	
        	if(up>UPLIMITY) {
        		
        		circleId.setLayoutY(up - 1);
        		TimeUnit.MILLISECONDS.sleep(200);
        		}
        	//}
    	}
    	if(Event.getCode() == KeyCode.DOWN) {

    		double down = circleId.getLayoutY();
        	

        	if(down<DOWNLIMITY) {
        		
        		circleId.setLayoutY(down + 1);
        		TimeUnit.MILLISECONDS.sleep(100);
        		down = circleId.getLayoutY();
 
        		}
        	
        		}
        	
    	
    	//lblInfo.setText(""+Event.getCode());
    	lblX.setText(""+circleId.getLayoutX());
    	lblY.setText(""+circleId.getLayoutY());
    }

}
