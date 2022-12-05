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
	
	private String[] Areas={"Física", "Biología", "Química", "Astronomía", "Tecnología","Matemática"};
	
	private Evento auxEvento=null;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public MostrarInfEvento(Evento event) {
		auxEvento=event;
		setTitle("Mostrar Informe Evento codigo:"+event.getCodigo()+" Nombre:"+event.getNombre());
		setBounds(100, 100, 844, 219);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 808, 119);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		String[] columnas = {"Area","Cant trabajos","Cant Comisiones","Cant Jurados","Cant Participantes"};
		model.setColumnIdentifiers(columnas);
		table.setModel(model);
		scrollPane.setViewportView(table);
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
			contarareacomision(rows, Areas[i]);
			model.addRow(rows);
		}
	}
	
	public void contarareacomision(Object[] row,String area) {
		int cantareacomision=0;
		int cantareatrabajo=0;
		int cantjurados=0;
		int cantparticipantes=0;
		boolean repetido=false;
		for (int i=0;i< auxEvento.getComisiones().size();i++) {
			if(area.equalsIgnoreCase(EventoCiencia.getInstance().getEventos().get(i).getComisiones().get(i).getArea()))
			{
				cantareacomision++;
				cantareatrabajo+=auxEvento.getComisiones().get(i).getTrabajos().size();
				cantjurados=auxEvento.getComisiones().get(i).getTrabajos().size()+1;
				for (int j = 0; j < auxEvento.getComisiones().get(i).getTrabajos().size(); j++)
				{
					Participante partaux=auxEvento.getComisiones().get(i).getTrabajos().get(j).getPropietario();
					cantparticipantes++;
					for (int k = j+1; k < auxEvento.getComisiones().get(i).getTrabajos().size() && repetido!=true; k++)
					{
						if(partaux.getCodparticipante().equalsIgnoreCase(auxEvento.getComisiones().get(i).getTrabajos().get(k).getPropietario().getCodparticipante()))
						{
							cantparticipantes--;
							repetido=true;
						}
					}
				}
			}
		}
		row[1]=cantareatrabajo;
		row[2]=cantareacomision;
		row[3]=cantjurados;
		row[4]=cantparticipantes;
	}
}
