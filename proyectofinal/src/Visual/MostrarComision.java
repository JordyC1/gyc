package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Comision;
import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Trabajo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

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
	private JComboBox boxFiltro;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 *//*
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
		setLocationRelativeTo(null);
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
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected>=0){
							   btnEliminar.setEnabled(true);
							   btnJurados.setEnabled(true);
							   btnTrabajos.setEnabled(true);
							   comi = EventoCiencia.getInstance().buscacomision(table.getValueAt(rowSelected, 0).toString());
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnJurados = new JButton("Jurados");
				btnJurados.setEnabled(false);
				btnJurados.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MostrarJurados aux = new MostrarJurados(comi.getJurados());
						aux.setModal(true);
						aux.setVisible(true);
						btnJurados.setEnabled(false);
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
					boxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos","Física", "Biología", "Química", "Astronomía", "Tecnología","Matemática"}));
					buttonPane.add(boxFiltro);
				}
				buttonPane.add(btnJurados);
			}
			{
				btnTrabajos = new JButton("Trabajos");
				btnTrabajos.setEnabled(false);
				btnTrabajos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MostrarTrabajo aux = new MostrarTrabajo(comi.getTrabajos());
						aux.setModal(true);
						aux.setVisible(true);
						btnTrabajos.setEnabled(false);
					}
				});
				buttonPane.add(btnTrabajos);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opcion;
						opcion= JOptionPane.showConfirmDialog(null, "Estas Seguro de querer eliminar la comisión :"+comi.getCodigo(),
								"Confirmacion", JOptionPane.YES_NO_OPTION);
						if(opcion == JOptionPane.OK_OPTION) {
							if(verificareventencomision(comi)) {
								JOptionPane.showMessageDialog(null, "No se puede eliminar una comision contenida en un evento", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							}else {
								EventoCiencia.getInstance().eliminarcomision(comi.getCodigo());
								JOptionPane.showMessageDialog(null, "Comisión eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								cargardatos(prioridad);
								btnEliminar.setEnabled(false);
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
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
			for (int i = 0; i < EventoCiencia.getInstance().getComisiones().size(); i++) {
				if(EventoCiencia.getInstance().getComisiones().get(i).getArea().equals(boxFiltro.getSelectedItem().toString()) || boxFiltro.getSelectedItem().toString().equals("Todos")) {
					rows[0] = EventoCiencia.getInstance().getComisiones().get(i).getCodigo();
					rows[1] = EventoCiencia.getInstance().getComisiones().get(i).getArea();
					rows[2] = EventoCiencia.getInstance().getComisiones().get(i).getPresidente().getNombre();
					rows[3] = EventoCiencia.getInstance().getComisiones().get(i).getJurados().size();
					rows[4] = EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size();

					model.addRow(rows);
				}
			}
		}
		else
		{
			for (int i=0;i<prioridad.size();i++) {
				if(prioridad.get(i).getArea().equals(boxFiltro.getSelectedItem().toString()) || boxFiltro.getSelectedItem().toString().equals("Todos")) {
					rows[0] = prioridad.get(i).getCodigo();
					rows[1] = prioridad.get(i).getArea();
					rows[2] = prioridad.get(i).getPresidente().getNombre();
					rows[3] = prioridad.get(i).getJurados().size();
					rows[4] = prioridad.get(i).getTrabajos().size();
					model.addRow(rows);
				}
			}
		}
		
	}
	public boolean verificareventencomision(Comision comi) {
		boolean encontrado=false;
		for (int i = 0; i < EventoCiencia.getInstance().getEventos().size(); i++) {
			for (int j = 0; j < EventoCiencia.getInstance().getEventos().get(i).getComisiones().size(); j++)
			{
				if(comi.equals(EventoCiencia.getInstance().getEventos().get(i).getComisiones().get(j))) 
				{
					encontrado=true;
				}
			}
		}
		return encontrado;
	}
	

}
