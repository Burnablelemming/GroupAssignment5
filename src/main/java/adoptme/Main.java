package adoptme;

import javax.swing.SwingUtilities;

import adoptme.controller.PetController;
import adoptme.model.Pet;
import adoptme.model.Shelter;
import adoptme.view.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		// Main entry point for the application
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Shelter<Pet> petShelter = new Shelter<Pet>();
				MainWindow mainWindow = new MainWindow();
				PetController controller = new PetController(petShelter, mainWindow);
				mainWindow.setVisible(true);	
			}
		});
	}
}
