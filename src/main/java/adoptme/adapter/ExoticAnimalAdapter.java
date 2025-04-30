package adoptme.adapter;
import adoptme.external.ExoticAnimal;
import adoptme.model.Pet;

/**
 * Adapter class that wraps an ExoticAnimal object to make it compatible with Pet
 */
public class ExoticAnimalAdapter  extends Pet{

	private ExoticAnimal exoticAnimal;
	
	/**
	 * Constructs the ExoticAnimalAdapter by translating field of ExoticAnimal to match the Pet constructor structure
	 * @param id			The id assigned to the pet
	 * @param name			The name assigned to the pet
	 * @param exoticAnimal	The ExoticAnimal object being adapted
	 */
	public ExoticAnimalAdapter(int id, String name, ExoticAnimal exoticAnimal) {
		super(id, exoticAnimal.getAnimalName(), exoticAnimal.getSubSpecies(), exoticAnimal.getYearsOld());
		this.exoticAnimal = exoticAnimal;
	}
	
	/**
	 * Returns ExoticAnimal instance before its adapted
	 * Used for accessing unconverted data for testing
	 * 
	 * @return the ExoticAnimal object
	 */
	 public ExoticAnimal getExoticAnimal() {
	        return exoticAnimal;
	    }

}
