package adoptme.external;

/**
 * Third party ExoticAnimal class
 * Does not follow the structure of Pet
 * Class is unmodifiable and is going to be adapted with ExoticAnimalAdapter
 */
public class ExoticAnimal {
	
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;
    
    /**
     * No arg constructor for Gson
     */
    public ExoticAnimal() {
    }

    /**
     * Returns ID of exotic animal
     * 
     * @return	exotic animal ID
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Returns the name of the exotic animal
     * 
     * @return	exotic animal name
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Returns the category of the exotic animal
     * 
     * @return	exotic animal category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the subspecies of the exotic animal
     * 
     * @return	exotic subspecies
     */
    public String getSubSpecies() {
        return subSpecies;
    }

    /**
     * Returns the age of the exotic animal in years
     * 
     * @return int age
     */
    public int getYearsOld() {
        return yearsOld;
    }
}
