package combat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import crayon.iDraw;
import ui.Resources;
import ui.Screen;

//where King is located
public class Backline implements iDraw {
	private Image queenImage;
	private int x;
	private int y;
	private int width = 50;
	private int height = 64;
	private int maxHealth=3;
	private int currentHealth=maxHealth;

	public Backline(Side side, BattleSize size){
		// Load princess
		queenImage = Resources.loadImage("Queen.jpg");

		width = size.GetBacklineWidth();
		height = 264 / (200 / width);

		switch (side) {
		case Left:
			x = 0;
			break;
		case Right:
			x = Screen.WIDTH_2 - width;
			break;
		}

		y = (Screen.HEIGHT_2 - height) / 2;
	}

	public void Hit(int hitpoints){
		currentHealth -= hitpoints;
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		// draw image
		g.drawImage(queenImage, x, y, width, height, null);
	}
}
