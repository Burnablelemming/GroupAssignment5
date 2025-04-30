package adoptme.model;

/**
 * Represents a rabbit in the pet adoption system
 * Extends Pet
 */
public class Rabbit extends Pet{

	/**
	 * Constructs a new Rabbit
	 * 
	 * @param id		ID of rabbit
	 * @param name		name of rabbit
	 * @param species	species of rabbit
	 * @param age		age of rabbit
	 */
	public Rabbit(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

}
