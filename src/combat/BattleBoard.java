package combat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import beijerinc.games.engine.interfaces.GameComponent;
import beijerinc.games.graphics.interfaces.IGraphics;
import beijerinc.games.ui.controls.Button;

//Will control.
public class BattleBoard extends GameComponent {
	private Grid leftGrid;
	private Grid rightGrid;

	private boolean isCharging;
	private Button chargeButton = new Button("PlainButton", 50, 630, 200, 50);

	public BattleBoard(BattleSize gridSize){
		leftGrid = new Grid(Side.Left, gridSize);
		rightGrid = new Grid(Side.Right, gridSize);

		// Setting the button as active will cause it to be drawn and receive user input.
		chargeButton.setIsActive(true);
		chargeButton.addClickListener(new ActionListener(){
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
	public void update(double delta) {
	}

	@Override
	public void draw(IGraphics g) {
		g.setColor(Color.cyan);
		g.fillRect(10, 10, 50, 50);

		leftGrid.draw(g);
		rightGrid.draw(g);

		// We have to draw the button ourselves. This also determines drawing order / overlapping.
		chargeButton.draw(g);

		if (isCharging){
			g.drawString("Will charge units forward. Attack!", 60, 660);
		}
	}
}