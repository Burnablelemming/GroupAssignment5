package adoptme.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import adoptme.model.Pet;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame {
	
	private JPanel panel;
	private JList<Pet> petList;
	private JLabel petListLabel;
	private JComboBox<String> sortComboBox;
	private JButton adoptPetButton;
	private JButton addPetButton;
	private JButton removePetButton;
	private JButton viewPetButton;
	private JButton saveShelterButton;
	private JLabel sortLabel;

	public MainWindow() {
		setTitle("Adopt Me Program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		petList = new JList<Pet>();
		petList.setBounds(39, 49, 220, 239);
		panel.add(petList);
		
		petListLabel = new JLabel("Pet Shelter");
		petListLabel.setBounds(102, 17, 104, 29);
		panel.add(petListLabel);
		
		sortComboBox = new JComboBox<String>();
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Age", "Species"}));
		sortComboBox.setBounds(269, 49, 106, 22);
		panel.add(sortComboBox);
		
		adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(269, 96, 104, 23);
		panel.add(adoptPetButton);
		
		addPetButton = new JButton("Add Pet");
		addPetButton.setBounds(269, 130, 106, 23);
		panel.add(addPetButton);
		
		removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(269, 164, 106, 23);
		panel.add(removePetButton);
		
		viewPetButton = new JButton("View Pet");
		viewPetButton.setBounds(269, 198, 106, 23);
		panel.add(viewPetButton);
		
		saveShelterButton = new JButton("Save Shelter");
		saveShelterButton.setBounds(269, 232, 106, 23);
		panel.add(saveShelterButton);
		
		sortLabel = new JLabel("Sort by: ");
		sortLabel.setBounds(299, 24, 46, 14);
		panel.add(sortLabel);
	}
	
	public JList<Pet> getPetList() {
		return petList;
	}
	
	public JComboBox<String> getSortComboBox(){
		return sortComboBox;
	}
	public JButton getAdoptPetButton() {
		return adoptPetButton;
	}

	public JButton getAddPetButton() {
		return addPetButton;
	}

	public JButton getRemovePetButton() {
		return removePetButton;
	}

	public JButton getViewPetButton() {
		return viewPetButton;
	}

	public JButton getSaveShelterButton() {
		return saveShelterButton;
	}
}
