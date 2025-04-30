package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import adoptme.view.AddPetDialog;

public class AddPetDialogController {
	
	private AddPetDialog dialog;
	
	public AddPetDialogController(AddPetDialog dialog) {
		this.dialog = dialog;
		this.dialog.getAddPetDialogButton().addActionListener(new AddPetDialogButtonListener());
		this.dialog.getCancelPetDialogButtong().addActionListener(new CancelPetDialogButtonListener());
	}
	
	private class AddPetDialogButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = dialog.getName();
			String ageStr = dialog.getPetAge();
			
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(dialog, "Name cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
                Integer parsedAge = Integer.parseInt(ageStr);
                if (parsedAge < 0) {
                    JOptionPane.showMessageDialog(dialog, "Age must be a non-negative number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
			
			dialog.setSubmitted(true);
			dialog.setVisible(false);
		}
	}
	
	private class CancelPetDialogButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.setSubmitted(false);
			dialog.setVisible(false);
			
		}
	}
}
