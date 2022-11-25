package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Participante;
import Logico.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcedula;
	private JTextField txtnombre;
	private JTextField txttelefono;
	private JTextField txtcodigo;
	private JTable table;
	private JRadioButton rdbtnjurado;
	private JRadioButton rdbtnparticipante;
	private JLabel lblarea;
	private JComboBox cmbarea;
	private JPanel panel_1;
	private JButton btnagregartrabajo;
	private JButton btneliminar;
	private Persona modpersona;
	private JButton btnagregar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegPersona(Persona tipospersona) {
		modpersona=tipospersona;
		rdbtnjurado = new JRadioButton("Jurado");
		rdbtnparticipante = new JRadioButton("Participante");
		if(modpersona!=null && modpersona instanceof Jurado) {
			setTitle("Modificar jurado: "+((Jurado)tipospersona).getNombre()+" codigo: " +((Jurado)tipospersona).getCodjurado());
			rdbtnjurado.setSelected(true);
			rdbtnjurado.setEnabled(false);
			rdbtnparticipante.setEnabled(false);
		}else if (modpersona!=null && modpersona instanceof Participante) {
			setTitle("Modificar participante: "+((Participante)tipospersona).getNombre()+" codigo: " +((Participante)tipospersona).getCodparticipante());
			rdbtnparticipante.setSelected(true);
			rdbtnparticipante.setEnabled(false);
			rdbtnjurado.setEnabled(false);
		}else {
			setTitle("Registro Personas");
			rdbtnjurado.setSelected(true);
		}
		setBounds(100, 100, 452, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 414, 103);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Cedula:");
				lblNewLabel.setBounds(10, 22, 51, 14);
				panel.add(lblNewLabel);
			}
			{
				txtcedula = new JTextField();
				txtcedula.setBounds(61, 19, 109, 20);
				panel.add(txtcedula);
				txtcedula.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 59, 51, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtnombre = new JTextField();
				txtnombre.setBounds(61, 56, 138, 20);
				panel.add(txtnombre);
				txtnombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Telefono:");
				lblNewLabel_2.setBounds(197, 22, 59, 14);
				panel.add(lblNewLabel_2);
			}
			{
				txttelefono = new JTextField();
				txttelefono.setBounds(266, 19, 138, 20);
				panel.add(txttelefono);
				txttelefono.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Codigo:");
				lblNewLabel_3.setBounds(209, 59, 59, 14);
				panel.add(lblNewLabel_3);
			}
			{
				txtcodigo = new JTextField();
				txtcodigo.setEditable(false);
				txtcodigo.setText("JUD-"+EventoCiencia.getInstance().getCodjurado());
				txtcodigo.setBounds(266, 56, 96, 20);
				panel.add(txtcodigo);
				txtcodigo.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 112, 414, 55);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			
			rdbtnjurado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pullrdbtnjurado();
					
				}
			});
			rdbtnjurado.setBounds(68, 25, 109, 23);
			panel.add(rdbtnjurado);
			
			
			rdbtnparticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pullrdtbparticipante();
				}
			});
			rdbtnparticipante.setBounds(249, 25, 109, 23);
			panel.add(rdbtnparticipante);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 178, 414, 198);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.setBorder(null);
				panel_1.setVisible(false);
				panel_1.setBounds(137, 23, 267, 142);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
					}
				}
			}
			{
				lblarea = new JLabel("Area de especializacion:");
				lblarea.setBounds(10, 50, 144, 14);
				panel.add(lblarea);
			}
			{
				cmbarea = new JComboBox();
				cmbarea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Informatica", "Matematicas", "Ciencias", "Lenguas", "Arte"}));
				cmbarea.setBounds(10, 75, 117, 20);
				panel.add(cmbarea);
			}
			{
				btnagregartrabajo = new JButton("Agregar trabajo");
				btnagregartrabajo.setVisible(false);
				btnagregartrabajo.setBounds(137, 164, 144, 23);
				panel.add(btnagregartrabajo);
			}
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.setBounds(285, 164, 119, 23);
				btneliminar.setVisible(false);
				panel.add(btneliminar);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnagregar = new JButton("Agregar");
				if(modpersona!=null) {
					btnagregar.setText("Modificar");
				}
				btnagregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona persona=null;
						if(modpersona!=null ) {
							if(modpersona instanceof Jurado) {
								modpersona.setCedula(txtcedula.getText());
								modpersona.setNombre(txtnombre.getText());
								modpersona.setTelefono(txttelefono.getText());
								((Jurado) modpersona).setCodjurado(txtcodigo.getText());
								((Jurado) modpersona).setAreaespecializado(cmbarea.getSelectedItem().toString());
								EventoCiencia.getInstance().modifJurado((Jurado)modpersona);
								MostrarJurados.loadjurados();
								dispose();
							}else if( modpersona instanceof Participante) {
								modpersona.setCedula(txtcedula.getText());
								modpersona.setNombre(txtnombre.getText());
								modpersona.setTelefono(txttelefono.getText());
								((Participante) modpersona).setCodparticipante(txtcodigo.getText());
								//((Participante) modpersona).setTrabajos(trabajos);(cmbarea.getSelectedItem().toString());
							}
						}else {
							if(rdbtnjurado.isSelected()) {
								persona=new Jurado(txtcedula.getText(),txtnombre.getText() , txttelefono.getText(), txtcodigo.getText(),
										cmbarea.getSelectedItem().toString());
								EventoCiencia.getInstance().agregarpersonas(persona);
							}else if (rdbtnparticipante.isSelected()) {
								
							}
							clean();
						}
					}
				});
				btnagregar.setActionCommand("OK");
				buttonPane.add(btnagregar);
				getRootPane().setDefaultButton(btnagregar);
			}
			{
				JButton btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
		if(modpersona!=null && modpersona instanceof Jurado) {
			loadjurado();
			pullrdbtnjurado();
		}else if (modpersona!=null && modpersona instanceof Participante) {
			loadparticipante();
			pullrdtbparticipante();
		}
	}

	private void pullrdtbparticipante() {
		txtcodigo.setText("Part-"+EventoCiencia.getInstance().getCodparticipante());
		rdbtnjurado.setSelected(false);
		lblarea.setVisible(false);
		cmbarea.setVisible(false);
		panel_1.setVisible(true);
		btnagregartrabajo.setVisible(true);
		btneliminar.setVisible(true);
	}
	private void pullrdbtnjurado() {
		rdbtnparticipante.setSelected(false);
		lblarea.setVisible(true);
		cmbarea.setVisible(true);
		panel_1.setVisible(false);
		btnagregartrabajo.setVisible(false);
		btneliminar.setVisible(false);
		txtcodigo.setText("JUD-"+EventoCiencia.getInstance().getCodjurado());
	}
	private void loadparticipante() {
		txtcedula.setText(modpersona.getCedula());
		txtcodigo.setText(((Participante)modpersona).getCodparticipante());
		txtnombre.setText(modpersona.getNombre());
		txttelefono.setText(modpersona.getTelefono());
		//cmbarea.setSelectedItem(((Participante)modpersona).getAreaespecializado());
	}

	private void clean() {
		txtcedula.setText("");
		txtcodigo.setText("");
		txtnombre.setText("");
		txttelefono.setText("");
		cmbarea.setSelectedItem("<Seleccione>");
		if(rdbtnjurado.isSelected()) {
			txtcodigo.setText("JUD-"+EventoCiencia.getInstance().getCodjurado());
		}else if(rdbtnparticipante.isSelected()) {
			txtcodigo.setText("Part-"+EventoCiencia.getInstance().getCodparticipante());
		}
	}
	private void loadjurado() {
		txtcedula.setText(modpersona.getCedula());
		txtcodigo.setText(((Jurado)modpersona).getCodjurado());
		txtnombre.setText(modpersona.getNombre());
		txttelefono.setText(modpersona.getTelefono());
		cmbarea.setSelectedItem(((Jurado)modpersona).getAreaespecializado());
		
	}
	
}
