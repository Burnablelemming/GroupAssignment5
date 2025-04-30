package adoptme.model;

/**
 * Abstract parent class representing a pet in the adoption system.
 * All pets have ID, name, species, age, and adoption status
 */
public abstract class Pet implements Comparable<Pet> {
	private int id;
    private String name;
    private String species;
    private int age;
    private boolean adopted;
    
    /**
     * Constructs a new Pet
     * 
     * @param id		ID of pet
     * @param name		name of pet
     * @param species	species of pet
     * @param age		age of pet
     */
    public Pet(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.adopted = false;
    }
    
    /**
     * Returns a pets ID
     * 
     * @return	the ID of pet
     */
    public int getId() {
    	return id;
    }
    
    /**
     * Returns the name of pet
     * 
     * @return	name of pet
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Returns the species of pet
     * 
     * @return	species of pet
     */
    public String getSpecies() {
    	return species;
    }
    
    /**
     * Returns the age of pet
     * 
     * @return	age of pet
     */
    public int getAge() { 
    	return age;
    }
    
    /**
     * Sets the pets adoption status as adopted
     */
    public void adopt() {
        this.adopted = true;
    }
    
    /**
     * Returns whether or not a pet has been adopted
     * 
     * @return	adoption status of pet
     */
    public boolean isAdopted() {
    	return adopted;
    }
    
    /**
     * Compares two pets to each other based off of name
     * Not case sensitive
     */
    @Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }
    
    /**
     * Simply string representation of a pet
     * Returns name: [species, age years old]
     */
    @Override
    public String toString() {
        return name + ": [" + species + ", " + age + " years old]";
    }
}
