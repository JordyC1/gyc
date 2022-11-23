package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RegTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcedula;
	private JTextField txtcodigo;
	private JTextField txttitulo;
	private JTable table;
	private JTable table_1;
	private JComboBox cmbarea;
	private JButton btnaddevento;
	private JButton btnaddcomision;
	private JButton btneliminar;
	private JButton btnregistrar;
	private JButton btncancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarTrabajo dialog = new MostrarTrabajo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajo() {
		setTitle("Agregar trabajo");
		setBounds(100, 100, 493, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cedula propietario:");
			lblNewLabel.setBounds(10, 25, 117, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtcedula = new JTextField();
			txtcedula.setBounds(125, 22, 128, 20);
			contentPanel.add(txtcedula);
			txtcedula.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setBounds(68, 68, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtcodigo = new JTextField();
			txtcodigo.setText("");
			txtcodigo.setBounds(124, 65, 86, 20);
			contentPanel.add(txtcodigo);
			txtcodigo.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Area Trabajo:");
			lblNewLabel_2.setBounds(243, 68, 86, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cmbarea = new JComboBox();
			cmbarea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Informatica", "Matematicas", "Ciencias", "Artes", "Lenguas"}));
			cmbarea.setBounds(331, 65, 109, 20);
			contentPanel.add(cmbarea);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Titulo:");
			lblNewLabel_3.setBounds(81, 108, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txttitulo = new JTextField();
			txttitulo.setBounds(125, 105, 158, 20);
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
				panel_1.setBounds(10, 27, 210, 166);
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
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(237, 27, 210, 166);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table_1 = new JTable();
						scrollPane.setViewportView(table_1);
					}
				}
			}
			{
				btnaddcomision = new JButton("Seleccionar comision");
				btnaddcomision.setBounds(10, 196, 157, 23);
				panel.add(btnaddcomision);
			}
			{
				btnaddevento = new JButton("Seleccionar evento");
				btnaddevento.setBounds(290, 196, 157, 23);
				panel.add(btnaddevento);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.setEnabled(false);
				buttonPane.add(btneliminar);
			}
			{
				btnregistrar = new JButton("Registrar");
				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
			}
			{
				btncancelar = new JButton("Cancelar");
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
	}

}
