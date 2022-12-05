package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Evento;
import Logico.EventoCiencia;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarInforme extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnseleccionar;
	private Evento event;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			MostrarEvento dialog = new MostrarEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarInforme() {
		setTitle("Eventos");
		setBounds(100, 100, 803, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Código","Título","Ubicación","Fecha de inicio","Fecha fin","Cupo"};
					model.setColumnIdentifiers(columnas);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected>=0){
							   btnseleccionar.setEnabled(true);
							   event = EventoCiencia.getInstance().buscarevento(table.getValueAt(rowSelected, 0).toString());
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
				btnseleccionar = new JButton("Seleccionar");
				btnseleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MostrarInfEvento auxEvento= new MostrarInfEvento(event);
						auxEvento.setModal(true);
						auxEvento.setVisible(true);
					}
				});
				btnseleccionar.setEnabled(false);
				btnseleccionar.setActionCommand("OK");
				buttonPane.add(btnseleccionar);
				getRootPane().setDefaultButton(btnseleccionar);
			}
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
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		for (int i = 0; i < EventoCiencia.getInstance().getEventos().size(); i++) {
		  
			rows[0] = EventoCiencia.getInstance().getEventos().get(i).getCodigo();
			rows[1] = EventoCiencia.getInstance().getEventos().get(i).getNombre();
			rows[2] = EventoCiencia.getInstance().getEventos().get(i).getUbicacion();
			rows[3] = EventoCiencia.getInstance().getEventos().get(i).getFechainicio().toString();
			rows[4] = EventoCiencia.getInstance().getEventos().get(i).getFechafinal().toString();
			rows[5] = EventoCiencia.getInstance().getEventos().get(i).getCupo();
		   
		   model.addRow(rows);
		}
	}

}