package adoptme.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddPetDialog extends JDialog{
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField typeTextField;
	private JTextField speciesTextField;
	private JTextField idTextField;
	private boolean submitted = false;
	
	public AddPetDialog() {
		getContentPane().setLayout(null);
		setSize(300, 300);
		
		JLabel lblNewLabel = new JLabel("Enter Pet Information:");
		lblNewLabel.setBounds(10, 11, 127, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 74, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age: ");
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type: ");
		lblNewLabel_3.setBounds(10, 124, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Species: ");
		lblNewLabel_4.setBounds(10, 149, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID: ");
		lblNewLabel_5.setBounds(10, 174, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(66, 71, 86, 20);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(66, 96, 86, 20);
		getContentPane().add(ageTextField);
		ageTextField.setColumns(10);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(66, 121, 86, 20);
		getContentPane().add(typeTextField);
		typeTextField.setColumns(10);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(66, 146, 86, 20);
		getContentPane().add(speciesTextField);
		speciesTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setBounds(66, 171, 86, 20);
		getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		JButton addPetDialogButton = new JButton("Add");
		addPetDialogButton.setBounds(10, 227, 89, 23);
		getContentPane().add(addPetDialogButton);
		addPetDialogButton.addActionListener(new ActionListener() {
			// Validating input while dialog is open
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText().trim();
				String ageStr = ageTextField.getText().trim();
				
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(AddPetDialog.this, "Name cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
                    Integer parsedAge = Integer.parseInt(ageStr);
                    if (parsedAge < 0) {
                        JOptionPane.showMessageDialog(AddPetDialog.this, "Age must be a non-negative number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddPetDialog.this, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				
				submitted = true;
				setVisible(false);
			}
		});
		
		JButton cancelPetDialogButton = new JButton("Cancel");
		cancelPetDialogButton.setBounds(185, 227, 89, 23);
		getContentPane().add(cancelPetDialogButton);
		
		cancelPetDialogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitted = false;
				setVisible(false);
			}
		});
	}
	
	public boolean isSubmitted() {
		return submitted;
	}
	
	public String getPetName() {
		return nameTextField.getText();
	}
	public String getPetAge() {
		return ageTextField.getText();
	}
	public String getPetType() {
		return typeTextField.getText();
	}
	public String getPetSpecies() {
		return speciesTextField.getText();
	}
	public String getPetId() {
		return idTextField.getText();
	}
	
}
