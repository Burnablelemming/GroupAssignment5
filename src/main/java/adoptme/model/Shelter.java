package adoptme.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelter<T extends Pet> {

	private List<T> pets;
	
	public Shelter() {
        pets = new ArrayList<>();
    }

    public void addPet(T pet) {
        pets.add(pet);
    }

    public void removePet(T pet) {
        pets.remove(pet);
    }

    public List<T> getAllPets() {
        return new ArrayList<>(pets);
    }

    public void clear() {
        pets.clear();
    }

    public void sortByName() {
        Collections.sort(pets);
    }

    public void sortByAge() {
    	pets.sort(new AgeComparator());
    }

    public void sortBySpecies() {
    	pets.sort(new SpeciesComparator());
    }
}
