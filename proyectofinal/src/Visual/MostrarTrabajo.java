package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Trabajo;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class MostrarTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Trabajo trabajo;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	private JButton btnOK;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JComboBox boxFiltro;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			MostrarTrabajo dialog = new MostrarTrabajo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarTrabajo(ArrayList<Trabajo> prioridad) {
		setTitle("Trabajos");
		setBounds(100, 100, 705, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Código","Título","Propietario","Calificación"};
					model.setColumnIdentifiers(columnas);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int rowselected=-1;
							rowselected=table.getSelectedRow();
							if(rowselected>=0) {
								btnEliminar.setEnabled(true);
								trabajo = EventoCiencia.getInstance().buscatrabajo(table.getValueAt(rowselected, 0).toString());
							}
						}
					});
					scrollPane.setViewportView(table);
					
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOK = new JButton("Okay");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.setEnabled(false);
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int opcion;
							if(trabajo!=null) {
								opcion= JOptionPane.showConfirmDialog(null, "Estas Seguro de querer eliminar el trabajo cod: "+trabajo.getCodigo(),
										"Confirmacion", JOptionPane.YES_NO_OPTION);
								if(opcion == JOptionPane.OK_OPTION) {
										EventoCiencia.getInstance().eliminarTrabajo(trabajo);
										cargardatos(prioridad);	
								}
							}
							btnEliminar.setEnabled(false);
						}
					});
					{
						lblNewLabel = new JLabel("Filtrar por:");
						buttonPane.add(lblNewLabel);
					}
					{
						boxFiltro = new JComboBox();
						boxFiltro.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cargardatos(prioridad);
							}
						});
						boxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "F\u00EDsica", "Biolog\u00EDa", "Qu\u00EDmica", "Astronom\u00EDa", "Tecnolog\u00EDa", "Matem\u00E1tica"}));
						buttonPane.add(boxFiltro);
					}
					buttonPane.add(btnEliminar);
				}
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
		}
		cargardatos(prioridad);
	}
	
	public void cargardatos(ArrayList<Trabajo> prioridad) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];

		if(prioridad == null)
		{
			for (int i=0 ; i<EventoCiencia.getInstance().getComisiones().size();i++) {
				for (int j = 0; j <EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size(); j++) {
					if(EventoCiencia.getInstance().getComisiones().get(i).getArea().equals(boxFiltro.getSelectedItem().toString()) || boxFiltro.getSelectedItem().toString().equals("Todos")) {
						rows[0] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j).getCodigo();
						rows[1] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j).gettitulo();
						rows[2] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j).getPropietario().getNombre();
						rows[3] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j).getCalificacion();
						model.addRow(rows);
					}
				}	
			}
		}
		else
		{
			for (Trabajo trab : prioridad) {
				if(filtrartrabajo(trab)) {
					rows[0] = trab.getCodigo();
					rows[1] = trab.gettitulo();
					rows[2] = trab.getPropietario().getNombre();
					rows[3] = trab.getCalificacion();
					model.addRow(rows);
				}
				
			}
		}
		
	}
	
	public boolean filtrartrabajo(Trabajo trabajo) {
		boolean filtrado=false;
		for (int i=0 ; i<EventoCiencia.getInstance().getComisiones().size() && filtrado!=true;i++) {
			for (int j = 0; j <EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size() && filtrado!=true; j++) {
				if(EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j).equals(trabajo)) {
					if(EventoCiencia.getInstance().getComisiones().get(i).getArea().equals(boxFiltro.getSelectedItem().toString()) || boxFiltro.getSelectedItem().toString().equals("Todos")) {
						filtrado=true;
					}
				}	
			}
		}	
		return filtrado;
	}

}
