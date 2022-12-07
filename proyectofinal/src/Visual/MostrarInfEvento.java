package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import Logico.Comision;
import Logico.Evento;
import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Participante;
import Logico.Persona;
import Logico.Trabajo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MostrarInfEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static Object[] rows;
	private static DefaultTableModel model;
	
	private String[] Areas={"F�sica", "Biolog�a", "Qu�mica", "Astronom�a", "Tecnolog�a","Matem�tica","Total"};
	
	private Evento auxEvento=null;
	private JTextField txtrecursos;
	private JTextField txtparticipante;
	
	private int totaltrabajo=0;
	private int totaljurado=0;
	private int totalcomisiones=0;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public MostrarInfEvento(Evento event) {
		auxEvento=event;
		setTitle("Mostrar Informe Evento codigo:"+event.getCodigo()+" Nombre:"+event.getNombre());
		setBounds(100, 100, 844, 289);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 69, 808, 135);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		String[] columnas = {"Area","Cant trabajos","Cant Comisiones","Cant Jurados"};
		model.setColumnIdentifiers(columnas);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Cantidad de recursos:");
		lblNewLabel.setBounds(29, 11, 145, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de participantes:");
		lblNewLabel_1.setBounds(10, 44, 151, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtrecursos = new JTextField();
		txtrecursos.setEditable(false);
		txtrecursos.setBounds(160, 8, 73, 20);
		contentPanel.add(txtrecursos);
		txtrecursos.setColumns(10);
		
		txtparticipante = new JTextField();
		txtparticipante.setEditable(false);
		txtparticipante.setBounds(160, 38, 73, 20);
		contentPanel.add(txtparticipante);
		txtparticipante.setColumns(10);
		txtparticipante.setText(""+EventoCiencia.getInstance().cantparticipanteevento(auxEvento.getCodigo()));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargardatos();
	}

	public void cargardatos() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];	

		for (int i=0;i< Areas.length;i++) {
			rows[0]=Areas[i];
			if(i<6) {
			contarareacomision(rows, Areas[i]);
			}else {
				rows[1]=totaltrabajo;
				rows[2]=totalcomisiones;
				rows[3]=totaljurado;
			}
			model.addRow(rows);
		}
	}
	
	public void contarareacomision(Object[] row,String area) {
		int cantareacomision=0;
		int cantareatrabajo=0;
		int cantjurados=0;
		int cantrecursos=0;
		for (int i=0;i< auxEvento.getComisiones().size();i++) {
			
			if(area.equalsIgnoreCase(auxEvento.getComisiones().get(i).getArea()))
			{
				cantareacomision++;
				cantareatrabajo+=auxEvento.getComisiones().get(i).getTrabajos().size();
				cantjurados+=auxEvento.getComisiones().get(i).getJurados().size()+1;
			}
		}
		txtrecursos.setText(String.valueOf(auxEvento.getRecursos().size()));
		totalcomisiones+=cantareacomision;
		totaljurado+=cantjurados;
		totaltrabajo+=cantareatrabajo;
		row[1]=cantareatrabajo;
		row[2]=cantareacomision;
		row[3]=cantjurados;
	}
	
	
}
