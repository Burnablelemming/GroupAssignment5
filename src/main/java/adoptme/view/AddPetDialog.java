package adoptme.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * A modal dialog for entering new pet information.
 * Provides fields for name, age, type, species, and ID,
 * along with "Submit" and "Cancel" buttons to confirm or dismiss input.
 * Used by the controller to create a new Pet object and add it to the shelter.
 */
public class AddPetDialog extends JDialog{
	
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField speciesTextField;
	private JTextField idTextField;
	private JButton addPetDialogButton;
	private JButton cancelPetDialogButton;
	private boolean submitted = false;
	private JComboBox typeComboBox;
	
	/**
	 * Constructs a new AddPetDialog tied to a parent JFrame.
	 * Sets up the UI components and makes the dialog modal so that the parent waits for input.
	 *
	 * @param parent the parent JFrame that launched this dialog
	 */
	public AddPetDialog(JFrame parent) {
		// Necessary for allowing the dialog to 'pause' the first add event which triggers 
		// the dialog to appear in the first place, makes the dialog modal
		super(parent, "Add Pet", true);
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
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(66, 146, 86, 20);
		getContentPane().add(speciesTextField);
		speciesTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setBounds(66, 171, 86, 20);
		getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		addPetDialogButton = new JButton("Submit");
		addPetDialogButton.setBounds(10, 227, 89, 23);
		getContentPane().add(addPetDialogButton);
		
		cancelPetDialogButton = new JButton("Cancel");
		cancelPetDialogButton.setBounds(185, 227, 89, 23);
		getContentPane().add(cancelPetDialogButton);
		
		typeComboBox = new JComboBox();
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Dog", "Cat", "Rabbit"}));
		typeComboBox.setBounds(66, 120, 86, 22);
		getContentPane().add(typeComboBox);
	}
	
	/**
	 * Returns whether the user submitted the dialog.
	 *
	 * @return true if the form was submitted, false otherwise
	 */
	public boolean isSubmitted() {
		return submitted;
	}
	
	/**
	 * Sets whether the dialog was submitted.
	 *
	 * @param submitted true if the form was submitted, false if canceled
	 */
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
	/**
	 * Gets the text field used for entering the pet's name.
	 *
	 * @return JTextField for the pet name
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * Gets the text field used for entering the pet's age.
	 *
	 * @return JTextField for the pet age
	 */
	public JTextField getAgeTextField() {
		return ageTextField;
	}
	
	/**
	 * Gets the text field used for entering the pet's species.
	 *
	 * @return JTextField for the pet species
	 */
	public JTextField getSpeciesTextField() {
		return speciesTextField;
	}

	/**
	 * Gets the text field used for entering the pet's ID.
	 *
	 * @return JTextField for the pet ID
	 */
	public JTextField getIdTextField() {
		return idTextField;
	}

	/**
	 * Gets the "Cancel" button used to close the dialog without submitting.
	 *
	 * @return JButton for canceling the form
	 */
	public JButton getCancelPetDialogButton() {
		return cancelPetDialogButton;
	}
	
	/**
	 * Gets the combo box for selecting the pet type (Dog, Cat, Rabbit).
	 *
	 * @return JComboBox for selecting the pet type
	 */
	public JComboBox getTypeComboBox() {
		return typeComboBox;
	}
	
	/**
	 * Gets the "Submit" button used to confirm the pet input.
	 *
	 * @return JButton for submitting the form
	 */
	public JButton getAddPetDialogButton() {
		return addPetDialogButton;
	}
}
