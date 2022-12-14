package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Logico.EventoCiencia;
import Logico.Recurso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegRecurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JTextField txtCodigo;
	private JTextField txtUbicacion;
	private JComboBox BoxTipo;
	private JLabel label4;
	private JEditorPane ptxtDescripcion;
	private JSpinner spnCant;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			RegRecurso dialog = new RegRecurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegRecurso() {
		setTitle("Agregar recurso");
		setBounds(100, 100, 396, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(12, 19, 56, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ubicaci\u00F3n:");
		lblNewLabel_1.setBounds(12, 54, 79, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setBounds(12, 89, 39, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(80, 17, 116, 22);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setText("Recur-"+EventoCiencia.getInstance().getCodrecurso());
		
		txtUbicacion = new JTextField();
		txtUbicacion.setBounds(80, 52, 286, 22);
		contentPanel.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		BoxTipo = new JComboBox();
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Micr\u00F3fono", "Bocina", "Pantalla", "Cable HDMI a HDMI", "Cable tipo C a HDMI", "Cable VGA a HDMI", "Mesa", "Silla", "Soporte de micr\u00F3fono", "Luces"}));
		BoxTipo.setToolTipText("");
		BoxTipo.setBounds(80, 87, 151, 22);
		contentPanel.add(BoxTipo);
		
		label4 = new JLabel("Descripci\u00F3n:");
		label4.setBounds(12, 125, 99, 16);
		contentPanel.add(label4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 146, 354, 72);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		ptxtDescripcion = new JEditorPane();
		panel.add(ptxtDescripcion, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setBounds(242, 90, 56, 16);
		contentPanel.add(lblNewLabel_3);
		
		spnCant = new JSpinner();
		spnCant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCant.setBounds(300, 88, 61, 19);
		contentPanel.add(spnCant);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarrecurso();
					}
				});
				btnAgregar.setActionCommand("OK");
				buttonPane.add(btnAgregar);
				getRootPane().setDefaultButton(btnAgregar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	public void registrarrecurso() {
		
		if(!(txtUbicacion.getText().equals("")))
		{
			if(BoxTipo.getSelectedIndex() != 0) 
			{
				Recurso rec = null;
				for(int i = 0; i < Integer.parseInt(spnCant.getValue().toString()); i++)
				{
					rec = new Recurso("Recur-"+EventoCiencia.getInstance().getCodrecurso(),true, txtUbicacion.getText(), BoxTipo.getSelectedItem().toString(),ptxtDescripcion.getText());
					EventoCiencia.getInstance().agregarrecurso(rec);
				}
				
				if(Integer.parseInt(spnCant.getValue().toString()) > 1)
					JOptionPane.showMessageDialog(null, "Recursos agregados!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Recurso agregado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				clear();
			}
			else
				JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Debe colocar una ubicaci?n!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void clear() {
		txtCodigo.setText("Recur-"+EventoCiencia.getInstance().getCodrecurso());
		txtUbicacion.setText("");
		BoxTipo.setSelectedIndex(0);
		ptxtDescripcion.setText("");
		spnCant.setValue(Integer.valueOf(0));
	}
}
