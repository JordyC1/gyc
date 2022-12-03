package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.EventoCiencia;
import Logico.Trabajo;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MostrarTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Trabajo trabajo;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
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
			for (Trabajo trab : EventoCiencia.getInstance().getTrabajos()) {
				rows[0] = trab.getCodigo();
				rows[1] = trab.gettitulo();
				rows[2] = trab.getPropietario().getNombre();
				rows[3] = trab.getCalificacion();
				model.addRow(rows);
				
			}
		}
		
		else
		{
			for (Trabajo trab : prioridad) {
				rows[0] = trab.getCodigo();
				rows[1] = trab.gettitulo();
				rows[2] = trab.getPropietario().getNombre();
				rows[3] = trab.getCalificacion();
				model.addRow(rows);
				
			}
		}
		
	}

}
