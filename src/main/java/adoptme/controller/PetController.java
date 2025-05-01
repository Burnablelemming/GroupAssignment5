package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import adoptme.model.Cat;
import adoptme.model.Dog;
import adoptme.model.Pet;
import adoptme.model.Rabbit;
import adoptme.model.Shelter;
import adoptme.view.AddPetDialog;
import adoptme.view.MainWindow;

public class PetController {
	
	private Shelter<Pet> model;
	private MainWindow view;
	
	public PetController(Shelter<Pet> model, MainWindow view) {
		this.model = model;
		this.view = view;
		
		this.view.getAdoptPetButton().addActionListener(new AdoptPetButtonListener());
		this.view.getAddPetButton().addActionListener(new AddPetButtonListener());
		this.view.getRemovePetButton().addActionListener(new RemovePetButtonListener());
		this.view.getViewPetButton().addActionListener(new ViewPetButtonListener());
		this.view.getSaveShelterButton().addActionListener(new SaveShelterButtonListener());
	}
	
	private class AdoptPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class AddPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AddPetDialog dialog = new AddPetDialog(view);
			AddPetDialogController dialogController = new AddPetDialogController(dialog);
			
			dialog.setVisible(true);
			
			if(dialog.isSubmitted()) {
				System.out.println("Submitted is true");
				// Pet attributes
				String name = dialog.getNameTextField().getText();
				Integer age = Integer.parseInt(dialog.getAgeTextField().getText());
				String type = dialog.getTypeComboBox().getSelectedItem().toString();
				String species = dialog.getSpeciesTextField().getText();
				Integer id = Integer.parseInt(dialog.getIdTextField().getText());
				
				Pet pet = null;
				
				switch(type) {
				
				case "Dog":
					pet = new Dog(id, name, species, age);
					break;
				
				case "Cat":
					pet = new Cat(id, name, species, age);
					break;
					
				case "Rabbit":
					pet = new Rabbit(id, name, species, age);
					break;
				
				// Just in case there is an invalid pet selected
				default:
					JOptionPane.showMessageDialog(null, "Unknown pet type: " + type);
				}
				
				System.out.println(pet.toString());
				model.addPet(pet);
				System.out.println(model.getAllPets().toString());
				
			}
			
		}
		
	}
	
	private class RemovePetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ViewPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class SaveShelterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
