package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Modelo.Conexion;
import Modelo.Formulario;

public class ControladoraNuevaDonacion1 {

	@FXML
	private TextField NumDonante;
	
	
	@FXML
	private Button ConfirmarFormulario;
	
	@FXML
	private Button LeerPreguntas;
	
	@FXML
	private ToggleGroup Pregunta1;
	
	@FXML
	private RadioButton P1Si;
	
	@FXML
	private RadioButton P1No;
	
	@FXML
	private ToggleGroup Pregunta2;
	
	@FXML
	private RadioButton P2Si;
	
	@FXML
	private RadioButton P2No;
	
	@FXML
	private ToggleGroup Pregunta3;
	
	@FXML
	private RadioButton P3Si;
	
	@FXML
	private RadioButton P3No;
	
	@FXML
	private ToggleGroup Pregunta4;
	
	@FXML
	private RadioButton P4Si;
	
	@FXML
	private RadioButton P4No;
	
	@FXML
	private ToggleGroup Pregunta5;
	
	@FXML
	private RadioButton P5Si;
	
	@FXML
	private RadioButton P5No;
	
	@FXML
	private ToggleGroup Pregunta6;
	
	@FXML
	private RadioButton P6Si;
	
	@FXML
	private RadioButton P6No;
	
	@FXML
	private ToggleGroup Pregunta7;
	
	@FXML
	private RadioButton P7Si;
	
	@FXML
	private RadioButton P7No;
	
	@FXML
	private ToggleGroup Pregunta8;
	
	@FXML
	private RadioButton P8Si;
	
	@FXML
	private RadioButton P8No;
	
	@FXML
	private ToggleGroup Pregunta9;
	
	@FXML
	private RadioButton P9Si;
	
	@FXML
	private RadioButton P9No;
	
	@FXML
	private ToggleGroup Pregunta10;
	
	@FXML
	private RadioButton P10Si;
	
	@FXML
	private RadioButton P10No;
	
	@FXML
	private ToggleGroup Pregunta11;
	
	@FXML
	private RadioButton P11Si;
	
	@FXML
	private RadioButton P11No;
	
	@FXML
	private ToggleGroup Pregunta12;
	
	@FXML
	private RadioButton P12Si;
	
	@FXML
	private RadioButton P12No;
	
	@FXML
	private ToggleGroup Pregunta13;
	
	@FXML
	private RadioButton P13Si;
	
	@FXML
	private RadioButton P13No;
	
	@FXML
	private ToggleGroup Pregunta14;
	
	@FXML
	private RadioButton P14Si;
	
	@FXML
	private RadioButton P14No;
	
	@FXML
	private ToggleGroup Pregunta15;
	
	@FXML
	private RadioButton P15Si;
	
	@FXML
	private RadioButton P15No;
	
	@FXML
	private ToggleGroup Pregunta16;
	
	@FXML
	private RadioButton P16Si;
	
	@FXML
	private RadioButton P16No;
	
	@FXML
	private ToggleGroup Pregunta17;
	
	@FXML
	private RadioButton P17Si;
	
	@FXML
	private RadioButton P17No;
	
	@FXML
	private ToggleGroup Pregunta18;
	
	@FXML
	private RadioButton P18Si;
	
	@FXML
	private RadioButton P18No;
	
	@FXML
	private ToggleGroup Pregunta19;
	
	@FXML
	private RadioButton P19Si;
	
	@FXML
	private RadioButton P19No;
	
	@FXML
	private ToggleGroup Pregunta20;
	
	@FXML
	private RadioButton P20Si;
	
	@FXML
	private RadioButton P20No;
	
	@FXML
	private ToggleGroup Pregunta21;
	
	@FXML
	private RadioButton P21Si;
	
	@FXML
	private RadioButton P21No;
	
	@FXML
	private ToggleGroup Pregunta22;
	
	@FXML
	private RadioButton P22Si;
	
	@FXML
	private RadioButton P22No;
	
	@FXML
	private ToggleGroup Pregunta23;
	
	@FXML
	private RadioButton P23Si;
	
	@FXML
	private RadioButton P23No;
	
	@FXML
	private ToggleGroup Pregunta24;
	
	@FXML
	private RadioButton P24Si;
	
	@FXML
	private RadioButton P24No;
	
	@FXML
	private ToggleGroup Pregunta25;
	
	@FXML
	private RadioButton P25Si;
	
	@FXML
	private RadioButton P25No;
	
	@FXML
	private ToggleGroup Pregunta26;
	
	@FXML
	private RadioButton P26Si;
	
	@FXML
	private RadioButton P26No;
	
	@FXML
	private ToggleGroup Pregunta27;
	
	@FXML
	private RadioButton P27Si;
	
	@FXML
	private RadioButton P27No;
	
	@FXML
	private ToggleGroup Pregunta28;
	
	@FXML
	private RadioButton P28Si;
	
	@FXML
	private RadioButton P28No;
	
	@FXML
	private ToggleGroup Pregunta29;
	
	@FXML
	private RadioButton P29Si;
	
	@FXML
	private RadioButton P29No;
	
	@FXML
	private ToggleGroup Pregunta30;
	
	@FXML
	private RadioButton P30Si;
	
	@FXML
	private RadioButton P30No;
	
	@FXML
	private ToggleGroup Pregunta31;
	
	@FXML
	private RadioButton P31Si;
	
	@FXML
	private RadioButton P31No;
	
	@FXML
	private ToggleGroup PreguntaEx1;
	
	@FXML
	private RadioButton PEx1Si;
	
	@FXML
	private RadioButton PEx1No;
	
	@FXML
	private ToggleGroup PreguntaEx2;
	
	@FXML
	private RadioButton PEx2Si;
	
	@FXML
	private RadioButton PEx2No;
	
	@FXML
	private ToggleGroup PreguntaEx3;
	
	@FXML
	private RadioButton PEx3Si;
	
	@FXML
	private RadioButton PEx3No;
	
	@FXML
	private Button SiguienteVentana;
	
	public void Confirmar() throws SQLException{
		
		String respuesta1 = "";
		if(P1Si.isSelected()==true){
			respuesta1 = "S";
		}else{
			if(P1No.isSelected()==true){
				respuesta1 = "N";
			}else{
			}
		}
		
		String respuesta2 = "";
		if(P2Si.isSelected()==true){
			respuesta2= "S";
		}else{
			if(P2No.isSelected()==true){
				respuesta2 = "N";
			}else{
			}
		}
		
		String respuesta3 = "";
		if(P3Si.isSelected()==true){
			respuesta3 = "S";
		}else{
			if(P3No.isSelected()==true){
				respuesta3 = "N";
			}else{
			}
		}
		
		String respuesta4 = "";
		if(P4Si.isSelected()==true){
			respuesta4 = "S";
		}else{
			if(P4No.isSelected()==true){
				respuesta4 = "N";
			}else{
			}
		}
		
		String respuesta5 = "";
		if(P1Si.isSelected()==true){
			respuesta5 = "S";
		}else{
			if(P5No.isSelected()==true){
				respuesta5 = "N";
			}else{
			}
		}
		
		String respuesta6 = "";
		if(P6Si.isSelected()==true){
			respuesta6 = "S";
		}else{
			if(P6No.isSelected()==true){
				respuesta6 = "N";
			}else{
			}
		}
		
		String respuesta7 = "";
		if(P7Si.isSelected()==true){
			respuesta7 = "S";
		}else{
			if(P7No.isSelected()==true){
				respuesta7 = "N";
			}else{
			}
		}
		
		String respuesta8 = "";
		if(P8Si.isSelected()==true){
			respuesta8 = "S";
		}else{
			if(P8No.isSelected()==true){
				respuesta8 = "N";
			}else{
			}
		}
		
		String respuesta9 = "";
		if(P9Si.isSelected()==true){
			respuesta9 = "S";
		}else{
			if(P9No.isSelected()==true){
				respuesta9 = "N";
			}else{
			}
		}
		
		String respuesta10 = "";
		if(P10Si.isSelected()==true){
			respuesta10 = "S";
		}else{
			if(P10No.isSelected()==true){
				respuesta10 = "N";
			}else{
			}
		}
		
		String respuesta11 = "";
		if(P11Si.isSelected()==true){
			respuesta11 = "S";
		}else{
			if(P11No.isSelected()==true){
				respuesta11 = "N";
			}else{
			}
		}
		
		String respuesta12 = "";
		if(P12Si.isSelected()==true){
			respuesta12 = "S";
		}else{
			if(P12No.isSelected()==true){
				respuesta12 = "N";
			}else{
			}
		}
		
		String respuesta13 = "";
		if(P13Si.isSelected()==true){
			respuesta13 = "S";
		}else{
			if(P13No.isSelected()==true){
				respuesta13 = "N";
			}else{
		}
		}
		
		String respuesta14 = "";
		if(P14Si.isSelected()==true){
			respuesta14 = "S";
		}else{
			if(P14No.isSelected()==true){
				respuesta14 = "N";
			}else{
			}
		}
		
		String respuesta15 = "";
		if(P15Si.isSelected()==true){
			respuesta15 = "S";
		}else{
			if(P15No.isSelected()==true){
				respuesta15 = "N";
			}else{
			}
		}
		
		String respuesta16 = "";
		if(P16Si.isSelected()==true){
			respuesta16 = "S";
		}else{
			if(P16No.isSelected()==true){
				respuesta16 = "N";
			}else{
			}
		}
		
		String respuesta17 = "";
		if(P17Si.isSelected()==true){
			respuesta17 = "S";
		}else{
			if(P17No.isSelected()==true){
				respuesta17 = "N";
			}else{
			}
		}
		
		String respuesta18 = "";
		if(P18Si.isSelected()==true){
			respuesta18 = "S";
		}else{
			if(P18No.isSelected()==true){
				respuesta18 = "N";
			}else{
				}
		}
		
		String respuesta19 = "";
		if(P19Si.isSelected()==true){
			respuesta19 = "S";
		}else{
			if(P19No.isSelected()==true){
				respuesta19 = "N";
			}else{
				}
		}
		
		String respuesta20 = "";
		if(P20Si.isSelected()==true){
			respuesta20 = "S";
		}else{
			if(P20No.isSelected()==true){
				respuesta20 = "N";
			}else{
			}
		}
		
		String respuesta21 = "";
		if(P21Si.isSelected()==true){
			respuesta21 = "S";
		}else{
			if(P21No.isSelected()==true){
				respuesta21 = "N";
			}else{
			}
		}
		
		String respuesta22 = "";
		if(P22Si.isSelected()==true){
			respuesta22 = "S";
		}else{
			if(P22No.isSelected()==true){
				respuesta22 = "N";
			}else{
				}
		}
		
		String respuesta23 = "";
		if(P23Si.isSelected()==true){
			respuesta23 = "S";
		}else{
			if(P23No.isSelected()==true){
				respuesta23 = "N";
			}else{
			}
		}
		
		String respuesta24 = "";
		if(P24Si.isSelected()==true){
			respuesta24 = "S";
		}else{
			if(P24No.isSelected()==true){
				respuesta24 = "N";
			}else{
			}
		}
		
		String respuesta25 = "";
		if(P25Si.isSelected()==true){
			respuesta25 = "S";
		}else{
			if(P25No.isSelected()==true){
				respuesta25 = "N";
			}else{
				}
		}
		
		String respuesta26 = "";
		if(P26Si.isSelected()==true){
			respuesta26 = "S";
		}else{
			if(P26No.isSelected()==true){
				respuesta26 = "N";
			}else{}
		}
		
		String respuesta27 = "";
		if(P27Si.isSelected()==true){
			respuesta27 = "S";
		}else{
			if(P27No.isSelected()==true){
				respuesta27 = "N";
			}else{
			}
		}
		
		String respuesta28 = "";
		if(P28Si.isSelected()==true){
			respuesta28 = "S";
		}else{
			if(P28No.isSelected()==true){
				respuesta28 = "N";
			}else{
			}
		}
		
		String respuesta29 = "";
		if(P29Si.isSelected()==true){
			respuesta29 = "S";
		}else{
			if(P29No.isSelected()==true){
				respuesta29 = "N";
			}else{
			}
		}
		
		String respuesta30= "";
		if(P30Si.isSelected()==true){
			respuesta30 = "S";
		}else{
			if(P30No.isSelected()==true){
				respuesta30 = "N";
			}else{
				}
		}
		
		String respuesta31 = "";
		if(P31Si.isSelected()==true){
			respuesta31 = "S";
		}else{
			if(P31No.isSelected()==true){
				respuesta31 = "N";
			}else{
				}
		}
		
		String respuestaEx1 = "";
		if(PEx1Si.isSelected()==true){
			respuestaEx1 = "S";
		}else{
			if(PEx1No.isSelected()==true){
				respuestaEx1 = "N";
			}else{
				}
		}
		
		String respuestaEx2 = "";
		if(PEx2Si.isSelected()==true){
			respuestaEx2 = "S";
		}else{
			if(PEx2No.isSelected()==true){
				respuestaEx2 = "N";
			}else{
				
			}
		}
		
		String respuestaEx3 = "";
		if(PEx3Si.isSelected()==true){
			respuestaEx3 = "S";
		}else{
			if(PEx3No.isSelected()==true){
				respuestaEx3 = "N";
			}else{
				
			}
		}
		Date date = new Date();
		Calendar fecha = new GregorianCalendar();
		fecha.setTime(date);
		int mes = fecha.get(Calendar.MONTH);
		int año = fecha.get(Calendar.YEAR);
		int dia = fecha.get(Calendar.DATE);
		String fechastring = "";
		if(mes>=10){
		fechastring = mes+"-"+dia+"-"+año;
		}else{
			 fechastring = "0"+mes+"-"+dia+"-"+año;

		}
		
		Conexion con = new Conexion();
		String numdonante1 = NumDonante.getText();
		int num_donante = Integer.parseInt(numdonante1);
		String estadodonante = "";
		if(respuestaEx1.equals("Si") || respuestaEx2.equals("Si") || respuestaEx3.equals("Si")){
			estadodonante = "NO APTO";
		}
		else{
			if(respuesta1.equals("No") || respuesta3.equals("No") || respuesta12.equals("Si") || respuesta14.equals("Si") || respuesta16.equals("Si") || respuesta17.equals("Si")){
				estadodonante = "Temporal";
			}else{
				estadodonante = "APTO";
			}
		}
		if(estadodonante.equals("Temporal")){
			
			int mes1 = fecha.get(Calendar.MONTH)+2;
			int año1 = fecha.get(Calendar.YEAR);
			int dia1 = fecha.get(Calendar.DATE);
			if(mes1>12){
				mes1 = mes1 - 12;
				año1 = año1+1;
			}else{
				if(mes1>=10){
					estadodonante = mes1+"-"+dia1+"-"+año1;
				}else{
					estadodonante = "0"+mes1+"-"+dia1+"-"+año1;
				}
			}		
		}
		int actudonante = con.ActualizarEstadoDonante(estadodonante, num_donante);
		int res = con.InsertarFormulario(num_donante, respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10, respuesta11, respuesta12, respuesta13, respuesta14, respuesta15, respuesta16, respuesta17, respuesta18, respuesta19, respuesta20, respuesta21, respuesta22, respuesta23, respuesta24, respuesta25, respuesta26, respuesta27, respuesta28, respuesta29, respuesta30, respuesta31, respuestaEx1, respuestaEx2, respuestaEx3);
		Alert alert = new Alert(AlertType.INFORMATION);
		switch (actudonante){
		case 0:
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Mensaje!");
			alert.setHeaderText("Actualizacion OK!");
			alert.setContentText("¡Estado de donante actualizado correctamente!");
			break;
		}
		
		switch (res){

		case 0:
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Mensaje!");
			alert.setHeaderText("Inserción OK!");
			alert.setContentText("¡Insercion del formulario realizada correctamente!");
			// Actualizo los datos de la tabla
			break;

		default:
		
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setHeaderText("Inserción NOK!");
			alert.setContentText("¡Ha habido un problema al realizar la inserción!");
		}
			
	
	}
	
	public void AbrirPreguntas(){
		try{
			 
			 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Preguntas.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de nuevadonacion2
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SiguienteVentana() throws SQLException{
		Conexion con = new Conexion();
		int numdonante = Integer.parseInt(NumDonante.getText());
		Alert alert = new Alert(AlertType.INFORMATION);
		String estado = "";
		 estado = con.ComprobarEstadoDonante(numdonante);
		 con.InsertarRellena(con.ContarFormularios(), numdonante); 
		if(estado.equals("APTO")){
		try{
			 
 
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("NuevaDonacion2.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			 
			//Creo un Stage, que es como una ventana vacia
			Stage stage= new Stage();
			 
			//Y ahora dentro del Stage meto la vista de nuevadonacion2
			stage.setScene(new Scene(root1));
			 
			// Y ahora le digo que me muestre el stage
			stage.show();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}else{
		if(estado.equals("NO APTO")){
			
			System.out.println("Este donante es alguien no apto para realizar una donacion");
		}else{
			if(estado.equals("n")){
				System.out.println("Este donante no ha rellenado nunca el formulario");
			}else{
				
				System.out.println("Este donante no puede donar todavia, vuelva cuando se le levante la restriccion: "+con.ComprobarEstadoDonante(numdonante));
			}
		}
	}
	}
}
