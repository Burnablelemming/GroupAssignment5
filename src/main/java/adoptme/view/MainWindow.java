package adoptme.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MainWindow extends JFrame {
	
	private JPanel panel;
	
	
	public MainWindow() {
		setTitle("Adopt Me Program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(39, 49, 220, 239);
		panel.add(list);
		
		JLabel petListLabel = new JLabel("Pet Shelter");
		petListLabel.setBounds(102, 17, 104, 29);
		panel.add(petListLabel);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Age", "Species"}));
		sortComboBox.setBounds(269, 49, 106, 22);
		panel.add(sortComboBox);
		
		JButton adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(269, 96, 104, 23);
		panel.add(adoptPetButton);
		
		JButton addPetButton = new JButton("Add Pet");
		addPetButton.setBounds(269, 130, 106, 23);
		panel.add(addPetButton);
		
		JButton removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(269, 164, 106, 23);
		panel.add(removePetButton);
		
		JButton viewPetButton = new JButton("View Pet");
		viewPetButton.setBounds(269, 198, 106, 23);
		panel.add(viewPetButton);
		
		JButton saveShelterButton = new JButton("Save Shelter");
		saveShelterButton.setBounds(269, 232, 106, 23);
		panel.add(saveShelterButton);
		
		JLabel sortLabel = new JLabel("Sort by: ");
		sortLabel.setBounds(299, 24, 46, 14);
		panel.add(sortLabel);
	}
}
