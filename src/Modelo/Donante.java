package Modelo;

public class Donante {
	private int N_Donante;
	private String Cod_Postal;
	private int Telefono;
	private String Identificacion;
	private String email;
	private String Apellido1;
	private String Apellido2;
	private String Nombre;
	private String Estado;
	private String Fecha_Nac;
	private String GrupoSang;
	private String Ciclo;
	
	public Donante(int n_Donante, String cod_Postal, int telefono, String identificacion, String email,
			String apellido1, String apellido2, String nombre, String estado, String fecha_Nac, String grupoSang,
			String ciclo) {
		super();
		N_Donante = n_Donante;
		Cod_Postal = cod_Postal;
		Telefono = telefono;
		Identificacion = identificacion;
		this.email = email;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		Nombre = nombre;
		Estado = estado;
		Fecha_Nac = fecha_Nac;
		GrupoSang = grupoSang;
		Ciclo = ciclo;
	}

	public int getN_Donante() {
		return N_Donante;
	}

	public void setN_Donante(int n_Donante) {
		N_Donante = n_Donante;
	}

	public String getCod_Postal() {
		return Cod_Postal;
	}

	public void setCod_Postal(String cod_Postal) {
		Cod_Postal = cod_Postal;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getIdentificacion() {
		return Identificacion;
	}

	public void setIdentificacion(String identificacion) {
		Identificacion = identificacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getFecha_Nac() {
		return Fecha_Nac;
	}

	public void setFecha_Nac(String fecha_Nac) {
		Fecha_Nac = fecha_Nac;
	}

	public String getGrupoSang() {
		return GrupoSang;
	}

	public void setGrupoSang(String grupoSang) {
		GrupoSang = grupoSang;
	}

	public String getCiclo() {
		return Ciclo;
	}

	public void setCiclo(String ciclo) {
		Ciclo = ciclo;
	}
	
	

}
