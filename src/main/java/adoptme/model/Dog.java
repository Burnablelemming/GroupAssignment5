package adoptme.model;

/**
 * Represents a dog in the pet adoption system.
 * Extends Pet
 */
public class Dog extends Pet{

	/**
	 * Constructs a new Dog instance
	 * 
	 * @param id		ID of the dog
	 * @param name		name of the dog
	 * @param species	species of the dog
	 * @param age		age of dog
	 */
	public Dog(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

}
