package Vista;

import Modelo.Donante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladoraDonantes {
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido1;
	
	@FXML
	private TextField Apellido2;
	
	@FXML
	private TextField Identificacion;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField Ciclo;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField CodigoPostal;
	
	@FXML
	private TextField GrupoSanguineo;
	
	@FXML
	private DatePicker FechaNacimiento;
	
	@FXML
	private ImageView Foto;
	
	@FXML
	private Button Insertar;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button Eliminar;
	
	@FXML
	private Button Borrar;
	
	@FXML
	private Button Imprimir;
	
	@FXML 
	private TextField BuscarNombre;
	
	@FXML 
	private TextField BuscarApellido;
	
	@FXML
	private TextField BuscarEmail;
	
	@FXML
	private TextField BuscarTelefono;
	
	@FXML 
	private TextField BuscarID;
	
	@FXML
	private TextField BuscarCiclo;
	
	@FXML
	private Button Buscar;
	
	@FXML
	private TableView<Donante> Tabla;
	
	@FXML
	private TableColumn<Donante,String> NombreT;
	
	@FXML
	private TableColumn<Donante,String> ApellidoT;
	
	@FXML
	private TableColumn<Donante,String> emailT;
	
	@FXML
	private TableColumn<Donante,String> GSangT;
	
	@FXML
	private TableColumn<Donante,String> TelefonoT;
	
	public void InsertarDonante(){
		
	}
	
	public void ModificarDonante(){
		
	}
	
	public void EliminarDonante(){
		
	}
	
	public void Borrar(){
		
	}
	
	public void GenerarCarnet(){
		
	}
	
	public void Buscar(){
		
	}

}
