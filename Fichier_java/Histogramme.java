import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Histogramme extends JPanel {
    
	private int width, height, taille;
	private int laps[];
	
	public Histogramme(int nbMois, long nbLapin[]) {
		this.taille = nbMois+1;
		this.height = 0;
		laps = new int[taille];
		for(int j = 0; j < taille; j++){
			laps[j] = (int) nbLapin[j];
		}
		
		histog();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int j = 0; j < taille; j++){
			height = laps[j];
			g.setColor(new Color(0,0,0));
			g.drawRect(width, 0, 20, height);
			width = width + 20;
		}
	}

	public void histog() {
		JFrame frame = new JFrame("Rectangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(600, 10000);
		frame.setVisible(true);
		
		JPanel cellule[] = new JPanel[taille];
		for(int j = 0; j < taille; j++){
			cellule[j] = new JPanel();
			cellule[j].setSize(20, height);
		}
	}
}
