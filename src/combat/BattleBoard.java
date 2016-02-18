package combat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import crayon.iDraw;

//Will control.
public class BattleBoard implements iDraw {
	private Grid leftGrid;
	private Grid rightGrid;
	
	public BattleBoard(){
		leftGrid = new Grid(3, 3);
		rightGrid = new Grid(3, 3);
	}
	
	public void charge(){
		// Will charge units forward. Attack!
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		g.setColor(Color.cyan);
		g.fillRect(10, 10, 50, 50);
		
		leftGrid.Draw(g, g2d);
		rightGrid.Draw(g, g2d);
	}
}
