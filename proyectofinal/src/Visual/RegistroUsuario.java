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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JComboBox boxTipo;
	private JTextField txtValidarcontra;
	private JLabel Contraanterior;
	private JTextField txtContraseñaant;
	private JPasswordField contanenia;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			RegistroUsuario dialog = new RegistroUsuario(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroUsuario(int opcion) {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 372, 310);
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
			
			if(opcion == 0)
				btnRegistrar = new JButton("Registrar");
			else
				btnRegistrar = new JButton("Modificar");	
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(opcion == 0)
						registrar();
					else
						modificar();
				}
			});
			btnRegistrar.setBounds(59, 199, 97, 25);
			panel.add(btnRegistrar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(175, 199, 97, 25);
			panel.add(btnCancelar);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBounds(22, 27, 56, 16);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			if(opcion == 0)
				lblNewLabel_1.setBounds(22, 70, 82, 16);
			else
				lblNewLabel_1.setBounds(22, 113, 82, 16);
			panel.add(lblNewLabel_1);
			
			
			if(opcion == 0)
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo de usuario:");
				lblNewLabel_2.setBounds(22, 156, 105, 16);
				panel.add(lblNewLabel_2);
				
				boxTipo = new JComboBox();
				boxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Administrador", "Secretaria"}));
				boxTipo.setBounds(165, 155, 167, 19);
				panel.add(boxTipo);
			}
				
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(165, 24, 167, 22);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			if(opcion == 1)
			{
				txtUsuario.setEnabled(false);
				txtUsuario.setText(EventoCiencia.getInstance().getUser().getUser());
			}
				
			txtContrasena = new JPasswordField();
			if(opcion == 0)
				txtContrasena.setBounds(165, 67, 167, 22);
			else
				txtContrasena.setBounds(165, 110, 167, 22);
			panel.add(txtContrasena);
			txtContrasena.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Confirmar contrase\u00F1a:");
			if(opcion == 0)
				lblNewLabel_3.setBounds(22, 113, 134, 16);
			else
				lblNewLabel_3.setBounds(22, 156, 134, 16);
			panel.add(lblNewLabel_3);
			
			txtValidarcontra = new JPasswordField();
			if(opcion == 0)
				txtValidarcontra.setBounds(165, 110, 167, 22);
			else
				txtValidarcontra.setBounds(165, 155, 167, 22);
			panel.add(txtValidarcontra);
			txtValidarcontra.setColumns(10);
			
			if(opcion == 1)
			{
				Contraanterior = new JLabel("Contrase\u00F1a anterior:");
				Contraanterior.setBounds(22, 70, 134, 16);
				panel.add(Contraanterior);
				
				txtContraseñaant = new JPasswordField();
				txtContraseñaant.setBounds(165, 67, 167, 22);
				panel.add(txtContraseñaant);
				txtContraseñaant.setColumns(10);
			}	
		}
	}
	
	public void registrar() {
		if(txtContrasena.getText().equals(txtValidarcontra))
		{
			Usuario aux = new Usuario(boxTipo.getSelectedItem().toString(), txtUsuario.getText(), txtContrasena.getText());
			EventoCiencia.getInstance().reguser(aux);
			JOptionPane.showMessageDialog(null, "Usuario registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			clear();
		}
		else
			JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void modificar() {
		if(EventoCiencia.getInstance().confirmLogin(txtUsuario.getText(), txtContraseñaant.getText()))
		{
			if(txtContrasena.getText().equals(txtValidarcontra.getText()))
			{
				Usuario aux = EventoCiencia.getInstance().buscarusuario(txtUsuario.getText());
				aux.setContrasena(txtContrasena.getText());
				JOptionPane.showMessageDialog(null, "Contraseña modificada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void clear() {
		txtContrasena.setText("");
		txtUsuario.setText("");
		boxTipo.setSelectedIndex(0);
	}
}
