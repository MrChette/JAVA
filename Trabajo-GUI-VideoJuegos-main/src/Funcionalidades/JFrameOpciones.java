package Funcionalidades;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;


public class JFrameOpciones {

	// Color de fundo de aplicacion
	public static final Color fondo = new Color(239, 221, 194);
	public static final Color fondo2 = new Color(244, 236, 226);
	public static final Color bordeBoton = new Color(136, 82, 29);
	
	//Inserto de imagenes
		//Logo
	public static final ImageIcon logo= new ImageIcon("ficheros/Imagenes/iconos/logo.png");
		
		//Mostrar contraseña
	public static final ImageIcon mostrar= new ImageIcon("ficheros/imagenes/iconos/mostrar.png");
	public static Image imgmostrar = JFrameOpciones.mostrar.getImage();
	public static Image newimg = imgmostrar.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		//Ocultar contraseña
	public static final ImageIcon ocultar= new ImageIcon("ficheros/imagenes/iconos/ocultar.png");
	public static Image imgocultar = JFrameOpciones.ocultar.getImage();
	public static Image newImgOcultar = imgocultar.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		//Error
	public static final ImageIcon error= new ImageIcon("ficheros/imagenes/iconos/error.png");
	public static Image imgError = JFrameOpciones.error.getImage();
	public static Image newImgError = imgError.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	
		//Guardar
	public static final ImageIcon guardar= new ImageIcon("ficheros/imagenes/iconos/guardar.png");
	public static Image imgGuardar = JFrameOpciones.guardar.getImage();
	public static Image newImgGuardar = imgGuardar.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	
		//Volver
	public static final ImageIcon volver= new ImageIcon("ficheros/imagenes/iconos/volver.png");
	public static Image imgVolver = JFrameOpciones.volver.getImage();
	public static Image newImgVolver = imgVolver.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		//Perfil
	public static final ImageIcon perfil= new ImageIcon("ficheros/imagenes/iconos/perfil.png");
	public static Image imgperfil = JFrameOpciones.perfil.getImage();
	public static Image newimgPerfil = imgperfil.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		//Nuevo perfil
	public static final ImageIcon nuevoUsu= new ImageIcon("ficheros/imagenes/iconos/nuevoUsuario.png");
	public static Image imgNuevoUsu = JFrameOpciones.nuevoUsu.getImage();
	public static Image newimgNuevoUsu = imgNuevoUsu.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//Llave Contraseña
	public static final ImageIcon llave= new ImageIcon("ficheros/imagenes/iconos/llave.png");
	public static Image imgLlave = JFrameOpciones.llave.getImage();
	public static Image newimgLlave = imgLlave.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		//Correo
	public static final ImageIcon correo= new ImageIcon("ficheros/imagenes/iconos/correo.png");
	public static Image imgCorreo = JFrameOpciones.correo.getImage();
	public static Image newimgCorreo = imgCorreo.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	
		//Nombre juego
	public static final ImageIcon nJuegos= new ImageIcon("ficheros/imagenes/iconos/nombre-juego.png");
	public static Image imgNjuegos = JFrameOpciones.nJuegos.getImage();
	public static Image newimgNJuegos = imgNjuegos.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
	
		//Edad
	public static final ImageIcon resEdad= new ImageIcon("ficheros/imagenes/iconos/res-edad.png");
	public static Image imgResEdad = JFrameOpciones.resEdad.getImage();
	public static Image newimgResEdad = imgResEdad.getScaledInstance(23, 23, Image.SCALE_SMOOTH);

		//Numero de ventas
	public static final ImageIcon nVentas= new ImageIcon("ficheros/imagenes/iconos/n-ventas.png");
	public static Image imgNVentas = JFrameOpciones.nVentas.getImage();
	public static Image newimgNVentas = imgNVentas.getScaledInstance(25, 25, Image.SCALE_SMOOTH);

		//Numero de ventas
	public static final ImageIcon cJuegos= new ImageIcon("ficheros/imagenes/iconos/c-juegos.png");
	public static Image imgcJuegos = JFrameOpciones.cJuegos.getImage();
	public static Image newimgcJuegos = imgcJuegos.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	//Valores almacenado a la hora de cambiar de JFrame
	public static String nombre, usuario;
	
	// letras
	public static Font letra=new Font("Tahoma", Font.PLAIN, 13);

	
}
