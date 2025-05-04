package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import adoptme.adapter.ExoticAnimalAdapter;
import adoptme.adapter.RuntimeTypeAdapterFactory;
import adoptme.external.ExoticAnimal;
import adoptme.model.Cat;
import adoptme.model.Dog;
import adoptme.model.Pet;
import adoptme.model.Rabbit;
import adoptme.model.Shelter;
import adoptme.view.AddPetDialog;
import adoptme.view.MainWindow;
import adoptme.view.ViewPetDialog;

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
		this.view.getSortComboBox().addActionListener(new SortShelterComboBoxListener());
		
		initializeShelter();
	}
	
	// Initialize the Shelter
	public void initializeShelter() {
		
		 // Register RuntimeTypeAdapterFactory for polymorphic Pet deserialization
	    RuntimeTypeAdapterFactory<Pet> petAdapterFactory = RuntimeTypeAdapterFactory
	        .of(Pet.class, "type")
	        .registerSubtype(Dog.class, "Dog")
	        .registerSubtype(Cat.class, "Cat")
	        .registerSubtype(Rabbit.class, "Rabbit");

	    Gson gson = new GsonBuilder()
	        .registerTypeAdapterFactory(petAdapterFactory)
	        .create();
		
		try (FileReader reader = new FileReader("src/main/resources/pets.json")) {
		    Type petListType = new TypeToken<List<Pet>>() {}.getType();
		    List<Pet> pets = gson.fromJson(reader, petListType);

		    for (Pet pet : pets) {
		        model.addPet(pet);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (FileReader reader = new FileReader("src/main/resources/exotic_animals.json")) {
            Type exoticType = new TypeToken<List<ExoticAnimal>>() {}.getType();
            List<ExoticAnimal> exoticPets = gson.fromJson(reader, exoticType);
            
            for (ExoticAnimal exotic : exoticPets) {
            	String rawId = exotic.getUniqueId();
            	int id = Integer.parseInt(rawId.replaceAll("\\D+", ""));
                model.addPet(new ExoticAnimalAdapter(id, exotic.getAnimalName(), exotic));  // Use adapter class
            }
            
        } catch (Exception e) {
            System.err.println("Failed to load exoticpets.json");
            e.printStackTrace();
        }
		
		updateList();
	}
	
	public void updateList() {
		
		// Sort list on update
		String selected = (String) view.getSortComboBox().getSelectedItem();
		
		switch (selected) {
		
		case "Name":
			model.sortByName(); 
			break;
		
		case "Age":
			model.sortByAge();
			break;
			
		case "Species":
			model.sortBySpecies();
			break;
		}
		
		DefaultListModel<Pet> listModel = new DefaultListModel<>();
		
		for (Pet pet : model.getAllPets()) {
			listModel.addElement(pet);
		}
		
		view.getPetList().setModel(listModel);
	}
	
	private class SortShelterComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String selected = (String) view.getSortComboBox().getSelectedItem();
			
			switch (selected) {
			
			case "Name":
				model.sortByName();
				break;
			
			case "Age":
				model.sortByAge();
				break;
				
			case "Species":
				model.sortBySpecies();
				break;
			}
			
			updateList();
		}
		
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
				
				updateList();
				
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
			ViewPetDialog dialog = new ViewPetDialog();
			
			
			
			dialog.setVisible(true);
			
		}
		
	}
	
	private class SaveShelterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
