package Menus;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Funcionalidades.FileWriter;
import Funcionalidades.Grafica;
import Funcionalidades.JFrameOpciones;
import Funcionalidades.PerfilJuego;

public class MenuJuegos extends JFrame {

	
	private JPanel contentPane;
	private static JTable tablaJuegos;
	private String[] columnas;
	public static JLabel lbimg;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnGrafica;
	private JButton btnVolver;
	public static List<PerfilJuego> juego;
	private JButton btnBorrar;
	private static File games = new File("ficheros/games");
	private DefaultTableModel tablemodel;
	private static ObjectInputStream is;
	public static String resEdad;
	public static String fechaSalida;
	public static String dir;
	public static String nombre;
	public static String ventas;
	public static int posicion;
	public static String usuario;

	public static void start() throws FileNotFoundException, ClassNotFoundException, IOException {
		if (games.exists())
			binToArray();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJuegos frame = new MenuJuegos();
					frame.setIconImage(JFrameOpciones.logo.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuJuegos() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {

		}
		setTitle("Menu Juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(JFrameOpciones.fondo);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		// Crear panel para la imagen
		lbimg = new JLabel();
		lbimg.setToolTipText("IMAGEN");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbimg, 24, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbimg, -197, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbimg, -22, SpringLayout.EAST, contentPane);
		lbimg.setHorizontalAlignment(SwingConstants.CENTER);
		Border blackline = BorderFactory.createLineBorder(JFrameOpciones.bordeBoton);
		lbimg.setBorder(blackline);
		contentPane.add(lbimg);

		// Crear el JTable
		columnas = new String[] { "Nombre", "Pegi", "Fecha de Salida", "Nº ventas", "Dir", "Creador" };
		tablemodel = new DefaultTableModel(columnas, 0);
		setTablaJuegos(new JTable(tablemodel));
		getTablaJuegos().setPreferredScrollableViewportSize(new Dimension(250, 100));	
		getTablaJuegos().getTableHeader().setReorderingAllowed(false);

		// Hacer invisible la columna del directorio de imagen
		getTablaJuegos().getColumnModel().getColumn(4).setMaxWidth(0);
		getTablaJuegos().getColumnModel().getColumn(4).setMinWidth(0);
		getTablaJuegos().getColumnModel().getColumn(4).setPreferredWidth(0);

		// Crear el scrollPanel
		scrollPane = new JScrollPane(getTablaJuegos());
		sl_contentPane.putConstraint(SpringLayout.WEST, lbimg, 22, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -134, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -23, SpringLayout.SOUTH, contentPane);
		contentPane.add(scrollPane);

		scrollPane.getViewport().setBackground(JFrameOpciones.fondo2);
		scrollPane.setBorder(blackline);

		// Crear y posicionar botones
		btnAgregar = new JButton("Agregar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAgregar, 18, SpringLayout.SOUTH, lbimg);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAgregar, 0, SpringLayout.WEST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAgregar, 0, SpringLayout.EAST, lbimg);
		btnAgregar.setBackground(JFrameOpciones.bordeBoton);
		contentPane.add(btnAgregar);

		btnGrafica = new JButton("Gráfico");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGrafica, 0, SpringLayout.WEST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGrafica, 0, SpringLayout.EAST, lbimg);
		btnGrafica.setBackground(JFrameOpciones.bordeBoton);
		contentPane.add(btnGrafica);

		btnBorrar = new JButton("Borrar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAgregar, -35, SpringLayout.NORTH, btnBorrar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBorrar, 76, SpringLayout.SOUTH, lbimg);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBorrar, 0, SpringLayout.WEST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBorrar, 0, SpringLayout.EAST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGrafica, 6, SpringLayout.SOUTH, btnBorrar);
		btnBorrar.setBackground(JFrameOpciones.bordeBoton);
		contentPane.add(btnBorrar);

		btnVolver = new JButton("Volver");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVolver, 0, SpringLayout.WEST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVolver, 0, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVolver, -22, SpringLayout.EAST, contentPane);
		btnVolver.setBackground(JFrameOpciones.bordeBoton);
		contentPane.add(btnVolver);

		JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 6, SpringLayout.SOUTH, btnAgregar);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 0, SpringLayout.WEST, lbimg);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 0, SpringLayout.EAST, lbimg);
		btnModificar.setBackground(JFrameOpciones.bordeBoton);
		contentPane.add(btnModificar);

		// Pasamos el array al JTable
		try {
			for (int i = 0; i < juego.size(); i++) {
				String nombre = juego.get(i).getNombre();
				String pegi = juego.get(i).getResEdad();
				String fecha = juego.get(i).getFechaSalida();
				int numVentas = juego.get(i).getnVentas();
				String link = juego.get(i).getDirImg().replace(" ", "");
				String creador = juego.get(i).getUsuario();

				Object[] data = { nombre, pegi, fecha, numVentas, link, creador };
				tablemodel.addRow(data);
			}
		} catch (java.lang.NullPointerException e) {
		}

		ManejadorVolver mnjvolver = new ManejadorVolver();
		btnVolver.addActionListener(mnjvolver);

		ManejadorAgregar mnjagregar = new ManejadorAgregar();
		btnAgregar.addActionListener(mnjagregar);

		ManejadorBorrar mnjborrar = new ManejadorBorrar();
		btnBorrar.addActionListener(mnjborrar);

		ManejadorModificar mnjmodificar = new ManejadorModificar();
		btnModificar.addActionListener(mnjmodificar);

		ManejadorEventos escuchador = new ManejadorEventos();
		btnGrafica.addActionListener(escuchador);

		ManejadorImagen mnjImg = new ManejadorImagen();
		getTablaJuegos().getSelectionModel().addListSelectionListener(mnjImg);

	}

	// Creamos los manejadores de evento
	public class ManejadorAgregar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			creacionJuego.start();
		}
	}

	// Agregar imagen a la libreria
	public class ManejadorImagen implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 4) != null) {
				Image img = new ImageIcon(getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 4).toString())
						.getImage();
				Image newimg = img.getScaledInstance(90, 130, java.awt.Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(newimg);
				lbimg.setIcon(imageIcon);
			}

		}
	}

	// Modificador los datos de JTable
	public class ManejadorModificar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (getTablaJuegos().getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				usuario = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 5).toString();
				if (usuario.equals(JFrameOpciones.usuario)) {
					Modificador.start();
					posicion = getTablaJuegos().getSelectedRow();
					nombre = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 0).toString();
					resEdad = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 1).toString();
					fechaSalida = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 2).toString();
					ventas = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 3).toString();
					dir = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 4).toString();
					usuario = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 5).toString();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "No eres el dueño de este juego", "",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		}

	}

	// Borrar datos de JTable
	public class ManejadorBorrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			usuario = getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 5).toString();
			if (usuario.equals(JFrameOpciones.usuario)) {
				int i = getTablaJuegos().getSelectedRow();
				if (i >= 0) {
					juego.remove(i);
					try {
						arraytoBin();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					setVisible(false);
					File img = new File(getTablaJuegos().getValueAt(getTablaJuegos().getSelectedRow(), 4).toString());;
					img.delete();
					try {
						start();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ninguna Tabla Seleccionada");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No eres el dueño de este juego", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Volver al inicio
	private class ManejadorVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Inicio();
		}
	}

	// Abrir la grafica
	private class ManejadorEventos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btnGrafica) {
				try {
					new Grafica();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	// Pasar el archivo games binario a arraylist
	public static void binToArray() throws FileNotFoundException, IOException, ClassNotFoundException {
		juego = new ArrayList<>();
		is = new ObjectInputStream(new FileInputStream("ficheros/games"));
		PerfilJuego juegox = (PerfilJuego) is.readObject();
		try {
			while (juegox != null) {
				juego.add(juegox);
				juegox = (PerfilJuego) is.readObject();
			}
		} catch (Exception e) {
		}
		is.close();
	}

	// Volcar datos de array a fichero para actualizar
	public static void arraytoBin() throws IOException {
		File games = new File("ficheros/games");
		games.delete();
		for (PerfilJuego pf : juego) {
			String nombre = pf.getNombre();
			String resEdad = pf.getResEdad();
			String fechaSalida = pf.getFechaSalida();
			int nVentas = pf.getnVentas();
			String dirImg = pf.getDirImg();
			String usuario = pf.getUsuario();
			// System.out.println(nombre);
			FileWriter.abrir(games);
			FileWriter.agregar(nombre, resEdad, fechaSalida, nVentas, dirImg, usuario);
			FileWriter.cerrar();
		}
	}

	public static JTable getTablaJuegos() {
		return tablaJuegos;
	}

	public void setTablaJuegos(JTable tablaJuegos) {
		this.tablaJuegos = tablaJuegos;
	}
}