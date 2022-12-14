package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Comision;
import Logico.Evento;
import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Recurso;
import Logico.Trabajo;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;

public class Calificar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodjurado;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JButton btnCancelar;
	
	private Jurado jurado;
	private Comision comision;
	private	Evento 	evento;
	private Trabajo	trabajo;
	
	private static Object[] rows;
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private static DefaultTableModel model3;
	private JButton btnCalificar;
	private JSpinner spnCalificacion;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			Calificar dialog = new Calificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Calificar() {
		
		jurado = null;
		comision = null;
		evento = null;
		trabajo = null;
		setTitle("Calificar trabajo");
		setBounds(100, 100, 489, 507);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel paneljurado = new JPanel();
		paneljurado.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneljurado.setBounds(12, 13, 447, 80);
		contentPanel.add(paneljurado);
		paneljurado.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo de jurado:");
		lblNewLabel.setBounds(12, 13, 114, 16);
		paneljurado.add(lblNewLabel);
		
		txtCodjurado = new JTextField();
		txtCodjurado.setBounds(125, 10, 135, 22);
		paneljurado.add(txtCodjurado);
		txtCodjurado.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jurado = EventoCiencia.getInstance().buscarJurado(txtCodjurado.getText());
				if(jurado == null)
				{
					JOptionPane.showMessageDialog(null, "Jurado no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					comision = null;
					evento = null;
					trabajo = null;
					clear();
					cargardatos();
				}
					
				else
				{
					JOptionPane.showMessageDialog(null, "Jurado encontrado con ?xito!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					txtNombre.setText(jurado.getNombre());
					comision = null;
					evento = null;
					trabajo = null;
					clear();
					cargardatos();
				}
					
			}
		});
		btnBuscar.setBounds(301, 9, 97, 25);
		paneljurado.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de jurado:");
		lblNewLabel_1.setBounds(12, 48, 114, 16);
		paneljurado.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(125, 45, 169, 22);
		paneljurado.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 91, 447, 162);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Eventos permitidos");
		lblNewLabel_2.setBounds(49, 13, 119, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Comisiones permitidas");
		lblNewLabel_3.setBounds(270, 13, 138, 16);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 41, 192, 110);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		model1 = new DefaultTableModel();
		String[] columnas = {"C?digo","Nombre"};
		model1.setColumnIdentifiers(columnas);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowSelected = -1;
				rowSelected = table.getSelectedRow();
				if(rowSelected>=0){
				   evento = EventoCiencia.getInstance().buscarevento(table.getValueAt(rowSelected, 0).toString());
				   cargardatos();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(243, 42, 192, 110);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		model2 = new DefaultTableModel();
		String[] columnas2 = {"C?digo","?rea"};
		model2.setColumnIdentifiers(columnas2);
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowSelected = -1;
				rowSelected = table_1.getSelectedRow();
				if(rowSelected>=0){
				   comision = EventoCiencia.getInstance().buscacomision(table_1.getValueAt(rowSelected, 0).toString());
				   cargardatos();
				}
			}
		});
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 248, 447, 168);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Trabajos");
		lblNewLabel_4.setBounds(96, 13, 65, 16);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 40, 232, 115);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		model3 = new DefaultTableModel();
		String[] columnas1 = {"C?digo","T?tulo","Propietario"};
		model3.setColumnIdentifiers(columnas1);
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowSelected = -1;
				rowSelected = table_2.getSelectedRow();
				if(rowSelected>=0){
				   btnCalificar.setEnabled(true);
				   trabajo = EventoCiencia.getInstance().buscatrabajo(table_2.getValueAt(rowSelected, 0).toString());
				}
			}
		});
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(model3);
		
		spnCalificacion = new JSpinner();
		spnCalificacion.setModel(new SpinnerNumberModel(new Float(0), null, new Float(10), new Float(1)));
		spnCalificacion.setBounds(310, 69, 83, 22);
		panel_1.add(spnCalificacion);
		
		btnCalificar = new JButton("Calificar");
		btnCalificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Float.parseFloat(spnCalificacion.getValue().toString()) != 0)
				{
					if(!trabajo.verificarcalificacion(jurado)) {
						trabajo.calificadopor(jurado);
						EventoCiencia.getInstance().evaluartrabajo(trabajo.getCodigo(), Float.parseFloat(spnCalificacion.getValue().toString()));
						JOptionPane.showMessageDialog(null, "Calificaci?n registrada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						spnCalificacion.setValue(Float.valueOf(0));
					}else {
						JOptionPane.showMessageDialog(null, "Este jurado ya ha calificado este trabajo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Calificaci?n debe ser mayor de 0", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCalificar.setEnabled(false);
		btnCalificar.setBounds(299, 104, 105, 25);
		panel_1.add(btnCalificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargardatos();
	}
	
	public void cargardatos() {
		
		if(jurado != null)
			cargardatoevento();
		if(evento != null)
			cargardatocomision();
		if(comision != null)
			cargardatotrabajo();
			
	}
	
	public void cargardatoevento() {
		model1.setRowCount(0);
		rows = new Object[model1.getColumnCount()];
		
		for (Evento event : EventoCiencia.getInstance().eventosdejurado(jurado.getCodjurado())) {
			rows[0] = event.getCodigo();
			rows[1] = event.getNombre();
			
			model1.addRow(rows);
		}
	}
	
	public void cargardatocomision() {
		model2.setRowCount(0);
		rows = new Object[model2.getColumnCount()];
		
		for (Comision comi : EventoCiencia.getInstance().comisiondejurado(jurado.getCodjurado(), evento)) {
			rows[0] = comi.getCodigo();
			rows[1] = comi.getArea();
			
			model2.addRow(rows);
		}	
	}
	
	public void cargardatotrabajo() {
		model3.setRowCount(0);
		rows = new Object[model3.getColumnCount()];
		for (Trabajo trab : comision.getTrabajos()) {
			rows[0] = trab.getCodigo();
			rows[1] = trab.gettitulo();
			rows[2] = trab.getPropietario().getNombre();
			
			model3.addRow(rows);
		}	
	}
	
	public void clear() {	
		model3.setRowCount(0);
		model2.setRowCount(0);
	}
}
