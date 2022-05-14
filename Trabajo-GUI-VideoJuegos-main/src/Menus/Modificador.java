package Menus;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import Funcionalidades.JFrameOpciones;
import Funcionalidades.PerfilJuego;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Modificador {

	private JFrame frame;
	private JTextField jtnewName;
	private JTextField jtnewVentas;
	private JLabel lblNewLabel;
	private String extension;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificador window = new Modificador();
					window.frame.setVisible(true);
					window.frame.setIconImage(JFrameOpciones.logo.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Modificador() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {

		}
		frame = new JFrame();
		frame.getContentPane().setBackground(JFrameOpciones.fondo);
		frame.setTitle("Modificador");
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel lblnewname = new JLabel("Nuevo Nombre");
		springLayout.putConstraint(SpringLayout.NORTH, lblnewname, 36, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblnewname, 24, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblnewname);

		jtnewName = new JTextField(MenuJuegos.nombre);
		springLayout.putConstraint(SpringLayout.NORTH, jtnewName, -3, SpringLayout.NORTH, lblnewname);
		springLayout.putConstraint(SpringLayout.WEST, jtnewName, 25, SpringLayout.EAST, lblnewname);
		frame.getContentPane().add(jtnewName);
		jtnewName.setColumns(10);

		JLabel lblNuevoPegi = new JLabel("Nuevo Pegi");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevoPegi, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNuevoPegi, 41, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNuevoPegi, 0, SpringLayout.EAST, lblnewname);
		frame.getContentPane().add(lblNuevoPegi);

		jtnewVentas = new JTextField(MenuJuegos.ventas);
		springLayout.putConstraint(SpringLayout.NORTH, jtnewVentas, 124, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, jtnewVentas, 0, SpringLayout.WEST, jtnewName);
		jtnewVentas.setColumns(10);
		frame.getContentPane().add(jtnewVentas);

		// 3, 7, 12, 16, 18
		String[] pegi = { "+3", "+7", "+12", "+16", "+18" };
		comboBox = new JComboBox(pegi);
		comboBox.setSelectedIndex(4);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblNuevoPegi);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, jtnewName);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -68, SpringLayout.EAST, frame.getContentPane());
		comboBox.setSelectedItem(MenuJuegos.resEdad.toString());
		frame.getContentPane().add(comboBox);

		lblNewLabel = new JLabel("Nuevas Ventas");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNuevoPegi, -28, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, jtnewVentas);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblnewname);
		frame.getContentPane().add(lblNewLabel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(JFrameOpciones.bordeBoton);
		springLayout.putConstraint(SpringLayout.NORTH, btnAceptar, 21, SpringLayout.SOUTH, jtnewVentas);
		springLayout.putConstraint(SpringLayout.EAST, btnAceptar, -80, SpringLayout.EAST, frame.getContentPane());
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnAceptar);

		ManejadorAceptar mnjAceptar = new ManejadorAceptar();
		btnAceptar.addActionListener(mnjAceptar);

	}

	public class ManejadorAceptar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String name = jtnewName.getText().toString();

			if(jtnewVentas.getText().equals("")) {
				jtnewVentas.setText("0");
			}
			int nVentas = Integer.parseInt(jtnewVentas.getText().toString());
			String pegi = comboBox.getSelectedItem().toString();
			
			
			//Cambiando el nombre de la imagen al nuevo nombre del juego
			File directorio = new File(MenuJuegos.dir.toString());
			if (directorio.exists())
				extension = (MenuJuegos.dir.toString().substring(MenuJuegos.dir.toString().lastIndexOf('.')));
			
			File nameImg = new File("ficheros/Imagenes/" + MenuJuegos.nombre.replace(" " , "") + extension);
			File newName = new File("ficheros/Imagenes/" + name.replace(" ", "") + extension);
			nameImg.renameTo(newName);
			
			//Cambiando los datos del juego dentro del ArrayList
			
			MenuJuegos.juego.set(MenuJuegos.posicion,
					new PerfilJuego(name, pegi, MenuJuegos.fechaSalida, nVentas, newName.toString(),MenuJuegos.usuario));
			try {
				MenuJuegos.arraytoBin();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(false);
			try {
				MenuJuegos.start();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			

			
				
		}

	}
}
