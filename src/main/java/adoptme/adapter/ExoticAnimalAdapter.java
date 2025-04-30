package adoptme.adapter;
import adoptme.external.ExoticAnimal;
import adoptme.model.Pet;


public class ExoticAnimalAdapter  extends Pet{

	private ExoticAnimal exoticAnimal;
	
	
	public ExoticAnimalAdapter(int id, String name, ExoticAnimal exoticAnimal) {
		super(id, exoticAnimal.getAnimalName(), exoticAnimal.getSubSpecies(), exoticAnimal.getYearsOld());
		this.exoticAnimal = exoticAnimal;
	}
	
	 public ExoticAnimal getExoticAnimal() {
	        return exoticAnimal;
	    }

}
