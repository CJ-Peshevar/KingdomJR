package combat.standalone;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import beijerinc.games.engine.GameLoop;
import beijerinc.games.engine.Library;
import beijerinc.games.ui.Screen;
import beijerinc.games.ui.forms.GameWindow;
import combat.BattleBoard;
import combat.BattleSize;

public class Program {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Initialize the library that contains the game building stuff.
					Library.initialize(Program.class);
					Screen.setWindowTitle("KingdomJR");
					Screen.setWidth(1024);
					Screen.setHeight(768);

					// A window for us to draw stuff in.
					GameWindow window = new GameWindow();

					// The game loop must be started after the window has been created to ensure we can draw.
					GameLoop.start();

					// Start everything up:
					GameLoop.register(new BattleBoard(BattleSize.Large));

					// Since we don't have a blocking call, we need to make sure we stop the game loop when
					// the window is closed.
					window.getFrame().addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
							GameLoop.stop();
			            }
			        });

					// NOTE: This is NOT a blocking call like it would be in C#, so whatever you call after
					// this is immediately executed after the window is shown.
					window.getFrame().setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}