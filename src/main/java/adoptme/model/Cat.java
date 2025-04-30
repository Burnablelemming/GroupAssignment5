package adoptme.model;

/**
 * Represents a cat in the pet adoption system
 * Extends Pet
 */
public class Cat extends Pet{

	/**
	 * Constructs a new Cat instance
	 * 
	 * @param id		unique id for the cat
	 * @param name		name of cat
	 * @param species	species of cat
	 * @param age		age of cat
	 */
	public Cat(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

}
