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
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

import Logico.Comision;
import Logico.EventoCiencia;
import Logico.Jurado;
import Logico.Trabajo;

import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Califmostrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JButton btncalificar;
	private JSpinner spncali;
	private JTextField txtcod;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Califmostrar(ArrayList<Trabajo> trabajoarray,Trabajo trabajo) {
		setTitle("Calificar trabajo");
		setBounds(100, 100, 355, 231);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 319, 132);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Codigo jurado:");
		label.setBounds(61, 31, 86, 14);
		panel.add(label);
		
		txtcod = new JTextField();
		txtcod.setColumns(10);
		txtcod.setBounds(155, 28, 86, 20);
		panel.add(txtcod);
		
		JLabel label_1 = new JLabel("Calificacion:");
		label_1.setBounds(73, 82, 86, 14);
		panel.add(label_1);
		
		spncali = new JSpinner();
		spncali.setBounds(155, 79, 86, 20);
		panel.add(spncali);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btncalificar = new JButton("Calificar");
				btncalificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jurado jurado=EventoCiencia.getInstance().buscarJurado(txtcod.getText());
						if(jurado!=null) {
							if(buscarjuradocomi(trabajo, jurado)) {
								if(Float.parseFloat(spncali.getValue().toString()) != 0)
								{
									if(!trabajo.verificarcalificacion(jurado)) {
										trabajo.calificadopor(jurado);
										EventoCiencia.getInstance().evaluartrabajo(trabajo.getCodigo(), Float.parseFloat(spncali.getValue().toString()));
										JOptionPane.showMessageDialog(null, "Calificación registrada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
										MostrarTrabajo.cargardatos(trabajoarray);
										btncalificar.setEnabled(false);
										spncali.setValue(Float.valueOf(0));
										dispose();
									}else {
										JOptionPane.showMessageDialog(null, "Este jurado ya ha calificado este trabajo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else
									JOptionPane.showMessageDialog(null, "Calificación debe ser mayor de 0", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Jurado no valido para calificar este trabajo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Codigo de jurado inexistente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
					}
							
				});
				btncalificar.setActionCommand("OK");
				buttonPane.add(btncalificar);
				getRootPane().setDefaultButton(btncalificar);
			}
			{
				btncancelar = new JButton("Cerrar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
	}
	public boolean buscarjuradocomi(Trabajo trabajo,Jurado jurado) {
		boolean encontrado=false;
		Comision comiaux=null;
		for (int i = 0; i < EventoCiencia.getInstance().getComisiones().size() && encontrado!=true; i++) {
			for (int j = 0; j < EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().size() && encontrado!=true; j++) {
				if(trabajo.equals(EventoCiencia.getInstance().getComisiones().get(i).getTrabajos().get(j))) {
					comiaux=EventoCiencia.getInstance().getComisiones().get(i);
					encontrado=true;
				}
			}
		}
		if(comiaux!=null) {
			encontrado=false;
			for (int i = 0; i < comiaux.getJurados().size() && encontrado!=true; i++) {
				if(jurado.equals(comiaux.getJurados().get(i))) {
					encontrado=true;
				}
			}
		}
		return encontrado;
	}
}
