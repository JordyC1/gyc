package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Logico.EventoCiencia;
import Logico.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField ftxtUsuario;
	private JFormattedTextField ftxtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream feria;
				FileOutputStream feria2;
				ObjectInputStream ferialeer;
				ObjectOutputStream feriaescribir;
				try {
					feria = new FileInputStream("feria.dat");
					ferialeer = new ObjectInputStream(feria);
					EventoCiencia aux = (EventoCiencia)ferialeer.readObject();
					EventoCiencia.setCiencia(aux);
					feria.close();
					ferialeer.close();
				} catch (FileNotFoundException e) {
					try {
						feria2 = new  FileOutputStream("feria.dat");
						feriaescribir = new ObjectOutputStream(feria2);
						Usuario aux = new Usuario("Administrador", "Admin", "Admin");
						EventoCiencia.getInstance().reguser(aux);
						feriaescribir.writeObject(EventoCiencia.getInstance());
						feria2.close();
						feriaescribir.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Feria de Ciencias");
		lblNewLabel.setFont(new Font("Gloucester MT Extra Condensed", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 5, 297, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(128, 77, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(119, 130, 75, 16);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Iniciar seci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EventoCiencia.getInstance().confirmLogin(ftxtUsuario.getText(),ftxtContrasena.getText())){
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(91, 205, 131, 25);
		panel.add(btnNewButton);
		
		ftxtUsuario = new JFormattedTextField();
		ftxtUsuario.setToolTipText("Usuario");
		ftxtUsuario.setBounds(76, 100, 161, 19);
		panel.add(ftxtUsuario);
		
		ftxtContrasena = new JFormattedTextField();
		ftxtContrasena.setBounds(76, 159, 161, 19);
		panel.add(ftxtContrasena);
		setLocationRelativeTo(null);
	}
}
