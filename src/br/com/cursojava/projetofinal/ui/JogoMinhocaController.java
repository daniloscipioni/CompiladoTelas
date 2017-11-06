package br.com.cursojava.projetofinal.ui;


import br.com.cursojava.projetofinal.model.Minhoca;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class JogoMinhocaController {

	static final double LEFTLIMITX = 0 ;
	static final double RIGTHLIMITX = 579;
	static final double UPLIMITY = 0;
	static final double DOWNLIMITY = 331.5;
	
    @FXML
    private Circle circleId;

    @FXML
    private Label lblInfo;


    @FXML
    private Label lblInfo1;

    @FXML
    private Label lblX;

    @FXML
    private Label lblY;
    
    @FXML
    private AnchorPane idAnchor;
    
	

    
	public void Esquerda(KeyEvent Event) {
		double YValue = circleId.getCenterY();
		
		if(Event.getCode() == KeyCode.LEFT) {
    		final Timeline timeline = new Timeline();
        	final KeyValue kv = new KeyValue(circleId.centerXProperty(), LEFTLIMITX,
        	 Interpolator.LINEAR);
        	final KeyValue kv1 = new KeyValue(circleId.centerYProperty(), YValue,
                  	 Interpolator.LINEAR);
        
        	
        	
        	lblX.setText(""+(int)circleId.getCenterX());
        	lblY.setText(""+(int)circleId.getCenterY());
        	
        	
        	final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv , kv1);
        	timeline.getKeyFrames().add(kf);
        	timeline.play();	
    	}
		
	
	}
	
	public void Direita(KeyEvent Event) {
		
		double YValue = circleId.getCenterY();
		if(Event.getCode() == KeyCode.RIGHT) {
    		            	
			final Timeline timeline = new Timeline();
            	
            	final KeyValue kv = new KeyValue(circleId.centerXProperty(), RIGTHLIMITX-circleId.getRadius(),
            	 Interpolator.LINEAR);
            	final KeyValue kv1 = new KeyValue(circleId.centerYProperty(), YValue,
                   	 Interpolator.LINEAR);
                   	
           
            	lblX.setText(""+(int)circleId.getCenterX());
            	lblY.setText(""+(int)circleId.getCenterY());
            	
            	
            	final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv ,kv1);
            	timeline.getKeyFrames().add(kf);
               	
            	timeline.play();	
            	
       
    	}
	}
	
	public void Cima(KeyEvent Event) {
		double XValue = circleId.getCenterX();
 
    	if(Event.getCode() == KeyCode.UP) {
    		final Timeline timeline = new Timeline();
     
        	final KeyValue kv = new KeyValue(circleId.centerYProperty(), UPLIMITY,
        	 Interpolator.LINEAR);
        	final KeyValue kv1 = new KeyValue(circleId.centerXProperty(), XValue,
               	 Interpolator.LINEAR);
        	
        	
        	lblX.setText(""+(int)circleId.getCenterX());
        	lblY.setText(""+(int)circleId.getCenterY());
        	
        	
        	final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv1 ,kv);
        	timeline.getKeyFrames().add(kf);
        	timeline.play();	
    	}
	}
	
	public void Baixo(KeyEvent Event) {
		double XValue = circleId.getCenterX();
		
    	if(Event.getCode() == KeyCode.DOWN) {

        	final Timeline timeline = new Timeline();
        
        	final KeyValue kv = new KeyValue(circleId.centerYProperty(), DOWNLIMITY - circleId.getRadius(),
        	 Interpolator.LINEAR);
        	
        	final KeyValue kv1 = new KeyValue(circleId.centerXProperty(), XValue,
               	 Interpolator.LINEAR);
        	
        
        	lblX.setText(""+(int)circleId.getCenterX());
        	lblY.setText(""+(int)circleId.getCenterY());
        	
        	final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv1 ,kv);
        	timeline.getKeyFrames().add(kf);
        	timeline.play();	
        	
    	}
	}
	
    public void initialize(){
    	//Coloca o foco no componete AnchorPane para o funcionamento das teclas
    	idAnchor.setFocusTraversable(true);
    	circleId.setLayoutX(5);
    	circleId.setLayoutY(5);
    	
    	Minhoca m = new Minhoca();
    	
    	m.AddElement(idAnchor, 13, 90);

    	
     }
    

    @FXML
    void PressedOnKey(KeyEvent event) throws InterruptedException {
		this.Esquerda(event);
        this.Baixo(event);
	    this.Cima(event);
	    this.Direita(event); 
    }
    

    

   

}
