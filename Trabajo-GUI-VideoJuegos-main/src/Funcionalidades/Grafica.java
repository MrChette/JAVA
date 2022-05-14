package Funcionalidades;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Funcionalidades.Grafica;

public class Grafica extends javax.swing.JFrame {
	
	JFreeChart grafico_circular;
	JFreeChart grafico_barras;
	ChartPanel panelGraficaCirc, panelGraficaBarr;
	JRadioButton Graf_cir, Graf_barr;
	JButton boton;
	DefaultCategoryDataset Datos = new DefaultCategoryDataset();
	DefaultPieDataset datos = new DefaultPieDataset();
	ArrayList<PerfilJuego> juegos;
	JPanel contentPane, panelGrafs;
	JPanel[] panelCharts = new JPanel[2];
	SpringLayout posComp;
	BufferedImage img;
	CategoryPlot plot;
	PiePlot3D plot2;

	public Grafica() throws IOException {
		setTitle("Grafico");
		setBounds(100, 100, 460, 550);
		setLocationRelativeTo(null);
		setIconImage(JFrameOpciones.logo.getImage());
		setVisible(true);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		posComp = new SpringLayout();
		contentPane.setLayout(posComp);
		ManejadorEventos escuchador = new ManejadorEventos();
		contentPane.setBackground(JFrameOpciones.fondo);

		// Crear y posicionar los radio button
		Graf_cir = new JRadioButton("Grafico circular", true);
		Graf_barr = new JRadioButton("Grafico de barras", false);
		Graf_cir.setBackground(JFrameOpciones.fondo);
		Graf_barr.setBackground(JFrameOpciones.fondo);
		posComp.putConstraint(SpringLayout.NORTH, Graf_cir, 10, SpringLayout.NORTH, contentPane);
		posComp.putConstraint(SpringLayout.WEST, Graf_cir, 105, SpringLayout.WEST, contentPane);
		posComp.putConstraint(SpringLayout.SOUTH, Graf_cir, -475, SpringLayout.SOUTH, contentPane);

		posComp.putConstraint(SpringLayout.NORTH, Graf_barr, 10, SpringLayout.NORTH, contentPane);
		posComp.putConstraint(SpringLayout.WEST, Graf_barr, 255, SpringLayout.WEST, contentPane);
		posComp.putConstraint(SpringLayout.SOUTH, Graf_barr, -475, SpringLayout.SOUTH, contentPane);
		ButtonGroup tipoGraf = new ButtonGroup();
		tipoGraf.add(Graf_cir);
		tipoGraf.add(Graf_barr);
		Graf_cir.addActionListener(escuchador);
		Graf_barr.addActionListener(escuchador);
		contentPane.add(Graf_cir);
		contentPane.add(Graf_barr);

		generarGraficoBarras();
		generarGraficoCircular();
		posComp.putConstraint(SpringLayout.NORTH, panelGrafs, 105, SpringLayout.NORTH, contentPane);
		posComp.putConstraint(SpringLayout.WEST, panelGrafs, 5, SpringLayout.WEST, contentPane);
		posComp.putConstraint(SpringLayout.EAST, panelGrafs, -5, SpringLayout.EAST, contentPane);
		posComp.putConstraint(SpringLayout.SOUTH, panelGrafs, -5, SpringLayout.SOUTH, contentPane);
		contentPane.add(panelGrafs);

	}

	private class ManejadorEventos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Elimina el panel actual y lo remplaza por el seleccionado
			if (Graf_cir.isSelected()) {
				getContentPane().remove(panelGrafs);
				panelGrafs = panelCharts[1];
				posComp.putConstraint(SpringLayout.NORTH, panelGrafs, 105, SpringLayout.NORTH, contentPane);
				posComp.putConstraint(SpringLayout.WEST, panelGrafs, 5, SpringLayout.WEST, contentPane);
				posComp.putConstraint(SpringLayout.EAST, panelGrafs, -5, SpringLayout.EAST, contentPane);
				posComp.putConstraint(SpringLayout.SOUTH, panelGrafs, -5, SpringLayout.SOUTH, contentPane);
				getContentPane().add(panelGrafs);
				// Reposicionar grafica
				setSize(459, 549);
				setSize(460, 550);
				// Refrescar ui
				repaint();
			} else if (Graf_barr.isSelected()) {
				getContentPane().remove(panelGrafs);
				panelGrafs = panelCharts[0];
				posComp.putConstraint(SpringLayout.NORTH, panelGrafs, 105, SpringLayout.NORTH, contentPane);
				posComp.putConstraint(SpringLayout.WEST, panelGrafs, 5, SpringLayout.WEST, contentPane);
				posComp.putConstraint(SpringLayout.EAST, panelGrafs, -5, SpringLayout.EAST, contentPane);
				posComp.putConstraint(SpringLayout.SOUTH, panelGrafs, -5, SpringLayout.SOUTH, contentPane);
				getContentPane().add(panelGrafs);
				setSize(459, 549);
				setSize(460, 550);
				repaint();
			}
		}
	}

	// Obtener los juegos del fichero
	public void binToArray() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			juegos = new ArrayList<>();
			File games = new File("ficheros/games");
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(games));
			PerfilJuego juegox = (PerfilJuego) is.readObject();
			try {
				while (juegox != null) {
					juegos.add(juegox);
					juegox = (PerfilJuego) is.readObject();
				}
			} catch (Exception ex) {
			}
			is.close();
		} catch (java.io.FileNotFoundException e) {

		}
	}

	public void generarGraficoBarras() {
		try {
			binToArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < juegos.size(); i++) {
			Datos.setValue(juegos.get(i).getnVentas(), juegos.get(i).getNombre(), "Juegos");

		}
		grafico_barras = ChartFactory.createBarChart("Juegos mas vendidos", "Juegos", "Ventas", Datos);
		grafico_barras.setBackgroundPaint(JFrameOpciones.fondo2);
		plot = (CategoryPlot) grafico_barras.getPlot();
		plot.setRangeGridlinePaint(Color.black);
		plot.setBackgroundPaint(Color.white);
		panelGraficaBarr = new ChartPanel(grafico_barras);
		panelGraficaBarr.setSize(400, 400);
		panelCharts[0] = panelGraficaBarr;

	}

	public void generarGraficoCircular() {

		try {
			binToArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < juegos.size(); i++) {
			datos.setValue(juegos.get(i).getNombre(), juegos.get(i).getnVentas());
		}
		// Genera el grafico
		grafico_circular = ChartFactory.createPieChart3D("Juegos mas vendidos", datos, true, true, true);
		grafico_circular.setBackgroundPaint(JFrameOpciones.fondo2);
		// Cambia el fondo de la grafica
		plot2 = (PiePlot3D) grafico_circular.getPlot();
		plot2.setBackgroundPaint(Color.white);
		panelGraficaCirc = new ChartPanel(grafico_circular);
		panelGraficaCirc.setSize(400, 400);
		panelCharts[1] = panelGraficaCirc;
		// Añade la grafica al panel
		panelGrafs = panelGraficaCirc;

	}
}