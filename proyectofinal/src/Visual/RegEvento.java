package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Comision;
import Logico.Evento;
import Logico.EventoCiencia;
import Logico.Recurso;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class RegEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtUbicacion;
	private JSpinner spnCupo;
	private JSpinner spnFechaInicio;
	private JSpinner spnFechaFin;
	private JTable tabledisponible;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	private static DefaultTableModel model2;
	private static DefaultTableModel model3;
	
	private ArrayList<Recurso> disponible;
	private ArrayList<Recurso> agregados;
	private ArrayList<Comision> comisionesagregadas;
	
	private JTable tableagregados;
	private JButton btnAgregarComision;
	private JTable tablaComisiones;
	private JButton btnIsquierda;
	private JButton btnDerecha;
	
	private Recurso rec1;
	private Recurso rec2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEvento dialog = new RegEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEvento() {
		disponible = new ArrayList<>();
		agregados = new ArrayList<>();
		disponible.addAll(EventoCiencia.getInstance().getRecursos());
		
		setTitle("Agregar evento");
		setBounds(100, 100, 651, 671);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 13, 609, 148);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(12, 13, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(12, 58, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cupo:");
		lblNewLabel_2.setBounds(290, 13, 56, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ubicaci\u00F3n:");
		lblNewLabel_3.setBounds(290, 58, 71, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de inicio:");
		lblNewLabel_4.setBounds(12, 98, 99, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de conclusi\u00F3n:");
		lblNewLabel_5.setBounds(290, 98, 128, 16);
		panel.add(lblNewLabel_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(71, 10, 116, 22);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setText("Event-"+EventoCiencia.getInstance().getCodevento());
		
		txtNombre = new JTextField();
		txtNombre.setBounds(71, 55, 187, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		spnCupo = new JSpinner();
		spnCupo.setBounds(353, 10, 61, 22);
		panel.add(spnCupo);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setBounds(353, 55, 244, 22);
		panel.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		spnFechaInicio = new JSpinner();
		spnFechaInicio.setModel(new SpinnerDateModel(new Date(1669089600000L), null, null, Calendar.DAY_OF_YEAR));
		spnFechaInicio.setBounds(106, 95, 140, 22);
		panel.add(spnFechaInicio);
		
		spnFechaFin = new JSpinner();
		spnFechaFin.setModel(new SpinnerDateModel(new Date(1669089600000L), null, null, Calendar.DAY_OF_YEAR));
		spnFechaFin.setBounds(414, 95, 140, 22);
		panel.add(spnFechaFin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 165, 609, 200);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Recursos:");
		lblNewLabel_6.setBounds(3, 0, 71, 16);
		panel_1.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 29, 210, 162);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel();
		String[] columnas = {"Código","Tipo"};
		model.setColumnIdentifiers(columnas);
		tabledisponible = new JTable();
		tabledisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowSelected = -1;
				rowSelected = tabledisponible.getSelectedRow();
				if(rowSelected>=0){
					btnDerecha.setEnabled(true);
					rec1 = EventoCiencia.getInstance().buscarrecurso(tabledisponible.getValueAt(rowSelected, 0).toString());
				}
			}
		});
		scrollPane.setViewportView(tabledisponible);
		tabledisponible.setModel(model);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(372, 29, 210, 162);
		panel_1.add(scrollPane_1);
		
		model2 = new DefaultTableModel();
		//String[] columnas1 = {"Código","Tipo"};
		model2.setColumnIdentifiers(columnas);
		tableagregados = new JTable();
		tableagregados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowSelected = -1;
				rowSelected = tableagregados.getSelectedRow();
				if(rowSelected>=0){
					btnIsquierda.setEnabled(true);
					rec2 = EventoCiencia.getInstance().buscarrecurso(tableagregados.getValueAt(rowSelected, 0).toString());
				}
			}
		});
		scrollPane_1.setViewportView(tableagregados);
		tableagregados.setModel(model2);
		
		JLabel lblNewLabel_7 = new JLabel("Disponibles:");
		lblNewLabel_7.setBounds(104, 13, 84, 16);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Agregados:");
		lblNewLabel_8.setBounds(435, 13, 84, 16);
		panel_1.add(lblNewLabel_8);
		
		btnDerecha = new JButton(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregados.add(rec1);
				eliminardisponible(rec1);
				btnDerecha.setEnabled(false);
				cargardatos();
				
			}
		});
		btnDerecha.setBounds(268, 62, 85, 25);
		panel_1.add(btnDerecha);
		
		btnIsquierda = new JButton("<<");
		btnIsquierda.setEnabled(false);
		btnIsquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disponible.add(rec2);
				eliminaragregado(rec2);
				btnIsquierda.setEnabled(false);
				cargardatos();		
			}
		});
		btnIsquierda.setBounds(268, 122, 85, 25);
		panel_1.add(btnIsquierda);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 378, 609, 200);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Comisiones:");
		lblNewLabel_9.setBounds(3, 0, 80, 16);
		panel_2.add(lblNewLabel_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(247, 29, 334, 158);
		panel_2.add(scrollPane_2);
		
		model3 = new DefaultTableModel();
		String[] columnas1 = {"Código","Área","Presidente"};
		model3.setColumnIdentifiers(columnas1);
		tablaComisiones = new JTable();
		scrollPane_2.setViewportView(tablaComisiones);
		tablaComisiones.setModel(model3);
		
		btnAgregarComision = new JButton("Agregar");
		btnAgregarComision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegComision aux = new RegComision();
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		btnAgregarComision.setBounds(80, 90, 97, 25);
		panel_2.add(btnAgregarComision);
		
		JLabel lblNewLabel_10 = new JLabel("Seleccionados:");
		lblNewLabel_10.setBounds(366, 10, 97, 16);
		panel_2.add(lblNewLabel_10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						agregarevento();
					}
				});
				btnAgregar.setActionCommand("OK");
				buttonPane.add(btnAgregar);
				getRootPane().setDefaultButton(btnAgregar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargardatos();
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cargardatos() {
		model.setRowCount(0);
		model2.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		//Recurso disponibles
		for (Recurso rec : disponible) {
			if(rec.getdisponible() == true)
			{
				rows[0] = rec.getCodigo();
				rows[1] = rec.getTipo();
				model.addRow(rows);	
			}
			
		}
		
		//Recurso seleccionado
		for (Recurso rec : agregados) {
			rows[0] = rec.getCodigo();
			rows[1] = rec.getTipo();
			model2.addRow(rows);	
		}
		
	}
	
	public void agregarevento(){
		
		if(!(txtNombre.getText().equals("")))
		{
			if(!(txtUbicacion.getText().equals("")))
			{
				Evento aux = new Evento(txtNombre.getText(), txtCodigo.getText(), txtUbicacion.getText()
						, spnFechaInicio.getValue().toString(), spnFechaFin.getValue().toString(), 
						Integer.parseInt(spnCupo.getValue().toString()));
				//aux.setComisiones(comisiones);
				aux.setRecursos(agregados);
				EventoCiencia.getInstance().agregarevento(aux);
				JOptionPane.showMessageDialog(null, "Evento creado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				clear();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe colocar una ubicación!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Debe colocar un nombre!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	public void clear(){
		txtCodigo.setText("Event-"+EventoCiencia.getInstance().getCodevento());
		txtNombre.setText("");
		txtUbicacion.setText("");
		
		agregados.clear();
		spnCupo.setValue(Integer.valueOf(0));
		cargardatos();
		//spnFechaInicio.setValue(value);
		//spnFechaFin.setValue(value);
	}
	
	public int inddisponible(Recurso rec) {
		int i = 0;
		boolean encontrado = false;
		
		while(i < disponible.size() && encontrado == false) {
			if(disponible.get(i).getCodigo().equals(rec.getCodigo()))
			{
				encontrado = true;
			}
			i++;
		}
		
		return i-1;
	}
	
	public void eliminardisponible(Recurso rec) {
		int ind = inddisponible(rec);
		disponible.remove(ind);
	}
	
	public int indagregado(Recurso rec) {
		int i = 0;
		boolean encontrado = false;
		
		while(i < agregados.size() && encontrado == false) {
			if(agregados.get(i).getCodigo().equals(rec.getCodigo()))
			{
				encontrado = true;
			}
			i++;
		}
		
		return i-1;
	}
	
	public void eliminaragregado(Recurso rec) {
		int ind = indagregado(rec);
		
		agregados.remove(ind);
	}
	
}
