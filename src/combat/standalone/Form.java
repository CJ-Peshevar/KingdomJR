package combat.standalone;

import javax.swing.JFrame;

import combat.BattleBoard;
import ui.Screen;
import ui.controls.PaintPanel;

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
		
		// Start everything up:
		panel.addDrawable(new BattleBoard());
	}
}