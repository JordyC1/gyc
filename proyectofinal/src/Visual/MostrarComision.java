package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Comision;
import Logico.EventoCiencia;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton btnEliminar;
	private JTable table;
	private Comision comi;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	private JButton btnTrabajos;
	private JButton btnJurados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarComision dialog = new MostrarComision(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarComision(ArrayList<Comision> prioridad) {
		setTitle("Comisiones");
		setBounds(100, 100, 691, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
					String[] columnas = {"Código","Área","Presidente","Cantidad de jurados","Cantidad de trabajos"};
					model.setColumnIdentifiers(columnas);
					
					table = new JTable();
					scrollPane.setViewportView(table);
					
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnJurados = new JButton("Jurados");
				btnJurados.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MostrarJurados aux = new MostrarJurados();
						aux.setModal(true);
						aux.setVisible(true);
					}
				});
				buttonPane.add(btnJurados);
			}
			{
				btnTrabajos = new JButton("Trabajos");
				buttonPane.add(btnTrabajos);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("btnCancelar");
				buttonPane.add(cancelButton);
			}
		}
		
		cargardatos(prioridad);
	}
	
	public void cargardatos(ArrayList<Comision> prioridad) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		if(prioridad == null)
		{	
			System.out.println(EventoCiencia.getInstance().getComisiones().size());
			for (int i = 0; i < EventoCiencia.getInstance().getComisiones().size(); i++) {
			  
				rows[0] = EventoCiencia.getInstance().getComisiones().get(i).getCodigo();
				rows[1] = EventoCiencia.getInstance().getComisiones().get(i).getArea();
				rows[2] = EventoCiencia.getInstance().getComisiones().get(i).getPresidente().getNombre();
				rows[3] = EventoCiencia.getInstance().getComisiones().get(i).getJurados().size();
				rows[4] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size();
			   
			   model.addRow(rows);
			}
		}
		
		else
		{
			for (Comision comision : prioridad) {
				rows[0] = comision.getCodigo();
				rows[1] = comision.getArea();
				rows[2] = comision.getPresidente().getNombre();
				rows[3] = comision.getJurados().size();
				rows[4] = comision.getTrabajos().size();
				model.addRow(rows);
			}
		}
		
	}

}
