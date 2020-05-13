package Vista;

import java.io.File;
import java.sql.SQLException;

import Modelo.Conexion;
import Modelo.Donante;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private ToggleGroup GrupoS;
	
	@FXML
	private RadioButton A;
	
	@FXML
	private RadioButton B;
	
	@FXML
	private RadioButton AB;
	
	@FXML
	private RadioButton Cero;
	
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
	
	ObservableList<Donante> datos = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;
	

	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

		Conexion con = new Conexion();
		datos = con.ObtenerDonantes();

		Tabla.setItems(datos);

		NombreT.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nombre"));
		ApellidoT.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido1"));
		emailT.setCellValueFactory(new PropertyValueFactory<Donante,String>("email"));
		GSangT.setCellValueFactory(new PropertyValueFactory<Donante,String>("GrupoSang"));
		TelefonoT.setCellValueFactory(new PropertyValueFactory<Donante,String>("Telefono"));

		// Al arrancar la vista se pone edicion a false
		edicion = false;
		indiceedicion = 0;

	}
	
	public void InsertarDonante(){

		// Añadir un chequeo de campos vacíos
		if(Nombre.getText().equals("") || Apellido1.getText().equals("") || Apellido2.getText().equals("") || email.getText().equals("") || Identificacion.getText().equals("")|| Telefono.getText().equals("") || Ciclo.getText().equals("") || CodigoPostal.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}
		else{

			if(edicion == true){
			
				// Hago la llamda al método que hace el update en la base de datos
				Conexion con = new Conexion();
				String GrupoSang = "";
				if(A.isSelected()){
					GrupoSang = "A";
				}
				else{
					if(B.isSelected()){
						GrupoSang = "B";
					}else{
						if(AB.isSelected()){
							GrupoSang = "AB";
						}else{
							if(Cero.isSelected()){
								GrupoSang = "0";
							}
					}
					}
				}
				
				int res = con.ModificarDonante(Nombre.getText(), Apellido1.getText(), Apellido2.getText(), Identificacion.getText(), email.getText(), GrupoSang, Ciclo.getText(), Integer.parseInt(Telefono.getText()), CodigoPostal.getText(), FechaNacimiento.getValue().toString());
				switch (res){

					case 0:
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Modificación OK!");
						alert.setContentText("¡Persona modificada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerDonantes();
						Tabla.setItems(datos);
						break;

					default:
							alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error!");
							alert.setHeaderText("Modificación NOK!");
							alert.setContentText("¡Ha habido un problema al realizar el update!");
							alert.showAndWait();
							break;

						}




			}
			else{
				// Realizar el insertado de datos en la base de datos
				Conexion con = new Conexion();
				File foto = new File();
				int res = con.InsertarDonante(CodigoPostal.getText(), Integer.parseInt(Telefono.getText()), Identificacion.getText(), email.getText(), Apellido1.getText(), Apellido2.getText(), Nombre.getText(), null, foto, FechaNacimiento.getValue().toString(), GrupoSang, Ciclo.getText());
				switch (res){

				case 0:
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("OK!");
					alert.setHeaderText("Inserción OK!");
					alert.setContentText("¡Persona insertada con éxito!");
					alert.showAndWait();

					// Actualizo los datos de la tabla
					datos = con.ObtenerDonantes();
					Tabla.setItems(datos);
					break;

				case 1:
					alert = new Alert(AlertType.WARNING);
					alert.setTitle("Aviso!");
					alert.setHeaderText("Inserción NOK!");
					alert.setContentText("¡Ya existe una persona con ese email!");
					alert.showAndWait();
					break;

				default:
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error!");
					alert.setHeaderText("Inserción NOK!");
					alert.setContentText("¡Ha habido un problema al realizar la inserción!");
					alert.showAndWait();
					break;

				}

			}

		}

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
