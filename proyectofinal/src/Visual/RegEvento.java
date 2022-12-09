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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.BevelBorder;
import javax.swing.SpinnerNumberModel;

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
	
	private JSpinner.DateEditor formato;
	private JSpinner.DateEditor formato2;
	private JSpinner.DateEditor formato3;
	private JSpinner.DateEditor formato4;
	
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
	private JButton btnEliminar;
	private JSpinner spnHorainicio;
	private JSpinner spnHorafin;
	private JSpinner spnCant1;
	private JSpinner spnCant2;

	/**
	 * Launch the application.
	 *//*
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
		panel.setBounds(12, 13, 609, 152);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(12, 17, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(12, 50, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cupo:");
		lblNewLabel_2.setBounds(290, 17, 56, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ubicaci\u00F3n:");
		lblNewLabel_3.setBounds(290, 50, 71, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de inicio:");
		lblNewLabel_4.setBounds(12, 83, 99, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de conclusi\u00F3n:");
		lblNewLabel_5.setBounds(290, 83, 128, 16);
		panel.add(lblNewLabel_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(71, 15, 116, 22);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setText("Event-"+EventoCiencia.getInstance().getCodevento());
		
		txtNombre = new JTextField();
		txtNombre.setBounds(71, 48, 187, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		spnCupo = new JSpinner();
		spnCupo.setBounds(353, 15, 61, 22);
		panel.add(spnCupo);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setBounds(353, 48, 244, 22);
		panel.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		
		spnFechaInicio = new JSpinner(new SpinnerDateModel());
		formato = new JSpinner.DateEditor(spnFechaInicio, "dd/MM/yyyy");
		spnFechaInicio.setEditor(formato);
		spnFechaInicio.setValue(new Date());
		spnFechaInicio.setBounds(106, 81, 140, 22);
		panel.add(spnFechaInicio);
		
		
		spnFechaFin = new JSpinner(new SpinnerDateModel());
		formato2 = new JSpinner.DateEditor(spnFechaFin, "dd/MM/yyyy");
		spnFechaFin.setEditor(formato2);
		spnFechaFin.setValue(new Date());
		spnFechaFin.setBounds(414, 81, 140, 22);
		panel.add(spnFechaFin);
		
		JLabel lblNewLabel_11 = new JLabel("Hora de inicio:");
		lblNewLabel_11.setBounds(12, 116, 99, 16);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Hora de cierre:");
		lblNewLabel_12.setBounds(290, 116, 112, 16);
		panel.add(lblNewLabel_12);
		
		spnHorainicio = new JSpinner(new SpinnerDateModel(new Date(1670561607769L), null, null, Calendar.DAY_OF_MONTH));
		formato3 = new JSpinner.DateEditor(spnHorainicio, "HH:mm");
		spnHorainicio.setEditor(formato3);
		spnHorainicio.setValue(new Date());
		spnHorainicio.setBounds(106, 114, 77, 20);
		panel.add(spnHorainicio);
		
		spnHorafin = new JSpinner(new SpinnerDateModel());
		formato4 = new JSpinner.DateEditor(spnHorafin, "HH:mm");
		spnHorafin.setEditor(formato4);
		spnHorafin.setValue(new Date());
		spnHorafin.setBounds(414, 114, 77, 22);
		panel.add(spnHorafin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 165, 609, 221);
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
				int j = 0,i = 0;
				
				while(j < Integer.parseInt(spnCant1.getValue().toString()))
				{
					if(disponible.get(i).getTipo().equals(rec1.getTipo()))
						if(disponible.get(i).getDescripcion().equals(rec1.getDescripcion()))
							if(disponible.get(i).getUbicacion().equals(rec1.getUbicacion()))
							{
								agregados.add(disponible.get(i));
								eliminardisponible(disponible.get(i));
								j++;
							}
					i++;
				}
				btnDerecha.setEnabled(false);
				cargardatos();
				spnCant1.setValue(Integer.valueOf(0));
			}
		});
		btnDerecha.setBounds(268, 62, 85, 25);
		panel_1.add(btnDerecha);
		
		btnIsquierda = new JButton("<<");
		btnIsquierda.setEnabled(false);
		btnIsquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = 0,i = 0;
				
				while(j < Integer.parseInt(spnCant2.getValue().toString()))
				{
					if(agregados.get(i).getTipo().equals(rec2.getTipo()))
						if(agregados.get(i).getDescripcion().equals(rec2.getDescripcion()))
							if(agregados.get(i).getUbicacion().equals(rec2.getUbicacion()))
							{
								disponible.add(agregados.get(i));
								eliminaragregado(agregados.get(i));
								j++;
							}
					i++;
				}
				btnIsquierda.setEnabled(false);
				cargardatos();	
				spnCant2.setValue(Integer.valueOf(0));
			}
		});
		btnIsquierda.setBounds(268, 122, 85, 25);
		panel_1.add(btnIsquierda);
		
		spnCant1 = new JSpinner();
		spnCant1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCant1.setBounds(123, 194, 59, 22);
		panel_1.add(spnCant1);
		
		spnCant2 = new JSpinner();
		spnCant2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCant2.setBounds(464, 194, 59, 22);
		panel_1.add(spnCant2);
		
		JLabel lblNewLabel_13 = new JLabel("Cantidad:");
		lblNewLabel_13.setBounds(64, 197, 65, 16);
		panel_1.add(lblNewLabel_13);
		
		JLabel label = new JLabel("Cantidad:");
		label.setBounds(405, 197, 65, 16);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 385, 609, 200);
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
				cargardatos();
			}
		});
		btnAgregarComision.setBounds(68, 55, 97, 25);
		panel_2.add(btnAgregarComision);
		
		JLabel lblNewLabel_10 = new JLabel("Seleccionados:");
		lblNewLabel_10.setBounds(366, 10, 97, 16);
		panel_2.add(lblNewLabel_10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(68, 125, 97, 25);
		panel_2.add(btnEliminar);
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
						EventoCiencia.getInstance().getcomisionesaux().clear();
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
		model3.setRowCount(0);
		
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
		
		rows = new Object[model3.getColumnCount()];
		//Comisiones seleccionadas
		for(Comision com : EventoCiencia.getInstance().getcomisionesaux()) 
		{
			rows[0] = com.getCodigo();
			rows[1] = com.getArea();
			rows[2] = com.getPresidente().getNombre();
			
			model3.addRow(rows);	

		}
		
	}
	
	public void agregarevento(){
		
		//Fecha tipo date
		Date algo1 = (Date)spnFechaInicio.getValue();
		Date cosa = (Date)spnHorainicio.getValue();
		algo1.setHours(cosa.getHours());
		algo1.setMinutes(cosa.getMinutes());
		
		Date algo2 = (Date)spnFechaFin.getValue();
		cosa = (Date)spnHorafin.getValue();
		algo2.setHours(cosa.getHours());
		algo2.setMinutes(cosa.getMinutes());
		
		
		if(algo1.after(new Date()))
		{
			if(algo2.after(algo1))
			{
				if(!(txtNombre.getText().equals("")))
				{
					if(!(txtUbicacion.getText().equals("")))
					{
						if(EventoCiencia.getInstance().getcomisionesaux().size() != 0)
						{
							if(Integer.parseInt(spnCupo.getValue().toString()) > 0)
							{
								Evento aux = new Evento(txtNombre.getText(), txtCodigo.getText(), txtUbicacion.getText()
										, algo1, algo2, Integer.parseInt(spnCupo.getValue().toString()));
								aux.setComisiones(EventoCiencia.getInstance().getcomisionesaux());
								aux.setRecursos(agregados);
								EventoCiencia.getInstance().agregarevento(aux);
								JOptionPane.showMessageDialog(null, "Evento creado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								
								//guardar las comisiones en la comision genral
								for(Comision com : EventoCiencia.getInstance().getcomisionesaux()) 
								{
									EventoCiencia.getInstance().agregarcomisiones(com);
								}
								clear();
							}
							else
								JOptionPane.showMessageDialog(null, "El cupo debe ser mayor que 0", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						}
						else
							JOptionPane.showMessageDialog(null, "Escoja al menos una comisión!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Debe colocar una ubicación!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Debe colocar un nombre!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				
			}
			else
				JOptionPane.showMessageDialog(null, "Fecha final no puede ser menor o igual que la inicial", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Fecha de inicio no puede ser menor que la fecha actual", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	public void clear(){
		txtCodigo.setText("Event-"+EventoCiencia.getInstance().getCodevento());
		txtNombre.setText("");
		txtUbicacion.setText("");
		
		agregados.clear();
		EventoCiencia.getInstance().getcomisionesaux().clear();
		spnCupo.setValue(Integer.valueOf(0));
		cargardatos();
		spnFechaInicio.setValue(new Date());
		spnFechaFin.setValue(new Date());
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
