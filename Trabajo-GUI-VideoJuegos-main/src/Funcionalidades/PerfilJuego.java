package Funcionalidades;

import java.io.Serializable;

public class PerfilJuego implements Serializable {
	

	private String nombre,fechaSalida, dirImg,resEdad,usuario;
	private int nVentas;
	

	public PerfilJuego(String nombre, String resEdad, String fechaSalida, int nVentas, String dirImg,String usuario) {
		super();
		this.nombre = nombre;
		this.resEdad = resEdad;
		this.fechaSalida = fechaSalida;
		this.nVentas = nVentas;
		this.dirImg = dirImg;
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public String getResEdad() {
		return resEdad;
	}

	public void setResEdad(String resEdad) {
		this.resEdad = resEdad;
	}

	
	public int getnVentas() {
		return nVentas;
	}

	public void setnVentas(int nVentas) {
		this.nVentas = nVentas;
	}
	
	
	public String getDirImg() {
		return dirImg;
	}

	public void setDirImg(String dirImg) {
		this.dirImg = dirImg;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	


	/*
	public String toStringg() {
		return nombre+";"+resEdad+";"+fechaSalida+";"+nVentas+";"+dirImg;
	}
	*/
	
	
	

}
