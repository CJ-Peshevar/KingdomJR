package combat;

import java.awt.Image;

import beijerinc.games.engine.interfaces.GameComponent;
import beijerinc.games.graphics.interfaces.IGraphics;

// Will be abstract later.
public class Unit extends GameComponent {
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
	public void update(double delta) {
	}
	
	@Override
	public void draw(IGraphics g) {
		g.drawImage(unitImage, x, y, width, height, null);
	}
}
