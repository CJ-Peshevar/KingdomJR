package combat;

import java.awt.Image;

import beijerinc.games.engine.Resources;
import beijerinc.games.engine.interfaces.GameComponent;
import beijerinc.games.graphics.interfaces.IGraphics;
import ui.Screen;

//where King is located
public class Backline extends GameComponent {
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
	public void update(double delta) {
	}

	@Override
	public void draw(IGraphics g) {
		// draw image
		g.drawImage(queenImage, x, y, width, height, null);
	}
}
