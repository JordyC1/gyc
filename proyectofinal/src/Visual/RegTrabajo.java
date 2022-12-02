package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Logico.Comision;
import Logico.Evento;
import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Participante;
import Logico.Persona;
import Logico.Recurso;
import Logico.Trabajo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFormattedTextField;

public class RegTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private  JTextField txtcodigo;
	private JTextField txttitulo;
	private JTable tablcomision;
	private JTable tablevento;
	private JComboBox cmbarea;
	private JButton btnaddcomision;
	private JButton btnregistrar;
	private JButton btncancelar;
	
	private DefaultTableModel modeltablecomision,modeltableevento;
	private Object[] rowscomision,rowsevent;
	
	private Comision comiselected=null;
	private Evento eventoselected=null;

	private int seleccionado=-1;
	
	public static Participante participantebuscar=null;
	
	//private Participante participantetrabajo;
	private static JFormattedTextField txtcedula;
	private static JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegTrabajo(Participante participante) {
		if(participante!=null) {
			participantebuscar=participante;
		}
		//Persona participantePersona=new Participante("555", "Fabio", "3123123", "1323123");
		/*Jurado p1=new Jurado("qweqe", "Carmen clara", "52345234", "Jud-2","Informatica");
		Jurado p2=new Jurado("qweqe", "CArlo hern", "52345234", "Jud-232","Informatica");
		Jurado p3=new Jurado("qweqe", "CFernando", "52345234", "Jud-4","Informatica");
		Jurado p4=new Jurado("qweqe", "Maria mag", "52345234", "Jud-5","Informatica");
		Comision comision=new Comision("42332", "Informatica", p1);
		Comision comision2=new Comision("34442", "Informatica", p4);
		Recurso recurso=new Recurso("23423", true, "frente", "Microfono", "423423");
		comision.agregarjurados(p2);
		comision2.agregarjurados(p3);
		Evento evento=new Evento("Feria 2019", "23323", "San pedro", "10/5/2010", "10/5/2010", 10);
		Evento event1=new Evento("Feria 201956", "32323", "Alemania", "10/5/2010", "10/5/2010", 20);
		evento.agregarcomision(comision);
		event1.agregarcomision(comision2);
		event1.agregarcomision(comision);
		EventoCiencia.getInstance().agregarcomisiones(comision);
		EventoCiencia.getInstance().agregarcomisiones(comision2);
		EventoCiencia.getInstance().agregarpersonas(p1);
		EventoCiencia.getInstance().agregarpersonas(p2);
		EventoCiencia.getInstance().agregarpersonas(p3);
		EventoCiencia.getInstance().agregarpersonas(p4);
		EventoCiencia.getInstance().agregarevento(evento);
		EventoCiencia.getInstance().agregarevento(event1);
	    */
		setTitle("Agregar trabajo");
		setBounds(100, 100, 493, 458);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cedula propietario:");
			lblNewLabel.setBounds(10, 20, 117, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo del trabajo:");
			lblNewLabel_1.setBounds(10, 98, 117, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtcodigo = new JTextField();
			txtcodigo.setEditable(false);
			txtcodigo.setText("w-"+EventoCiencia.getInstance().getCodtrabajo());
			txtcodigo.setBounds(124, 96, 108, 20);
			contentPanel.add(txtcodigo);
			txtcodigo.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Area Trabajo:");
			lblNewLabel_2.setBounds(244, 101, 86, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cmbarea = new JComboBox();
			cmbarea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadtablecomis();
					modeltableevento.setRowCount(0);
				}
			});
			cmbarea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Física", "Biología", "Química", "Astronomía", "Tecnología","Matemática"}));
			cmbarea.setBounds(332, 98, 109, 20);
			contentPanel.add(cmbarea);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Titulo del proyecto:");
			lblNewLabel_3.setBounds(10, 60, 117, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txttitulo = new JTextField();
			txttitulo.setBounds(124, 57, 317, 20);
			contentPanel.add(txttitulo);
			txttitulo.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Seleccionar:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 145, 457, 230);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Selecciona la comision", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 27, 210, 166);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						tablcomision = new JTable();
						tablcomision.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								 seleccionado=tablcomision.getSelectedRow();
								if(seleccionado!=-1) {
									comiselected=EventoCiencia.getInstance().buscacomision(modeltablecomision.getValueAt(seleccionado, 0).toString());
									btnaddcomision.setEnabled(true);
								}
							}
						});
						modeltablecomision=new DefaultTableModel();
						String []columnacomis= {"Codigo","Presidente"};
						modeltablecomision.setColumnIdentifiers(columnacomis);
						tablcomision.setModel(modeltablecomision);
						scrollPane.setViewportView(tablcomision);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Seleccione el evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(237, 27, 210, 166);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						tablevento = new JTable();
						tablevento.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								seleccionado=tablevento.getSelectedRow();
								if(seleccionado!=-1) {
									eventoselected=EventoCiencia.getInstance().buscarEvento(tablevento.getValueAt(seleccionado, 0).toString());
									btnregistrar.setEnabled(true);
								}
							}
						});
						modeltableevento=new DefaultTableModel();
						String []columnaevento= {"Codigo","Nombre"};
						modeltableevento.setColumnIdentifiers(columnaevento);
						tablevento.setModel(modeltableevento);
						scrollPane.setViewportView(tablevento);
					}
				}
			}
			{
				btnaddcomision = new JButton("Seleccionar comision");
				btnaddcomision.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadtableevent();
						btnaddcomision.setEnabled(false);
					}
				});
				btnaddcomision.setEnabled(false);
				btnaddcomision.setBounds(10, 196, 157, 23);
				panel.add(btnaddcomision);
			}
		}
		{
/////////////////////////////////////////////////////////////////////////////////////////////////////	
//Diseño de la cedula
MaskFormatter mask1 = null;
try {
mask1 = new MaskFormatter("###-#######-#");
mask1.setPlaceholderCharacter('_');
} catch (Exception e) {
e.printStackTrace();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////


			txtcedula = new JFormattedTextField(mask1);
			if(participante!=null) {
				txtcedula.setEditable(false);
			}
			txtcedula.setBounds(124, 18, 117, 20);
			contentPanel.add(txtcedula);
		}
		
		btnBuscar = new JButton("Buscar Participante");
		if(participante!=null) {
			btnBuscar.setEnabled(false);
		}
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Participante BuscarP=null;
				BuscarP=EventoCiencia.getInstance().buscaparticipantebycedula(txtcedula.getText());
				if(BuscarP!=null) {
					txtcedula.setText(BuscarP.getCedula());
					JOptionPane.showMessageDialog(null, "Participante encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);	
				}else {
					int opcion= JOptionPane.showConfirmDialog(null, "Participante no contenido ¿Desea Agregarlo?",
							"Confirmacion", JOptionPane.YES_NO_OPTION);
					if(opcion == JOptionPane.OK_OPTION) {
						BuscarP=new Participante(txtcedula.getText(), "", "", "buscar");
						RegPersona regPersona=new RegPersona(BuscarP);
						regPersona.setModal(true);
						regPersona.setVisible(true);
					}
				}
			}
		});
		btnBuscar.setBounds(267, 16, 152, 23);
		contentPanel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnregistrar = new JButton("Registrar");
				btnregistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Participante participanteaux=null;
						if(!txtcedula.getText().equalsIgnoreCase("")) {
							participanteaux=EventoCiencia.getInstance().buscaparticipantebycedula(txtcedula.getText());
							Trabajo trabajo=null;
							if(!(txttitulo.getText().equalsIgnoreCase(""))) {
								if(eventoselected!=null) {
									if(participante!=null) {
										trabajo=new Trabajo(txtcodigo.getText(), participante, txttitulo.getText());
										participante.agregartrabajo(trabajo);
									}else {
										trabajo=new Trabajo(txtcodigo.getText(), participanteaux, txttitulo.getText());
										participanteaux.agregartrabajo(trabajo);
									}
									comiselected.agregartrabajos(trabajo);
									EventoCiencia.getInstance().modicomision(comiselected);
									EventoCiencia.getInstance().modifevento(eventoselected);
									EventoCiencia.getInstance().agregartrabajo(trabajo);
									if(participante!=null) {
										RegPersona.mostrartrabajos();
									}
									JOptionPane.showMessageDialog(null, "Trabajo Agregado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
									clean();
									btnregistrar.setEnabled(false);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Ingrese un titulo al trabajo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Cedula inexistente", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnregistrar.setEnabled(false);
				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
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
		if(participante!=null) {
			loadparticipante();
		}
	}
	
	private void loadtablecomis() {
		modeltablecomision.setRowCount(0);
		rowscomision =new Object[modeltablecomision.getColumnCount()];
		for (int i = 0; i < EventoCiencia.getInstance().getComisiones().size(); i++) {
			if(EventoCiencia.getInstance().getComisiones().get(i).getArea().equalsIgnoreCase(String.valueOf(cmbarea.getSelectedItem()))) {
				rowscomision[0]=EventoCiencia.getInstance().getComisiones().get(i).getCodigo();
				rowscomision[1]=EventoCiencia.getInstance().getComisiones().get(i).getPresidente().getNombre();
				modeltablecomision.addRow(rowscomision);
			}
		}
	}
	
	private void loadparticipante() {
		txtcedula.setText(participantebuscar.getCedula());
		txtcodigo.setText("W-"+EventoCiencia.getInstance().getCodtrabajo());
	}
	private void loadtableevent() {
		modeltableevento.setRowCount(0);
		rowsevent =new Object[modeltableevento.getColumnCount()];
		for (int i = 0; i < EventoCiencia.getInstance().getEventos().size(); i++) {
			for (int j = 0; j < EventoCiencia.getInstance().getEventos().get(i).getComisiones().size(); j++) {
				if(comiselected!=null && EventoCiencia.getInstance().getEventos().get(i).getComisiones().get(j).getCodigo().equalsIgnoreCase(comiselected.getCodigo())) {
					rowsevent[0]=EventoCiencia.getInstance().getEventos().get(i).getCodigo();
					rowsevent[1]=EventoCiencia.getInstance().getEventos().get(i).getNombre();
					modeltableevento.addRow(rowsevent);
					
				}
				
			}
		}
	}
	public static void buscarparticipantecedula() {
		txtcedula.setText(participantebuscar.getCedula());
		txtcedula.setEditable(false);
		btnBuscar.setEnabled(false);
	}
	

	private void clean(){
		cmbarea.setSelectedItem("<Seleccione>");
		txttitulo.setText("");
		txtcodigo.setText("W-"+EventoCiencia.getInstance().getCodtrabajo());
		loadtablecomis();
	}
	
}
