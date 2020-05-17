package Vista;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import Modelo.Conexion;
import Modelo.Donacion;
import Modelo.Donante;
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

public class ControladoraNuevaDonacion2 {
	
	@FXML
	private Button Relacionar;
	
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
	private TextField Numdonante;
	
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
	private TableColumn<Donacion, Integer> NumDonacionT;
	
	@FXML
	private TableColumn<Donacion, String> TipoT;
	
	@FXML
	private TableColumn<Donacion, String> FechaDonacionT;
	
	@FXML
	private TableColumn<Donacion, String> PulsoT;
	
	ObservableList<Donacion> datos = FXCollections.observableArrayList();
	
	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Donante> datos

		Conexion con = new Conexion();
		datos = con.ObtenerDonaciones();

		TablaDonacion.setItems(datos);

		NumDonacionT.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("Numdonacion"));
		TipoT.setCellValueFactory(new PropertyValueFactory<Donacion,String>("tipoDonacion"));
		FechaDonacionT.setCellValueFactory(new PropertyValueFactory<Donacion,String>("Fecha"));
		PulsoT.setCellValueFactory(new PropertyValueFactory<Donacion,String>("Pulso"));
		
	

	}
	public void Insertar() throws SQLException{
		
		String TipoDonacion = "";
		if(Aferesis.isSelected()){
			TipoDonacion = "Aferesis";
		}
		else{
			if(Normal.isSelected()){
				TipoDonacion = "Normal";
			}
			}
		
		// Añadir un chequeo de campos vacíos
		if(TensionD.getText().equals("") || TensionS.getText().equals("") || Pulso.getText().equals("") || HBVen.getText().equals("") ||  HBCap.getText().equals("") || TipoDonacion.equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}else{			
				Conexion con = new Conexion();
						
				DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
				  String fecha_n = FechaDonacion.getValue().format(isoFecha);
				 
				  //mes-dia-año
				  String mes=  fecha_n.substring(8, 10);
				  String dia= fecha_n.substring(5, 7);
				  String año= fecha_n.substring(0, 4);
				 
				  String fecha_na= mes+ "-" + dia + "-" + año;
				  
				int res = con.InsertarDonacion(fecha_na, TipoDonacion, Pulso.getText(), TensionS.getText(), TensionD.getText(), HBCap.getText(), HBVen.getText(), Integer.parseInt(Pulso.getText()));
				switch (res){

				case 0:
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("OK!");
					alert.setHeaderText("Inserción OK!");
					alert.setContentText("¡Persona insertada con éxito!");
					alert.showAndWait();

					// Actualizo los datos de la tabla
					datos = con.ObtenerDonaciones();
					TablaDonacion.setItems(datos);
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
	
		public void Relacionar() throws SQLException{
			int index = TablaDonacion.getSelectionModel().getSelectedIndex();
			if( index >= 0){
			Conexion con = new Conexion();
			int numdonante = Integer.parseInt(Numdonante.getText());
			Donacion seleccionada = TablaDonacion.getSelectionModel().getSelectedItem();
			
			 con.InsertRealiza(seleccionada.getNumdonacion(), numdonante); 
			}else{
				
			}
		}
	
	
	public void Borrar(){
		TensionD.setText("Tension diástolica");
		TensionS.setText("Tension sistolica");
		Pulso.setText("Pulso");
		HBVen.setText("HB Venosa");
		HBCap.setText("HB Capilar");
		Aferesis.setSelected(false);
		Normal.setSelected(false);
	}
	
	public void Eliminar() throws SQLException{
		int index = TablaDonacion.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donacion seleccionada = TablaDonacion.getSelectionModel().getSelectedItem();

			// Se abre un dialog box de confirmacion de eliminar
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Conformación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Dese borrar la donacion "+ seleccionada.getNumdonacion());

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK

				// Llamar a un método que realice el DELETE en la base de datos
				Conexion con = new Conexion();
				int res = con.EliminarDonacion(seleccionada.getNumdonacion());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Persona borrada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerDonaciones();
						TablaDonacion.setItems(datos);
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
	

}
