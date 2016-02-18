package combat;

import java.awt.Graphics;
import java.awt.Graphics2D;

import crayon.iDraw;

//should only be programmed on how to move units within it's own
//grid and how those units interact with each other.
public class Grid implements iDraw {
	private int width;
	private int height;
	private Backline backline;
	private Unit[][] units;
	
	public Grid(int width, int height){
		backline = new Backline();
		units = new Unit[width][height];
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		backline.Draw(g, g2d);
		
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				units[x][y].Draw(g, g2d);
			}
		}
	}
}
