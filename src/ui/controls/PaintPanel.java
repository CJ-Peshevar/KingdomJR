package ui.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import crayon.iDraw;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1276408633985928729L;
	
	private Timer repaintTimer;
	private List<iDraw> drawables = new ArrayList<iDraw>();

	public PaintPanel(){
		repaintTimer = new Timer(16, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		repaintTimer.start();
	}

	public void addDrawable(iDraw drawable){
		drawables.add(drawable);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// It's actually a Graphics2D, because it's 2D, and we need some special properties on this thing.
		Graphics2D g2d = (Graphics2D)g;

		// Make it look smooth.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the active drawables.
		for (iDraw drawable : drawables){
			//if (drawable.getIsActive())
			{
				drawable.Draw(g, g2d);
			}
		}
	}
}