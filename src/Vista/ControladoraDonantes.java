package Vista;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import Modelo.Conexion;

import Vista.ImprimeArchivo;
import Modelo.Donante;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

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
	private Button BuscarImagen;
	
	@FXML 
	private TextField RutaImagen;
	
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
	private TableColumn<Donante, Integer> TelefonoT;
	
	ObservableList<Donante> datos = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;
	

	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Donante> datos

		Conexion con = new Conexion();
		datos = con.ObtenerDonantes();

		Tabla.setItems(datos);

		NombreT.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nombre"));
		ApellidoT.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido1"));
		emailT.setCellValueFactory(new PropertyValueFactory<Donante,String>("email"));
		GSangT.setCellValueFactory(new PropertyValueFactory<Donante,String>("GrupoSang"));
		TelefonoT.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("Telefono"));
		
	
		// Al arrancar la vista se pone edicion a false
		edicion = false;
		indiceedicion = 0;

	}
	
	public void InsertarDonante() throws NumberFormatException, FileNotFoundException, SQLException{

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
				DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				  String fecha_n = FechaNacimiento.getValue().format(isoFecha);
				 
				  //mes-dia-año
				  String mes=  fecha_n.substring(8, 10);
				  String dia= fecha_n.substring(5, 7);
				  String año= fecha_n.substring(0, 4);
				 
				  String fecha_na= mes+ "-" + dia + "-" + año;

				int res = con.ModificarDonante(Nombre.getText(), Apellido1.getText(), Apellido2.getText(), Identificacion.getText(), email.getText(), GrupoSang, Ciclo.getText(), Integer.parseInt(Telefono.getText()), CodigoPostal.getText(), fecha_na);
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
				
				DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				  String fecha_n = FechaNacimiento.getValue().format(isoFecha);
				 
				  //mes-dia-año
				  String mes=  fecha_n.substring(8, 10);
				  String dia= fecha_n.substring(5, 7);
				  String año= fecha_n.substring(0, 4);
				 
				  String fecha_na= mes+ "-" + dia + "-" + año;
				  
				int res = con.InsertarDonante(CodigoPostal.getText(), Integer.parseInt(Telefono.getText()), Identificacion.getText(), email.getText(), Apellido1.getText(), Apellido2.getText(), Nombre.getText(), "", fecha_na, GrupoSang, Ciclo.getText());
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
	
	
	
	public void ModificarDonante() throws SQLException{

		Conexion con = new Conexion();
		
		int index = Tabla.getSelectionModel().getSelectedIndex();


		if( index >= 0){

			// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
			edicion = true;
			indiceedicion = index;


			Donante seleccionada = Tabla.getSelectionModel().getSelectedItem();

			Nombre.setText(seleccionada.getNombre());
			Apellido1.setText(seleccionada.getApellido1());
			Apellido2.setText(seleccionada.getApellido2());
			Identificacion.setText(seleccionada.getIdentificacion());
			Telefono.setText(String.valueOf(seleccionada.getTelefono()));
			Ciclo.setText(seleccionada.getCiclo());
			email.setText(seleccionada.getEmail());
			CodigoPostal.setText(seleccionada.getCod_Postal());
			LocalDate setfecha = LocalDate.parse(seleccionada.getFecha_Nac().substring(0, 10));
			FechaNacimiento.setValue(setfecha);
			
			
			if(seleccionada.getGrupoSang().equals("A")){
				A.setSelected(true);
			}else{
				if(seleccionada.getGrupoSang().equals("B")){
					B.setSelected(true);
				}else{
					if(seleccionada.getGrupoSang().equals("AB")){
						AB.setSelected(true);
					}else{
						Cero.setSelected(true);	
					}
				}
			}
		}
		
		
	}
	
	public void EliminarDonante() throws SQLException{
		int index = Tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donante seleccionada = Tabla.getSelectionModel().getSelectedItem();

			// Se abre un dialog box de confirmacion de eliminar
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Conformación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Dese borrar al usuario "+ seleccionada.getNombre() + " " +seleccionada.getApellido1() +" ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK

				// Llamar a un método que realice el DELETE en la base de datos
				Conexion con = new Conexion();
				int res = con.BorrarDonante(seleccionada.getEmail());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Persona borrada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerDonantes();
						Tabla.setItems(datos);
						break;

					default:
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!");
						alert.setHeaderText("Inserción NOK!");
						alert.setContentText("¡Ha habido un problema al realizar la inserción!");
						alert.showAndWait();
						break;
				}

				Borrar();
			}

		}else{

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en selección de datos");
			alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
			alert.showAndWait();

		}
	}
	
	public void Borrar(){
		edicion = false;
		Nombre.setText("Nombre");
		Apellido1.setText("Apellido1");
		Apellido2.setText("Apellido2");
		Identificacion.setText("Identificacion");
		Telefono.setText("Telefono");
		Ciclo.setText("Ciclo");
		email.setText("Email");
		CodigoPostal.setText("CodigoPostal");
		FechaNacimiento.setValue(null);
		
		A.setSelected(false);
		AB.setSelected(false);
		B.setSelected(false);
		Cero.setSelected(false);
	}
	
	public void GenerarCarnet() throws FileNotFoundException, DocumentException{
		int index = Tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donante seleccionada = Tabla.getSelectionModel().getSelectedItem();
			int numdonante = seleccionada.getN_Donante();
			String nombre = seleccionada.getNombre();
			String apellido1 = seleccionada.getApellido1();
			String apellido2 = seleccionada.getApellido2();
			String estado = seleccionada.getEstado();
			String gruposanguineo = seleccionada.getGrupoSang();
			
			ImprimeArchivo imprime = new ImprimeArchivo("CarnetDonante"+numdonante, "C:\\Users\\Jose Antonio\\Documents\\PDFSDONANTE\\");
			
			imprime.generarArchivoPDF(nombre, numdonante, apellido1, apellido2, estado, gruposanguineo);
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No has seleccionado un donante.");
			alert.setContentText("Pincha en la tabla para seleccionar un donante.");
			alert.showAndWait();
		}
		
		
	}
	
	public void Buscar() throws SQLException{
		
		
		
		String Nombre = BuscarNombre.getText();
		String Apellido = BuscarApellido.getText();
		String email = BuscarEmail.getText();
		String Identificacion = BuscarID.getText();
		String telefono = BuscarTelefono.getText();
		String ciclo = BuscarCiclo.getText();

		// llama a un  método  que haga el select de la base de datos
		Conexion con = new Conexion();
		datos = con.BuscarDonantes(Nombre, Apellido, email, Identificacion, telefono, ciclo);

		Tabla.setItems(datos);
	}

}
