package Funcionalidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FuncioUsuario {
	static String ruta = "ficheros/Usuarios.txt";

	public static void EscribirUsuario(PerfilUsuario u) throws IOException {
		File FileUsu = new File(ruta);
		if (!FileUsu.exists()) {
			FileUsu.createNewFile();
		}
		FileWriter wusu = new FileWriter(ruta, true);

		wusu.write(u.getNombre() + ";" + u.getContra() + ";" + u.getCorreo() + "\n");

		wusu.close();
	}

	public static ArrayList<PerfilUsuario> LeerUsuario() throws IOException {
		ArrayList<PerfilUsuario> array = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(ruta));

		String linea = br.readLine();
		while (linea != null) {
			String[] datos = linea.split(";");
			String nombre = datos[0];
			String contra = datos[1];
			String correo = datos[2];
			PerfilUsuario usu = new PerfilUsuario(nombre, contra, correo);
			array.add(usu);
			linea = br.readLine();
		}
		br.close();
		return array;
	}

	public static boolean ComprobarContra(String usu, String contra) throws IOException {
		ArrayList<PerfilUsuario> array = new ArrayList<>();
		array = LeerUsuario();
		for (PerfilUsuario u : array) {
			if (u.getNombre().equals(usu) && u.getContra().equals(contra)) {
				return true;
			}
		}
		return false;
	}

	public static boolean ComprobarUsu(String usu) throws IOException {
		ArrayList<PerfilUsuario> array = new ArrayList<>();
		array = LeerUsuario();
		for (PerfilUsuario u : array) {
			if (u.getNombre().equals(usu)) {
				return true;
			}
		}
		return false;
	}

}
