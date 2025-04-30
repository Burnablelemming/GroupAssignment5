package adoptme;

import javax.swing.SwingUtilities;

import adoptme.view.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				MainWindow mainWindow = new MainWindow();
				mainWindow.setVisible(true);	
			}
		});
	}
}
