package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Modelo.Formulario;

public class ControladoraNuevaDonacion1 {

	@FXML
	private TextField NumDonante;
	
	@FXML
	private ChoiceBox<Formulario> Formulario;
	
	@FXML
	private Button ConfirmarFormulario;
	
	@FXML
	private Button SiguienteVentana;
	
	public void Confirmar(){
		
	}
	
	public void SiguienteVentana(){
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("NuevaDonacion2.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de nuevadonacion2
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
