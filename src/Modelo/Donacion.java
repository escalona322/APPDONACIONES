package Modelo;

public class Donacion {
	private int Numdonacion;
	private String Fecha;
	private String TipoDonacion;
	private String Pulso;
	private String Ta_Sist;
	private String HB_Cap;
	private String HB_VEN;
	private String GrupoSang;
	private int Volumen;
	public Donacion(int numdonacion, String fecha, String tipoDonacion, String pulso, String ta_Sist, String hB_Cap,
			String hB_VEN, String grupoSang, int volumen) {
		super();
		Numdonacion = numdonacion;
		Fecha = fecha;
		TipoDonacion = tipoDonacion;
		Pulso = pulso;
		Ta_Sist = ta_Sist;
		HB_Cap = hB_Cap;
		HB_VEN = hB_VEN;
		Volumen = volumen;
		GrupoSang = grupoSang;
	}
	public int getNumdonacion() {
		return Numdonacion;
	}
	public void setNumdonacion(int numdonacion) {
		Numdonacion = numdonacion;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getTipoDonacion() {
		return TipoDonacion;
	}
	public void setTipoDonacion(String tipoDonacion) {
		TipoDonacion = tipoDonacion;
	}
	public String getPulso() {
		return Pulso;
	}
	public void setPulso(String pulso) {
		Pulso = pulso;
	}
	public String getTa_Sist() {
		return Ta_Sist;
	}
	public void setTa_Sist(String ta_Sist) {
		Ta_Sist = ta_Sist;
	}
	public String getHB_Cap() {
		return HB_Cap;
	}
	public void setHB_Cap(String hB_Cap) {
		HB_Cap = hB_Cap;
	}
	public String getHB_VEN() {
		return HB_VEN;
	}
	public void setHB_VEN(String hB_VEN) {
		HB_VEN = hB_VEN;
	}
	public Number getVolumen() {
		return Volumen;
	}
	public void setVolumen(int volumen) {
		Volumen = volumen;
	}
	
	

}
