package Menus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import Funcionalidades.FileWriter;
//import Funcionalidades.FuncionCreacionJuego;
import Funcionalidades.JFrameOpciones;
import Funcionalidades.PerfilJuego;
import javax.swing.JComboBox;

public class creacionJuego extends JFrame {

	private JPanel contentPane;
	JTextField jtNombre;
	private JTextField jtNumVentas;
	private JButton btnSelectImg;
	private JDateChooser dateChooser;
	private JButton btnAgregarGame;
	private JButton btnVolver;
	private JButton btnCerrar;
	private JComboBox comboBox;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private String extension;
	private File games = new File("ficheros/games");
	private Path sourcer;
	private Path destination;
	private ImageIcon icoNjuegos, icoEdad, icoNVentas, icoCJuegos;
	private JLabel lNjuego, lIcoEdad, lIcoNVentas, lIcoCarpeta;


	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creacionJuego frame = new creacionJuego();
					// Creamos JFrame
					frame.setTitle("Añadir Juego");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 450, 300);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setIconImage(JFrameOpciones.logo.getImage());
					frame.getContentPane().setBackground(JFrameOpciones.fondo);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public creacionJuego() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {

		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lNombre = new JLabel("Nombre");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lNombre, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lNombre, 136, SpringLayout.WEST, contentPane);
		lNombre.setFont(JFrameOpciones.letra);
		contentPane.add(lNombre);

		jtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, jtNombre, 214, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lNombre, -6, SpringLayout.WEST, jtNombre);
		sl_contentPane.putConstraint(SpringLayout.NORTH, jtNombre, -1, SpringLayout.NORTH, lNombre);
		contentPane.add(jtNombre);
		jtNombre.setColumns(10);

		JLabel lResEdad = new JLabel("Restricion de Edad");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lResEdad, 21, SpringLayout.SOUTH, lNombre);
		sl_contentPane.putConstraint(SpringLayout.WEST, lResEdad, 74, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lResEdad, -237, SpringLayout.EAST, contentPane);
		lResEdad.setFont(JFrameOpciones.letra);
		contentPane.add(lResEdad);

		JLabel lFechaSalida = new JLabel("Fecha de Salida");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lFechaSalida, 24, SpringLayout.SOUTH, lResEdad);
		sl_contentPane.putConstraint(SpringLayout.WEST, lFechaSalida, 90, SpringLayout.WEST, contentPane);
		lFechaSalida.setFont(JFrameOpciones.letra);
		contentPane.add(lFechaSalida);

		dateChooser = new JDateChooser();
		sl_contentPane.putConstraint(SpringLayout.WEST, dateChooser, 214, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, dateChooser, -88, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lFechaSalida, -26, SpringLayout.WEST, dateChooser);
		sl_contentPane.putConstraint(SpringLayout.NORTH, dateChooser, 0, SpringLayout.NORTH, lFechaSalida);
		((JTextField) this.dateChooser.getDateEditor()).setEditable(false);
		contentPane.add(dateChooser);

		JLabel lNumVentas = new JLabel("Numero de Ventas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lNumVentas, 24, SpringLayout.SOUTH, lFechaSalida);
		sl_contentPane.putConstraint(SpringLayout.WEST, lNumVentas, 0, SpringLayout.WEST, lResEdad);
		sl_contentPane.putConstraint(SpringLayout.EAST, lNumVentas, -237, SpringLayout.EAST, contentPane);
		lNumVentas.setFont(JFrameOpciones.letra);
		contentPane.add(lNumVentas);

		jtNumVentas = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, jtNumVentas, -1, SpringLayout.NORTH, lNumVentas);
		sl_contentPane.putConstraint(SpringLayout.WEST, jtNumVentas, 0, SpringLayout.WEST, jtNombre);
		sl_contentPane.putConstraint(SpringLayout.EAST, jtNumVentas, -131, SpringLayout.EAST, contentPane);
		contentPane.add(jtNumVentas);
		jtNumVentas.setColumns(10);

		btnAgregarGame = new JButton("Agregar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAgregarGame, 39, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAgregarGame, -12, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAgregarGame, -299, SpringLayout.EAST, contentPane);
		contentPane.add(btnAgregarGame);

		btnVolver = new JButton("Volver");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVolver, 52, SpringLayout.EAST, btnAgregarGame);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVolver, -12, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVolver, -175, SpringLayout.EAST, contentPane);
		contentPane.add(btnVolver);

		btnSelectImg = new JButton("Seleccionar Portada");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSelectImg, 135, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSelectImg, -14, SpringLayout.NORTH, btnVolver);
		btnSelectImg.setFont(JFrameOpciones.letra);
		contentPane.add(btnSelectImg);

		btnCerrar = new JButton("Cerrar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCerrar, -11, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCerrar, -38, SpringLayout.EAST, contentPane);
		contentPane.add(btnCerrar);

		btnAñadir btnAñadir = new btnAñadir();
		btnAgregarGame.addActionListener(btnAñadir);

		comprobarFechas cFecha = new comprobarFechas();
		jtNumVentas.addFocusListener(cFecha);

		añadirImg btnAddImg = new añadirImg();
		btnSelectImg.addActionListener(btnAddImg);

		ActVolver btnVolverr = new ActVolver();
		btnVolver.addActionListener(btnVolverr);

		ManejadorCerrar mnjCerrar = new ManejadorCerrar();
		btnCerrar.addActionListener(mnjCerrar);

		// Insertar imagenes
		icoNjuegos = new ImageIcon(JFrameOpciones.newimgNJuegos);
		icoNVentas = new ImageIcon(JFrameOpciones.newimgNVentas);
		icoEdad = new ImageIcon(JFrameOpciones.newimgResEdad);
		icoCJuegos = new ImageIcon(JFrameOpciones.newimgcJuegos);

		// JLabel Imagenes
		lNjuego = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lNjuego, 18, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lNjuego, 5, SpringLayout.EAST, jtNombre);
		lNjuego.setIcon(icoNjuegos);
		getContentPane().add(lNjuego);

		lIcoEdad = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lIcoEdad, 0, SpringLayout.SOUTH, lResEdad);
		sl_contentPane.putConstraint(SpringLayout.EAST, lIcoEdad, -118, SpringLayout.EAST, contentPane);
		lIcoEdad.setIcon(icoEdad);
		contentPane.add(lIcoEdad);

		lIcoNVentas = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lIcoNVentas, 16, SpringLayout.SOUTH, dateChooser);
		sl_contentPane.putConstraint(SpringLayout.WEST, lIcoNVentas, 8, SpringLayout.EAST, jtNumVentas);
		lIcoNVentas.setIcon(icoNVentas);
		contentPane.add(lIcoNVentas);

		lIcoCarpeta = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lIcoCarpeta, 0, SpringLayout.NORTH, btnSelectImg);
		sl_contentPane.putConstraint(SpringLayout.WEST, lIcoCarpeta, 6, SpringLayout.EAST, btnSelectImg);
		lIcoCarpeta.setIcon(icoCJuegos);
		contentPane.add(lIcoCarpeta);

		String[] peggi = { "+3", "+7", "+12", "+16", "+18" };
		comboBox = new JComboBox(peggi);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, -2, SpringLayout.NORTH, lResEdad);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, jtNombre);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, 20, SpringLayout.NORTH, lResEdad);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 61, SpringLayout.WEST, jtNombre);
		contentPane.add(comboBox);

		// Hacemos visible el jframe
		setVisible(true);

	}

	public class ManejadorCerrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

		}

	}

	public class ActVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			try {
				MenuJuegos.start();
			} catch (ClassNotFoundException | IOException e1) {

				e1.printStackTrace();
			}
		}

	}

	public class btnAñadir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(jtNumVentas.getText().equals("")) {
				jtNumVentas.setText("0");
			}
				
				
			try {
				if (getRepetido() == true && comprobarDatos() == true) {
					try {
						String nombre = jtNombre.getText();
						String resEdad = comboBox.getSelectedItem().toString();
						String date = sdf.format(dateChooser.getDate());
						int numVentas = Integer.parseInt(jtNumVentas.getText());
						String dirImg = "ficheros/Imagenes/" + jtNombre.getText() + extension;
						String usuario = JFrameOpciones.usuario;
						FileWriter.abrir(games);
						FileWriter.agregar(nombre, resEdad, date, numVentas, dirImg, usuario);
						FileWriter.cerrar();
						JOptionPane.showMessageDialog(creacionJuego.this, "El juego se ha insertado correctamente...",
								"", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						if(sourcer!=null) 
							Files.copy(sourcer, destination);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	// Comprobar si la fecha es posterior o anterior al dia de hoy , para activar o
	// desactivar casilla numero de Ventas
	public class comprobarFechas implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			if (dateChooser.getDate() != null) {
				Calendar today = Calendar.getInstance();
				Date hoy = today.getTime();
				Date fechaJuego = dateChooser.getDate();

				if (hoy.before(fechaJuego)) {
					jtNumVentas.setEditable(false);
					jtNumVentas.setText("No disponible");
				}

			}

		}

		@Override
		public void focusLost(FocusEvent e) {
			if (dateChooser.getDate() != null) {
				Calendar today = Calendar.getInstance();
				Date hoy = today.getTime();
				Date fechaJuego = dateChooser.getDate();
				if (hoy.before(fechaJuego)) {
					jtNumVentas.setEditable(true);
					jtNumVentas.setText("");
				}
			}
		}
	}

	// COMPROBAR INTRODUCCION DE DATOS

	public boolean comprobarDatos() {
		boolean comprobado = true;
		if (jtNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre del videojuego no puede estar vacio", "",
					JOptionPane.ERROR_MESSAGE);
			comprobado = false;
		}

		// Formatear el dateChooser a formato fecha dd-MM-yyyy
		@SuppressWarnings("unused")
		String date;
		if (dateChooser.getDate() != null) {
			date = sdf.format(dateChooser.getDate());
		} else {
			JOptionPane.showMessageDialog(null, "El campo fecha no puede estar vacio", "", JOptionPane.ERROR_MESSAGE);
			comprobado = false;
		}
		return comprobado;
	}

	// Comprobar repetidos
	public boolean getRepetido() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean testeado = true;
		if (games.exists()) {
			File file = new File("ficheros/games");
			FileReader fr = new FileReader(file);
			if (fr.read() > 0) {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(games));
				PerfilJuego juegox = (PerfilJuego) is.readObject();
				try {
					while (juegox != null) {
						if (juegox.getNombre().equals(jtNombre.getText()))
							testeado = false;
						juegox = (PerfilJuego) is.readObject();
					}
				} catch (Exception ex) {
				}
				is.close();
				fr.close();
				if (testeado == false)
					JOptionPane.showMessageDialog(null, "Este nombre ya se encuentra en la base de datos", "",
							JOptionPane.ERROR_MESSAGE);
			}
		}
		return testeado;
	}

	public class añadirImg implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png", "jpeg");
			fileChooser.setFileFilter(soloImg);
			fileChooser.showSaveDialog(null);

			if (fileChooser.getSelectedFile() != null) {
				extension = fileChooser.getSelectedFile().toString()
						.substring(fileChooser.getSelectedFile().toString().lastIndexOf('.'));
				File imagenes = new File("ficheros/Imagenes/" + jtNombre.getText().replace(" ", "") + extension);
				sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
				destination = imagenes.toPath();
				JOptionPane.showMessageDialog(null, "Imagen añadida" ,"", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}
