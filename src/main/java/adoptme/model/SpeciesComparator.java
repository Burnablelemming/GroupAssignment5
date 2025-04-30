package adoptme.model;

import java.util.Comparator;

public class SpeciesComparator implements Comparator<Pet> {
		
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}
}
