package Menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Funcionalidades.FuncioUsuario;
import Funcionalidades.JFrameOpciones;
import Funcionalidades.PerfilUsuario;

public class RegistrarUsuario extends JFrame {


	private JTextField txNombre, txCorreo;
	private JPasswordField txContra;
	private JLabel lNombre, lContra, lCorreo, lGuardar, lVolver, lNuevoUsu, lPerfil, lLave, lgmail;
	private JButton bSalir, bRegistrar, bMostrarContra;
	private ImageIcon icoMostrar, icoOcultar, icoError, icoGuardar, icoVolver, icoNuevoUsu, icoPerfil, icollave,
			icoCorreo;

	public RegistrarUsuario() {

		// Opciones de JFrame
		setTitle("Registrar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(JFrameOpciones.logo.getImage());
		this.getContentPane().setBackground(JFrameOpciones.fondo);

		// Agregar imagenes

		icoMostrar = new ImageIcon(JFrameOpciones.newimg);
		icoOcultar = new ImageIcon(JFrameOpciones.newImgOcultar);
		icoError = new ImageIcon(JFrameOpciones.newImgError);
		icoGuardar = new ImageIcon(JFrameOpciones.newImgGuardar);
		icoVolver = new ImageIcon(JFrameOpciones.newImgVolver);
		icoPerfil = new ImageIcon(JFrameOpciones.newimgPerfil);
		icoNuevoUsu = new ImageIcon(JFrameOpciones.newimgNuevoUsu);
		icollave = new ImageIcon(JFrameOpciones.newimgLlave);
		icoCorreo = new ImageIcon(JFrameOpciones.newimgCorreo);

		// Introducir las etiquitas

		lNuevoUsu = new JLabel("");
		lNuevoUsu.setBounds(200, 5, 50, 50);
		lNuevoUsu.setIcon(icoNuevoUsu);
		add(lNuevoUsu);

		lNombre = new JLabel("Nombre:");
		lNombre.setFont(JFrameOpciones.letra);
		lNombre.setBounds(87, 65, 60, 23);
		add(lNombre);

		lPerfil = new JLabel("");
		lPerfil.setBounds(301, 61, 24, 24);
		lPerfil.setIcon(icoPerfil);
		add(lPerfil);

		lContra = new JLabel("Contraseña:");
		lContra.setFont(JFrameOpciones.letra);
		lContra.setBounds(70, 96, 70, 26);
		add(lContra);

		lLave = new JLabel("");
		lLave.setBounds(336, 100, 20, 20);
		lLave.setIcon(icollave);
		add(lLave);

		lCorreo = new JLabel("Correo electronico:");
		lCorreo.setFont(JFrameOpciones.letra);
		lCorreo.setBounds(30, 131, 130, 28);
		add(lCorreo);

		lgmail = new JLabel("");
		lgmail.setBounds(345, 134, 24, 24);
		lgmail.setIcon(icoCorreo);
		add(lgmail);

		lGuardar = new JLabel("");
		lGuardar.setIcon(icoGuardar);
		lGuardar.setBounds(186, 205, 25, 25);
		add(lGuardar);

		lVolver = new JLabel("");
		lVolver.setIcon(icoVolver);
		lVolver.setBounds(303, 205, 25, 25);
		add(lVolver);

		// Introducimos los cuadrados de texto
		txNombre = new JTextField("");
		txNombre.setBounds(158, 62, 138, 25);
		txNombre.setColumns(10);
		add(txNombre);

		txContra = new JPasswordField("");
		txContra.setEchoChar('*');
		txContra.setColumns(10);
		txContra.setBounds(158, 97, 138, 25);
		add(txContra);

		txCorreo = new JTextField("");
		txCorreo.setColumns(10);
		txCorreo.setBounds(158, 133, 180, 25);
		add(txCorreo);

		// Agregar los botnoes
		bSalir = new JButton("SALIR");
		bSalir.setBackground(JFrameOpciones.bordeBoton);
		bSalir.setBounds(234, 206, 68, 23);
		add(bSalir);

		bRegistrar = new JButton("GUARDAR");
		bRegistrar.setBounds(100, 206, 86, 23);
		bRegistrar.setBackground(JFrameOpciones.bordeBoton);

		add(bRegistrar);

		bMostrarContra = new JButton();
		bMostrarContra.setBounds(300, 97, 26, 26);
		bMostrarContra.setIcon(icoMostrar);
		bMostrarContra.setOpaque(false);
		bMostrarContra.setContentAreaFilled(false);
		bMostrarContra.setBorderPainted(false);
		add(bMostrarContra);

		BotonFuncio Funcionalidad = new BotonFuncio();
		bSalir.addActionListener(Funcionalidad);
		bRegistrar.addActionListener(Funcionalidad);
		bMostrarContra.addActionListener(Funcionalidad);

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
			} else if (evento.getActionCommand().equals("GUARDAR")) {

				// Comprobar si existe ese usuario
				boolean existe = true;
				try {

					existe = FuncioUsuario.ComprobarUsu(txNombre.getText());

				} catch (IOException e1) {

					e1.printStackTrace();
				}
				boolean bNombreNulo = txNombre.getText().equals("");

				if (bNombreNulo) {
					JOptionPane.showMessageDialog(RegistrarUsuario.this, "Usuario VACIO", "USUARIO",
							JOptionPane.ERROR_MESSAGE);

					txNombre.setBackground(Color.pink);
				} else if (existe) {

					Object[] opciones = { "INICIAR SESION", "CANCELAR" };
					int op = JOptionPane.showOptionDialog(RegistrarUsuario.this, "¿Deseas iniciar sesion?",
							"Usuario existente", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							icoError, opciones, opciones[1]);
					if (op == 0) {
						setVisible(false);
						JFrameOpciones.nombre = txNombre.getText();
						new Inicio();

					}

					txNombre.setBackground(Color.pink);

				} else
					txNombre.setBackground(Color.green);

				// Comprobar contraseña

				String valiContra = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
						+ "(?=\\S+$).{8,20}$";
				boolean bValiContra = txContra.getText().matches(valiContra);

				if (!bValiContra && !existe && txNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(RegistrarUsuario.this, "Contraseña ERRONEA", "CONTRASEÑA",
							JOptionPane.ERROR_MESSAGE);

					txContra.setBackground(Color.PINK);
				} else
					txContra.setBackground(Color.GREEN);

				// Comprobar correo

				String valiCorreo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

				boolean bValiCorreo = txCorreo.getText().matches(valiCorreo);

				if (!bValiCorreo && !existe && txNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(RegistrarUsuario.this, "Correo ERRONEO", "CORREO",
							JOptionPane.ERROR_MESSAGE);
					txCorreo.setBackground(Color.PINK);
				} else
					txCorreo.setBackground(Color.green);

				// Registrar

				if (bValiCorreo && bValiContra && !existe && !bNombreNulo) {

					Object[] opciones = { "ACEPTAR", "CANCELAR" };
					int op = JOptionPane.showOptionDialog(RegistrarUsuario.this,
							"¿Seguro que deseas registrar usuario?", "Registrar usuario",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icoError, opciones,
							opciones[1]);
					if (op == 0) {
						PerfilUsuario usu = new PerfilUsuario(txNombre.getText(), txContra.getText(),
								txCorreo.getText());
						try {
							FuncioUsuario.EscribirUsuario(usu);
						} catch (IOException e) {
							e.printStackTrace();
						}

						JOptionPane.showMessageDialog(RegistrarUsuario.this, "Usuario registrado");
						JFrameOpciones.usuario = txNombre.getText();
						try {
							MenuJuegos.start();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						setVisible(false);
					}

				}
			}

			// Salir

			else if (evento.getActionCommand().equalsIgnoreCase("SALIR")) {
				setVisible(false);
				new Inicio();
			}
		}
	}
}