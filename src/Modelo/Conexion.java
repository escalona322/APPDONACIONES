package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
			String Apellido1, String Apellido2, String Nombre, String Estado, File foto,
			String FechaNacimiento, String GrupoSang, String Ciclo) throws SQLException, FileNotFoundException{
		
		//Cuento los donantes para que NumDonantese pueda introducir automaticamente
		String ContarDonantes = "SELECT N_Donante"+usr+"FROM DONANTE where N_Donante = (Select max(N_Donante) from "+usr+".Donante";
		Statement stm = conexion.createStatement();
		ResultSet cuenta = stm.executeQuery(ContarDonantes);
		// Preparo la sentencia SQL
		int SiguienteNumDonante = cuenta.getInt(1)+1;
		String insertsql = "INSERT INTO "+usr+".DONANTE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
		FileInputStream convertir_imagen = new FileInputStream (foto);
		pstmt.setBlob(11, convertir_imagen, foto.length());
		pstmt.setString(12, GrupoSang);
		pstmt.setString(13, Ciclo);
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
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	//modificar donante
	public int ModificarDonante(String Nombre, String Apellido1, String Apellido2, String ID, 
			String email, String GrupoSang, String Ciclo, int telefono,
			String Cod_Postal, String FechaNacimiento) throws SQLException{


		String updatesql = "UPDATE"+usr+".DONANTE SET Nombre=?, Apellido1=?, Apellido2=?, Identificacion=?, email=?, GrupoSang=?, Ciclo=?, Cod_Postal=?, Fecha_nacim=?, Telefono=? where Identificacion=?";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		pstmt.setString(1, Nombre);
		pstmt.setString(2, Apellido1);
		pstmt.setString(3, Apellido2);
		pstmt.setString(4, ID);
		pstmt.setString(5, email);
		pstmt.setString(6, GrupoSang);
		pstmt.setString(7, Ciclo);
		pstmt.setString(8, Cod_Postal);
		pstmt.setString(9, FechaNacimiento);
		pstmt.setInt(10, telefono);
		pstmt.setString(11, ID);


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
				System.out.println("Ha habido algún problema con Oracle al hacer la insercion");
				return 2;
			}

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
		if(Identificacion.equals("")){
			if(email.equals("")){
				if(telefono.equals("")){
					if(Nombre.equals("")){
						if(Apellido.equals("")){
							selectsql = "SELECT * FROM " + usr +".DONANTE";
							pstmt = conexion.prepareStatement (selectsql);
						}
						else{
							selectsql = "SELECT * FROM " + usr +".PERSONAS WHERE Apellido1 LIKE ?%";
							pstmt = conexion.prepareStatement (selectsql);
						}
					}
					else{
						selectsql = "SELECT * FROM " + usr +".PERSONAS WHERE Nombre LIKE ?%";
						pstmt = conexion.prepareStatement (selectsql);

					}
				}
				else{
					selectsql = "SELECT * FROM " + usr +".PERSONAS WHERE telefono LIKE ?%";
					pstmt = conexion.prepareStatement (selectsql);

				}
			}
			else{
				selectsql = "SELECT * FROM " + usr +".PERSONAS WHERE email LIKE ?%";
				pstmt = conexion.prepareStatement (selectsql);
			}
		}
		else{
			selectsql = "SELECT * FROM " + usr +".PERSONAS WHERE Identificacion LIKE ?%";
			pstmt = conexion.prepareStatement (selectsql);
			
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
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
	
	public byte[] LeerFoto(String Identificacion) throws SQLException{
		
		byte[] byteImage = null;
		
		try{
			//Sentencia sql
			String selectfoto = "SELECT "
		}catch(SQLException sqle){
			
		}
		
	}

}
