package Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Funcionalidades.FuncioUsuario;
import Funcionalidades.JFrameOpciones;

public class Inicio extends JFrame {


	
	private JTextField txNombre;
	private JLabel lbPortada, lbnombre, lbcontra, lperfil, lLlave;
	private JPasswordField txContra;
	private JButton btEntrar, btRegistrar,bMostrarContra;
	private ImageIcon icoperfil,icollave,icoMostrar,icoOcultar;

	public Inicio() {
		try {
		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e){
			
		}
		
		setTitle("Gestor de videojuegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 249);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setIconImage(JFrameOpciones.logo.getImage());
		setResizable(false);
		this.getContentPane().setBackground(JFrameOpciones.fondo);
		
		// Agregar imagenes
		
		icoperfil = new ImageIcon(JFrameOpciones.newimgPerfil);
		icollave = new ImageIcon(JFrameOpciones.newimgLlave);
		icoMostrar=new ImageIcon(JFrameOpciones.newimg);
		icoOcultar=new ImageIcon(JFrameOpciones.newImgOcultar);
		
		
		// Introducir las etiquitas
		lbPortada = new JLabel("Bienvenido al gestor de videojuegos");
		lbPortada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPortada.setBounds(50, 11, 292, 43);
		add(lbPortada);
		
		lbnombre = new JLabel("Nombre:");
		lbnombre.setFont(JFrameOpciones.letra);
		lbnombre.setBounds(88, 75, 54, 14);
		add(lbnombre);
		
		lperfil = new JLabel("");
		lperfil.setIcon(icoperfil);
		lperfil.setBounds(284, 70, 24, 24);
		add(lperfil);
		
		lbcontra = new JLabel("Contraseña:");
		lbcontra.setFont(JFrameOpciones.letra);
		lbcontra.setBounds(72, 106, 70, 14);
		add(lbcontra);
		
		lLlave = new JLabel("");
		lLlave.setIcon(icollave);
		lLlave.setBounds(312, 103, 20, 20);
		add(lLlave);

		
		// Introducimos los cuadrados de texto
		txNombre = new JTextField(JFrameOpciones.nombre, 20);
		txNombre.setBounds(152, 72, 128, 20);
		add(txNombre);
		
		txContra = new JPasswordField("", 20);
		
		txContra.setColumns(10); 
		txContra.setBounds(152, 103, 128, 20);
		txContra.setEchoChar('*');
		add(txContra);
	
		// Agregar los botnoes
		BotonFuncio Funcionalida = new BotonFuncio();
		btEntrar = new JButton("Entrar");
		btEntrar.setBackground(JFrameOpciones.bordeBoton);
		btEntrar.setBounds(72, 167, 89, 23);
		btEntrar.addActionListener(Funcionalida);
		
		add(btEntrar);
		
		btRegistrar = new JButton("Registrar");
		btRegistrar.setBackground(JFrameOpciones.bordeBoton);
		btRegistrar.setBounds(193, 167, 89, 23);
		btRegistrar.addActionListener(Funcionalida);

		add(btRegistrar);
		
		bMostrarContra = new JButton();
		bMostrarContra.setBounds(283, 100, 26, 26);
		bMostrarContra.setIcon(icoMostrar);
		bMostrarContra.setOpaque(false);
		bMostrarContra.setContentAreaFilled(false);
		bMostrarContra.setBorderPainted(false);
		bMostrarContra.addActionListener(Funcionalida);
		
		add(bMostrarContra);
		

		// Hacemos visible
		
		setVisible(true);
	}

	private class BotonFuncio implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent evento) {
			
			if (evento.getSource().equals(bMostrarContra)) {
			
				// Mostrar contra
				if (bMostrarContra.getIcon() == icoMostrar) {
					txContra.setEchoChar((char) 0);
					bMostrarContra.setIcon(icoOcultar);
					// Ocultar contra
				} else if (bMostrarContra.getIcon() == icoOcultar) {
					txContra.setEchoChar('*');
					bMostrarContra.setIcon(icoMostrar);
				}
			} else if (evento.getActionCommand().equalsIgnoreCase("Entrar")) {
				
				// Comprobar usuario y contraseña, almacenarla en
				
				boolean usuBoolean = false, contraBoolean = false;
				
				try {
					
					usuBoolean = FuncioUsuario.ComprobarUsu(txNombre.getText());
					contraBoolean = FuncioUsuario.ComprobarContra(txNombre.getText(), txContra.getText());

				} catch (IOException e) {
					e.printStackTrace();
				}

				// Comprobar usuario
				if (!usuBoolean) {
					JOptionPane.showMessageDialog(Inicio.this, "¡Usuario incorrecto!", "ERROR USUARIO",
							JOptionPane.ERROR_MESSAGE);
					txNombre.setBackground(Color.pink);
				} else
					txNombre.setBackground(Color.green);

				// Comprobar contraseña
				if (!contraBoolean) {
					JOptionPane.showMessageDialog(Inicio.this, "¡Contraseña incorrecta!", "ERROR USUARIO",
							JOptionPane.ERROR_MESSAGE);
					txContra.setBackground(Color.pink);
				} else
					txContra.setBackground(Color.green);

				// Salir de inicio
				if (usuBoolean && contraBoolean) {
					setVisible(false);
					
					try {
						MenuJuegos.start();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					JFrameOpciones.usuario=txNombre.getText();
				}

			} else if (evento.getActionCommand().equalsIgnoreCase("Registrar")) {
				setVisible(false);
				new RegistrarUsuario();
			}
		}
	}

}