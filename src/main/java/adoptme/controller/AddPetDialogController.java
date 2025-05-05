package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import adoptme.view.AddPetDialog;

/**
 * Controller for the AddPetDialog. Handles form validation and submission logic
 * for adding a new pet to the shelter. Connects button actions in the dialog
 * to input checks and user feedback.
 */
public class AddPetDialogController {
	
	private AddPetDialog dialog;
	
	/**
	 * Constructs a controller for the given AddPetDialog.
	 * Adds action listeners to handle submit and cancel events.
	 *
	 * @param dialog the AddPetDialog instance this controller manages
	 */
	public AddPetDialogController(AddPetDialog dialog) {
		this.dialog = dialog;
		this.dialog.getAddPetDialogButton().addActionListener(new AddPetDialogButtonListener());
		this.dialog.getCancelPetDialogButton().addActionListener(new CancelPetDialogButtonListener());
	}
	
	/**
	 * Handles the logic when the "Submit" button is clicked.
	 * Validates that all fields are filled in and that age and ID are valid integers.
	 * If validation passes, the dialog is marked as submitted and closed.
	 */
	private class AddPetDialogButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = dialog.getNameTextField().getText();
			String ageStr = dialog.getAgeTextField().getText();
			String species = dialog.getSpeciesTextField().getText();
			String idStr = dialog.getIdTextField().getText();
			
			if(name.isBlank() || ageStr.isBlank() || species.isBlank() || idStr.isBlank()) {
				JOptionPane.showMessageDialog(dialog, "Pet attributes cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				
                Integer parsedAge = Integer.parseInt(ageStr);
                Integer parsedId = Integer.parseInt(idStr);
                
                if (parsedAge < 0 || parsedId < 0) {
                    JOptionPane.showMessageDialog(dialog, "Age or ID must be a non-negative number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Age or ID must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
			
			dialog.setSubmitted(true);
			System.out.println("Input is valid");
			dialog.setVisible(false);
		}
	}
	
	/**
	 * Handles the logic when the "Cancel" button is clicked.
	 * Clears the input fields, marks the dialog as not submitted, and closes it.
	 */
	private class CancelPetDialogButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearTextFields();
			dialog.setSubmitted(false);
			dialog.setVisible(false);	
		}
	}
	
	/**
	 * Clears all text fields in the dialog.
	 * Called when the cancel button is pressed.
	 */
	public void clearTextFields() {
		dialog.getNameTextField().setText("");
		dialog.getAgeTextField().setText("");
		dialog.getSpeciesTextField().setText("");
		dialog.getIdTextField().setText("");
	}
}
