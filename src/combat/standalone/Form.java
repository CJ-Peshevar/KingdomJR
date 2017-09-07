package combat.standalone;

import javax.swing.JFrame;

import combat.BattleBoard;
import combat.BattleSize;
import ui.Screen;
import ui.controls.PaintPanel;
import ui.ControlInputHandler;

import java.awt.BorderLayout;

public class Form {
	private JFrame frame;

	public JFrame getFrame(){
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, Screen.WIDTH, Screen.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PaintPanel panel = new PaintPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		// Set up the controllers/handlers.
		ControlInputHandler controlHandler = new ControlInputHandler();
		panel.addMouseListener(controlHandler);
		panel.addMouseMotionListener(controlHandler);

		// Start everything up:
		panel.addDrawable(new BattleBoard(BattleSize.Large));
	}
}