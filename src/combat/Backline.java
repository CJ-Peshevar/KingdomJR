package combat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import crayon.iDraw;
import ui.Resources;

//where King is located
public class Backline implements iDraw {
	private Image queenImage;
	private int maxHealth=3;
	private int currentHealth=maxHealth;
	
	public Backline(){
		// Load princess
		queenImage = Resources.loadImage("Queen.jpg");
	}
	
	public void Hit(int hitpoints){
		currentHealth -= hitpoints;
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		// draw image
		g.drawImage(queenImage, 200, 200, null);
	}
	
}
