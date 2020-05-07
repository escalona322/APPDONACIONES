package Vista;

import Modelo.Donacion;
import Modelo.Donante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControladoraBuscarDonacion {
	
	@FXML
	private DatePicker Fecha;
	
	@FXML
	private TextField Nombre;
	
	@FXML 
	private TextField GSang;
	
	@FXML
	private ToggleGroup Tipo;
	
	@FXML
	private RadioButton Aferesis;
	
	@FXML
	private RadioButton Normal;
	
	@FXML
	private Button BuscarFecha;
	
	@FXML
	private Button BuscarNombre;
	
	@FXML
	private Button BuscarGSang;
	
	@FXML
	private Button BuscarTipo;
	
	@FXML
	private TableView<Donante> TablaDonacion;
	
	@FXML
	private TableColumn<Donacion, String> NumDonacionT;
	
	@FXML
	private TableColumn<Donante, String> NombreT;
	
	@FXML
	private TableColumn<Donacion, String> GrupoSangT;
	
	@FXML
	private TableColumn<Donacion, String> FechaDonacionT;
	
	
	public void BuscarPorFecha(){
		
	}
	
	public void BuscarPorNombre(){
		
	}
	
	public void BuscarPorGSang(){
		
	}
	
	public void BuscarPorTipo(){
		
	}

}
