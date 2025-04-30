package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adoptme.model.Pet;
import adoptme.model.Shelter;
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
			// TODO Auto-generated method stub
			
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
