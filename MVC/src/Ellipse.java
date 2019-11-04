import java.awt.Graphics;

public class Ellipse extends Shape{

	public Ellipse(int x, int y, int width, int height, boolean fill) {
		super(x, y, width, height, fill);
		
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
