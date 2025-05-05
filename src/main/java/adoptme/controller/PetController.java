package adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
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

/**
 * The PetController class acts as the controller in the MVC architecture. 
 * It connects the Shelter model with the MainWindow view, sets up event listeners,
 * and handles loading, displaying, modifying, and saving pet data.
 */
public class PetController {
	
	// Model and view used by the controller
	private Shelter<Pet> model;
	private MainWindow view;
	
	/**
	 * Constructs a PetController that binds the model and view, sets up UI event listeners,
	 * and loads pet data from JSON files into the shelter.
	 * 
	 * @param model	the Shelter model containing pets
	 * @param view	the main GUI window of the application
	 */
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
	
	/**
	 * Initializes the shelter by loading pet data from pets.json and exotic_animals.json.
	 * Uses Gson and the RuntimeTypeAdapterFactory to deserialize Pet data.
	 * Exotic animals are adapted into Pets using ExoticAnimalAdapter.
	 */
	public void initializeShelter() {
		
		 // Register RuntimeTypeAdapterFactory for building the Gson
	    RuntimeTypeAdapterFactory<Pet> petAdapterFactory = RuntimeTypeAdapterFactory
	        .of(Pet.class, "type")
	        .registerSubtype(Dog.class, "Dog")
	        .registerSubtype(Cat.class, "Cat")
	        .registerSubtype(Rabbit.class, "Rabbit");

	    Gson gson = new GsonBuilder()
	        .registerTypeAdapterFactory(petAdapterFactory)
	        .create();
		
	    // Create regular pets
		try (FileReader reader = new FileReader("src/main/resources/pets.json")) {
		    Type petListType = new TypeToken<List<Pet>>() {}.getType();
		    List<Pet> pets = gson.fromJson(reader, petListType);

		    for (Pet pet : pets) {
		        model.addPet(pet);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Read and convert Exotic pets here
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
	
	/**
	 * Updates the pet list in the view by retrieving all pets from the model, 
	 * sorting them based on the selected sort type, and populating the JList.
	 */
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
		
		// Make new ListModel and populate with updated, properly sorted Pet list
		DefaultListModel<Pet> listModel = new DefaultListModel<>();
		
		for (Pet pet : model.getAllPets()) {
			listModel.addElement(pet);
		}
		
		view.getPetList().setModel(listModel);
	}
	
	/**
	 * Handles sorting the shelter when the sort combo box is changed.
	 * Sorts by name, age, or species depending on the selected item.
	 */
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
	
	/**
	 * Handles adopting a selected pet from the list.
	 * Marks the pet as adopted and displays a confirmation dialog.
	 * Shows an error if no pet is selected or if the pet is already adopted.
	 */
	private class AdoptPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet pet = view.getPetList().getSelectedValue();
			
			if(pet != null) {
				if(pet.isAdopted()) {
					JOptionPane.showMessageDialog(view, "Pet is already adopted!", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					pet.adopt();
					JOptionPane.showMessageDialog(view, pet.getName() + " has successfully been adopted", "Success", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			// No pet selected
			JOptionPane.showMessageDialog(view, "Please select a pet to adopt.", "Input Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	/**
	 * Handles opening the AddPetDialog and adding a new pet to the shelter
	 * if the form submitted is valid. Also supports multiple pet types (Dog, Cat, Rabbit).
	 */
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
				
				// Debugging print statements
				//System.out.println(pet.toString());
				model.addPet(pet);
				//System.out.println(model.getAllPets().toString());
				
				updateList();
				
			}
			
		}
		
	}
	
	/**
	 * Handles removing a selected pet from the list.
	 * Displays a successful dialog removal and updates list.
	 * Displays an error dialog if no pet was selected.
	 */
	private class RemovePetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet removePet = view.getPetList().getSelectedValue();
			
			if (removePet != null) {
				model.getAllPets().remove(removePet);
				updateList();
				JOptionPane.showMessageDialog(view, removePet.getName() + " has successfully been removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(view, "Please select a pet to remove.", "Input Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Handles viewing the details of a selected pet in a pop-up dialog.
	 * Displays all relevant pet fields (name, age, species, ID, adopted status).
	 */
	private class ViewPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Get the selected pet
			Pet viewPet = view.getPetList().getSelectedValue();
			
			if (viewPet != null) {
				ViewPetDialog dialog = new ViewPetDialog();
				dialog.getNameLabel().setText(viewPet.getName());
				dialog.getAgeLabel().setText(String.valueOf(viewPet.getAge()));
				dialog.getSpeciesLabel().setText(viewPet.getSpecies());
				dialog.getIdLabel().setText(String.valueOf(viewPet.getId()));
				dialog.getAdoptedLabel().setText(viewPet.isAdopted() ? "True" :"False");
				dialog.setVisible(true);
				return;
			}
			JOptionPane.showMessageDialog(view, "Please select a pet to view.", "Input Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Handles saving the current Pet list to a time stamped JSON file using Gson.
	 * Uses RuntimeTypeAdapterFactory to preserve type information.
	 */
	private class SaveShelterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RuntimeTypeAdapterFactory<Pet> petAdapterFactory = RuntimeTypeAdapterFactory
			        .of(Pet.class, "type")
			        .registerSubtype(Dog.class, "Dog")
			        .registerSubtype(Cat.class, "Cat")
			        .registerSubtype(Rabbit.class, "Rabbit")
					.registerSubtype(ExoticAnimalAdapter.class, "Exotic");
			Gson gson = new GsonBuilder()
		        .registerTypeAdapterFactory(petAdapterFactory)
		        .setPrettyPrinting()
		        .create();
			
			// Create file time stamp
			String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
			String filename = "src/main/resources/" + timestamp + "_pets.json";
			
			try (FileWriter writer = new FileWriter(filename)){
				gson.toJson(model.getAllPets(), writer);
				JOptionPane.showMessageDialog(view, "Shelter saved as " + filename, "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(view, "Failed to save shelter.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
