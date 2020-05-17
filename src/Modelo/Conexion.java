package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Conexion {

	private String url= "";
	private   String user = "";
	private String pwd = "";
	private  String usr = "";
	private  Connection conexion;

	public Conexion()  {

		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Modelo/datos.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
	
	//Insertar donante
	public int InsertarDonante(String Cod_Postal, int Telefono, String ID, String email, 
			String Apellido1, String Apellido2, String Nombre, String Estado, String FechaNacimiento, String GrupoSang, String Ciclo) throws SQLException, FileNotFoundException{
		
		//Cuento los donantes para que NumDonantese pueda introducir automaticamente
		String ContarDonantes = "SELECT N_Donante FROM "+usr+".DONANTE where N_Donante = (Select max(N_Donante) FROM "+usr+".DONANTE)";
		Statement stm = conexion.createStatement();
		ResultSet cuenta = stm.executeQuery(ContarDonantes);
		int numaux = 0;
		while(cuenta.next()){
			int numdonantes = cuenta.getInt(1);
			numaux = numdonantes;
		}
		int SiguienteNumDonante = numaux+1;
		String insertsql = "INSERT INTO "+usr+".DONANTE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Estado = "n";
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, SiguienteNumDonante);
		pstmt.setString(2, Cod_Postal);
		pstmt.setInt(3, Telefono);
		pstmt.setString(4, ID);
		pstmt.setString(5, email);
		pstmt.setString(6, Apellido1);
		pstmt.setString(7, Apellido2);
		pstmt.setString(8, Nombre);
		pstmt.setString(9, Estado);
		pstmt.setString(10, FechaNacimiento);
		pstmt.setString(11, GrupoSang);
		pstmt.setString(12, Ciclo);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese email!!");
				return 1;
			}
			else{
				System.out.println(sqle.toString());
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion1");
				return 2;
			}

		}

	}
	
	//modificar donante
	public int ModificarDonante(String Nombre, String Apellido1, String Apellido2, String ID, 
			String email, String GrupoSang, String Ciclo, int telefono,
			String Cod_Postal, String FechaNacimiento) throws SQLException{


		String updatesql = "UPDATE "+usr+".DONANTE SET Nombre=?, Apellido1=?, Apellido2=?, Identificacion=?, email=?, Grupo_Sang=?, Ciclo=?, Cod_Postal=?, Fecha_nacim='"+FechaNacimiento+"', Telefono=? where Identificacion=?";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		pstmt.setString(1, Nombre);
		pstmt.setString(2, Apellido1);
		pstmt.setString(3, Apellido2);
		pstmt.setString(4, ID);
		pstmt.setString(5, email);
		pstmt.setString(6, GrupoSang);
		pstmt.setString(7, Ciclo);
		pstmt.setString(8, Cod_Postal);
		pstmt.setInt(9, telefono);
		pstmt.setString(10, ID);


		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Donante actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe un donante con ese id!!");
				return 1;
			}
			else{
				System.out.println(sqle.toString());
				System.out.println("Ha habido algún problema con Oracle al hacer la insercion2");
				return 2;
			}

		}

	}
	
	public int ActualizarEstadoDonante(String estado, int numdonante) throws SQLException{


		String updatesql = "UPDATE "+usr+".DONANTE SET ESTADO=? where N_DONANTE=?";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		pstmt.setString(1, estado);
		pstmt.setInt(2, numdonante);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Donante actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

				System.out.println(sqle.toString());
				System.out.println("Ha habido algún problema con Oracle al hacer la insercion2");
				return 2;
			

		}

	}
	
	public int InsertarRellena(int codigoform, int numdonante) throws SQLException{

		String updatesql = "INSERT INTO "+usr+".RELLENA VALUES (?, ?)";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		pstmt.setInt(1, codigoform);
		pstmt.setInt(2, numdonante);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Insert de rellena realizado correctamente!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

				System.out.println(sqle.toString());
				System.out.println("Ha habido algún problema con Oracle al hacer la insercion");
				return 2;
			

		}
	}
	
	public ObservableList<Donante> ObtenerDonantes() throws SQLException{

		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String selectsql = "SELECT * FROM " + usr +".DONANTE";

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;

				int N_Donante= resultado.getInt(1);
				String Cod_Postal = resultado.getString(2);
				int telefono = resultado.getInt(3);
				String identificacion = resultado.getString(4);
				String email = resultado.getString(5);
				String apellido1 = resultado.getString(6);
				String apellido2 = resultado.getString(7);
				String nombre = resultado.getString(8);
				String estado = resultado.getString(9);
				String fecha_Nac = resultado.getString(10);
				String grupoSang = resultado.getString(11);
				String ciclo = resultado.getString(12);
				

				Donante nueva = new Donante(N_Donante, Cod_Postal, telefono, identificacion, email,
						apellido1, apellido2, nombre, estado, fecha_Nac, grupoSang,
						ciclo);
				listadonantes.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
	
	public int BorrarDonante(String email) throws SQLException{

		// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
		String deletesql = "DELETE " + usr +".DONANTE WHERE EMAIL= ?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setString(1, email);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Donante borrado con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado" + codeErrorSQL);
			return 2;
		}

	}
	
	public ObservableList<Donante> BuscarDonantes(String Nombre, String Apellido, String email, String Identificacion, String telefono, String ciclo) throws SQLException{

		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();
		PreparedStatement pstmt;


		/*
		 * Gracias a estos ifs hay un orden de prioridad al realizar la busqueda de donantes,
		 * al escribir varios campos hay un orden de prioridad y el select que devuelve sera segun este checkeo.
		 * Tambien se contara al usuario como es ese orden si se usa.
		 */
		String selectsql = "";
		if(Identificacion.equals("") || Identificacion.equals("Identificacion")){
			if(email.equals("") || email.equals("Email")){
				if(telefono.equals("") || telefono.equals("Telefono")){
					if(Nombre.equals("") || Nombre.equals("Nombre")){
						if(Apellido.equals("") || Apellido.equals("Apellido")){
							selectsql = "SELECT * FROM " + usr +".DONANTE";
							pstmt = conexion.prepareStatement (selectsql);
						}
						else{
							selectsql = "SELECT * FROM " + usr +".DONANTE WHERE Apellido1=?";
							pstmt = conexion.prepareStatement (selectsql);
							pstmt.setString(1, Apellido);
						}
					}
					else{
						selectsql = "SELECT * FROM " + usr +".DONANTE WHERE Nombre=?";
						pstmt = conexion.prepareStatement (selectsql);
						pstmt.setString(1, Nombre);
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Aviso!");
						alert.setHeaderText("Se ha usado un orden de prioridad!!");
						alert.setContentText("Al buscar por varios campos se busca con este orden: ID>Email>Tlfno>Nombre>Apellido!");
						alert.showAndWait();

					}
				}
				else{
					selectsql = "SELECT * FROM " + usr +".DONANTE WHERE telefono=?";
					pstmt = conexion.prepareStatement (selectsql);
					Alert alert = new Alert(AlertType.INFORMATION);
					pstmt.setString(1, telefono);
					alert.setTitle("Aviso!");
					alert.setHeaderText("Se ha usado un orden de prioridad!!");
					alert.setContentText("Al buscar por varios campos se busca con este orden: ID>Email>Tlfno>Nombre>Apellido!");
					alert.showAndWait();

				}
			}
			else{
				selectsql = "SELECT * FROM " + usr +".DONANTE WHERE email=?";
				pstmt = conexion.prepareStatement (selectsql);
				pstmt.setString(1, email);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Aviso!");
				alert.setHeaderText("Se ha usado un orden de prioridad!!");
				alert.setContentText("Al buscar por varios campos se busca con este orden: ID>Email>Tlfno>Nombre>Apellido!");
				alert.showAndWait();
			}
		}
		else{
			selectsql = "SELECT * FROM " + usr +".DONANTE WHERE Identificacion=?";
			pstmt = conexion.prepareStatement (selectsql);
			pstmt.setString(1, Identificacion);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aviso!");
			alert.setHeaderText("Se ha usado un orden de prioridad!!");
			alert.setContentText("Al buscar por varios campos se busca con este orden: ID>Email>Tlfno>Nombre>Apellido!");
			alert.showAndWait();
		}



		//ejecuto la sentencia
		try{
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;


				int N_Donante= resultado.getInt(1);
				String Cod_Postal = resultado.getString(2);
				int telefono2 = resultado.getInt(3);
				String identificacion = resultado.getString(4);
				String email2 = resultado.getString(5);
				String apellido1 = resultado.getString(6);
				String apellido2 = resultado.getString(7);
				String nombre = resultado.getString(8);
				String estado = resultado.getString(9);
				String fecha_Nac = resultado.getString(10);
				String grupoSang = resultado.getString(11);
				String ciclo2 = resultado.getString(12);

				Donante nueva = new Donante(N_Donante, Cod_Postal, telefono2, identificacion, email2,
						apellido1, apellido2, nombre, estado, fecha_Nac, grupoSang,
						ciclo2);
				listadonantes.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage();

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
	
	public int ContarFormularios() throws SQLException{
		String MaxCodForm= "SELECT CODIGO_FORM FROM "+usr+".FORMULARIO where CODIGO_FORM = (Select max(CODIGO_FORM) FROM "+usr+".FORMULARIO)";
		Statement stm = conexion.createStatement();
		ResultSet cuenta = stm.executeQuery(MaxCodForm);
		int numaux = 0;
		while(cuenta.next()){
			int numdonantes = cuenta.getInt(1);
			numaux = numdonantes;
		}
		int SiguienteNumFormulario = numaux;
		
		return SiguienteNumFormulario;
	}
	
	public String ComprobarEstadoDonante(int numdonante) throws SQLException{
		String estadodonante = "SELECT ESTADO FROM "+usr+".DONANTE WHERE N_DONANTE=?";
	
			Statement stm = conexion.createStatement();
			PreparedStatement pstmt = conexion.prepareStatement (estadodonante);
			pstmt.setInt(1, numdonante);
			String estado = "";
			
			try{
				ResultSet resultado = pstmt.executeQuery();

				int contador = 0;
				while(resultado.next()){
					contador++;


					estado= resultado.getString(1);
					

				
				}

				if(contador==0)
					System.out.println("no data found");

			}catch(SQLException sqle){

				int pos = sqle.getMessage().indexOf(":");
				String codeErrorSQL = sqle.getMessage();

				System.out.println(codeErrorSQL);
			}
			
		return estado;
		
	}
	
	public int InsertarFormulario(int CodigoDonante, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuesta5,
			String respuesta6, String respuesta7, String respuesta8, String respuesta9, String respuesta10, String respuesta11,
			String respuesta12, String respuesta13, String respuesta14, String respuesta15, String respuesta16, String respuesta17,
			String respuesta18, String respuesta19, String respuesta20, String respuesta21, String respuesta22, String respuesta23,
			String respuesta24, String respuesta25, String respuesta26, String respuesta27, String respuesta28, String respuesta29,
			String respuesta30, String respuesta31, String respuestaEx1, String respuestaEx2, String respuestaEx3) throws SQLException{
		//Cuento los donantes para que NumDonantese pueda introducir automaticamente
				String MaxCodForm= "SELECT CODIGO_FORM FROM "+usr+".FORMULARIO where CODIGO_FORM = (Select max(CODIGO_FORM) FROM "+usr+".FORMULARIO)";
				Statement stm = conexion.createStatement();
				ResultSet cuenta = stm.executeQuery(MaxCodForm);
				int numaux = 0;
				while(cuenta.next()){
					int numdonantes = cuenta.getInt(1);
					numaux = numdonantes;
				}
				int SiguienteNumFormulario = numaux+1;
				
				
				String InsertarFormulario = "INSERT INTO "+usr+".FORMULARIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt = conexion.prepareStatement (InsertarFormulario);
				pstmt.setInt(1, SiguienteNumFormulario);
				pstmt.setString(2, respuesta1);
				pstmt.setString(3, respuesta2);
				pstmt.setString(4, respuesta3);
				pstmt.setString(5, respuesta4);
				pstmt.setString(6, respuesta5);
				pstmt.setString(7, respuesta6);
				pstmt.setString(8, respuesta7);
				pstmt.setString(9, respuesta8);
				pstmt.setString(10, respuesta9);
				pstmt.setString(11, respuesta10);
				pstmt.setString(12, respuesta11);
				pstmt.setString(13, respuesta12);
				pstmt.setString(14, respuesta13);
				pstmt.setString(15, respuesta14);
				pstmt.setString(16, respuesta15);
				pstmt.setString(17, respuesta16);
				pstmt.setString(18, respuesta17);
				pstmt.setString(19, respuesta18);
				pstmt.setString(20, respuesta19);
				pstmt.setString(21, respuesta20);
				pstmt.setString(22, respuesta21);
				pstmt.setString(23, respuesta22);
				pstmt.setString(24, respuesta23);
				pstmt.setString(25, respuesta24);
				pstmt.setString(26, respuesta25);
				pstmt.setString(27, respuesta26);
				pstmt.setString(28, respuesta27);
				pstmt.setString(29, respuesta28);
				pstmt.setString(30, respuesta29);
				pstmt.setString(31, respuesta30);
				pstmt.setString(32, respuesta31);
				pstmt.setString(33, respuestaEx1);
				pstmt.setString(34, respuestaEx2);
				pstmt.setString(35, respuestaEx3);
	
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Formulario insertado con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion" + codeErrorSQL);
				return 2;
			}

		}
	
	
		
public int InsertarDonacion(String Fecha, String Tipo, String Pulso, String TA_SIST, String TA_DIAS, String HB_CAP, String HB_Ven, int Volumen) throws SQLException{
	//Cuento los donantes para que NumDonantese pueda introducir automaticamente
			String MaxCodDonacion= "SELECT NUM_DONACION FROM "+usr+".DONACION where NUM_DONACION = (Select max(NUM_DONACION) FROM "+usr+".DONACION)";
			Statement stm = conexion.createStatement();
			ResultSet cuenta = stm.executeQuery(MaxCodDonacion);
			int numaux = 0;
			while(cuenta.next()){
				int numdonaciones = cuenta.getInt(1);
				numaux = numdonaciones;
			}
			int SiguienteNumDonacion = numaux+1;
			
			
			String InsertarDonacion = "INSERT INTO "+usr+".DONACION VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conexion.prepareStatement (InsertarDonacion);
			pstmt.setInt(1, SiguienteNumDonacion);
			pstmt.setString(2, Fecha);
			pstmt.setString(3, Tipo);
			pstmt.setString(4, Pulso);
			pstmt.setString(5, TA_SIST);
			pstmt.setString(6, TA_DIAS);
			pstmt.setString(7, HB_CAP);
			pstmt.setString(8, HB_Ven);
			pstmt.setInt(9, Volumen);
			

	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en la inserción " + resultado);
		else
			System.out.println("Donacion insertado con éxito!!!");

		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);
			System.out.println("Ha habido algún problema con  Oracle al hacer la insercion" + codeErrorSQL);
			return 2;
		}

	}


public ObservableList<Donacion> ObtenerDonaciones() throws SQLException{

	ObservableList<Donacion> listadonaciones = FXCollections.observableArrayList();

	//Preparo la conexión para ejecutar sentencias SQL de tipo update
	Statement stm = conexion.createStatement();

	// Preparo la sentencia SQL CrearTablaPersonas
	String selectsql = "SELECT * FROM " + usr +".DONACION";

	//ejecuto la sentencia
	try{
		ResultSet resultado = stm.executeQuery(selectsql);

		int contador = 0;
		while(resultado.next()){
			contador++;

			int N_Donacion = resultado.getInt(1);
			String fecha = resultado.getString(2);
			String TipoDonacion = resultado.getString(3);
			String Pulso = resultado.getString(4);
			String TA_Sist = resultado.getString(5);
			String TA_Dias = resultado.getString(6);
			String HB_Cap = resultado.getString(7);
			String HB_Ven = resultado.getString(8);
			int Volumen = resultado.getInt(9);
			Donacion nueva = new Donacion(N_Donacion, fecha.substring(0,10), TipoDonacion, Pulso, TA_Sist, TA_Dias, HB_Cap, HB_Ven, Volumen);
			listadonaciones.add(nueva);
		}

		if(contador==0)
			System.out.println("no data found");

	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		System.out.println(codeErrorSQL);
	}

	return listadonaciones;
}
public int EliminarDonacion(int Numdonacion) throws SQLException{

	// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
	String deletesql = "DELETE " + usr +".DONACION WHERE Num_Donacion= ?";
	PreparedStatement pstmt = conexion.prepareStatement (deletesql);
	pstmt.setInt(1, Numdonacion);

	//ejecuto la sentencia
	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en el borrado " + resultado);
		else
			System.out.println("Donante borrado con éxito!!!");

		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		System.out.println("Ha habido algún problema con  Oracle al hacer el borrado" + codeErrorSQL);
		return 2;
	}
}
public int InsertRealiza(int numdonacion, int numdonante) throws SQLException{

	String updatesql = "INSERT INTO "+usr+".REALIZA VALUES (?, ?)";

	PreparedStatement pstmt = conexion.prepareStatement (updatesql);
	pstmt.setInt(1, numdonacion);
	pstmt.setInt(2, numdonante);

	//ejecuto la sentencia
	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en la actualización " + resultado);
		else
			System.out.println("Insert de realiza realizado correctamente!!!");

		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(sqle.toString());
			System.out.println("Ha habido algún problema con Oracle al hacer la insercion");
			return 2;
		

	}
	
}

}