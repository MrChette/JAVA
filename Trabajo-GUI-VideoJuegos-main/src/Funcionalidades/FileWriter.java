package Funcionalidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class FileWriter {
	private static ObjectOutputStream os;
	public static void abrir(File games) throws IOException {

		try {
			if (games.exists()) {
				os = new AppendableObjectOutputStream(new FileOutputStream(games, true));
			} else {
				games.createNewFile();
				os = new ObjectOutputStream(new FileOutputStream(games));
			}
		} catch (Exception ex) {
		}
	}

	
	public static void agregar(String nombre,String resEdad,String fechaSalida,int nVentas,String dirImg,String usuario) throws IOException{
			os.writeObject(new PerfilJuego(nombre, resEdad, fechaSalida, nVentas, dirImg, usuario));
	};
	
	public static void cerrar() throws IOException {
		os.close();
	}

}
