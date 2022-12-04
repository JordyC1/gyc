package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Logico.EventoCiencia;
import Logico.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JComboBox boxTipo;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			RegistroUsuario dialog = new RegistroUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroUsuario() {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 338, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrar();
				}
			});
			btnRegistrar.setBounds(41, 172, 97, 25);
			panel.add(btnRegistrar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(161, 172, 97, 25);
			panel.add(btnCancelar);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBounds(22, 27, 56, 16);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_1.setBounds(22, 71, 82, 16);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Tipo de usuario:");
			lblNewLabel_2.setBounds(22, 119, 105, 16);
			panel.add(lblNewLabel_2);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(122, 24, 157, 22);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			txtContrasena = new JTextField();
			txtContrasena.setBounds(122, 68, 157, 22);
			panel.add(txtContrasena);
			txtContrasena.setColumns(10);
			
			boxTipo = new JComboBox();
			boxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Administrador", "Secretaria"}));
			boxTipo.setBounds(122, 118, 157, 19);
			panel.add(boxTipo);
		}
	}
	
	public void registrar() {
		Usuario aux = new Usuario(boxTipo.getSelectedItem().toString(), txtUsuario.getText(), txtContrasena.getText());
		EventoCiencia.getInstance().reguser(aux);
		clear();
	}
	
	public void clear() {
		txtContrasena.setText("");
		txtUsuario.setText("");
		boxTipo.setSelectedIndex(0);
	}
}
