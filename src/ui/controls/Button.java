package ui.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ui.Resources;

@SuppressWarnings("unused")
public class Button extends ControlBase {
	private Image normalImage;
	private Image lightImage;
	private Image darkImage;

	private List<ActionListener> clickListeners = new ArrayList<ActionListener>();

	public Button(String imageName, int x, int y, int width, int height){
		super(new Rectangle(x, y, width, height));

		normalImage = Resources.loadImageOrFallback("buttons", String.format("%s_Normal.png", imageName));
		lightImage = Resources.loadImageOrFallback("buttons", String.format("%s_Light.png", imageName));
		darkImage = Resources.loadImageOrFallback("buttons", String.format("%s_Dark.png", imageName));
	}

	@Override
	public void click(Point relativePoint) {
		notifyClick();
	}

	@Override
	public void Draw(Graphics g, Graphics2D g2d) {
		g.drawImage(isMouseOver ? lightImage : normalImage, bounds.x, bounds.y, bounds.width, bounds.height, null);
	}

	public void AddClickListener(ActionListener listener){
		clickListeners.add(listener);
	}

	public void RemoveClickListener(ActionListener listener){
		clickListeners.remove(listener);
	}

	private void notifyClick(){
		ActionEvent event = new ActionEvent(this, 0, "click");

		for (ActionListener listener : clickListeners){
			listener.actionPerformed(event);
		}
	}
}