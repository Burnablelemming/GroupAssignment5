package adoptme.model;

import java.util.Comparator;

/**
 * Comparator implementation for sorting Pet objects by species
 */
public class SpeciesComparator implements Comparator<Pet> {
		
	 /**
     * Compares two pets based on their species name alphabetically
     * Not case sensitive
     *
     * @param o1 the first Pet to compare
     * @param o2 the second Pet to compare
     * @return a negative integer if o1 species comes before o2
     *         zero if they are equal,
     *         or a positive integer if o1 species comes after o2
     */
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}
}
