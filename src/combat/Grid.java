package combat;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import crayon.iDraw;
import ui.Resources;
import ui.Screen;

//should only be programmed on how to move units within it's own
//grid and how those units interact with each other.
public class Grid implements iDraw {
	private int gridX;
	private int gridY;
	private int gridWidth;
	private int gridHeight;
	private int width;
	private int height;
	
	private Backline backline;
	private Unit[][] units;
	private Image gridImage;
	
	public Grid(Side side, BattleSize size){
		gridWidth = size.GetGridPixelWidth();
		gridHeight = size.GetGridPixelHeight();
		width = size.GetGridWidth();
		height = size.GetGridHeight();

		switch (side) {
		case Left:
			gridX = size.GetBacklineHorizontalOffset();
			break;
		case Right:
			gridX = Screen.WIDTH_2 - width * gridWidth - size.GetBacklineHorizontalOffset();
			break;
		}

		gridY = (Screen.HEIGHT_2 - (height * gridHeight)) / 2;
		
		backline = new Backline(side, size);
		units = new Unit[width][height];
		gridImage = Resources.loadImageOrFallback("grids", "Grid_Plain_Normal.png");
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		backline.Draw(g, g2d);
		
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				g.drawImage(gridImage, gridX + x * gridWidth, gridY + y * gridHeight, gridWidth, gridHeight, null);

				if (units[x][y] != null){
					units[x][y].Draw(g, g2d);
				}
			}
		}
	}
}
