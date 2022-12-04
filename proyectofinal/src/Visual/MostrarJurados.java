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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MostrarJurados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnmodificar;
	private JButton btncomisiones;
	private JButton btneliminar;
	private JButton btncancelar;
	private static DefaultTableModel modeltable;
	private static Object[] rows;
	private Jurado juradoselect=null;
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			MostrarJurados dialog = new MostrarJurados(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarJurados(ArrayList<Jurado> prioridad) {
		/*Jurado jurado=new Jurado("qweqe", "Carmen clara", "52345234", "Jud-2", "Informatica");
		Jurado jurado2=new Jurado("qweqe", "CArlo hern", "52345234", "Jud-232", "Informatica");
		EventoCiencia.getInstance().agregarpersonas(jurado);
		EventoCiencia.getInstance().agregarpersonas(jurado2);*/
		setTitle("Mostrar Jurados");
		setBounds(100, 100, 583, 335);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 547, 241);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		modeltable= new DefaultTableModel();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowselected=-1;
				rowselected=table.getSelectedRow();
				if(rowselected>=0) {
					btneliminar.setEnabled(true);
					btnmodificar.setEnabled(true);
					btncomisiones.setEnabled(true);
					juradoselect=EventoCiencia.getInstance().buscarJurado(modeltable.getValueAt(rowselected, 0).toString());
				}
			}
		});
		String[] columna= {"Codigo","Cedula","Nombre","Telefono","Area especializada"};
		modeltable.setColumnIdentifiers(columna);
		table.setModel(modeltable);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnmodificar = new JButton("Modificar");
			btnmodificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegPersona regjur= new RegPersona(juradoselect);
					regjur.setModal(true);
					regjur.setVisible(true);
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btncomisiones.setEnabled(false);
				}
			});
			btnmodificar.setEnabled(false);
			buttonPane.add(btnmodificar);
			
			btncomisiones = new JButton("Comisiones");
			btncomisiones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//MostrarComision aux = new MostrarComision(prioridad);
				}
			});
			btncomisiones.setEnabled(false);
			buttonPane.add(btncomisiones);
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opcion;
						if(juradoselect!=null) {
							opcion= JOptionPane.showConfirmDialog(null, "Estas Seguro de querer eliminar al jurado con codigo:"+juradoselect.getCodjurado(),
									"Confirmacion", JOptionPane.YES_NO_OPTION);
							if(opcion == JOptionPane.OK_OPTION) {
								EventoCiencia.getInstance().eliminarjurado(juradoselect.getCodjurado());;
								loadjurados(prioridad);
							}
						}
						btneliminar.setEnabled(false);
						btnmodificar.setEnabled(false);
						btncomisiones.setEnabled(false);
					}
				});
				btneliminar.setEnabled(false);
				btneliminar.setActionCommand("OK");
				buttonPane.add(btneliminar);
				getRootPane().setDefaultButton(btneliminar);
			}
			{
				btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
				
			}
		}
		loadjurados(prioridad);
	}

	public static void loadjurados(ArrayList<Jurado> prioridad) {
		modeltable.setRowCount(0);
		rows = new Object[modeltable.getColumnCount()];
		
		if(prioridad == null)
		{
			for (int i = 0; i < EventoCiencia.getInstance().getPersonas().size(); i++) {
				if(EventoCiencia.getInstance().getPersonas().get(i) instanceof Jurado) {
					rows[0] = ((Jurado)EventoCiencia.getInstance().getPersonas().get(i)).getCodjurado();
					rows[1] = EventoCiencia.getInstance().getPersonas().get(i).getCedula();
					rows[2] = EventoCiencia.getInstance().getPersonas().get(i).getNombre();
					rows[3] = EventoCiencia.getInstance().getPersonas().get(i).getTelefono();
					rows[4] = ((Jurado)EventoCiencia.getInstance().getPersonas().get(i)).getAreaespecializado();
					modeltable.addRow(rows);
				}
			}
		}
		
		else
		{
			for (Jurado jurado : prioridad) {
						rows[0] = jurado.getCodjurado();
						rows[1] = jurado.getCedula();
						rows[2] = jurado.getNombre();
						rows[3] = jurado.getTelefono();
						rows[4] = jurado.getAreaespecializado();
						modeltable.addRow(rows);
			}
		}
		
	}
}