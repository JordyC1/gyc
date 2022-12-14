package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.EventoCiencia;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\reino\\Downloads\\ciencias.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream feria;
				ObjectOutputStream feriaescribir;
				try {
					feria = new  FileOutputStream("feria.dat");
					feriaescribir = new ObjectOutputStream(feria);
					feriaescribir.writeObject(EventoCiencia.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		setTitle("Feria Cient\u00EDfica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 323);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-40);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Persona");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegPersona aux = new RegPersona(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mostrar jurados");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarJurados aux = new MostrarJurados(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Mostrar participantes");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarParticipante aux = new MostrarParticipante(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu = new JMenu("Recursos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegRecurso aux = new RegRecurso();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mostrar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarRecurso aux = new MostrarRecurso(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Comisiones");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarComision aux = new MostrarComision(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Eventos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegEvento aux = new RegEvento();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarEvento aux = new MostrarEvento();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("Proyectos");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegTrabajo aux = new RegTrabajo(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarTrabajo aux = new MostrarTrabajo(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_6 = new JMenu("Funciones");
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Calificar trabajo");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calificar aux = new Calificar();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_9 = new JMenu("Ver mejores trabajos");
		mnNewMenu_6.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Trabajos feria");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarMejoresproy aux=new MostrarMejoresproy(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Por eventos");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarInforme aux = new MostrarInforme(1);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_19);
		if(EventoCiencia.getInstance().getUser().getTipo().equals("Secretaria"))
			mnNewMenu_6.setEnabled(false);
		
		JMenu mnNewMenu_5 = new JMenu("Administraci\u00F3n");
		if(EventoCiencia.getInstance().getUser().getTipo().equals("Secretaria"))
			mnNewMenu_5.setEnabled(false);
		mnNewMenu_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Nuevo usuario");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario aux = new RegistroUsuario(0);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Mostrar usuarios");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarUsuarios aux = new MostrarUsuarios();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_7 = new JMenu("Informes");
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Informe Eventos");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarInforme aux = new MostrarInforme(2);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Informe Feria");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mostrarinfgeneral aux = new Mostrarinfgeneral();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_8 = new JMenu("Cuenta");
		menuBar.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Cambiar contrase\u00F1a");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroUsuario aux = new RegistroUsuario(1);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Cerrar sesi\u00F3n");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login aux = new Login();
				aux.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_14);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
	}

}
