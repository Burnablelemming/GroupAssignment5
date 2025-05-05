package adoptme.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JSeparator;

public class ViewPetDialog extends JDialog{
	
	private JPanel panel;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel speciesLabel;
	private JLabel idLabel;
	private JLabel adoptedLabel;
	
	public ViewPetDialog() {
		setTitle("Pet Information");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(800, 100, 300, 250);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		//getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(10, 35, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age: ");
		lblNewLabel_1.setBounds(10, 60, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Species: ");
		lblNewLabel_2.setBounds(10, 85, 64, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID: ");
		lblNewLabel_3.setBounds(10, 110, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel dialogTitleLabel = new JLabel("Pet Information");
		dialogTitleLabel.setBounds(30, 11, 96, 14);
		getContentPane().add(dialogTitleLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Adopted: ");
		lblNewLabel_4.setBounds(10, 135, 64, 14);
		getContentPane().add(lblNewLabel_4);
		
		nameLabel = new JLabel("New label");
		nameLabel.setBounds(76, 35, 132, 14);
		getContentPane().add(nameLabel);
		
		ageLabel = new JLabel("New label");
		ageLabel.setBounds(76, 60, 132, 14);
		getContentPane().add(ageLabel);
		
		speciesLabel = new JLabel("New label");
		speciesLabel.setBounds(76, 85, 132, 14);
		getContentPane().add(speciesLabel);
		
		idLabel = new JLabel("New label");
		idLabel.setBounds(76, 110, 132, 14);
		getContentPane().add(idLabel);
		
		adoptedLabel = new JLabel("New label");
		adoptedLabel.setBounds(76, 135, 132, 14);
		getContentPane().add(adoptedLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 26, 124, 2);
		panel.add(separator);
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JLabel getAgeLabel() {
		return ageLabel;
	}

	public JLabel getSpeciesLabel() {
		return speciesLabel;
	}

	public JLabel getIdLabel() {
		return idLabel;
	}

	public JLabel getAdoptedLabel() {
		return adoptedLabel;
	}
}
