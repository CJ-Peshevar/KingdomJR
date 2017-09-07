package combat;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import crayon.iDraw;

// Will be abstract later.
public class Unit implements iDraw {
	private UnitType type;
	private Image unitImage;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Unit(UnitType type, BattleSize size, int x, int y) {
		this.type = type;
		unitImage = type.GetBadgeIcon();
		width = size.GetUnitWidth();
		height = size.GetUnitHeight();
	}
	
	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		g.drawImage(unitImage, x, y, width, height, null);
	}

}
