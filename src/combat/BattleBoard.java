package combat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crayon.iDraw;
import ui.controls.Button;

//Will control.
public class BattleBoard implements iDraw {
	private Grid leftGrid;
	private Grid rightGrid;

	private boolean isCharging;
	private Button chargeButton = new Button("PlainButton", 50, 630, 200, 50);

	public BattleBoard(){
		leftGrid = new Grid(3, 3);
		rightGrid = new Grid(3, 3);

		// Setting the button as active will cause it to be drawn and receive user input.
		chargeButton.setIsActive(true);
		chargeButton.AddClickListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				charge();
			}
		});
	}

	public void charge(){
		// Will charge units forward. Attack!
		isCharging = true;
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		g.setColor(Color.cyan);
		g.fillRect(10, 10, 50, 50);

		leftGrid.Draw(g, g2d);
		rightGrid.Draw(g, g2d);

		// We have to draw the button ourselves. This also determines drawing order / overlapping.
		chargeButton.Draw(g, g2d);

		if (isCharging){
			g.drawString("Will charge units forward. Attack!", 60, 660);
		}
	}
}