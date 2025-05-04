package adoptme.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A generic shelter class that manages a list of pets
 * List can only hold Pet and its subclasses
 * Extends Pet
 * 
 * @param <T>	type of pet shelter list (Pet)
 */
public class Shelter<T extends Pet> {

	private List<T> pets;
	
	/**
	 * Constructs empty shelter
	 */
	public Shelter() {
        pets = new ArrayList<>();
    }

	/**
	 * Adds a pet to the shelter
	 * 
	 * @param pet	the pet being added
	 */
    public void addPet(T pet) {
        pets.add(pet);
    }

    /**
     * Removes a pet from shelter
     * 
     * @param pet	the pet being removed
     */
    public void removePet(T pet) {
        pets.remove(pet);
    }

    /**
     * Returns copy of all pets in shelter
     * 
     * @return	new list of all pets in shelter
     */
    public List<T> getAllPets() {
        return pets;
    	//return new ArrayList<>(pets);
    }

    /**
     * Clears all pets from shelter
     */
    public void clear() {
        pets.clear();
    }

    /**
     * Sorts pets in shelter by name using default comparable method
     */
    public void sortByName() {
        Collections.sort(pets);
    }

    /**
     * Sorts pets in the shelter by age using AgeComparator
     */
    public void sortByAge() {
    	pets.sort(new AgeComparator());
    }

    /**
     * Sorts pets in the shelter by species using SpeciesComparator
     */
    public void sortBySpecies() {
    	pets.sort(new SpeciesComparator());
    }
}
