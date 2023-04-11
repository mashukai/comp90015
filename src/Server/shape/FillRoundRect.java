package Server.shape;

import java.awt.*;

public class FillRoundRect extends Shape {
	// This function will draw a filled round corner rectangle
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setPaint(new Color(R, G, B));
		g2d.setStroke(new BasicStroke(stroke));
		g2d.fillRoundRect(Math.min(x1, x2), Math.min(y2, y2),
				Math.abs(x1 - x2), Math.abs(y1 - y2), 50, 35);
	}
}
