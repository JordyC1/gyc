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
import Logico.Jurado;
import Logico.Participante;
import Logico.Trabajo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarMejoresproy extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private JTable tabletrabajo;
	private DefaultTableModel modeltable;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			MostrarMejoresproy dialog = new MostrarMejoresproy();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public MostrarMejoresproy() {
		setTitle("Mostrar mejores trabajos");
		setBounds(100, 100, 672, 279);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Area del trabajo:");
		lblNewLabel.setBounds(174, 33, 95, 14);
		contentPanel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarmejorescali();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Física", "Biología", "Química", "Astronomía", "Tecnología","Matemática"}));
		comboBox.setBounds(279, 30, 105, 20);
		contentPanel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 636, 134);
		contentPanel.add(scrollPane);
		
		tabletrabajo = new JTable();
		modeltable=new DefaultTableModel() ;
		String[] columnas = {"Nombre propietario","Titulo trabajo","Calificacion"};
		modeltable.setColumnIdentifiers(columnas);
		tabletrabajo.setModel(modeltable);
		scrollPane.setViewportView(tabletrabajo);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okbtn = new JButton("Aceptar");
				okbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okbtn.setActionCommand("Cancel");
				buttonPane.add(okbtn);
			}
		}
	}
	public void mostrarmejorescali() {

		modeltable.setRowCount(0);
		rows =new Object[modeltable.getColumnCount()];
		for (int i=0;i< EventoCiencia.getInstance().getComisiones().size();i++) 
		{
			ArrayList<Trabajo> mejoresTrabajos=new ArrayList<>();
			for (int j = 0; j < EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size(); j++) {
				if(EventoCiencia.getInstance().getComisiones().get(i).getArea().equalsIgnoreCase(String.valueOf(comboBox.getSelectedItem())))
				{
					mejoresTrabajos.add(EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j));
				}
			}
			organizarmejorestrabajos(rows, mejoresTrabajos);
		}
	}
	
	public void organizarmejorestrabajos(Object[] row,ArrayList<Trabajo> trabajos) {
		if(trabajos!=null) {
			Trabajo temp=null;
			for (int i = 1; i < trabajos.size(); i++) {
					for (int j=0 ; j < trabajos.size()- 1; j++){
						if (trabajos.get(j).getCalificacion() < trabajos.get(j+1).getCalificacion()){
							temp = trabajos.get(j);
							trabajos.set(j, trabajos.get(j+1));
							trabajos.set(j+1,temp);
						}
					}
			}
				for (int i = 0; i < trabajos.size(); i++) {
					rows[0]=trabajos.get(i).getPropietario().getNombre();
					rows[1]=trabajos.get(i).gettitulo();
					rows[2]=String.valueOf(trabajos.get(i).getCalificacion());
					modeltable.addRow(rows);
				}
			}
		}

}
