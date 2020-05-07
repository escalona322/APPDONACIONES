package Vista;

import Modelo.Donacion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControladoraNuevaDonacion2 {
	
	@FXML
	private TextField TensionD;
	
	@FXML
	private TextField TensionS;
	
	@FXML
	private TextField Pulso;
	
	@FXML
	private TextField HBVen;
	
	@FXML
	private TextField HBCap;
	
	@FXML
	private DatePicker FechaDonacion;
	
	@FXML
	private ToggleGroup Tipo;
	
	@FXML
	private RadioButton Aferesis;
	
	@FXML
	private RadioButton Normal;
	
	@FXML
	private Button InsertarDonacion;
	
	@FXML
	private Button Borrar;
	
	@FXML
	private Button Eliminar;
	
	@FXML
	private TableView<Donacion> TablaDonacion;
	
	@FXML
	private TableColumn<Donacion, String> NumDonacionT;
	
	@FXML
	private TableColumn<Donacion, String> TipoT;
	
	@FXML
	private TableColumn<Donacion, String> FechaDonacionT;
	
	@FXML
	private TableColumn<Donacion, String> PulsoT;
	
	public void Insertar(){
		
	}
	
	public void Borrar(){
		
	}
	
	public void Eliminar(){
		
	}
	

}
