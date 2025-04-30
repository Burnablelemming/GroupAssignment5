package adoptme.model;

import java.util.Comparator;

/**
 * Comparator implementation for sorting Pet objects by age
 */
public class AgeComparator implements Comparator<Pet>{

	/**
     * Compares two pets based on their age.
     *
     * @param o1 the first Pet to compare
     * @param o2 the second Pet to compare
     * @return a negative integer if o1 is younger than o2,
     *         zero if they are the same age,
     *         or a positive integer if o1 is older than o2
     */
	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
