package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraMenuDonaciones {
	
	@FXML
	private Button NuevaDonacion;
	
	@FXML
	private Button BuscarDonaciones;

	public void AbrirNuevaDonacion(){
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("NuevaDonacion1.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de nueva donacion 1
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void AbrirBuscarDonaciones(){
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("BuscarDonacion.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de buscar donacion
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
