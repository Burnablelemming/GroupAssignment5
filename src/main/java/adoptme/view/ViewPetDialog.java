package adoptme.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ViewPetDialog extends JDialog{
	public ViewPetDialog() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(10, 35, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age: ");
		lblNewLabel_1.setBounds(10, 60, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Species: ");
		lblNewLabel_2.setBounds(10, 85, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID: ");
		lblNewLabel_3.setBounds(10, 110, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel dialogTitleLabel = new JLabel("Pet Information");
		dialogTitleLabel.setBounds(176, 11, 96, 14);
		getContentPane().add(dialogTitleLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Adopted: ");
		lblNewLabel_4.setBounds(10, 135, 64, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setBounds(66, 35, 46, 14);
		getContentPane().add(nameLabel);
		
		JLabel ageLabel = new JLabel("New label");
		ageLabel.setBounds(66, 60, 46, 14);
		getContentPane().add(ageLabel);
		
		JLabel speciesLabel = new JLabel("New label");
		speciesLabel.setBounds(66, 85, 46, 14);
		getContentPane().add(speciesLabel);
		
		JLabel idLabel = new JLabel("New label");
		idLabel.setBounds(66, 110, 46, 14);
		getContentPane().add(idLabel);
		
		JLabel adoptedLabel = new JLabel("New label");
		adoptedLabel.setBounds(66, 135, 46, 14);
		getContentPane().add(adoptedLabel);
	}
}
