package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladoraMainMenu {
	
	@FXML
	private Button Donantes;
	
	@FXML
	private Button Donaciones;
	
	@FXML
	private Button Informes;
	

	
	public void BttnMenuDonantes(){
		
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Donantes.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de donantes
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		

	public void BttnMenuDonaciones(){
		
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("MenuDonaciones.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista del menu de donaciones
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BttnMenuInformes(){
		try{
			 			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Informes.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de informes
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
