import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Test {
	private JFrame frame;
	// private JButton botones;
	int premiobase = 1;
	private JButton[] botones;
	private ArrayList<Integer> winners;
	private int[] premios = {10,200,500,10000,50000};
	private int nPremio=0;
	static int numBt = 9;
	private int perdedor;
	private int contador;
	private int premiototal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Juego");
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel(new GridLayout(3, 3));
		frame.add(panel1, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		frame.add(panel2, BorderLayout.SOUTH);

		botones = new JButton[numBt];
		// Generando botones
		ManejadorJuego mjuego = new ManejadorJuego();
		for (int i = 0; i < numBt; i++) {
			botones[i] = new JButton(String.valueOf(i));
			botones[i].setEnabled(false);
			panel1.add(botones[i]);
			botones[i].addActionListener(mjuego);
		}

		JButton jugar = new JButton("Jugar");
		panel2.add(jugar);

		ManejadorJugar mJugar = new ManejadorJugar();
		jugar.addActionListener(mJugar);

		frame.setVisible(true);

	}

	public class ManejadorJugar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			premiototal = 0;
			nPremio = 0;
			System.out.println(nPremio);
			for (int i = 0; i < numBt; i++) {
				botones[i].setEnabled(true);
			}
			contador = 0;
			juego();
		}
	}

	public class ManejadorJuego implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			botones[Integer.parseInt(e.getActionCommand())].setEnabled(false);
			if (contador <= 2) {
				if (winners.contains(Integer.parseInt(e.getActionCommand()))) {
					premiototal += premios[nPremio];
					JOptionPane.showMessageDialog(null, "Ganador, sumas ->" + premios[nPremio] + "    " + premiototal);
					nPremio++;
				}
				if ((Integer.parseInt(e.getActionCommand())) == perdedor) {
					JOptionPane.showMessageDialog(null, "Perdiste, no ganas nada");
					premiototal = 0;
					System.exit(0);	
				}
			}
			if(contador == 2) {
				JOptionPane.showMessageDialog(null,"Felicidades, has ganado " + premiototal);
				for (int i = 0; i < numBt; i++) {
				}
			}
			contador++;
		}
	}

	private void juego() {
		// Generando numeros ganadores
		System.out.println("Num wins -> " + premios.length);
		winners = new ArrayList<>();
		for (int i = 0; i < premios.length; i++) {
			int random = (int) (Math.random() * numBt);
			if (!winners.contains(random))
				winners.add(random);
			else
				i--;
		}

		// Generando perdedor
		perdedor = (int) (Math.random() * numBt);
		while (winners.contains(perdedor))
			perdedor = (int) (Math.random() * numBt);
		System.out.println("Num Perdedor ->" + perdedor);

		// Comprobante por consola
		for (Integer i : winners)
			System.out.println(i);
	}

}
