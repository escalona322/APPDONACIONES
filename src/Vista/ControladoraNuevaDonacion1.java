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
	
	public void Confirmar(){
		
		String respuesta1 = "";
		if(P1Si.isSelected()==true){
			respuesta1 = "Si";
		}else{
			if(P1No.isSelected()==true){
				respuesta1 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 1");
				alert.showAndWait();
			}
		}
		
		String respuesta2 = "";
		if(P2Si.isSelected()==true){
			respuesta2= "Si";
		}else{
			if(P2No.isSelected()==true){
				respuesta2 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 2");
				alert.showAndWait();
			}
		}
		
		String respuesta3 = "";
		if(P3Si.isSelected()==true){
			respuesta3 = "Si";
		}else{
			if(P3No.isSelected()==true){
				respuesta3 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 3");
				alert.showAndWait();
			}
		}
		
		String respuesta4 = "";
		if(P4Si.isSelected()==true){
			respuesta4 = "Si";
		}else{
			if(P4No.isSelected()==true){
				respuesta4 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 4");
				alert.showAndWait();
			}
		}
		
		String respuesta5 = "";
		if(P1Si.isSelected()==true){
			respuesta5 = "Si";
		}else{
			if(P5No.isSelected()==true){
				respuesta5 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 5");
				alert.showAndWait();
			}
		}
		
		String respuesta6 = "";
		if(P6Si.isSelected()==true){
			respuesta6 = "Si";
		}else{
			if(P6No.isSelected()==true){
				respuesta6 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 6");
				alert.showAndWait();
			}
		}
		
		String respuesta7 = "";
		if(P7Si.isSelected()==true){
			respuesta7 = "Si";
		}else{
			if(P7No.isSelected()==true){
				respuesta7 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 7");
				alert.showAndWait();
			}
		}
		
		String respuesta8 = "";
		if(P8Si.isSelected()==true){
			respuesta8 = "Si";
		}else{
			if(P8No.isSelected()==true){
				respuesta8 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 8");
				alert.showAndWait();
			}
		}
		
		String respuesta9 = "";
		if(P9Si.isSelected()==true){
			respuesta9 = "Si";
		}else{
			if(P9No.isSelected()==true){
				respuesta9 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 9");
				alert.showAndWait();
			}
		}
		
		String respuesta10 = "";
		if(P10Si.isSelected()==true){
			respuesta10 = "Si";
		}else{
			if(P10No.isSelected()==true){
				respuesta10 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 10");
				alert.showAndWait();
			}
		}
		
		String respuesta11 = "";
		if(P11Si.isSelected()==true){
			respuesta11 = "Si";
		}else{
			if(P11No.isSelected()==true){
				respuesta11 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 11");
				alert.showAndWait();
			}
		}
		
		String respuesta12 = "";
		if(P12Si.isSelected()==true){
			respuesta12 = "Si";
		}else{
			if(P12No.isSelected()==true){
				respuesta12 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 12");
				alert.showAndWait();
			}
		}
		
		String respuesta13 = "";
		if(P13Si.isSelected()==true){
			respuesta13 = "Si";
		}else{
			if(P13No.isSelected()==true){
				respuesta13 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 13");
				alert.showAndWait();
			}
		}
		
		String respuesta14 = "";
		if(P14Si.isSelected()==true){
			respuesta14 = "Si";
		}else{
			if(P14No.isSelected()==true){
				respuesta14 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 14");
				alert.showAndWait();
			}
		}
		
		String respuesta15 = "";
		if(P15Si.isSelected()==true){
			respuesta15 = "Si";
		}else{
			if(P15No.isSelected()==true){
				respuesta15 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 15");
				alert.showAndWait();
			}
		}
		
		String respuesta16 = "";
		if(P16Si.isSelected()==true){
			respuesta16 = "Si";
		}else{
			if(P16No.isSelected()==true){
				respuesta16 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 16");
				alert.showAndWait();
			}
		}
		
		String respuesta17 = "";
		if(P17Si.isSelected()==true){
			respuesta17 = "Si";
		}else{
			if(P17No.isSelected()==true){
				respuesta17 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 17");
				alert.showAndWait();
			}
		}
		
		String respuesta18 = "";
		if(P18Si.isSelected()==true){
			respuesta18 = "Si";
		}else{
			if(P18No.isSelected()==true){
				respuesta18 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 18");
				alert.showAndWait();
			}
		}
		
		String respuesta19 = "";
		if(P19Si.isSelected()==true){
			respuesta19 = "Si";
		}else{
			if(P19No.isSelected()==true){
				respuesta19 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 19");
				alert.showAndWait();
			}
		}
		
		String respuesta20 = "";
		if(P20Si.isSelected()==true){
			respuesta20 = "Si";
		}else{
			if(P20No.isSelected()==true){
				respuesta20 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 20");
				alert.showAndWait();
			}
		}
		
		String respuesta21 = "";
		if(P21Si.isSelected()==true){
			respuesta21 = "Si";
		}else{
			if(P21No.isSelected()==true){
				respuesta21 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 21");
				alert.showAndWait();
			}
		}
		
		String respuesta22 = "";
		if(P22Si.isSelected()==true){
			respuesta22 = "Si";
		}else{
			if(P22No.isSelected()==true){
				respuesta22 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 22");
				alert.showAndWait();
			}
		}
		
		String respuesta23 = "";
		if(P23Si.isSelected()==true){
			respuesta23 = "Si";
		}else{
			if(P23No.isSelected()==true){
				respuesta23 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 23");
				alert.showAndWait();
			}
		}
		
		String respuesta24 = "";
		if(P24Si.isSelected()==true){
			respuesta24 = "Si";
		}else{
			if(P24No.isSelected()==true){
				respuesta24 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 24");
				alert.showAndWait();
			}
		}
		
		String respuesta25 = "";
		if(P25Si.isSelected()==true){
			respuesta25 = "Si";
		}else{
			if(P25No.isSelected()==true){
				respuesta25 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 25");
				alert.showAndWait();
			}
		}
		
		String respuesta26 = "";
		if(P26Si.isSelected()==true){
			respuesta26 = "Si";
		}else{
			if(P26No.isSelected()==true){
				respuesta26 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 26");
				alert.showAndWait();
			}
		}
		
		String respuesta27 = "";
		if(P27Si.isSelected()==true){
			respuesta27 = "Si";
		}else{
			if(P27No.isSelected()==true){
				respuesta27 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 27");
				alert.showAndWait();
			}
		}
		
		String respuesta28 = "";
		if(P28Si.isSelected()==true){
			respuesta28 = "Si";
		}else{
			if(P28No.isSelected()==true){
				respuesta28 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 28");
				alert.showAndWait();
			}
		}
		
		String respuesta29 = "";
		if(P29Si.isSelected()==true){
			respuesta29 = "Si";
		}else{
			if(P29No.isSelected()==true){
				respuesta29 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 29");
				alert.showAndWait();
			}
		}
		
		String respuesta30= "";
		if(P30Si.isSelected()==true){
			respuesta30 = "Si";
		}else{
			if(P30No.isSelected()==true){
				respuesta30 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 30");
				alert.showAndWait();
			}
		}
		
		String respuesta31 = "";
		if(P31Si.isSelected()==true){
			respuesta31 = "Si";
		}else{
			if(P31No.isSelected()==true){
				respuesta31 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta 31");
				alert.showAndWait();
			}
		}
		
		String respuestaEx1 = "";
		if(PEx1Si.isSelected()==true){
			respuestaEx1 = "Si";
		}else{
			if(P1No.isSelected()==true){
				respuestaEx1 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta excluyente 1");
				alert.showAndWait();
			}
		}
		
		String respuestaEx2 = "";
		if(PEx2Si.isSelected()==true){
			respuestaEx2 = "Si";
		}else{
			if(PEx2No.isSelected()==true){
				respuestaEx2 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta excluyente 2");
				alert.showAndWait();
			}
		}
		
		String respuestaEx3 = "";
		if(PEx3Si.isSelected()==true){
			respuestaEx3 = "Si";
		}else{
			if(PEx3No.isSelected()==true){
				respuestaEx3 = "No";
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!");
				alert.setHeaderText("Asegurate de responder a todas las preguntas");
				alert.setContentText("No has respondido la pregunta excluyente 3");
				alert.showAndWait();
			}
		}
		
		Conexion con = new Conexion();
		
		int res = con.InsertarFormulario(respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10, respuesta11, respuesta12, respuesta13, respuesta14, respuesta15, respuesta16, respuesta17, respuesta18, respuesta19, respuesta20, respuesta21, respuesta22, respuesta23, respuesta24, respuesta25, respuesta26, respuesta27, respuesta28, respuesta29, respuesta30, respuesta31, respuestaEx1, respuestaEx2, respuestaEx3);
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
	
	public void SiguienteVentana(){
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
	}
}
