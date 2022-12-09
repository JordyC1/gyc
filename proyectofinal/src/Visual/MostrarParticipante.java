package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Participante;

public class MostrarParticipante extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnmodificar;
	private JButton btnproyecto;
	private JButton btneliminar;
	private JButton btncancelar;
	private static DefaultTableModel modeltable;
	private static Object[] rows;
	private Participante participanteselect=null;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public MostrarParticipante(ArrayList<Participante> prioridad) {
		setTitle("Mostrar Participantes");
		setBounds(100, 100, 709, 335);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
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
					btnproyecto.setEnabled(true);
					participanteselect=EventoCiencia.getInstance().buscaparticipante(modeltable.getValueAt(rowselected, 0).toString());
				}
			}
		});
		String[] columna= {"Código","Cédula","Nombre","Teléfono","Cantidad de proyectos"};
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
					RegPersona regjur= new RegPersona(participanteselect);
					regjur.setModal(true);
					regjur.setVisible(true);
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btnproyecto.setEnabled(false);
				}
			});
			btnmodificar.setEnabled(false);
			buttonPane.add(btnmodificar);
			
			btnproyecto = new JButton("Proyectos");
			btnproyecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MostrarTrabajo mostrarTrabajo= new MostrarTrabajo(participanteselect.getTrabajos());
					mostrarTrabajo.setModal(true);
					mostrarTrabajo.setVisible(true);
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btnproyecto.setEnabled(false);
				}
			});
			btnproyecto.setEnabled(false);
			buttonPane.add(btnproyecto);
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opcion;
						if(participanteselect!=null) {
							opcion= JOptionPane.showConfirmDialog(null, "Estas Seguro de querer eliminar al jurado con codigo:"+participanteselect.getCodparticipante(),
									"Confirmacion", JOptionPane.YES_NO_OPTION);
							if(opcion == JOptionPane.OK_OPTION) {
								if(participanteselect.getTrabajos().size()==0) {
								EventoCiencia.getInstance().eliminarparticipante(participanteselect.getCodparticipante());
								loadparticipantes(null);
								}else {
									JOptionPane.showMessageDialog(null, "No se puede borrar un participante con un trabajo registrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
						btneliminar.setEnabled(false);
						btnmodificar.setEnabled(false);
						btnproyecto.setEnabled(false);
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
		loadparticipantes(prioridad);
	}

	public static void loadparticipantes(ArrayList<Participante> prioridad) {
		modeltable.setRowCount(0);
		rows = new Object[modeltable.getColumnCount()];
		if(prioridad == null) {
			for (int i = 0; i < EventoCiencia.getInstance().getPersonas().size(); i++) {
				if(EventoCiencia.getInstance().getPersonas().get(i) instanceof Participante) {
					rows[0] = ((Participante)EventoCiencia.getInstance().getPersonas().get(i)).getCodparticipante();
					rows[1] = EventoCiencia.getInstance().getPersonas().get(i).getCedula();
					rows[2] = EventoCiencia.getInstance().getPersonas().get(i).getNombre();
					rows[3] = EventoCiencia.getInstance().getPersonas().get(i).getTelefono();
					rows[4] = ((Participante)EventoCiencia.getInstance().getPersonas().get(i)).getTrabajos().size();
					modeltable.addRow(rows);
				}
			}
		}else 
		{
			for (Participante participante : prioridad) {
				rows[0] = participante.getCodparticipante();
				rows[1] = participante.getCedula();
				rows[2] = participante.getNombre();
				rows[3] = participante.getTelefono();
				rows[4] = participante.getTrabajos().size();
				modeltable.addRow(rows);
			}
		}
	}
	
}
