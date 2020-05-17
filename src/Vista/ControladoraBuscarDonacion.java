package Vista;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import Modelo.Conexion;
import Modelo.Donacion;
import Modelo.DonacionBuscada;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladoraBuscarDonacion {
	
	@FXML
	private DatePicker Fecha;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private ToggleGroup RBGsang;
	
	@FXML
	private RadioButton RBA;
	
	@FXML
	private RadioButton RBB;
	
	@FXML
	private RadioButton RBAB;
	
	@FXML
	private RadioButton Cero;
	
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
	private TableView<DonacionBuscada> TablaDonacion;
	
	@FXML
	private TableColumn<DonacionBuscada, String> NumDonacionT;
	
	@FXML
	private TableColumn<DonacionBuscada, String> NombreT;
	
	@FXML
	private TableColumn<DonacionBuscada, String> GrupoSangT;
	
	@FXML
	private TableColumn<DonacionBuscada, String> FechaDonacionT;
	
	ObservableList<DonacionBuscada> datos = FXCollections.observableArrayList();
	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Donante> datos


		NumDonacionT.setCellValueFactory(new PropertyValueFactory<DonacionBuscada,String>("NumDonacion"));
		NombreT.setCellValueFactory(new PropertyValueFactory<DonacionBuscada,String>("NombreDonante"));
		GrupoSangT.setCellValueFactory(new PropertyValueFactory<DonacionBuscada,String>("GrupoSanguineo"));
		FechaDonacionT.setCellValueFactory(new PropertyValueFactory<DonacionBuscada,String>("Fecha"));
		
	
		// Al arrancar la vista se pone edicion a false

	}
	
	public void BuscarPorFecha() throws SQLException{
		Conexion con = new Conexion();
		DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
		  String fecha_n = Fecha.getValue().format(isoFecha);
		 
		  //mes-dia-año
		  String mes=  fecha_n.substring(8, 10);
		  String dia= fecha_n.substring(5, 7);
		  String año= fecha_n.substring(0, 4);
		 
		  String fecha= mes+ "-" + dia + "-" + año;
		  
		  datos = con.BuscarPorFecha(fecha);
		  
	}
	
	public void BuscarPorNombre() throws SQLException{
		Conexion con = new Conexion();
		
		String nombre = Nombre.getText();
		  
		  datos = con.BuscarPorNombre(nombre);

	}
	
	public void BuscarPorGSang() throws SQLException{
		Conexion con = new Conexion();
		
		
		
		String GrupoSang = "";
		if(RBA.isSelected()){
			GrupoSang = "A";
		}
		else{
			if(RBB.isSelected()){
				GrupoSang = "B";
			}else{
				if(RBAB.isSelected()){
					GrupoSang = "AB";
				}else{
					if(Cero.isSelected()){
						GrupoSang = "0";
					}
			}
			}
		}
		  
		  datos = con.BuscarPorGSang(GrupoSang);
	}
	
	public void BuscarPorTipo() throws SQLException{
Conexion con = new Conexion();
		
		
		
		String Tipo = "";
		if(Aferesis.isSelected()){
			Tipo = "Aferesis";
		}
		else{
			if(Normal.isSelected()){
				Tipo = "Normal";
			}else{
				
			}
		}
		  
		  datos = con.BuscarPorTipo(Tipo);
	}

}
