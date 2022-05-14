package Funcionalidades;

public class PerfilUsuario {

	private String nombre, contra, correo;

	public PerfilUsuario(String nombre, String contra, String correo) {
		super();
		this.nombre = nombre;
		this.contra = contra;
		this.correo = correo;
	}

	public PerfilUsuario() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario: "+nombre+", correo: "+correo+", contraseña: "+contra;
	}
	
	
}
