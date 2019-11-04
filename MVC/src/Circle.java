import java.awt.Graphics;

public class Circle extends Ellipse {
	
	public Circle(int x, int y, int w, int h, boolean fill) {
		
		super(x,y,w,h, fill);
	}

	
	public void draw(Graphics g) {
		if(!getFill()) {
		g.drawOval(getX() - getWidth() / 2, getY() - getHeight() / 2 , getWidth(), getHeight());
		
	}
		else {
		g.fillOval(getX() - getWidth() / 2, getY() - getHeight() / 2 , getWidth(), getHeight());
		
	}
}
	
}
