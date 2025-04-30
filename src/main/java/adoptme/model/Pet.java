package adoptme.model;

public abstract class Pet implements Comparable<Pet> {
	private int id;
    private String name;
    private String species;
    private int age;
    private boolean adopted;
    
    public Pet(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.adopted = false;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getSpecies() {
    	return species;
    }
    
    public int getAge() { 
    	return age;
    }
    
    public void adopt() {
        this.adopted = true;
    }
    
    public boolean isAdopted() {
    	return adopted;
    }
    
    @Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }
    
    @Override
    public String toString() {
        return name + " (" + species + ", " + age + " years old)";
    }
}
